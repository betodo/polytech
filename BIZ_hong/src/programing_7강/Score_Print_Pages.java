package programing_7��;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Score_Print_Pages {

		static ArrayList<OneRec2> ArrayOneRec2 =new ArrayList <OneRec2>();
		//��̸���Ʈ�� onerec2Ŭ������ �ְڴ�
		
		static int sumkor = 0;
		static int sumeng = 0;
		static int summat = 0;
		static int sumsum = 0;
		static int sumave = 0;
		
		static int page_sumkor = 0;
		static int page_sumeng = 0;
		static int page_summat = 0;
		static int page_sumsum = 0;
		static int page_sumave = 0;
			
		static final int iPerson = 100;//��ü �����
		static final int pagePer =30;//���������� ����� �����
		
		static int page_cnt =0;//������ ���� ������ ����� ��¿� �ʿ��� ����
		
		//�����͸����
		public static void dataSet() {
			for ( int i=0 ; i < iPerson ; i++) {
				String name = String.format("ȫ�浿%02d", i+1);//�̸������
				int kor = (int)(Math.random()*100); //�������� �����
				int eng = (int)(Math.random()*100); //�������� �����
				int mat = (int)(Math.random()*100); //�������� �����
				ArrayOneRec2.add(new OneRec2(i,name,kor,eng,mat));
				//�ϳ��� OneRec2Ŭ���� ������ ArrayList�� �������
			}	
		}
		
		//����μ�
		public static void HeaderPrint(int page) {
			System.out.println("                   ��������ǥ\n");
			Calendar calt = Calendar.getInstance();
			SimpleDateFormat sdf= new SimpleDateFormat("YYYY.MM.dd HH:mm:ss"); 
			System.out.printf("PAGE : %d               ������� : %s\n",page+1,sdf.format(calt.getTime()));
			System.out.println("======================================================");
			System.out.printf("%2s   %-4s     %2s   %2s   %2s     %2s     %2s\n",
					"��ȣ","�̸�","����","����","����","�հ�","���");
			System.out.println("======================================================");
		}
		
		//�����μ�
		public static void ItemPrint(int i) {
			OneRec2 rec; //Ŭ�����Ҿ�� rec�̶�� �ν��ͽ���
			rec=ArrayOneRec2.get(i);
		
			System.out.printf("%-3d   %-6.6s    %3d    %3d    %3d      %3d   %6.2f\n",
					rec.student_id()+1,rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.ave());
					//id�� 1������ ����ϱ� ����
			sumkor+=rec.kor();//������ 
			sumeng+=rec.eng();
			summat+=rec.mat();
			sumsum+=rec.sum();
			sumave+=rec.ave();
			
			page_sumkor+=rec.kor();//�������� ��µ� ��ŭ
			page_sumeng+=rec.eng();
			page_summat+=rec.mat();
			page_sumsum+=rec.sum();
			page_sumave+=rec.ave();
			
			page_cnt++;//ī��Ʈ �ø� //�������� ��µ� ����� ��ŭ ī��Ʈ ��
				
		}
		
		//�����μ�
		public static void TailPrint(int page) {
			//���������� ���
			System.out.println("======================================================");
			System.out.println("����������");
			System.out.printf("�հ�             %5d  %5d  %5d  %7d  %7d\n",
					page_sumkor,page_sumeng,page_summat,page_sumsum,page_sumave);
			System.out.printf("���            %6.2f  %5.2f  %5.2f  %7.2f  %7.2f\n",
					page_sumkor/(double)(pagePer),page_sumeng/(double)(pagePer),page_summat/(double)(pagePer),
					page_sumsum/(double)(pagePer),page_sumave/(double)(pagePer));
			
			//������������ ���� ���� ������  ���� �ʱ�ȭ
			page_sumkor=0;page_sumeng=0;page_summat=0;page_sumsum=0;page_sumave=0;
			
			
			//���������� ���
			System.out.println("======================================================");
			System.out.println("����������");
			System.out.printf("�հ�             %5d  %5d  %5d  %7d  %7d\n",sumkor,sumeng,summat,sumsum,sumave);
			System.out.printf("���            %6.2f  %5.2f  %5.2f  %7.2f  %7.2f\n",
					sumkor/(double)(pagePer*(page)+page_cnt),sumeng/(double)(pagePer*(page)+page_cnt),
					summat/(double)(pagePer*(page)+page_cnt),
					sumsum/(double)(pagePer*(page)+page_cnt),sumave/(double)(pagePer*(page)+page_cnt));
			System.out.println("\n");
			
			page_cnt=0;//�ʱ�ȭ//pagePer��ŭ ���̸� ���� �����ָ� �ǰ� ������ ���� ��ŭ �����༭ 
						//������ ����� �����ϰ� ��
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dataSet();//�����͸���� ����
		
		//�������� �ݺ� 30�� �μ�
		
		for (int page =0; page < ArrayOneRec2.size()/pagePer+1; page++ ) {
			if (page > ArrayOneRec2.size()/pagePer -1 
					&& ArrayOneRec2.size()%pagePer == 0) break;
			//�ܼ��� ������ ���������� �ꐞ�̸� �ƹ��͵� ������
			//����������� �� ���ư� �� �ؿ� ����� ���� ���� �߰�
			HeaderPrint(page);//����μ�
			for(int i=0+(page*pagePer) ; i < (page+1)*pagePer ; i++) {
				if (i > ArrayOneRec2.size()-1) break; 
				//������� 90 �̻��϶� �� ���� �����
				//�������� ó���� ���� ����
				
				ItemPrint(i);//�����μ�
				
			}
			TailPrint(page);//�����μ�
		}	
		
	}

}

