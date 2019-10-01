package programing_7강;

import java.text.DecimalFormat;

public class 고정길이에서_필드추출 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] oneRec = {
				"01  초코파이               3,780 100    378,000",
				"02  바나나우유            15,000   1     15,000",
				"03* 건포도                 2,980   2      5,960",
				"04  오렌지주스             4,900   4     19,600",
				"05  초코에몽               1,000   1      1,000",
				"06* 파김치                 2,530   3      7,590",
				"07  풀무원치즈&치즈        3,310   1      3,310",
				"08  스판반팔티             5,000   5     25,000",
				"09* 서울우유              13,300   1     13,300",
				"10* 얼갈이김치             1,700   1      1,700",
				"11  물티슈 100매             100   1        100",
				"12  팔도왕뚜껑               990   7      6,930",
				"13* 사과 1kg               1,440   4      5,760",
				"14  프링글스 BBQ           4,250   2      8,500",
				"15  [노브렌드]생수 2L      2,750   2      5,500",
				"16  올리브 짜파게티        9,800   8     78,400",
				"17  CJ 햇반                5,180   1      5,180",
				"18  크리넥스 3겹 3롤         900   1        1,900",
				"19  유한락스 1.5L          9,900   1      9,900",
				"20  [홈스타]욕실세정용     9,800   2     19,600",
				"21  남성 린넨셔츠          5,000   1      5,000",
				"22* 이천쌀 2kg             4,060   2      8,120",
				"23  블루충치케어 치약     10,130   1     10,130",
				"24  [노브랜드]수세미3p     3,500   3     10,500",
				"25  고무장갑              25,000   2     50,000",
				"26  울샴푸                   800   6      4,800",
				"27  [노브랜드]종이호일 3,120,000   9 28,080,111",
				"28  샤프란                   550   1        550",
				"29  [아디다스]슈퍼스타 1,234,560   5  6,172,800",
				"30* 당근                     520   1        1,520"};
		
		//한레코드의 고정길이
		//System.out.println(oneRec[0].length()); // =43
		//ystem.out.println(oneRec[0].getBytes().length); // =47
		//System.out.println(oneRec[29].getBytes().length); //=48
		
		//n~m번째 글자 추출(번호,항목,단가,수량,가격)
		String num,item,price,count,total;
		int int_price, int_count, int_total;
		int diff =0;
		
		for (int i=0 ; i < oneRec.length ; i++ ) {//배열.length=배열갯수
			//글자 추출
			diff = oneRec[i].getBytes().length - oneRec[i].length();//한글이 차지하는 바이트수
			num = oneRec[i].substring(0,2);
			item = oneRec[i].substring(4,23-diff); 
			//짜르고 싶은 길이는 23인데 안에 
			//한글이 껴있어서 한글이 더 차지하는 만큼을 빼줌
			price = oneRec[i].substring(23-diff,33-diff); //22 부터 33까지 추출하고 싶은데
			count = oneRec[i].substring(33-diff,36-diff);//한글땜시 추가된 바이트수 빼줌
			total = oneRec[i].substring(36-diff,oneRec[i].getBytes().length-diff);
			
			//추출문자 콤마 제거
			price = price.replaceAll(",","");
			total = total.replaceAll(",","");
			
			//공백제거
			num = num.trim();//공백제거할 땐 트림쓴다
			item = item.trim();
			price = price.trim();
			count = count.trim();
			total = total.trim();
			
			//문자열->숫자 for 계산
			int_price = Integer.parseInt(price);
			int_count = Integer.parseInt(count);
			int_total = int_price * int_count; //실제 계산값
			
			
			//출력
			DecimalFormat df = new DecimalFormat("###,###,###,###,###");
			
			if (Integer.parseInt(total) != int_total) { //데이터와 실제 계산값이 다르면
				System.out.println("*******************************");
				//오류줄 출력
				System.out.printf("%s[%s  %s","오류",num,item); //공백전까지 출력
				
				for ( int blank =0 ; blank < 20-item.getBytes().length; blank++) {//출력을 위해 공백 찍어주기
					System.out.printf("%s"," ");}//공백갯수 글자수가 많으면 적게
														  //글자수가 없으면 그만큼 적게
				
				System.out.printf("%10s%4s%15s]\n",df.format(int_price),df.format(int_count),
						df.format(Integer.parseInt(total))); //공백이후 출력
				//수정줄 출력
				System.out.printf("%s[%s  %s","수정",num,item);
				
				for ( int blank =0 ; blank < 20-item.getBytes().length; blank++) {
					System.out.printf("%s"," ");}
				
				System.out.printf("%10s%4s%15s]\n",df.format(int_price),df.format(int_count),
						df.format(int_total));
				System.out.println("*******************************");
			} 
		}
		

	}

}







