package programing_8��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class �ǽ�_�Ｚ����_�����ڵ� {
	//�����Ϳ��� Ư�� �ڵ尪�� ����

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//���� ����
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
					+ "\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		//���� �� ����
		File f1 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
					+ "\\A005930.csv");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

		String readtxt;

		int cnt = 0;//��ü ���� row �� �� ����
		int wcnt = 0;//������ ������ row �� �� ����
		while ((readtxt = br.readLine()) != null) {
			
			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%"); 
		
			if (field.length > 2 && field[2].replace("^", "").trim().equals("A005930")) { 
				//Ư�� �����ڵ常 ��Ƴ��� ������ ���꽺Ʈ�� �Լ� �ʿ� ����
				
				s.append(field[0].replace("^", "").trim());//ù�ʵ� ����
				
				for (int j = 1; j < field.length; j++) {//������ �ʵ� ����
					s.append("," + field[j].replace("^", "").trim()); 
				}
				
				bw1.write(field[2].replace("^", "").trim());
				//�ڵ尪�� ���� �� �����ϰ� ������ s.toString()�� ������
				bw1.newLine(); // ���Ͽ� ����
				wcnt++;
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}

		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
		//�� 9841��
	}

}
