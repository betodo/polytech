<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>
<%@ page import="javax.xml.parsers.*,org.w3c.dom.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보 파싱</title>
<script type="text/javascript">

</script>
</head>
<body>

	<%
		ArrayList<String> testlist = new ArrayList<String>();

		//파싱을 위한 준비과정
		DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		
		String url = "http://openapi.its.go.kr:8082/api/NEventIdentity?key=1498271446332&ReqType=2&MinX=127.100000&MaxX=128.890000&MinY=34.100000&MaxY=39.100000&type=its";
		//xml 웹페이지를 파싱해서 doc에 넣는다
		Document doc = docBuilder.parse(url);

		Element root = doc.getDocumentElement();
		
		NodeList tag_lng = doc.getElementsByTagName("coordx");
		NodeList tag_lat = doc.getElementsByTagName("coordy");
		
		int cnt = 0;
		for (int i = 0; i < tag_lat.getLength(); i++) {
			
			testlist.add(tag_lng.item(i).getFirstChild().getNodeValue()+","+tag_lat.item(i).getFirstChild().getNodeValue());
			cnt++;
			
		}
		
		out.print(cnt+"<br>");
		for(int i=0; i<testlist.size();i++){
			out.println("list[" + i + "] = " + testlist.get(i)+"<br>");
		}
		
// 		request.setAttribute("list", testlist);

	%>
	<input type="button" onclick='yyy()' value="버튼">
<!-- 	 onclick='submitForm("write")' -->
</body>
</html>