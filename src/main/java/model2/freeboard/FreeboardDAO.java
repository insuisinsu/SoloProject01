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

	//�˻� ���ǿ� �´� �Խù��� ������ ��ȯ
	//�Ű������� �Խù� �˻��� ���� ����(�˻���)�� �������
	public int selectCount(Map<String, Object> map) {
		int totalCount = 0;
		
		//�Խù� ���� ������ ������ �ۼ�
		String query = "SELECT COUNT(*) FROM freeboard";
		if(map.get("searchWord") != null) {
			query += " WHERE " + map.get("searchFiled") + " "
					+ " LIKE '%" + map.get("searchWord") + "%'";
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next(); //Ŀ���� ù ��° ������ �̵�
			//SELECT COUNT(*) FROM board �� ù ��° �÷��� ������ = �Խù� ��
			totalCount = rs.getInt(1);	
		}catch(Exception e) {
			System.out.println("�Խù� ���� ���ϴ� �� ���� �߻�");
			e.printStackTrace();
		}
		
		return totalCount;	//jsp �� ��ȯ
	}
	
	
	//�˻� ���ǿ� �´� �Խù� ����� ��ȯ(����¡ ó�� ����)
		public List<FreeboardDTO> selectListPage(Map<String, Object> map){
			//���(�Խù� ���)�� ���� ����
			List<FreeboardDTO> bbs = new Vector<FreeboardDTO>();
			
			String query = " SELECT * FROM ( "
						+ " 	SELECT tb.*, ROWNUM rNUM FROM ("
						+ "			SELECT * FROM freeboard	";
			
			// �˻����� �߰�
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
				System.out.println("�Խù� ��ȸ �� ���� �߻�");
				e.printStackTrace();
			}
			
			return bbs;
		}
		
		//�Խñ� �����͸� �޾� DB�� �߰��մϴ�.
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
				System.out.println("�Խù� �Է� �� ���� �߻�");
				e.printStackTrace();
			}
			
			return result;
		}
		
	
		
		// ������ �Խù��� ã�� ������ ��ȯ�մϴ�. �󼼺���
		
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
				System.out.println("�Խù� �󼼺��� �� ���� �߻�");
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
				System.out.println("�Խù� �󼼺��� �� ���� �߻�");
				e.printStackTrace();
			}
			return dto;
		}
		*/
	
		//������ �Խù��� ��ȸ���� 1 ������Ų��.
		public void updateVisitCount(String num) {
			String query = " UPDATE freeboard SET "
						+ " visitcount=visitcount+1 "
						+ " WHERE num=?";
			
			try {
				psmt = con.prepareStatement(query);
				psmt.setString(1, num);
				rs = psmt.executeQuery();
			}catch(Exception e) {
				System.out.println("�Խù� ��ȸ�� ���� �� ���� �߻�");
				e.printStackTrace();
			}
		}
		
		
		//������ �Խù��� �����մϴ�.
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
				System.out.println("�Խù� ���� �� ���� �߻�");
				e.printStackTrace();
			}
			
			return result;
		}
		
		// ������ �Խù� ����
		public int deleteBoard(FreeboardDTO dto) {
			int result = 0;
			
			try {
				String query = " DELETE freeboard WHERE num=? ";
				psmt = con.prepareStatement(query);
				psmt.setString(1, dto.getNum());
				
				result = psmt.executeUpdate();
			}catch(Exception e) {
				System.out.println("�Խù� ���� �� ���� �߻�");
				e.printStackTrace();
			}
			
			return result;
		}
		
		
		
		// �ٿ�ε� Ƚ���� 1 ������Ŵ
		public void downCountPlus(String num) {
			String sql = "UPDATE freeboard SET "
						+" downcount=downcount+1 "
						+" WHERE num=? ";
			
			try {
				psmt = con.prepareStatement(sql);
				psmt.setString(1, num);
				psmt.execute();
			}catch(Exception e) {
				System.out.println("�ٿ�ε� Ƚ�� ���� �� ���� �߻�");
				e.printStackTrace();
			}
			
		}
		
}
