<%@ page import="account.AccountDAO" %>
<%@ page import="account.AccountDTO" %>
<%@ page import="utils.JSFunction" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//폼값 받기
String userId = request.getParameter("userid");
String userPw = request.getParameter("userpw");
String userName = request.getParameter("username");
String userEmail = request.getParameter("useremail");

//폼에서 받은 값을 DTO 객체에 저장
AccountDTO dto = new AccountDTO();
dto.setUserId(userId);
dto.setUserPw(userPw);
dto.setUserName(userName);
dto.setUserEmail(userEmail);

//DAO 객체를 통해 DB에 DTO 저장
AccountDAO dao = new AccountDAO();
int result = dao.createAccount(dto);
dao.close();


if(result == 1){
	response.sendRedirect("Login.jsp");
}else{
	JSFunction.alertBack(response, "회원가입 실패");
}



%>