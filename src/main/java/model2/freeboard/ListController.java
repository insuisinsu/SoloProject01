package model2.freeboard;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.BoardPage;


public class ListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FreeboardDAO dao = new FreeboardDAO();
		
		//�信 ������ �Ű����� ����� �� ����
		Map<String, Object> map = new HashMap<String, Object>();
		
		String searchField = req.getParameter("searchField");
		String searchWord = req.getParameter("searchWordk");
		if(searchWord != null) {
			// ������Ʈ������ ���޹��� �Ű����� �� �˻�� �ִٸ� map �� ����
			map.put("searchField",  searchField);
			map.put("searchWord",  searchWord);
		}
		int totalCount = dao.selectCount(map);	//�Խù� ����
		
		
		
		
		/* ������ ó�� Start */
		//web.xml �� ���õ� ������ �ҷ����� 
		ServletContext application = getServletContext(); 
		int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE")); 
		int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLOCK"));
		
		//���� ������ Ȯ�� 
		int pageNum = 1; 
		String pageTemp = req.getParameter("pageNum");  
		if (pageTemp != null && !pageTemp.equals("")) {
			pageNum = Integer.parseInt(pageTemp); 	//  ���� ��� ���� ������ �ѿ��� ������ ������ ������ ��ȯ�ؼ� ���� 
		}
		
		//��Ͽ� ����� �Խù� ���� ��� 
		int start = (pageNum -1) * pageSize + 1 ;  //ù �Խù� ��ȣ 
		int end = pageNum * pageSize;     //������ �Խù� ��ȣ 
		
		//�� �������� �� ����
		map.put("start", start); 
		map.put("end", end);
		
		/* ����¡ ó�� �κ� end */ 
	
		
		// �Խù� ����� �޾ƿ��� (DAO ��ü�� �۾��� ���� )
			//boardLists�� DB�� ���ڵ带 ���� DTO��ü(5��) �� ��� �ִ�. 
		
        List<FreeboardDTO> boardLists = dao.selectListPage(map);  // �Խù� ��� �ޱ�
        dao.close(); // DB ���� �ݱ�
	
		//���������� ���� �� �Ű��������� �߰� 
	        //utils.BoardPage : ����¡ ó���ϴ� Ŭ����, pagingStr �޼ҵ� �� static �޼ҵ���
	    String pagingImg = BoardPage.pagingStr(totalCount, pageSize,
	            blockPage, pageNum, "../Solo/List.do");  // �ٷΰ��� ���� HTML ���ڿ�
	    //View �������� ���� �� ����
	    map.put("pagingImg", pagingImg);
	    map.put("totalCount", totalCount);
	    map.put("pageSize", pageSize);
	    map.put("pageNum", pageNum); 
		
		//���������� ������ ����, request ������ ������ �����͸� ������ List.jsp (��������) �� ������ 
	    req.setAttribute("boardLists", boardLists);	//DataBase ���� Select �� �����
	    req.setAttribute("map", map);
	    req.getRequestDispatcher("/Solo/List.jsp").forward(req, resp);
			
		
		
		
	}
}
