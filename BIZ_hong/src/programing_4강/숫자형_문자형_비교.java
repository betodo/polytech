package programing_4��;

public class ������_������_�� {
	//int�� double�� ���� $ ��Ʈ�� �񱳴� .equals( )
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int il;
		double iD;
		
		il=10/3;//---�� 3 �Ҽ��� ����
		iD=10/3.0;// ���� :3.33333333333333333.. ǥ��3.33333 (6�ڸ���)
		
		//int�� double�� ���������� �Ǽ��� �����̴�. => ���δٸ�
		if (il == iD) System.out.println("equal");
		else System.out.printf("Not equal [%f][%f]\n",(double)il,iD);
		
		//��ȿ������ ǥ�Ⱑ ���� �� => �ٸ� ����
		if (iD == 3.333333) System.out.println("equal");
		else System.out.printf("Not equal [3.333333][%f]\n",iD);
		
		//���������� �ٲٸ� �Ҽ��� ���� ������
		iD = (int)iD;
		if (il == iD) System.out.println("equal");
		else System.out.printf("Not equal [%f][%f]\n",(double)il,iD);
		
		System.out.printf("int�� �μ�[%d][%f]\n",il,iD);
		System.out.printf("double�� �μ�[%f][%f]\n",(double)il,iD);
		
		// char 1���� a=='a'�� �񱳰���
		char a='c'; 
		if (a=='b') System.out.println("a�� b�̴�.");
		if (a=='c') System.out.println("a�� c�̴�.");
		if (a=='d') System.out.println("a�� d�̴�.");
		
		//String�� Ŭ�����Լ�.equals("")��밡��
		String aa="abcd";
		if (aa.equals("abcd")) System.out.println("aa�� abcd�̴�.");
		else System.out.println("aa�� abcd�� �ƴϴ�.");
		
		// !!�� ���ߺ���
		boolean bb = true;
		if (!!bb) System.out.println("bb�� �ƴϰ� �ƴϸ� ���̴�.");
		else System.out.println("bb�� �ƴϰ� �ƴϸ� �����̴�.");
		
		
		
	}

}
