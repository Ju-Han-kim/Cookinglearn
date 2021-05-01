package kr.co.cookinglearn.model;

import java.sql.Timestamp;

public class OpinionVO {
	
	private int opinionNo;
	private String content;
	private Timestamp regDate;
	
	public int getOpinionNo() {
		return opinionNo;
	}
	public void setOpinionNo(int opinionNo) {
		this.opinionNo = opinionNo;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
