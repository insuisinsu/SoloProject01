<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<table border="1" width="90%">
	<tr>
		<td align="center">
		<!-- 로그인 여부에 따른 메뉴 변화 -->
		<% if(session.getAttribute("UserId") == null) { %>
			<a href="../Login.jsp">로그인</a>
		<%	} else { %>
			<a href="../Solo/Logout.jsp">로그아웃</a>
		<%  } %>
		&nbsp;&nbsp;&nbsp;
		<a href="../08Board/List.jsp"> 게시판(페이징x)</a>
		&nbsp;&nbsp;&nbsp;
		<a href="../09PagingBoard/List.jsp"> 게시판(페이징O)</a>
		</td>
	</tr>
</table>