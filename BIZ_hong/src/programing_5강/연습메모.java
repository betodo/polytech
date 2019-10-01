package programing_5강;

public class 연습메모 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int iPrice = 220000;
		double taxRate = 10;
		int taxBase; 
		int tax;
		
		
		//과세,세금계산
		double x;
		x = (iPrice/(1+taxRate/100));
		if ((x*10)%10 >= 5) x = (int)x+1;
		
		taxBase = (int)x;
		tax = iPrice - taxBase;
				
		System.out.println(taxBase);
		System.out.println(tax);		
				
		/*
		 * if (iPrice/(100+taxRate)==(int)(iPrice/(100+taxRate))) { tax =
		 * (int)(iPrice/(100+taxRate)*taxRate); }else { tax =
		 * (int)(iPrice/(100+taxRate)*taxRate)+1; }
		 taxBase = iPrice - tax;
		*/
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
