package progaming_3강;

public class 반올림_버림처리 {

	public static void main(String[] args) {            //버림은 걍 나누고 곱
		// TODO Auto-generated method stub              //반올림은 +절반 한 뒤
		int ii;                                         //올림은 +그 자릿수 한 뒤
		
		ii = 12345; // 12345원 10원 미만 버려서 처리
		System.out.println(ii/10);
		int j = (ii/10)*10;
		System.out.printf("#4-1 : %d\n", j);
		
		ii = 12345; // 10원 미만 반올림 처리
		j = ((ii+5)/10)*10;
		System.out.printf("#4-2 : %d\n", j);
		
		ii = 12344; // 10원 미만 반올림 처리 
		j = ((ii+5)/10)*10;
		System.out.printf("#4-2 : %d\n", j);
		
/////////////////////////////////////////////////////

		// #4-2. 식 검증
		for (int i = 12340; i <12350; i++) {
			j = ((i+5)/10)*10;
			System.out.printf("i=%d , j=%d\n", i,j);
		}
		//
		// #4-3. 1000원 미만 버림,올림
		ii = 12399;
		j = (ii/100)*100;
		int k = ((ii+99)/100)*100;
		System.out.printf("#4-3 버림=%d, 올림=%d\n",j,k);
		
		// #4-4. 10000원 미만 버림, 반올림
		ii = 12789;
		j = (ii/1000)*1000;
		k = ((ii+500)/1000)*1000;
		System.out.printf("#4-3 버림=%d, 반올림=%d",j,k);
	}

}
