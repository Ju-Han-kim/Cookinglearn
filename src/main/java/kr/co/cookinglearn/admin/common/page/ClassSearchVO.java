package kr.co.cookinglearn.admin.common.page;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClassSearchVO extends SearchVO {
	
	private boolean classType;
	private String seDate;
	private Timestamp startDate;
	private Timestamp endDate;
	private String classCategory;
	
	private boolean complete;
	
	public ClassSearchVO() {
		this.complete = true;
		this.classType = false;
		this.startDate = null;
		this.endDate = null;
		this.seDate = "";
		this.classCategory = "all";
	}
	
	public void setMinDate() {
		if(this.seDate.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date from = new Date();
			Date to = new Date(from.getTime() + 60*60*24*364*1000L);
			
			String defualtSeDate = sdf.format(from) + " ~ " + sdf.format(to);
			
			setSeDate(defualtSeDate);
		}
	}
	
	public void setMaxDate() {
		if(this.seDate.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date to = new Date();
			Date from = new Date(to.getTime() - 60*60*24*364*1000L);
			
			String defualtSeDate = sdf.format(from) + " ~ " + sdf.format(to);
			
			setSeDate(defualtSeDate);
		}
	}

	public boolean isClassType() {
		return classType;
	}

	public void setClassType(boolean classType) {
		this.classType = classType;
	}

	public String getSeDate() {
		return seDate;
	}

	public void setSeDate(String seDate) {
		if(!seDate.equals("")) {
			this.seDate = seDate;
		}
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getClassCategory() {
		return classCategory;
	}

	public void setClassCategory(String classCategory) {
		this.classCategory = classCategory;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
}
