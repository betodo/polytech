package programing_10��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test01 {
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//
//		File f = new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�"
//				+ "\\StockDailyPrice.csv"); //dat=DB�� �������� ����
//		BufferedReader br = new BufferedReader(new FileReader(f));
//		
//		String readtxt;
//		int LineCnt =0;
//		
//		
//		
//		while ((readtxt = br.readLine()) != null) {
//			StringBuffer s = new StringBuffer();
//			String[] field = readtxt.split(",");
//			
//			System.out.println(LineCnt+" : "+field.length);
//			
//			LineCnt++;
//		}
//		
//		br.close();
//		
//	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement();//���âȣ��

		
		String QueryTxt;

		QueryTxt = "select count(*) from Student_Score";
		
	
		ResultSet rset = stmt.executeQuery(QueryTxt);
		
		int cnt=0;
		while(rset.next()) {//�ܼ�â�� ��� rset.next()�ϸ�  �� �ο쾿 ��� rset=row
							//next(n)=Į�� n��° Į���� ����
		
			System.out.printf("%S\n",rset.getString(2));//��� tabled�� row�� Į��
			
		
		}
		rset.close();//������ ����� �Ե��� ������ ����
		stmt.close();
		conn.close();
	}
	
}
