package programing_4강;

public class 단순비교_계단출력 {
	// for문 안쓰고 while 사용
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iA, iB;
		
		iA=0;
		while(true) {           //첫번째 : 별 찍고 a=0 b=0이라서 브맄 내부와일 벗어나서 줄바꾸고 a=1
			iB=0;               //두번째 : 별 찍고 a=1 b=0이라서 내부와일 반복 a=1 b=1 내부와일 벗어나서 줄바꾸고 a=2
			                    //이짓 반복 a와 b의 차이만큼 찍힘
			while(true) {
				System.out.printf("*"); // 별찍기
				
				if (iA == iB) break;
				iB++;
			}
			
		System.out.printf("\n"); // 줄바꾸기
		iA++;
		if (iA == 30) break;
		}
		
	}

}
