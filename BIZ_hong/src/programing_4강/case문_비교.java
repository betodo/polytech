package programing_4��;

public class case��_�� {
// ������ ������ �ڵ� �̷������� ¥�� �ȵȴ�
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =1 ; i <13 ; i++) {
			System.out.printf("%d�� =>", i);
			
			Loop:for (int j =1 ; j <32 ; j++) {
				System.out.printf("%d,", j);
				
				switch(i) {
				case 4: case 6: case 7: case 9: case 11:
					if (j==30) break Loop;
					//���� �̷� ǥ�� ����
					//LOOP ǥ���� ������ ������ ���
				break;
				case 2:
					if (j==28) break Loop;
				break;	
				}
			}
		System.out.println();	
		}	
	}

}
