package programing_7��;

public class �����ڵ�_�ʵ�����2 {

	public static String HanCount(String num) {//��Ʈ�� ���� �б�
		String numRead=""; //���� �����
		
		String [] units= {"��", "��", "��", "��", "��", "��", "��", "ĥ", "��", "��"}; //�����б�
	    String [] unitx= {"", "��", "��", "õ", "��", "��", "��", "õ", "��", "��","��","õ"}; //������
		
	    int j = num.length()-1;//������ ���ڿ����� ���� ���ϴ� ��
	    					//��ü�ڸ���-1 �迭�� 0���ͼ��ϱ�
	    
	    for (int i=0;i <num.length();i++) {
	    	String numEach = units[Integer.parseInt(num.substring(i,i+1))];
	    	
	    	if (numEach=="0") {
	    		if (unitx[j]=="��" || unitx[j]=="��") {
	    			numRead = numRead + unitx[j];//���� ���� �ױ�
	    		}else {} // �ƹ��͵� ����
	    		
	    	}else {
	    		numRead = numRead + numEach + unitx[j]; //�����б�� �������� �ױ�
	    	}
	    	j--;//�������� j�� �ϳ��� �����鼭 ��
	    	
	    }
		return numRead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] oneRec = {
			"�ŷ���,�ŷ�����(kg),�ŷ��ݾ�(��)", 
			"2018�� 1��,16107304,37325875968" ,
			"2018�� 2��,17171357,45044049693" ,
			"2018�� 3��,16523480,36577043404" ,
			"2018�� 4��,17317973,35697053180" ,
			"2018�� 5��,21485180,38893082999" ,
			"2018�� 6��,27777587,38516240089" ,
			"2018�� 7��,22097814,34846295687" ,
			"2018�� 8��,14924173,34802325518" 
		};
		

		String[] field_name = oneRec[0].split(",");
	
		for (int i=1 ; i <oneRec.length ; i++) { //�ʵ�� ���� ������ ����ŭ �ݺ�(8ȸ ���)
			
			String[] field = oneRec[i].split(","); //������ �޸� ���� �迭����
			
			System.out.println("********************************");
			
			for (int j=0 ; j < field_name.length; j++) {//�ʵ�� ������ �� ��ŭ ���(3)
				try {
					System.out.printf(" %s : %s\n", field_name[j], HanCount(field[j])); //�����б� ó��
				}catch(Exception e) {
					System.out.printf(" %s : %s\n", field_name[j], field[j]); 	
				}//Ʈ����ĳġ�� �����б� ó���� ��������(���ڰ� �ƴ�) �׳� ����
			}
			System.out.println("********************************");
		}
	
	}
	
}