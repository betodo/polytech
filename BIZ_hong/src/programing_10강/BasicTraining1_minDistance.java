package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicTraining1_minDistance {
	//Comment : ���� ���� ����� �� ã��
			public static void main(String[] args) throws ClassNotFoundException, SQLException {
				// TODO Auto-generated method stub
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				//jdbc����̹��� ȣ��(java��  db connector)
				Connection conn = DriverManager.getConnection
						("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
				//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
				
				Statement stmt = conn.createStatement();//���âȣ��
				
		/////////////////////////////////////////////////////////////////////		
				double lat=37.3860521; double lng=127.1214038; //����ġ
				
				String QueryTxt;
				QueryTxt = String.format("select * from Children_Protection_Zone "
						+"where SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))= "
						+"(select MIN(SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))) from Children_Protection_Zone);"
						,lat,lng,lat,lng);
				//������ �Ÿ� sqrt=��Ʈ����� �Լ�/ power=�����ϴ� �Լ�
				//������ �Ÿ� ����=��Ÿ��� ���� ��Ʈ(a^2+b^2)
				//������ �Ÿ�=�ּ� ������ �Ÿ� �� row�� �˻�
		///////////////////////////////////////////////////////////////////////	
				
				ResultSet rset = stmt.executeQuery(QueryTxt);
				
				int iCnt=0;
				while(rset.next()) {//�ܼ�â�� ��� rset.next()�ϸ�  �� �ο쾿 ��� rset=row
									//next(n)=Į�� n��° Į���� ����
					System.out.printf("*(%d)***********************************************\n",iCnt++);
					System.out.printf("�ü�����       : %S\n",rset.getString(1));//��� tabled�� row�� Į��
					System.out.printf("���ü���     : %S\n",rset.getString(2));
					System.out.printf("���������θ��ּ�: %S\n",rset.getString(3));
					System.out.printf("�����������ּ�  : %S\n",rset.getString(4));
					System.out.printf("����           : %f\n",rset.getDouble(5));
					System.out.printf("�浵           : %f\n",rset.getDouble(6));//�������� ����
					System.out.printf("���������     : %S\n",rset.getString(7));
					System.out.printf("���Ұ�������   : %S\n",rset.getString(8));
					System.out.printf("CCTV��ġ����   : %S\n",rset.getString(9));
					System.out.printf("CCTV��ġ����   : %S\n",rset.getString(10));
					System.out.printf("��ȣ���������� : %S\n",rset.getString(11));
					System.out.printf("�����ͱ������� : %S\n",rset.getDate(12));//�������� ����					
					System.out.printf("*************************************************\n");
				}
				rset.close();//������ ����� �Ե��� ������ ����
				stmt.close();
				conn.close();
			}
}
