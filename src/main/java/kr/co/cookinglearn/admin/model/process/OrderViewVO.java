package kr.co.cookinglearn.admin.model.process;

import kr.co.cookinglearn.admin.model.OrderVO;

public class OrderViewVO extends OrderVO {

	private boolean classType;
	private String classCategory;
	
	private String className;
	private String userId;
	private String nickname;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public boolean isClassType() {
		return classType;
	}

	public void setClassType(boolean classType) {
		this.classType = classType;
	}

	public String getClassCategory() {
		return classCategory;
	}

	public void setClassCategory(String classCategory) {
		this.classCategory = classCategory;
	}

	@Override
	public String toString() {
		return super.toString()+"[classType=" + classType + ", classCategory=" + classCategory + ", className=" + className
				+ ", userId=" + userId + ", nickname=" + nickname + "]";
	}

}
