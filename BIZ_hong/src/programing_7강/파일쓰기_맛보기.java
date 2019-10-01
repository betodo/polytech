package programing_7강;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class 파일쓰기_맛보기 {
	
	//파일->파일리더/라이터->버퍼드리더/라이터
	//시스템인 ->인풋스트림리더->버퍼드리더
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		FileWriter fw = new FileWriter("C:\\Users\\admin\\Desktop\\a.txt",true);
		//저장하고자 하는 파일이름(필요한 경로도 써야함,트루는 중복시 덮어쓰기 유무
		
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sf = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//버퍼읽는 클래스 br사용 인풋스트림읽기로 읽은애 읽겠다
		
		String str ="";
		while(!(str = br.readLine()).startsWith("s"));
			sf.append(str+"\n"); //스트링버퍼에 한줄씩 읽어 기록한다.
								 //엔터치면 기록
								//s로 시작하는 아무단어 치면 저장
			
		br.close(); //자원해제 (br닫기)
		fw.write(sf.toString()); //스트링버퍼를 스트링형으로 변환하여 기록
		fw.flush();
		fw.close();
		System.out.println("저장이 완료되었습니다.");
		
		//처음 실행하면 지정경로에 파일 생성됨
		//콘솔창에 한줄씩 입력하고(엔터)
		//s로 시작하는 아무거나 입력하면 저장이 완료되었습니다. 뜸
		//파일가보면 리더리로 읽을게 저장됨(덮어씀)
	}

}
