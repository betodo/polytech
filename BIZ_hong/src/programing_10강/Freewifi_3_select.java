package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Freewifi_3_select {
	//Comment : 나와 가장 가까운 곳 찾기
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			//jdbc드라이버를 호출(java와  db connector)
			Connection conn = DriverManager.getConnection
					("jdbc:mysql://34.80.186.131:3306/songdb","root","m21234");
			
			//커넥션 놓는 위치 설정 즉   db와 연결
			
			Statement stmt = conn.createStatement();//명령창호출
	/////////////////////////////////////////////////////////////////////		
			//double lat=37.3860521; double lng=127.1214038; //현위치
			
			String QueryTxt;
//			QueryTxt = String.format("select * from freewifi "
//					+"where SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))= "
//					+"(select MIN(SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))) from freewifi);"
//					,lat,lng,lat,lng);
			//두점의 거리 sqrt=루트씌우는 함수/ power=제곱하는 함수
			//두점의 거리 공식=피타고라스 정의 루트(a^2+b^2)
			//두점의 거리=최소 두점의 거리 인 row만 검색
		//실습2 QueryTxt = "select * from freewifi";
		//실습3	QueryTxt = "select * from freewifi where service_provider='SKT'";
			QueryTxt = "select * from freewifi where inst_country='수원시'";
			
	///////////////////////////////////////////////////////////////////////		
			ResultSet rset = stmt.executeQuery(QueryTxt);
			
			int iCnt=0;
			while(rset.next()) {//콘솔창에 출력 rset.next()하면  한 로우씩 출력 rset=row
								//next(n)=칼럼 n번째 칼럼을 말함
				System.out.printf("*(%d)***********************************************\n",iCnt++);
				System.out.printf("설치장소명     : %S\n",rset.getString(1));//결과 tabled의 row와 칼럼
				System.out.printf("설치장소상세     : %S\n",rset.getString(2));
				System.out.printf("설치시도명   : %S\n",rset.getString(3));
				System.out.printf("설치시군구명   : %S\n",rset.getString(4));
				System.out.printf("설치시설구분   : %S\n",rset.getString(5));
				System.out.printf("서비스제공사명   : %S\n",rset.getString(6));
				System.out.printf("와이파이SSID   : %S\n",rset.getString(7));
				System.out.printf("설치년월   : %S\n",rset.getString(8));
				System.out.printf("소재지도로명주소   : %S\n",rset.getString(9));
				System.out.printf("소재지주번주소   : %S\n",rset.getString(10));
				System.out.printf("관리기관명   : %S\n",rset.getString(11));
				System.out.printf("관리기관전화번호   : %S\n",rset.getString(12));
				System.out.printf("위도   : %f\n",rset.getFloat(13));
				System.out.printf("경도   : %f\n",rset.getFloat(14));
				System.out.printf("데이터기준일자   : %S\n",rset.getDate(15));
				System.out.printf("*************************************************\n");
			}
			rset.close();//데이터 안잡아 먹도록 쓰고나면 닫자
			stmt.close();
			conn.close();
		}
}
