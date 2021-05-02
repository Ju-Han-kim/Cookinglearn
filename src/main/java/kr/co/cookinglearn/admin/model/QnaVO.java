package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QnaVO {

	private int qnaNo;
	private int userNo;
	private String title;
	private String writer;
	private String qnaContent;
	private Timestamp regDate;
	private String answer;

	public QnaVO() {

	}

	public QnaVO(int qnaNo, int userNo, String title, String writer, String qnaContent, Timestamp regDate,
			String answer) {
		super();
		this.qnaNo = qnaNo;
		this.userNo = userNo;
		this.title = title;
		this.writer = writer;
		this.qnaContent = qnaContent;
		this.regDate = regDate;
		this.answer = answer;
	}

}
