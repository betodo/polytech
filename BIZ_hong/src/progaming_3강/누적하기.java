package progaming_3��;

public class �����ϱ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// #2. �����ϱ�, �ձ��ϱ�
		
		int sum; // java�� �ʿ��� �� �����ص� ������ �������ϱ� ������ �տ��� ����
		
		sum = 0; // ����, ������ �� �ʱ�ȭ �Ѵ�.
		
		//1���� 100���� ���غ���
		for ( int i=1 ; i <101 ; i++) 
		{
			sum = sum + i;           // i=0+1, i=1+2, ...
		}
		System.out.printf("#2 : %d\n", sum); //���ó���Ѵٸ� ���⼭ ���� ���� ó��
		
		System.out.printf("#2-2 : %d\n", sum/100);
		
		//�迭 ����
		int [] v= {1,2,3,4,5}; // �迭���� : �������� [] ������
		int vSum;
		
		vSum = 0;
		
		for (int i=0 ; i <5 ; i++) {
			vSum = vSum + v[i];     // vSum=0+1, vSums=1+2, ...
		}
		System.out.printf("#2-3 : %d\n", vSum);
	}

}
