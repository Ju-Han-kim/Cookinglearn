package kr.co.cookinglearn.user.model;

import java.sql.Timestamp;

public class UserVO {

	private int userNo;
	private String userId; // email
	private String userPassword;
	private String nickname;
	private int gender;
	private Timestamp regDate;
	private int adminLevel;
	private int deleteAccount;
	private Timestamp deleteDay;

	public int getUserNo() {
		return userNo;
	}

	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", userPassword=" + userPassword + ", nickname="
				+ nickname + ", gender=" + gender + ", regDate=" + regDate + ", adminLevel=" + adminLevel
				+ ", deleteAccount=" + deleteAccount + ", deleteDay=" + deleteDay + "]";
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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

	public int getDeleteAccount() {
		return deleteAccount;
	}

	public void setDeleteAccount(int deleteAccount) {
		this.deleteAccount = deleteAccount;
	}

	public Timestamp getDeleteDay() {
		return deleteDay;
	}

	public void setDeleteDay(Timestamp deleteDay) {
		this.deleteDay = deleteDay;
	}

}
