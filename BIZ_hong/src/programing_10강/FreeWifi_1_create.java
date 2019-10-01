package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FreeWifi_1_create {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/song?serverTimezone=UTC","root","1234");
//				("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
//		stmt.execute("create table freewifi2("+ //freewifi로 테이블 생성
		stmt.execute("create table freewifi("+ //freewifi로 테이블 생성
					"place_no int not null,"+	
				//복합 프라이머리키를 주기 위해 칼럼을 하나 만듬(like일련번호)
					"inst_place varchar(50) ,"+//설치장소 
					"inst_place_detail varchar(200),"+//설치장소상세
					"inst_city varchar(50),"+//설치시도명
					"inst_country varchar(50),"+//설치시군구명
					"inst_place_flag varchar(50),"+//설치시설구분
					"service_provider varchar(50),"+//서비스제공사명
					"wifi_ssid varchar(200),"+//와이파이ssid
					"inst_date date,"+//설치년월 //date로 정제
					"place_addr_road varchar(300),"+//소재지도로명주소
					"place_addr_land varchar(200),"+//소재지지번주소
					"manage_office varchar(50),"+//관리기관명
					"manage_office_phone varchar(50),"+//관리기관전화번호
					"latitude double,"+//위도
					"longitude double,"+//경도
					"write_date date,"+//데이터기준일자
					"PRIMARY KEY(place_no,inst_place)"+//복합프라이머리키 주는 문법 mysql
					") DEFAULT CHARSET=utf8;");//한글처리 테이블마다 해주어야 함
		
		stmt.close();
		conn.close();
	}
}
