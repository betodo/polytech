package programing_7��;

import java.util.ArrayList;

public class ArrayList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iTestMax = 100;
		ArrayList iAL = new ArrayList();
		
		for (int i=0 ; i < iTestMax; i++ ) {
			iAL.add( (int)(Math.random()*100) ); }
			//Math.random()�ϸ� 0~1�� ���� �װ� ���Ƿ� ���� ó��
		
		/*
		 * for (int i=0 ; i < iAL.size() ; i++) {
		 * System.out.printf("ArrayList %d = %d\n",i,iAL.get(i));}
		 */
		//���� ���� ���ڴ�� ���
		
		
		  System.out.println("******************************"); 
		  iAL.sort(null);
		  
		  for (int i=0 ; i < iAL.size() ; i++) {
		  System.out.printf("ArrayList %d = %d\n",i,iAL.get(i));}
		 
		// �����������ĵ� ��̸���Ʈ ��������
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
