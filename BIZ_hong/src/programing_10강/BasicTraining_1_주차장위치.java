package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicTraining_1_��������ġ {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","m21234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		stmt.execute("create table examtable("+ //���̺� ����� �����Է�
					"������_���� varchar(20) not null primary key,"+
					"������� varchar(40),"+
					"������_���� varchar(10),"+
					"������_���� int,"+
					"���������� int,�������ֺ� varchar)"+
					"DEFAULT CHARSET=utf8;");
		
		stmt.close();
		conn.close();
	}
}
