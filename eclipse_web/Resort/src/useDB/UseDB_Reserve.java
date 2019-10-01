package useDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UseDB_Reserve {

	private String ip = "jdbc:mysql://192.168.56.102";
	private String port = ":3306/";
	private String dbname = "song?useSSL=false";
	private String dbID = "root";
	private String dbPW = "1234";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rset = null;

	// 생성자
	public UseDB_Reserve() {
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

	// 예약 조회
	public ResultSet selectAllReserve() {
		this.rset = null;
		String sql = "SELECT * FROM resort_reserve;";
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

	// 예약 삽입(유저용)
	public int insertReserve(String name, String rsv_date, int room, String addr, String phone_num, String deposit_name,
			String rsv_comment, int processing) {
		int status = 0;
		try {
			String sql = "insert into resort_reserve" + " (name, rsv_date, room, addr, phone_num, deposit_name,"
					+ " comment, write_date, processing)" + " values (?, ?, ?, ?, ?, ?, ?, date(now()), ?)";
			PreparedStatement pstmt;

			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, rsv_date);
			pstmt.setInt(3, room);
			pstmt.setString(4, addr);
			pstmt.setString(5, phone_num);
			pstmt.setString(6, deposit_name);
			pstmt.setString(7, rsv_comment);
			pstmt.setInt(8, processing);
			status = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

	// 예약 삽입(관리자용)
	public int insertRsvForAdmin(String name, String rsv_date, int room, String addr, String phone_num, String deposit,
			String comment, String write_date, int processing) {
		int status = 0;
		try {
			String sql = "insert into resort_reserve" + " (name, rsv_date, room, addr, phone_num, deposit_name,"
					+ " comment, write_date, processing)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt;

			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, rsv_date);
			pstmt.setInt(3, room);
			pstmt.setString(4, addr);
			pstmt.setString(5, phone_num);
			pstmt.setString(6, deposit);
			pstmt.setString(7, comment);
			pstmt.setString(8, write_date);
			pstmt.setInt(9, processing);
			status = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("관리자:삽입성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//				e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

	// 예약목록 조회
	public ResultSet selectRsv() {
		this.rset = null;

		Calendar cal = Calendar.getInstance();
		//시스템상 현재 날짜를 넣기 위해 구하는 변수들
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd");
		String year_and_month = sdf.format(cal.getTime());
		String curDay = sdf2.format(cal.getTime());
		
		//System.out.println(year_and_month);
		//System.out.println(curDay);
		try {
			
			//현재부터 한달까지의 날짜 테이블을 sql내부 내용으로 만들고 내 예약 테이블과 조인
			//그 결과를 resultset에 담고 리턴
			
			String sql = "SELECT cal.dt,DAYOFWEEK(cal.dt) AS DAY, "
					+ "IFNULL((SELECT NAME FROM resort_reserve WHERE room = 1 AND rsv_date = cal.dt),'예약가능') AS room1, "
					+ "IFNULL((SELECT NAME FROM resort_reserve WHERE room = 2 AND rsv_date = cal.dt),'예약가능') AS room2, "
					+ "IFNULL((SELECT NAME FROM resort_reserve WHERE room = 3 AND rsv_date = cal.dt),'예약가능') AS room3 "
					+ "FROM " + "(SELECT dt + INTERVAL lv-1 DAY dt " + "  FROM ("
					+ "        SELECT ordinal_position lv, CONCAT('" + year_and_month + "','" + curDay + "') dt "
					+ "          FROM information_schema.columns " + "         WHERE table_schema = 'mysql' "
					+ "           AND table_name = 'user' " + "        ) a " + "WHERE lv <= DAY(LAST_DAY(dt))) AS cal "
					+ "LEFT JOIN " + "resort_reserve AS rsv " + "on cal.dt = rsv.rsv_date " + "GROUP BY dt" + ";";
			// System.out.println(sql);
			this.pstmt = this.conn.prepareStatement(sql);
			this.rset = pstmt.executeQuery();
			System.out.println("성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("실패");
			System.out.println(e);
		}

		return this.rset;
	}

	// 예약목록 조회 1년단위
	public ResultSet selectOneYearReserve(String startDate, String endDate) {
		this.rset = null;
		String sql = "SELECT rsv_date, room FROM resort_reserve where rsv_date >=? and rsv_date <? order by rsv_date;";
		// PreparedStatement pstmt = null;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, startDate);
			this.pstmt.setString(2, endDate);
			this.rset = pstmt.executeQuery(); // 괄호안에 아뭇것도 없이

//			while(rset.next()) {
//				System.out.println(rset.getString(1)+","+rset.getString(2));
//			}
//			System.out.println(sql);
//			System.out.println(startDate);
//			System.out.println(endDate);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return this.rset;
	}

	// 예약목록 하나 조회
	public ResultSet selectOneRsv(String rsv_date, int room) {
		// ResultSet rset = null;
		String sql = "SELECT * FROM resort_reserve where rsv_date=? and room=?;";
		// PreparedStatement pstmt;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, rsv_date);
			this.pstmt.setInt(2, room);
			this.rset = this.pstmt.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return this.rset;
	}

	// 예약 수정(update)
	public int updateRsv(String name, String rsv_date, int room, String addr, String phone_num, String deposit,
			String comment, String write_date, int processing) {
		int status = 0;
		String sql = "update resort_reserve set name=?, addr=?, phone_num=?, deposit_name=?,"
				+ " comment=?, write_date=?, processing=? where rsv_date=? and room=?;";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setString(3, phone_num);
			pstmt.setString(4, deposit);
			pstmt.setString(5, comment);
			pstmt.setString(6, write_date);
			pstmt.setInt(7, processing);
			pstmt.setString(8, rsv_date);
			pstmt.setInt(9, room);
			status = pstmt.executeUpdate();
			System.out.println("업뎃 성공");

			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

	// 예약 하나 삭제
	public int deleteRsv(String rsv_date, int room) {
		int status = 0;
		String sql = "delete from resort_reserve  where rsv_date=? and room=?;";
		PreparedStatement pstmt;
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, rsv_date);
			pstmt.setInt(2, room);
			status = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("삭제성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}

	// 생성자 닫기=conn닫기=소멸자 역할
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
