<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://kit.fontawesome.com/2d323a629b.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" type="text/css" href="/SoloProject01/Solo/css/style.css">
	<title>Insert title here</title>
</head>
<body>

<header>
    <div class="inner">
        <h1><a href="../Solo/Index.jsp">렌트카를 인수하자!</a></h1>           
        <ul id="gnb">
            <li><a href="#">차종/요금</a></li>
            <li><a href="#">이용방법</a></li>
            <li><a href="#">회사소개</a></li>
            <li><a href="#">대여소위치</a></li>
            <li><a href="../freeboard/list.do">게시판</a></li>
        </ul>

        <ul class="util">
        <% if(session.getAttribute("userid") == null) { %>
            <li><a href="../Solo/Login.jsp">Login</a></li>
            <li><a href="../Solo/CreateAccount.jsp">Create Account</a></li>
		<%	} else { %>
            <li><%= session.getAttribute("userid") %></a></li>
            <li><a href="../Solo/Logout.jsp">Logout</a></li>
		<% } %>
        </ul>
    </div>
</header>


</body>
</html>