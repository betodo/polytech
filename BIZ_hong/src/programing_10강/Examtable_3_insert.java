package programing_10��;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Examtable_3_insert {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc����̹��� ȣ��(java��  db connector)
		Connection conn = DriverManager.getConnection
				//("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		("jdbc:mysql://192.168.56.102:3306/song?","root","1234");
		//Ŀ�ؼ� ���� ��ġ ���� ��   db�� ����
		
		Statement stmt = conn.createStatement(); //���âȣ��
		
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('ȿ��',209901,95,100,95);");//data����(row)
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('����',209902,95,95,95);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('����',209903,100,100,100);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('����',209904,100,95,90);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('�ҿ�',209905,80,100,70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('ť��',209906,100,100,70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('ȭ��',209907,70,70,70);");
		
		stmt.close();
		conn.close();
	}
}
