package GongJi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseDB {
		//db연결 변수들
		private String ip = "jdbc:mysql://192.168.56.102"; 
		private String port = ":3306/";
		private String dbname = "song?useSSL=false";
		private String dbID = "root";
		private String dbPW = "1234";
		
		//privateString dbname = "song?useSSL=false";
		//privateString ip = "192.168.23.96";
		
		//커넥션 생성
		private Connection conn = null;
		//private Statement stmt = null;
		//private PreparedStatement pstmt = null;
		
		//생성자 역할
		public UseDB() {
			this.conn = this.connDB();
		}
		
		//스테이트 먼트 선언 메서드
		public Statement statementDB() {
			Statement stmt =null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("Ŭ��������");
				this.conn = DriverManager.getConnection(ip + port + dbname, dbID, dbPW);
				//System.out.println("Ŀ�ؼǼ���");
				 stmt = this.conn.createStatement();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stmt;
			
		}
		
		//커넥션 맺는 메서드
		public Connection connDB() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				//System.out.println("Ŭ��������");
				conn = DriverManager.getConnection(ip + port + dbname, dbID, dbPW);
				//System.out.println("Ŀ�ؼǼ���");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
			
		}
		

		//글 삽입 메서드
		public int insertGongji(String title, String content, String file1, String file2) {
			int status = 0;
			try {
				String sql = "insert into gongji (title, date, content, relevel, recnt, viewcnt, file1, file2)"
										+" values (?, date(now()), ?, ?, ?, ?, ?, ?)"; 
				PreparedStatement pstmt;
			
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, 0);
				pstmt.setInt(4, 0);
				pstmt.setInt(5, 0);
				pstmt.setString(6, file1);
				pstmt.setString(7, file2);
				//status = pstmt.executeUpdate();//��ȣ�ȿ� �ƹ��͵� ����!//status 0,1(���������� ���°����� ��
				pstmt.executeUpdate();
				
				String sql2 ="update gongji set rootid=last_insert_id() where id=last_insert_id();";
				pstmt = this.conn.prepareStatement(sql2);
				status =pstmt.executeUpdate();
				
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println(e);
			}
			return status;
		}
		
		//댓글 삽입 메소드
		public int insertRe(String title, String content, int rootid, int relevel, int recnt) {
			int status = 0;
			try {
				ResultSet rset = null;
				PreparedStatement pstmt;
				
				System.out.println("rootid : "+rootid);
				System.out.println("relevel : "+relevel);
				System.out.println("recnt : "+recnt);
				System.out.println("==============");
				//원글이 갖고 내가 클릭한 글의 recnt보다 큰 글들의 정보를 조회
				String sql3 = "select relevel, recnt from gongji where (rootid=? and recnt>?) ORDER BY recnt asc;";
				
				pstmt = this.conn.prepareStatement(sql3);
				pstmt.setInt(1, rootid);
				pstmt.setInt(2, recnt);
				
				//System.out.println(pstmt);
				
				rset = pstmt.executeQuery();
				
				//기존 처음 생각했던 메서드
//				while (rset.next()) {
//					System.out.println(rset.getInt(1)+" / "+ rset.getInt(2));
//				}
				
//				if (recnt == 0 && rset.next()) {
//					System.out.println("if 1 = "+recnt);
//					rset.beforeFirst();
//					
//					while(rset.next()) {	
//						recnt = rset.getInt(2);
//						System.out.println("while="+recnt);
//					
//					}
//					recnt = recnt +1;
//				}
//				else if(recnt == 0 && rset.next()==false) {
//					System.out.println("else if 1 = "+recnt);
//					recnt = 1;
//					
//				}
//				else if(recnt != 0 && rset.next()) {
//					System.out.println("else if 2 = "+recnt);
//					rset.beforeFirst();			
//
//					while(rset.next()) {
//						if(rset.getInt(1) < relevel) break;
//						recnt = rset.getInt(2);
//						System.out.println("while="+recnt);
//					}
//					recnt = recnt +1;
//				}
//				else if(recnt != 0 && rset.next()==false) {
//					System.out.println("else if 2 = "+recnt);
//					recnt = recnt +1;
//				
//				}
				
				//조회한 글 들 중에서 같은 수준의 글들을 구함
				//작성할 댓글의 recnt를 구하는 과정
	            while(rset.next()){
	                if( rset.getInt(1) < relevel ) break;
	                recnt = rset.getInt(2);
	            }
	            recnt = recnt +1;
				
				
				
				System.out.println("==============");
				System.out.println("update = "+recnt);
				System.out.println("==============");
		
				//구한 recnt가 들어갈 자리를 만듬
				String sql2 = "update gongji set recnt=recnt+1 where rootid=? and recnt>=?";
				pstmt = this.conn.prepareStatement(sql2);
				pstmt.setInt(1, rootid);
				pstmt.setInt(2, recnt);
				status = pstmt.executeUpdate();
				
				//구한 recnt를 토대로 댓글 db에 삽입
				String sql = "insert into gongji (title, date, content, rootid, relevel, recnt, viewcnt)"
										+" values (?, date(now()), ?, ?, ?, ?, ?)"; 
		
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, rootid);
				pstmt.setInt(4, relevel);
				pstmt.setInt(5, recnt);
				pstmt.setInt(6, 0);
				pstmt.executeUpdate();//��ȣ�ȿ� �ƹ��͵� ����!//status 0,1(���������� ���°����� ��

				
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				System.out.println(e);
			}
			return status;
		}
		
		
		//글 수정 메서드
		public int updateGongji(int id, String title, String content) {
			int status = 0;
			String sql = "update gongji set title=?, date=date(now()), content=? where id=?;"; 
			
			PreparedStatement pstmt;
			try {
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, content);
				pstmt.setInt(3, id);
				status = pstmt.executeUpdate();//��ȣ�ȿ� �ƹ��͵� ����!//status 0,1(���������� ���°����� ��
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			return status;
		}
		
		//글 하나 조회 메서드
		public ResultSet selectOneGongji(int id) {
			ResultSet rset = null;
			String sql = "SELECT * FROM gongji where id=?;";
			PreparedStatement pstmt;
			try {
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rset = pstmt.executeQuery(); //����Ʈ�̹Ƿ� ������ ���
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			return rset;
		}
		
		//글 하나 지우는 메서드
		public int deleteGongji(int id) {
			int status = 0;
			String sql = "delete from gongji WHERE id=?;"; 
			PreparedStatement pstmt;
			try {
				pstmt = this.conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				status = pstmt.executeUpdate();//��ȣ�ȿ� �ƹ��͵� ����!//status 0,1(���������� ���°����� ��
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			return status;
		}
		
		
		//����Ѱ� ���� �޼ҵ�
		public void close() {
			try {
				//this.pstmt.close();
				//this.stmt.close();
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
			
		}
//		public void stmtclose() {
//			try {
//				this.pstmt.close();
//				this.stmt.close();
//				this.conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println(e);
//			}
//			
//		}
		
}

//	//������ �Է�
//	//String sql = "insert into gongji (title, date, content) values ('"+title+"', date(now()), '"+content+"');";
//	//stmt.execute(sql);
//	String sql = "insert into gongji (title, date, content) values (?, date(now()), ?)"; 
//	PreparedStatement pstmt = conn.prepareStatement(sql);

//	pstmt.setString(1,title);
//	pstmt.setString(2,content);

//	int status = pstmt.executeUpdate();//��ȣ�ȿ� �ƹ��͵� ����!//status 0,1(���������� ���°����� ��


