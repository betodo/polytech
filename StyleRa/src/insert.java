import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String[] itemName = {"��������","�ٳ�������","������","�������ֽ�","���ڿ���","�ı�ġ",
				"ġ��&ġ�����","���ǹ���Ƽ","�������","���̱�ġ","��Ƽ�� 100��",
				"�ȵ��նѲ�","��� 1kg","�����۽� BBQ","[��귻��]���� 2L","�ø��� ¥�İ�Ƽ",
				"CJ �޹�","ũ���ؽ� 3�� 3��","���Ѷ��� 1.5L","[Ȩ��Ÿ]��Ǽ�����","���� ���ټ���",
				"��õ�� 2kg","�����ġ�ɾ� ġ��","[��귣��]������3p","���尩","�ＤǪ",
				"[��귣��]����ȣ��","������","[�Ƶ�ٽ�]���۽�Ÿ","���"}; //
		
		//System.out.println(itemName.length);
		
		String[] itemImg = {"chcopi","bananamilk","gunpodo","orangejuice","chocoemong","pakimchi","pulmuwon","spanT","seoulmilk",
				"ulkimchi","watertisue","paldowang","apple","pringles","��","¥�İ�Ƽ","�޹�","ũ���ؽ�","¥�İ�Ƽ","�޹�","ũ���ؽ�",
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
		System.out.println("����̹�ȣ�⼺��");

		String ip = "192.168.56.102";
        String port = ":3306/";
        String dbname = "song?useSSL=false";
        String dbID = "root";
        String dbPW = "1234";

        //Ŀ�ؼ�
        Connection conn;
        conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + dbname, dbID, dbPW);
        System.out.println("Ŀ�ؼ� ���� ����");
		
		String sql = "insert into tw_stock (name, stock_cnt, reg_day_p, reg_day_s, description, img)"
				+" values (?, ?, date(now()), date(now()), ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql); //���âȣ��
		
		String x ="";
		for(int k = 1; k <= 7; k++) {
			for(int i=0;i<itemName.length;i++) {
				pstmt.setString(1, itemName[i]);
				pstmt.setInt(2,(int)(Math.random()*100));
				x =String.format("��ǰ ���� %d", i+1);
				pstmt.setString(3,x);
				pstmt.setString(4,imgJPG[i]);
				pstmt.executeUpdate();
			}
		}
		
//		String sql = "delete from tw_stock";
//		PreparedStatement pstmt = conn.prepareStatement(sql); //���âȣ��
//		pstmt.executeUpdate();
		
		
		System.out.println("���������⼺��");
		//rset.close();
		pstmt.close();
		conn.close();
	}
	
	
}
