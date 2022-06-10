package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
	
	//����� �̸�, ��, ���� �Ⱓ �������� ���ο� ��Ű�� �����մϴ�.
	public static void makeCookie(HttpServletResponse response, String cName, String cValue, int cTime) {
		Cookie cookie = new Cookie(cName, cValue);
		cookie.setPath("/");		//�� ���ø����̼� ��ü���� ���ǵ��� �ֻ��� ��θ� ������
		cookie.setMaxAge(cTime);
		response.addCookie(cookie);
	}
	
	//����� �̸��� ��Ű�� ã�� �� ���� ��ȯ�մϴ�.
	public static String readCookie(HttpServletRequest request, String cName	) {
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
		makeCookie(response, cName,"",0);		//��Ű�� ���� �� ���ڿ�, �����Ⱓ 0 �ο��ϸ� ��
	}
	
	
}
