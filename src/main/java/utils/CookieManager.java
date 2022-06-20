package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	//명시한 이름, 값, 유지 기간 조건으로 새로운 쿠키를 생성합니다.
	public static void makeCookie
	(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName, cValue);
		cookie.setPath("/");		//웹 애플리케이션 전체에서 사용되도록 최상위 경로를 지정함
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}
	
	//명시한 이름의 쿠키를 찾아 그 값을 반환합니다.
	public static String readCookie(HttpServletRequest request, String cName) {
		String cookieValue = "";
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie c : cookies) {
				String cookieName = c.getName();
				if(cookieName.equals(cName)) {
					cookieValue = c.getValue();
				}
			}
		}
		return cookieValue;
	}

	public static void deleteCookie(HttpServletResponse response, String cName) {
		makeCookie(response, cName,"",0);		//쿠키를 값은 빈 문자열, 유지기간 0 부여하면 됨
	}
	
	
}
