package programing_7��;

import java.util.ArrayList;

public class ArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList iAL = new ArrayList();
		
		iAL.add("abc"); //��̸���Ʈ�� �߰� .add
		iAL.add("abcd");
		iAL.add("efga");
		iAL.add("������0");
		iAL.add("1234");
		iAL.add("12rk");
		
		System.out.println("******************************");
		System.out.printf("���� ArraySize %d\n",iAL.size());//=al �迭 ����
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}//=al ����Ʈ�� �ҷ��ö�	
		
		iAL.set(3, "���󰡶�");//3�� al ���뺯��
		System.out.println("******************************");
		System.out.printf("���뺯�� ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		iAL.remove(4);//4�� al ����
		System.out.println("******************************");
		System.out.printf("���� ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		iAL.sort(null);//���� = �������� ����12 ����ab �ѱ۰���
		System.out.println("******************************");
		System.out.printf("����Ʈ ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		iAL.clear();//al �������� ����
		System.out.println("******************************");
		System.out.printf("���λ��� ArraySize %d\n",iAL.size());
		
		for (int i=0 ; i < iAL.size() ; i++) {
			System.out.printf("ArrayList %s = %s\n",i,iAL.get(i));}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
