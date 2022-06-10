<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
	function validateForm(form){
		if(!form.userid.value){
			alert("아이디를 입력하세요.")
			form.userid.focus();
			return faluse;
		}
		if(!form.userpw.value){
			alert("비밀번호를 입력하세요.")
			form.userpw.focus();
			return faluse;
		}
		if(!form.username.value){
			alert("이름을 입력하세요.")
			form.username.focus();
			return faluse;
		}
		if(!form.useremail.value){
			alert("이메일을 입력하세요.")
			form.useremail.focus();
			return faluse;
		}
	}
</script>
<title>회원가입</title>
</head>
<body>
<!-- Header -->
<%@ include file="../Solo/Header.jsp" %>

<!-- 로그인 폼 -->

<div class="loginbox">
	<h2>회원가입</h2>
	<form name="createAccountFrm" method="post"
			action="createAccountProcess.jsp" onsubmit = "return validateForm(this);">
			<label>아이디</lable>
			<input type="text" name="userid" placeholder="아이디를 입력하세요.">
			<label>비밀번호</label>
			<input type="password" name="userpw" placeholder="비밀번호를 입력하세요.">
			<label>이름</label>
			<input type="text" name="username" placeholder="이름을 입력하세요.">
			<label>email</label>
			<input type="text" name="useremail" placeholder="이메일을 입력하세요.">
			<ul>
				<li><a href="#">아이디/비밀번호 찾기</a>
			</ul>
			<button type="submit">회원가입</button>
	</form>
</div>

<!-- Footer -->
<%@ include file="../Solo/Footer.jsp" %>

</body>
</html>