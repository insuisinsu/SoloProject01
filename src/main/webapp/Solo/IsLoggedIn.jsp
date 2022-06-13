<%@ page import="utils.JSFunction" %>

<%
if(session.getAttribute("userid") == null){
	JSFunction.alertLocation(response, "Fail", "../Solo/Login.jsp");
	return;
}
%>
