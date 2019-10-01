<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*" %>
<%@ page import="javax.xml.parsers.*,org.w3c.dom.*" %>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>성적조회</h1>
<%
	//파싱을 위한 준비과정
	//일단 xml문서를 만들기 위해 DocumentBuilder 사용 DocumentBuilderFactory.필요
	DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

	//당연히 파일을 읽을때 서버내부 local path(전체경로) 로 지정 ..이 문장이 xml파싱을 한다. 
	//단 위에 xml관련 import를 주의하라
	
	String path = request.getRealPath("/testdata.xml"); //절대경로를 알기 위해 realpath 사용
	//out.print(path);
	
	Document doc = docBuilder.parse(new File(path));
	
	Element root  = doc.getDocumentElement(); //root태그를 가져오기도 하지난 이소스에서는 쓰이는 곳 없음
	
	NodeList tag_name = doc.getElementsByTagName("name"); //xml의 name tag
	NodeList tag_studentid = doc.getElementsByTagName("studentid"); //xml의 tag_studentid tag
	NodeList tag_kor = doc.getElementsByTagName("kor"); //xml의 name tag
	NodeList tag_eng = doc.getElementsByTagName("eng"); //xml의 name tag
	NodeList tag_mat = doc.getElementsByTagName("mat"); //xml의 name tag
	
%>
	<table cellespacing=1 width=500 border=1>
		<tr>
			<td width=100>이름</td>
			<td width=100>학번</td>
			<td width=100>국어</td>
			<td width=100>영어</td>
			<td width=100>수학</td>
		</tr>
	
<%
	for(int i=0; i<tag_name.getLength(); i++){
		out.print("<tr>");
		//아래와 같은 형식으로 불러온다
		//몇번째 태그내임인지.거서 첫째아이의.값을 가져옴ㄴ
		out.print("<td width=100>"+tag_name.item(i).getFirstChild().getNodeValue()+"</td>");
		out.print("<td width=100>"+tag_studentid.item(i).getFirstChild().getNodeValue()+"</td>");
		out.print("<td width=100>"+tag_kor.item(i).getFirstChild().getNodeValue()+"</td>");
		out.print("<td width=100>"+tag_eng.item(i).getFirstChild().getNodeValue()+"</td>");
		out.print("<td width=100>"+tag_mat.item(i).getFirstChild().getNodeValue()+"</td>");
		out.print("</tr>");
	}
%>
	</table>
</body>
</html>



























