<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//contentType="application/json;" 처음에서 
//아작스 요청을 받아 응답하는 서버 페이지

//아작스가 보낸 name이란 data를 받음
String name = request.getParameter("name");//앞에서 네임을 받음
System.out.println(name);//확인

//아작스가 보낸 data에 따라 동작이 바뀜
if("홍길동".equals(name)){//name이 널일수도 있으니까 뒤로 뺌 홍길동이 앞이면 널포인트 에러는 안날꺼 아냐 tip
	
	//json을 만들어서 뿌려준다. (요걸 배열로 한데 AllviewDB1.jsp임)
	String output = "{\"title\": \"홍길동전\", \"html\": \"아버지를<br> 아버지라..\"}";
	
	out.print(output);
	
}else if("흥부".equals(name)){
	
	out.print("{\"title\": \"흥부전\", \"html\": \"흥부와 놀부는~\"}");
	
}

//out.print로 제이슨을 만듬 그럼 ajax_test가 다시 가져감

%>    
