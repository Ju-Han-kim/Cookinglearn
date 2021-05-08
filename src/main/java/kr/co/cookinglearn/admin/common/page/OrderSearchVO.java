package kr.co.cookinglearn.admin.common.page;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		this.seDate = seDate;
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

	public int[] getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(int[] orderProcess) {
		this.orderProcess = orderProcess;
	}
	
}
