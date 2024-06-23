package com.kang.nov301.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// SqlSessionTemplate
//		SqlSession의 하위클래스
//		(public class SqlsessionTemplate implements Sqlsession)의 구조
//		-> SqlSession의 기능은 다 들어있고, 뭔가 더 추가됨
//		자동연결/ 자동해제
//		자동 commit


@Service
public class StudentDAO {
	
	@Autowired
	private SqlSession ss; // setvlet-context.xml의 맨 마지막에 bean으로 담겨있음
	
	public void regStudent(Student s, HttpServletRequest req) {
		try {
			
			// 연결 - 자동(SqlsessionTemplate이 자동으로 해줌) : connect,close 필요 X
			
			// 값 받아오기 & 객체로 만들기 - Spring이 해결을 자동으로 해줌
			
//			System.out.println(s.getS_name());
//			System.out.println(s.getS_nickname());
			
			//SQL 수행 - MyBatis활용
			//		interface를 가져온다
			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			// interface에 있는 abstract method(추상메소드)호출
			// -자동-> 연결이 되어있는 mapper.xml의 해당 부분이 실행
			if (sm.regStudent(s) == 1) {
				req.setAttribute("r", "학생등록성공");
//				ss.commit(); //->commit 자동
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "학생등록실패");
		}
	}
	
	public void getAllStudent(HttpServletRequest req) {
	try {
		
//		List<Student> students = ss.getMapper(StudentMapper.class).getAllStudent();
//		req.setAttribute("students", students);
		req.setAttribute("students", ss.getMapper(StudentMapper.class).getAllStudent());
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
}
