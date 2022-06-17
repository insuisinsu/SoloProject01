<%@ page import="utils.JSFunction" %>

<%
if(session.getAttribute("userid") == null){
	JSFunction.alertLocation(response, "login ha3.", "../Solo/Login.jsp");
	return;
}
%>




