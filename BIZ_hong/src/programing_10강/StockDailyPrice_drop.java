package programing_10��;

import java.sql.*;

public class StockDailyPrice_drop {
	public static void main(String[] args) 
			throws Throwable {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		stmt.execute("drop table StockDailyPrice;");//���̺� �����
		
		stmt.close();
		conn.close();
	}
}
