package progaming_3강;

public class 환전문제 {
	//은행은 손해 보지 않는다!!!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// 단순 환전 계산 (환전 수수료율 X)
		
		int MyWon = 1000000;       // 환전할 돈
		double MoneyEx = 1238.21;  // 환율
		double commission = 0.003; // 환전 수수료율
		
		//은행가서 환전하면 지폐만 준다.(동전 센트 안줌)
		int usd = (int)(MyWon/MoneyEx);       //최종결과 정수처리 = 지폐만 계산(소수점이하=동전)
		int remain = (int)(MyWon-usd*MoneyEx);//고객에게 돌려줄 잔돈도 소수점이하 금액은 삥땅해야(정수처리)
		
		System.out.println("=========================================");
		System.out.println("*              수수료 없이 계산                            *");
							
		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 잔돈: %d원\n", MyWon,usd,remain);
		System.out.println("=========================================");

//////////////////////////////////////////////////////////////////////////////////////////////////
	// 수수료 포함 환전 계산(1)
		
		double ComPerOne = MoneyEx * commission; // 1달러당 수수료 ,
												 // 1238.21을 1$로 바꾸는데 바꾸는 돈의 0.003이 환율
		//달러당 수수료를 더해서 계산할까? 전체금액 산정한 후 수수료율을 때릴까?
		//현재는 실수연산이기 때문에 차이는 없다. 정수형이면 차이가 남
		
		double totalcom = usd * ComPerOne;
		
		System.out.println("****************************************************");
		System.out.println("*              수수료 계산                         *");
							
		System.out.printf("총 수수료: %f원=> 미화: %d달러, 달러당 수수료: %f원\n", totalcom,usd,ComPerOne);
		System.out.println("*****************************************************");
		//1원 아래 돈 나옴
	
/////////////////////////////////////////////////////////////////////////////////////////////////
	// 수수료 포함 환전 계산(2)
		// 은행은 수수료를 고려해서 달러를 바꿔줘야 한다.
		// 먼저 달러를 다 계산하고 수수료를 빼버릴려면 어마어마한 오차가 생긴다(수수료 0.0003은 적은 돈이 아님)
		// 즉 1달러당 원하금액 + 1달러당 수수료를 가지고 실수형 계산을 해야함
		
		// 은행 입장 당연히 수수료는 받아야 할 돈이니 올림 처리한다
	
		int i_totalcom;
		
		// 뭔 짓거리인지 따져보고 익혀서 암기
		if ( totalcom != (double)(int)totalcom){ // 전체수수료가 소수점이 나오면 1원 더한단거
			i_totalcom = (int)totalcom + 1; //
		} else {
			i_totalcom = (int)totalcom;
		}
		System.out.println("****************************************************");
		System.out.println("*              수수료 적용 환전                     *");			
		System.out.printf("총 수수료: %d원=> 미화: %d달러, 달러당 수수료: %f원\n", 
				i_totalcom,usd,ComPerOne);
	
		remain = (int)(MyWon-usd*MoneyEx - i_totalcom);
		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 수수료청구: %d원, 잔돈 :%d원\n", 
				MyWon,usd,i_totalcom,remain);
		System.out.println("****************************************************");
	
		//잔돈이 -2233원 나옴= 2233원을 더 주어야 807달러 환전해준다는거 말이 안됨
/////////////////////////////////////////////////////////////////////////////////////////////
	// 수수료 포함 환전 계산(3) = 최종
		
		//(1달러당 원화금액 + 1달러당 수수료)가지고 실수형 계산을 해야 한다.
	
		//int MyWon = 1000000;
		//double MoneyEx = 1238.21;
		//double commission = 0.003;
		//double ComPerOne = MoneyEx * commission;
		
		usd = (int)(MyWon/(MoneyEx + ComPerOne));
		totalcom = usd * ComPerOne;
		if ( totalcom != (double)((int)totalcom)) {
			i_totalcom = (int)totalcom +1;
		} else {
			i_totalcom = (int)totalcom;
		}
		////
		System.out.println("****************************************************");
		System.out.println("*              (정확한) 수수료 적용 환전                     *");			
		System.out.printf("총 수수료: %d원=> 미화: %d달러, 달러당 수수료: %f원\n", 
				i_totalcom,usd,ComPerOne);
	
		remain = (int)(MyWon-usd*MoneyEx - i_totalcom);
		System.out.printf("총 한화환전금액: %d원=> 미화: %d달러, 수수료청구: %d원, 잔돈 :%d원\n", 
				MyWon,usd,i_totalcom,remain);
		System.out.println("****************************************************");
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
