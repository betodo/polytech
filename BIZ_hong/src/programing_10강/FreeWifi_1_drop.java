package programing_10강;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FreeWifi_1_drop {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
		stmt.execute("drop table freewifi2;");//테이블 지우기
		
		stmt.close();
		conn.close();
	}
}
