package programing_10강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class StockDailyPrice_insert {
	// 파일에서 대량의 data 정제하여 db에 넣기 (오토퍼밋, 배치 사용)
	
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");// jdbc드라이버를 호출(=java와 db connector)
		//JDBC를 통해서 *IP에 존재하는 DB의 3306포트를 통하여 접속, ID와 PASSWD 같이 적어주어서 접속 된다
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/songdb", "root", "1234");
		// 커넥션 놓는 위치 설정 즉 db와 연결
		Statement stmt = conn.createStatement(); //DB의 명령창 호출(쿼리문을 사용하기 위해 Statement사용)
		
		//읽을 파일 지정 File클래스 사용
		File f = new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습\\THTSKS010H00.dat");
		//파일 읽을 도구로 버퍼리더를 사용
		BufferedReader br = new BufferedReader(new FileReader(f));

		int LineCnt = 1;//몇줄의 데이터가 들어갔는지 셀 변수
		String readtxt;//로우 한줄을 읽기 위한 변수선언

		conn.setAutoCommit(false);//(sql문 하나하나 마다)자동커밋off=빠른속도로 데이터 넣기=커밋횟수 줄여줌
		while ((readtxt = br.readLine()) != null) { // 더이상 읽을 줄이 없을 때까지 반복
			
			StringBuffer s = new StringBuffer();//sql문을 한번에 담을 그릇으로 사용
			s.append("insert into abc value('");//sql문을 append로 그릇에 담자(,)요거 조심!
			
			String[] field = readtxt.split("%_%");// 구분자를 지정하여 필드에 저장
			if(field.length<3) continue;//데이터 모습상 필드가 짧은 의미 없는 줄이 있음
										//그거 넘겨 버림
			
			//뒤에서 반복문으로 sql문을 조립하기 위해 첫필드만 따로 넣어줌(, 이거 붙이는거 때문)
			//mysql에서 문자는 '문자' 싱글포테이션으로 감싸야하기 때문에 replace
			s.append(field[0].replace("^",  "'").trim());
			
			for (int i = 1; i < field.length; i++) {//필드 갯수 만큼 sql문 조립
				if (field[i].replace("^",  "").trim().length() == 0) {//필드가 null이면
					s.append("," + "null");//널값입력 문자아님
				} else { //필드가 null이 아니면
					try {//필드를 숫자로 변환했을때 에러 안나면 ' 싱글포테 안 붙임
						Integer.parseInt(field[i].replace("^",  "").trim());
						s.append("," + field[i].replace("^",  "").trim());
						
					}catch(Exception e) {//필드 숫자 변환 에러나면 문자니까 싱글포테 붙임
						s.append("," +field[i].replace("^",  "'").trim());
					}	
				}
			}
			s.append(");");//맨뒤의 sql문 조립해서 sql문 완성 

			//addBatch=여러개의 sql문을 한꺼번에 실행할때 사용하는 그릇
			stmt.addBatch(s.toString());//완성한 sql문을 스트링으로 add배치에 담자
			
			if (LineCnt % 10000 == 0) {
				stmt.executeBatch();//오만개의 row씩 sql문을 날린다=오만개의 sql문이 담겨있다
				System.out.println(LineCnt + "row까지 insert & commit 완료");//insert확인용
				conn.commit();//오만개 row마다 커밋때려주기
			}
			
			LineCnt++; //한줄 작업이 끝나면 줄 카운트를 늘려준다
			
		}
		stmt.executeBatch(); //마지막에 남은 sql문도 실행 
		conn.commit();//sql문 전부 실행했으니까 커밋해줌
		conn.setAutoCommit(true);// 꺼놨던 오토 커밋도 켜준다

		System.out.println("전부 완료되었습니다.");//최종완료 확인

		br.close();//연순의 역순으로 닫는다
		stmt.close();
		conn.close();
	
	}

}
