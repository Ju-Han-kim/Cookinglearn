package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

public class ReviewVO {

	private int reviewNo;
	private int userNo;
	private int classCode;
	private String writer;
	private String reviewComment;
	private int reviewStar;
	private Timestamp regDate;
	private String img;

	public ReviewVO() {

	}

	public ReviewVO(int reviewNo, int userNo, int classCode, String writer, String reviewComment, 
			int reviewStar,	Timestamp regDate, String img) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.classCode = classCode;
		this.writer = writer;
		this.reviewComment = reviewComment;
		this.reviewStar = reviewStar;
		this.regDate = regDate;
		this.img = img;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", userNo=" + userNo + ", classCode=" + classCode + ", writer="
				+ writer + ", reviewComment=" + reviewComment + ", reviewStar=" + reviewStar + ", regDate=" + regDate
				+ ", img=" + img + "]";
	}

}
