package programing_6��;

public class Singleton {
	//�̱��� Ŭ�������� �����̺����� �̱��� ����
	//�ۺ����� �ϸ� ���ο��� �ٷ� s�� �����ع��� �� ����
	//Singleton s = Singleton.s; �̷������� ��s���β� ��s �̱��� Ŭ������
	//�ٷ� ������ ������ �� ���ҿ��ֳ� �̷� �ʿ䰡 ������
	private static Singleton s =new Singleton();
					
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {		
		
		return s;
	}
	
}
