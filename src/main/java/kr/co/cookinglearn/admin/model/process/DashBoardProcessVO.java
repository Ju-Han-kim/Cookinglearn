package kr.co.cookinglearn.admin.model.process;

public class DashBoardProcessVO {

	private boolean classType;
	private int orderProcess;
	private int count;

	public boolean isClassType() {
		return classType;
	}

	public void setClassType(boolean classType) {
		this.classType = classType;
	}

	public int getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(int orderProcess) {
		this.orderProcess = orderProcess;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "DashBoardProcessVO [classType=" + classType + ", orderProcess=" + orderProcess + ", count=" + count
				+ "]";
	}
	
}
