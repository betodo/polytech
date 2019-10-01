package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest_jdbc기본프로그램 {
	//Comment : 이클립스에서 DB를 쓰는 가장 기본적인 틀
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");//커넥션 놓는 위치 설정 즉   db와 연결
		//34.~db가 있는 곳 ip(나의 우분투 접속 주소),우분투안에서 연결할 포트3306, songdb=db이름,root=db사용자,m2~db사용자 비밀번호
		Statement stmt = conn.createStatement();//명령어창 생성 우분투로는 bash프로그램 불어오는 느낌
		ResultSet rset = stmt.executeQuery("select * from Student_Score;");//명령어창에 sql문 쿼리 날리기
		
		while(rset.next()) {//콘솔창에 출력 rset.next()하면  한 로우씩 출력 rset=row
			System.out.println("값 : "+rset.getString(1));//1row부터 끝까지
		}
		rset.close();//데이터 안잡아 먹도록 쓰고나면 닫자
		stmt.close();//닫는 순서 잘 맞춰라
		conn.close();
		
	}

}
