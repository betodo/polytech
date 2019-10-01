package programing_7강;
//클래스의배열에 쓰임
public class OneRec {
	
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public OneRec(String name, int kor,int eng, int mat) {
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
	}
	
	public String name() {return this.name;};
	public int kor() {return this.kor;};
	public int eng() {return this.eng;};
	public int mat() {return this.mat;};
	public int sum() {return this.kor+this.eng+this.mat;};
	public double ave() {return this.sum()/3.0;};
}
