package programing_8강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class 파일_훝어보고_감잡기 {
		// 30년치 주가데이터
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//읽을 파일
		File f = new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습"
				+ "\\THTSKS010H00.dat"); //dat=DB를 덤프받은 파일
		BufferedReader br = new BufferedReader(new FileReader(f));//버퍼로 읽기
		
		
		int LineCnt =0;
		int n =-1; //파일 다 읽을때 필요한 변수
		StringBuffer s = new StringBuffer(); //읽은걸 저장할 변수
		
		while(true) { //계속 돌아감 브맄으로 나가기
			
			char[] ch = new char[100];//char배열로 읽기 배열크기는 100개
			
			n = br.read(ch);//파일을 ch(배열)로 읽어 한글자씩 n에 저장
		
			if (n == -1)break;
			
			for(char c : ch) { //=for (int i=0;i<n;i++) { 같은 뜻
				if ( c == '\n') {//한글자씩 읽다가 개행문자 만나면
					System.out.printf("[%s]***\n",s.toString());//출력
					s.delete(0, s.length());//한줄 다 읽었으니 초기화(비워줌)
				}else {
					s.append(c);//개행문자 아니면 계속 한글자씩 붙임
				}
			}
			LineCnt++;//줄수 늘려주고
		
		}
		System.out.printf("[%s]***\n",s.toString());//개행문자 안 만난애 출력
		br.close();
		
	}

}

//20~30년치 전 종목 주가데이터를 받아왔다.
//이 파일은 데이터베이스를 덤프받은 파일이다. 
//데이터베이스 구조파일도 받아서 대충 구조도 알듯하다
//크기가 너무 커서 메모장 등은 읽어지지도 않는다. 
//하나씩 읽어보고 찍어보고 감잡아 본다
//음..한줄씩 데이터가 쓰여 있고, 구분자로 분리된 파일이다.































