package programing_8��;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class �����ϰ�_�а�_���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ���۾��� char[N]���� �迭�� ��� �б� 
		 * �ڹ��� exceptionó�� (try {}catch(e){} ���� ) ������ ���ٵ���,
		 * �ϵ��ũ ��������� ���ٵ��� 
		 * ���丮�� C:\�� �����ϰ� �ǽ� 
		 * HanCount�� �־��� ���ڿ��� �ѱۼ��� ������
		 */	
		try {
			File f = new File("C:\\Users\\admin\\Desktop\\"//���ϻ���(��ν���)
					+ "��\\ȫ�ʵα��������Ͻǽ�\\8lecTest.txt");
			
			FileWriter fw = new FileWriter(f);//���Ͼ��� Ŭ���� �ҷ��ͼ� ���� ����
				
			fw.write("�ȳ� ����\n");
			fw.write("hello ���\n");//���Ͽ��� ���� ���๮�ڴ� �ڹٿ� �����찡 �޶� �ȸ���
			
			fw.close();//Ŭ������ �����ؼ� �޸𸮴��� ���´�
			
			FileReader fr =  new FileReader(f);//���ϸ��� Ŭ������ �����б�
			
			int n=-1; //���� �� ������ �ʿ��� ����
			char[] ch;//char �迭�� �ϱ�
			
			while (true) {
				ch = new char[100];
				n = fr.read(ch);//�迭�� ��� ���� �����ϳ��� �о n�� ����
				
				if (n ==-1)break;//���̻� ���� ���ڰ� ������ �����б� ����
				
				for (int i=0;i<n;i++) {
				//	for (char : c) {}�� �ᵵ��
					System.out.printf("%c",ch[i]); //�ѱ��ھ� �о �ڹٿ� ���
				}
			}
			fr.close();
			System.out.printf("\n FILE READ END"); //��ġ�� �����б� ������ ���
			
		}catch(Exception e){
			System.out.printf("�� ����[%s]\n",e); //���� ������ ��µ�
		}

	}

}
