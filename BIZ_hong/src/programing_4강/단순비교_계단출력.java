package programing_4��;

public class �ܼ���_������ {
	// for�� �Ⱦ��� while ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iA, iB;
		
		iA=0;
		while(true) {           //ù��° : �� ��� a=0 b=0�̶� �ꐞ ���ο��� ����� �ٹٲٰ� a=1
			iB=0;               //�ι�° : �� ��� a=1 b=0�̶� ���ο��� �ݺ� a=1 b=1 ���ο��� ����� �ٹٲٰ� a=2
			                    //���� �ݺ� a�� b�� ���̸�ŭ ����
			while(true) {
				System.out.printf("*"); // �����
				
				if (iA == iB) break;
				iB++;
			}
			
		System.out.printf("\n"); // �ٹٲٱ�
		iA++;
		if (iA == 30) break;
		}
		
	}

}
