package programing_7��;

public class �迭��_�ִ��ּ�ã�� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] iArray= {1,7,5,3,2,1,3,4,9,12,1,212,33,11,21,11,2121,121,11,5,6,33};
		
		for (int i=0 ; i < iArray.length ;i++) {//iArray�迭���� ����
			System.out.printf("iArray[%d]=%d\n", i, iArray[i]);
		}
		
		//MAXã��
		int max=iArray[0]; //ó�������� �� ����
		int maxPt=0; //���� �񱳰�
		
		for (int i=0 ; i < iArray.length ; i++) { //�迭 ���� ��ŭ �ݺ� ��
			
			if (max < iArray[i]) { // ���� ���� �ƽ��� ���� �迭������ �۴ٸ�
				max = iArray[i];  //�����ƽ��� ����迭������ �ٲ�
				maxPt=i; //���� �迭�� ��ġ ���� �ٱ�
			}
		}
		System.out.printf("MAX : iArray[%d]=%d\n",maxPt,max);
		
		
		
		
	}

}
