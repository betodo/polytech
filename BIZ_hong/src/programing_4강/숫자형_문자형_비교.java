package programing_4강;

public class 숫자형_문자형_비교 {
	//int와 double의 차이 $ 스트링 비교는 .equals( )
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int il;
		double iD;
		
		il=10/3;//---걍 3 소수점 절삭
		iD=10/3.0;// 실제 :3.33333333333333333.. 표현3.33333 (6자리만)
		
		//int와 double은 정수형연산 실수형 연산이다. => 서로다름
		if (il == iD) System.out.println("equal");
		else System.out.printf("Not equal [%f][%f]\n",(double)il,iD);
		
		//유효숫자의 표기가 같을 뿐 => 다른 숫자
		if (iD == 3.333333) System.out.println("equal");
		else System.out.printf("Not equal [3.333333][%f]\n",iD);
		
		//정수형으로 바꾸면 소수점 버림 같아짐
		iD = (int)iD;
		if (il == iD) System.out.println("equal");
		else System.out.printf("Not equal [%f][%f]\n",(double)il,iD);
		
		System.out.printf("int로 인쇄[%d][%f]\n",il,iD);
		System.out.printf("double로 인쇄[%f][%f]\n",(double)il,iD);
		
		// char 1개는 a=='a'로 비교가능
		char a='c'; 
		if (a=='b') System.out.println("a는 b이다.");
		if (a=='c') System.out.println("a는 c이다.");
		if (a=='d') System.out.println("a는 d이다.");
		
		//String은 클래스함수.equals("")사용가능
		String aa="abcd";
		if (aa.equals("abcd")) System.out.println("aa는 abcd이다.");
		else System.out.println("aa는 abcd가 아니다.");
		
		// !!는 이중부정
		boolean bb = true;
		if (!!bb) System.out.println("bb가 아니고 아니면 참이다.");
		else System.out.println("bb가 아니고 아니면 거짓이다.");
		
		
		
	}

}
