package model2.freeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class ViewController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//게시물 정보 불러 오기 ( 1. 조회수 증가, 2.게시물 정보 가져오기) 
		FreeboardDAO dao = new FreeboardDAO(); 
		
		String num = req.getParameter("num"); 
		
		//조회수 증가 
		dao.updateVisitCount(num); 
		
		//게시물의 자세한 정보 값 가져오기
		FreeboardDTO dto = dao.getBoard(num); 
		dao.close();   //객체 반납 
		
		//DataBase 의  content 컬럼의 \r\n  <== <<Enter>>을 "<br /> 태그로 변환 
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		//게시물 (dto) 객체를 view페이지로 전달하기 변수 값 저장 
		req.setAttribute("dto", dto); 
		req.getRequestDispatcher("/Solo/View.jsp").forward(req, resp); 
								// /Solo/View.jsp 아닌가? 
		
	}

	
		
}
