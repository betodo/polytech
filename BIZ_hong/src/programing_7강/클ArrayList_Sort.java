package programing_7강;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 클ArrayList_Sort {

		static ArrayList<OneRec2> ArrayOneRec2 =new ArrayList <OneRec2>();
		//어레이리스트에 onerec2클래스만 넣겠다
		
		static int sumkor = 0;//변수선언 //생성자
		static int sumeng = 0;
		static int summat = 0;
		static int sumsum = 0;
		static int sumave = 0;
		static final int iPerson = 20;
		
		//데이터만들기
		public static void dataSet() {
			for ( int i=0 ; i < iPerson ; i++) {
				String name = String.format("홍길동%02d", i);//이름만들기
				int kor = (int)(Math.random()*100); //국어점수 만들기
				int eng = (int)(Math.random()*100); //영어점수 만들기
				int mat = (int)(Math.random()*100); //수학점수 만들기
				ArrayOneRec2.add(new OneRec2(i,name,kor,eng,mat));
				//하나의 OneRec2클래스 생성후 ArrayList에 집어넣음
			}	
		}
		
		//헤더인쇄
		public static void HeaderPrint() {
			System.out.println("*********************************************");
			System.out.printf("%2s  %4s  %2s  %2s  %2s  %2s   %2s\n","번호","이름","국어","영어","수학","합계","평균");
			System.out.println("*********************************************");
		}
		
		//내용인쇄
		public static void ItemPrint(int i) {
			OneRec2 rec; //클래스불어옴 rec이라는 인스터스로
			rec=ArrayOneRec2.get(i);
		
			System.out.printf("%4d  %4s  %3d  %3d  %3d    %3d  %6.2f\n",
					rec.student_id(),rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.ave());
			
			sumkor+=rec.kor();
			sumeng+=rec.eng();
			summat+=rec.mat();
			sumsum+=rec.sum();
			sumave+=rec.ave();
		}
		
		//꼬리인쇄
		public static void TailPrint() {
			System.out.println("*********************************************");
			System.out.printf("국어합계 %d   국어평균 : %6.2f\n",sumkor,sumkor/(double)ArrayOneRec2.size());
			System.out.printf("영어합계 %d   영어평균 : %6.2f\n",sumeng,sumeng/(double)ArrayOneRec2.size());
			System.out.printf("수학합계 %d   수학평균 : %6.2f\n",summat,summat/(double)ArrayOneRec2.size());
			System.out.println("*********************************************");
			System.out.printf("반평균합계 %d   반평균 : %6.2f\n",sumave,sumave/(double)ArrayOneRec2.size());
		}
		
		//데이터 소트
		public static void dataSort() {
			Comparator<OneRec2> bikyokijun = new Comparator<OneRec2>() {
			// 클래스등의 복잡한 ArrayList의 소트는 콜랙션과 컴퍼레이터 클래스 이용하여 소트
			// 컴퍼레이터 클래스 생성시 compare메소드 재정의 필요(오버로딩) 비교기준 정하자
				public int compare(OneRec2 a1, OneRec2 a2) { //앞 뒤 레코드 비교
					return (a2.sum()-a1.sum()); //빼서 양수값이면 취함 즉 오름차순
					//a2,a1 반대로 써주면 내림차순
				}
			};
			Collections.sort(ArrayOneRec2,bikyokijun);
			//설정한 내용대로 정렬
			//Collections.reserve(ArrayOneRec2);//역정렬(뒤집기)
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dataSet();//데이터만들기 실행
		dataSort();// 데이터 정렬
		HeaderPrint();
		for(int i=0 ; i < ArrayOneRec2.size() ; i++) {
			ItemPrint(i);
		}
		TailPrint();//꼬리인쇄
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
