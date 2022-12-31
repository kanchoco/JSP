package vo;

public class UserVO {
	private int userNumber;
	private String userId;
	private String userPassword;
	private String userName;
	private int userAge;
	private String userPhonenumber;
	private char userStatus;
	private String userBirth;
	
	public UserVO() {;}

	
	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserAge() {
		return userAge;
	}


	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}


	public String getUserPhonenumber() {
		return userPhonenumber;
	}


	public void setUserPhonenumber(String userPhonenumber) {
		this.userPhonenumber = userPhonenumber;
	}


	public char getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(char userStatus) {
		this.userStatus = userStatus;
	}


	public String getUserBirth() {
		return userBirth;
	}


	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}


	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "UserVO [userNumber=" + userNumber + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", userName=" + userName + ", userAge=" + userAge + ", userPhonenumber=" + userPhonenumber
				+ ", userStatus=" + userStatus + ", userBirth=" + userBirth + "]";
	}
	

	
}
