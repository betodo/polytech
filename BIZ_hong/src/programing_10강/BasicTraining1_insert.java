package programing_10강;

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
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
		File f=new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습\\"
				+ "서울특별시_서대문구_어린이보호구역_20180807.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;//한줄 먼저 읽어야--DB랑은 상관 없음
		if((readtxt=br.readLine())==null) {
			System.out.println("빈 파일입니다.");//읽었는데 없는경우
			return;
		}
		
		String[] field_name = readtxt.split("\t");//탭으로 분리한 첫줄
		
		int LineCnt=0;
		while((readtxt=br.readLine())!=null) {
			String[] field = readtxt.split("\t");//탭으로 분리한 것을 줄로
			String QueryTxt;
			
			QueryTxt = String.format("insert into Children_Protection_Zone ("//테이블병
					+"facility_kind,facility_name,place_addr_road,place_addr_land,"//칼럼들
					+"latitude,longitude,manage_office,manage_police_office,"
					+ "CCTV_check,CCTV_num,protection_road_width,write_date)"
					+"values ("//칼럼에 각 값들"
					+"'%s','%s','%s','%s',"
					+"'%s','%s','%s','%s',"//작은 따옴표가 없으면 에러남
					+"'%s','%s','%s','%s');", 
					field[0],field[1],field[2],field[3],
					field[4],field[5],field[6],field[7],
					field[8],field[9],field[10],field[11]);//field 하나하나 입력
		
			stmt.execute(QueryTxt);//쿼리 날리기
			System.out.printf("%d번째 항목 Insert OK [%s]\n",LineCnt,QueryTxt.substring(0, 7));
			//줄수 쿼리 출력
			LineCnt++;
		}
		br.close();
		
		stmt.close();
		conn.close();
	}
}
