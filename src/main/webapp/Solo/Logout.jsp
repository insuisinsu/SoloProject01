<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%

//��� 1 : ȸ���������� �Ӽ� ����
// session.removeAttribute("userid");
// session.removeAttribute("username");

//��� 2 : ��� �Ӽ� �Ѳ����� ����		<- ���� �̰ɷ� ��
session.invalidate();

// �Ӽ� ���� �� ������ �̵�
response.sendRedirect("Login.jsp");

%>