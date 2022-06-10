package account;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

@WebServlet("/Solo/createAccount.do")
public class CreateAccountController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("../Solo/CreateAccount.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//폼값을 DTO 에 저장하고 DAO의 createAccount 를 호출하여 DB에 저장
		AccountDTO dto = new AccountDTO();

		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		String username = req.getParameter("username");
		String useremail = req.getParameter("useremail");
		
		System.out.println(userid+userpw+username+useremail);
		
		dto.setUserId(userid);
		dto.setUserPw(userpw);
		dto.setUserName(username);
		dto.setUserEmail(useremail);
		
		AccountDAO dao = new AccountDAO();
		int result = dao.createAccount(dto);
		System.out.println(result);
		
		dao.close();
		
//		if(result == 1) {
//			resp.sendRedirect("../Solo/Login.do");
//		}
//		//글쓰기가 실패하면 이동하는 페이지
//		if(result == 0 ) {
//			resp.sendRedirect("../Solo/createAccount.do");
//		}
		
	}

	
}
