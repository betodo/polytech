package programing_8��;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class �Ÿ����_�ǽ�3 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�" 
				+ "\\����������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		
		
		String readtxt;

		if ((readtxt = br.readLine()) == null) {
			System.out.printf("�� �����Դϴ�\n");
			return;
		}

		String[] field_name =readtxt.split("\t");//�ʵ�� ���

		double lat = 37.386000; //���۸� ���� ����� ����
		double lng = 127.121346;//���۸� ���� ����� �浵
		
						   //���Ϲ��� ���� ó������ �񱳰����� �ޱ�����
		double maxDist =0; //�ʱ�ƽ��� �����ͻ� �� ����̹Ƿ� 0
		double minDist =10000;//�ʱ�ΰ� ���������� ū���� ��
		
		String maxPlace =null;
		String maxAddr =null;//����հ��� ��µ�����
		String maxlat =null;
		String maxlng =null;
		
		String minPlace =null;
		String minAddr =null;// ���尡��� ���� ��µ�����
		String minlat =null;
		String minlng =null;
		
		int LineCnt = 1; // ���°�׸����� ����
		int maxLineCnt =1;
		int minLineCnt =1;
		
		while ((readtxt = br.readLine()) != null) {

			String[] field = readtxt.split("\t");
			try {//����or�浵�� ��������� ����=����ó������
			
			double dist = Math.sqrt(// ������ �Ÿ�(��Ÿ�������)
						Math.pow(Double.parseDouble(field[28]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[29]) - lng, 2));
			
			//����հ�
			if (maxDist < dist) {
				maxDist = dist; //�ƽ��� ã��
				maxPlace = field[1];
				//�ּ����
				if(field[4].isBlank()) {//�����ּҰ� �ȳ���������
					maxAddr = field[5];//���θ��ּҷ�
				}else {
					maxAddr = field[4];
				}
				if (field[4].isBlank() && field[5].isBlank()) { //�Ѵ� ������
					maxAddr = "�ּҾ���";}//�ּҾ�������
				
				maxlat = field[28];
				maxlng = field[29];
				maxLineCnt =LineCnt;
			}
			//���尡���� (����հ��� ���� ����)
			if (minDist > dist) {
				minDist = dist; //�ΰ� ã��
				minPlace = field[1];
				//�ּ����
				if(field[4].isBlank()) { //���θ� �ּ� ������
					minAddr = field[5]; //�����ּ�
				}else {
					minAddr = field[4];
				}
				if (field[4].isBlank() && field[5].isBlank()) { //�Ѵ� ������
					minAddr = "�ּҾ���";}
				
				minlat = field[28];
				minlng = field[29];
				minLineCnt =LineCnt;
			}
			}catch (Exception e) {
				
			}
			LineCnt++;
		}
		br.close();
		
		//���
		//�����
		System.out.printf("**[%d��° �׸�]*************\n", maxLineCnt);
		System.out.println("���� �� �� : " + maxPlace);
		System.out.println("���� �Ǵ� ���θ� �ּ� : " + maxAddr );
		System.out.println(field_name[28] + " : " + maxlat );
		System.out.println(field_name[29] + " : " + maxlng );
		System.out.printf("��������� �Ÿ� : %f\n", maxDist);
		System.out.println("******************************");
		//���� �����
		System.out.printf("**[%d��° �׸�]*************\n", minLineCnt);
		System.out.println("���� ����� �� : " + minPlace);
		System.out.println("���� �Ǵ� ���θ� �ּ� : " + minAddr);
		System.out.println(field_name[28] + " : " + minlat );
		System.out.println(field_name[29] + " : " + minlng );
		System.out.printf("��������� �Ÿ� : %f\n", minDist);
		System.out.println("******************************");
	}

}
