package kr.co.cookinglearn.admin.model.process;

import java.util.Date;

public class DashBoardProcessVO {

	private boolean classType;
	private int orderProcess;
	private int count;
	private Date paymentDate;
	private int payment;

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public boolean isClassType() {
		return classType;
	}

	public void setClassType(boolean classType) {
		this.classType = classType;
	}

	public int getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(int orderProcess) {
		this.orderProcess = orderProcess;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DashBoardProcessVO [classType=" + classType + ", orderProcess=" + orderProcess + ", count=" + count
				+ ", paymentDate=" + paymentDate + ", payment=" + payment + "]";
	}

}
