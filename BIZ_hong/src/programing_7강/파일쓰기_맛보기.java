package programing_7��;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ���Ͼ���_������ {
	
	//����->���ϸ���/������->���۵帮��/������
	//�ý����� ->��ǲ��Ʈ������->���۵帮��
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileWriter fw = new FileWriter("C:\\Users\\admin\\Desktop\\a.txt",true);
		//�����ϰ��� �ϴ� �����̸�(�ʿ��� ��ε� �����,Ʈ��� �ߺ��� ����� ����
		
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sf = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�����д� Ŭ���� br��� ��ǲ��Ʈ���б�� ������ �аڴ�
		
		String str ="";
		while(!(str = br.readLine()).startsWith("s"));
			sf.append(str+"\n"); //��Ʈ�����ۿ� ���پ� �о� ����Ѵ�.
								 //����ġ�� ���
								//s�� �����ϴ� �ƹ��ܾ� ġ�� ����
			
		br.close(); //�ڿ����� (br�ݱ�)
		fw.write(sf.toString()); //��Ʈ�����۸� ��Ʈ�������� ��ȯ�Ͽ� ���
		fw.flush();
		fw.close();
		System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		
		//ó�� �����ϸ� ������ο� ���� ������
		//�ܼ�â�� ���پ� �Է��ϰ�(����)
		//s�� �����ϴ� �ƹ��ų� �Է��ϸ� ������ �Ϸ�Ǿ����ϴ�. ��
		//���ϰ����� �������� ������ �����(���)
	}

}
