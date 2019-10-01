package programing_7강;

public class 클래스의배열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int iPerson = 5; //이값을 주는 만큼 저장소 생성
		
		OneRec [] inData = new OneRec[iPerson];//클래스형태의 배열이 생성
		// 배열(저장소의 갯수가 5개)
		//원렉클래스를 배열로 불러옴-이거의 인스턴스(이름)는 inData
		//클래스 자체가 배열(저장소에 저장됨)
		
		
		//클래스배열마다 클래스인스턴스 생성해 주어야함
		inData[0] = new OneRec("홍길01",100,100,90); // 각 배열마다 클래스 인스터스생성
		inData[1] = new OneRec("홍길02",90,90,90);//           "
		inData[2] = new OneRec("홍길03",80,70,90);//           "
		inData[3] = new OneRec("홍길04",70,60,90);//           "
		inData[4] = new OneRec("홍길05",60,100,90);//           "
		
		for (int i=0 ; i <iPerson ; i++) {
			System.out.printf("번호:%d 이름:%s 국어;%d 영어%d 수학%d 총점%d 평균%f\n",
					i, inData[i].name(),inData[i].kor(),inData[i].eng(),inData[i].mat(),
					inData[i].sum(),inData[i].ave());
		}
	}	
}
