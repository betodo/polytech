package programing_7��;

import java.text.DecimalFormat;

public class �������̿���_�ʵ����� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] oneRec = {
				"01  ��������               3,780 100    378,000",
				"02  �ٳ�������            15,000   1     15,000",
				"03* ������                 2,980   2      5,960",
				"04  �������ֽ�             4,900   4     19,600",
				"05  ���ڿ���               1,000   1      1,000",
				"06* �ı�ġ                 2,530   3      7,590",
				"07  Ǯ����ġ��&ġ��        3,310   1      3,310",
				"08  ���ǹ���Ƽ             5,000   5     25,000",
				"09* �������              13,300   1     13,300",
				"10* ���̱�ġ             1,700   1      1,700",
				"11  ��Ƽ�� 100��             100   1        100",
				"12  �ȵ��նѲ�               990   7      6,930",
				"13* ��� 1kg               1,440   4      5,760",
				"14  �����۽� BBQ           4,250   2      8,500",
				"15  [��귻��]���� 2L      2,750   2      5,500",
				"16  �ø��� ¥�İ�Ƽ        9,800   8     78,400",
				"17  CJ �޹�                5,180   1      5,180",
				"18  ũ���ؽ� 3�� 3��         900   1        1,900",
				"19  ���Ѷ��� 1.5L          9,900   1      9,900",
				"20  [Ȩ��Ÿ]��Ǽ�����     9,800   2     19,600",
				"21  ���� ���ټ���          5,000   1      5,000",
				"22* ��õ�� 2kg             4,060   2      8,120",
				"23  �����ġ�ɾ� ġ��     10,130   1     10,130",
				"24  [��귣��]������3p     3,500   3     10,500",
				"25  ���尩              25,000   2     50,000",
				"26  �ＤǪ                   800   6      4,800",
				"27  [��귣��]����ȣ�� 3,120,000   9 28,080,111",
				"28  ������                   550   1        550",
				"29  [�Ƶ�ٽ�]���۽�Ÿ 1,234,560   5  6,172,800",
				"30* ���                     520   1        1,520"};
		
		//�ѷ��ڵ��� ��������
		//System.out.println(oneRec[0].length()); // =43
		//ystem.out.println(oneRec[0].getBytes().length); // =47
		//System.out.println(oneRec[29].getBytes().length); //=48
		
		//n~m��° ���� ����(��ȣ,�׸�,�ܰ�,����,����)
		String num,item,price,count,total;
		int int_price, int_count, int_total;
		int diff =0;
		
		for (int i=0 ; i < oneRec.length ; i++ ) {//�迭.length=�迭����
			//���� ����
			diff = oneRec[i].getBytes().length - oneRec[i].length();//�ѱ��� �����ϴ� ����Ʈ��
			num = oneRec[i].substring(0,2);
			item = oneRec[i].substring(4,23-diff); 
			//¥���� ���� ���̴� 23�ε� �ȿ� 
			//�ѱ��� ���־ �ѱ��� �� �����ϴ� ��ŭ�� ����
			price = oneRec[i].substring(23-diff,33-diff); //22 ���� 33���� �����ϰ� ������
			count = oneRec[i].substring(33-diff,36-diff);//�ѱ۶��� �߰��� ����Ʈ�� ����
			total = oneRec[i].substring(36-diff,oneRec[i].getBytes().length-diff);
			
			//���⹮�� �޸� ����
			price = price.replaceAll(",","");
			total = total.replaceAll(",","");
			
			//��������
			num = num.trim();//���������� �� Ʈ������
			item = item.trim();
			price = price.trim();
			count = count.trim();
			total = total.trim();
			
			//���ڿ�->���� for ���
			int_price = Integer.parseInt(price);
			int_count = Integer.parseInt(count);
			int_total = int_price * int_count; //���� ��갪
			
			
			//���
			DecimalFormat df = new DecimalFormat("###,###,###,###,###");
			
			if (Integer.parseInt(total) != int_total) { //�����Ϳ� ���� ��갪�� �ٸ���
				System.out.println("*******************************");
				//������ ���
				System.out.printf("%s[%s  %s","����",num,item); //���������� ���
				
				for ( int blank =0 ; blank < 20-item.getBytes().length; blank++) {//����� ���� ���� ����ֱ�
					System.out.printf("%s"," ");}//���鰹�� ���ڼ��� ������ ����
														  //���ڼ��� ������ �׸�ŭ ����
				
				System.out.printf("%10s%4s%15s]\n",df.format(int_price),df.format(int_count),
						df.format(Integer.parseInt(total))); //�������� ���
				//������ ���
				System.out.printf("%s[%s  %s","����",num,item);
				
				for ( int blank =0 ; blank < 20-item.getBytes().length; blank++) {
					System.out.printf("%s"," ");}
				
				System.out.printf("%10s%4s%15s]\n",df.format(int_price),df.format(int_count),
						df.format(int_total));
				System.out.println("*******************************");
			} 
		}
		

	}

}







