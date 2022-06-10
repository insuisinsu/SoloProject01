<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

//방법 1 : 회원인증정보 속성 삭제
// session.removeAttribute("userid");
// session.removeAttribute("username");

//방법 2 : 모든 속성 한꺼번에 삭제		<- 보통 이걸로 씀
session.invalidate();

// 속성 삭제 후 페이지 이동
response.sendRedirect("Login.jsp");

%>