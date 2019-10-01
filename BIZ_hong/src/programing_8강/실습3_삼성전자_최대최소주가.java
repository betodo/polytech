package programing_8강;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;


public class 실습3_삼성전자_최대최소주가 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습" 
					+ "\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;
		int cnt = 0;
		int maxcnt = 0;
		int mincnt =0;
		int max =0;//최초비교값 음수는 없으니 0부터
		int min =999999999;//최초비교값이라 겂나 크게
		int chkNum;//최대최소 비교할 변수
		
		while ((readtxt = br.readLine()) != null) {

			String[] field = readtxt.split("%_%");
			
			if (field.length > 2 //단축 코드를 잡는 이유는 유효하지 않은 문자(데이터) 치울라고
					&& field[2].replace("^", "").trim().equals("A005930")
					&& field[1].replace("^", "").trim().substring(0, 4).equals("2015")) {
				
				try { //종가가 공백이면 에러 = catch로 걍 넘어가기
					chkNum = Integer.parseInt(field[86].replace("^", "").trim());
					
					if(chkNum != 0) { // 종가가 0이 아닐때만 실행
						if (max < chkNum){
							max = chkNum; maxcnt=cnt; //맥스값 구하기
						}
						if (min > chkNum) {
							min =chkNum; mincnt=cnt;//민값 구하기
						}
					}	
					
				}catch (Exception e) {
					
				}
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}
		br.close();
		System.out.printf("[%d행] 2015년 삼정전자 주가 최대값 : %d\n", maxcnt, max);
		System.out.printf("[%d행] 2015년 삼정전자 주가 최소값 : %d\n", mincnt, min);
	}

}
