package programing_10��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicTraining1_insert {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		File f=new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�\\"
				+ "����Ư����_���빮��_��̺�ȣ����_20180807.txt");
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
			
			QueryTxt = String.format("insert into Children_Protection_Zone ("//���̺�
					+"facility_kind,facility_name,place_addr_road,place_addr_land,"//Į����
					+"latitude,longitude,manage_office,manage_police_office,"
					+ "CCTV_check,CCTV_num,protection_road_width,write_date)"
					+"values ("//Į���� �� ����"
					+"'%s','%s','%s','%s',"
					+"'%s','%s','%s','%s',"//���� ����ǥ�� ������ ������
					+"'%s','%s','%s','%s');", 
					field[0],field[1],field[2],field[3],
					field[4],field[5],field[6],field[7],
					field[8],field[9],field[10],field[11]);//field �ϳ��ϳ� �Է�
		
			stmt.execute(QueryTxt);//���� ������
			System.out.printf("%d��° �׸� Insert OK [%s]\n",LineCnt,QueryTxt.substring(0, 7));
			//�ټ� ���� ���
			LineCnt++;
		}
		br.close();
		
		stmt.close();
		conn.close();
	}
}
