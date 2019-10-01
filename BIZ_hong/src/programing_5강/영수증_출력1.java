package programing_5강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 영수증_출력1 {
	//주문합계액= input값, 과세&세액 계산
	//시간일자함수사용
	//폰트,굵기,할인 무시
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//선언
		int iPrice = 14000; //지불금액
		double taxRate = 10;//세율
		int taxBase; 
		int tax;
		
		
		//과세,세금계산
		// taxBase = (int)(iPrice / (1 + taxRate/100.0));
		// tax = iPrice -taxBase
		if (iPrice/(100+taxRate)==(int)(iPrice/(100+taxRate))) {//소수점 안나오고 나눠떨어짐
			tax = (int)(iPrice/(100+taxRate)*taxRate);//세금구하는 공식
		}else {
			tax = (int)(iPrice/(100+taxRate)*taxRate)+1;//소수점 나옴
														//세금 소수점 나오면 세금을 1원올리고
														//소수점 절삭 처리
		}
		taxBase = iPrice - tax;//과세금액
		
		//영수증 출력
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");//콤마 찍기
		
		System.out.printf("%23s\n","영  수  증");
		System.out.println("==========================================");//전체42칸
		System.out.println("종로상회(분당서현점)  129-17-77924");
		System.out.println("이상철  031 781 1596");
		System.out.println("성남시 분당구 서현동 269-3");
		System.out.println("테이블명 : 12");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYYMMdd");//날짜 형식
		SimpleDateFormat sdf2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		Calendar calt = Calendar.getInstance();
		
		System.out.printf("주문번호 : %s 01 00041\n",sdf1.format(calt.getTime()));
		System.out.println("==========================================");
		System.out.printf("주문합계%34s\n",df.format(iPrice));
		System.out.printf("할인금액%34s\n","0");
		System.out.printf("받을금액%34s\n",df.format(iPrice));
		System.out.println("==========================================");
		System.out.printf("현  금%13s    과  세%13s\n","0",df.format(taxBase)); //카드로만 계산 가정
		System.out.printf("카  드%13s    세  액%13s\n",df.format(iPrice),df.format(tax));
		System.out.printf("현  금%13s    과  세%13s\n","0","0"); // 포인트, 면세 무시
		System.out.printf("%27s%11s\n","영수금액",df.format(iPrice));
		System.out.println("==========================================");
		System.out.printf("%23s\n","[우리카드 신용 승인]");
		System.out.printf("승 인 일 시 : %s\n",sdf2.format(calt.getTime()));
		System.out.println("카 드 번 호 : 55222059****2021");
		System.out.println("승 인 번 호 : 79753574  할부개월 : 00");
		System.out.printf("%s %s\n","승 인 금 액 :",df.format(iPrice));
		System.out.println("가 맹 번 호 : 730461774  /  비씨카드사");
		System.out.println("사업자 번호 : 129-17-77924");
		System.out.println("==========================================");
		System.out.printf("%s  CASHIER : %12s\n",sdf3.format(calt.getTime()),"직원");
		System.out.println("==========================================");
		System.out.print("감사 합니다.");
		
	}

}







































