package model2.freeboard;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import utils.FileUtil;
import utils.JSFunction;

public class WriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/Solo/Write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Post ��� ��û ó��
				//Write.jsp ���������� ������ Ŭ������ �� form ���� �Ѿ���� ������ ���� ó��
				
				//form ���� ������ �����ϹǷ� cos.jar ���̺귯���� ��ü ������ ������ ���� �޾ƾ��Ѵ�.
				
				//1. ���� ���ε� ó��
					//saveDirectory ������ ���ε��� ������ ������ ������ �������� ��θ� ����
					String saveDirectory = req.getServletContext().getRealPath("/Uploads");
					
					//maxPostSize : ���ε��� �ִ� �뷮 (web.xml �� 1MB �� ��������) �װ� �ҷ��� ����
					ServletContext application = getServletContext();
					int maxPostSize = Integer.parseInt(application.getInitParameter("maxPostSize"));
				
					//��ü ����
					MultipartRequest mr = FileUtil.uploadFile(req, saveDirectory, maxPostSize);
					
					//��ü ���� ���н� ó���� ����
					if(mr==null) { // ��ü ���� ���� (1MB �̻��� ���� ���۽�)
						JSFunction.alertLocation(resp, "÷�ο뷮 �ʰ�", "../freeboard/write.do");
						return;
					}
				
				//2. ���� ���ε� �� ó��(Form �� ������ ó��)
					//������ �Ѱܹ��� ���� �޾Ƽ� DTO(VO)�� Setter ������ �ϰ� DAO �� Insert �޼ҵ忡 ������
					FreeboardDTO dto = new FreeboardDTO();
					dto.setUserid(mr.getParameter("userid"));
					dto.setTitle(mr.getParameter("title"));
					dto.setContent(mr.getParameter("content"));
					
					//�������� �̸��� �������� �̸� ����
					String fileName = mr.getFilesystemName("ofile");	//client�� ÷�������� ������ �ּ�
					System.out.println(fileName);
					if(fileName != null) { 		//÷�������� ������� �ʴٸ�
						
						//���ο� ���� �̸����� �����ؼ� ������ ������
						//÷���ϴ� ������ �̸��� �̹� ������ ���� �� ���� -> ��¥�� ���� �ߺ� ����
						String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());
						System.out.println("now : " + now);
						//Ȯ���ڸ� �߶󳻰� ���� - " . " ���� �����Ȥ�
						String ext = fileName.substring(fileName.lastIndexOf("."));
						System.out.println("ext : " + ext);
						//������ ������ �����̸�
						String newFileName = now + ext;
						System.out.println("newFileName : " + newFileName);
						
						//���ϸ� ����
						File oldFile = new File(saveDirectory + File.separator + fileName);		//File.separator = \ (��������)
						File newFile = new File(saveDirectory + File.separator + newFileName);
						System.out.println("oldFile : " + oldFile);
						System.out.println("newFile : " + newFile);
						//oldFile �� �̸��� newFile �� ����
						oldFile.renameTo(newFile);
						
						dto.setOfile(fileName);		//���� ���� �̸�
						dto.setSfile(newFileName);	//������ ����� ���� �̸�
					}
					
					//DTO�� ��ü�� DAO �� insertWrite(dto) �޼ҵ带 ȣ���ؼ� DB�� ����
					FreeboardDAO dao = new FreeboardDAO();
					int result = dao.insertWrite(dto);
					//��ü ���� �޼ҵ� ȣ��(rs, stmt, psmt, con ��� ����)
					dao.close();
					
					//�۾��Ⱑ �����ϸ� list �������� �̵�
					if(result == 1) {
						resp.sendRedirect("../freeboard/list.do");
					}
					//�۾��Ⱑ �����ϸ� �̵��ϴ� ������
					if(result == 0 ) {
						resp.sendRedirect("../freeboard/write.do");
					}
					
	
	}
	
	
	
}
