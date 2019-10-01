package progaming_3강;

public class 누적하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// #2. 누적하기, 합구하기
		
		int sum; // java는 필요할 때 선언해도 되지만 지저분하기 때문에 앞에서 선언
		
		sum = 0; // 누적, 루프는 꼭 초기화 한다.
		
		//1부터 100까지 더해보자
		for ( int i=1 ; i <101 ; i++) 
		{
			sum = sum + i;           // i=0+1, i=1+2, ...
		}
		System.out.printf("#2 : %d\n", sum); //평균처리한다면 여기서 더한 다음 처리
		
		System.out.printf("#2-2 : %d\n", sum/100);
		
		//배열 응용
		int [] v= {1,2,3,4,5}; // 배열선언 : 데이터형 [] 변수명
		int vSum;
		
		vSum = 0;
		
		for (int i=0 ; i <5 ; i++) {
			vSum = vSum + v[i];     // vSum=0+1, vSums=1+2, ...
		}
		System.out.printf("#2-3 : %d\n", vSum);
	}

}
