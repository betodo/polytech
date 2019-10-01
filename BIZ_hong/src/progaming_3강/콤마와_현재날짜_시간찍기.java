package progaming_3강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class 콤마와_현재날짜_시간찍기 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int MyWon = 1000000;
		double MoneyEx = 1238.21;
		double commission = 0.003;
		double ComPerOne = MoneyEx * commission;
		int usd = (int)(MyWon/(MoneyEx + ComPerOne));
		double totalcom = usd * ComPerOne;
		int i_totalcom;
		if ( totalcom != (double)((int)totalcom)) {
			i_totalcom = (int)totalcom +1;
		} else {
			i_totalcom = (int)totalcom;
		}
		
		//돈은 세자리마다 콤마를 찍는다 이거 하기
		//DecimalFormat 이라는 클래스를 가져다 쓴다 임포트하는 방법 배우기
		//클래스 입력후 ctrl shift o 누르기 = 자동 임포트 or 에러 마우스커서 선택 입력
		
		// %d=정수 %f=실수 %s=문자열 decimal 포맷쓰면 문자열되니 잘 바꿔줘야함
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		System.out.println("****************************************************");
		System.out.println("*              콤마찍기, 날짜 적용                    *");			
		System.out.printf("총 수수료: %s원=> 미화: %s달러, 달러당 수수료: %f원\n", 
				df.format(i_totalcom),
				df.format(usd),
				ComPerOne);
	
		int remain = (int)(MyWon-usd*MoneyEx - i_totalcom);
		System.out.printf("총 한화환전금액: %s원=> 미화: %s달러, 수수료청구: %s원, 잔돈 :%s원\n", 
				df.format(MyWon),df.format(usd),df.format(i_totalcom),df.format(remain));
		
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		Calendar calt = Calendar.getInstance();
		
		System.out.printf("최종실행시간: %s\n", sdt.format(calt.getTime()));
		
		System.out.println("****************************************************");
		
		
		
		
		
		
	}

}
