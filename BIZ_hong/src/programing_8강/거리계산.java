package programing_8강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class 거리계산 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	// 실습2 융기원과 가장 가깝,먼 곳 찾기
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습" 
				+ "\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;

		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다\n");
			return;
		}
		//필드명 첫줄 읽고 분리
		String[] field_name =readtxt.split("\t");//필드명 얻기

		double lat = 37.3860521; //융기원위도
		double lng = 127.1214038;//융기원경도
		
						   //와일문에 들어가서 처음값을 비교값으로 받기위해
		double maxDist =0; //초기맥스값 데이터상 다 양수이므로 0
		double minDist =10000;//초기민값 절대적으로 큰수로 비교
		
		String maxPlace =null; //가장먼곳의 출력데이터
		String maxlat =null;
		String maxlng =null;
		
		String minPlace =null;// 가장가까운 곳의 출력데이터
		String minlat =null;
		String minlng =null;
		
		int LineCnt = 1; // 몇번째항목인지 변수
		int maxLineCnt =1;
		int minLineCnt =1;
		
		while ((readtxt = br.readLine()) != null) {//끝까지 읽기

			String[] field = readtxt.split("\t");//탭으로 나눠서 필드에 저장
			
			double dist = Math.sqrt(// 두점의 거리(피타고라스정리)
						Math.pow(Double.parseDouble(field[12]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[13]) - lng, 2));

			if (maxDist < dist) {//맥스값 찾기
				maxDist = dist;  // 하나씩 계속 비교해나감 맥스가 더 작으면 큰놈으로
				maxPlace = field[9];//그때의 장소
				maxlat = field[12];//그때의 위경도
				maxlng = field[13];
				maxLineCnt =LineCnt;//그때의 줄수
			}
			
			if (minDist > dist) {//민값도 마찬가지
				minDist = dist; 
				minPlace = field[9];
				minlat = field[12];
				minlng = field[13];
				minLineCnt =LineCnt;
			}
			
			LineCnt++;//한줄 읽을동안 할일 다했으면 다시 와일문 돌기전에 줄수 올려줌
		}
		br.close();
		
		//출력
		System.out.printf("**[%d번째 항목]*************\n", maxLineCnt);
		System.out.println("가장먼곳");
		System.out.println(field_name[9] + " : " + maxPlace );
		System.out.println(field_name[12] + " : " + maxlat );
		System.out.println(field_name[13] + " : " + maxlng );
		System.out.printf("융기원과의 거리 : %f\n", maxDist);
		System.out.println("******************************");
		System.out.printf("**[%d번째 항목]*************\n", minLineCnt);
		System.out.println("가장가까운곳");
		System.out.println(field_name[9] + " : " + minPlace );
		System.out.println(field_name[12] + " : " + minlat );
		System.out.println(field_name[13] + " : " + minlng );
		System.out.printf("융기원과의 거리 : %f\n", minDist);
		System.out.println("******************************");
		
	}
}
//////////////////////////////////////////////////////////////////////////////////		
		
		