package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BT2_create {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		stmt.execute("create table Student_Score("+ //���̺� ����
					"student_id int not null primary key,"+// �����̸Ӹ� Ű
					"name varchar(50),"+//
					"kor int,"+//
					"eng int,"+//
					"math int"+
					
					") DEFAULT CHARSET=utf8;");//�ѱ�ó�� ���̺��� ���־�� ��
		
		stmt.close();
		conn.close();
	}
}
