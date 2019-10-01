package progaming_3강;
//public vs private 다른 클래스에서 호울 가능 유무
//static vs dynamic 호출 시 자리 차지 스테이틱은 메모리에 직접 데이터 저장 아무데서나 호출 가능
//클래스 안에 클래스 오류 가능=> 내부 클래스를 static으로 선언해서 사용가능 했다
public class 단순_세금계산 {
	
	// 반올림은 유효숫자를 높여 오차를 줄이는 방법이나, 세금계산 경우 손해를 안봐야 함
	// 즉 세율을 나눠서 원단위가 딱 떨어지면 그대로 세금을 먹이나, 아니면 +1을 더해야 한다.
	public static class Taxcalc {
		public int  taxcal(int val, int rate) { // 세전가, 세율
			int ret; // 판매가(소비자 가)
			if( (double)val*(double)rate/100.0 == val*rate/100 )
				ret = val * rate/100;
			else
				ret = val * rate/100 +1;
			return ret;
		}
	}
	// 실수계산시 소수점 남음, 정수계산은 소수점 버림 
	// 소수점이 남았을 때 소수점을 올려서 돈을 받아야(판매가결정) 나중에 세금 손해 안봄
	// 그래서 정수연산하고 +1을 더해줘서 올림 처림함
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// 단순 세금 계산 (판매자입장)
		
		int val = 271;
		int rate = 3;
		Taxcalc tc = new Taxcalc();
		
		// 우리 나라는 소비자가(판매가)=세금포함가격
		int tax = tc.taxcal(val, rate);
		System.out.println("=========================================");
		System.out.println("*               단순 세금 게산                                 *");
		System.out.printf("실제 세금 계산: %f\n", val*rate/100.0); // 100.0 때문에 실수 계산함
												 // 하나라도 double형식 연산을 하면 실수로 표시
		System.out.printf("세전가격: %d 세금: %d 세포함가격: %d\n", val,tax,val+tax);
		System.out.println("=========================================");
		
		// 실제세금 8.13 1원 자리에서 올림처리해서 판매가 정함 271+9
//////////////////////////////////////////////////////////////////////////////////////////////

	// 소비자가 세금 계산
		//한국식은 소비자가격이 세금 포함, 똑 떨어짐
		//세금에 1원 미만 금액이 생기면 무조건 1원 더 붙어서 세금 책정됨
		//세전가격을 버림 처림하면 무조건 세금은 올림 처리 됨
		//세전가격을 정수형 연산하면 되겠네
		//세전가 = 소비자가격 / (1 + rate), 세금 = 소비자가 - 세전가
		
		int custom = 1100;
		int taxrate = 10; //=3%
		
		int taxval, netval;
		
		netval = (int)(custom / (1 + taxrate/100.0));
		// 100.0으로 나누면 실수 계산 실수계산 쭉하다가 마지막에 정수형변환 하면 
		// 세전가격 소수점이하 버림처리
		taxval = custom -netval;
		//세금=세전가*세율로 계산하면 소수점 오차 생김 그래서 이와 같이 계산
		
		System.out.println("=========================================");
		System.out.println("*              소비자가 세금 계산                            *");
		System.out.printf("실제 세금 계산: %f\n", val*rate/100.0); // 100.0 때문에 실수 계산함
												 // 하나라도 double형식 연산을 하면 실수로 표시
		System.out.printf("소비자가격: %d 세전가격: %d 세금: %d\n", custom,netval,taxval);
		System.out.println("=========================================");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
