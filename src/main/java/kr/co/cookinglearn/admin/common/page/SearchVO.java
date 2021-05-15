package kr.co.cookinglearn.admin.common.page;

public class SearchVO extends PageVO{
	
	private String condition;
	private String keyword;
	
	public SearchVO() {
		this.condition = "";
		this.keyword = "";
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
