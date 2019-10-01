package programing_10��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class StockDailyPrice_insert {
	// ���Ͽ��� �뷮�� data �����Ͽ� db�� �ֱ� (�����۹�, ��ġ ���)
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");// jdbc����̹��� ȣ��(=java�� db connector)
		//JDBC�� ���ؼ� *IP�� �����ϴ� DB�� 3306��Ʈ�� ���Ͽ� ����, ID�� PASSWD ���� �����־ ���� �ȴ�
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/songdb", "root", "1234");
		// Ŀ�ؼ� ���� ��ġ ���� �� db�� ����
		Statement stmt = conn.createStatement(); //DB�� ���â ȣ��(�������� ����ϱ� ���� Statement���)
		
		//���� ���� ���� FileŬ���� ���
		File f = new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�\\THTSKS010H00.dat");
		//���� ���� ������ ���۸����� ���
		BufferedReader br = new BufferedReader(new FileReader(f));

		int LineCnt = 1;//������ �����Ͱ� ������ �� ����
		String readtxt;//�ο� ������ �б� ���� ��������

		conn.setAutoCommit(false);//(sql�� �ϳ��ϳ� ����)�ڵ�Ŀ��off=�����ӵ��� ������ �ֱ�=Ŀ��Ƚ�� �ٿ���
		while ((readtxt = br.readLine()) != null) { // ���̻� ���� ���� ���� ������ �ݺ�
			
			StringBuffer s = new StringBuffer();//sql���� �ѹ��� ���� �׸����� ���
			s.append("insert into abc value('");//sql���� append�� �׸��� ����(,)��� ����!
			
			String[] field = readtxt.split("%_%");// �����ڸ� �����Ͽ� �ʵ忡 ����
			if(field.length<3) continue;//������ ����� �ʵ尡 ª�� �ǹ� ���� ���� ����
										//�װ� �Ѱ� ����
			
			//�ڿ��� �ݺ������� sql���� �����ϱ� ���� ù�ʵ常 ���� �־���(, �̰� ���̴°� ����)
			//mysql���� ���ڴ� '����' �̱������̼����� ���ξ��ϱ� ������ replace
			s.append(field[0].replace("^",  "'").trim());
			
			for (int i = 1; i < field.length; i++) {//�ʵ� ���� ��ŭ sql�� ����
				if (field[i].replace("^",  "").trim().length() == 0) {//�ʵ尡 null�̸�
					s.append("," + "null");//�ΰ��Է� ���ھƴ�
				} else { //�ʵ尡 null�� �ƴϸ�
					try {//�ʵ带 ���ڷ� ��ȯ������ ���� �ȳ��� ' �̱����� �� ����
						Integer.parseInt(field[i].replace("^",  "").trim());
						s.append("," + field[i].replace("^",  "").trim());
						
					}catch(Exception e) {//�ʵ� ���� ��ȯ �������� ���ڴϱ� �̱����� ����
						s.append("," +field[i].replace("^",  "'").trim());
					}	
				}
			}
			s.append(");");//�ǵ��� sql�� �����ؼ� sql�� �ϼ� 

			//addBatch=�������� sql���� �Ѳ����� �����Ҷ� ����ϴ� �׸�
			stmt.addBatch(s.toString());//�ϼ��� sql���� ��Ʈ������ add��ġ�� ����
			
			if (LineCnt % 10000 == 0) {
				stmt.executeBatch();//�������� row�� sql���� ������=�������� sql���� ����ִ�
				System.out.println(LineCnt + "row���� insert & commit �Ϸ�");//insertȮ�ο�
				conn.commit();//������ row���� Ŀ�Զ����ֱ�
			}
			
			LineCnt++; //���� �۾��� ������ �� ī��Ʈ�� �÷��ش�
			
		}
		stmt.executeBatch(); //�������� ���� sql���� ���� 
		conn.commit();//sql�� ���� ���������ϱ� Ŀ������
		conn.setAutoCommit(true);// ������ ���� Ŀ�Ե� ���ش�

		System.out.println("���� �Ϸ�Ǿ����ϴ�.");//�����Ϸ� Ȯ��

		br.close();//������ �������� �ݴ´�
		stmt.close();
		conn.close();
	
	}

}
