package kr.co.cookinglearn.admin.model.process;

import java.util.Date;

public class DashBoardSalesVO {
	private Date paymentDate;
	private int onClass;
	private int onPayment;
	private int offClass;
	private int offPayment;
	private int returnClass;
	private int returnPayment;
	
	public DashBoardSalesVO() {
		setDay(4);
		this.onClass = 0;
		this.onPayment = 0;
		this.offClass = 0;
		this.offPayment = 0;
		this.returnClass = 0;
		this.returnPayment = 0;
	}
	
	public void setDay(int day) {
		long now = new Date().getTime();
		this.paymentDate = new Date(now - now%(1000*60*60*24L) - 1000L*60*60*24*day - 1000*60*60*9L);
	}
	
	public void setData(int onClass, int onPayment, int offClass, int offPayment, int returnClass,
			int returnPayment) {
		this.onClass = onClass;
		this.onPayment = onPayment;
		this.offClass = offClass;
		this.offPayment = offPayment;
		this.returnClass = returnClass;
		this.returnPayment = returnPayment;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getOnClass() {
		return onClass;
	}

	public void setOnClass(int onClass) {
		this.onClass = onClass;
	}

	public int getOnPayment() {
		return onPayment;
	}

	public void setOnPayment(int onPayment) {
		this.onPayment = onPayment;
	}

	public int getOffClass() {
		return offClass;
	}

	public void setOffClass(int offClass) {
		this.offClass = offClass;
	}

	public int getOffPayment() {
		return offPayment;
	}

	public void setOffPayment(int offPayment) {
		this.offPayment = offPayment;
	}

	public int getReturnClass() {
		return returnClass;
	}

	public void setReturnClass(int returnClass) {
		this.returnClass = returnClass;
	}

	public int getReturnPayment() {
		return returnPayment;
	}

	public void setReturnPayment(int returnPayment) {
		this.returnPayment = returnPayment;
	}

}
