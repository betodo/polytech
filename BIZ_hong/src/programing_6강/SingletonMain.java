package programing_6��;

public class SingletonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Singleton s = new Singleton(); �����ڰ� private�̶� ��ȣ����
		//���ο��� new ������ �ϱ� ���ؼ� ���� ����
		
		Singleton s1 =Singleton.getInstance();//getInstance�޼ҵ鸦 ȣ���ϸ�
		Singleton s2 =Singleton.getInstance();//�̱��� Ŭ�������� ������ s�� ����
		Singleton s3 =Singleton.getInstance();//s1,s2,s3��� ���� s�� ����
											  //�׷��� ����� ����
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
//		Singleton s = new Singleton();

	}

}
//���
//programing_6��.Singleton@2ef9b8bc
//programing_6��.Singleton@2ef9b8bc
//programing_6��.Singleton@2ef9b8bc