package kr.co.cookinglearn.admin.model.process;

import kr.co.cookinglearn.admin.model.ReviewVO;

public class ReviewClassVO extends ReviewVO {

	private boolean classType;
	private String classCategory;
	private String className;

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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return super.toString() + "[classType=" + classType + ", classCategory=" + classCategory + ", className=" + className
				+ "]";
	}

}
