
public class �Ƕ�̵�_��� {
	// �̳��� ����� �߽����� ����� ��ĭ
	// �پ��� �ְ�, ���� 2���� �þ��
	// ��� �̽��� ��Ģ�� ã�� ������ ����!
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, m;
		m = 20;
		n = 1;
		
		while(true) {                   //f: 20��ĭ ���,�� 1���,�ٹٲ�
			for(int i =0; i <m ; i ++) {//s: m=19, n=3
			System.out.print(" ");	    // 19��ĭ ���, �� 3���, �ٹٲ�
			}                           //th : m=19, n=5
			for(int i =0; i <n ; i ++) {// 18��ĭ ���, �� 5���, �ٹٲ�
			System.out.print("*");	    // ���� �ݺ�
			}
			System.out.println();
			
			m = m -1;
			n = n +2;
			
			if (m <0) break;
		}
	}

}
