package progaming_3강;



public class 사칙연산_연산_후_대입 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// #1. 연산 후 대입, 당연히 사칙연산의 순서
		int ii;
		ii = 1+2; // 연산 후 변수에 저장한다.
		System.out.printf("#1-1 : %d\n", ii);
		////
		ii = 1+2*3;
		System.out.printf("#1-2 : %d\n", ii);
		
		int a = 100;
		int b = 1;
		System.out.println(a*b/3);
		System.out.println(a*b/3.0);
		
		int iNumVal = 1001034567;
		
		String sNumVal = String.valueOf(iNumVal); //int를 String으로
		System.out.println(sNumVal.substring(1, 2));
		
	}

}
