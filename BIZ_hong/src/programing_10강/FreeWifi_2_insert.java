package programing_10��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FreeWifi_2_insert {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/song?serverTimezone=UTC","root","1234");
//				("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
//		File f=new File("C:\\Users\\kopo\\Desktop\\���������������ǥ�ص�����.txt");
		File f=new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;//���� ���� �о��--DB���� ��� ����
		if((readtxt=br.readLine())==null) {
			System.out.println("�� �����Դϴ�.");//�о��µ� ���°��
			return;
		}
		
		String[] field_name = readtxt.split("\t");//������ �и��� ù��
		
		int LineCnt=0;
		while((readtxt=br.readLine())!=null) {
			String[] field = readtxt.split("\t");//������ �и��� ���� �ٷ�
			String QueryTxt;
			//
			//������ ��� �ٷ�� ���α׷��� �������� �ִٸ� �밡���� ���� ����
			//�Ʒ����� ��� ���ļ� ������ �� �� �� �ְ� �Ѱ��� ������
			//���α׷� ������ �°� ��� ���� �ʿ�
			//���� ������� �ټ����� ���ٿ�
			//%s �C����ǥ �ѰͰ� ���� ���� ���̴�?
			
			if(field[7].trim().length()==0) field[7]="0000-01-01";
			//field[7]�� ���鹮�ڰ� �ִ�. ���鹮�ڰ� ������ date�� �����Ͱ� ������
			//if������ ���� ���鹮�ڰ� ������ ó��
			//trim���� ������ ¥�� null�� ������ isEmpty�������� length=0���� ��ƾ� ����
			
			QueryTxt = String.format("insert into freewifi ("//���̺� Į���� //��Ʈ�� ����� ������
//			QueryTxt = String.format("insert into freewifi2 ("//���̺� Į���� //��Ʈ�� ����� ������
					+"place_no,inst_place,inst_place_detail,inst_city,inst_country,inst_place_flag,"
					+"service_provider,wifi_ssid,inst_date,place_addr_road,place_addr_land,"
					+"manage_office,manage_office_phone,latitude,longitude,write_date)"
					+"values ("//Į���� �� ����
					+"'%d','%s','%s','%s','%s','%s',"//���� ����ǥ�� ������ ������
					+"'%s','%s','%s','%s','%s'," //���̺� ���鶧 �� varchar�� �ؼ�
					+"'%s','%s','%s','%s','%s');", 
					LineCnt,field[0],field[1],field[2],field[3],field[4],//�ε����� �ϳ� �־
					field[5],field[6],field[7],field[8],field[9],
					field[10],field[11],field[12],field[13],field[14]);//field �ϳ��ϳ� �Է�
		
			stmt.execute(QueryTxt);//���� ������
			System.out.printf("%d��° �׸� Insert OK [%s]\n",LineCnt,QueryTxt);
			//�ټ� ���� ���
			LineCnt++;
		}
		br.close();
		
		stmt.close();
		conn.close();
	}
}
