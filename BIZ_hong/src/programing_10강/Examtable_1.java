package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Examtable_1 {

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		System.out.println("����̹� ȣ�� ����");
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				//("jdbc:mysql://192.168.23.96:3306/songdb","root","1234");
				("jdbc:mysql://192.168.56.102:3306/song?serverTimezone=UTC","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		System.out.println("Ŀ�ؼ� ���� ����");
		Statement stmt = conn.createStatement(); //���âȣ��

		
		//stmt.execute("drop table examtable;");//���̺� �����
		stmt.execute("create table examtable("+ //���̺� ����� �����Է�
					"name varchar(20),"+
					"studentid int not null primary key,"+
					"kor int,"+
					"eng int,"+
					"mat int)"+
					"DEFAULT CHARSET=utf8;");
		//ResultSet�� �ʿ���� ���� execute �Լ� 
		//Result Set�� �ǹ� ���� (���̺��� �ο� �Ұ� �ƴײ�) 
		//excuteQuery -> excute
		stmt.close();
		conn.close();
	}
//	���̺� �����, �������� ���α׷�ȭ �ϸ� ���ϴ�
//	Open()�� ��ŭ close() ���ϸ� ���߿� ���α׷� �ڻ쳭��

}
