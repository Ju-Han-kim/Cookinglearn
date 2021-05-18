package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

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

	public int getPointNo() {
		return pointNo;
	}

	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public Timestamp getPointDate() {
		return pointDate;
	}

	public void setPointDate(Timestamp pointDate) {
		this.pointDate = pointDate;
	}

	public String getPointHistory() {
		return pointHistory;
	}

	public void setPointHistory(String pointHistory) {
		this.pointHistory = pointHistory;
	}

	public String getPointChange() {
		return pointChange;
	}

	public void setPointChange(String pointChange) {
		this.pointChange = pointChange;
	}

	@Override
	public String toString() {
		return "PointVO [pointNo=" + pointNo + ", userNo=" + userNo + ", pointDate=" + pointDate + ", pointHistory="
				+ pointHistory + ", pointChange=" + pointChange + "]";
	}
}
