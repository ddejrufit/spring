package com.kang.nov281mb;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class InsertMain {
	public static void main(String[] args) {
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("asdf.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			
			//값 넣기
			Scanner k = new Scanner(System.in);
			System.out.print("과일 이름 : ");
			String n = k.next();
			System.out.print("가격 : ");
			BigDecimal p = k.nextBigDecimal();
			
			// 입력받은 값들은 Javabean으로
			Fruit f = new Fruit(n,p);
		
			if (ss.insert("fdsa.regFruit", f) ==1) {
				System.out.println("good~");
				ss.commit(); // 실질적으로 db에 적용
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
