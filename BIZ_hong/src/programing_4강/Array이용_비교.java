package programing_4강;

public class Array이용_비교 {
	//비정형 비교(룰이 애매할 때)는 배열을 이용하는 것도 한 방법.
	//하지만 이것도 복잡해 보임
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] ilmd = {31,28,31,30,31,30,31,31,30,31,30,31};
		// 단 배열은 0부터 시작하는 것 유의
		for (int i =1 ; i <13 ; i++) {
			System.out.printf("%d월 =>", i);
			
			for (int j =1 ; j <32 ; j++) {
				System.out.printf("%d", j);
				
				if (ilmd[i-1]==j) break; //31=31이면 break;
				System.out.print(","); //마지막일 콤마 안 찍기
			}
		System.out.println();
		}
	}

}
