package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StockDailyPrice_select {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");//db�� ����
		Statement stmt = conn.createStatement();//���âȣ��

		String QueryTxt;//������ �����
		QueryTxt = String.format("select * from StockDailyPrice "
				+ "where bsop_date like '2015%%' and shrn_iscd = 'A005930';");
		
		ResultSet rset = stmt.executeQuery(QueryTxt);
		
		int cnt =0;
		while(rset.next()==true) {//�������� �б� ���̻� ������ ���� ������
			String printRow="";//������ ���� ����� ���� ����
			
				for ( int i=1; i<100;i++) {//�÷� �� 99��
					try {
						printRow = printRow + " " + rset.getString(i);//�÷��� �����϶�
					}catch (Exception e) {
						printRow = printRow + " " + rset.getInt(i);//�÷��� �����϶�
					}

				}
			System.out.println(printRow);//������ row���		
			cnt++;
		}
		System.out.println(cnt+" row���");
		
		rset.close();
		stmt.close();
		conn.close();
		
	}
}
