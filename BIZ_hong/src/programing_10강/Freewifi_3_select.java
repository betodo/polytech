package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Freewifi_3_select {
	//Comment : ���� ���� ����� �� ã��
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//jdbc����̹��� ȣ��(java��  db connector)
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
			
			//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
			
			Statement stmt = conn.createStatement();//���âȣ��
	/////////////////////////////////////////////////////////////////////		
			//double lat=37.3860521; double lng=127.1214038; //����ġ
			
			String QueryTxt;
//			QueryTxt = String.format("select * from freewifi "
//					+"where SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))= "
//					+"(select MIN(SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))) from freewifi);"
//					,lat,lng,lat,lng);
			//������ �Ÿ� sqrt=��Ʈ����� �Լ�/ power=�����ϴ� �Լ�
			//������ �Ÿ� ����=��Ÿ��� ���� ��Ʈ(a^2+b^2)
			//������ �Ÿ�=�ּ� ������ �Ÿ� �� row�� �˻�
		//�ǽ�2 QueryTxt = "select * from freewifi";
		//�ǽ�3	QueryTxt = "select * from freewifi where service_provider='SKT'";
			QueryTxt = "select * from freewifi where inst_country='������'";
			
	///////////////////////////////////////////////////////////////////////		
			ResultSet rset = stmt.executeQuery(QueryTxt);
			
			int iCnt=0;
			while(rset.next()) {//�ܼ�â�� ��� rset.next()�ϸ�  �� �ο쾿 ��� rset=row
								//next(n)=Į�� n��° Į���� ����
				System.out.printf("*(%d)***********************************************\n",iCnt++);
				System.out.printf("��ġ��Ҹ�     : %S\n",rset.getString(1));//��� tabled�� row�� Į��
				System.out.printf("��ġ��һ�     : %S\n",rset.getString(2));
				System.out.printf("��ġ�õ���   : %S\n",rset.getString(3));
				System.out.printf("��ġ�ñ�����   : %S\n",rset.getString(4));
				System.out.printf("��ġ�ü�����   : %S\n",rset.getString(5));
				System.out.printf("�����������   : %S\n",rset.getString(6));
				System.out.printf("��������SSID   : %S\n",rset.getString(7));
				System.out.printf("��ġ���   : %S\n",rset.getString(8));
				System.out.printf("���������θ��ּ�   : %S\n",rset.getString(9));
				System.out.printf("�������ֹ��ּ�   : %S\n",rset.getString(10));
				System.out.printf("���������   : %S\n",rset.getString(11));
				System.out.printf("���������ȭ��ȣ   : %S\n",rset.getString(12));
				System.out.printf("����   : %f\n",rset.getFloat(13));
				System.out.printf("�浵   : %f\n",rset.getFloat(14));
				System.out.printf("�����ͱ�������   : %S\n",rset.getDate(15));
				System.out.printf("*************************************************\n");
			}
			rset.close();//������ ����� �Ե��� ������ ����
			stmt.close();
			conn.close();
		}
}
