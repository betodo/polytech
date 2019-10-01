package useDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UseDB_Comment {
	private String ip = "jdbc:mysql://192.168.56.102";
	private String port = ":3306/";
	private String dbname = "song?useSSL=false";
	private String dbID = "root";
	private String dbPW = "1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;

	// 생성자
	public UseDB_Comment() {
		this.conn = this.connDB();
	}

	// 커넥션 생성
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
	// 후기 리스트, 전부 조회
	public ResultSet selectAllComment() {
		this.rset = null;
		String sql = "SELECT * FROM resort_comment ORDER BY rootid desc, recnt asc;";
		// PreparedStatement pstmt = null;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.rset = pstmt.executeQuery(); // 괄호안에 아뭇것도 없이

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return this.rset;
	}

////////////////////////////////////////////////////////////////////////////////////////////////
	// 후기뷰 viewcnt 늘리기
	public int addViewcnt(ResultSet rset, int id) {
		int status = 0;
		try {
			rset.next();
			System.out.println(rset.getInt(8));
			int viewcnt = rset.getInt(8) + 1;
			rset.close();
			String sql = "update resort_comment set viewcnt=" + viewcnt + " where id=" + id + ";";
			this.pstmt = this.conn.prepareStatement(sql);
			status = pstmt.executeUpdate(); // 쿼리가 문제없이 성공하면 status가 1인 된다
			// System.out.println(status);
			this.pstmt.close();
			System.out.println(viewcnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			System.out.println("실패");
		}
		return status;
	}

	// 공지뷰 , 하나 조회
	public ResultSet selectOneComment(int id) {
		// ResultSet rset = null;
		String sql = "SELECT * FROM resort_comment where id=?;";
		// PreparedStatement pstmt;
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
	// 후기 신규 작성
	public int insertComment(String title, String content, String file1, String file2) {
		int status = 0;
		try {
			String sql = "insert into resort_comment (title, date, content, relevel, recnt, viewcnt, file1, file2)"
					+ " values (?, date(now()), ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt;

			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setString(6, file1);
			pstmt.setString(7, file2);
			pstmt.executeUpdate();

			String sql2 = "update resort_comment set rootid=last_insert_id() where id=last_insert_id();";
			pstmt = this.conn.prepareStatement(sql2);
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
	// 글 수정
	public int updateComment(int id, String title, String content, String file1, String file2) {
		int status = 0;
		String sql = "update resort_comment set title=?, date=date(now()), content=?, file1=?, file2=? where id=?;";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, file1);
			pstmt.setString(4, file2);
			pstmt.setInt(5, id);
			status = pstmt.executeUpdate();
			System.out.println("업뎃 성공");
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
//댓글 삽입
	public int insertRe(String title, String content, int rootid, int relevel, int recnt, String file1, String file2) {
		int status = 0;
		try {
			ResultSet rset = null;
			PreparedStatement pstmt;

			String sql3 = "select relevel, recnt from resort_comment where (rootid=? and recnt>?) ORDER BY recnt asc;";

			pstmt = this.conn.prepareStatement(sql3);
			pstmt.setInt(1, rootid);
			pstmt.setInt(2, recnt);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				if (rset.getInt(1) < relevel)
					break;
				recnt = rset.getInt(2);
			}
			recnt = recnt + 1;

			String sql2 = "update resort_comment set recnt=recnt+1 where rootid=? and recnt>=?";
			pstmt = this.conn.prepareStatement(sql2);
			pstmt.setInt(1, rootid);
			pstmt.setInt(2, recnt);
			status = pstmt.executeUpdate();

			String sql = "insert into resort_comment"
					+ " (title, date, content, rootid, relevel, recnt, viewcnt, file1, file2)"
					+ " values (?, date(now()), ?, ?, ?, ?, ?, ?, ?)";

			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, rootid);
			pstmt.setInt(4, relevel);
			pstmt.setInt(5, recnt);
			pstmt.setInt(6, 0);
			pstmt.setString(7, file1);
			pstmt.setString(8, file2);
			pstmt.executeUpdate();

			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

////////////////////////////////////////////////////////////////////////////////////////////////
//후기글 하나 삭제
	public int deleteComment(int id) {
		int status = 0;
		String sql = "delete from resort_comment WHERE id=?;";
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

////////////////////////////////////////////////////////////////////////////////////////////////
//댓글 삭제
	public int deleteComment2(int rootid, int relevel, int recnt) {
		int status = 0;
		try {
			ResultSet rset = null;
			PreparedStatement pstmt;
			String sql3 = "select relevel, recnt from resort_comment where (rootid=? and recnt>?) ORDER BY recnt asc;";
			pstmt = this.conn.prepareStatement(sql3);
			pstmt.setInt(1, rootid);
			pstmt.setInt(2, recnt);
			rset = pstmt.executeQuery();

			int delRecnt = 0;
			while (rset.next()) {
				if (rset.getInt(1) <= relevel)
					break;
				delRecnt = rset.getInt(2);
			}

			String sql = "delete from resort_comment WHERE rootid=? and (recnt >=? and recnt <=?);";

			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, rootid);
			pstmt.setInt(2, recnt);
			pstmt.setInt(3, delRecnt);
			status = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
//TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

////////////////////////////////////////////////////////////////////////////////////////////////
//생성자 닫기=conn닫기=소멸자 역할
	public void close() {
		try {
			if (this.rset != null)
				this.rset.close();
			if (this.pstmt != null)
				this.pstmt.close();
			this.conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}

	}
}