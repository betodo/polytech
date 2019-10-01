package useDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseDB_Gongji {

	private String ip = "jdbc:mysql://192.168.56.102"; 
	private String port = ":3306/";
	private String dbname = "song?useSSL=false";
	private String dbID = "root";
	private String dbPW = "1234";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	
	//생성자
	public UseDB_Gongji() {
		this.conn = this.connDB();
	}
	
	//커넥션 생성
	public Connection connDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(ip + port + dbname, dbID, dbPW);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	//공지리스트, 전부 조회
	public ResultSet selectAllGongji() {
		this.rset = null;
		String sql = "SELECT * FROM resort_gongji ORDER BY id desc;";
		//PreparedStatement pstmt = null;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.rset = pstmt.executeQuery(); //괄호안에 아뭇것도 없이
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return this.rset;
	}
////////////////////////////////////////////////////////////////////////////////////////////////	
	//공지뷰 viewcnt 늘리기
	public int addViewcnt(ResultSet rset, int id) {
		int status = 0;
		try {
			rset.next();
			int viewcnt = rset.getInt(7)+1;//조회수 칼럼값을 하나 올려서
			rset.close();//새로 업데이트
			String sql = "update resort_gongji set viewcnt="+viewcnt+" where id="+id+";";
			this.pstmt = this.conn.prepareStatement(sql);
			status = pstmt.executeUpdate(); //쿼리가 문제없이 성공하면 status가 1인 된다
			//System.out.println(status);
			this.pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}
	//공지뷰 , 하나 조회
	public ResultSet selectOneGongji(int id) {
		//ResultSet rset = null;
		String sql = "SELECT * FROM resort_gongji where id=?;";
		//PreparedStatement pstmt;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, id);
			this.rset = this.pstmt.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return this.rset;
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	//신규 글 삽입
	public int insertGongji(String title, String content, String file1, String file2) {
		int status = 0;
		try {
			String sql = "insert into resort_gongji (title, date, content, file1, file2, viewcnt)"
									+" values (?, date(now()), ?, ?, ?, ?)"; 
			PreparedStatement pstmt;
		
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, file1);
			pstmt.setString(4, file2);
			pstmt.setInt(5, 0);
			status = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}
////////////////////////////////////////////////////////////////////////////////////////////////
	//글 수정
	public int updateGongji(int id, String title, String content, String file1, String file2) {
		int status = 0;
		String sql = "update resort_gongji set title=?, date=date(now()), content=?, file1=?, file2=? where id=?;"; 
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, file1);
			pstmt.setString(4, file2);
			pstmt.setInt(5, id);
			status = pstmt.executeUpdate();
//			System.out.println("업뎃 성공");
//			System.out.println(title);
//			System.out.println(content);
//			System.out.println(file1);
//			System.out.println(file2);
//			System.out.println(id);
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////	
	//공지글 하나 삭제
	public int deleteGongji(int id) {
		int status = 0;
		String sql = "delete from resort_gongji WHERE id=?;"; 
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}
	
	//생성자 닫기=conn닫기=소멸자 역할
	public void close() {
		try {
			if (this.rset != null) this.rset.close();
			if (this.pstmt != null) this.pstmt.close();
			this.conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	
}
