package programing_4��;

public class �����б� {
	//���� ���� �� 1�� �ڸ��� ��,��,��..��
	//10�� �ڸ��� ��,�Ͻ���~�̽�,�̽���~���
	//10,20,30... ó���� ����
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������ �ִ� ��, ���� �ڸ���
		String[] units = {"��","��","��","��","��","��","��","ĥ","��","��"};
		//���� �ֵ��� �迭�� ���� ���ڿ� ���� �б� ����
		for (int i =0 ; i <101 ; i++) {
			
			if (i >=0 && i <10) { //1~9�б�
				System.out.printf("�����ڸ� : %s\n",units[i]); 
			} 
			else if (i >=10 && i <100) { //10~100�б�
				int i10, i0;
				i10 = i /10;//���� �ڸ�
				i0 = i %10; //���� �ڸ�
				if (i0==0) {//���� �ڸ��� 0�̸�
					System.out.printf("�����ڸ� : %s��\n",units[i10]); //10,20,30..ó��
				}else {
					System.out.printf("�����ڸ� : %s��%s\n",units[i10],units[i0]);
					//�� �Ϲݼ��ڵ� ó��
				}
			}else System.out.printf("==> %d\n",i);
		}	
	}

}
