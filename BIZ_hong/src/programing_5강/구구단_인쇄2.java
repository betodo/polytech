package programing_5강;

public class 구구단_인쇄2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//구구단 가로 인쇄
		for (int i = 1; i < 4; i++) { // i= 1~3
			System.out.println("************\t************\t************");
			System.out.printf(" 구구단 %d단 \t 구구단 %d단 \t 구구단 %d단 \t\n", i, i + 3, i + 6);
			System.out.println("************\t************\t************");

			//1,4,7 한번 2,5,8 한번 3,6,9 한번 출력
			  for (int j =1 ; j <10 ; j++) {
				  System.out.printf(" %d * %d = %d\t %d * %d = %d\t %d * %d = %d\n", i, j, i*j,
				  i+3, j, (i+3)*j, i+6,j,(i+6)*j); 
			  }
		 
		}
	
	}

}
