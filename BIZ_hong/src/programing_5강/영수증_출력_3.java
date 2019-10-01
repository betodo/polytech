package programing_5��;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ������_���_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//����
		//ǰ��
		String[] itemName = {"��������","�ٳ�������","������","�������ֽ�","���ڿ���","�ı�ġ",
				"Ǯ����ġ��&ġ��","���ǹ���Ƽ","�������","���̱�ġ","��Ƽ�� 100��",
				"�ȵ��նѲ�","��� 1kg","�����۽� BBQ","[��귻��]���� 2L","�ø��� ¥�İ�Ƽ",
				"CJ �޹�","ũ���ؽ� 3�� 3��","���Ѷ��� 1.5L","[Ȩ��Ÿ]��Ǽ�����","���� ���ټ���",
				"��õ�� 2kg","�����ġ�ɾ� ġ��","[��귣��]������3p","���尩","�ＤǪ",
				"[��귣��]����ȣ��","������","[�Ƶ�ٽ�]���۽�Ÿ","���"};
		
		//����
		int[] price = {12343780,15000,2980,4900,1000,2530,3310,5000,13300,1700,100,990,1440,4250,2750,
				9800,5180,900,9900,9800,5000,4060,10130,3500,25000,800,20000,550,4560,520};
		//����
		int[] num ={2,100,2,4,1,3,1,5,1,1,1,7,4,2,2,
				8,1,1,1,2,1,2,1,3,2,6,9,1,5,1};
		
		//�鼼����
		boolean[] taxFree ={false,false,true,false,false,true,false,false,true,true,false,false,true,false,false,
				false,false,false,false,false,false,true,false,false,false,false,false,false,false,true};
		
		// ���
		// �鼼��ǰ �Ѱ���
		int taxFree_totalPrice=0;
		for (int i =0 ; i <itemName.length ; i++) {
			if (taxFree[i] == true) {
				taxFree_totalPrice = taxFree_totalPrice + price[i]*num[i]; 
			}
		}
		// ����ǰ �Ѱ���
		int totalPrice =0;
		for (int i =0 ; i <itemName.length ; i++) {
				totalPrice = totalPrice + price[i]*num[i]; 
		}
		
		// ������ǰ �Ѱ���(�鼼��ǰ �Ѱ��� - ����ǰ �Ѱ���)
		int beforeTaxPrice = totalPrice - taxFree_totalPrice;
		
		// ���ݰ��
		double taxRate = 10;
		
		int taxBase;
		int tax;
		
		if (beforeTaxPrice/(100+taxRate)==(int)(beforeTaxPrice/(100+taxRate))) {//�Ҽ��� �ȳ����� ����������
			tax = (int)(beforeTaxPrice/(100+taxRate)*taxRate);//���ݱ��ϴ� ����
		}else {
			tax = (int)(beforeTaxPrice/(100+taxRate)*taxRate)+1;//�Ҽ��� ����
														//���� �Ҽ��� ������ ������ 1���ø���
														//�Ҽ��� ���� ó��
		}
		taxBase = beforeTaxPrice - tax;//�����ݾ�
		

//		double x; // ���� �ݿø� ó��
//		x = (beforeTaxPrice / (1 + taxRate / 100));// �����ݿø� ���� ������ ���� ����
//		if ((x * 10) % 10 >= 5)
//			x = (int) x + 1;// �Ҽ���1�ڸ� 5�̻��̸� �ݿø�
//
//		taxBase = (int) x; // ���� (int�� ���ϱ�)
//		tax = beforeTaxPrice - taxBase;// ����

		//���
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		Calendar calt = Calendar.getInstance();
		
		System.out.println("                 �̸�Ʈ ������ (031)888-1234");
		System.out.println("      emart      206-86-50913�̰���");
		System.out.println("                 ���α� ������ ������� 552");
		System.out.println();
		System.out.println("������ �������� ��ȯ/ȯ�� �Ұ�(30���̳�)");
		System.out.println("��ȯ/ȯ�� ���������� ����(����ī������)");
		System.out.println("üũī��/�ſ�ī�� û����� �ݿ���");
		System.out.println("�ִ� 3~5�� �ҿ� (�ָ�,����������)");
		System.out.println();
		System.out.printf("[�� ��]%s %24s\n",sdf1.format(calt.getTime()),"POS:0009-2418");
		System.out.println("------------------------------------------------"); // �� 48ĭ
		System.out.printf("%4s%21s%3s%8s\n","  �� ǰ ��","�� ��","����","�� ��");
		System.out.println("------------------------------------------------");
		
		
		//�׸����
		String star = null;
		for (int i =0 ; i <itemName.length ; i++) {
			
			//�鼼��ǰ ��ǥ���
			if (taxFree[i] == true) {star ="*";}
			else {star ="";}
			
			System.out.printf("%02d%-2s%s",i+1,star,itemName[i]);
			
			//ǰ���� �������
			for (int blank =0 ; blank <19-itemName[i].getBytes().length ; blank++) {
				//����Ʈ�� ��� ��밡���ϰ� ������-int�� ����
				System.out.printf("%s"," ");
			}// 
			
			//������ �ܰ� ���� �ݾ� ���
			System.out.printf("%10s%4s%11s\n",df.format(price[i]),num[i],
					df.format(price[i]*num[i]));
		}
		
		
		System.out.println();
		System.out.printf("%22s%22s\n","(*)�� �� �� ǰ",df.format(taxFree_totalPrice));
		System.out.printf("%22s%22s\n","�� �� �� ǰ",df.format(taxBase));
		System.out.printf("%23s%22s\n","��   ��  ��",df.format(tax));
		System.out.printf("%24s%22s\n","��       ��",df.format(totalPrice));
		System.out.printf("�� �� �� �� �� ��%31s\n",df.format(totalPrice));
		System.out.println("------------------------------------------------");
		System.out.printf("0024 ��  ��%37s\n","5417**8890/07850246");
		System.out.printf("ī�����%37s\n","�Ͻú� / "+df.format(totalPrice));
		System.out.println("------------------------------------------------");
	}

}




