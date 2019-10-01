package programing_10강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

public class test_insert {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");						// DB 와 연결
		Statement stmt = conn.createStatement();		// DB 명령문을? 준비
		
		File f = new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));	//버퍼 리더
		int cnt = 0; //루프용 카운트
		String readtxt;
		
		conn.setAutoCommit(false);		// 오토커밋기능을 끈다 끄면 빠르대요
		
		while((readtxt= br.readLine()) != null) {		//파일을 끝까지 읽는 루프
			StringBuffer s = new StringBuffer();		// 한줄씩 읽어서 sql문으로 넣는다. 버퍼설정
			s.append("insert into THTSKS010H00 values ('");	//sql문 초반부
			String[] field = readtxt.split("%_%");		//구분자를 %_% 로 잡고 필드 분할
			//구분자 제거 후 원하는 필드 검출
			if(field.length <3) continue;			//필드가 적은 줄은 continue로 패스한다
			s.append(field[0].replace("^",  "'").trim());	//구분자 대체
			for (int j=1; j< field.length; j++) {			//필드 끝까지
				if (field[j].replace("^",  "").trim().length() == 0) {
					s.append("," + "null");		//구분자 제거하고 필드값이 없을 땐 null을 넣는다
				} else {
					try {	//에러체크 try~catch를 통한 숫자 판별
						Integer.parseInt(field[j].replace("^",  "").trim());	//숫자변환해서 에러가 안뜨면
						s.append("," + field[j].replace("^",  "").trim());		//구분자만 제거해서 조립
								//^ 제거 후 버퍼에 추가
					} catch (Exception e) {						//숫자변환시 에러가 뜨면(문자열이 있을경우?)
						s.append("," + field[j].replace("^",  "'").trim());		//구분자를 '로 대체해서 조립
					}
				}
			}
			s.append(");");		// sql문 마저 조립
			
			stmt.addBatch(s.toString());		//배치를 쓰면 빨라진다고 한다..
			if(cnt % 10000 == 0) {				//10000개 마다
				stmt.executeBatch();			//배치된 것 적용
				System.out.println(cnt + " row inserted");	//확인용 문구 출력
				conn.commit();				//커밋해준다
			}
			cnt++;		//카운트
			//stmt.execute(s.toString());	//배치쓰기 전의 흔적
		}
		stmt.executeBatch();		//while문 끝나고 10000미만의 row들 처리를 위해 배치적용 한번더
		System.out.printf("완료되었습니다.\n");
		conn.commit();			//커밋도 한번더
		conn.setAutoCommit(true);		//오토커밋 다시 적용해준다
		
		br.close();
		stmt.close();
		conn.close();		//끝
	}

}


