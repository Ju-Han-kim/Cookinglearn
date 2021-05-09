package kr.co.cookinglearn.admin.common.page;

public class QnaSearchVO extends SearchVO{
	
	private boolean complete;
	
	public QnaSearchVO() {
		this.complete = false;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
