package account;

import common.JDBConnect;

public class AccountDAO extends JDBConnect {

		//명시한 데이터로의 연결이 완료된 MemberDAO 객체를 생성
	
	public AccountDAO() {
		super();
	}
	public AccountDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	//명시한 userid/userpw 와 일치하는 회원 정보를 반환
	public AccountDTO getAccountDTO(String userid, String userpw) {
		AccountDTO dto = new AccountDTO();
		String query = "SELECT * FROM useraccount WHERE userid=? AND userpw=?";
		
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, userid);
			psmt.setString(2, userpw);
			rs = psmt.executeQuery();
			
			//결과처리
			if(rs.next()) {
				dto.setUserId(rs.getString("userid"));
				dto.setUserPw(rs.getString("userpw"));
				dto.setUserName(rs.getString("username"));
				dto.setUserRegidate(rs.getDate("userregidate"));
			}
			
		}catch(Exception e) {
			System.out.println("아이디/패스워드 확인 중 예외발생");
			e.printStackTrace();
		}
		return dto;
	}
	
	
	
	
	//CreateAccount
	public int createAccount(AccountDTO dto) {
		int result = 0;
		System.out.println("createAccount 호출");
		
		try {
			String query = "INSERT INTO useraccount ( "
						+ " idx, userid, userpw, username, useremail )"
						+ " VALUES ( seq_user_num.nextval, ? , ? , ? , ? )";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getUserId());
			psmt.setString(2, dto.getUserPw());
			psmt.setString(3, dto.getUserName());
			psmt.setString(4, dto.getUserEmail());
			
			result = psmt.executeUpdate();
			
			System.out.println(query);
		}catch(Exception e) {
			System.out.println("계정 생성 중 예외 발생");
			e.printStackTrace();
		}
		if(result == 1) {
			System.out.println("createAccount 실행됨");
		}else {
			System.out.println("createAccount error");
		}
		return result;
	}
}
