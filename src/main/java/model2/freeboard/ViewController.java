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
		
		//�Խù� ���� �ҷ� ���� ( 1. ��ȸ�� ����, 2.�Խù� ���� ��������) 
		FreeboardDAO dao = new FreeboardDAO(); 
		
		String num = req.getParameter("num"); 
		
		//��ȸ�� ���� 
		dao.updateVisitCount(num); 
		
		//�Խù��� �ڼ��� ���� �� ��������
		FreeboardDTO dto = dao.getBoard(num); 
		dao.close();   //��ü �ݳ� 
		
		//DataBase ��  content �÷��� \r\n  <== <<Enter>>�� "<br /> �±׷� ��ȯ 
		dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));
		
		//�Խù� (dto) ��ü�� view�������� �����ϱ� ���� �� ���� 
		req.setAttribute("dto", dto); 
		req.getRequestDispatcher("/Solo/View.jsp").forward(req, resp); 
								// /Solo/View.jsp �ƴѰ�? 
		
	}

	
		
}
