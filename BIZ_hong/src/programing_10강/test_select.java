package programing_10강;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test_select {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");						// DB 와 연결
		Statement stmt = conn.createStatement();		// DB 명령문을? 준비
		
		//String QueryTxt = String.format("select * from THTSKS010H00 where shrn_iscd = 'A005930';"); //삼성전자 코드 A005930
		String QueryTxt = String.format("select * from THTSKS010H00 where bsop_date = '20150112';");
		
		ResultSet rset = stmt.executeQuery(QueryTxt);	// 쿼리 전송, 데이터 받아오기
		
		int cnt = 0; //심심하니까 개수 세어보자
		
		while(rset.next()) {
			String resultText = rset.getString(1);			// 결과를 조립해서 보여주자 첫번째 필드는 그냥 넣고
			for (int i=2; i < 100; i++)	resultText = resultText + ", " + rset.getString(i);		//필드를 comma separate로 조립
			System.out.println(resultText);	//조립된 결과 출력
			cnt++;		//카운터 증가
		}
		System.out.printf("%d개의 결과 출력됨", cnt);	//개수 결과 출력
		rset.close();
		stmt.close();
		conn.close();		//연결종료
	}

}
