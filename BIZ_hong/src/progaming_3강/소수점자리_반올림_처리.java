package progaming_3��;

public class �Ҽ����ڸ�_�ݿø�_ó�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// �١١� 14/5�� 14/5.0�� ���α׷�������  �ٸ� ��
		
		int myVal = 14/5; //�̰��� 2.8, ������ ���� ������ 2, �ݿø��ϸ� 3
		
		System.out.printf("#5-1 : %d\n", myVal); // ��������=�Ҽ������� ����
		
		// �١١��� ���� �Ǽ�(float,double�� ����ȯ)���� �� 0.5�� ���� ����
		//       ������ ����ȯ�� �ϸ� �ݿø� ó�� �ȴ�
		
		double myValF;
		
		myValF = 14/5; // 2.0000..�� ���´� =�Ҽ��� ���� �ƴ�!
					   // ���� �Ǽ��������� ����� ���� �ƹ��͵� �Ƚ���� ������ ��Ʈ�� �μ�
		System.out.printf("#5-2 : %f\n", myValF);
		
		myValF = 14.0/5; // �� ���� �Ǽ������� ǥ�ø� �ؾ� ����� �Ǽ��� ���´�
		System.out.printf("#5-3 : %f\n", myValF);
		
		myValF = (14.0)/5+0.5; // �Ǽ��� ��꿡�� 0.5 ���ϱ�
		System.out.printf("#5-4 : %f\n", myValF);
		
		myValF = (int) ((14.0)/5+0.5); // �Ǽ��� ����� �ϰ� ������ ����ȯ�� ����
		         // ����ȯ -> (��������) (����)
		System.out.printf("#5-2 : %f\n", myValF);
	}

}
