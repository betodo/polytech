package programing_5��;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ������_���2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����
		String itemName1, itemName2;
		String itemCode1, itemCode2;
		int price1, price2;
		int num1, num2;
		
		itemName1="������ ���� �̼��� D12";
		itemCode1="77778889999";
		price1 =23900; num1=1;
		
		itemName2="�𽽷��� Ŭ����";
		itemCode2="132121212331";
		price2 =3430; num2=8;
		
		//����, ���� ���
		int iPrice = (price1 * num1) + (price2 * num2);
		double taxRate = 10;
		int taxBase; 
		int tax;
		
		double x;  //���� �ݿø� ó��
		x = (iPrice/(1+taxRate/100));//�����ݿø� ���� ������ ���� ����
		if ((x*10)%10 >= 5) x =(int)x+1;// �Ҽ���1�ڸ� 5�̻��̸� �ݿø�
		
		taxBase = (int)x; //���� (int�� ���ϱ�)
		tax = iPrice - taxBase;//����
				
		//���
		//���� �����ڸ��� �޸�
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		System.out.println("����(����)�ްԼ�");
		System.out.println("������ֽð��ݸ������380-4");
		System.out.println("�ֺ��� 677-85-00239 TEL:043-857-9229");
		System.out.println("\n");
		//��¥�ޱ�
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYYMMdd");
		Calendar calt = Calendar.getInstance();
		
		System.out.printf("[������]%s 190049%15s\n",sdf1.format(calt.getTime()),
				"POS��ȣ: 0002");
		System.out.println("------------------------------------------"); // ��ĭ 42
		System.out.printf("ǰ���ڵ�%17s  ����%7s\n","�ܰ�","�ݾ�");
		System.out.println("------------------------------------------");
		System.out.printf("%s\n",itemName1);
		System.out.printf("10%s%14s%6s%9s\n",itemCode1,df.format(price1),
				df.format(num1),df.format(price1*num1));
		System.out.printf("10%s\n",itemName2);
		System.out.printf("%s%14s%6s%9s\n\n",itemCode2,df.format(price2),
				df.format(num2),df.format(price2*num2));
		
		
		System.out.printf("���� ��ǰ �հ�%28s\n",df.format(taxBase));
		System.out.printf("��    ��    ��%28s\n",df.format(tax));
		System.out.printf("��          ��%28s\n",df.format(iPrice));
		System.out.printf("026-��ī���%28s\n","00/00A");
		String cardNum ="5522-20**-****-BADD";
		System.out.printf("ī  ��  ��  ȣ :%26s\n",cardNum);
		System.out.printf("ī  ��  ��  �� :%26s\n",df.format(iPrice));
		System.out.printf("��  ��  ��  �� :%23s\n","�Ͻú�");
		System.out.printf("��  ��  ��  ȣ : 04-KICC%18s\n","75549250");
		System.out.printf("�� �� �� �� ȣ :\n");
		System.out.printf("��  ��  ��  �� :%26s\n",df.format(iPrice));
		System.out.printf("��    ��    �� :%26s\n","0");
		System.out.println("------------------------------------------");
		System.out.printf("�ֹ���ȣ :%11s\n","0920");
		System.out.println("------------------------------------------");
		System.out.println("�Ǹſ� : 000002 ������2");
		System.out.printf("%s-0002-0922\n",sdf1.format(calt.getTime()));
		System.out.printf("�������:{00138705  %s190049]\n",sdf1.format(calt.getTime()));
	}

}








































