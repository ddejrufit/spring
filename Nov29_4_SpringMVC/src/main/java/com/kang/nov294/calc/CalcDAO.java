package com.kang.nov294.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// 멤버변수 없으면 : static method 기반
// M/DAO에서 게시판 같은 기능 구현을 하려면 멤버변수가 생길 수 밖에 없음
//		-> static 기반 method 포기 -> 객체를 만들어서 사용해야 하는데
//		-> 새로고침 or 요청 => calculate.do로 요청할 때마다 새 CalcDAO가 생성됨
//		-> 메모리 폭발(메모리 계속 사용해서 비효율 적)
//		allCalcCount도 제대로 카운팅 안됨

// 해결방안 : CalcDAO를 singleton처리

// Spring 식의 singleton 처리방법

@Service // servlet-context.xml에 CalcDAO 객체 하나 등록해 놓은 효과
public class CalcDAO {
	private int allCalcCount;//몇번 계산했는지
	
	public void claculate(Calculate cal, HttpServletRequest req) {
		allCalcCount++;
		System.out.println(allCalcCount);
		int add = cal.getX() + cal.getY();
		req.setAttribute("r", add);
	}
}
