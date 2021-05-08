package kr.co.cookinglearn.admin.common.page;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
			
			String defuautSeDate = sdf.format(from) + " ~ " + sdf.format(to);
			
			setSeDate(defuautSeDate);
		}
	}
	
	public void setMaxDate() {
		if(this.seDate.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date to = new Date();
			Date from = new Date(to.getTime() - 60*60*24*364*1000L);
			
			String defuautSeDate = sdf.format(from) + " ~ " + sdf.format(to);
			
			setSeDate(defuautSeDate);
		}
	}
}
