package programing_8강;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 감_잡고_파일정제 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//읽을파일
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습\\THTSKS010H00.dat"); 
		// dat=DB를 덤프받은 파일
		BufferedReader br = new BufferedReader(new FileReader(f));
		//새로 쓸파일
		File f1 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습\\StockDailyPrice.csv");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

		String readtxt; //읽은거 저장할 변수

		int cnt = 0;//전체 파일 row 수 셀 변수
		int wcnt = 0;//데이터 조정한 row 수 셀 변수
		
		while ((readtxt = br.readLine()) != null) {//한줄 씩 읽기
			
			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%"); // 구분자를 %_% 로 잡고 필드 분할
			
			// 구분자 제거 후 원하는 필드 검출
			if (field.length > 2 && field[2].replace("^","").trim().substring(0, 1).equals("A")) { //단축코드A잡기
				//자료보니까 생줄이 필드 하나 있고 띄어져있음 --의미 없는 애들
				//단축코드가 A인 애들만 의미 있음
				s.append(field[0].replace("^","").trim()); // 첫필드 ^제거 후 버퍼 추가
														//쉼표자동 붙이려고 처음만 일케
				
				for (int j = 1; j < field.length; j++) { // 나머지 필드 쉽표 붙여주고 ^제거후 버퍼 추가
					s.append("," + field[j].replace("^","").trim()); 
				}
				
				bw1.write(s.toString());//완성된 버퍼를 스트링으로 바까서 씀
				bw1.newLine(); // 개행문자 윈도우용
				wcnt++;
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}

		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
