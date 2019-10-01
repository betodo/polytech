package programing_8강;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class 실습_삼성전자_단축코드 {
	//데이터에서 특정 코드값만 추출

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//읽을 파일
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
					+ "\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		//새로 쓸 파일
		File f1 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
					+ "\\A005930.csv");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

		String readtxt;

		int cnt = 0;//전체 파일 row 수 셀 변수
		int wcnt = 0;//데이터 조정한 row 수 셀 변수
		while ((readtxt = br.readLine()) != null) {
			
			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%"); 
		
			if (field.length > 2 && field[2].replace("^", "").trim().equals("A005930")) { 
				//특정 단축코드만 잡아내기 때문에 서브스트링 함수 필요 없다
				
				s.append(field[0].replace("^", "").trim());//첫필드 조립
				
				for (int j = 1; j < field.length; j++) {//나머지 필드 조립
					s.append("," + field[j].replace("^", "").trim()); 
				}
				
				bw1.write(field[2].replace("^", "").trim());
				//코드값만 추출 다 추출하고 싶으면 s.toString()을 변수로
				bw1.newLine(); // 파일에 쓴다
				wcnt++;
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}

		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
		//총 9841행
	}

}
