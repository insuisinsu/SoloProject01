<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="./IsLoggedIn.jsp" %>  <!-- 로그인 확인 --> --%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
		function validateForm (form){
			if(!form.title.value){
				alert("제목을 입력하새요");
				form.title.focus();
				return false;
			}
			if(!form.content.value){
				alert("내용 입력하새요");
				form.content.focus();
				return false;
			}
		}
</script>
</head>
<body>

<jsp:include page="../Solo/Header.jsp" />
<h2>회원제 게시판 - 글쓰기(Write)</h2>
<form name="writeFrm" method="post" enctype="multipart/form-data" action="../freeboard/write.do"
		onsubmit="return validateForm(this)">
		<input type="hidden" name="userid" value="${dto.userid }" />
	<table border="1" width="90%">
	
		<tr>
			<td>제목</td>
			<td>
				<input type="text" name="title" style="width: 90%;" />
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				<!-- 로그인한 계정의 id 를 가져와야됨 -->
				<%-- ${dto.userid } --%>
				<input name="userid" type="text" value="test" > 
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name="content" style="width: 90%; height: 100px;"></textarea>
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td>
				<input type="file" name="ofile"  />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="submit">작성 완료</button>
				<button type="reset">다시 입력</button>
				<button type="button" onclick="location.href='List.do';">목록 보기</button>
			</td>
		</tr>
	</table>
	
	
<%@ include file="../Solo/Footer.jsp" %>

</body>
</html>