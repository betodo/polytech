package progaming_3강;

public class 정수형_연산 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// #3 정수형 변수의 나눗셈은 정수범위에서 버림처리 = 나머지를 안 구한다
		
		// ☆☆☆ 정수형 변수는 소수점이하를 저장해두지 않기 때문에 버려버림
		// 		  이것을 이용해서 버림처리, 형변환등 여러 처리를 한다.
		
		int ii;
		ii = 1000/3; // !=333.33333...
		System.out.printf("#3-1 : %d\n", ii);
		
		ii = 1000%3; // 나머지 계산엔 %
		System.out.printf("#3-2 : %d\n", ii);
		System.out.println();
		
		// 나머지 연산자 응용
		// 나머지를 연산자를 응용하면 여러가지로 써먹는데 유용 (주기적 처리 때 유용)
		// 5로 나눈 나머지가 0인 것은 (밑에 예제 기준) 5번마다 나타난다.
		
		for(int i=0 ; i <20 ; i++) {
			System.out.printf("#3-3 : %d\n", i); // 4찍고
			
			if (((i+1) % 5)==0) { // 4+1이 5로 나누어지면서 if문 수행
				System.out.printf("\n");
			}
		}
	}

}
