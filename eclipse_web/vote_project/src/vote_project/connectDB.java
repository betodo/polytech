package vote_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connectDB {
	//db���ῡ �ʿ��� �ֵ� ����ȭ
	private String ip = "jdbc:mysql://192.168.56.102"; 
	private String port = ":3306/";
	private String dbname = "song?useSSL=false";
	private String dbID = "root";
	private String dbPW = "1234";
	
	//privateString dbname = "song?useSSL=false";
	//privateString ip = "192.168.23.96";
	
	//Ŀ�ؼǰ� ������Ʈ��Ʈ�� ���������� ���
	private Connection conn = null;
	private Statement stmt = null;
	
	//Ŭ����+Ŀ�ؼ�+������Ʈ��Ʈ�� �ϳ��� �޼ҵ��
	public Statement useDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Ŭ��������");
			conn = DriverManager.getConnection(ip + port + dbname, dbID, dbPW);
			//System.out.println("Ŀ�ؼǼ���");
			stmt = conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
		
	}
	
	//����Ѱ� ���� �޼ҵ�
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public Connection useDB() {
//		Connection conn = null;
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String ip = "192.168.56.102";
//			String port = ":3306/";
//			String ubuntuID = "kopo11?useSSL=false";
//			String dbID = "root";
//			String dbPW = "1234";
//
//			conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + ubuntuID, dbID, dbPW);
//
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}
	
	
	
	
	public Connection getConn() {
		return this.conn;
	}



	
}
