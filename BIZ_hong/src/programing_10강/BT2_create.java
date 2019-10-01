package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BT2_create {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
		stmt.execute("create table Student_Score("+ //테이블 생성
					"student_id int not null primary key,"+// 프라이머리 키
					"name varchar(50),"+//
					"kor int,"+//
					"eng int,"+//
					"math int"+
					
					") DEFAULT CHARSET=utf8;");//한글처리 테이블마다 해주어야 함
		
		stmt.close();
		conn.close();
	}
}
