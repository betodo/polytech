package programing_7강;

public class 한글_계산 {

	// HanBlankForeword매서드 = 앞으로 빈칸
	public static String HanBlankForeword (String text, int num) {
		String returnText = "";//초기화
		returnText = text;

		for (int i = 0; i < num - text.getBytes().length; i++) {//총자릿수-글자자릿수
			returnText = " " + returnText;//한글때문에 getByte사용
		}

		return returnText;}

	// HanBlankForeword매서드 = 뒤로 빈칸
	public static String HanBlankBackword (String text, int num) {//num은 총자릿수
		String returnText = "";
		returnText = text;

		for (int i = 0; i < num - text.getBytes().length; i++) {
			returnText = returnText + " "; //포문이 총자릿수에서 text의 바이트를 
		}								   //뺀 숫자만큼 빈칸을 채움

		return returnText;}
	
	//주어진 문자열의 한글수 리턴
	public static int HanCount (String text) {
		int HanCount =0;
			HanCount = text.getBytes().length - text.length();
			//한 문자열의 바이트와 랭스의 차이는 곧 한글의 갯수 
			//한글이 1바이트 더 먹으닌까 
		return HanCount;}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("HanBlankForewod[%s]\n", HanBlankForeword("한글abcd", 15));
		System.out.printf("HanBlankForewod[%s]\n", HanBlankForeword("한글한글aa", 15));
		System.out.printf("HanBlankForewod[%s]\n", HanBlankBackword("한글aa", 15));
		System.out.printf("HanBlankForewod[%s]\n", HanBlankBackword("한글한글aa", 15));
		System.out.printf("한글은 [%d]개",HanCount("한글한글aa"));
	}

}
