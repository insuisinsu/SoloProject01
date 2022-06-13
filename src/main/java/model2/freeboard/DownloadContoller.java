package model2.freeboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.FileUtil;



@WebServlet("/mvcboard/download.do")
public class DownloadContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get ��� ��û ó��
		
		//Get ���� �Ѿ���� �Ű� ���� �ޱ�
		String ofile = req.getParameter("ofile");
		String sfile = req.getParameter("sfile");
		String num = req.getParameter("num");
		
		//���� �ٿ�ε� ó��(FileUtile �� download �޼ҵ� ȣ��
		FileUtil.download(req, resp, "/Uploads", sfile, ofile);
		
		//�Խù��� �ٿ�ε� �� 1 ����
		FreeboardDAO dao = new FreeboardDAO();
		dao.downCountPlus(num);
		dao.close();
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 
	}

	

}
