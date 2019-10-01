package programing_7강;

import java.util.ArrayList;

public class 클래스의_ArrayList {

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
			System.out.printf("%2s  %4s  %2s  %2s  %2s  %2s   %2s\n","번호",
					"이름","국어","영어","수학","합계","평균");
			System.out.println("*********************************************");
		}
		
		//내용인쇄
		public static void ItemPrint(int i) {
			OneRec2 rec; //클래스불어옴 rec이라는 인스터스로
			rec=ArrayOneRec2.get(i);//rec에 arrayonerec2.get매서드 결과 저장
		
			System.out.printf("%4d  %4s  %3d  %3d  %3d    %3d  %6.2f\n",
					rec.student_id(),rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.ave());
					//rec.클래스의 name등의 메서드 실행해서 출력
			sumkor+=rec.kor();
			sumeng+=rec.eng();
			summat+=rec.mat();
			sumsum+=rec.sum();
			sumave+=rec.ave();
		}
		
		//꼬리인쇄
		public static void TailPrint() {//포문이 돌아가는 동안 합계 누적됨 
			System.out.println("*********************************************");
			System.out.printf("국어합계 %d   국어평균 : %6.2f\n",sumkor,sumkor/(double)ArrayOneRec2.size());
			System.out.printf("영어합계 %d   영어평균 : %6.2f\n",sumeng,sumeng/(double)ArrayOneRec2.size());
			System.out.printf("수학합계 %d   수학평균 : %6.2f\n",summat,summat/(double)ArrayOneRec2.size());
			System.out.println("*********************************************");
			System.out.printf("반평균합계 %d   반평균 : %6.2f\n",sumave,sumave/(double)ArrayOneRec2.size());
		}	//어렉사이즈는 전체 사람수가 됨
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dataSet();//데이터만들기 실행
		HeaderPrint();
		for(int i=0 ; i < ArrayOneRec2.size() ; i++) { //어렉사이즈=사람수
			ItemPrint(i);
		}
		TailPrint();//꼬리인쇄
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
