package programing_10��;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FreeWifi_1_drop {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		stmt.execute("drop table freewifi2;");//���̺� �����
		
		stmt.close();
		conn.close();
	}
}
