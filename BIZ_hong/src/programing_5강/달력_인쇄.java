package programing_5강;

public class 달력_인쇄 {
	// 2019년 기준
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int iWeekday = 2; // 2019년 1월 1일은 화요일부터 시작!

		// 각 달의 마지막일 배열로 저장
		int[] iEnd = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		// 헤더출력 월,===,요일
		for (int iMon = 0; iMon < 12; iMon++) {
			System.out.printf("\n\n%14d월\n", iMon + 1);
			System.out.println("==============================");
			System.out.println("  일  월  화  수  목  금  토");//빈칸2한글2

			// 빈칸출력
			for (int k = 0; k < iWeekday; k++) {  //f:윜데이2, 2번 빈칸
				//4자리만큼 빈칸
				System.out.printf("%4s", " ");	//s:윜데이4, 4번빈칸,5번째 숫자
			}

			// 숫자출력
			for (int i = 1; i <= iEnd[iMon]; i++) {//f: i=1찍고, 윜데이3
												   //s: i=2찍고, 윅데이4
				System.out.printf("%4s", i);       //...윜데이7(다음주일요일)
				iWeekday++;						  //이면 줄바꿈, 윅데이 초기화
												//i는 계속 찍히면서 윅데이만 처리
				if (iWeekday == 7) {			//첫월 끝나면 다시 올라가서
					System.out.println();      // 마지막 윜데이=4(목)
					iWeekday = 0;
				}

			}

		}

	}

}
