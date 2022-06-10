<%@ page import="account.AccountDTO" %>
<%@ page import="account.AccountDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그인 폼으로부터 받은 아이디와 패스워드
String userid = request.getParameter("userid");
String userpw = request.getParameter("userpw");

String oracleDriver = application.getInitParameter("OracleDriver");
String oracleURL = application.getInitParameter("OracleURL");
String oracleId = application.getInitParameter("OracleId");
String oraclePwd = application.getInitParameter("OraclePwd");

// 회원 테이블 DAO 를 통해 회원 정보 DTO 획득 및 DB 접속
AccountDAO dao = new AccountDAO(oracleDriver, oracleURL, oracleId, oraclePwd);
//사용자가 입력한 아이디와 패스워드를 인수로 getMemberDTO 를 호출함
// -> 아이디 패스워드가 일치된다면 해당 회원의 DTO 객체가 memberDTO 에 저장됨
AccountDTO accountDTO = dao.getAccountDTO(userid, userpw);
dao.close();

//로그인 성공 여부에 따른 처리
	//로그인 성공 - memberDTO 에 id 값이 있다 = 아이디 패스워드가 일치하여 회원의 객체를 가져왔다
	// 로그인 성공했으니 session 에 아이디 패스워드를 저장함
	// session 영역은 브라우저를 닫을 때 까지 모든 페이지에서 공유됨
//로그인 성공 여부에 따른 처리
if(accountDTO.getUserId() != null){
	//로그인 성공 - memberDTO 에 id 값이 있다 = 아이디 패스워드가 일치하여 회원의 객체를 가져왔다
	// 로그인 성공했으니 session 에 아이디 패스워드를 저장함
	// session 영역은 브라우저를 닫을 때 까지 모든 페이지에서 공유됨
	session.setAttribute("userid", accountDTO.getUserId());
	session.setAttribute("username", accountDTO.getUserName());
	response.sendRedirect("Index.jsp");
	out.println("로그인 성공");
}else{
	//로그인 실패
	// request 영역에 저장된 값은 포워드된 페이지까지 공유됨
	request.setAttribute("LoginErrMsg", "로그인 오류입니다.");
	request.getRequestDispatcher("Login.jsp").forward(request, response);
}
	//로그인 실패
	// request 영역에 저장된 값은 포워드된 페이지까지 공유됨

%>