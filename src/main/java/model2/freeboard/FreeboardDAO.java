package model2.freeboard;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.ServletContext;
import common.JDBConnect;
import model2.freeboard.FreeboardDTO;

public class FreeboardDAO extends JDBConnect{
	public FreeboardDAO(ServletContext application) {
		super(application);
	}
	
	public FreeboardDAO() {
		// TODO Auto-generated constructor stub
	}

	//검색 조건에 맞는 게시물의 개수를 반환
	//매개변수에 게시물 검색을 위한 조건(검색어)이 담겨있음
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		//게시물 수를 얻어오는 쿼리문 작성
		String query = "SELECT COUNT(*) FROM freeboard";
		if(map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchFiled") + " "
					+ " LIKE '%" + map.get("searchWord") + "%'";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next(); //커서를 첫 번째 행으로 이동
			//SELECT COUNT(*) FROM board 의 첫 번째 컬럼을 가져옴 = 게시물 수
			totalCount = rs.getInt(1);	
		}catch(Exception e) {
			System.out.println("게시물 수를 구하는 중 예외 발생");
			e.printStackTrace();
		}
		
		return totalCount;	//jsp 로 반환
	}
	
	
	//검색 조건에 맞는 게시물 목록을 반환(페이징 처리 지원)
		public List<FreeboardDTO> selectListPage(Map<String, Object> map){
			//결과(게시물 목록)을 담을 변수
			List<FreeboardDTO> bbs = new Vector<FreeboardDTO>();
			
			String query = " SELECT * FROM ( "
						+ " 	SELECT tb.*, ROWNUM rNUM FROM ("
						+ "			SELECT * FROM freeboard	";
			
			// 검색조건 추가
			if(map.get("searchWord") != null) {
				query += " WHERE " + map.get("searchField") + " "
						+ " LIKE '%" + map.get("searchWord") + "%'";
			}
			
			query += " ORDER BY num DESC "
					+ " )TB"
					+ " ) "
					+ " WHERE rNum BETWEEN ? AND ?";
			
			try {
				
				psmt = con.prepareStatement(query);
				psmt.setString(1, map.get("start").toString());
				psmt.setString(2, map.get("end").toString());
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					FreeboardDTO dto = new FreeboardDTO();
					
					dto.setNum(rs.getString("num"));
					dto.setUserid(rs.getString("userid"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setPostdate(rs.getDate("postdate"));
					dto.setVisitcount(rs.getInt("visitcount"));
					dto.setOfile(rs.getString("ofile"));
					dto.setSfile(rs.getString("sfile"));
					dto.setDowncount(rs.getInt("downcount"));

					bbs.add(dto);
					
				}
				
			}catch(Exception e) {
				System.out.println("게시물 조회 중 예외 발생");
				e.printStackTrace();
			}
			
			return bbs;
		}
		
		//게시글 데이터를 받아 DB에 추가합니다.
		public int insertBoard(FreeboardDTO dto) {
			int result = 0;
			
			try {
				String query = "INSERT INTO freeboard ( "
							+ " num, userid, title, content, ofile, sfile) "
							+ " VALUES ( "
							+ " seq_freeboard_num.NEXTVAL, ?, ?, ?, ?, ?)";
				
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getUserid());
				psmt.setString(2, dto.getTitle());
				psmt.setString(3, dto.getContent());
				psmt.setString(4, dto.getOfile());
				psmt.setString(5, dto.getSfile());
				result = psmt.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("게시물 입력 중 예외 발생");
				e.printStackTrace();
			}
			
			return result;
		}
		
	
		
		// 지정한 게시물을 찾아 내용을 반환합니다. 상세보기
		
		public FreeboardDTO getBoard(String num) {
			FreeboardDTO dto = new FreeboardDTO();
			String query = "SELECT * FROM freeboard WHERE num=?";
			try {
				psmt = con.prepareStatement(query);
				psmt.setString(1, num);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					dto.setNum(rs.getString(1));
					dto.setUserid(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setContent(rs.getString(4));
					dto.setPostdate(rs.getDate(5));
					dto.setVisitcount(rs.getInt(6));
					dto.setOfile(rs.getString(7));
					dto.setSfile(rs.getString(8));
					dto.setDowncount(rs.getInt(9));
				}
				
			}catch(Exception e){
				System.out.println("게시물 상세보기 중 예외 발생");
				e.printStackTrace();
			}
			return dto;
		}
		
		/*   
		public FreeboardDTO selectView(String num) {
			FreeboardDTO dto = new FreeboardDTO();
			
			String query = "SELECT B.*, M.name "
						+ " FROM useraccount M INNER JOIN freeboard B "
						+ " ON M.id=B.id "
						+ " WHERE num=?";
			
			try {
				psmt = con.prepareStatement(query);
				psmt.setString(1, num);
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					dto.setNum(rs.getString("num"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setPostdate(rs.getDate("postdate"));
					dto.setUserid(rs.getString("userid"));
					dto.setVisitcount(rs.getString("visitcount"));
				}
			}catch(Exception e) {
				System.out.println("게시물 상세보기 중 예외 발생");
				e.printStackTrace();
			}
			return dto;
		}
		*/
	
		//지정한 게시물의 조회수를 1 증가시킨다.
		public void updateVisitCount(String num) {
			String query = " UPDATE freeboard SET "
						+ " visitcount=visitcount+1 "
						+ " WHERE num=?";
			
			try {
				psmt = con.prepareStatement(query);
				psmt.setString(1, num);
				rs = psmt.executeQuery();
			}catch(Exception e) {
				System.out.println("게시물 조회수 증가 중 예외 발생");
				e.printStackTrace();
			}
		}
		
		
		//지정한 게시물을 수정합니다.
		public int updateBoard(FreeboardDTO dto) {
			int result = 0;
			
			try {
				String query = " UPDATE freeboard SET "
							+ " title=?, content=?, userid=?"
							+ " WHERE num=? ";
				
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getTitle());
				psmt.setString(2, dto.getContent());
				psmt.setString(3, dto.getUserid());
				psmt.setString(4, dto.getNum());
				
				result = psmt.executeUpdate();
				
			}catch(Exception e) {
				System.out.println("게시물 수정 중 예외 발생");
				e.printStackTrace();
			}
			
			return result;
		}
		
		// 지정한 게시물 삭제
		public int deleteBoard(FreeboardDTO dto) {
			int result = 0;
			
			try {
				String query = " DELETE freeboard WHERE num=? ";
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getNum());
				
				result = psmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("게시물 삭제 중 예외 발생");
				e.printStackTrace();
			}
			
			return result;
		}
		
		
		
		// 다운로드 횟수를 1 증가시킴
		public void downCountPlus(String num) {
			String sql = "UPDATE freeboard SET "
						+" downcount=downcount+1 "
						+" WHERE num=? ";
			
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, num);
				psmt.execute();
			}catch(Exception e) {
				System.out.println("다운로드 횟수 증가 중 예외 발생");
				e.printStackTrace();
			}
			
		}
		
}
