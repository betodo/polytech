package programing_8강;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered_읽고_쓰기 {
	public static void FileWrite() throws IOException{
		//파일 이름과 파일 저장할 경로 설정
		File f = new File ("C:\\Users\\admin\\Desktop\\"
				+ "나\\홍필두교수님파일실습\\8lecTest2.txt");
		//버퍼라이터로 파일 쓰기
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("안녕 파일");//파일쓰기
		bw.newLine(); //파일쓸때 개행문자 이렇게 사용
		bw.write("hello 헬로");
		bw.newLine();
		
		bw.close();//클래스를 열었으면 닫자
			
	}
	
	public static void FileRead() throws IOException{
		//읽을 파일 지정
		File f = new File ("C:\\Users\\admin\\Desktop\\"
				+ "나\\홍필두교수님파일실습\\8lecTest2.txt");
		//버퍼 리더로 파일 읽기
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;//읽을 라인을 저장할 변수
		
		while((readtxt= br.readLine())!=null) {//읽을 라인이 없으면 그만
			System.out.printf("%s\n",readtxt);//읽은거 출력
		}
		br.close();//역시 닫아준다
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWrite();
		FileRead();
		
		/*
		 * 버퍼를 가지고 읽음. 
		 * 뭐 몇 바이트 버퍼를 하든지 무지 큰 파일을 어떻게 읽든지는 
		 * 클래스가 알아서.. 
		 * readLine() 같은 함수를사용하여 한줄(\n)단위로 읽는다
		 * IOException을 클래스 위로 던져서 시스템 메시지로 받는예.. 
		 * Close를 안하면 계속 파일이 열려있어서 제어할 수 가 없다.
		 */
	
	}

}
