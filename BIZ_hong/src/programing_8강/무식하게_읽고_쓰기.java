package programing_8강;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class 무식하게_읽고_쓰기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 버퍼없이 char[N]개의 배열을 잡아 읽기 
		 * 자바의 exception처리 (try {}catch(e){} 구문 ) 파일이 없다든지,
		 * 하드디스크 쓰기권한이 없다든지 
		 * 디렉토리를 C:\로 지정하고 실습 
		 * HanCount는 주어진 문자열의 한글수를 리턴함
		 */	
		try {
			File f = new File("C:\\Users\\admin\\Desktop\\"//파일생성(경로써줌)
					+ "나\\홍필두교수님파일실습\\8lecTest.txt");
			
			FileWriter fw = new FileWriter(f);//파일쓰기 클래스 불러와서 파일 쓰기
				
			fw.write("안녕 파일\n");
			fw.write("hello 헬로\n");//파일에다 쓸거 개행문자는 자바와 윈도우가 달라 안먹음
			
			fw.close();//클래스를 종료해서 메모리누수 막는다
			
			FileReader fr =  new FileReader(f);//파일리더 클래스로 파일읽기
			
			int n=-1; //파일 다 읽을때 필요한 변수
			char[] ch;//char 배열로 일기
			
			while (true) {
				ch = new char[100];
				n = fr.read(ch);//배열에 담긴 문자 갯수하나씩 읽어서 n에 저장
				
				if (n ==-1)break;//더이상 읽을 문자가 없으면 파일읽기 종료
				
				for (int i=0;i<n;i++) {
				//	for (char : c) {}로 써도됨
					System.out.printf("%c",ch[i]); //한글자씩 읽어서 자바에 출력
				}
			}
			fr.close();
			System.out.printf("\n FILE READ END"); //마치면 파일읽기 끝났다 출력
			
		}catch(Exception e){
			System.out.printf("나 에러[%s]\n",e); //에러 내용이 출력된
		}

	}

}
