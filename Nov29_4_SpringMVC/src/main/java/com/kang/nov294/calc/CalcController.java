package com.kang.nov294.calc;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // <- 컨트롤러 anntotation 붙이지 않으면 controller역할 못함
public class CalcController {

	
	// 1. JSP Model 2 스타일 -> 생각보다 Spring에서 자주 사용됨 (파일업로드, 날짜, ...)
	//	요청 파라미터 : String -> 형변환해서 사용
	/*@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
	public String calcXY(HttpServletRequest req) {
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		System.out.println(x + y);
		
		return "index";
	}*/
	
	// GET방식 요청 파라미터 한글처리
	//			: Tomcat 설정(server.xml)
	//		Servers -> tomcat ~ -> server.xml
	//		63번 줄: URIEncoding="UTF-8"
	//			ㄴ자동으로 인코딩할 때 어떤 방식을 쓸지
	
	// POST방식 요청 파라미터(서버내부에)  한글처리
	//			: 프로젝트 설정
	//		JSP	: 파라미터값 읽기 전에 req.setCharacterEncoding("utf-8");
	//		Spring: web.xml에 설정
	
	// 2. Spring 스타일      활용가치는 낮음
	
	/*@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
	public String calcXY(
			@RequestParam(value="n") String n,
			@RequestParam(value="x") int x,
			@RequestParam(value="y") int y) {
		System.out.println(n);
		System.out.println(x);
		System.out.println(y);
		
		return "index";
	}*/


@Autowired
private CalcDAO cDAO;

// 3.Spring 스타일2
	@RequestMapping(value = "/calculate.do", method = RequestMethod.POST)
public String calcXY(Calculate cal, HttpServletRequest req) {
					// ㄴdao에서 가져올 method의 parameter를 함께 넣어줌
		cDAO.claculate(cal, req);
		
	
	return "index";
}
}
