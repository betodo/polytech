package programing_10��;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test_select {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");						// DB �� ����
		Statement stmt = conn.createStatement();		// DB ��ɹ���? �غ�
		
		//String QueryTxt = String.format("select * from THTSKS010H00 where shrn_iscd = 'A005930';"); //�Ｚ���� �ڵ� A005930
		String QueryTxt = String.format("select * from THTSKS010H00 where bsop_date = '20150112';");
		
		ResultSet rset = stmt.executeQuery(QueryTxt);	// ���� ����, ������ �޾ƿ���
		
		int cnt = 0; //�ɽ��ϴϱ� ���� �����
		
		while(rset.next()) {
			String resultText = rset.getString(1);			// ����� �����ؼ� �������� ù��° �ʵ�� �׳� �ְ�
			for (int i=2; i < 100; i++)	resultText = resultText + ", " + rset.getString(i);		//�ʵ带 comma separate�� ����
			System.out.println(resultText);	//������ ��� ���
			cnt++;		//ī���� ����
		}
		System.out.printf("%d���� ��� ��µ�", cnt);	//���� ��� ���
		rset.close();
		stmt.close();
		conn.close();		//��������
	}

}
