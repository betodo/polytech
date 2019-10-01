package dbTest;

import java.sql.*;

public class DBconnect {

	private String ip = "localhost";
	// privateString ip = "192.168.23.96";
	private String port = ":3306/";
	private String dbname = "song";
	// privateString dbname = "song?useSSL=false";
	private String dbID = "root";
	private String dbPW = "1234";

	private Statement stmt;

	public Connection connDB() {
		Connection conn = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("클래스성공");
			conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + dbname, dbID, dbPW);
			System.out.println("커넥션성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public Statement useDB() {
		Connection conn = null;
		stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + dbname, dbID, dbPW);
			stmt = conn.createStatement();
			conn.close();
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

}
