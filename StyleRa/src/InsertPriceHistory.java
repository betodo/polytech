import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertPriceHistory {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.23.96:3306/stylera?serverTimezone=UTC","root","1234");
		Statement stmt = conn.createStatement(); //명령창호출
		
		
		File f=new File("C:\\Users\\admin\\Desktop\\한이음\\한이음_test_DB\\price_history.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;//한줄 먼저 읽어야--DB랑은 상관 없음
		if((readtxt=br.readLine())==null) {
			System.out.println("빈 파일입니다.");//읽었는데 없는경우
			return;
		}
		
		String[] field_name = readtxt.split(",");
		
		int LineCnt=2;
		while((readtxt=br.readLine())!=null) {
			String[] field = readtxt.split(",");
			String QueryTxt;
			
			QueryTxt = String.format("insert into price_history ("
					+"date, product_id, min_price, seller_code)"
					+"values ("
					+"'%d','%s','%d','%s');", 
					Integer.parseInt(field[0]),field[1],
					Integer.parseInt(field[2]),field[3]);
		
			stmt.execute(QueryTxt);//쿼리 날리기
			System.out.printf("%d번째 항목 Insert OK\n",LineCnt);
			//줄수 쿼리 출력
			LineCnt++;
		}
		br.close();
		
		System.out.println("완료");
			
		stmt.close();
		conn.close();
	}
}
