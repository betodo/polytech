package programing_4강;

public class 범위줘서_비교 {
	//조건문안에 범위줄 수 있음
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iVal;
		for(int i=0 ; i <300 ; i++) {
			iVal = 5 * i;
			
			//연산자는 && ||가 있다 한개짜리는 bit연산자임
			
			if (iVal >=0 && iVal <10) System.out.printf("일 %d\n",iVal);
			else if (iVal >=10 && iVal <100) System.out.printf("십 %d\n",iVal);
			else if (iVal >=100 && iVal <1000) System.out.printf("백 %d\n",iVal);
			else System.out.printf("천 %d\n",iVal);
			
		}
	}

}
