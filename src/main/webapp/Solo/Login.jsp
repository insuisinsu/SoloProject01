<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.CookieManager" %>
<%
String loginId = CookieManager.readCookie(request, "loginID");
String cookieCheck="";
if(!loginId.equals("")){
	cookieCheck="checked";
}
%>
<!DOCTYPE html>
<html>
<head>
	<script>
function validateForm(form){
	if(!form.userid.value){
		alert("아이디를 입력하세요.");
		return false;
	}
	if(!form.userpw.value){
		alert("비밀번호를 입력하세요.");
		return false;
	}
}
</script>
<title>로그인</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>



<!-- Header -->
<%@ include file="../Solo/Header.jsp" %>

<!-- 로그인 상태 확인 -->



<!-- 로그인 폼 -->

<div class="loginbox">
	<h2>로그인</h2>
	<form action="LoginProcess.jsp" method="post" name="loginFrm"
		onsubmit="return validateForm(this);">
		<fieldset>
			아이디 저장하기 
			<input type="checkbox" class="check" name="save_check" value="Y" <%= loginId %> />
			<label for="userid">아이디</lable>
			<input type="text" name="userid" placeholder="아이디를 입력하세요.">
			<label for="userpw">비밀번호</label>
			<input type="password" name="userpw" placeholder="비밀번호를 입력하세요.">
			<ul>
				<li><a href="#">아이디/비밀번호 찾기</a>
				<li><a href="../Solo/CreateAccount.jsp">회원가입</a>
			</ul>
			<button type="submit">로그인</button>
		</fieldset>
	</form>
</div>

<!-- Footer -->
<%@ include file="../Solo/Footer.jsp" %>

</body>
</html>