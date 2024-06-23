package com.kang.nov281mb;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//			 DB 서버 연결			SQL						SQL명령문
//Java			JDBC			.java					.java
//JSP		ConnectionPool		META-INF/context.xml	.java(DAO)
//Spring	Mybatis				asdf.xml				fdsa.xml

// Mybatis(ver3.x : MyBatis, ver2.x : iBatis)
// DB ORM(Object Relationship Mapping) framwork : DB데이터 POJO를 통해 자동매핑

// mybatis.jar
// ojdbc.jar

public class ConnectionMain {
	public static void main(String[] args) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs= null;
		//	con + pstmt + rs = sqlsession
		SqlSession ss = null;
		try {
			InputStream is = Resources.getResourceAsStream("asdf.xml");
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory ssf = ssfb.build(is);
			ss = ssf.openSession();
			System.out.println("성공");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
