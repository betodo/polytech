package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest_jdbc�⺻���α׷� {
	//Comment : ��Ŭ�������� DB�� ���� ���� �⺻���� Ʋ
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		//34.~db�� �ִ� �� ip(���� ����� ���� �ּ�),������ȿ��� ������ ��Ʈ3306, songdb=db�̸�,root=db�����,m2~db����� ��й�ȣ
		Statement stmt = conn.createStatement();//��ɾ�â ���� ������δ� bash���α׷� �Ҿ���� ����
		ResultSet rset = stmt.executeQuery("select * from Student_Score;");//��ɾ�â�� sql�� ���� ������
		
		while(rset.next()) {//�ܼ�â�� ��� rset.next()�ϸ�  �� �ο쾿 ��� rset=row
			System.out.println("�� : "+rset.getString(1));//1row���� ������
		}
		rset.close();//������ ����� �Ե��� ������ ����
		stmt.close();//�ݴ� ���� �� �����
		conn.close();
		
	}

}
