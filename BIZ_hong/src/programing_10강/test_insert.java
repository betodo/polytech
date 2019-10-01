package programing_10��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class test_insert {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");						// DB �� ����
		Statement stmt = conn.createStatement();		// DB ��ɹ���? �غ�
		
		File f = new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));	//���� ����
		int cnt = 0; //������ ī��Ʈ
		String readtxt;
		
		conn.setAutoCommit(false);		// ����Ŀ�Ա���� ���� ���� �������
		
		while((readtxt= br.readLine()) != null) {		//������ ������ �д� ����
			StringBuffer s = new StringBuffer();		// ���پ� �о sql������ �ִ´�. ���ۼ���
			s.append("insert into THTSKS010H00 values ('");	//sql�� �ʹݺ�
			String[] field = readtxt.split("%_%");		//�����ڸ� %_% �� ��� �ʵ� ����
			//������ ���� �� ���ϴ� �ʵ� ����
			if(field.length <3) continue;			//�ʵ尡 ���� ���� continue�� �н��Ѵ�
			s.append(field[0].replace("^",  "'").trim());	//������ ��ü
			for (int j=1; j< field.length; j++) {			//�ʵ� ������
				if (field[j].replace("^",  "").trim().length() == 0) {
					s.append("," + "null");		//������ �����ϰ� �ʵ尪�� ���� �� null�� �ִ´�
				} else {
					try {	//����üũ try~catch�� ���� ���� �Ǻ�
						Integer.parseInt(field[j].replace("^",  "").trim());	//���ں�ȯ�ؼ� ������ �ȶ߸�
						s.append("," + field[j].replace("^",  "").trim());		//�����ڸ� �����ؼ� ����
								//^ ���� �� ���ۿ� �߰�
					} catch (Exception e) {						//���ں�ȯ�� ������ �߸�(���ڿ��� �������?)
						s.append("," + field[j].replace("^",  "'").trim());		//�����ڸ� '�� ��ü�ؼ� ����
					}
				}
			}
			s.append(");");		// sql�� ���� ����
			
			stmt.addBatch(s.toString());		//��ġ�� ���� �������ٰ� �Ѵ�..
			if(cnt % 10000 == 0) {				//10000�� ����
				stmt.executeBatch();			//��ġ�� �� ����
				System.out.println(cnt + " row inserted");	//Ȯ�ο� ���� ���
				conn.commit();				//Ŀ�����ش�
			}
			cnt++;		//ī��Ʈ
			//stmt.execute(s.toString());	//��ġ���� ���� ����
		}
		stmt.executeBatch();		//while�� ������ 10000�̸��� row�� ó���� ���� ��ġ���� �ѹ���
		System.out.printf("�Ϸ�Ǿ����ϴ�.\n");
		conn.commit();			//Ŀ�Ե� �ѹ���
		conn.setAutoCommit(true);		//����Ŀ�� �ٽ� �������ش�
		
		br.close();
		stmt.close();
		conn.close();		//��
	}

}


