package kr.co.cookinglearn.admin.common.page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchVO extends PageVO{
	
	private String condition;
	private String keyword;
	
	public SearchVO() {
		this.condition = "";
		this.keyword = "";
	}
	
}
