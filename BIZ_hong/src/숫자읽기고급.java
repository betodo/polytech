
public class �����б��� {
	//1,001,034,567
	//�Ͻʾ��︸��õ��������ĥ �б�--��Ģ�� �ľ��ؼ� ���α׷����� ǥ��
	//���ʺ��� �Ѱ��� ó��
	//��~��, ����: �� �� õ �� ~
	//�ش� �ڸ��� 0�϶� ���аų� ��,���� ���� ���̳� ���� ����
	//2,030,200,000 = �̽�(��)�� ��õ(����)�̽�(��)�� (��õ)(����)(��)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iNumVal = 1001034567;
		
		String sNumVal = String.valueOf(iNumVal); //int�� String����
		String sNumVoice="";
		System.out.printf("==> %s [%d�ڸ�]\n",sNumVal,sNumVal.length());
		
		int i,j;
		
		String[] units = {"��","��","��","��","��","��","��","ĥ","��","��"};
		String[] unitx= {"","��","��","õ","��","��","��","õ","��","��"};
		
		i=0;
		j=sNumVal.length()-1; // ó�� j=9
		
		while (true) {
			if (i >=sNumVal.length()) break;
			
			System.out.printf("%s[%s]",
					sNumVal.substring(i,i+1),
					units[Integer.parseInt(sNumVal.substring(i, i+1))]);
						//Integer.parseInt(X) = String X�� int��
							//X.substirng(n,m) = ���ڿ� X�� ��°���� m�̸� ��°���� ����
							//���ڸ� �� �� �а� ����
			if (sNumVal.substring(i, i+1).equals("0")) {
				// �ش��ڸ��� 0�϶� �������� �Ⱥ��̴µ� ��, �� �ڸ��� ���δ�.
				// �̹� �縸 �̽�.. �̹� �� ��..
				//��, ���ڸ��� �ƴϸ� �ƹ����� ����
				if (unitx[j].equals("��") || unitx[j].equals("��")) {
					sNumVoice = sNumVoice + ""+ unitx[j];					
				}else {
					//�ƹ����� ����
				}
			}else {
				sNumVoice = sNumVoice +
						units[Integer.parseInt(sNumVal.substring(i, i+1))]+
						unitx[j];
			}
			i++; j--;
		}	
		System.out.printf("\n %s[%s]\n",sNumVal,sNumVoice);	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
