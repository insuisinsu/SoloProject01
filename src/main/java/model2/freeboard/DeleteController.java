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
	
	//게시물의 자세한 정보 값 가져오기
	FreeboardDTO dto = dao.getBoard(num);
	dto.setUserid(userid);
	int result = dao.deleteBoard(dto);
	dao.close();   //객체 반납 
	
	if(result == 1) {
		req.getRequestDispatcher("../freeboard/list.do").forward(req, resp); 
	}else {
		JSFunction.alertLocation(resp, "삭제에 실패했습니다.", "../freeboard/view.do?num="+num);
	}
	
	}

	
}
