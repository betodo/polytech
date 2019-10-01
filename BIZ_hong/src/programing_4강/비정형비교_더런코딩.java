package programing_4강;

public class 비정형비교_더런코딩 {
	// 이런식으로 하지 말자
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =1 ; i <13 ; i++) {
			System.out.printf("%d월 =>", i);
			
			for (int j =1 ; j <32 ; j++) {
				System.out.printf("%d,", j);
				
				if (i==4 || i==6 || i==7 || i==9 || i==11 ) {
					if(j==30) break;//깔끔코딩과 같은 결과 조건으로 압축
				}
				if (i==2) {
					if(j==28) break;
				}
			}	
			System.out.println();
		}
		
		for (int i =1 ; i <13 ; i++) {
			System.out.printf("%d월 =>", i);
			
			for (int j =1 ; j <32 ; j++) {
				System.out.printf("%d,", j);
				
				if ((i==4 || i==6 || i==7 || i==9 || i==11)&&(j==30) ) break;
				if (i==2 && j==28 ) break;//깔끔코딩과 같은결과 조건을 조금더 압축
				
			}	
			System.out.println();
		}
	}

}
