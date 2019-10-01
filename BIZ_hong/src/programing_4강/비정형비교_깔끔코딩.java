package programing_4강;

public class 비정형비교_깔끔코딩 {
	//프로그래밍은 몇줄 아끼는 것보다 직관적인 것이 좋음
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i =1 ; i <13 ; i++) {
			System.out.printf("%d월 =>", i);
			
			for (int j =1 ; j <32 ; j++) {
				System.out.printf("%d,", j);
				
				if (i==1 && j==31) break; // i=1찍고 j쭉 찍다가 조건 맞으면 브맄
				if (i==2 && j==28) break; // 브맄 포문 빠져나가서 줄 띄기
				if (i==3 && j==31) break; // 다시 i=2찍고 반복
				if (i==4 && j==30) break;
				if (i==5 && j==31) break;
				if (i==6 && j==30) break;
				if (i==7 && j==31) break;
				if (i==8 && j==31) break;
				if (i==9 && j==30) break;
				if (i==10 && j==31) break;
				if (i==11 && j==30) break;
				if (i==12 && j==31) break;
			}
			System.out.println();
		}
	}

}
