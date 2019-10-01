import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//json은 key와 value 가 중괄호 { , } 안에서 표현되고,  대괄호 [ , ]  는 하나의 value 가 될 수 있다.
		//이 중괄호를 object 라고하며 대괄호는 array라고 한다.
		//json 문자열 예
		String str = "[{'NO':1,'NAME':'APPLE','KOR':'사과','PRICE':'1000'},{'NO':2,'NAME':'BANANA','KOR':'바나나','PRICE':'500'},{'NO':3,'NAME':'MELON','KOR':'메론','PRICE':'2000'}]";
		
		//파싱을위해 JsonParser 객체를 만들어준다.
		JsonParser jp = new JsonParser();
		
		//그 다음 JsonArray 를 선언하여 JsonParser 로 문자열을 파싱한다.
		//Array가 대괄호를 뜻하기에 [ ] 안의 데이터가 JsonArray에 담긴다. Array(대괄호)를 나누는 key가 없으므로 곧바로 JsonParser를 이용해 파싱한다.
		JsonArray jsonArray = (JsonArray) jp.parse(str);
		
		//루프를 돌면서 jsonArray 안의 object(중괄호) 를 빼내어 값을 추출한다.
		//(jsonArray의 크기는 Array(대괄호) 안의 object(중괄호) 수 이다.)
		for (int i = 0; i < jsonArray.size(); i++) {
			JsonObject object = (JsonObject) jsonArray.get(i);
			
			//object.get("태그") 로 object 안의 key를 찾아 해당하는 value를 리턴해준다.
			String NO = object.get("NO").getAsString();
			String NAME = object.get("NAME").getAsString();
			String KOR = object.get("KOR").getAsString();
			String PRICE = object.get("PRICE").getAsString();

			System.out.println(NO);
			System.out.println(NAME);
			System.out.println(KOR);
			System.out.println(PRICE);
			System.out.println();
		}
		
/////////////////////////////oject의 key가 있는 경우//////////////////////////////////
		
		str = "{'fruit':[{'NO':1,'NAME':'APPLE','KOR':'사과','PRICE':'1000'},"+
            "{'NO':2,'NAME':'BANANA','KOR':'바나나','PRICE':'500'},"+
            "{'NO':3,'NAME':'MELON','KOR':'메론','PRICE':'2000'}],"+
            "'animal':[{'NO':1,'NAME':'cat','KOR':'고양이','age':'3'},"+
            "{'NO':2,'NAME':'dog','KOR':'개','age':'5'},"+
            "{'NO':3,'NAME':'rabbit','KOR':'토끼','age':'2'}]}";
		
		//아까와 다르게 object에 key(fruit,animal)가 있기에 JsonParser 를 Object 로 먼저 파싱한다.
		//다음 array를 obect에서 key(fruit)를 get하여 해당하는 object를 array로 담는다
		
		JsonParser Parser = new JsonParser();
		JsonObject jsonObj = (JsonObject) Parser.parse(str);
		JsonArray memberArray = (JsonArray) jsonObj.get("fruit");
		
		//다음 array에서 object 를 해당하는 key로 value를 추출한다. 
		System.out.println("=========fruit=========");          
		for (int i = 0; i < memberArray.size(); i++) {          
			JsonObject object = (JsonObject) memberArray.get(i);
			System.out.println("번호 : " + object.get("NO"));     
			System.out.println("영어 : " + object.get("NAME").getAsString());//getAsString하면 따옴표 없애줌   
			System.out.println("한글 : " + object.get("KOR"));    
			System.out.println("가격 : " + object.get("PRICE"));  
			System.out.println("------------------------");     
		} 
		
		//루프가 끝났으면 다음 array에 object의 key(animal)를 넣어array를 만든 후 루프를돈다.
		memberArray = (JsonArray) jsonObj.get("animal");        
		System.out.println("=========animal=========");         
		for (int i = 0; i < memberArray.size(); i++) {          
			JsonObject object = (JsonObject) memberArray.get(i);
			System.out.println("번호 : " + object.get("NO"));     
			System.out.println("영어 : " + object.get("NAME"));   
			System.out.println("한글 : " + object.get("KOR"));    
			System.out.println("나이 : " + object.get("age"));    
			System.out.println("------------------------");     
		}


		
		
	}

}
