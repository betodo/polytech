<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>
<%@ page import="javax.xml.parsers.*,org.w3c.dom.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wifi조회</title>
</head>
<body>
	<h1>wifi 조회</h1>

	<%
		//파싱을 위한 준비과정
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		//당연히 파일을 읽을때 서버내부 local path(전체경로) 로 지정 ..이 문장이 xml파싱을 한다. 
		//단 위에 xml관련 import를 주의하라

		String path = request.getRealPath("/wifi.xml");
		//out.print(path);

		Document doc = docBuilder.parse(new File(path));

		Element root = doc.getDocumentElement(); //root태그를 가져오기도 하지난 이소스에서는 쓰이는 곳 없음

		NodeList tag_addr = doc.getElementsByTagName("소재지지번주소");
		NodeList tag_lat = doc.getElementsByTagName("위도");
		NodeList tag_lng = doc.getElementsByTagName("경도");
	%>
	<table cellespacing=1 width=400 border=1>
		<tr>
			<td width=100>순번</td>
			<td width=100>소재지지번주소</td>
			<td width=100>위도</td>
			<td width=100>경도</td>
		</tr>
		<%
			int lineCnt = 0;
			for (int i = 0; i < tag_addr.getLength(); i++) {
				out.print("<tr>");
				//아래와 같은 형식으로 불러온다
				out.print("<td width=100>" + lineCnt + "</td>");
				out.print("<td width=100>" + tag_addr.item(i).getFirstChild().getNodeValue() + "</td>");
				out.print("<td width=100>" + tag_lat.item(i).getFirstChild().getNodeValue() + "</td>");
				out.print("<td width=100>" + tag_lng.item(i).getFirstChild().getNodeValue() + "</td>");
				
				out.print("</tr>");
				lineCnt++;
			}
		%>
	</table>
</body>
</html>