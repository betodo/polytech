package programing_8강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class 실제_파일에_응용 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// \은 특문자이므로 \\두개를 써야한다
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터.csv");//csv같은 형식까지 지정해야
		//버퍼리더로 파일 읽기
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		//readtxt가 먼지 선언
		if((readtxt=br.readLine())==null) { //파일이 혹시 빈파일인지 검사
			System.out.printf("빈 파일입니다\n");
			return;
		}
		
		String[] field_name =readtxt.split(","); //첫줄읽기=필드명
												//리드라인은 \n기준으로 일기 때문에
		                                      //한줄을 먼저 읽어야 필드명을 알 수 있다.
		int LineCnt=0;//줄수 셀 변수
		while ((readtxt = br.readLine()) !=null) {
			
			String[] field =readtxt.split(","); // 다음리드라인은 그 다음줄
			System.out.printf("**[%d번째 항목]***************\n",LineCnt);
			
			for(int j=0 ; j < field_name.length ; j++) {//field_name.length=필드의 갯수 
														//length는 1부터센다 그래서 걍 작음
				System.out.printf(" %s : %s\n",field_name[j],field[j]);
			}
			System.out.println("******************************");
			if (LineCnt == 100)break; // 100줄만 읽겠단 소리
			LineCnt++;
		}
		br.close();
		
	}

}
