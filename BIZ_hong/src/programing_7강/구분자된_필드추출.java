package programing_7강;

public class 구분자된_필드추출 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] oneRec = {
			"허가(신고)번호,허가(신고)일자,영업종류,상호,우편번호,소재지(지번),소재지(도로명),연락처,시설면적(㎡),영업상태,안정성검사대상 유기기구 시설종수,안정성검사대상 유기기구 시설대수,안정성검사대상이 아닌 유기기구 시설종수,안정성검사대상이 아닌 유기기구 시설대수,소재지도로명여부",
			"27100-2013-000002,2013-10-21,일반유원시설업,아이스온아트,,부산광역시 북구 덕천동 763번지 ,,051-333-3238,9966,영업중,2,2,0,0,N",
			"27200-2015-000002,2015-08-25,기타유원시설업,만덕범퍼카랜드,46565,부산광역시 북구 만덕동 927-1번지 대성종합상가 106동 B01호,부산광역시 북구 만덕2로44번길 72, 106동 B01호 (만덕동, 대성종합상가),051-334-5436,207,영업중,0,0,1,7,Y",
			"27200-2015-000003,2015-09-17,기타유원시설업,홈런짱야구연습장,46576,부산광역시 북구 덕천동 400-8번지 ,부산광역시 북구 만덕대로16번길 8, 6층 (덕천동),051-333-4765,231,영업중,0,0,6,6,Y",
			"27200-2015-000004,2015-11-26,기타유원시설업,스타야구장,46576,부산광역시 북구 덕천동 402-3번지 3층 ,부산광역시 북구 덕천1길 32, 3층 (덕천동),,188,영업중,0,0,4,4,Y"
		};
		//파일 첫줄=필드명, 필드명을 콤마로 구분하여 배열에 담음
		String[] field_name = oneRec[0].split(",");
		
		for (int i=1 ; i <oneRec.length ; i++) { //필드명 제외 데이터 수만큼 반복(4회 출력)
			
			String[] field = oneRec[i].split(","); //데이터 콤마 구분 배열저장
			
			System.out.println("********************************");
			for (int j=0 ; j < field_name.length; j++) {//필드명 구분한 수 만큼 출력
				System.out.printf(" %s : %s\n", field_name[j], field[j]);
			}
			System.out.println("********************************");
		}
	
	}

}
