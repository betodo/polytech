package programing_8��;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;


public class �ǽ�3_�Ｚ����_�ִ��ּ��ְ� {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("C:\\Users\\admin\\Desktop\\��\\ȫ�ʵα��������Ͻǽ�" 
					+ "\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;
		int cnt = 0;
		int maxcnt = 0;
		int mincnt =0;
		int max =0;//���ʺ񱳰� ������ ������ 0����
		int min =999999999;//���ʺ񱳰��̶� ���� ũ��
		int chkNum;//�ִ��ּ� ���� ����
		
		while ((readtxt = br.readLine()) != null) {

			String[] field = readtxt.split("%_%");
			
			if (field.length > 2 //���� �ڵ带 ��� ������ ��ȿ���� ���� ����(������) ġ����
					&& field[2].replace("^", "").trim().equals("A005930")
					&& field[1].replace("^", "").trim().substring(0, 4).equals("2015")) {
				
				try { //������ �����̸� ���� = catch�� �� �Ѿ��
					chkNum = Integer.parseInt(field[86].replace("^", "").trim());
					
					if(chkNum != 0) { // ������ 0�� �ƴҶ��� ����
						if (max < chkNum){
							max = chkNum; maxcnt=cnt; //�ƽ��� ���ϱ�
						}
						if (min > chkNum) {
							min =chkNum; mincnt=cnt;//�ΰ� ���ϱ�
						}
					}	
					
				}catch (Exception e) {
					
				}
				// System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			cnt++;
		}
		br.close();
		System.out.printf("[%d��] 2015�� �������� �ְ� �ִ밪 : %d\n", maxcnt, max);
		System.out.printf("[%d��] 2015�� �������� �ְ� �ּҰ� : %d\n", mincnt, min);
	}

}
