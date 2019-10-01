package programing_8강;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class 파일분리_데이터보정2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// \은 특문자이므로 \\두개를 써야한다
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		File f1 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터_SKT_2.txt");
		File f2 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터_KT_2.txt");
		File f3 = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습"
				+ "\\전국무료와이파이표준데이터_LGU_2.txt");

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
			
			String[] field = readtxt.split("\t");//탭으로 라인 분리 배열저장
			String detect = field[5].trim().toUpperCase(); // 통신사 검출용 변수//upper로 소문자 처리
			StringBuffer s = new StringBuffer(); //재조립용 버퍼 변수
			
			for (int i=0 ; i <=4 ; i++) s.append(field[i]+"\t"); //필드4까지 재조립
			
			
			if(detect.contains("SK") || detect.contains("텔레콤")) { //통신사가 SKT일 조건
				
				field[5] = field[5].replace(field[5], "SKT"); //field[5]를 "SKT"로 바꾸기
				s.append(field[5]+"\t");//필드5 재조립
				for (int k =6 ; k < field.length ; k++) s.append(field[k]+"\t");//나머지 재조립
				
				bw1.write(s.toString());//스트링으로 안해주면 안에 인트도 있어서 못읽고 씀
				bw1.newLine();
				
			}else if(detect.contains("KT") || detect.contains("케이티")) { 
				
				if(detect != "넷KTI") { //이름에 kt가 들어가는 유일한 타기업 제외
					field[5] = field[5].replace(field[5], "KT"); 
					s.append(field[5]+"\t");//필드 5 조립
					for (int k =6 ; k < field.length ; k++) s.append(field[k]+"\t"); 
					//필드 6부터 끝까지 조립
					
					bw2.write(s.toString());
					bw2.newLine();
				}
				
			}else if(detect.contains("LG") || detect.contains("엘지")) { 
				
				field[5] = field[5].replace(field[5], "LGU+"); 
				s.append(field[5]+"\t");
				for (int k =6 ; k < field.length ; k++) s.append(field[k]+"\t");
				
				bw3.write(s.toString());
				bw3.newLine();
				
			}else {
				System.out.printf("알수 없는 통신사 [%d번째 항목][%s]***\n", LineCnt, field[5]);
			}
			
			LineCnt++;
		}
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();
	}

}



















