package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BascicTraining1_create {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		stmt.execute("create table Children_Protection_Zone("+ //���̺� ����
					"facility_kind varchar(50) ,"+//�ü�����
					"facility_name varchar(200),"+//���ü���
					"place_addr_road varchar(300),"+//���������θ��ּ�
					"place_addr_land varchar(300),"+//�����������ּ�
					"latitude double not null,"+//����
					"longitude double not null,"+//�浵
					"manage_office varchar(100),"+//���������
					"manage_police_office varchar(100),"+//���Ұ�������
					"CCTV_check varchar(10),"+//CCTV��ġ����
					"CCTV_num varchar(10),"+//CCTV��ġ����
					"protection_road_width varchar(50),"+//��ȣ����������
					"write_date date"+//�����ͱ�������
					
					//"PRIMARY KEY(latitude,longitude)"+//���������̸Ӹ�Ű �ִ� ���� mysql
					") DEFAULT CHARSET=utf8;");//�ѱ�ó�� ���̺��� ���־�� ��
		
		stmt.close();
		conn.close();
	}
}
