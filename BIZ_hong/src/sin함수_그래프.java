
public class sin�Լ�_�׷��� {
	//sin�Լ��� 1������ 360�� ���ϱ�
	//2���̴� 360��, sin�Լ����� -1 ~ 1
	//���ȭ�Ͽ� +1�ϸ� 0~2
	//�̳��� 50���ϸ� 0~100 ǥ�� ����
	//�� ����ŭ ��� �� ���� ���ϳ� ����
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//360��:2���� = 1��:x
		double fSin;
		
		for (int i =0 ; i <360 ; i++) {
			
			fSin = Math.sin(i *3.141592 /180);
			System.out.printf("%d sin ==>%f\n",i,fSin);
		}
		
		for (int i =0 ; i <360 ; i++) {
			
			fSin = Math.sin(i *3.141592 /180);
			int iSpace = (int)( (1.0-fSin) *50 );
			
			for(int j =0 ; j < iSpace ; j++) {
				System.out.print(" ");
			}
		System.out.printf("*[%f][%d]\n",fSin,iSpace);	
		}
	}

}
