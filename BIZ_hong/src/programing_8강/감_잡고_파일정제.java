package programing_8��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ��_���_�������� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//��������
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�\\THTSKS010H00.dat"); 
		// dat=DB�� �������� ����
		BufferedReader br = new BufferedReader(new FileReader(f));
		//���� ������
		File f1 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�\\StockDailyPrice.csv");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

		String readtxt; //������ ������ ����

		int cnt = 0;//��ü ���� row �� �� ����
		int wcnt = 0;//������ ������ row �� �� ����
		
		while ((readtxt = br.readLine()) != null) {//���� �� �б�
			
			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%"); // �����ڸ� %_% �� ��� �ʵ� ����
			
			// ������ ���� �� ���ϴ� �ʵ� ����
			if (field.length > 2 && field[2].replace("^","").trim().substring(0, 1).equals("A")) { //�����ڵ�A���
				//�ڷẸ�ϱ� ������ �ʵ� �ϳ� �ְ� ��������� --�ǹ� ���� �ֵ�
				//�����ڵ尡 A�� �ֵ鸸 �ǹ� ����
				s.append(field[0].replace("^","").trim()); // ù�ʵ� ^���� �� ���� �߰�
														//��ǥ�ڵ� ���̷��� ó���� ����
				
				for (int j = 1; j < field.length; j++) { // ������ �ʵ� ��ǥ �ٿ��ְ� ^������ ���� �߰�
					s.append("," + field[j].replace("^","").trim()); 
				}
				
				bw1.write(s.toString());//�ϼ��� ���۸� ��Ʈ������ �ٱ ��
				bw1.newLine(); // ���๮�� �������
				wcnt++;
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}

		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
