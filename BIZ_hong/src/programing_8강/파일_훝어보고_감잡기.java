package programing_8��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ����_�m���_����� {
		// 30��ġ �ְ�������
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//���� ����
		File f = new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�"
				+ "\\THTSKS010H00.dat"); //dat=DB�� �������� ����
		BufferedReader br = new BufferedReader(new FileReader(f));//���۷� �б�
		
		
		int LineCnt =0;
		int n =-1; //���� �� ������ �ʿ��� ����
		StringBuffer s = new StringBuffer(); //������ ������ ����
		
		while(true) { //��� ���ư� �ꐞ���� ������
			
			char[] ch = new char[100];//char�迭�� �б� �迭ũ��� 100��
			
			n = br.read(ch);//������ ch(�迭)�� �о� �ѱ��ھ� n�� ����
		
			if (n == -1)break;
			
			for(char c : ch) { //=for (int i=0;i<n;i++) { ���� ��
				if ( c == '\n') {//�ѱ��ھ� �дٰ� ���๮�� ������
					System.out.printf("[%s]***\n",s.toString());//���
					s.delete(0, s.length());//���� �� �о����� �ʱ�ȭ(�����)
				}else {
					s.append(c);//���๮�� �ƴϸ� ��� �ѱ��ھ� ����
				}
			}
			LineCnt++;//�ټ� �÷��ְ�
		
		}
		System.out.printf("[%s]***\n",s.toString());//���๮�� �� ������ ���
		br.close();
		
	}

}

//20~30��ġ �� ���� �ְ������͸� �޾ƿԴ�.
//�� ������ �����ͺ��̽��� �������� �����̴�. 
//�����ͺ��̽� �������ϵ� �޾Ƽ� ���� ������ �˵��ϴ�
//ũ�Ⱑ �ʹ� Ŀ�� �޸��� ���� �о������� �ʴ´�. 
//�ϳ��� �о�� ���� ����� ����
//��..���پ� �����Ͱ� ���� �ְ�, �����ڷ� �и��� �����̴�.































