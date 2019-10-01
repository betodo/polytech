
public class 띄어쓰기 {
	// 원하는 칸 만큼 블랭크(빈칸)출력
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i =0; i <10 ; i++) {   
			for(int j =0; j <i ; j++) { 
				System.out.print(" ");
			}
		System.out.println(i);
		}
	//fi : i=0, 내부포문안돌고 0찍고 줄내림
	//se : i=1, 내부포문 1번돌고 (1번 빈칸찍고)
	//     내부포문 나와서 1찍고 줄내림 이짓 반복
	}

}
