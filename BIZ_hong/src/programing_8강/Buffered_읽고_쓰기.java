package programing_8��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered_�а�_���� {
	public static void FileWrite() throws IOException{
		//���� �̸��� ���� ������ ��� ����
		File f = new File ("C:\\Users\\admin\\Desktop\\"
				+ "��\\ȫ�ʵα��������Ͻǽ�\\8lecTest2.txt");
		//���۶����ͷ� ���� ����
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		
		bw.write("�ȳ� ����");//���Ͼ���
		bw.newLine(); //���Ͼ��� ���๮�� �̷��� ���
		bw.write("hello ���");
		bw.newLine();
		
		bw.close();//Ŭ������ �������� ����
			
	}
	
	public static void FileRead() throws IOException{
		//���� ���� ����
		File f = new File ("C:\\Users\\admin\\Desktop\\"
				+ "��\\ȫ�ʵα��������Ͻǽ�\\8lecTest2.txt");
		//���� ������ ���� �б�
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;//���� ������ ������ ����
		
		while((readtxt= br.readLine())!=null) {//���� ������ ������ �׸�
			System.out.printf("%s\n",readtxt);//������ ���
		}
		br.close();//���� �ݾ��ش�
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWrite();
		FileRead();
		
		/*
		 * ���۸� ������ ����. 
		 * �� �� ����Ʈ ���۸� �ϵ��� ���� ū ������ ��� �е����� 
		 * Ŭ������ �˾Ƽ�.. 
		 * readLine() ���� �Լ�������Ͽ� ����(\n)������ �д´�
		 * IOException�� Ŭ���� ���� ������ �ý��� �޽����� �޴¿�.. 
		 * Close�� ���ϸ� ��� ������ �����־ ������ �� �� ����.
		 */
	
	}

}
