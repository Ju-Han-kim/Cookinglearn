package kr.co.cookinglearn.admin.common.page;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearchVO extends SearchVO{
	
	private boolean classType;
	private String seDate;
	private Timestamp startDate;
	private Timestamp endDate;
	private int[] orderProcess;
	
	public OrderSearchVO() {
		this.classType = false;
		this.startDate = null;
		this.endDate = null;
		this.seDate = "";
		this.orderProcess = null;
		
		setDate();
	}
	
	private void setDate() {
		if(this.seDate.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date now = new Date();
			
			String defualtSeDate = sdf.format(now) + " ~ " + sdf.format(now);
			
			setSeDate(defualtSeDate);
		}
	}
	
}
