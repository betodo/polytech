import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		String[] itemName = {"��������","�ٳ�������","������","�������ֽ�","���ڿ���","�ı�ġ",
				"Ǯ����ġ��&ġ��","���ǹ���Ƽ","�������","���̱�ġ","��Ƽ�� 100��",
				"�ȵ��նѲ�","��� 1kg","�����۽� BBQ","[��귻��]���� 2L","�ø��� ¥�İ�Ƽ",
				"CJ �޹�","ũ���ؽ� 3�� 3��","���Ѷ��� 1.5L","[Ȩ��Ÿ]��Ǽ�����","���� ���ټ���",
				"��õ�� 2kg","�����ġ�ɾ� ġ��","[��귣��]������3p","���尩","�ＤǪ",
				"[��귣��]����ȣ��","������","[�Ƶ�ٽ�]���۽�Ÿ","���"};
		
		//System.out.println(itemName.length);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("����̹�ȣ�⼺��");
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.23.96:3306/stylera?serverTimezone=UTC","root","1234");
		System.out.println("Ŀ�ؼǼ���");
		
		
		String sql = "insert into tw_stock (id, name, stock_cnt, reg_day_p, reg_day_s, description, img)"
				+" values (?, ?, ?, date(now()), date(now()), ?, ?);";
		PreparedStatement pstmt = conn.prepareStatement(sql); //���âȣ��
		
		
		for(int i=0;i<itemName.length;i++) {
			pstmt.setInt(1, 1220+i);
			pstmt.setString(2, itemName[i]);
			pstmt.setString(2, itemName[i]);
			
			
		}
		
		System.out.println("���������⼺��");
		//rset.close();
		pstmt.close();
		conn.close();
	}
}
