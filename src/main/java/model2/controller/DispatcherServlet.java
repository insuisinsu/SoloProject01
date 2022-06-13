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
//		// 1. 클라이언트의 요청 path 정보를 추출한다.
//		String uri = request.getRequestURI();
//		String path = uri.substring(uri.lastIndexOf("/"));
//		System.out.println(path);
//
//		// 2. 클라이언트의 요청 path에 따라 적절히 분기처리 한다.
//		if (path.equals("/login.do")) {
//			System.out.println("로그인 처리");
//			// 1. 사용자 입력 정보 추출
//						String id = request.getParameter("userid");
//						String password = request.getParameter("userpw");
//						
//						// 2. DB 연동 처리
//						AccountDTO vo = new AccountDTO();
//						vo.setUserId(id);
//						vo.setUserPw(password);
//						
//						AccountDAO userDAO = new AccountDAO();
//						AccountDTO user = userDAO.getAccountDTO(vo.getUserId(), vo.getUserPw());
//						
//						// 3. 화면 네비게이션  
//						if(user != null){
//							response.sendRedirect("getBoardList.do");
//						} else {
//							response.sendRedirect("login.jsp");
//						}
//
//		} else if (path.equals("/logout.do")) {
//			System.out.println("로그아웃 처리");
//			// 1. 브라우저와 연결된 세션 객체를 강제 종료한다.  
//			HttpSession session = request.getSession();
//			session.invalidate();
//
//			// 2. 세션 종료 후, 메인 화면으로 이동한다.   
//			response.sendRedirect("login.jsp");
//
//			
//		} else if (path.equals("/insertBoard.do")) {
//			System.out.println("글 등록 처리");
//			// request.setCharacterEncoding("UTF-8");	// 위에서 이미 처리해서 불필요함
//			String title = request.getParameter("title");
//			String userid = request.getParameter("userid");
//			String content = request.getParameter("content");
//			
//			// 2. DB 연동 처리
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setTitle(title);
//			vo.setUserid(userid);
//			vo.setContent(content);
//			
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			boardDAO.insertBoard(vo);
//			
//			// 3. 화면 네비게이션
//			//// 등록 작업 성공 후에 getBoardList.do 를 다시 요청해야함
//			//// 성공 후에 getBoardList.jsp 로 이동하면 등록 전에 세션에 저장된 목록이 출력됨
//			response.sendRedirect("getBoardList.do");
//
//			
//		} else if (path.equals("/updateBoard.do")) {
//			System.out.println("글 수정 처리");
//			// 1. 사용자 입력 정보 추출 
//			
//			//request.setCharacterEncoding("UTF-8");
//			String title = request.getParameter("title");
//			String content = request.getParameter("content");
//			String num = request.getParameter("num");
//			
//			
//			// 2. DB 연동 처리
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setTitle(title);
//			vo.setContent(content);
//			vo.setNum(num);
//			
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			boardDAO.updateBoard(vo);
//			
//			// 3. 화면 네비게이션
//			response.sendRedirect("getBoardList.do");
//
//			
//		} else if (path.equals("/deleteBoard.do")) {
//			System.out.println("글 삭제 처리");
//			// 1. 사용자 입력 정보 추출 
//			
//			//request.setCharacterEncoding("UTF-8");
//			String num = request.getParameter("num");
//			
//			
//			// 2. DB 연동 처리
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setNum(num);
//			
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			boardDAO.deleteBoard(vo);
//			
//			// 3. 화면 네비게이션
//			response.sendRedirect("getBoardList.do");
//
//			
//		} else if (path.equals("/getBoard.do")) {
//			System.out.println("글 상세 조회 처리");
//			// 1. 검색할 게시글 번호 추출
//			String num = request.getParameter("num");
//
//			// 2. DB 연동 처리
//			FreeboardDTO vo = new FreeboardDTO();
//			vo.setNum(num);
//
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			FreeboardDTO board = boardDAO.getBoard(num);
//			
//			// 3. 응답 화면 구성
//			HttpSession session = request.getSession();
//			session.setAttribute("board", board);
//			response.sendRedirect("getBoard.jsp");
//
//			
//		} else if (path.equals("/getBoardList.do")) {
//			System.out.println("글 목록 검색 처리");
//			// 1. 사용자 입력 정보 추출(검색 기능은 나중에 구현)
//			// 2. DB 연동처리
//			FreeboardDTO vo = new FreeboardDTO();
//			FreeboardDAO boardDAO = new FreeboardDAO();
//			List<FreeboardDTO> boardList = boardDAO.selectListPage(vo);
//			
//			// 3. 검색 결과를 세션에 저장하고 목록 화면으로 이동한다.  
//			HttpSession session = request.getSession();
//			session.setAttribute("boardList", boardList);
//			response.sendRedirect("getBoardList.jsp");
//
//		}
//	}
//
//}
