package com.kang.kangminip.sns;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SNSMsg {
	
	private String k_id; 
	private String k_photo; 


	private BigDecimal k_no; 
	private String k_txt; 
	private Date k_when; 
	private String k_color; 

	private List<SNSReply> k_replys; 

	public SNSMsg() {
		// TODO Auto-generated constructor stub
	}

	public SNSMsg(String k_id, String k_photo, BigDecimal k_no, String k_txt, Date k_when, String k_color,
			List<SNSReply> k_replys) {
		super();
		this.k_id = k_id;
		this.k_photo = k_photo;
		this.k_no = k_no;
		this.k_txt = k_txt;
		this.k_when = k_when;
		this.k_color = k_color;
		this.k_replys = k_replys;
	}

	public String getK_id() {
		return k_id;
	}

	public void setK_id(String k_id) {
		this.k_id = k_id;
	}

	public String getK_photo() {
		return k_photo;
	}

	public void setK_photo(String k_photo) {
		this.k_photo = k_photo;
	}

	public BigDecimal getK_no() {
		return k_no;
	}

	public void setK_no(BigDecimal k_no) {
		this.k_no = k_no;
	}

	public String getK_txt() {
		return k_txt;
	}

	public void setK_txt(String k_txt) {
		this.k_txt = k_txt;
	}

	public Date getK_when() {
		return k_when;
	}

	public void setK_when(Date k_when) {
		this.k_when = k_when;
	}

	public String getK_color() {
		return k_color;
	}

	public void setK_color(String k_color) {
		this.k_color = k_color;
	}

	public List<SNSReply> getK_replys() {
		return k_replys;
	}

	public void setK_replys(List<SNSReply> k_replys) {
		this.k_replys = k_replys;
	}

	
}
