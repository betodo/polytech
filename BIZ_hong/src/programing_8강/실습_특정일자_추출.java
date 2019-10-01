package programing_8강;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class 실습_특정일자_추출 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//읽을 파일
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습" 
					+ "\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		//쓸 파일
		File f1 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
					+ "\\20150112_all.csv");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

		String readtxt;

		int cnt = 0;//전체 파일 row 수 셀 변수
		int wcnt = 0;//데이터 조정한 row 수 셀 변수
		while ((readtxt = br.readLine()) != null) {

			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%");

			if (field.length > 2 //단축 코드를 잡는 이유는 유효하지 않은 문자(데이터) 치울라고
					&& field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
				
				if(field[1].replace("^", "").trim().equals("20150112")) { //특정날짜

					s.append(field[0].replace("^", "").trim());
	
					for (int j = 1; j < field.length; j++) {
						s.append("," + field[j].replace("^", "").trim());
					}
	
					bw1.write(s.toString()); //버퍼를 스프링으로 바꾼 걸 파일에다 씀
					bw1.newLine(); 
					wcnt++;
				
				}
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}

		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);

	}

}
