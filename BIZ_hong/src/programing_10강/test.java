package programing_10강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("C:\\Users\\admin\\Desktop\\홍필두교수님파일실습"
				+ "\\StockDailyPrice.csv"); //dat=DB를 덤프받은 파일
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		int LineCnt =0;
		int n =-1; //파일 다 읽을때 필요한 변수
		StringBuffer s = new StringBuffer();
		
		while(true) {
			
			char[] ch = new char[100];//char배열로 읽기
			
			n = br.read(ch);//파일을 ch(배열)로 읽어 한글자씩 n에 저장
		
			if (n == -1)break;
			
			for(char c : ch) { //=for (int i=0;i<n;i++) { 같은 뜻
				if ( c == '\n') {
					System.out.printf("[%s]***\n",s.toString());
					s.delete(0, s.length());
				}else {
					s.append(c);
				}
			}
			LineCnt++;
		
		}
		System.out.printf("[%s]***\n",s.toString());
		br.close();
		
	}
}
