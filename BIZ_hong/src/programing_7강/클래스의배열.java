package programing_7��;

public class Ŭ�����ǹ迭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int iPerson = 5; //�̰��� �ִ� ��ŭ ����� ����
		
		OneRec [] inData = new OneRec[iPerson];//Ŭ���������� �迭�� ����
		// �迭(������� ������ 5��)
		//����Ŭ������ �迭�� �ҷ���-�̰��� �ν��Ͻ�(�̸�)�� inData
		//Ŭ���� ��ü�� �迭(����ҿ� �����)
		
		
		//Ŭ�����迭���� Ŭ�����ν��Ͻ� ������ �־����
		inData[0] = new OneRec("ȫ��01",100,100,90); // �� �迭���� Ŭ���� �ν��ͽ�����
		inData[1] = new OneRec("ȫ��02",90,90,90);//           "
		inData[2] = new OneRec("ȫ��03",80,70,90);//           "
		inData[3] = new OneRec("ȫ��04",70,60,90);//           "
		inData[4] = new OneRec("ȫ��05",60,100,90);//           "
		
		for (int i=0 ; i <iPerson ; i++) {
			System.out.printf("��ȣ:%d �̸�:%s ����;%d ����%d ����%d ����%d ���%f\n",
					i, inData[i].name(),inData[i].kor(),inData[i].eng(),inData[i].mat(),
					inData[i].sum(),inData[i].ave());
		}
	}	
}
