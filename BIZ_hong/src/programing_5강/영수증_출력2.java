package programing_5강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 영수증_출력2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//선언
		String itemName1, itemName2;
		String itemCode1, itemCode2;
		int price1, price2;
		int num1, num2;
		
		itemName1="오랄비 전동 미세모 D12";
		itemCode1="77778889999";
		price1 =23900; num1=1;
		
		itemName2="디슬로잉 클리어";
		itemCode2="132121212331";
		price2 =3430; num2=8;
		
		//과세, 세금 계산
		int iPrice = (price1 * num1) + (price2 * num2);
		double taxRate = 10;
		int taxBase; 
		int tax;
		
		double x;  //과세 반올림 처리
		x = (iPrice/(1+taxRate/100));//과세반올림 위해 더블형 변수 선언
		if ((x*10)%10 >= 5) x =(int)x+1;// 소수점1자리 5이상이면 반올림
		
		taxBase = (int)x; //과세 (int값 취하기)
		tax = iPrice - taxBase;//세금
				
		//출력
		//숫자 세글자마다 콤마
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		System.out.println("충주(양평)휴게소");
		System.out.println("충북충주시가금면용전리380-4");
		System.out.println("최병권 677-85-00239 TEL:043-857-9229");
		System.out.println("\n");
		//날짜받기
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYYMMdd");
		Calendar calt = Calendar.getInstance();
		
		System.out.printf("[정상등록]%s 190049%15s\n",sdf1.format(calt.getTime()),
				"POS번호: 0002");
		System.out.println("------------------------------------------"); // 총칸 42
		System.out.printf("품목코드%17s  수량%7s\n","단가","금액");
		System.out.println("------------------------------------------");
		System.out.printf("%s\n",itemName1);
		System.out.printf("10%s%14s%6s%9s\n",itemCode1,df.format(price1),
				df.format(num1),df.format(price1*num1));
		System.out.printf("10%s\n",itemName2);
		System.out.printf("%s%14s%6s%9s\n\n",itemCode2,df.format(price2),
				df.format(num2),df.format(price2*num2));
		
		
		System.out.printf("과세 물품 합계%28s\n",df.format(taxBase));
		System.out.printf("부    가    세%28s\n",df.format(tax));
		System.out.printf("합          계%28s\n",df.format(iPrice));
		System.out.printf("026-비씨카드사%28s\n","00/00A");
		String cardNum ="5522-20**-****-BADD";
		System.out.printf("카  드  번  호 :%26s\n",cardNum);
		System.out.printf("카  드  매  출 :%26s\n",df.format(iPrice));
		System.out.printf("거  래  구  분 :%23s\n","일시불");
		System.out.printf("승  인  번  호 : 04-KICC%18s\n","75549250");
		System.out.printf("가 맹 점 번 호 :\n");
		System.out.printf("받  은  금  액 :%26s\n",df.format(iPrice));
		System.out.printf("거    스    름 :%26s\n","0");
		System.out.println("------------------------------------------");
		System.out.printf("주문번호 :%11s\n","0920");
		System.out.println("------------------------------------------");
		System.out.println("판매원 : 000002 편의점2");
		System.out.printf("%s-0002-0922\n",sdf1.format(calt.getTime()));
		System.out.printf("연동모듈:{00138705  %s190049]\n",sdf1.format(calt.getTime()));
	}

}








































