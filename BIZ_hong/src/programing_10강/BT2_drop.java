package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BT2_drop {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				//("jdbc:mysql://192.168.23.96:3306/songdb","root","1234"); ����
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		stmt.execute("drop table Student_Score;");//���̺� �����
		
		stmt.close();
		conn.close();
	}
}
