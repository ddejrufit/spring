package com.kang.kangminip.member;

public class Member {
	private String k_id;
	private String k_pw;
	private String k_name;
	private String k_addr;
	private String k_photo;
	private String k_role;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String k_id, String k_pw, String k_name, String k_addr, String k_photo, String k_role) {
		super();
		this.k_id = k_id;
		this.k_pw = k_pw;
		this.k_name = k_name;
		this.k_addr = k_addr;
		this.k_photo = k_photo;
		this.k_role = k_role;
	}
	public String getK_id() {
		return k_id;
	}
	public void setK_id(String k_id) {
		this.k_id = k_id;
	}
	public String getK_pw() {
		return k_pw;
	}
	public void setK_pw(String k_pw) {
		this.k_pw = k_pw;
	}
	public String getK_name() {
		return k_name;
	}
	public void setK_name(String k_name) {
		this.k_name = k_name;
	}
	public String getK_addr() {
		return k_addr;
	}
	public void setK_addr(String k_addr) {
		this.k_addr = k_addr;
	}
	public String getK_photo() {
		return k_photo;
	}
	public void setK_photo(String k_photo) {
		this.k_photo = k_photo;
	}
	public String getK_role() {
		return k_role;
	}
	public void setK_role(String k_role) {
		this.k_role = k_role;
	}
	
}
