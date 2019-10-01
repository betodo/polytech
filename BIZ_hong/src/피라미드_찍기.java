
public class 피라미드_찍기 {
	// 이놈은 가운데를 중심으로 띄어쓰기는 한칸
	// 줄어들고 있고, 별은 2개씩 늘어난다
	// 모든 이슈의 규칙을 찾는 습관을 갖자!
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m;
		m = 20;
		n = 1;
		
		while(true) {                   //f: 20빈칸 찍고,별 1찍고,줄바꿈
			for(int i =0; i <m ; i ++) {//s: m=19, n=3
			System.out.print(" ");	    // 19빈칸 찍고, 별 3찍고, 줄바꿈
			}                           //th : m=19, n=5
			for(int i =0; i <n ; i ++) {// 18빈칸 찍고, 별 5찍고, 줄바꿈
			System.out.print("*");	    // 이짓 반복
			}
			System.out.println();
			
			m = m -1;
			n = n +2;
			
			if (m <0) break;
		}
	}

}
