package programing_6강;

public class Singleton {
	//싱글톤 클래스에서 프라이빗으로 싱글톤 생성
	//퍼블릭으로 하면 메인에서 바로 s로 접근해버릴 수 있음
	//Singleton s = Singleton.s; 이런식으로 앞s메인꺼 뒤s 싱글톤 클래스꺼
	//바로 접근해 버리면 다 뭔소용있냐 이럴 필요가 없어짐
	private static Singleton s =new Singleton();
					
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {		
		
		return s;
	}
	
}
