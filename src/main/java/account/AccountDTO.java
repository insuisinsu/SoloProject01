package account;

public class AccountDTO {
	private String idx;
	private String userId;
	private String userPw;
	private String userName;
	
	public AccountDTO() {
		System.out.println("AccountDTO 가 생성되었습니다.");
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String userEmail;
	private java.sql.Date userRegidate;
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public java.sql.Date getUserRegidate() {
		return userRegidate;
	}
	public void setUserRegidate(java.sql.Date userRegidate) {
		this.userRegidate = userRegidate;
	}
	
	
	
}
	
