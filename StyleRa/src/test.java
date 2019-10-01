import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String[] itemName = {"초코파이","바나나우유","건포도","오렌지주스","초코에몽","파김치",
				"풀무원치즈&치즈","스판반팔티","서울우유","얼갈이김치","물티슈 100매",
				"팔도왕뚜껑","사과 1kg","프링글스 BBQ","[노브렌드]생수 2L","올리브 짜파게티",
				"CJ 햇반","크리넥스 3겹 3롤","유한락스 1.5L","[홈스타]욕실세정용","남성 린넨셔츠",
				"이천쌀 2kg","블루충치케어 치약","[노브랜드]수세미3p","고무장갑","울샴푸",
				"[노브랜드]종이호일","샤프란","[아디다스]슈퍼스타","당근"};
		
		//System.out.println(itemName.length);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버호출성공");
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.23.96:3306/stylera?serverTimezone=UTC","root","1234");
		System.out.println("커넥션성공");
		
		
		String sql = "insert into tw_stock (id, name, stock_cnt, reg_day_p, reg_day_s, description, img)"
				+" values (?, ?, ?, date(now()), date(now()), ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql); //명령창호출
		
		
		for(int i=0;i<itemName.length;i++) {
			pstmt.setInt(1, 1220+i);
			pstmt.setString(2, itemName[i]);
			pstmt.setString(2, itemName[i]);
			
			
		}
		
		System.out.println("쿼리날리기성공");
		//rset.close();
		pstmt.close();
		conn.close();
	}
}
