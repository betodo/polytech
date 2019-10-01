package programing_7강;

import java.util.ArrayList;

public class ArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList iAL = new ArrayList();
		
		iAL.add("abc"); //어레이리스트에 추가 .add
		iAL.add("abcd");
		iAL.add("efga");
		iAL.add("가나다0");
		iAL.add("1234");
		iAL.add("12rk");
		
		System.out.println("******************************");
		System.out.printf("시작 ArraySize %d\n",iAL.size());//=al 배열 갯수
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}//=al 리스트값 불러올때	
		
		iAL.set(3, "가라가라");//3번 al 내용변경
		System.out.println("******************************");
		System.out.printf("내용변경 ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		iAL.remove(4);//4번 al 삭제
		System.out.println("******************************");
		System.out.printf("삭제 ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		iAL.sort(null);//정렬 = 오름차순 숫자12 영문ab 한글가나
		System.out.println("******************************");
		System.out.printf("리스트 ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		iAL.clear();//al 내용전부 삭제
		System.out.println("******************************");
		System.out.printf("전부삭제 ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
