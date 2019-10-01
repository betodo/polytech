package programing_7��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ŬArrayList_Sort {

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
			System.out.printf("%2s  %4s  %2s  %2s  %2s  %2s   %2s\n","��ȣ","�̸�","����","����","����","�հ�","���");
			System.out.println("*********************************************");
		}
		
		//�����μ�
		public static void ItemPrint(int i) {
			OneRec2 rec; //Ŭ�����Ҿ�� rec�̶�� �ν��ͽ���
			rec=ArrayOneRec2.get(i);
		
			System.out.printf("%4d  %4s  %3d  %3d  %3d    %3d  %6.2f\n",
					rec.student_id(),rec.name(),rec.kor(),rec.eng(),rec.mat(),rec.sum(),rec.ave());
			
			sumkor+=rec.kor();
			sumeng+=rec.eng();
			summat+=rec.mat();
			sumsum+=rec.sum();
			sumave+=rec.ave();
		}
		
		//�����μ�
		public static void TailPrint() {
			System.out.println("*********************************************");
			System.out.printf("�����հ� %d   ������� : %6.2f\n",sumkor,sumkor/(double)ArrayOneRec2.size());
			System.out.printf("�����հ� %d   ������� : %6.2f\n",sumeng,sumeng/(double)ArrayOneRec2.size());
			System.out.printf("�����հ� %d   ������� : %6.2f\n",summat,summat/(double)ArrayOneRec2.size());
			System.out.println("*********************************************");
			System.out.printf("������հ� %d   ����� : %6.2f\n",sumave,sumave/(double)ArrayOneRec2.size());
		}
		
		//������ ��Ʈ
		public static void dataSort() {
			Comparator<OneRec2> bikyokijun = new Comparator<OneRec2>() {
			// Ŭ�������� ������ ArrayList�� ��Ʈ�� �ݷ��ǰ� ���۷����� Ŭ���� �̿��Ͽ� ��Ʈ
			// ���۷����� Ŭ���� ������ compare�޼ҵ� ������ �ʿ�(�����ε�) �񱳱��� ������
				public int compare(OneRec2 a1, OneRec2 a2) { //�� �� ���ڵ� ��
					return (a2.sum()-a1.sum()); //���� ������̸� ���� �� ��������
					//a2,a1 �ݴ�� ���ָ� ��������
				}
			};
			Collections.sort(ArrayOneRec2,bikyokijun);
			//������ ������ ����
			//Collections.reserve(ArrayOneRec2);//������(������)
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dataSet();//�����͸���� ����
		dataSort();// ������ ����
		HeaderPrint();
		for(int i=0 ; i < ArrayOneRec2.size() ; i++) {
			ItemPrint(i);
		}
		TailPrint();//�����μ�
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
