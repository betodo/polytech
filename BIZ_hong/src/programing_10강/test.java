package programing_10��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		File f = new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�"
				+ "\\StockDailyPrice.csv"); //dat=DB�� �������� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		int LineCnt =0;
		int n =-1; //���� �� ������ �ʿ��� ����
		StringBuffer s = new StringBuffer();
		
		while(true) {
			
			char[] ch = new char[100];//char�迭�� �б�
			
			n = br.read(ch);//������ ch(�迭)�� �о� �ѱ��ھ� n�� ����
		
			if (n == -1)break;
			
			for(char c : ch) { //=for (int i=0;i<n;i++) { ���� ��
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
