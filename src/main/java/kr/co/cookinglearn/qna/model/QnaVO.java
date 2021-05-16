package kr.co.cookinglearn.qna.model;

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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((answerDate == null) ? 0 : answerDate.hashCode());
		result = prime * result + ((qnaContent == null) ? 0 : qnaContent.hashCode());
		result = prime * result + qnaNo;
		result = prime * result + ((regDate == null) ? 0 : regDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + userNo;
		result = prime * result + ((writer == null) ? 0 : writer.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QnaVO other = (QnaVO) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (answerDate == null) {
			if (other.answerDate != null)
				return false;
		} else if (!answerDate.equals(other.answerDate))
			return false;
		if (qnaContent == null) {
			if (other.qnaContent != null)
				return false;
		} else if (!qnaContent.equals(other.qnaContent))
			return false;
		if (qnaNo != other.qnaNo)
			return false;
		if (regDate == null) {
			if (other.regDate != null)
				return false;
		} else if (!regDate.equals(other.regDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userNo != other.userNo)
			return false;
		if (writer == null) {
			if (other.writer != null)
				return false;
		} else if (!writer.equals(other.writer))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "QnaVO [qnaNo=" + qnaNo + ", userNo=" + userNo + ", title=" + title + ", writer=" + writer
				+ ", qnaContent=" + qnaContent + ", regDate=" + regDate + ", answer=" + answer + ", answerDate="
				+ answerDate + "]";
	}
	
}
