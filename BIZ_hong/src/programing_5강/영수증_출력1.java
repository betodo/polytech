package programing_5��;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ������_���1 {
	//�ֹ��հ��= input��, ����&���� ���
	//�ð������Լ����
	//��Ʈ,����,���� ����
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//����
		int iPrice = 14000; //���ұݾ�
		double taxRate = 10;//����
		int taxBase; 
		int tax;
		
		
		//����,���ݰ��
		// taxBase = (int)(iPrice / (1 + taxRate/100.0));
		// tax = iPrice -taxBase
		if (iPrice/(100+taxRate)==(int)(iPrice/(100+taxRate))) {//�Ҽ��� �ȳ����� ����������
			tax = (int)(iPrice/(100+taxRate)*taxRate);//���ݱ��ϴ� ����
		}else {
			tax = (int)(iPrice/(100+taxRate)*taxRate)+1;//�Ҽ��� ����
														//���� �Ҽ��� ������ ������ 1���ø���
														//�Ҽ��� ���� ó��
		}
		taxBase = iPrice - tax;//�����ݾ�
		
		//������ ���
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");//�޸� ���
		
		System.out.printf("%23s\n","��  ��  ��");
		System.out.println("==========================================");//��ü42ĭ
		System.out.println("���λ�ȸ(�д缭����)  129-17-77924");
		System.out.println("�̻�ö  031 781 1596");
		System.out.println("������ �д籸 ������ 269-3");
		System.out.println("���̺�� : 12");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYYMMdd");//��¥ ����
		SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		Calendar calt = Calendar.getInstance();
		
		System.out.printf("�ֹ���ȣ : %s 01 00041\n",sdf1.format(calt.getTime()));
		System.out.println("==========================================");
		System.out.printf("�ֹ��հ�%34s\n",df.format(iPrice));
		System.out.printf("���αݾ�%34s\n","0");
		System.out.printf("�����ݾ�%34s\n",df.format(iPrice));
		System.out.println("==========================================");
		System.out.printf("��  ��%13s    ��  ��%13s\n","0",df.format(taxBase)); //ī��θ� ��� ����
		System.out.printf("ī  ��%13s    ��  ��%13s\n",df.format(iPrice),df.format(tax));
		System.out.printf("��  ��%13s    ��  ��%13s\n","0","0"); // ����Ʈ, �鼼 ����
		System.out.printf("%27s%11s\n","�����ݾ�",df.format(iPrice));
		System.out.println("==========================================");
		System.out.printf("%23s\n","[�츮ī�� �ſ� ����]");
		System.out.printf("�� �� �� �� : %s\n",sdf2.format(calt.getTime()));
		System.out.println("ī �� �� ȣ : 55222059****2021");
		System.out.println("�� �� �� ȣ : 79753574  �Һΰ��� : 00");
		System.out.printf("%s %s\n","�� �� �� �� :",df.format(iPrice));
		System.out.println("�� �� �� ȣ : 730461774  /  ��ī���");
		System.out.println("����� ��ȣ : 129-17-77924");
		System.out.println("==========================================");
		System.out.printf("%s  CASHIER : %12s\n",sdf3.format(calt.getTime()),"����");
		System.out.println("==========================================");
		System.out.print("���� �մϴ�.");
		
	}

}







































