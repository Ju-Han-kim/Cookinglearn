package kr.co.cookinglearn.admin.model;

public class OrderViewVO extends OrderVO {

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

	@Override
	public String toString() {
		return super.toString() + "[className=" + className + ", userId=" + userId + ", nickname=" + nickname + "]";
	}

}
