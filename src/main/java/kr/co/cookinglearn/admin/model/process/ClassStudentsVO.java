package kr.co.cookinglearn.admin.model.process;

import java.sql.Timestamp;

public class ClassStudentsVO {

	private int orderNo;
	private int userNo;
	private String userId;
	private String nickname;
	private boolean gender;
	private Timestamp paymentDate;
	private int orderProcess;
	
	public String getProcess(int orderProcess) { 
		String process = "";
		
		switch (orderProcess) {
		case 0:
			process = "결제완료";
			break;
		case 1:
			process = "수강확정";
			break;
		case 2:
			process = "수강완료";
			break;
		case 3:
			process = "반품";
			break;
		}
		
		return process;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(int orderProcess) {
		this.orderProcess = orderProcess;
	}
	
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	@Override
	public String toString() {
		return "ClassStudentsVO [orderNo=" + orderNo + ", userNo=" + userNo + ", userId=" + userId + ", nickname="
				+ nickname + ", gender=" + gender + ", paymentDate=" + paymentDate + ", orderProcess=" + orderProcess
				+ "]";
	}
	
}
