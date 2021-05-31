package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

public class ClassVO {

	private int classCode;
	private boolean classType;
	private String classCategory;
	private String thumbnailImg;
	private String className;
	private String classContent;
	private int runTime;
	private Timestamp startDate;
	private String contentImg;
	private String classUrl;
	private int price;
	private int maxStudent;
	
	public ClassVO() {

	}

	public ClassVO(int classCode, boolean classType, String classCategory, String thumbnailImg, String className,
			String classContent, int runTime, Timestamp startDate, String contentImg, String classUrl, int price,
			int maxStudent) {
		super();
		this.classCode = classCode;
		this.classType = classType;
		this.classCategory = classCategory;
		this.thumbnailImg = thumbnailImg;
		this.className = className;
		this.classContent = classContent;
		this.runTime = runTime;
		this.startDate = startDate;
		this.contentImg = contentImg;
		this.classUrl = classUrl;
		this.price = price;
		this.maxStudent = maxStudent;
	}

	@Override
	public String toString() {
		return "ClassVO [classCode=" + classCode + ", classType=" + classType + ", classCategory=" + classCategory
				+ ", thumbnailImg=" + thumbnailImg + ", className=" + className + ", classContent=" + classContent
				+ ", runTime=" + runTime + ", startDate=" + startDate + ", contentImg=" + contentImg + ", classUrl="
				+ classUrl + ", price=" + price + ", maxStudent=" + maxStudent + "]";
	}

	public int getClassCode() {
		return classCode;
	}

	public void setClassCode(int classCode) {
		this.classCode = classCode;
	}

	public boolean isClassType() {
		return classType;
	}

	public void setClassType(boolean classType) {
		this.classType = classType;
	}

	public String getClassCategory() {
		return classCategory;
	}

	public void setClassCategory(String classCategory) {
		this.classCategory = classCategory;
	}

	public String getThumbnailImg() {
		return thumbnailImg;
	}

	public void setThumbnailImg(String thumbnailImg) {
		this.thumbnailImg = thumbnailImg;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassContent() {
		return classContent;
	}

	public void setClassContent(String classContent) {
		this.classContent = classContent;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getContentImg() {
		return contentImg;
	}

	public void setContentImg(String contentImg) {
		this.contentImg = contentImg;
	}

	public String getClassUrl() {
		return classUrl;
	}

	public void setClassUrl(String classUrl) {
		this.classUrl = classUrl;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMaxStudent() {
		return maxStudent;
	}

	public void setMaxStudent(int maxStudent) {
		this.maxStudent = maxStudent;
	}
	
}
