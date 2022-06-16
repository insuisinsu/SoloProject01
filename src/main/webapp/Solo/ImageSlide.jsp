<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/SoloProject01/Solo/css/main.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 이미지 슬라이드 -->
    <div class="section">
        <input type="radio" name="slide" id="slide01" checked>
        <input type="radio" name="slide" id="slide02">
        <input type="radio" name="slide" id="slide03">
        <input type="radio" name="slide" id="slide04">
        <div class="slidewrap">
            <ul class="slidelist">
                <li class="slideitem">
                    <a href="">
                        <label for="slide04" class="left"></label>
                        <img src="./img/slide01.png" alt="">
                        <label for="slide02" class="right"></label>
                    </a>
                </li>
                <li class="slideitem">
                    <a href="">
                        <label for="slide01" class="left"></label>
                        <img src="./img/slide02.png" alt="">
                        <label for="slide03" class="right"></label>
                    </a>
                </li>
                <li class="slideitem">
                    <a href="">
                        <label for="slide02" class="left"></label>
                        <img src="./img/slide03.png" alt="">
                        <label for="slide04" class="right"></label>
                    </a>
                </li>
                <li class="slideitem">
                    <a href="">
                        <label for="slide03" class="left"></label>
                        <img src="./img/slide04.png" alt="">
                        <label for="slide01" class="right"></label>
                    </a>
                </li>
            </ul>
        </div>
    </div>



</body>
</html>