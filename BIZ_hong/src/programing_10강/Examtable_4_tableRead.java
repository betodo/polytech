package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Examtable_4_tableRead {
	//Comment : ��Ŭ�������� DB�� ���� ���� �⺻���� Ʋ
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc����̹��� ȣ��(java��  db connector)
		
		Connection conn = DriverManager.getConnection
				//("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
				("jdbc:mysql://192.168.56.102:3306/song","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement();//���âȣ��//java���� sql�� �������� �ʿ�
		ResultSet rset = stmt.executeQuery("select * from examtable;");
		//resultset Ŭ���� ���� ��ɹ��� ����� �޴� Ŭ����
		//select ������ executeQuery T�����
		
		System.out.println("  �̸�  �й�  ����  ����  ����");
		while(rset.next()) {//�ܼ�â�� ��� rset.next()�ϸ�  �� �ο쾿 ��� rset=row
			System.out.printf("%4s  %6d  %3d  %3d  %3d \n",rset.getString(1),
					rset.getInt(2),//rset.get��������(Į������)=Į�� ������� ����
					rset.getInt(3),
					rset.getInt(4),//������ Ÿ�� ����
					rset.getInt(5));// Į�� 1���� 5���� & 1row���� ������
		}
		rset.close();//������ ����� �Ե��� ������ ����
		stmt.close();
		conn.close();
	}

}
