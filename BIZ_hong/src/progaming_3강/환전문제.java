package progaming_3��;

public class ȯ������ {
	//������ ���� ���� �ʴ´�!!!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// �ܼ� ȯ�� ��� (ȯ�� �������� X)
		
		int MyWon = 1000000;       // ȯ���� ��
		double MoneyEx = 1238.21;  // ȯ��
		double commission = 0.003; // ȯ�� ��������
		
		//���డ�� ȯ���ϸ� ���� �ش�.(���� ��Ʈ ����)
		int usd = (int)(MyWon/MoneyEx);       //������� ����ó�� = ���� ���(�Ҽ�������=����)
		int remain = (int)(MyWon-usd*MoneyEx);//������ ������ �ܵ��� �Ҽ������� �ݾ��� �涥�ؾ�(����ó��)
		
		System.out.println("=========================================");
		System.out.println("*              ������ ���� ���                            *");
							
		System.out.printf("�� ��ȭȯ���ݾ�: %d��=> ��ȭ: %d�޷�, �ܵ�: %d��\n", MyWon,usd,remain);
		System.out.println("=========================================");

//////////////////////////////////////////////////////////////////////////////////////////////////
	// ������ ���� ȯ�� ���(1)
		
		double ComPerOne = MoneyEx * commission; // 1�޷��� ������ ,
												 // 1238.21�� 1$�� �ٲٴµ� �ٲٴ� ���� 0.003�� ȯ��
		//�޷��� �����Ḧ ���ؼ� ����ұ�? ��ü�ݾ� ������ �� ���������� ������?
		//����� �Ǽ������̱� ������ ���̴� ����. �������̸� ���̰� ��
		
		double totalcom = usd * ComPerOne;
		
		System.out.println("****************************************************");
		System.out.println("*              ������ ���                         *");
							
		System.out.printf("�� ������: %f��=> ��ȭ: %d�޷�, �޷��� ������: %f��\n", totalcom,usd,ComPerOne);
		System.out.println("*****************************************************");
		//1�� �Ʒ� �� ����
	
/////////////////////////////////////////////////////////////////////////////////////////////////
	// ������ ���� ȯ�� ���(2)
		// ������ �����Ḧ ����ؼ� �޷��� �ٲ���� �Ѵ�.
		// ���� �޷��� �� ����ϰ� �����Ḧ ���������� ���� ������ �����(������ 0.0003�� ���� ���� �ƴ�)
		// �� 1�޷��� ���ϱݾ� + 1�޷��� �����Ḧ ������ �Ǽ��� ����� �ؾ���
		
		// ���� ���� �翬�� ������� �޾ƾ� �� ���̴� �ø� ó���Ѵ�
	
		int i_totalcom;
		
		// �� ���Ÿ����� �������� ������ �ϱ�
		if ( totalcom != (double)(int)totalcom){ // ��ü�����ᰡ �Ҽ����� ������ 1�� ���Ѵܰ�
			i_totalcom = (int)totalcom + 1; //
		} else {
			i_totalcom = (int)totalcom;
		}
		System.out.println("****************************************************");
		System.out.println("*              ������ ���� ȯ��                     *");			
		System.out.printf("�� ������: %d��=> ��ȭ: %d�޷�, �޷��� ������: %f��\n", 
				i_totalcom,usd,ComPerOne);
	
		remain = (int)(MyWon-usd*MoneyEx - i_totalcom);
		System.out.printf("�� ��ȭȯ���ݾ�: %d��=> ��ȭ: %d�޷�, ������û��: %d��, �ܵ� :%d��\n", 
				MyWon,usd,i_totalcom,remain);
		System.out.println("****************************************************");
	
		//�ܵ��� -2233�� ����= 2233���� �� �־�� 807�޷� ȯ�����شٴ°� ���� �ȵ�
/////////////////////////////////////////////////////////////////////////////////////////////
	// ������ ���� ȯ�� ���(3) = ����
		
		//(1�޷��� ��ȭ�ݾ� + 1�޷��� ������)������ �Ǽ��� ����� �ؾ� �Ѵ�.
	
		//int MyWon = 1000000;
		//double MoneyEx = 1238.21;
		//double commission = 0.003;
		//double ComPerOne = MoneyEx * commission;
		
		usd = (int)(MyWon/(MoneyEx + ComPerOne));
		totalcom = usd * ComPerOne;
		if ( totalcom != (double)((int)totalcom)) {
			i_totalcom = (int)totalcom +1;
		} else {
			i_totalcom = (int)totalcom;
		}
		////
		System.out.println("****************************************************");
		System.out.println("*              (��Ȯ��) ������ ���� ȯ��                     *");			
		System.out.printf("�� ������: %d��=> ��ȭ: %d�޷�, �޷��� ������: %f��\n", 
				i_totalcom,usd,ComPerOne);
	
		remain = (int)(MyWon-usd*MoneyEx - i_totalcom);
		System.out.printf("�� ��ȭȯ���ݾ�: %d��=> ��ȭ: %d�޷�, ������û��: %d��, �ܵ� :%d��\n", 
				MyWon,usd,i_totalcom,remain);
		System.out.println("****************************************************");
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
