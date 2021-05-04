package kr.co.cookinglearn.admin.common.page;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassSearchVO extends SearchVO {
	
	private boolean classType;
	private Timestamp startDate;
	private Timestamp endDate;
	private String classCategory;
	
	public ClassSearchVO() {
		this.classType = false;
		this.startDate = null;
		this.endDate = null;
		this.classCategory = "all";
	}
	
}
