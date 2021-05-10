package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

public class QnaVO {

	private int qnaNo;
	private int userNo;
	private String title;
	private String writer;
	private String qnaContent;
	private Timestamp regDate;
	private String answer;
	private Timestamp answerDate;
	

	public QnaVO() {

	}
	
	public QnaVO(int qnaNo, int userNo, String title, String writer, String qnaContent, Timestamp regDate,
			String answer, Timestamp answerDate) {
		super();
		this.qnaNo = qnaNo;
		this.userNo = userNo;
		this.title = title;
		this.writer = writer;
		this.qnaContent = qnaContent;
		this.regDate = regDate;
		this.answer = answer;
		this.answerDate = answerDate;
	}

	public int getQnaNo() {
		return qnaNo;
	}

	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Timestamp getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(Timestamp answerDate) {
		this.answerDate = answerDate;
	}

	@Override
	public String toString() {
		return "QnaVO [qnaNo=" + qnaNo + ", userNo=" + userNo + ", title=" + title + ", writer=" + writer
				+ ", qnaContent=" + qnaContent + ", regDate=" + regDate + ", answer=" + answer + ", answerDate="
				+ answerDate + "]";
	}

}
