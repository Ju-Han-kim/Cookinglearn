package kr.co.cookinglearn.admin.common.page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageVO {
	
	private int currentPage;
	private int messagePerPage;
	
	public PageVO() {
		this.currentPage = 1;
		this.messagePerPage = 10;
	}
	
}
