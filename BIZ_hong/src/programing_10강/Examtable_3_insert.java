package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Examtable_3_insert {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				//("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		("jdbc:mysql://192.168.56.102:3306/song?","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('효민',209901,95,100,95);");//data삽입(row)
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('보람',209902,95,95,95);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('은정',209903,100,100,100);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('지연',209904,100,95,90);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('소연',209905,80,100,70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('큐리',209906,100,100,70);");
		stmt.execute("insert into examtable (name, studentid, kor, eng, mat) values ('화영',209907,70,70,70);");
		
		stmt.close();
		conn.close();
	}
}
