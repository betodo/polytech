package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Examtable_1 {

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		System.out.println("드라이버 호출 성공");
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				//("jdbc:mysql://192.168.23.96:3306/songdb","root","1234");
				("jdbc:mysql://192.168.56.102:3306/song?serverTimezone=UTC","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		System.out.println("커넥션 연결 성공");
		Statement stmt = conn.createStatement(); //명령창호출

		
		//stmt.execute("drop table examtable;");//테이블 지우기
		stmt.execute("create table examtable("+ //테이블 만드는 쿼리입력
					"name varchar(20),"+
					"studentid int not null primary key,"+
					"kor int,"+
					"eng int,"+
					"mat int)"+
					"DEFAULT CHARSET=utf8;");
		//ResultSet이 필요없는 경우는 execute 함수 
		//Result Set이 의미 없음 (테이블의 로우 불게 아닝께) 
		//excuteQuery -> excute
		stmt.close();
		conn.close();
	}
//	테이블 만들기, 지우기등을 프로그램화 하면 편하다
//	Open()한 만큼 close() 안하면 나중에 프로그램 박살난다

}
