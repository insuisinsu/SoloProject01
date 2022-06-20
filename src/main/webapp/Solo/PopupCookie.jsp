<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String chkVal = request.getParameter("inactiveToday"); 	//inactiveToday 의 값 얻기

if(chkVal != null && chkVal.equals("1")){
	Cookie cookie = new Cookie("PopupClose", "off");	// 쿠키 생성
	cookie.setPath(request.getContextPath());		// 쿠키의 경로 설정
	cookie.setMaxAge(60*60*24);		// 유지기간 설정
	response.addCookie(cookie);		// 응답 객체에 쿠키 추가
	out.println("쿠키 : 하루동안 열지 않음");
}

%>
