package com.kang.nov294.calc;

// 필수)요청 파라미터명 = DB필드명 = Javabean멤버변수명
// 자동으로 요청파라미터 값을 Javabean객체에 담아

public class Calculate {
	private String n;
	private int x;
	private int y;
	public Calculate() {
		// TODO Auto-generated constructor stub
	}
	public Calculate(String n, int x, int y) {
		super();
		this.n = n;
		this.x = x;
		this.y = y;
	}
	public String getN() {
		return n;
	}
	public void setN(String n) {
		this.n = n;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
