package kr.co.cookinglearn.admin.model.process;

public class DashBoardTodayVO {

	private int onComplete;
	private int offComplete;
	private int todayOffClass;
	private int tomorrowOffClass;
	private int WaitForCompletion;
	private int returnOrder;
	private int newUser;
	private int qnaCount;

	public int getOnComplete() {
		return onComplete;
	}

	public void setOnComplete(int onComplete) {
		this.onComplete = onComplete;
	}

	public int getOffComplete() {
		return offComplete;
	}

	public void setOffComplete(int offComplete) {
		this.offComplete = offComplete;
	}

	public int getTodayOffClass() {
		return todayOffClass;
	}

	public void setTodayOffClass(int todayOffClass) {
		this.todayOffClass = todayOffClass;
	}

	public int getTomorrowOffClass() {
		return tomorrowOffClass;
	}

	public void setTomorrowOffClass(int tomorrowOffClass) {
		this.tomorrowOffClass = tomorrowOffClass;
	}

	public int getWaitForCompletion() {
		return WaitForCompletion;
	}

	public void setWaitForCompletion(int waitForCompletion) {
		WaitForCompletion = waitForCompletion;
	}

	public int getReturnOrder() {
		return returnOrder;
	}

	public void setReturnOrder(int returnOrder) {
		this.returnOrder = returnOrder;
	}

	public int getNewUser() {
		return newUser;
	}

	public void setNewUser(int newUser) {
		this.newUser = newUser;
	}

	public int getQnaCount() {
		return qnaCount;
	}

	public void setQnaCount(int qnaCount) {
		this.qnaCount = qnaCount;
	}

	@Override
	public String toString() {
		return "DashBoardTodayVO [onComplete=" + onComplete + ", offComplete=" + offComplete + ", todayOffClass="
				+ todayOffClass + ", tomorrowOffClass=" + tomorrowOffClass + ", WaitForCompletion=" + WaitForCompletion
				+ ", returnOrder=" + returnOrder + ", newUser=" + newUser + ", qnaCount=" + qnaCount + "]";
	}

}
