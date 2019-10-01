package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BascicTraining1_create {
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		//jdbc드라이버를 호출(java와  db connector)
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
		//커넥션 놓는 위치 설정 즉   db와 연결
		
		Statement stmt = conn.createStatement(); //명령창호출
		
		stmt.execute("create table Children_Protection_Zone("+ //테이블 생성
					"facility_kind varchar(50) ,"+//시설종류
					"facility_name varchar(200),"+//대상시설명
					"place_addr_road varchar(300),"+//소재지도로명주소
					"place_addr_land varchar(300),"+//소재지지번주소
					"latitude double not null,"+//위도
					"longitude double not null,"+//경도
					"manage_office varchar(100),"+//관리기관명
					"manage_police_office varchar(100),"+//관할경찰서명
					"CCTV_check varchar(10),"+//CCTV설치여부
					"CCTV_num varchar(10),"+//CCTV설치갯수
					"protection_road_width varchar(50),"+//보호구역도로폭
					"write_date date"+//데이터기준일자
					
					//"PRIMARY KEY(latitude,longitude)"+//복합프라이머리키 주는 문법 mysql
					") DEFAULT CHARSET=utf8;");//한글처리 테이블마다 해주어야 함
		
		stmt.close();
		conn.close();
	}
}
