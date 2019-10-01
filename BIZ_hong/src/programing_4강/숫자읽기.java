package programing_4강;

public class 숫자읽기 {
	//숫자 읽을 때 1의 자리는 일,이,삼..구
	//10의 자리는 십,일십일~이십,이십일~삼십
	//10,20,30... 처리가 관건
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//범위를 주는 것, 숫자 자르기
		String[] units = {"영","일","이","삼","사","오","육","칠","팔","구"};
		//읽을 애들을 배열로 저장 숫자에 따라서 읽기 위해
		for (int i =0 ; i <101 ; i++) {
			
			if (i >=0 && i <10) { //1~9읽기
				System.out.printf("일의자리 : %s\n",units[i]); 
			} 
			else if (i >=10 && i <100) { //10~100읽기
				int i10, i0;
				i10 = i /10;//십의 자리
				i0 = i %10; //일의 자리
				if (i0==0) {//일의 자리가 0이면
					System.out.printf("십의자리 : %s십\n",units[i10]); //10,20,30..처리
				}else {
					System.out.printf("십의자리 : %s십%s\n",units[i10],units[i0]);
					//걍 일반숫자들 처리
				}
			}else System.out.printf("==> %d\n",i);
		}	
	}

}
