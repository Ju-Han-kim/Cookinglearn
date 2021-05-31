package kr.co.cookinglearn.user.model.process;

import java.sql.Timestamp;

public class MyClassVO {

	private int orderNo;
	private boolean classType;
	private int classCode;
	private Timestamp startDate;
	private String className;
	private String thumbnailImg;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public boolean isClassType() {
		return classType;
	}

	public void setClassType(boolean classType) {
		this.classType = classType;
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getThumbnailImg() {
		return thumbnailImg;
	}

	public void setThumbnailImg(String thumbnailImg) {
		this.thumbnailImg = thumbnailImg;
	}

	@Override
	public String toString() {
		return "MyClassVO [orderNo=" + orderNo + ", classType=" + classType + ", classCode=" + classCode
				+ ", startDate=" + startDate + ", className=" + className + ", thumbnailImg=" + thumbnailImg + "]";
	}

}
