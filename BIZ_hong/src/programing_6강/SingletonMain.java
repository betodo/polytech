package programing_6강;

public class SingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Singleton s = new Singleton(); 생성자가 private이라 못호출함
		//메인에서 new 못쓰게 하기 위해서 만든 패턴
		
		Singleton s1 =Singleton.getInstance();//getInstance메소들를 호출하면
		Singleton s2 =Singleton.getInstance();//싱글톤 클래스에서 선언한 s가 생성
		Singleton s3 =Singleton.getInstance();//s1,s2,s3모두 같은 s를 가짐
											  //그래서 결과가 같다
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
//		Singleton s = new Singleton();

	}

}
//결과
//programing_6강.Singleton@2ef9b8bc
//programing_6강.Singleton@2ef9b8bc
//programing_6강.Singleton@2ef9b8bc