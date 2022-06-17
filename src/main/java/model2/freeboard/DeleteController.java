package model2.freeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JSFunction;

public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	FreeboardDAO dao = new FreeboardDAO(); 
	String num = req.getParameter("num"); 
	String userid = req.getParameter("userid"); 
	
	//�Խù��� �ڼ��� ���� �� ��������
	FreeboardDTO dto = dao.getBoard(num);
	dto.setUserid(userid);
	int result = dao.deleteBoard(dto);
	dao.close();   //��ü �ݳ� 
	
	if(result == 1) {
		req.getRequestDispatcher("../freeboard/list.do").forward(req, resp); 
	}else {
		JSFunction.alertLocation(resp, "������ �����߽��ϴ�.", "../freeboard/view.do?num="+num);
	}
	
	}

	
}
