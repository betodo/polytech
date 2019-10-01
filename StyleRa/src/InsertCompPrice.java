import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCompPrice {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.23.96:3306/stylera?serverTimezone=UTC","root","1234");
		Statement stmt = conn.createStatement(); //명령창호출
		
		
		File f=new File("C:\\Users\\admin\\Desktop\\한이음\\한이음_test_DB\\comp_price.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;//한줄 먼저 읽어야--DB랑은 상관 없음
		if((readtxt=br.readLine())==null) {
			System.out.println("빈 파일입니다.");//읽었는데 없는경우
			return;
		}
		
		String[] field_name = readtxt.split(",");
		
		int LineCnt=0;
		while((readtxt=br.readLine())!=null) {
			String[] field = readtxt.split(",");
			String QueryTxt;
			
			QueryTxt = String.format("insert into comp_price ("
					+"product_id, seller_code, price, s_product_name, photo, stock)"
					+"values ("
					+"'%s','%s','%d','%s','%s','%d');", 
					field[0],field[1],Integer.parseInt(field[2]),
					field[3],field[4],Integer.parseInt(field[5]));
		
			stmt.execute(QueryTxt);//쿼리 날리기
			System.out.printf("%d번째 항목 Insert OK [%s]\n",LineCnt,QueryTxt);
			//줄수 쿼리 출력
			LineCnt++;
		}
		br.close();
		
		System.out.println("완료");
		
//		ResultSet rset = stmt.executeQuery("show tables;");
//		while(rset.next()) {
//			System.out.println(rset.getString(1));
//		}
//		rset.close();
		
		stmt.close();
		conn.close();
	}
}
