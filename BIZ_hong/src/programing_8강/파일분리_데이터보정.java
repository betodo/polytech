package programing_8강;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 파일분리_데이터보정 {
	//파일 읽으다가 자료 고쳐서 새로 쓰기
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// \은 특문자이므로 \\두개를 써야한다
		//읽을 파일
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		//새로 쓸 파일
		File f1 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터_SKT.txt");
		File f2 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터_KT.txt");
		File f3 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터_LGU.txt");
		
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));
		
		String readtxt;
		
		if((readtxt=br.readLine())==null) { //필드명 읽기
			System.out.printf("빈 파일입니다\n");
			return;
		}
		
		//첫줄(필드명)은 모든 파일에 다 쓴다.
		bw1.write(readtxt); bw1.newLine();
		bw2.write(readtxt); bw2.newLine();
		bw3.write(readtxt); bw3.newLine();
		
//		String[] field_name =readtxt.split(","); //첫줄읽기=필드명
												//리드라인은 \n기준으로 일기 때문에
		
		int LineCnt=0;
		while((readtxt= br.readLine()) != null) {
			
			String[] field = readtxt.split("\t"); //탭으로 분리해서 파일 나누고
			
			if(field[5].trim().contains("SK")) { //.equals하면 에러남 바운더리가 다른게 있음
												 // 그래서 컨테인으로 바꿈
				bw1.write(readtxt);//파일f읽은 걸 파일f1에 씀
				bw1.newLine();
			} else if(field[5].trim().contains("KT")) {//와이파이가 kt면 kt파일에
				bw2.write(readtxt);
				bw2.newLine(); //파일쓸때 개행문자 이클립스랑 자바랑 다르니까 꼭
			} else if(field[5].trim().contains("LGU+")) {//엘지는 2가지 경우이다.
				bw3.write(readtxt);
				bw3.newLine();
			} else if(field[5].trim().contains("LG U+")) {
				bw3.write(readtxt); 
				bw3.newLine();
			} else { // 모르겠는 통신사는 몇번째줄ㅇ= ㅇ인지 얼==얼ㄹ
				System.out.printf("알수 없는 통신사 [%d번째 항목][%s]***\n", LineCnt, field[5]);
			}
			LineCnt++;
		}
		br.close();//열었으면 닫자
		bw1.close();
		bw2.close();
		bw3.close();
	}

}



















