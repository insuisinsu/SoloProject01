package model2.freeboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.MultipartRequest;

import utils.FileUtil;
import utils.JSFunction;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��й�ȣ ���� ��(������ �Ϸ�Ǹ�) idx �� �ش��ϴ� ���ڵ带 dto �� ��Ƽ� Edit.jsp �� ���
		//Get ������� ��û�� �޾Ƽ�(Client �� �ѱ�� ������ �Ҵ� �޾Ƽ�) �� �������� �ѱ�
		String num = req.getParameter("num");
		FreeboardDAO dao = new FreeboardDAO();
		FreeboardDTO dto = dao.getBoard(num);	//idx �� �ش��ϴ� ���ڵ带 �Ѱܹ޾� DTO�� ����
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/Solo/Update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Edit.jsp ���� ������ ������ �޾Ƽ� DB�� ����
		
		//1. ���� ���ε� ó��
			//���ε� ���丮�� �������� ��θ� Ȯ���ؾ� ��(������ ������ ���ε��� �������� ������)
		String saveDirectory = req.getServletContext().getRealPath("/Solo/Uploads");
		
			//���ε��� ������ �ִ�뷮 Ȯ��(web.xml �� ������ ������ / 1MB)
		ServletContext application = this.getServletContext();
		int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
		
			//���� ���ε�
		MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
		
		if(mr == null) {
			//���� ���ε� ����
			JSFunction.alertBack(resp, "÷������ �뷮�� �ʰ��Ǿ����ϴ�.");
			return;
		}
		
		//2. ���� ���ε� �� ó��
			//Request ��ü�� �ƴ϶� MultipartRequest ��ü���� Form �� �������� ����
			// - ���ε� ���̺귯�� ���� form �� �������� �޴� �޼ҵ� �̸��� �ٸ� �� ����
		String num = mr.getParameter("num");
		String prevOfile = mr.getParameter("prevOfile");
		String prevSfile = mr.getParameter("prevSfile");
		
		String userid = mr.getParameter("userid");
		String title = mr.getParameter("title");
		String content = mr.getParameter("content");
		
		
		//DTO ���� �Ѱܹ��� �������� ����(Client Form -> DTO -> DAO �� ����)
		FreeboardDTO dto = new FreeboardDTO();
		dto.setNum(num);
		dto.setUserid(userid);
		dto.setTitle(title);
		dto.setContent(content);
		
		//dto ��ü�� Ofile, Sfile �� ���ε� ��ο� �ش� ���ϸ��� �����ϴ� ��� ó�� �ʿ�
		
		//���� ���ϸ�� ����� ���� �̸� ����
		String fileName = mr.getFilesystemName("ofile");
		if(fileName != null) {		//÷�� ������ Uploads ������ �����ϴ� ���, ���� �̸��� �����ؼ� ����
			//���ο� ���ϸ� ����
			String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());	//��¥
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String newFilename = now + ext;
			
			System.out.println("now : " + now);
			System.out.println("ext : " + ext);
			System.out.println("newFilename : " + newFilename);
			
			//���ϸ� ����
			File oldFile = new File(saveDirectory + File.separator + fileName);
			File newFile = new File(saveDirectory + File.separator + newFilename);
			
			oldFile.renameTo(newFile);
			
			//����� ������ DTO �� ����
			dto.setOfile(fileName);		//���� �����̸�
			dto.setSfile(newFilename);	//���ο� �����̸�(������ ����� �����̸�)
			
			//���� ���� ����
			FileUtil.deleteFile(req, "/Uploads", prevSfile);

		}else { 	//÷�������� �������� ������ ������ �̸� ����
			dto.setOfile(prevOfile);
			dto.setSfile(prevSfile);
		}
		//DB�� ���� ������ �ݿ� (DTO �� ����� ���� DAO �� �޼ҵ��� �Ű������� ����)
		FreeboardDAO dao = new FreeboardDAO();
		int result = dao.updateBoard(dto);		//result �� 1�̸� update ����, 0�̸� update ����
		System.out.println(result);
		dao.close();
		
		//���� ���� or ����
		if(result > 0) {
			resp.sendRedirect("../freeboard/view.do?num=" + num);
		}else {
			JSFunction.alertLocation(resp, "������ �����߽��ϴ�.",
					"../freeboard/view.do?num=" + num);
		}
		
		
	}

}
