<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model2.freeboard.FreeboardDTO" %>
<%@ page import="model2.freeboard.FreeboardDAO" %>
<%@ include file="/Solo/IsLoggedIn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보 보기</title>
</head>
<body>
<jsp:include page="../Solo/Header.jsp" />

<table border = "1" width = "90%">
	<colgroup>
		<col width = "15%"/> <col width ="35%"/>
		<col width = "15%"/> <col width ="*"/>
	</colgroup>
	
	<!--  게시글 정보 출력 	 -->
	<tr> 
		<td>번호 </td>	<td> ${dto.num }</td>
		<td>작성자 </td>	<td>${dto.userid} </td>
	</tr>
	
	<tr> 
		<td>작성일 </td>	<td> ${dto.postdate }</td>
		<td>조회수 </td>	<td>${dto.visitcount} </td>
	</tr>
	
	<tr> 
		<td>내용 </td>	
		<td colspan="3" height = "100"> ${dto.content } </td>
	</tr>
	
	<!-- 첨부파일  -->
	
	<tr>
		<td>첨부파일 </td>
		<td> 
			<c:if test= "${not empty dto.ofile}"> 
			${dto.ofile }
			<a href = "../freeboard/download.do?ofile=${dto.ofile}&sfile=${dto.sfile}&num=${dto.num}">
				[다운로드]
			</a>
			</c:if>
		</td>
		<td>
			다운로드수
		</td>
		<td>
			${dto.downcount }
		</td>
	</tr>
	
	<!--  하단 메뉴 버튼  -->
	<tr>
		<td colspan = "4" align ="center"> 
		<%
			//1.로그인한 유저의 userid 와 게시글에 존재하는 userid 를 비교함
			
			// session 의 userid (account 의 userid 임) 를 userID에 담는다
			String userID = null;
			if(session.getAttribute("userid") != null) { userID = (String) session.getAttribute("userid");}
			
			// freeboard 의 userid 를 boardUserid 에 담는다.
			//${dto.userid} 를 어떻게 가져올 수 있을까
		
	//		FreeboardDTO boardDTO = new FreeboardDAO.getBoard()
			
	//      Bbs bbs = new BbsDAO().getBbs(bbsID);
	//        if (!userID.equals(bbs.getUserID())) { // !userID세션값과 bbs.getUserID 작성한사람 동일한지
		%>
			<button type ="button" onclick = "location.href='../freeboard/update.do?num=${param.num }';">수정하기</button>
			<button type ="button" onclick = "location.href='../freeboard/deleteBoard.do?num=${param.num }';">삭제하기</button>
	
		<!-- 
			수정하기, 삭제하기 버튼 수정해야함-->
	
			<button type = "button" onclick = "location.href='../freeboard/list.do';">목록 바로가기</button>					
		</td> 	
	</tr>
	

</table>






<%@ include file="../Solo/Footer.jsp" %>




</body>
</html>