package progaming_3��;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class �޸���_���糯¥_�ð���� {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int MyWon = 1000000;
		double MoneyEx = 1238.21;
		double commission = 0.003;
		double ComPerOne = MoneyEx * commission;
		int usd = (int)(MyWon/(MoneyEx + ComPerOne));
		double totalcom = usd * ComPerOne;
		int i_totalcom;
		if ( totalcom != (double)((int)totalcom)) {
			i_totalcom = (int)totalcom +1;
		} else {
			i_totalcom = (int)totalcom;
		}
		
		//���� ���ڸ����� �޸��� ��´� �̰� �ϱ�
		//DecimalFormat �̶�� Ŭ������ ������ ���� ����Ʈ�ϴ� ��� ����
		//Ŭ���� �Է��� ctrl shift o ������ = �ڵ� ����Ʈ or ���� ���콺Ŀ�� ���� �Է�
		
		// %d=���� %f=�Ǽ� %s=���ڿ� decimal ���˾��� ���ڿ��Ǵ� �� �ٲ������
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		System.out.println("****************************************************");
		System.out.println("*              �޸����, ��¥ ����                    *");			
		System.out.printf("�� ������: %s��=> ��ȭ: %s�޷�, �޷��� ������: %f��\n", 
				df.format(i_totalcom),
				df.format(usd),
				ComPerOne);
	
		int remain = (int)(MyWon-usd*MoneyEx - i_totalcom);
		System.out.printf("�� ��ȭȯ���ݾ�: %s��=> ��ȭ: %s�޷�, ������û��: %s��, �ܵ� :%s��\n", 
				df.format(MyWon),df.format(usd),df.format(i_totalcom),df.format(remain));
		
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		Calendar calt = Calendar.getInstance();
		
		System.out.printf("��������ð�: %s\n", sdt.format(calt.getTime()));
		
		System.out.println("****************************************************");
		
		
		
		
		
		
	}

}
