package programing_8��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ���Ϻи�_�����ͺ��� {
	//���� �����ٰ� �ڷ� ���ļ� ���� ����
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// \�� Ư�����̹Ƿ� \\�ΰ��� ����Ѵ�
		//���� ����
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		//���� �� ����
		File f1 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����_SKT.txt");
		File f2 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����_KT.txt");
		File f3 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����_LGU.txt");
		
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));
		
		String readtxt;
		
		if((readtxt=br.readLine())==null) { //�ʵ�� �б�
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		
		//ù��(�ʵ��)�� ��� ���Ͽ� �� ����.
		bw1.write(readtxt); bw1.newLine();
		bw2.write(readtxt); bw2.newLine();
		bw3.write(readtxt); bw3.newLine();
		
//		String[] field_name =readtxt.split(","); //ù���б�=�ʵ��
												//��������� \n�������� �ϱ� ������
		
		int LineCnt=0;
		while((readtxt= br.readLine()) != null) {
			
			String[] field = readtxt.split("\t"); //������ �и��ؼ� ���� ������
			
			if(field[5].trim().contains("SK")) { //.equals�ϸ� ������ �ٿ������ �ٸ��� ����
												 // �׷��� ���������� �ٲ�
				bw1.write(readtxt);//����f���� �� ����f1�� ��
				bw1.newLine();
			} else if(field[5].trim().contains("KT")) {//�������̰� kt�� kt���Ͽ�
				bw2.write(readtxt);
				bw2.newLine(); //���Ͼ��� ���๮�� ��Ŭ������ �ڹٶ� �ٸ��ϱ� ��
			} else if(field[5].trim().contains("LGU+")) {//������ 2���� ����̴�.
				bw3.write(readtxt);
				bw3.newLine();
			} else if(field[5].trim().contains("LG U+")) {
				bw3.write(readtxt); 
				bw3.newLine();
			} else { // �𸣰ڴ� ��Ż�� ���°�٤�= ������ ��==��
				System.out.printf("�˼� ���� ��Ż� [%d��° �׸�][%s]***\n", LineCnt, field[5]);
			}
			LineCnt++;
		}
		br.close();//�������� ����
		bw1.close();
		bw2.close();
		bw3.close();
	}

}



















