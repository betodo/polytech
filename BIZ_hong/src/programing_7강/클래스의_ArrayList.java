package programing_7��;

import java.util.ArrayList;

public class Ŭ������_ArrayList {

		static ArrayList<OneRec2> ArrayOneRec2 =new ArrayList <OneRec2>();
		//��̸���Ʈ�� onerec2Ŭ������ �ְڴ�
		
		static int sumkor = 0;//�������� //������
		static int sumeng = 0;
		static int summat = 0;
		static int sumsum = 0;
		static int sumave = 0;
		static final int iPerson = 20;
		
		//�����͸����
		public static void dataSet() {
			for ( int i=0 ; i < iPerson ; i++) {
				String name = String.format("ȫ�浿%02d", i);//�̸������
				int kor = (int)(Math.random()*100); //�������� �����
				int eng = (int)(Math.random()*100); //�������� �����
				int mat = (int)(Math.random()*100); //�������� �����
				ArrayOneRec2.add(new OneRec2(i,name,kor,eng,mat));
				//�ϳ��� OneRec2Ŭ���� ������ ArrayList�� �������
			}	
		}
		
		//����μ�
		public static void HeaderPrint() {
			System.out.println("*********************************************");
			System.out.printf("%2s  %4s  %2s  %2s  %2s  %2s   %2s\n","��ȣ",
					"�̸�","����","����","����","�հ�","���");
			System.out.println("*********************************************");
		}
		
		//�����μ�
		public static void ItemPrint(int i) {
			OneRec2 rec; //Ŭ�����Ҿ�� rec�̶�� �ν��ͽ���
			rec=ArrayOneRec2.get(i);//rec�� arrayonerec2.get�ż��� ��� ����
		
			System.out.printf("%4d  %4s  %3d  %3d  %3d    %3d  %6.2f\n",
					rec.student_id(),rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.ave());
					//rec.Ŭ������ name���� �޼��� �����ؼ� ���
			sumkor+=rec.kor();
			sumeng+=rec.eng();
			summat+=rec.mat();
			sumsum+=rec.sum();
			sumave+=rec.ave();
		}
		
		//�����μ�
		public static void TailPrint() {//������ ���ư��� ���� �հ� ������ 
			System.out.println("*********************************************");
			System.out.printf("�����հ� %d   ������� : %6.2f\n",sumkor,sumkor/(double)ArrayOneRec2.size());
			System.out.printf("�����հ� %d   ������� : %6.2f\n",sumeng,sumeng/(double)ArrayOneRec2.size());
			System.out.printf("�����հ� %d   ������� : %6.2f\n",summat,summat/(double)ArrayOneRec2.size());
			System.out.println("*********************************************");
			System.out.printf("������հ� %d   ����� : %6.2f\n",sumave,sumave/(double)ArrayOneRec2.size());
		}	//�������� ��ü ������� ��
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dataSet();//�����͸���� ����
		HeaderPrint();
		for(int i=0 ; i < ArrayOneRec2.size() ; i++) { //�������=�����
			ItemPrint(i);
		}
		TailPrint();//�����μ�
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
