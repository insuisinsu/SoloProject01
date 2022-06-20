<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode = "on";

Cookie[] cookies = request.getCookies();	// 쿠키를 읽어와서 popupMode 값을 설정함
if(cookies != null){
	for (Cookie c : cookies){
		String cookieName = c.getName();
		String cookieValue = c.getValue();
		if(cookieName.equals("PopupClose")){
			popupMode = cookieValue;
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<title>렌트카를 인수하자!</title>
<style>
	div#popup{
	 position:absolute; top:100px; left:50px; color:yellow;
	widthL270px; height:100px; background-color:gray;
	}
	div#popup>div{
	position: relative; background-color:#ffffff; top:0px;
	border:1px; solid gray; padding:10px; color:black;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
</script>
<script>
$(function(){
	$('#closeBtn').click(function(){	//닫기 버튼을 누르면 실행되는 함수
		$('#popup').hide();
		var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();	// 체크 여부 확인
		
		$.ajax({								//jQuery의 ajax() 함수로 비동기 요청
			url : './PopupCookie.jsp',
			type : 'get',
			data : {inactiveToday : chkVal},	//inactiveToday=<chkVal 변수의 값> 데이터를
			dataType : "text",					//응답 데이터의 타입은 일반 텍스트
			success : function(resData){		//요청 성공 시 호출되는 함수
				if(resData != '') location.reload();	//응답 데이터가 있다면 페이지를 새로고침
			}
		});
	});
});
</script>
</head>
<body>



<!-- Header -->
<%@ include file="../Solo/Header.jsp" %>

<!-- 공지사항 팝업 (쿠키) -->
<%
	if(popupMode.equals("on")){
%>
<div id="popup">
	<h2 align="center">공지사항 팝업입니다.</h2>
	<div align="right">
		<form name="popFrm">
			<input type="checkbox" id="inactiveToday" value="1" />
			하루 동안 열지 않음
			<input type="button" value="닫기" id="closeBtn"/>
		</form>		
	</div>
</div>
<%
	}
%>
	
<!-- 이미지 슬라이드 -->
<%@ include file="../Solo/ImageSlide.jsp" %>
<!-- 검색탭 / 상품리스트-->
<%@ include file="../Solo/SearchCar.jsp" %>
<!-- Footer -->
<%@ include file="../Solo/Footer.jsp" %>
</body>
</html>