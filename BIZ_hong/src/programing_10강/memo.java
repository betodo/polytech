package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class memo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement();//���âȣ��
		ResultSet rset = stmt.executeQuery("select * from Children_Protection_Zone;");
		
		int c =0;
		while(rset.next()) {//�ܼ�â�� ��� rset.next()�ϸ�  �� �ο쾿 ��� rset=row
			System.out.printf("%d  %s  %s  %s  %s\n",c,rset.getString(1),
					rset.getString(2),
					rset.getString(3),
					rset.getString(4)//������ Ÿ�� ����
					);// Į�� 1���� 5���� & 1row���� ������
			c++;
		}
		rset.close();//������ ����� �Ե��� ������ ����
		stmt.close();
		conn.close();
	}
}
