package com.kang.nov293.member;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 유지보수에 용이

// 연/월/일 의 형태로 시간을 표현

// 연-월-일 시:분:초


// servlet-context.xml에 등록한 효과
@Service
public class MemberDAO {

	@Autowired
	private SimpleDateFormat sdf;
	
	public void test() {
		Date now = new Date();
		System.out.println(sdf.format(now));
		
	}
}






