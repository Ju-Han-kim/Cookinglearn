package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointVO {

	private int pointNo;
	private int userNo;
	private Timestamp pointDate;
	private String pointHistory;
	private String pointChange;

	public PointVO() {

	}

	public PointVO(int pointNo, int userNo, Timestamp pointDate, String pointHistory, String pointChange) {
		super();
		this.pointNo = pointNo;
		this.userNo = userNo;
		this.pointDate = pointDate;
		this.pointHistory = pointHistory;
		this.pointChange = pointChange;
	}

}
