package kr.co.cookinglearn.admin.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchVO extends PageVO{
	
	private String condition;
	private String keyword;
	
	public UserSearchVO() {
		this.condition = "";
		this.keyword = "";
	}
	
}
