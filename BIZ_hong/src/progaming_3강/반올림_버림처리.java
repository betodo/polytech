package progaming_3��;

public class �ݿø�_����ó�� {

	public static void main(String[] args) {            //������ �� ������ ��
		// TODO Auto-generated method stub              //�ݿø��� +���� �� ��
		int ii;                                         //�ø��� +�� �ڸ��� �� ��
		
		ii = 12345; // 12345�� 10�� �̸� ������ ó��
		System.out.println(ii/10);
		int j = (ii/10)*10;
		System.out.printf("#4-1 : %d\n", j);
		
		ii = 12345; // 10�� �̸� �ݿø� ó��
		j = ((ii+5)/10)*10;
		System.out.printf("#4-2 : %d\n", j);
		
		ii = 12344; // 10�� �̸� �ݿø� ó�� 
		j = ((ii+5)/10)*10;
		System.out.printf("#4-2 : %d\n", j);
		
/////////////////////////////////////////////////////

		// #4-2. �� ����
		for (int i = 12340; i <12350; i++) {
			j = ((i+5)/10)*10;
			System.out.printf("i=%d , j=%d\n", i,j);
		}
		//
		// #4-3. 1000�� �̸� ����,�ø�
		ii = 12399;
		j = (ii/100)*100;
		int k = ((ii+99)/100)*100;
		System.out.printf("#4-3 ����=%d, �ø�=%d\n",j,k);
		
		// #4-4. 10000�� �̸� ����, �ݿø�
		ii = 12789;
		j = (ii/1000)*1000;
		k = ((ii+500)/1000)*1000;
		System.out.printf("#4-3 ����=%d, �ݿø�=%d",j,k);
	}

}
