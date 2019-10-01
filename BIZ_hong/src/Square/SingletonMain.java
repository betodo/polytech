package Square;

public class SingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Singleton s = new Singleton(); 생성자가 private이라 못호출함
		
		Singleton s1 =Singleton.getInstance();
		Singleton s2 =Singleton.getInstance();
		Singleton s3 =Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
