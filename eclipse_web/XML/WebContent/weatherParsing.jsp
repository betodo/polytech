<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>
<%@ page import="javax.xml.parsers.*,org.w3c.dom.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 정보 파싱</title>

<link href="weather.css" type="text/css" rel="stylesheet">

<%
	//변수선언
	String seq = ""; //시퀀스 (48시간중 몇번째인지)
	String hour = ""; //시각   (3시간 단위)
	
	String hour1="";//출력용시각
	int hour2=0;//낮밤비교용변수
	boolean night = true; //낮밤 판단변수 true=밤
	
	String day = ""; //날짜   (0:오늘 1:내일 2:모레)
	String temp = ""; //현재온도
	String tmx = ""; //최고온도
	String tmn = ""; //최저온도
	String sky = ""; //하늘상태   (1:맑음 2:구름조금 3:구름많음 4:흐림)
	String pty = ""; //강수상태   (0:없음 1:비 2:비/눈 3:눈/비 4:눈)
	String wfKor = ""; //날씨 한국어   (하늘상태+강수상태)
	String wfEn = ""; //날씨 영어
	String pop = ""; //강수확률 %
	String r12 = ""; //12시간 예상강수량
	String s12 = ""; //12시간 예상적설량
	String ws = ""; //풍속(m/s)
	String wd = ""; //풍향   (0-7:북, 북동, 동, 남동, 남, 남서, 서, 북서)
	String wdKor = ""; //풍향 한국어
	String wdEn = ""; //풍향 영어
	String reh = ""; //습도 %
	String r06 = ""; //6시간 예상강수량
	String s06 = ""; //6시간 예상적설량
%>

</head>
<body>
	<h1>날씨조회</h1>
	<table id="customers">
		<thead>
			<tr>
				<th>seq</th>
				<th>시각</th>
				<th>날짜</th>
				<th>현재온도(℃)</th>
				<th>최고온도</th>
				<th>최저온도</th>
				<th>하늘상태</th>
				<th>강수상태</th>
				<th>날씨 한국어</th>
				<th>날씨 영어</th>
				<th>강수확률(%)</th>
				<th>강수량(mm)</th>
				<th>적설량(mm)</th>
				<th>풍속(m/s)</th>
				<th>풍향</th>
				<th>풍향 한국어</th>
				<th>풍향 영어</th>
				<th>습도(%)</th>
				<th>6시간예상 강수량</th>
				<th>6시간예상 강수량</th>
			</tr>
		</thead>
		<tbody>
			<%
				//파싱을 위한 준비과정
				DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

				//xml 웹페이지를 파싱해서 doc에 넣는다
				Document doc = docBuilder.parse("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=123");

				Element root = doc.getDocumentElement();

				NodeList tag_001 = doc.getElementsByTagName("data"); //xml의 루트를 기준으로  data테그를 찾는다.

				for (int i = 0; i < tag_001.getLength(); i++) {
					// data 테그가 여러 개 있는데 하나를 선택(item(i)) 하여 어트리뷰트가 seq를 찾고 그것의 값을 찾는다
					// data seq=“0”, data seq=“1”등을 보고 결국 0,1,2,3 값이 나온다. 
					seq = tag_001.item(i).getAttributes().getNamedItem("seq").getNodeValue();
					//아래 hour테그는 전체 xml이 아니라 현재 data테그 하나를 기준으로 하위의  hour를 찾아 
					//그놈의 노드값을 보여준다
					Element elmt = (Element) tag_001.item(i);

					hour = elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue();
					day = elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue();
					temp = elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue();
					tmx = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
					tmn = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
					sky = elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue();
					pty = elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue();
					wfKor = elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue();
					wfEn = elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue();
					pop = elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue();
					r12 = elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue();
					s12 = elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue();
					ws = elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue();
					wd = elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue();
					wdKor = elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue();
					wdEn = elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue();
					reh = elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue();
					r06 = elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue();
					s06 = elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue();
					
					//데이터 변조(출력용)
					switch(day){  
						case "0": day = "오늘"; hour1 = day + hour + "시"; break;
						case "1": day = "내일"; hour1 = day + hour + "시"; break;
						case "2": day = "모레"; hour1 = day + hour + "시"; break;
					}
					
					if(tmx.equals("-999.0")) tmx=""; //최고온도
					if(tmn.equals("-999.0")) tmn=""; //최저온도
					
					//하늘상태   (1:맑음 2:구름조금 3:구름많음 4:흐림)
					//낮밤 판단
					hour2 = Integer.parseInt(hour);
					if(hour2 >= 18 && hour2 <= 6) night = true; 
					else night = false;
					
					if(night == false){
						switch(sky){  //상태에 따라 맞는 이미지를 넣어준다
							case "1": sky = "<img src=\"wheaterImg/맑음.png\">"; break;
							case "2": sky = "<img src=\"wheaterImg/구름조금낮.png\">"; break;
							case "3": sky = "<img src=\"wheaterImg/구름많음낮.png\">"; break;
							case "4": sky = "<img src=\"wheaterImg/흐림.png\">"; break;
						}
						
					}else{
						switch(sky){  
							case "1": sky = "<img src=\"wheaterImg/맑음밤.png\">"; break;
							case "2": sky = "<img src=\"wheaterImg/구름조금밤.png\">"; break;
							case "3": sky = "<img src=\"wheaterImg/구름많음밤.png\">"; break;
							case "4": sky = "<img src=\"wheaterImg/흐림.png\">"; break;
						}
					}
					
					
					//강수상태   (0:없음 1:비 2:비/눈 3:눈/비 4:눈)
					switch(pty){  
						case "0": pty = "없음"; break;
						case "1": pty = "<img src=\"wheaterImg/비.png\">"; break;
						case "2": pty = "<img src=\"wheaterImg/비눈.png\">"; break;
						case "3": pty = "<img src=\"wheaterImg/눈비.png\">"; break;
						case "4": pty = "<img src=\"wheaterImg/눈.png\">"; break;
					}
					
					//풍향   (0-7:북, 북동, 동, 남동, 남, 남서, 서, 북서)
					switch(wd){  
						case "0": wd = "↓"; break;
						case "1": wd = "↙"; break;
						case "2": wd = "←"; break;
						case "3": wd = "↖"; break;
						case "4": wd = "↑"; break;
						case "5": wd = "↗"; break;
						case "6": wd = "→"; break;
						case "7": wd = "↘"; break;
					}
					
					//풍속(m/s)
					ws = String.format("%.1f", Float.parseFloat(ws));
					
					
					
			%>
			<tr>
				<td><%=seq%></td>
				<td><%=hour1%></td>
				<td><%=day%></td>
				<td><%=temp%></td>
				<td style="color: red;"><%=tmx%></td>
				<td style="color: blue;"><%=tmn%></td>
				<td><%=sky%></td>
				<td><%=pty%></td>
				<td><%=wfKor%></td>
				<td><%=wfEn%></td>
				<td><%=pop%></td>
				<td><%=r12%></td>
				<td><%=s12%></td>
				<td><%=ws%></td>
				<td><%=wd%></td>
				<td><%=wdKor%></td>
				<td><%=wdEn%></td>
				<td style="color: green;"><%=reh%></td>
				<td><%=r06%></td>
				<td><%=s06%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
</html>