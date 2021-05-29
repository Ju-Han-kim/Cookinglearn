package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

public class UserVO {

	private int userNo;
	private String userId;
	private String userPassword;
	private String nickname;
	private boolean gender;
	private Timestamp regDate;
	private int adminLevel;
	private boolean deleteAccount;
	private Timestamp deleteDay;

	public UserVO() {
		this.deleteAccount = false;
	}

	public UserVO(int userNo, String userId, String userPassword, String nickname, boolean gender, Timestamp regDate,
			int adminLevel, boolean deleteAccount, Timestamp deleteDay) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPassword = userPassword;
		this.nickname = nickname;
		this.gender = gender;
		this.regDate = regDate;
		this.adminLevel = adminLevel;
		this.deleteAccount = deleteAccount;
		this.deleteDay = deleteDay;
	}

	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", userPassword=" + userPassword + ", nickname="
				+ nickname + ", gender=" + gender + ", regDate=" + regDate + ", adminLevel=" + adminLevel
				+ ", deleteAccount=" + deleteAccount + ", deleteDay=" + deleteDay + "]";
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}

	public boolean isDeleteAccount() {
		return deleteAccount;
	}

	public void setDeleteAccount(boolean deleteAccount) {
		this.deleteAccount = deleteAccount;
	}

	public Timestamp getDeleteDay() {
		return deleteDay;
	}

	public void setDeleteDay(Timestamp deleteDay) {
		this.deleteDay = deleteDay;
	}
	
}
