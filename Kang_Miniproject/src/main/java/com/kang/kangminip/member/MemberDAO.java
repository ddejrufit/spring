package com.kang.kangminip.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	
	public Members memberIdCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMemberById(m));
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	public void divideAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getK_addr();
		String[] addr2 = addr.split("!");
		req.setAttribute("addr", addr2);
	}
	
	public void bye(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");

			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("r", "탈퇴 성공");

				String dm_photo = m.getK_photo();
				dm_photo = URLDecoder.decode(dm_photo, "utf-8"); // ㅋ ㅋ.png

				String path = req.getSession().getServletContext().getRealPath("resources/img");

				new File(path + "/" + dm_photo).delete();

			} else {
				req.setAttribute("r", "탈퇴 실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "탈퇴 실패");
		}
	}
	
	public void join(Member m, HttpServletRequest req) {
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/img");

			MultipartRequest mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			m.setK_id(mr.getParameter("k_id"));
			m.setK_pw(mr.getParameter("k_pw"));
			m.setK_name(mr.getParameter("k_name"));
			m.setK_role(mr.getParameter("k_role"));

			String k_addr1 = mr.getParameter("k_addr1"); // 12312
			String k_addr2 = mr.getParameter("k_addr2"); // 서울시 서초구 서초대로
			String k_addr3 = mr.getParameter("k_addr3"); // 서초@ 101/201
			String k_addr = k_addr2 + "!" + k_addr3 + "!" + k_addr1; // 서울시 서초구 서초대로!서초@ 101/201!12312
			m.setK_addr(k_addr);

			String k_photo = mr.getFilesystemName("k_photo"); // ㅋ ㅋ.png
			String k_photo_kor = URLEncoder.encode(k_photo, "utf-8").replace("+", " "); // %3A 3A.png
			m.setK_photo(k_photo_kor);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("r", "가입성공");
			}
		} catch (Exception e) {
			req.setAttribute("r", "가입실패");
		}
	}
	
	public void login(Member inputM, HttpServletRequest req) {
		try {
			List<Member> dbms = ss.getMapper(MemberMapper.class).getMemberById(inputM);
			if (dbms.size() != 0) {
				Member dbM = dbms.get(0); // list에 있는 m_id
				if (dbM.getK_pw().equals(inputM.getK_pw())) {
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(10 * 60);
					req.setAttribute("r", "로그인성공");
				} else {
					req.setAttribute("r", "로그인실패(PW오류)");
				}
			} else {
				req.setAttribute("r", "로그인실패(미가입ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인실패(DB서버문제)");
		}
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
	
	// 파일 필수 - x
		// 기존 사진 그냥 쓸거면 선택 안하기
		// 사진을 바꿀거면 선택 하기
		public void update(Member m, HttpServletRequest req) {
			// 사진 파일은 최대 10MB
			// 수정시도 : 파일을 10MB넘게 -> 무조건 실패
			String path = req.getSession().getServletContext().getRealPath("resources/img");
			MultipartRequest mr = null;
			try {
				mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			} catch (Exception e) {
				req.setAttribute("r", "수정실패(파일용량초과)");
				return;
			}

			// 현재 로그인 된 회원 정보(수정되기 전)
			Member lm = (Member) req.getSession().getAttribute("loginMember");

			// 기존 사진 파일명
			String oldFile = lm.getK_photo(); // %2A.png

			// 새 파일명
			String newFile = mr.getFilesystemName("k_photo"); // ㅎ.png
			try {
				String dm_id = mr.getParameter("k_id");
				String dm_pw = mr.getParameter("k_pw");
				String dm_name = mr.getParameter("k_name");
				String dm_addr1 = mr.getParameter("k_addr1");
				String dm_addr2 = mr.getParameter("k_addr2");
				String dm_addr3 = mr.getParameter("k_addr3");

				if (newFile == null) { // 사진은 수정 안하는
					newFile = oldFile;
				} else { // 사진 수정
					newFile = URLEncoder.encode(newFile, "utf-8");
					newFile = newFile.replace("+", " ");
				}
				m.setK_id(dm_id);
				m.setK_pw(dm_pw);
				m.setK_name(dm_name);
				m.setK_addr(dm_addr2 + "!" + dm_addr3 + "!" + dm_addr1);
				m.setK_photo(newFile);

				// DB수정
				if (ss.getMapper(MemberMapper.class).update(m) == 1) {
					req.setAttribute("r", "수정성공");

					// 사이트에 반영
					req.getSession().setAttribute("loginMember", m);
					loginCheck(req);

					// 프사 바꾸는 상황 : 옛날 프사 지우기
					if (!oldFile.equals(newFile)) {
						oldFile = URLDecoder.decode(oldFile, "utf-8");
						new File(path + "/" + oldFile).delete();
					}
				} else {
					req.setAttribute("r", "수정실패");

					// 프사 바꾸는 상황 : 새 프사 지우기
					if (!oldFile.equals(newFile)) {
						newFile = URLDecoder.decode(newFile, "utf-8");
						new File(path + "/" + newFile).delete();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("r", "수정실패");

				// 프사 바꾸는 상황 : 새 프사 지우기
				if (!oldFile.equals(newFile)) {
					try {
						newFile = URLDecoder.decode(newFile, "utf-8");
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					new File(path + "/" + newFile).delete();
				}
			}

		}
	
}
