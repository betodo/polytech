import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertProduct {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.23.96:3306/stylera?serverTimezone=UTC","root","1234");
		Statement stmt = conn.createStatement(); //����âȣ��
		
		
		File f=new File("C:\\Users\\admin\\Desktop\\������\\������_test_DB\\product.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;//���� ���� �о��--DB���� ��� ����
		if((readtxt=br.readLine())==null) {
			System.out.println("�� �����Դϴ�.");//�о��µ� ���°��
			return;
		}
		
		String[] field_name = readtxt.split(",");
		
		int LineCnt=2;
		while((readtxt=br.readLine())!=null) {
			String[] field = readtxt.split(",");
			String QueryTxt;
			
			QueryTxt = String.format("insert into product ("
					+"product_id, product_code, product_name, "
					+"brand_code, brand_name, category_code, category_name)"
					+"values ("
					+"'%s','%s','%s','%s','%s','%s','%s');", 
					field[0],field[1],field[2],field[3],field[4],field[5],field[6]);
		
			stmt.execute(QueryTxt);//���� ������
			System.out.printf("%d��° �׸� Insert OK\n",LineCnt);
			//�ټ� ���� ���
			LineCnt++;
		}
		br.close();
		
		System.out.println("�Ϸ�");
			
		stmt.close();
		conn.close();
	}
}