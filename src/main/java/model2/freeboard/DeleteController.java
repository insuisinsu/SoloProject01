package model2.freeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("");
	FreeboardDAO dao = new FreeboardDAO(); 
	String num = req.getParameter("num"); 
	
	//게시물의 자세한 정보 값 가져오기
	FreeboardDTO dto = dao.getBoard(num);
	dao.deleteBoard(dto);
	dao.close();   //객체 반납 
	
	req.getRequestDispatcher("../freeboard/list.do").forward(req, resp); 
	
	}

	
}
