//package model2.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import account.AccountDAO;
//import account.AccountDTO;
//import model2.freeboard.FreeboardDAO;
//import model2.freeboard.FreeboardDTO;
//
//
//
//@WebServlet(name = "action", urlPatterns = { "*.do" })
//public class DispatcherServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	public DispatcherServlet() {
//		super();
//	}
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		process(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		process(request, response);
//	}
//
//	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		// 1. Ŭ���̾�Ʈ�� ��û path ������ �����Ѵ�.
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println(path);
//
//		// 2. Ŭ���̾�Ʈ�� ��û path�� ���� ������ �б�ó�� �Ѵ�.
//		if (path.equals("/login.do")) {
//			System.out.println("�α��� ó��");
//			// 1. ����� �Է� ���� ����
//						String id = request.getParameter("userid");
//						String password = request.getParameter("userpw");
//						
//						// 2. DB ���� ó��
//						AccountDTO vo = new AccountDTO();
//						vo.setUserId(id);
//						vo.setUserPw(password);
//						
//						AccountDAO userDAO = new AccountDAO();
//						AccountDTO user = userDAO.getAccountDTO(vo.getUserId(), vo.getUserPw());
//						
//						// 3. ȭ�� �׺���̼�  
//						if(user != null){
//							response.sendRedirect("getBoardList.do");
//						} else {
//							response.sendRedirect("login.jsp");
//						}
//
//		} else if (path.equals("/logout.do")) {
//			System.out.println("�α׾ƿ� ó��");
//			// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.  
//			HttpSession session = request.getSession();
//			session.invalidate();
//
//			// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.   
//			response.sendRedirect("login.jsp");
//
//			
//		} else if (path.equals("/insertBoard.do")) {
//			System.out.println("�� ��� ó��");
//			// request.setCharacterEncoding("UTF-8");	// ������ �̹� ó���ؼ� ���ʿ���
//			String title = request.getParameter("title");
//			String userid = request.getParameter("userid");
//			String content = request.getParameter("content");
//			
//			// 2. DB ���� ó��
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setTitle(title);
//			vo.setUserid(userid);
//			vo.setContent(content);
//			
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			boardDAO.insertBoard(vo);
//			
//			// 3. ȭ�� �׺���̼�
//			//// ��� �۾� ���� �Ŀ� getBoardList.do �� �ٽ� ��û�ؾ���
//			//// ���� �Ŀ� getBoardList.jsp �� �̵��ϸ� ��� ���� ���ǿ� ����� ����� ��µ�
//			response.sendRedirect("getBoardList.do");
//
//			
//		} else if (path.equals("/updateBoard.do")) {
//			System.out.println("�� ���� ó��");
//			// 1. ����� �Է� ���� ���� 
//			
//			//request.setCharacterEncoding("UTF-8");
//			String title = request.getParameter("title");
//			String content = request.getParameter("content");
//			String num = request.getParameter("num");
//			
//			
//			// 2. DB ���� ó��
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setTitle(title);
//			vo.setContent(content);
//			vo.setNum(num);
//			
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			boardDAO.updateBoard(vo);
//			
//			// 3. ȭ�� �׺���̼�
//			response.sendRedirect("getBoardList.do");
//
//			
//		} else if (path.equals("/deleteBoard.do")) {
//			System.out.println("�� ���� ó��");
//			// 1. ����� �Է� ���� ���� 
//			
//			//request.setCharacterEncoding("UTF-8");
//			String num = request.getParameter("num");
//			
//			
//			// 2. DB ���� ó��
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setNum(num);
//			
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			boardDAO.deleteBoard(vo);
//			
//			// 3. ȭ�� �׺���̼�
//			response.sendRedirect("getBoardList.do");
//
//			
//		} else if (path.equals("/getBoard.do")) {
//			System.out.println("�� �� ��ȸ ó��");
//			// 1. �˻��� �Խñ� ��ȣ ����
//			String num = request.getParameter("num");
//
//			// 2. DB ���� ó��
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setNum(num);
//
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			FreeboardDTO board = boardDAO.getBoard(num);
//			
//			// 3. ���� ȭ�� ����
//			HttpSession session = request.getSession();
//			session.setAttribute("board", board);
//			response.sendRedirect("getBoard.jsp");
//
//			
//		} else if (path.equals("/getBoardList.do")) {
//			System.out.println("�� ��� �˻� ó��");
//			// 1. ����� �Է� ���� ����(�˻� ����� ���߿� ����)
//			// 2. DB ����ó��
//			FreeboardDTO vo = new FreeboardDTO();
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			List<FreeboardDTO> boardList = boardDAO.selectListPage(vo);
//			
//			// 3. �˻� ����� ���ǿ� �����ϰ� ��� ȭ������ �̵��Ѵ�.  
//			HttpSession session = request.getSession();
//			session.setAttribute("boardList", boardList);
//			response.sendRedirect("getBoardList.jsp");
//
//		}
//	}
//
//}
