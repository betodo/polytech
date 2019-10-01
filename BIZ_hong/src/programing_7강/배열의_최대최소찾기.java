package programing_7강;

public class 배열의_최대최소찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] iArray= {1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		for (int i=0 ; i < iArray.length ;i++) {//iArray배열값들 보기
			System.out.printf("iArray[%d]=%d\n", i, iArray[i]);
		}
		
		//MAX찾기
		int max=iArray[0]; //처음꺼부터 비교 시작
		int maxPt=0; //최초 비교값
		
		for (int i=0 ; i < iArray.length ; i++) { //배열 갯수 만큼 반복 비교
			
			if (max < iArray[i]) { // 만일 기존 맥스가 현재 배열값보다 작다면
				max = iArray[i];  //기존맥스를 현재배열값으로 바꿈
				maxPt=i; //비교할 배열의 위치 값도 바굼
			}
		}
		System.out.printf("MAX : iArray[%d]=%d\n",maxPt,max);
		
		
		
		
	}

}
