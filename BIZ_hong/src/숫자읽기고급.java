
public class 숫자읽기고급 {
	//1,001,034,567
	//일십억백삼만사천오백육십칠 읽기--규칙을 파악해서 프로그램으로 표현
	//왼쪽부터 한개씩 처리
	//일~구, 단위: 십 백 천 만 ~
	//해당 자리가 0일때 안읽거나 억,만일 때는 억이나 만을 써줌
	//2,030,200,000 = 이십(영)억 삼천(영백)이십(영)만 (영천)(영백)(영)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iNumVal = 1001034567;
		
		String sNumVal = String.valueOf(iNumVal); //int를 String으로
		String sNumVoice="";
		System.out.printf("==> %s [%d자리]\n",sNumVal,sNumVal.length());
		
		int i,j;
		
		String[] units = {"영","일","이","삼","사","오","육","칠","팔","구"};
		String[] unitx= {"","십","백","천","만","십","백","천","억","십"};
		
		i=0;
		j=sNumVal.length()-1; // 처음 j=9
		
		while (true) {
			if (i >=sNumVal.length()) break;
			
			System.out.printf("%s[%s]",
					sNumVal.substring(i,i+1),
					units[Integer.parseInt(sNumVal.substring(i, i+1))]);
						//Integer.parseInt(X) = String X를 int로
							//X.substirng(n,m) = 문자열 X의 번째부터 m미만 번째까지 추출
							//한자리 수 만 읽고 있음
			if (sNumVal.substring(i, i+1).equals("0")) {
				// 해당자리가 0일땐 단위값을 안붙이는데 억, 만 자리는 붙인다.
				// 이백 사만 이십.. 이백 만 원..
				//억, 만자리가 아니면 아무짓도 안함
				if (unitx[j].equals("만") || unitx[j].equals("억")) {
					sNumVoice = sNumVoice + ""+ unitx[j];					
				}else {
					//아무짓도 안함
				}
			}else {
				sNumVoice = sNumVoice +
						units[Integer.parseInt(sNumVal.substring(i, i+1))]+
						unitx[j];
			}
			i++; j--;
		}	
		System.out.printf("\n %s[%s]\n",sNumVal,sNumVoice);	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
