package programing_10강;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicTraining1_minDistance {
	//Comment : 나와 가장 가까운 곳 찾기
			public static void main(String[] args) throws ClassNotFoundException, SQLException {
				// TODO Auto-generated method stub
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				//jdbc드라이버를 호출(java와  db connector)
				Connection conn = DriverManager.getConnection
						("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
				//커넥션 놓는 위치 설정 즉   db와 연결
				
				Statement stmt = conn.createStatement();//명령창호출
				
		/////////////////////////////////////////////////////////////////////		
				double lat=37.3860521; double lng=127.1214038; //현위치
				
				String QueryTxt;
				QueryTxt = String.format("select * from Children_Protection_Zone "
						+"where SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))= "
						+"(select MIN(SQRT(POW(latitude-%f,2) + POW(longitude-%f,2))) from Children_Protection_Zone);"
						,lat,lng,lat,lng);
				//두점의 거리 sqrt=루트씌우는 함수/ power=제곱하는 함수
				//두점의 거리 공식=피타고라스 정의 루트(a^2+b^2)
				//두점의 거리=최소 두점의 거리 인 row만 검색
		///////////////////////////////////////////////////////////////////////	
				
				ResultSet rset = stmt.executeQuery(QueryTxt);
				
				int iCnt=0;
				while(rset.next()) {//콘솔창에 출력 rset.next()하면  한 로우씩 출력 rset=row
									//next(n)=칼럼 n번째 칼럼을 말함
					System.out.printf("*(%d)***********************************************\n",iCnt++);
					System.out.printf("시설종류       : %S\n",rset.getString(1));//결과 tabled의 row와 칼럼
					System.out.printf("대상시설명     : %S\n",rset.getString(2));
					System.out.printf("소재지도로명주소: %S\n",rset.getString(3));
					System.out.printf("소재지지번주소  : %S\n",rset.getString(4));
					System.out.printf("위도           : %f\n",rset.getDouble(5));
					System.out.printf("경도           : %f\n",rset.getDouble(6));//데이터형 조심
					System.out.printf("관리기관명     : %S\n",rset.getString(7));
					System.out.printf("관할경찰서명   : %S\n",rset.getString(8));
					System.out.printf("CCTV설치여부   : %S\n",rset.getString(9));
					System.out.printf("CCTV설치갯수   : %S\n",rset.getString(10));
					System.out.printf("보호구역도로폭 : %S\n",rset.getString(11));
					System.out.printf("데이터기준일자 : %S\n",rset.getDate(12));//데이터형 조심					
					System.out.printf("*************************************************\n");
				}
				rset.close();//데이터 안잡아 먹도록 쓰고나면 닫자
				stmt.close();
				conn.close();
			}
}
