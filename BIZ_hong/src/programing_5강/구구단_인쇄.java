package programing_5��;

public class ������_�μ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =1 ; i <10 ; i =i+3) {
			//��� �κ� ��� (3�� ���)
			System.out.println("************\t************\t************");
			System.out.printf(" ������ %d�� \t ������ %d�� \t ������ %d�� \t\n", i, i+1 ,i+2);
			System.out.println("************\t************\t************");
			
			//���� ��� (1,2,3 �ѹ�) 4,5,6 �ѹ� 7,8,9 �ѹ� ���
			for (int j =1 ; j <10 ; j++) {
				System.out.printf(" %d * %d = %d\t %d * %d = %d\t %d * %d = %d\n", 
									i, j, i*j, i+1, j, (i+1)*j, i+2,j,(i+2)*j);
			}
			
		}
	
	}

}
