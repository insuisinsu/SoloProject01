<%@ page import="utils.JSFunction" %>

<%
if(session.getAttribute("userid") == null){
	JSFunction.alertLocation("Fail", "../Solo/Login.jsp", out);
	return;
}
%>
