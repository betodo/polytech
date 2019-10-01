package programing_7강;
//클래스의 ArrayList에 쓰임
public class OneRec2 {
	
	private int student_id;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	//세터 역할
	public OneRec2(int student_id, String name, int kor, int eng, int mat) {
		this.student_id=student_id;
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.mat=mat;
	}
	
	//게터 역할
	public int student_id() {return this.student_id;};
	public String name() {return this.name;};
	public int kor() {return this.kor;};
	public int eng() {return this.eng;};
	public int mat() {return this.mat;};
	public int sum() {return this.kor+this.eng+this.mat;};
	public double ave() {return this.sum()/3.0;};
}
