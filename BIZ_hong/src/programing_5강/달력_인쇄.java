package programing_5��;

public class �޷�_�μ� {
	// 2019�� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int iWeekday = 2; // 2019�� 1�� 1���� ȭ���Ϻ��� ����!

		// �� ���� �������� �迭�� ����
		int[] iEnd = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// ������ ��,===,����
		for (int iMon = 0; iMon < 12; iMon++) {
			System.out.printf("\n\n%14d��\n", iMon + 1);
			System.out.println("==============================");
			System.out.println("  ��  ��  ȭ  ��  ��  ��  ��");//��ĭ2�ѱ�2

			// ��ĭ���
			for (int k = 0; k < iWeekday; k++) {  //f:������2, 2�� ��ĭ
				//4�ڸ���ŭ ��ĭ
				System.out.printf("%4s", " ");	//s:������4, 4����ĭ,5��° ����
			}

			// �������
			for (int i = 1; i <= iEnd[iMon]; i++) {//f: i=1���, ������3
												   //s: i=2���, ������4
				System.out.printf("%4s", i);       //...������7(�������Ͽ���)
				iWeekday++;						  //�̸� �ٹٲ�, ������ �ʱ�ȭ
												//i�� ��� �����鼭 �����̸� ó��
				if (iWeekday == 7) {			//ù�� ������ �ٽ� �ö󰡼�
					System.out.println();      // ������ ������=4(��)
					iWeekday = 0;
				}

			}

		}

	}

}
