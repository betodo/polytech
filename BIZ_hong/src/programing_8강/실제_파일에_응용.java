package programing_8��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ����_���Ͽ�_���� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// \�� Ư�����̹Ƿ� \\�ΰ��� ����Ѵ�
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����.csv");//csv���� ���ı��� �����ؾ�
		//���۸����� ���� �б�
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		//readtxt�� ���� ����
		if((readtxt=br.readLine())==null) { //������ Ȥ�� ���������� �˻�
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		
		String[] field_name =readtxt.split(","); //ù���б�=�ʵ��
												//��������� \n�������� �ϱ� ������
		                                      //������ ���� �о�� �ʵ���� �� �� �ִ�.
		int LineCnt=0;//�ټ� �� ����
		while ((readtxt = br.readLine()) !=null) {
			
			String[] field =readtxt.split(","); // ������������� �� ������
			System.out.printf("**[%d��° �׸�]***************\n",LineCnt);
			
			for(int j=0 ; j < field_name.length ; j++) {//field_name.length=�ʵ��� ���� 
														//length�� 1���ͼ��� �׷��� �� ����
				System.out.printf(" %s : %s\n",field_name[j],field[j]);
			}
			System.out.println("******************************");
			if (LineCnt == 100)break; // 100�ٸ� �аڴ� �Ҹ�
			LineCnt++;
		}
		br.close();
		
	}

}
