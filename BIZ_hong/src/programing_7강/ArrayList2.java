package programing_7강;

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iTestMax = 100;
		ArrayList iAL = new ArrayList();
		
		for (int i=0 ; i < iTestMax; i++ ) {
			iAL.add( (int)(Math.random()*100) ); }
			//Math.random()하면 0~1값 나옴 그걸 임의로 정수 처리
		
		/*
		 * for (int i=0 ; i < iAL.size() ; i++) {
		 * System.out.printf("ArrayList %d = %d\n",i,iAL.get(i));}
		 */
		//정렬 없이 지멋대로 출력
		
		
		  System.out.println("******************************"); 
		  iAL.sort(null);
		  
		  for (int i=0 ; i < iAL.size() ; i++) {
		  System.out.printf("ArrayList %d = %d\n",i,iAL.get(i));}
		 
		// 오름차순정렬됨 어레이리스트 순에따라
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
