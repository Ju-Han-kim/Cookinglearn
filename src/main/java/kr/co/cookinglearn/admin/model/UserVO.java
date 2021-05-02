package kr.co.cookinglearn.admin.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

}
