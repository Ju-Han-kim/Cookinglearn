package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

}
