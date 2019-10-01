package programing_5강;

public class 구구단_인쇄 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =1 ; i <10 ; i =i+3) {
			//헤더 부분 출력 (3번 출력)
			System.out.println("************\t************\t************");
			System.out.printf(" 구구단 %d단 \t 구구단 %d단 \t 구구단 %d단 \t\n", i, i+1 ,i+2);
			System.out.println("************\t************\t************");
			
			//내용 출력 (1,2,3 한번) 4,5,6 한번 7,8,9 한번 출력
			for (int j =1 ; j <10 ; j++) {
				System.out.printf(" %d * %d = %d\t %d * %d = %d\t %d * %d = %d\n", 
									i, j, i*j, i+1, j, (i+1)*j, i+2,j,(i+2)*j);
			}
			
		}
	
	}

}
