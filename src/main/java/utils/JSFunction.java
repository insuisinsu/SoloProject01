package utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class JSFunction {

	//�޽��� �˸�â�� ��� �� ����� URL�� �̵��մϴ�.
	public static void alertLocation(HttpServletResponse resp, String msg, String url) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = ""
						+ "<script>"
						+ "  alert('" + msg + "');"
						+ "  location.href='" + url + "';"
						+ "</script>";
			writer.println(script);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//�޽��� �˸�â�� ��� �� ���� �������� ���ư��ϴ�.
	public static void alertBack(HttpServletResponse resp, String msg) {
		try {
			resp.setContentType("text/html;charset=UTF-8");
			PrintWriter writer = resp.getWriter();
			String script = ""
					+ "<script>"
					+ "  alert('" + msg + "');"
					+ "  history.back();"
					+ "</script>";
		writer.println(script);
		}catch(Exception e) {
			
		}
	}
	
}
