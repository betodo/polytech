package programing_5��;

public class ������_�μ�2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ ���� �μ�
		for (int i = 1; i < 4; i++) { // i= 1~3
			System.out.println("************\t************\t************");
			System.out.printf(" ������ %d�� \t ������ %d�� \t ������ %d�� \t\n", i, i + 3, i + 6);
			System.out.println("************\t************\t************");

			//1,4,7 �ѹ� 2,5,8 �ѹ� 3,6,9 �ѹ� ���
			  for (int j =1 ; j <10 ; j++) {
				  System.out.printf(" %d * %d = %d\t %d * %d = %d\t %d * %d = %d\n", i, j, i*j,
				  i+3, j, (i+3)*j, i+6,j,(i+6)*j); 
			  }
		 
		}
	
	}

}
