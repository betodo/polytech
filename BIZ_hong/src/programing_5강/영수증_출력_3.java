package programing_5강;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class 영수증_출력_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//선언
		//품목
		String[] itemName = {"초코파이","바나나우유","건포도","오렌지주스","초코에몽","파김치",
				"풀무원치즈&치즈","스판반팔티","서울우유","얼갈이김치","물티슈 100매",
				"팔도왕뚜껑","사과 1kg","프링글스 BBQ","[노브렌드]생수 2L","올리브 짜파게티",
				"CJ 햇반","크리넥스 3겹 3롤","유한락스 1.5L","[홈스타]욕실세정용","남성 린넨셔츠",
				"이천쌀 2kg","블루충치케어 치약","[노브랜드]수세미3p","고무장갑","울샴푸",
				"[노브랜드]종이호일","샤프란","[아디다스]슈퍼스타","당근"};
		
		//가격
		int[] price = {12343780,15000,2980,4900,1000,2530,3310,5000,13300,1700,100,990,1440,4250,2750,
				9800,5180,900,9900,9800,5000,4060,10130,3500,25000,800,20000,550,4560,520};
		//수량
		int[] num ={2,100,2,4,1,3,1,5,1,1,1,7,4,2,2,
				8,1,1,1,2,1,2,1,3,2,6,9,1,5,1};
		
		//면세유무
		boolean[] taxFree ={false,false,true,false,false,true,false,false,true,true,false,false,true,false,false,
				false,false,false,false,false,false,true,false,false,false,false,false,false,false,true};
		
		// 계산
		// 면세상품 총가격
		int taxFree_totalPrice=0;
		for (int i =0 ; i <itemName.length ; i++) {
			if (taxFree[i] == true) {
				taxFree_totalPrice = taxFree_totalPrice + price[i]*num[i]; 
			}
		}
		// 전상품 총가격
		int totalPrice =0;
		for (int i =0 ; i <itemName.length ; i++) {
				totalPrice = totalPrice + price[i]*num[i]; 
		}
		
		// 과세상품 총가격(면세상품 총가격 - 전상품 총가격)
		int beforeTaxPrice = totalPrice - taxFree_totalPrice;
		
		// 세금계산
		double taxRate = 10;
		
		int taxBase;
		int tax;
		
		if (beforeTaxPrice/(100+taxRate)==(int)(beforeTaxPrice/(100+taxRate))) {//소수점 안나오고 나눠떨어짐
			tax = (int)(beforeTaxPrice/(100+taxRate)*taxRate);//세금구하는 공식
		}else {
			tax = (int)(beforeTaxPrice/(100+taxRate)*taxRate)+1;//소수점 나옴
														//세금 소수점 나오면 세금을 1원올리고
														//소수점 절삭 처리
		}
		taxBase = beforeTaxPrice - tax;//과세금액
		

//		double x; // 과세 반올림 처리
//		x = (beforeTaxPrice / (1 + taxRate / 100));// 과세반올림 위해 더블형 변수 선언
//		if ((x * 10) % 10 >= 5)
//			x = (int) x + 1;// 소수점1자리 5이상이면 반올림
//
//		taxBase = (int) x; // 과세 (int값 취하기)
//		tax = beforeTaxPrice - taxBase;// 세금

		//출력
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		SimpleDateFormat sdf1 = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		Calendar calt = Calendar.getInstance();
		
		System.out.println("                 이마트 죽전점 (031)888-1234");
		System.out.println("      emart      206-86-50913이갈수");
		System.out.println("                 용인구 수지시 포은대로 552");
		System.out.println();
		System.out.println("영수증 미지참시 교환/환불 불가(30일이내)");
		System.out.println("교환/환불 구매점에서 가능(결제카드지참)");
		System.out.println("체크카드/신용카드 청구취소 반영은");
		System.out.println("최대 3~5일 소요 (주말,공휴일제외)");
		System.out.println();
		System.out.printf("[구 매]%s %24s\n",sdf1.format(calt.getTime()),"POS:0009-2418");
		System.out.println("------------------------------------------------"); // 총 48칸
		System.out.printf("%4s%21s%3s%8s\n","  상 품 명","단 가","수량","금 액");
		System.out.println("------------------------------------------------");
		
		
		//항목출력
		String star = null;
		for (int i =0 ; i <itemName.length ; i++) {
			
			//면세물품 별표찍기
			if (taxFree[i] == true) {star ="*";}
			else {star ="";}
			
			System.out.printf("%02d%-2s%s",i+1,star,itemName[i]);
			
			//품목명뒤 공백찍기
			for (int blank =0 ; blank <19-itemName[i].getBytes().length ; blank++) {
				//바이트를 얻어 사용가능하게 랭스함-int값 받음
				System.out.printf("%s"," ");
			}// 
			
			//나머지 단가 수량 금액 찍기
			System.out.printf("%10s%4s%11s\n",df.format(price[i]),num[i],
					df.format(price[i]*num[i]));
		}
		
		
		System.out.println();
		System.out.printf("%22s%22s\n","(*)면 세 물 품",df.format(taxFree_totalPrice));
		System.out.printf("%22s%22s\n","과 세 물 품",df.format(taxBase));
		System.out.printf("%23s%22s\n","부   과  세",df.format(tax));
		System.out.printf("%24s%22s\n","합       계",df.format(totalPrice));
		System.out.printf("결 제 대 상 금 액%31s\n",df.format(totalPrice));
		System.out.println("------------------------------------------------");
		System.out.printf("0024 하  나%37s\n","5417**8890/07850246");
		System.out.printf("카드결제%37s\n","일시불 / "+df.format(totalPrice));
		System.out.println("------------------------------------------------");
	}

}




