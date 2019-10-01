import java.text.DecimalFormat;

public class 칸_맞춰_인쇄 {
	//일반적 리포트는 헤더 인쇄 후 내용 인쇄
	//폰트가 칸이 맞아야 함(한글1개=영문2개)
	//웃기는 것이 한글을 1s로 인식한다
	//(즉 한글 한자당 -1을 해야한다. 당해보면 안다.)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.printf("%1.1s\n","a");
		//System.out.printf("%1.1s","가");
		
		String item = "사과";
		int unit_price = 5000;
		int num = 500;
		int total = 0;
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		//헤더찍기
		System.out.println("=====================================================");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n","품목","단가","수량","합계");
		System.out.println("=====================================================");
		//값찍기
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n",
				item, df.format(unit_price),df.format(num),df.format(unit_price*num));
		System.out.println("=====================================================");
	}

}
