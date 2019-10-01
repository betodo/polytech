package programing_10강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test01 {
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		File f = new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습"
//				+ "\\StockDailyPrice.csv"); //dat=DB를 덤프받은 파일
//		BufferedReader br = new BufferedReader(new FileReader(f));
//		
//		String readtxt;
//		int LineCnt =0;
//		
//		
//		
//		while ((readtxt = br.readLine()) != null) {
//			StringBuffer s = new StringBuffer();
//			String[] field = readtxt.split(",");
//			
//			System.out.println(LineCnt+" : "+field.length);
//			
//			LineCnt++;
//		}
//		
//		br.close();
//		
//	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement();//명령창호출

		
		String QueryTxt;

		QueryTxt = "select count(*) from Student_Score";
		
	
		ResultSet rset = stmt.executeQuery(QueryTxt);
		
		int cnt=0;
		while(rset.next()) {//콘솔창에 출력 rset.next()하면  한 로우씩 출력 rset=row
							//next(n)=칼럼 n번째 칼럼을 말함
		
			System.out.printf("%S\n",rset.getString(2));//결과 tabled의 row와 칼럼
			
		
		}
		rset.close();//데이터 안잡아 먹도록 쓰고나면 닫자
		stmt.close();
		conn.close();
	}
	
}
