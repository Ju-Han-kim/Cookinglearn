package kr.co.cookinglearn.order.model;

import java.sql.Timestamp;

public class OrderVO {

	private int orderNo;
	private int userNo;
	private int classCode;
	private int pointUse;
	private int payment;
	private String paymentMethod;
	private Timestamp paymentDate;
	private Timestamp limitDate;
	private int orderProcess;
	private int payNo;
	
	
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public int getClassCode() {
		return classCode;
	}
	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}
	public int getPointUse() {
		return pointUse;
	}
	public void setPointUse(int pointUse) {
		this.pointUse = pointUse;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Timestamp getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(Timestamp limitDate) {
		this.limitDate = limitDate;
	}
	public int getOrderProcess() {
		return orderProcess;
	}
	public void setOrderProcess(int orderProcess) {
		this.orderProcess = orderProcess;
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", userNo=" + userNo + ", classCode=" + classCode + ", pointUse="
				+ pointUse + ", payment=" + payment + ", paymentMethod=" + paymentMethod + ", paymentDate="
				+ paymentDate + ", limitDate=" + limitDate + ", orderProcess=" + orderProcess + ", payNo=" + payNo
				+ "]";
	}
	
	

	

}
