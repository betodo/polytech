package programing_8��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class freeWifi {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// �ǽ�1

		File f = new File("C:\\Users\\admin\\Desktop\\ȫ�ʵα��������Ͻǽ�" + 
							"\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;

		if ((readtxt = br.readLine()) == null) {//���Ǿȿ� �־ readLine�ѹ� �����
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		String[] field_name = readtxt.split("\t");// �ʵ��

		double lat = 37.3860521;
		double lng = 127.1214038;

		int LineCnt = 1;
		while ((readtxt = br.readLine()) != null) {

			String[] field = readtxt.split("\t");
			System.out.printf("**[%d��° �׸�]***************\n", LineCnt);
			System.out.printf(" %s : %s\n", field_name[9], field[9]);// 9��° : �����ּ�
			System.out.printf(" %s : %s\n", field_name[12], field[12]);// 12��° : �����ּ�
			System.out.printf(" %s : %s\n", field_name[13], field[13]);// 13��° : �浵�ּ�

			double dist = Math.sqrt(// ������ �Ÿ�(��Ÿ�������)
					Math.pow(Double.parseDouble(field[12]) - lat, 2)
							+ Math.pow(Double.parseDouble(field[13]) - lng, 2));

			System.out.printf(" ������������ �Ÿ� : %f\n", dist);
			System.out.println("******************************");
			if (LineCnt == 100)
				break;
			LineCnt++;
		
		}
		br.close();

//��������������� ǥ�ص�����.csv�� �����Ͱ� �����̶� �������� ������ �и��Ǵ� txt���Ϸ� ����. �տ��� �ʵ庰 ������ �����°�
//��(a,b) ��(c,d)���� �Ÿ��� ��Ÿ��� ���� ������� �������̿� ������ �Ÿ����

	}

}
