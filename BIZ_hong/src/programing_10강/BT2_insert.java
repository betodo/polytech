package programing_10��;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BT2_insert {
	
	static int student_id;//�Է��� ����(������)
	static String name;
	static int kor;
	static int eng;
	static int math;
	
	static Connection conn = null;  //�������̽� ����
	static Statement stmt = null;	//���� �޼ҵ忡 ���
	static ResultSet rset = null;
	
	static String queryTxt;
	
	static int iPerson =1000; // ��ü �����
	static final int pagePer=30;//���������� ���� �����
	static int page=1;//������ ��ȣ
	
	static int lastPagePer=0;//�������������� ���� �����


	
	static void dataSet(int i) throws SQLException { //������ ���� �޼���
		
			student_id = i+1;
			name = String.format("ȫ�浿%04d", i+1);//�̸������
			kor=(int)(Math.random()*100);//������ �ֱ�
			eng=(int)(Math.random()*100);
			math=(int)(Math.random()*100);
			
			
			queryTxt =String.format("insert into Student_Score (student_id, name, kor, eng, math)"
					+ "values ('%d', '%s', '%d', '%d', '%d');", student_id, name, kor, eng, math);
			
			stmt.execute(queryTxt);//�μ�Ʈ�� ����
		}
	
	static void headPrint(int page) { //��� �Ӹ� �κ� 
		System.out.println("                   ��������ǥ\n");
		Calendar calt = Calendar.getInstance();//��¥ �ð� �ޱ�
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//���� ��¥ �ð� ���� ����
		System.out.printf("PAGE : %d   �������: %s\n",page,sdf.format(calt.getTime()));
		System.out.println("======================================================");
		System.out.printf("%2s  %-2s        %2s   %2s   %2s     %2s     %2s\n",
				"�й�","�̸�","����","����","����","�հ�","���");
		System.out.println("======================================================");
	}
	
	static void bodyPrint(int page, int pagePer) throws SQLException { //������ ��������
		queryTxt =String.format("select student_id,name,kor,eng,math,kor+eng+math,round((kor+eng+math)/3,2)"
							+ " from Student_Score"
							+ " where student_id>=%d && student_id<=%d;",(page-1)*pagePer+1,page*pagePer);
											//������ ������ �� ����=��� �� ��ŭ 1~pagePer,pagePer~2*pagePer
		rset = stmt.executeQuery(queryTxt);
		
		while(rset.next()!=false) { //��� �ݺ� �� row��
			System.out.printf("%04d  %6s  %3d   %4d    %3d       %3d   %6.2f\n",
					rset.getInt(1),rset.getString(2),rset.getInt(3),rset.getInt(4),rset.getInt(5),
					rset.getInt(6),rset.getDouble(7));
		}
	}
	
	//�����κ� �������� ���, ���������� ��� ���
	static void tailPrint(int page, int calc) throws SQLException { 
		System.out.println("======================================================");
		System.out.println("����������");
		queryTxt=String.format("select sum(kor),sum(eng),"//page�� ������ row�� �°��
				+ "sum(math),sum(kor+eng+math),sum((kor+eng+math)/3)"
				+ " from Student_Score where student_id>=%d && student_id<=%d;"
				,pagePer*(page-1),pagePer*page);
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) { //rest.next()�� ���̶�� ������ ������ rest.get�� �ȵȴ�!
			System.out.printf("����            %5d %6d %7d %8d %8.2f\n",
					rset.getInt(1),rset.getInt(2),rset.getInt(3),
					rset.getInt(4),rset.getDouble(5));
		}
		
		queryTxt=String.format("select round(sum(kor)/%d,2),round(sum(eng)/%d,2)," //��հ��
				+ "round(sum(math)/%d,2),round(sum(kor+eng+math)/%d,2),round(sum((kor+eng+math)/3)/%d,2)"
				+ " from Student_Score where student_id>=%d && student_id<=%d;"
				,calc,calc,calc,calc,calc,pagePer*(page-1),pagePer*page);
		//calc�� ������������ ����� ����̳Ŀ� ���� �޶���
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) {
			System.out.printf("���            %3.2f  %3.2f   %3.2f   %3.2f    %3.2f\n",
					rset.getDouble(1),rset.getDouble(2),rset.getDouble(3),
					rset.getDouble(4),rset.getDouble(5));
		}
		
		System.out.println("======================================================");
		System.out.println("����������");
		queryTxt=String.format("select sum(kor),sum(eng),"
				+ "sum(math),sum(kor+eng+math),sum((kor+eng+math)/3)"
				+ " from Student_Score where student_id >=1 and student_id<=%d;"
				,page*pagePer);//������ ���� ����ϴ� row�� 1���͸� �ȴ�.
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) {
			System.out.printf("����            %5d %6d %7d %8d %8.2f\n",
					rset.getInt(1),rset.getInt(2),rset.getInt(3),
					rset.getInt(4),rset.getDouble(5));
		}
		
		queryTxt=String.format("select round(sum(kor)/%d,2),round(sum(eng)/%d,2),"
				+ "round(sum(math)/%d,2),round(sum(kor+eng+math)/%d,2),round(sum((kor+eng+math)/3)/%d,2)"
				+ " from Student_Score where student_id >=1 and student_id<=%d;"
				
				//������������ ����� pagePer�� �ȵɰ�� calc�� ����ؼ� ������, ������ ������ ��¿���
				
				,(page-1)*pagePer+calc,(page-1)*pagePer+calc,(page-1)*pagePer+calc,
				page*pagePer);
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) {//����� �ٸ��� �ʴ�
			System.out.printf("���            %3.2f  %3.2f   %3.2f   %3.2f    %3.2f\n",
					rset.getDouble(1),rset.getDouble(2),rset.getDouble(3),
					rset.getDouble(4),rset.getDouble(5));
		}
		System.out.println("======================================================");
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	//jdbc����̹� �ε�, jdbc ����̹���
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc����̹� ���� Ŭ����
	//driver manager API Ŭ������ ���� �޼ҵ带 �����ؼ� ip, id, pw�� �Է¹޾� Connection
	//�������̽��� ��ü�� �����ϸ� ���ϰ� ��ȯ
		conn = DriverManager.getConnection //Ŀ�ؼ� ����(DB�� ����)
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
	//Connetion �������̽��� Statement ���� �޼ҵ带 �����ؼ� statement �������̽��� ��ü�� �����ϸ� 
	//���ϰ� ��ȯ
		stmt = conn.createStatement(); //���â ��ȯ
	//������ ����
//		for (int i =0; i<iPerson; i++) { //��� ����ŭ rset�Է�.
//			dataSet(i);	
//		}
		
	//������ ��ȸ
		//�������� ��ü�����/�������� ����� +1 ��ŭ ���
		for(int page =1; page<=iPerson/pagePer+1;page++) {
			//�������������� ��µ��� ���� ����(��ü������� �� �������� ������� ����� ��������)
			if  (page > iPerson/pagePer && iPerson%pagePer==0) break;
			
			headPrint(page); //������ ����ŭ ������
			bodyPrint(page,pagePer);//������ ����ŭ �ٵ����
			
			if(page*pagePer>iPerson) {//���� ������ ������� �����Ҷ� =���� ������ ��� ����
				lastPagePer = iPerson % pagePer; //�������� ���ؼ� ������ ��� �޼ҵ� �׷��� �ǰ� ¥��
				tailPrint(page,lastPagePer);
			}
			else{ //������ ������ ������ ��� ����
				tailPrint(page,pagePer);
			}
		}
		
	}
}
