<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<table border="1" width="90%">
	<tr>
		<td align="center">
		<!-- �α��� ���ο� ���� �޴� ��ȭ -->
		<% if(session.getAttribute("UserId") == null) { %>
			<a href="../Login.jsp">�α���</a>
		<%	} else { %>
			<a href="../Solo/Logout.jsp">�α׾ƿ�</a>
		<%  } %>
		&nbsp;&nbsp;&nbsp;
		<a href="../08Board/List.jsp"> �Խ���(����¡x)</a>
		&nbsp;&nbsp;&nbsp;
		<a href="../09PagingBoard/List.jsp"> �Խ���(����¡O)</a>
		</td>
	</tr>
</table>