package programing_4��;

public class �����б�_��� {
	
	public static String HanCount(String num) {//��Ʈ�� ���� �б� �޼���
		String numRead=""; //���� �����
		
		String [] units= {"��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��"}; //�����б�
	    String [] unitx= {"", "��", "��", "õ", "��", "��", "��", "õ", "��", "��","��","õ"}; //������
		
	    int j = num.length()-1;//������ ���ڿ����� ���� ���ϴ� ��
	    					//��ü�ڸ���-1 �迭�� 0���ͼ��ϱ�
	    
	    for (int i=0;i <num.length();i++) {
	    	String numEach = units[Integer.parseInt(num.substring(i,i+1))];
	    	
	    	if (numEach=="0") {
	    		if (unitx[j]=="��" || unitx[j]=="��") { //���ʸ���õ 0�̶� ���ʿ�õ�̾�� �ϴµ�
	    			numRead = numRead + unitx[j];       //�������� ���ʸ���õ �Ȱ��� (�ʾ�, �ʸ� �������� 2��
	    		}else {} // �ƹ��͵� ����
	    		
	    	}else {
	    		numRead = numRead + numEach + unitx[j]; //���� ���� �ױ�
	    	}
	    	j--; //�������� j�� �ϳ��� �����鼭 ��
	    	
	    }
		return numRead;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������ ���ڷ� �ǽ�
		// �Ͻʾ� ��︸ ��õ ���� ���� ĥ �б�
		// ���ʺ��� �Ѱ��� ó��
		// ���� ���ڿ� ���� ���� 2���迭 �ʿ�
		// �ش� �ڸ��� 0�̸� ������ but ��� ���� ����
		// 2,030,200,00=�̽� (��)�� ��õ (����) �̽� (��)�� (��õ)(����)(����)
	      int iNumVal = 1001034567;
	      // String������ ���� �߰�
	      String sNumVal = String.valueOf(iNumVal);//int�� ��Ʈ������
	      String sNumVoice = "";
	      
	      System.out.printf("==> %s [%d�ڸ�]\n", sNumVal, sNumVal.length());
	      
	      int i, j;
	      
	      String [] units= {"��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��"}; //�����б�
	      String [] unitX= {"", "��", "��", "õ", "��", "��", "��", "õ", "��", "��"}; //������
	      
	      i = 0;
	      j = sNumVal.length()-1;//�����ϸ� �ڸ��� ������ 1���� ������ �迭�� 0���ͼ��ϱ�
	      						//ó�� j�� 9
	      
	      while (true) {
	         if ( i>= sNumVal.length()) break;//���̻� ���� ���ڸ��� ������ �ꐞ
	         // ���� ���ڿ� �� ���ڸ����� ���
	         System.out.printf("%s[%s]", sNumVal.substring(i,i+1), //i��° �ڸ� �ѱ��ڸ� �߶��
	                           units[Integer.parseInt(sNumVal.substring(i,i+1))]);//�� ���ڸ� ����(�迭�̿�)
	         					//��Ʈ������ �߶�� ���ڸ� ��Ʈ�� �ٲ�
	         					//�ش� ��ġ�� �迭���� ����
	         //�������б�
	         if (sNumVal.substring(i,i+1).contentEquals("0")) {
	            // �ش��ڸ��� 0�� �� ������ X
	            //��, �� �ڸ��� ������ �ٿ��� =�ʾ�, �ʸ� �������� 2�� 
	            if(unitX[j].equals("��")||unitX[j].equals("��")) {
	               sNumVoice=sNumVoice + "" + unitX[j]; //���� ���� �ױ�
	            } else {
	               // �ƹ��͵� ����
	            }
	         } else {//ù ����1��� snumVoice = ""+(int)1(��)+unit9(��)= �Ͻ�
	            sNumVoice = sNumVoice + units[Integer.parseInt(sNumVal.substring(i, i+1))]
	                             + unitX[j];// ���� ���ڿ� �������� �׾Ƽ� ó�� �׷��� �����ִ°�
	         }
	         i++; j--;
	      }
	      // �ϳ��� ����ϴ°� �ƴ϶� ����[�����б�]�������� ���
	      System.out.printf("\n %s[%s]\n", sNumVal, sNumVoice);

	}

}
