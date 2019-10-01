package progaming_3강;

public class 소수점자리_반올림_처리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ☆☆☆ 14/5와 14/5.0은 프로그램언어에서는  다른 것
		
		int myVal = 14/5; //이값은 2.8, 소주점 이하 버리면 2, 반올림하면 3
		
		System.out.printf("#5-1 : %d\n", myVal); // 정수연산=소수점이하 버림
		
		// ☆☆☆이 값을 실수(float,double로 형변환)연산 후 0.5를 더한 다음
		//       정수형 형변환을 하면 반올림 처리 된다
		
		double myValF;
		
		myValF = 14/5; // 2.0000..이 나온다 =소수형 연산 아님!
					   // 답은 실수형이지만 계산할 때는 아무것도 안써줬기 때문에 인트로 인쇄
		System.out.printf("#5-2 : %f\n", myValF);
		
		myValF = 14.0/5; // 한 개라도 실수형태의 표시를 해야 결과가 실수가 나온다
		System.out.printf("#5-3 : %f\n", myValF);
		
		myValF = (14.0)/5+0.5; // 실수형 계산에서 0.5 더하기
		System.out.printf("#5-4 : %f\n", myValF);
		
		myValF = (int) ((14.0)/5+0.5); // 실수형 계산을 하고 정수형 형변환을 하자
		         // 형변환 -> (데이터형) (변수)
		System.out.printf("#5-2 : %f\n", myValF);
	}

}
