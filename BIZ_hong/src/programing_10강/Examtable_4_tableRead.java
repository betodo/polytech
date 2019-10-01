package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Examtable_4_tableRead {
	//Comment : 이클립스에서 DB를 쓰는 가장 기본적인 틀
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc드라이버를 호출(java와  db connector)
		
		Connection conn = DriverManager.getConnection
				//("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
				("jdbc:mysql://192.168.56.102:3306/song","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement();//명령창호출//java에서 sql문 날리려면 필요
		ResultSet rset = stmt.executeQuery("select * from examtable;");
		//resultset 클래스 쿼리 명령문의 결과를 받는 클래스
		//select 날릴땐 executeQuery T써야함
		
		System.out.println("  이름  학번  국어  영어  수학");
		while(rset.next()) {//콘솔창에 출력 rset.next()하면  한 로우씩 출력 rset=row
			System.out.printf("%4s  %6d  %3d  %3d  %3d \n",rset.getString(1),
					rset.getInt(2),//rset.get데이터형(칼럼숫자)=칼럼 결과값을 받음
					rset.getInt(3),
					rset.getInt(4),//데이터 타입 조심
					rset.getInt(5));// 칼럼 1부터 5까지 & 1row부터 끝까지
		}
		rset.close();//데이터 안잡아 먹도록 쓰고나면 닫자
		stmt.close();
		conn.close();
	}

}
