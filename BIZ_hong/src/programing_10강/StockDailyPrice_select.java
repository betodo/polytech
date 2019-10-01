package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StockDailyPrice_select {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");//db와 연결
		Statement stmt = conn.createStatement();//명령창호출

		String QueryTxt;//쿼리문 만들기
		QueryTxt = String.format("select * from StockDailyPrice "
				+ "where bsop_date like '2015%%' and shrn_iscd = 'A005930';");
		
		ResultSet rset = stmt.executeQuery(QueryTxt);
		
		int cnt =0;
		while(rset.next()==true) {//한줄한줄 읽기 더이상 읽을게 없을 때가지
			String printRow="";//데이터 한줄 출력할 변수 선언
			
				for ( int i=1; i<100;i++) {//컬럼 총 99개
					try {
						printRow = printRow + " " + rset.getString(i);//컬럼이 문자일때
					}catch (Exception e) {
						printRow = printRow + " " + rset.getInt(i);//컬럼이 숫자일때
					}

				}
			System.out.println(printRow);//조립한 row출력		
			cnt++;
		}
		System.out.println(cnt+" row출력");
		
		rset.close();
		stmt.close();
		conn.close();
		
	}
}
