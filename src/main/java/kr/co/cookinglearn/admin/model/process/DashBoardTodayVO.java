package kr.co.cookinglearn.admin.model.process;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DashBoardTodayVO {

	private int onComplete;
	private int offComplete;
	private int todayOffClass;
	private int tomorrowOffClass;
	private int WaitForCompletion;
	private int onReturn;
	private int offReturn;
	private int newUser;
	private int qnaCount;

	public DashBoardTodayVO() {
		this.onComplete = 0;
		this.offComplete = 0;
		this.todayOffClass = 0;
		this.tomorrowOffClass = 0;
		this.WaitForCompletion = 0;
		this.onReturn = 0;
		this.offReturn = 0;
		this.newUser = 0;
		this.qnaCount = 0;
	}

	public String StringSeDate(String day) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date seDate = new Date();

		if (day.equals("tomorrow")) {
			seDate = new Date(seDate.getTime() + 1000L * 60 * 60 * 24);
		}
		return sdf.format(seDate) + " ~ " + sdf.format(seDate);
	}

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

	public int getOnReturn() {
		return onReturn;
	}

	public void setOnReturn(int onReturn) {
		this.onReturn = onReturn;
	}

	public int getOffReturn() {
		return offReturn;
	}

	public void setOffReturn(int offReturn) {
		this.offReturn = offReturn;
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
				+ ", onReturn=" + onReturn + ", offReturn=" + offReturn + ", newUser=" + newUser + ", qnaCount="
				+ qnaCount + "]";
	}

}
