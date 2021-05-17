package kr.co.cookinglearn.admin.common.page;

public class PageVO {
	
	private int currentPage;
	private int messagePerPage;
	
	public PageVO() {
		this.currentPage = 1;
		this.messagePerPage = 10;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMessagePerPage() {
		return messagePerPage;
	}

	public void setMessagePerPage(int messagePerPage) {
		if(messagePerPage != 0) {
			this.messagePerPage = messagePerPage;
		}
	}
	
}
