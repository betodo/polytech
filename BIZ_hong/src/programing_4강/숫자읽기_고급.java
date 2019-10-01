package programing_4강;

public class 숫자읽기_고급 {
	
	public static String HanCount(String num) {//스트링 숫자 읽기 메서드
		String numRead=""; //최종 결과값
		
		String [] units= {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"}; //숫자읽기
	    String [] unitx= {"", "십", "백", "천", "만", "십", "백", "천", "억", "십","백","천"}; //단위값
		
	    int j = num.length()-1;//랭스는 문자열만의 갯수 구하는 것
	    					//전체자릿수-1 배열은 0부터세니까
	    
	    for (int i=0;i <num.length();i++) {
	    	String numEach = units[Integer.parseInt(num.substring(i,i+1))];
	    	
	    	if (numEach=="0") {
	    		if (unitx[j]=="만" || unitx[j]=="억") { //오십만오천 0이라서 오십오천이어야 하는데
	    			numRead = numRead + unitx[j];       //만억조라서 오십만오천 된거임 (십억, 십만 단위값이 2개
	    		}else {} // 아무것도 안함
	    		
	    	}else {
	    		numRead = numRead + numEach + unitx[j]; //단위 값을 쌓기
	    	}
	    	j--; //단위값은 j를 하나씩 떨구면서 셈
	    	
	    }
		return numRead;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 임의의 숫자로 실습
		// 일십억 백삼만 사천 오백 육십 칠 읽기
		// 왼쪽부터 한개씩 처리
		// 읽을 숫자와 단위 숫자 2개배열 필요
		// 해당 자리가 0이면 안읽음 but 억과 만은 읽음
		// 2,030,200,00=이십 (영)억 삼천 (영백) 이십 (영)만 (영천)(영백)(영만)
	      int iNumVal = 1001034567;
	      // String형으로 변수 추가
	      String sNumVal = String.valueOf(iNumVal);//int를 스트링으로
	      String sNumVoice = "";
	      
	      System.out.printf("==> %s [%d자리]\n", sNumVal, sNumVal.length());
	      
	      int i, j;
	      
	      String [] units= {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"}; //숫자읽기
	      String [] unitX= {"", "십", "백", "천", "만", "십", "백", "천", "억", "십"}; //단위값
	      
	      i = 0;
	      j = sNumVal.length()-1;//랭스하면 자릿수 랭스는 1부터 세지만 배열은 0부터세니까
	      						//처음 j는 9
	      
	      while (true) {
	         if ( i>= sNumVal.length()) break;//더이상 읽을 수자리가 없으면 브맄
	         // 읽을 숫자와 총 몇자리인지 출력
	         System.out.printf("%s[%s]", sNumVal.substring(i,i+1), //i번째 자리 한글자만 잘라옴
	                           units[Integer.parseInt(sNumVal.substring(i,i+1))]);//그 글자를 읽음(배열이용)
	         					//스트링으로 잘라온 글자를 인트로 바꿈
	         					//해당 위치의 배열값을 받음
	         //단위값읽기
	         if (sNumVal.substring(i,i+1).contentEquals("0")) {
	            // 해당자리가 0일 땐 단위값 X
	            //억, 만 자리만 단위를 붙여줌 =십억, 십만 단위값이 2개 
	            if(unitX[j].equals("만")||unitX[j].equals("억")) {
	               sNumVoice=sNumVoice + "" + unitX[j]; //단위 값을 쌓기
	            } else {
	               // 아무것도 안함
	            }
	         } else {//첫 숫자1경우 snumVoice = ""+(int)1(일)+unit9(십)= 일십
	            sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i+1))]
	                             + unitX[j];// 읽을 숫자와 단위값을 쌓아서 처리 그래서 더해주는거
	         }
	         i++; j--;
	      }
	      // 하나씩 출력하는게 아니라 숫자[숫자읽기]형식으로 출력
	      System.out.printf("\n %s[%s]\n", sNumVal, sNumVoice);

	}

}
