<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/best_car.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 차량 검색 -->
    <div class="carsearch">
        <table class="smart_car_search">
            <colgroup class ="colgroup">
                <col width="25%"><col width="25%"><col width="25%"><col width="25%">
            </colgroup>
            <tbody>
                <tr>
                    <td rowspan="2" style="border-bottom: none; border-right: 1px solid #dbdde9;">
                        <h4>CAR SEARCH</h4>
                    </td>
                    <td colspan="3">
                        <span class="scs_radio">
                            <input type="radio" name="category" id="scs1" value="1" checked="">
                            <label for="scs1">단기대여</label>
                        </span>
                        <span class="scs_radio">
                            <input type="radio" name="category" id="scs2" value="2">
                            <label for="scs2">월대여</label>
                        </span>
                        <span class="scs_radio">
                            <input type="radio" name="category" id="scs3" value="3">
                            <label for="scs3">장기대여</label>
                        </span>
                    </td>
                </tr>
                <tr>
                    <td>
                        <select name="a2_item">
                            <option selected>차종 선택</option>
                            <option value="경차/소형">작은 차</option>
                            <option value="준중형">큰 차</option>
                        </select>
                    </td>
                    <td>
                        <select name="a1_item">
                            <option selected>제조사 선택</option>
                            <option value="현대">현대</option>
                            <option value="기아">기아</option>
                            <option value="수입차">수입차</option>
                        </select>
                    </td>
                    <td>
                        <button type="submit">검색하기</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>


    <!-- best car -->
<div class="best_car_section">
    <div class="dep">
        <div class="best_car_look">
            <ul>
                <li><a href="#" class="selected">단기 인기차종</a></li>
                <li><a href="#" class="selected">월 인기차종</a></li>
                <li><a href="#" class="selected">장기 인기차종</a></li>
            </ul>
        </div>
        <h3 class="main_title">인기 차종</h3> 
    </div>
    <div class="slide_box">
        <div class="best_car">
            <ul class="best_car_ul">
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="k3.html"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K3</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">59,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">69,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>Avante</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">59,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">69,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K5</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">69,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">79,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K7</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">89,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">99,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K7</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">89,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">99,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K7</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">89,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">99,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K7</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">89,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">99,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K7</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">89,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">99,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K7</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">89,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">99,000</div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="topdan">
                        <p>단기대여</p>
                        <a href="#"><img src="img/K3.png" alt="#"></a>
                    </div>
                    <div class="buttom">
                        <div class="car_name">
                            <p>K7</p>
                        </div>
                    </div>
                    <div class="buttom2">
                        <div class="box">
                            <div class="wid50 text">평일 24시간</div>
                            <div class="wid50 pay">89,000</div>
                            <div class="wid50 text">주말 24시간</div>
                            <div class="wid50 pay">99,000</div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>


 

</body>
</html>