package programing_7��;

public class �ѱ�_��� {

	// HanBlankForeword�ż��� = ������ ��ĭ
	public static String HanBlankForeword (String text, int num) {
		String returnText = "";//�ʱ�ȭ
		returnText = text;

		for (int i = 0; i < num - text.getBytes().length; i++) {//���ڸ���-�����ڸ���
			returnText = " " + returnText;//�ѱ۶����� getByte���
		}

		return returnText;}

	// HanBlankForeword�ż��� = �ڷ� ��ĭ
	public static String HanBlankBackword (String text, int num) {//num�� ���ڸ���
		String returnText = "";
		returnText = text;

		for (int i = 0; i < num - text.getBytes().length; i++) {
			returnText = returnText + " "; //������ ���ڸ������� text�� ����Ʈ�� 
		}								   //�� ���ڸ�ŭ ��ĭ�� ä��

		return returnText;}
	
	//�־��� ���ڿ��� �ѱۼ� ����
	public static int HanCount (String text) {
		int HanCount =0;
			HanCount = text.getBytes().length - text.length();
			//�� ���ڿ��� ����Ʈ�� ������ ���̴� �� �ѱ��� ���� 
			//�ѱ��� 1����Ʈ �� �����ѱ� 
		return HanCount;}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("HanBlankForewod[%s]\n", HanBlankForeword("�ѱ�abcd", 15));
		System.out.printf("HanBlankForewod[%s]\n", HanBlankForeword("�ѱ��ѱ�aa", 15));
		System.out.printf("HanBlankForewod[%s]\n", HanBlankBackword("�ѱ�aa", 15));
		System.out.printf("HanBlankForewod[%s]\n", HanBlankBackword("�ѱ��ѱ�aa", 15));
		System.out.printf("�ѱ��� [%d]��",HanCount("�ѱ��ѱ�aa"));
	}

}
