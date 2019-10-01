import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String[] itemName = {"초코파이","바나나우유","건포도","오렌지주스","초코에몽","파김치",
				"치즈&치즈떡볶이","스판반팔티","서울우유","얼갈이김치","물티슈 100매",
				"팔도왕뚜껑","사과 1kg","프링글스 BBQ","[노브렌드]생수 2L","올리브 짜파게티",
				"CJ 햇반","크리넥스 3겹 3롤","유한락스 1.5L","[홈스타]욕실세정용","남성 린넨셔츠",
				"이천쌀 2kg","블루충치케어 치약","[노브랜드]수세미3p","고무장갑","울샴푸",
				"[노브랜드]종이호일","샤프란","[아디다스]슈퍼스타","당근"}; //
		
		//System.out.println(itemName.length);
		
		String[] itemImg = {"chcopi","bananamilk","gunpodo","orangejuice","chocoemong","pakimchi","pulmuwon","spanT","seoulmilk",
				"ulkimchi","watertisue","paldowang","apple","pringles","물","짜파게티","햇반","크리넥스","짜파게티","햇반","크리넥스",
				"chcopi","gunpodo","orangejuice","chocoemong","pakimchi","pulmuwon","spanT","seoulmilk",
				"ulkimchi"};
		String[] imgJPG = new String[30];
		
		for( int i =0; i<itemImg.length;i++) {
			//imgJPG[i] = (itemImg[i] + ".jpg");
			imgJPG[i] = ( "upload_imgs/" + itemImg[i] + ".jpg");
			System.out.println(imgJPG[i]);
		}
		

		System.out.println(itemImg.length);
		System.out.println(itemName.length);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("드라이버호출성공");

		String ip = "192.168.56.102";
        String port = ":3306/";
        String dbname = "song?useSSL=false";
        String dbID = "root";
        String dbPW = "1234";

        //커넥션
        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + dbname, dbID, dbPW);
        System.out.println("커넥션 연결 성공");
		
		String sql = "insert into tw_stock (name, stock_cnt, reg_day_p, reg_day_s, description, img)"
				+" values (?, ?, date(now()), date(now()), ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql); //명령창호출
		
		String x ="";
		for(int k = 1; k <= 7; k++) {
			for(int i=0;i<itemName.length;i++) {
				pstmt.setString(1, itemName[i]);
				pstmt.setInt(2,(int)(Math.random()*100));
				x =String.format("제품 설명 %d", i+1);
				pstmt.setString(3,x);
				pstmt.setString(4,imgJPG[i]);
				pstmt.executeUpdate();
			}
		}
		
//		String sql = "delete from tw_stock";
//		PreparedStatement pstmt = conn.prepareStatement(sql); //명령창호출
//		pstmt.executeUpdate();
		
		
		System.out.println("쿼리날리기성공");
		//rset.close();
		pstmt.close();
		conn.close();
	}
	
	
}
