package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}
