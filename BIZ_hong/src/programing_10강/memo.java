package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class memo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement();//명령창호출
		ResultSet rset = stmt.executeQuery("select * from Children_Protection_Zone;");
		
		int c =0;
		while(rset.next()) {//콘솔창에 출력 rset.next()하면  한 로우씩 출력 rset=row
			System.out.printf("%d  %s  %s  %s  %s\n",c,rset.getString(1),
					rset.getString(2),
					rset.getString(3),
					rset.getString(4)//데이터 타입 조심
					);// 칼럼 1부터 5까지 & 1row부터 끝까지
			c++;
		}
		rset.close();//데이터 안잡아 먹도록 쓰고나면 닫자
		stmt.close();
		conn.close();
	}
}
