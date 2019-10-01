package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicTraining_1_주차장위치 {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","m21234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
		stmt.execute("create table examtable("+ //테이블 만드는 쿼리입력
					"주차장_관리 varchar(20) not null primary key,"+
					"주차장명 varchar(40),"+
					"주차장_구분 varchar(10),"+
					"주차장_유형 int,"+
					"소재지도로 int,소재지주변 varchar)"+
					"DEFAULT CHARSET=utf8;");
		
		stmt.close();
		conn.close();
	}
}
