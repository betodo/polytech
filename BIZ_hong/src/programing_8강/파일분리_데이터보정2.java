package programing_8��;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ���Ϻи�_�����ͺ���2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// \�� Ư�����̹Ƿ� \\�ΰ��� ����Ѵ�
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		File f1 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����_SKT_2.txt");
		File f2 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����_KT_2.txt");
		File f3 = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�"
				+ "\\���������������ǥ�ص�����_LGU_2.txt");

		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));
		
		String readtxt;
		
		if((readtxt=br.readLine())==null) { //�ʵ�� �б�
			System.out.printf("�� �����Դϴ�\n");
			return;
		}
		
		//ù��(�ʵ��)�� ��� ���Ͽ� �� ����.
		bw1.write(readtxt); bw1.newLine();
		bw2.write(readtxt); bw2.newLine();
		bw3.write(readtxt); bw3.newLine();
		
//		String[] field_name =readtxt.split(","); //ù���б�=�ʵ��
												//��������� \n�������� �ϱ� ������
		
		int LineCnt=0;
		while((readtxt= br.readLine()) != null) {
			
			String[] field = readtxt.split("\t");//������ ���� �и� �迭����
			String detect = field[5].trim().toUpperCase(); // ��Ż� ����� ����//upper�� �ҹ��� ó��
			StringBuffer s = new StringBuffer(); //�������� ���� ����
			
			for (int i=0 ; i <=4 ; i++) s.append(field[i]+"\t"); //�ʵ�4���� ������
			
			
			if(detect.contains("SK") || detect.contains("�ڷ���")) { //��Ż簡 SKT�� ����
				
				field[5] = field[5].replace(field[5], "SKT"); //field[5]�� "SKT"�� �ٲٱ�
				s.append(field[5]+"\t");//�ʵ�5 ������
				for (int k =6 ; k < field.length ; k++) s.append(field[k]+"\t");//������ ������
				
				bw1.write(s.toString());//��Ʈ������ �����ָ� �ȿ� ��Ʈ�� �־ ���а� ��
				bw1.newLine();
				
			}else if(detect.contains("KT") || detect.contains("����Ƽ")) { 
				
				if(detect != "��KTI") { //�̸��� kt�� ���� ������ Ÿ��� ����
					field[5] = field[5].replace(field[5], "KT"); 
					s.append(field[5]+"\t");//�ʵ� 5 ����
					for (int k =6 ; k < field.length ; k++) s.append(field[k]+"\t"); 
					//�ʵ� 6���� ������ ����
					
					bw2.write(s.toString());
					bw2.newLine();
				}
				
			}else if(detect.contains("LG") || detect.contains("����")) { 
				
				field[5] = field[5].replace(field[5], "LGU+"); 
				s.append(field[5]+"\t");
				for (int k =6 ; k < field.length ; k++) s.append(field[k]+"\t");
				
				bw3.write(s.toString());
				bw3.newLine();
				
			}else {
				System.out.printf("�˼� ���� ��Ż� [%d��° �׸�][%s]***\n", LineCnt, field[5]);
			}
			
			LineCnt++;
		}
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();
	}

}



















