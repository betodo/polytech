package programing_4��;

public class Array�̿�_�� {
	//������ ��(���� �ָ��� ��)�� �迭�� �̿��ϴ� �͵� �� ���.
	//������ �̰͵� ������ ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ilmd = {31,28,31,30,31,30,31,31,30,31,30,31};
		// �� �迭�� 0���� �����ϴ� �� ����
		for (int i =1 ; i <13 ; i++) {
			System.out.printf("%d�� =>", i);
			
			for (int j =1 ; j <32 ; j++) {
				System.out.printf("%d", j);
				
				if (ilmd[i-1]==j) break; //31=31�̸� break;
				System.out.print(","); //�������� �޸� �� ���
			}
		System.out.println();
		}
	}

}
