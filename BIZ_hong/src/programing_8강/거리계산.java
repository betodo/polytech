package programing_8��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class �Ÿ���� {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	// �ǽ�2 ������� ���� ����,�� �� ã��
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�" 
				+ "\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;

		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		//�ʵ�� ù�� �а� �и�
		String[] field_name =readtxt.split("\t");//�ʵ�� ���

		double lat = 37.3860521; //���������
		double lng = 127.1214038;//������浵
		
						   //���Ϲ��� ���� ó������ �񱳰����� �ޱ�����
		double maxDist =0; //�ʱ�ƽ��� �����ͻ� �� ����̹Ƿ� 0
		double minDist =10000;//�ʱ�ΰ� ���������� ū���� ��
		
		String maxPlace =null; //����հ��� ��µ�����
		String maxlat =null;
		String maxlng =null;
		
		String minPlace =null;// ���尡��� ���� ��µ�����
		String minlat =null;
		String minlng =null;
		
		int LineCnt = 1; // ���°�׸����� ����
		int maxLineCnt =1;
		int minLineCnt =1;
		
		while ((readtxt = br.readLine()) != null) {//������ �б�

			String[] field = readtxt.split("\t");//������ ������ �ʵ忡 ����
			
			double dist = Math.sqrt(// ������ �Ÿ�(��Ÿ�������)
						Math.pow(Double.parseDouble(field[12]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[13]) - lng, 2));

			if (maxDist < dist) {//�ƽ��� ã��
				maxDist = dist;  // �ϳ��� ��� ���س��� �ƽ��� �� ������ ū������
				maxPlace = field[9];//�׶��� ���
				maxlat = field[12];//�׶��� ���浵
				maxlng = field[13];
				maxLineCnt =LineCnt;//�׶��� �ټ�
			}
			
			if (minDist > dist) {//�ΰ��� ��������
				minDist = dist; 
				minPlace = field[9];
				minlat = field[12];
				minlng = field[13];
				minLineCnt =LineCnt;
			}
			
			LineCnt++;//���� �������� ���� �������� �ٽ� ���Ϲ� �������� �ټ� �÷���
		}
		br.close();
		
		//���
		System.out.printf("**[%d��° �׸�]*************\n", maxLineCnt);
		System.out.println("����հ�");
		System.out.println(field_name[9] + " : " + maxPlace );
		System.out.println(field_name[12] + " : " + maxlat );
		System.out.println(field_name[13] + " : " + maxlng );
		System.out.printf("��������� �Ÿ� : %f\n", maxDist);
		System.out.println("******************************");
		System.out.printf("**[%d��° �׸�]*************\n", minLineCnt);
		System.out.println("���尡����");
		System.out.println(field_name[9] + " : " + minPlace );
		System.out.println(field_name[12] + " : " + minlat );
		System.out.println(field_name[13] + " : " + minlng );
		System.out.printf("��������� �Ÿ� : %f\n", minDist);
		System.out.println("******************************");
		
	}
}
//////////////////////////////////////////////////////////////////////////////////		
		
		