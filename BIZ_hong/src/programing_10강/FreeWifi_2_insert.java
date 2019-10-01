package programing_10강;

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
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/song?serverTimezone=UTC","root","1234");
//				("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
//		File f=new File("C:\\Users\\kopo\\Desktop\\전국무료와이파이표준데이터.txt");
		File f=new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습\\전국무료와이파이표준데이터.txt");
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
			//
			//앞으로 디비 다루는 프로그램을 만질일이 있다면 노가다의 끝을 볼것
			//아래같이 몇개씩 뭉쳐서 쓰던지 잘 알 수 있게 한개씩 쓰든지
			//프로그램 문법에 맞게 대신 연습 필요
			//갯수 맞출려고 다섯개씩 한줄에
			//%s 혿따움표 한것과 안한 것의 차이는?
			
			if(field[7].trim().length()==0) field[7]="0000-01-01";
			//field[7]에 공백문자가 있다. 공백문자가 있으면 date형 데이터가 에러남
			//if문으로 으로 공백문자가 있을때 처리
			//trim으로 공백을 짜름 null을 잡을땐 isEmpty안잡히고 length=0으로 잡아야 잡힘
			
			QueryTxt = String.format("insert into freewifi ("//테이블 칼럼명 //스트링 덩어리를 변수로
//			QueryTxt = String.format("insert into freewifi2 ("//테이블 칼럼명 //스트링 덩어리를 변수로
					+"place_no,inst_place,inst_place_detail,inst_city,inst_country,inst_place_flag,"
					+"service_provider,wifi_ssid,inst_date,place_addr_road,place_addr_land,"
					+"manage_office,manage_office_phone,latitude,longitude,write_date)"
					+"values ("//칼럼에 각 값들
					+"'%d','%s','%s','%s','%s','%s',"//작은 따옴표가 없으면 에러남
					+"'%s','%s','%s','%s','%s'," //테이블 만들때 다 varchar로 해서
					+"'%s','%s','%s','%s','%s');", 
					LineCnt,field[0],field[1],field[2],field[3],field[4],//인덱스값 하나 넣어봄
					field[5],field[6],field[7],field[8],field[9],
					field[10],field[11],field[12],field[13],field[14]);//field 하나하나 입력
		
			stmt.execute(QueryTxt);//쿼리 날리기
			System.out.printf("%d번째 항목 Insert OK [%s]\n",LineCnt,QueryTxt);
			//줄수 쿼리 출력
			LineCnt++;
		}
		br.close();
		
		stmt.close();
		conn.close();
	}
}
