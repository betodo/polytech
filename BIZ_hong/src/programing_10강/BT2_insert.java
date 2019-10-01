package programing_10강;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BT2_insert {
	
	static int student_id;//입력할 내용(변수들)
	static String name;
	static int kor;
	static int eng;
	static int math;
	
	static Connection conn = null;  //인터페이스 생성
	static Statement stmt = null;	//여러 메소드에 사용
	static ResultSet rset = null;
	
	static String queryTxt;
	
	static int iPerson =1000; // 전체 사람수
	static final int pagePer=30;//한페이지당 나올 사람수
	static int page=1;//페이지 번호
	
	static int lastPagePer=0;//마지막페이지에 나올 사람수


	
	static void dataSet(int i) throws SQLException { //데이터 삽입 메서드
		
			student_id = i+1;
			name = String.format("홍길동%04d", i+1);//이름만들기
			kor=(int)(Math.random()*100);//랜덤값 주기
			eng=(int)(Math.random()*100);
			math=(int)(Math.random()*100);
			
			
			queryTxt =String.format("insert into Student_Score (student_id, name, kor, eng, math)"
					+ "values ('%d', '%s', '%d', '%d', '%d');", student_id, name, kor, eng, math);
			
			stmt.execute(queryTxt);//인서트문 실행
		}
	
	static void headPrint(int page) { //출력 머리 부분 
		System.out.println("                   성적집계표\n");
		Calendar calt = Calendar.getInstance();//날짜 시간 받기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//받은 날짜 시간 형식 지정
		System.out.printf("PAGE : %d   출력일자: %s\n",page,sdf.format(calt.getTime()));
		System.out.println("======================================================");
		System.out.printf("%2s  %-2s        %2s   %2s   %2s     %2s     %2s\n",
				"학번","이름","국어","영어","수학","합계","평균");
		System.out.println("======================================================");
	}
	
	static void bodyPrint(int page, int pagePer) throws SQLException { //데이터 꺼내오기
		queryTxt =String.format("select student_id,name,kor,eng,math,kor+eng+math,round((kor+eng+math)/3,2)"
							+ " from Student_Score"
							+ " where student_id>=%d && student_id<=%d;",(page-1)*pagePer+1,page*pagePer);
											//데이터 꺼낼올 때 조건=출력 수 만큼 1~pagePer,pagePer~2*pagePer
		rset = stmt.executeQuery(queryTxt);
		
		while(rset.next()!=false) { //출력 반복 한 row씩
			System.out.printf("%04d  %6s  %3d   %4d    %3d       %3d   %6.2f\n",
					rset.getInt(1),rset.getString(2),rset.getInt(3),rset.getInt(4),rset.getInt(5),
					rset.getInt(6),rset.getDouble(7));
		}
	}
	
	//꼬리부분 현페이지 계산, 누적페이지 계산 출력
	static void tailPrint(int page, int calc) throws SQLException { 
		System.out.println("======================================================");
		System.out.println("현재페이지");
		queryTxt=String.format("select sum(kor),sum(eng),"//page당 꺼내온 row의 걔계산
				+ "sum(math),sum(kor+eng+math),sum((kor+eng+math)/3)"
				+ " from Student_Score where student_id>=%d && student_id<=%d;"
				,pagePer*(page-1),pagePer*page);
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) { //rest.next()가 참이라는 조건이 없으면 rest.get이 안된다!
			System.out.printf("총점            %5d %6d %7d %8d %8.2f\n",
					rset.getInt(1),rset.getInt(2),rset.getInt(3),
					rset.getInt(4),rset.getDouble(5));
		}
		
		queryTxt=String.format("select round(sum(kor)/%d,2),round(sum(eng)/%d,2)," //평균계산
				+ "round(sum(math)/%d,2),round(sum(kor+eng+math)/%d,2),round(sum((kor+eng+math)/3)/%d,2)"
				+ " from Student_Score where student_id>=%d && student_id<=%d;"
				,calc,calc,calc,calc,calc,pagePer*(page-1),pagePer*page);
		//calc은 마지막페이지 사람이 몇명이냐에 따라 달라짐
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) {
			System.out.printf("평균            %3.2f  %3.2f   %3.2f   %3.2f    %3.2f\n",
					rset.getDouble(1),rset.getDouble(2),rset.getDouble(3),
					rset.getDouble(4),rset.getDouble(5));
		}
		
		System.out.println("======================================================");
		System.out.println("누적페이지");
		queryTxt=String.format("select sum(kor),sum(eng),"
				+ "sum(math),sum(kor+eng+math),sum((kor+eng+math)/3)"
				+ " from Student_Score where student_id >=1 and student_id<=%d;"
				,page*pagePer);//누적은 간단 계산하는 row가 1부터면 된다.
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) {
			System.out.printf("총점            %5d %6d %7d %8d %8.2f\n",
					rset.getInt(1),rset.getInt(2),rset.getInt(3),
					rset.getInt(4),rset.getDouble(5));
		}
		
		queryTxt=String.format("select round(sum(kor)/%d,2),round(sum(eng)/%d,2),"
				+ "round(sum(math)/%d,2),round(sum(kor+eng+math)/%d,2),round(sum((kor+eng+math)/3)/%d,2)"
				+ " from Student_Score where student_id >=1 and student_id<=%d;"
				
				//마지막페이지 사람이 pagePer가 안될경우 calc을 계산해서 더해줌, 마지막 페이지 출력에서
				
				,(page-1)*pagePer+calc,(page-1)*pagePer+calc,(page-1)*pagePer+calc,
				page*pagePer);
		
		rset =stmt.executeQuery(queryTxt);
		
		if(rset.next()) {//출력은 다르지 않다
			System.out.printf("평균            %3.2f  %3.2f   %3.2f   %3.2f    %3.2f\n",
					rset.getDouble(1),rset.getDouble(2),rset.getDouble(3),
					rset.getDouble(4),rset.getDouble(5));
		}
		System.out.println("======================================================");
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	//jdbc드라이버 로딩, jdbc 드라이버명
		Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc드라이버 연결 클래스
	//driver manager API 클래스의 연결 메소드를 실행해서 ip, id, pw를 입력받아 Connection
	//인터페이스의 객체를 생성하며 리턴값 반환
		conn = DriverManager.getConnection //커넥션 놓기(DB에 연결)
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");
	//Connetion 인터페이스의 Statement 생성 메소드를 실행해서 statement 인터페이스의 객체를 생성하며 
	//리턴값 반환
		stmt = conn.createStatement(); //명령창 소환
	//데이터 삽입
//		for (int i =0; i<iPerson; i++) { //사람 수만큼 rset입력.
//			dataSet(i);	
//		}
		
	//데이터 조회
		//페이지는 전체사람수/페이지당 사람수 +1 만큼 출력
		for(int page =1; page<=iPerson/pagePer+1;page++) {
			//마지막페이지가 출력되지 않을 조건(전체사람수가 딱 페이지당 사람수로 나우어 떨어질때)
			if  (page > iPerson/pagePer && iPerson%pagePer==0) break;
			
			headPrint(page); //페이지 수만큼 헤드출력
			bodyPrint(page,pagePer);//페이지 수만큼 바디출력
			
			if(page*pagePer>iPerson) {//남은 페이지 사람수가 존재할때 =남은 페이지 출력 조건
				lastPagePer = iPerson % pagePer; //나머지를 더해서 누적값 계산 메소드 그렇게 되게 짜놈
				tailPrint(page,lastPagePer);
			}
			else{ //마지막 페이지 전까지 출력 조건
				tailPrint(page,pagePer);
			}
		}
		
	}
}
