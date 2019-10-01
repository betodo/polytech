package programing_8강;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class 거리계산_실습3 {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\admin\\Desktop\\나\\홍필두교수님파일실습" 
				+ "\\전국주차장표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		
		
		String readtxt;

		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다\n");
			return;
		}

		String[] field_name =readtxt.split("\t");//필드명 얻기

		double lat = 37.386000; //구글맵 기준 융기원 위도
		double lng = 127.121346;//구글맵 기준 융기원 경도
		
						   //와일문에 들어가서 처음값을 비교값으로 받기위해
		double maxDist =0; //초기맥스값 데이터상 다 양수이므로 0
		double minDist =10000;//초기민값 절대적으로 큰수로 비교
		
		String maxPlace =null;
		String maxAddr =null;//가장먼곳의 출력데이터
		String maxlat =null;
		String maxlng =null;
		
		String minPlace =null;
		String minAddr =null;// 가장가까운 곳의 출력데이터
		String minlat =null;
		String minlng =null;
		
		int LineCnt = 1; // 몇번째항목인지 변수
		int maxLineCnt =1;
		int minLineCnt =1;
		
		while ((readtxt = br.readLine()) != null) {

			String[] field = readtxt.split("\t");
			try {//위도or경도가 비어있으면 오류=오류처리위해
			
			double dist = Math.sqrt(// 두점의 거리(피타고라스정리)
						Math.pow(Double.parseDouble(field[28]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[29]) - lng, 2));
			
			//가장먼곳
			if (maxDist < dist) {
				maxDist = dist; //맥스값 찾기
				maxPlace = field[1];
				//주소찍기
				if(field[4].isBlank()) {//지번주소가 안나와있으면
					maxAddr = field[5];//도로명주소로
				}else {
					maxAddr = field[4];
				}
				if (field[4].isBlank() && field[5].isBlank()) { //둘다 없으면
					maxAddr = "주소없음";}//주소없음으로
				
				maxlat = field[28];
				maxlng = field[29];
				maxLineCnt =LineCnt;
			}
			//가장가까운곳 (가장먼곳과 같은 로직)
			if (minDist > dist) {
				minDist = dist; //민값 찾기
				minPlace = field[1];
				//주소찍기
				if(field[4].isBlank()) { //도로명 주소 없으면
					minAddr = field[5]; //지번주소
				}else {
					minAddr = field[4];
				}
				if (field[4].isBlank() && field[5].isBlank()) { //둘다 없으면
					minAddr = "주소없음";}
				
				minlat = field[28];
				minlng = field[29];
				minLineCnt =LineCnt;
			}
			}catch (Exception e) {
				
			}
			LineCnt++;
		}
		br.close();
		
		//출력
		//가장먼
		System.out.printf("**[%d번째 항목]*************\n", maxLineCnt);
		System.out.println("가장 먼 곳 : " + maxPlace);
		System.out.println("지번 또는 도로명 주소 : " + maxAddr );
		System.out.println(field_name[28] + " : " + maxlat );
		System.out.println(field_name[29] + " : " + maxlng );
		System.out.printf("융기원과의 거리 : %f\n", maxDist);
		System.out.println("******************************");
		//가장 가까운
		System.out.printf("**[%d번째 항목]*************\n", minLineCnt);
		System.out.println("가장 가까운 곳 : " + minPlace);
		System.out.println("지번 또는 도로명 주소 : " + minAddr);
		System.out.println(field_name[28] + " : " + minlat );
		System.out.println(field_name[29] + " : " + minlng );
		System.out.printf("융기원과의 거리 : %f\n", minDist);
		System.out.println("******************************");
	}

}
