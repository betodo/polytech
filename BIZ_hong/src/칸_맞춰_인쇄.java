import java.text.DecimalFormat;

public class ĭ_����_�μ� {
	//�Ϲ��� ����Ʈ�� ��� �μ� �� ���� �μ�
	//��Ʈ�� ĭ�� �¾ƾ� ��(�ѱ�1��=����2��)
	//����� ���� �ѱ��� 1s�� �ν��Ѵ�
	//(�� �ѱ� ���ڴ� -1�� �ؾ��Ѵ�. ���غ��� �ȴ�.)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.printf("%1.1s\n","a");
		//System.out.printf("%1.1s","��");
		
		String item = "���";
		int unit_price = 5000;
		int num = 500;
		int total = 0;
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		
		//������
		System.out.println("=====================================================");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n","ǰ��","�ܰ�","����","�հ�");
		System.out.println("=====================================================");
		//�����
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n",
				item, df.format(unit_price),df.format(num),df.format(unit_price*num));
		System.out.println("=====================================================");
	}

}
