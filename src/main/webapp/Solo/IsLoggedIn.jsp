<%@ page import="utils.JSFunction" %>

<%
if(session.getAttribute("userid") == null){
	JSFunction.alertLocation(response, "fhrmdlsdl vlfdygkqslek.", "../Solo/Login.jsp");
	return;
}
%>
