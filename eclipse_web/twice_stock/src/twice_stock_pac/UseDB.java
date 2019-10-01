package twice_stock_pac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UseDB {//db���� �� ���� ������ Ŭ����
	
	//db���ῡ �ʿ��� �ֵ� ����ȭ
	//private String ip = "jdbc:mysql://192.168.56.102"; 
	private String ip = "jdbc:mysql://192.168.23.96";
	private String port = ":3306/";
	private String dbname = "song?useSSL=false";
	private String dbID = "root";
	private String dbPW = "1234";
	
	//Ŀ�ؼ� ���������� ���
	private Connection conn = null;
	//private PreparedStatement pstmt=null;
	//Ŀ�ؼ� ������ �ʿ�
	public UseDB() {
		this.conn = this.connDB();
	}
	//Ŀ�ؼ� ���
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
	//������Ʈ��Ʈ ���
	public Statement statementDB() {
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Ŭ��������");
			conn = DriverManager.getConnection(ip + port + dbname, dbID, dbPW);
			//System.out.println("Ŀ�ؼǼ���");
			stmt = conn.createStatement();
			//stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
		
	}
	
	//����� All ��ȸ
	public ResultSet selectAllTw_stock() {
		ResultSet rset = null;
		String sql = "SELECT * FROM tw_stock order by reg_day_s DESC, id desc;";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery(); //����Ʈ�̹Ƿ� ������ ���
			//pstmt.close();
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return rset;
	}
	
	//����� �ϳ� ��ȸ
	public ResultSet selectOneTw_stock(int id) {
		ResultSet rset = null;
		String sql = "SELECT * FROM tw_stock where id=?;";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rset = pstmt.executeQuery(); //����Ʈ�̹Ƿ� ������ ���
			//pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return rset;
	}
		
	//���� �޼���
	public int deleteTw_stock(int id) {
		int status = 0;
		String sql = "delete from tw_stock WHERE id=?;"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			//��ȣ�ȿ� �ƹ��͵� ����!//status 0,1(���������� ���°����� ��
			status = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}
	//������Ʈ �޼���
	public int updateTw_stock(int stockCnt, int id) {
		int status = 0;
		String sql = "update tw_stock set stock_cnt=? where id=?;"; 
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stockCnt);
			pstmt.setInt(2, id);
			//��ȣ�ȿ� �ƹ��͵� ����!//status 0,1(���������� ���°����� ��
			status = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}	
	
	//�μ�Ʈ �޼���
	public int insertTw_stock(String name, int stockCnt, String description, String img) {
		int status = 0;
		//id�� auto_increment�� ��¥�� ���� ��¥�� ����
		String sql = "insert into tw_stock (name, stock_cnt, reg_day_p, reg_day_s, description, img)"
				+" values (?, ?, date(now()), date(now()), ?, ?);";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, stockCnt);
			pstmt.setString(3, description);
			pstmt.setString(4, img);
			status = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//				e.printStackTrace();
			System.out.println(e);
		}
		return status;
	}	
		
	//�ݴ� �޼���
	public void close() {
		try {
			//this.pstmt.close();
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
	}
	
//	public void connClose() {
//		try {
//			this.conn.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e);
//		}
//		
//	}
}
