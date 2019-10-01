
public class sin함수_그래프 {
	//sin함수값 1도에서 360도 구하기
	//2파이는 360도, sin함수값은 -1 ~ 1
	//양수화하여 +1하면 0~2
	//이놈을 50배하면 0~100 표현 가능
	//그 값만큼 띄어 쓴 다음 별하나 찍어보자
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//360도:2파이 = 1도:x
		double fSin;
		
		for (int i =0 ; i <360 ; i++) {
			
			fSin = Math.sin(i *3.141592 /180);
			System.out.printf("%d sin ==>%f\n",i,fSin);
		}
		
		for (int i =0 ; i <360 ; i++) {
			
			fSin = Math.sin(i *3.141592 /180);
			int iSpace = (int)( (1.0-fSin) *50 );
			
			for(int j =0 ; j < iSpace ; j++) {
				System.out.print(" ");
			}
		System.out.printf("*[%f][%d]\n",fSin,iSpace);	
		}
	}

}
