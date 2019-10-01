package programing_8강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class freeWifi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// 실습1

		File f = new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습" + 
							"\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;

		if ((readtxt = br.readLine()) == null) {//조건안에 있어도 readLine한번 실행됨
			System.out.printf("빈 파일입니다\n");
			return;
		}
		String[] field_name = readtxt.split("\t");// 필드명

		double lat = 37.3860521;
		double lng = 127.1214038;

		int LineCnt = 1;
		while ((readtxt = br.readLine()) != null) {

			String[] field = readtxt.split("\t");
			System.out.printf("**[%d번째 항목]***************\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[9], field[9]);// 9번째 : 지번주소
			System.out.printf(" %s : %s\n", field_name[12], field[12]);// 12번째 : 위도주소
			System.out.printf(" %s : %s\n", field_name[13], field[13]);// 13번째 : 경도주소

			double dist = Math.sqrt(// 두점의 거리(피타고라스정리)
					Math.pow(Double.parseDouble(field[12]) - lat, 2)
							+ Math.pow(Double.parseDouble(field[13]) - lng, 2));

			System.out.printf(" 현재지점과의 거리 : %f\n", dist);
			System.out.println("******************************");
			if (LineCnt == 100)
				break;
			LineCnt++;
		
		}
		br.close();

//전국무료와이파이 표준데이터.csv가 데이터가 지랄이라 엑셀에서 텝으로 분리되는 txt파일로 저장. 앞에서 필드별 데이터 나누는것
//점(a,b) 점(c,d)간의 거리는 피타고라스 정리 융기원과 와이파이와 떨어진 거리계산

	}

}
