package programing_8��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class �ǽ�_Ư������_���� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//���� ����
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�" 
					+ "\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		//�� ����
		File f1 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
					+ "\\20150112_all.csv");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

		String readtxt;

		int cnt = 0;//��ü ���� row �� �� ����
		int wcnt = 0;//������ ������ row �� �� ����
		while ((readtxt = br.readLine()) != null) {

			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%");

			if (field.length > 2 //���� �ڵ带 ��� ������ ��ȿ���� ���� ����(������) ġ����
					&& field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
				
				if(field[1].replace("^", "").trim().equals("20150112")) { //Ư����¥

					s.append(field[0].replace("^", "").trim());
	
					for (int j = 1; j < field.length; j++) {
						s.append("," + field[j].replace("^", "").trim());
					}
	
					bw1.write(s.toString()); //���۸� ���������� �ٲ� �� ���Ͽ��� ��
					bw1.newLine(); 
					wcnt++;
				
				}
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}

		br.close();
		bw1.close();

		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);

	}

}
