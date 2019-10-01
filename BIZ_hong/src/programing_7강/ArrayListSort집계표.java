package programing_7강;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListSort집계표 {

		static ArrayList<OneRec2> ArrayOneRec2 =new ArrayList <OneRec2>();
		//어레이리스트에 onerec2클래스만 넣겠다
		
		static int sumkor = 0;
		static int sumeng = 0;
		static int summat = 0;
		static int sumsum = 0;
		static int sumave = 0;
		
		static int page_sumkor = 0;
		static int page_sumeng = 0;
		static int page_summat = 0;
		static int page_sumsum = 0;
		static int page_sumave = 0;
			
		static final int iPerson = 200;
		static final int pagePer =30;
		
		static int page_cnt =0;
		
		//데이터만들기
		public static void dataSet() {
			for ( int i=0 ; i < iPerson ; i++) {
				String name = String.format("홍길동%02d", i+1);//이름만들기
				int kor = (int)(Math.random()*100); //국어점수 만들기
				int eng = (int)(Math.random()*100); //영어점수 만들기
				int mat = (int)(Math.random()*100); //수학점수 만들기
				ArrayOneRec2.add(new OneRec2(i,name,kor,eng,mat));
				//하나의 OneRec2클래스 생성후 ArrayList에 집어넣음
			}	
		}
		
		//헤더인쇄
		public static void HeaderPrint(int page) {
			System.out.println("                   성적집계표\n");
			Calendar calt = Calendar.getInstance();
			SimpleDateFormat sdf= new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); 
			System.out.printf("PAGE : %d               출력일자 : %s\n",page+1,sdf.format(calt.getTime()));
			System.out.println("======================================================");
			System.out.printf("%2s   %-4s     %2s   %2s   %2s     %2s     %2s\n",
					"번호","이름","국어","영어","수학","합계","평균");
			System.out.println("======================================================");
		}
		
		//내용인쇄
		public static void ItemPrint(int i) {
			OneRec2 rec; //클래스불어옴 rec이라는 인스터스로
			rec=ArrayOneRec2.get(i);
		
			System.out.printf("%-3d   %-6.6s    %3d    %3d    %3d      %3d   %6.2f\n",
					rec.student_id()+1,rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.ave());
			
			sumkor+=rec.kor();
			sumeng+=rec.eng();
			summat+=rec.mat();
			sumsum+=rec.sum();
			sumave+=rec.ave();
			
			page_sumkor+=rec.kor();
			page_sumeng+=rec.eng();
			page_summat+=rec.mat();
			page_sumsum+=rec.sum();
			page_sumave+=rec.ave();
			
			page_cnt++;
				
		}
		
		//꼬리인쇄
		public static void TailPrint(int page) {
			//현재페이지 출력
			System.out.println("======================================================");
			System.out.println("현재페이지");
			System.out.printf("합계             %5d  %5d  %5d  %7d  %7d\n",
					page_sumkor,page_sumeng,page_summat,page_sumsum,page_sumave);
			System.out.printf("평균            %6.2f  %5.2f  %5.2f  %7.2f  %7.2f\n",
					page_sumkor/(double)(pagePer),page_sumeng/(double)(pagePer),page_summat/(double)(pagePer),
					page_sumsum/(double)(pagePer),page_sumave/(double)(pagePer));
			
			//다음페이지를 위해 현재 페이지  변수 초기화
			page_sumkor=0;page_sumeng=0;page_summat=0;page_sumsum=0;page_sumave=0;
			
			
			//누적페이지 출력
			System.out.println("======================================================");
			System.out.println("누적페이지");
			System.out.printf("합계             %5d  %5d  %5d  %7d  %7d\n",sumkor,sumeng,summat,sumsum,sumave);
			System.out.printf("평균            %6.2f  %5.2f  %5.2f  %7.2f  %7.2f\n",
					sumkor/(double)(pagePer*(page)+page_cnt),sumeng/(double)(pagePer*(page)+page_cnt),
					summat/(double)(pagePer*(page)+page_cnt),
					sumsum/(double)(pagePer*(page)+page_cnt),sumave/(double)(pagePer*(page)+page_cnt));
			System.out.println("\n");
			
			page_cnt=0;
		}
		//데이터 소트
				public static void dataSort() {
					Comparator<OneRec2> bikyokijun = new Comparator<OneRec2>() {
						public int compare(OneRec2 a1, OneRec2 a2) {
							return (a2.sum()-a1.sum());
						}
					};
					Collections.sort(ArrayOneRec2,bikyokijun);
				}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dataSet();//데이터만들기 실행
		//dataSort();
		//페이지별 반복 30명씩 인쇄
		
		for (int page =0; page < ArrayOneRec2.size()/pagePer+1; page++ ) {
			if (page > ArrayOneRec2.size()/pagePer -1 
					&& ArrayOneRec2.size()%pagePer == 0) break;
			//단순히 나누어 떨어질때만 브맄이면 아무것도 안찍힘
			//나누어떨어지고 또 돌아갈 때 밑에 안찍기 위해 조건 추가
			HeaderPrint(page);//헤더인쇄
			for(int i=0+(page*pagePer) ; i < (page+1)*pagePer ; i++) {
				if (i > ArrayOneRec2.size()-1) break; 
				//예를들어 90 이상일때 더 돌지 말라고
				//나머지를 처리를 위한 조건
				
				ItemPrint(i);//내용인쇄
				
			}
			TailPrint(page);//꼬리인쇄
		}	
		
		
	}

}

