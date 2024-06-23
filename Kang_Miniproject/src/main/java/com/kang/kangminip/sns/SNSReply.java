package com.kang.kangminip.sns;

import java.math.BigDecimal;
import java.util.Date;

public class SNSReply {
	private BigDecimal kr_no;
	private BigDecimal kr_k_no;
	private String kr_owner;
	private String kr_txt;
	private Date kr_when;

	public SNSReply() {
		// TODO Auto-generated constructor stub
	}

	public SNSReply(BigDecimal kr_no, BigDecimal kr_k_no, String kr_owner, String kr_txt, Date kr_when) {
		super();
		this.kr_no = kr_no;
		this.kr_k_no = kr_k_no;
		this.kr_owner = kr_owner;
		this.kr_txt = kr_txt;
		this.kr_when = kr_when;
	}

	public BigDecimal getKr_no() {
		return kr_no;
	}

	public void setKr_no(BigDecimal kr_no) {
		this.kr_no = kr_no;
	}

	public BigDecimal getKr_k_no() {
		return kr_k_no;
	}

	public void setKr_k_no(BigDecimal kr_k_no) {
		this.kr_k_no = kr_k_no;
	}

	public String getKr_owner() {
		return kr_owner;
	}

	public void setKr_owner(String kr_owner) {
		this.kr_owner = kr_owner;
	}

	public String getKr_txt() {
		return kr_txt;
	}

	public void setKr_txt(String kr_txt) {
		this.kr_txt = kr_txt;
	}

	public Date getKr_when() {
		return kr_when;
	}

	public void setKr_when(Date kr_when) {
		this.kr_when = kr_when;
	}

	


}
