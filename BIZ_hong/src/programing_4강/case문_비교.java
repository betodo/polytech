package programing_4강;

public class case문_비교 {
// 굉장히 더러운 코드 이런식으로 짜면 안된다
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =1 ; i <13 ; i++) {
			System.out.printf("%d월 =>", i);
			
			Loop:for (int j =1 ; j <32 ; j++) {
				System.out.printf("%d,", j);
				
				switch(i) {
				case 4: case 6: case 7: case 9: case 11:
					if (j==30) break Loop;
					//거의 이런 표현 안함
					//LOOP 표시자 없으면 엉뚱한 결과
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
