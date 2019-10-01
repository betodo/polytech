package programing_7강;

public class 구분자된_필드추출2 {

	public static String HanCount(String num) {//스트링 숫자 읽기
		String numRead=""; //최종 결과값
		
		String [] units= {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"}; //숫자읽기
	    String [] unitx= {"", "십", "백", "천", "만", "십", "백", "천", "억", "십","백","천"}; //단위값
		
	    int j = num.length()-1;//랭스는 문자열만의 갯수 구하는 것
	    					//전체자릿수-1 배열은 0부터세니까
	    
	    for (int i=0;i <num.length();i++) {
	    	String numEach = units[Integer.parseInt(num.substring(i,i+1))];
	    	
	    	if (numEach=="0") {
	    		if (unitx[j]=="만" || unitx[j]=="억") {
	    			numRead = numRead + unitx[j];//단위 값을 쌓기
	    		}else {} // 아무것도 안함
	    		
	    	}else {
	    		numRead = numRead + numEach + unitx[j]; //숫자읽기와 단위값을 쌓기
	    	}
	    	j--;//단위값은 j를 하나씩 떨구면서 셈
	    	
	    }
		return numRead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] oneRec = {
			"거래월,거래물량(kg),거래금액(원)", 
			"2018년 1월,16107304,37325875968" ,
			"2018년 2월,17171357,45044049693" ,
			"2018년 3월,16523480,36577043404" ,
			"2018년 4월,17317973,35697053180" ,
			"2018년 5월,21485180,38893082999" ,
			"2018년 6월,27777587,38516240089" ,
			"2018년 7월,22097814,34846295687" ,
			"2018년 8월,14924173,34802325518" 
		};
		

		String[] field_name = oneRec[0].split(",");
	
		for (int i=1 ; i <oneRec.length ; i++) { //필드명 제외 데이터 수만큼 반복(8회 출력)
			
			String[] field = oneRec[i].split(","); //데이터 콤마 구분 배열저장
			
			System.out.println("********************************");
			
			for (int j=0 ; j < field_name.length; j++) {//필드명 구분한 수 만큼 출력(3)
				try {
					System.out.printf(" %s : %s\n", field_name[j], HanCount(field[j])); //숫자읽기 처리
				}catch(Exception e) {
					System.out.printf(" %s : %s\n", field_name[j], field[j]); 	
				}//트라이캐치로 숫자읽기 처리가 에러나면(숫자가 아님) 그냥 찍음
			}
			System.out.println("********************************");
		}
	
	}
	
}