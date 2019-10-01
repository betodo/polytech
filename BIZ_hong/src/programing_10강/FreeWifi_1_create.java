package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FreeWifi_1_create {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/song?serverTimezone=UTC","root","1234");
//				("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
//		stmt.execute("create table freewifi2("+ //freewifi�� ���̺� ����
		stmt.execute("create table freewifi("+ //freewifi�� ���̺� ����
					"place_no int not null,"+	
				//���� �����̸Ӹ�Ű�� �ֱ� ���� Į���� �ϳ� ����(like�Ϸù�ȣ)
					"inst_place varchar(50) ,"+//��ġ��� 
					"inst_place_detail varchar(200),"+//��ġ��һ�
					"inst_city varchar(50),"+//��ġ�õ���
					"inst_country varchar(50),"+//��ġ�ñ�����
					"inst_place_flag varchar(50),"+//��ġ�ü�����
					"service_provider varchar(50),"+//�����������
					"wifi_ssid varchar(200),"+//��������ssid
					"inst_date date,"+//��ġ��� //date�� ����
					"place_addr_road varchar(300),"+//���������θ��ּ�
					"place_addr_land varchar(200),"+//�����������ּ�
					"manage_office varchar(50),"+//���������
					"manage_office_phone varchar(50),"+//���������ȭ��ȣ
					"latitude double,"+//����
					"longitude double,"+//�浵
					"write_date date,"+//�����ͱ�������
					"PRIMARY KEY(place_no,inst_place)"+//���������̸Ӹ�Ű �ִ� ���� mysql
					") DEFAULT CHARSET=utf8;");//�ѱ�ó�� ���̺��� ���־�� ��
		
		stmt.close();
		conn.close();
	}
}
