package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

	public OrderVO() {

	}

	public OrderVO(int orderNo, int userNo, int classCode, int pointUse, int payment, String paymentMethod,
			Timestamp paymentDate, Timestamp limitDate, int orderProcess) {
		super();
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.classCode = classCode;
		this.pointUse = pointUse;
		this.payment = payment;
		this.paymentMethod = paymentMethod;
		this.paymentDate = paymentDate;
		this.limitDate = limitDate;
		this.orderProcess = orderProcess;
	}

}
