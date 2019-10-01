<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="org.apache.http.HttpEntity"%>
<%@ page import="org.apache.http.HttpResponse"%>
<%@ page import="org.apache.http.NameValuePair"%>
<%@ page import="org.apache.http.ParseException"%>
<%@ page import="org.apache.http.client.HttpClient"%>
<%@ page import="org.apache.http.client.entity.UrlEncodedFormEntity"%>
<%@ page import="org.apache.http.client.methods.HttpGet"%>
<%@ page import="org.apache.http.client.methods.HttpPost"%>
<%@ page import="org.apache.http.impl.client.DefaultHttpClient"%>
<%@ page import="org.apache.http.message.BasicNameValuePair"%>
<%@ page import="org.apache.http.params.HttpConnectionParams"%>
<%@ page import="org.apache.http.util.EntityUtils"%>
<%@ page import="org.apache.http.conn.ClientConnectionManager"%>
<%@ page import="org.apache.http.params.HttpParams"%>
<%@ page
	import="org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager"%>
<!-- 아파치 임포트 *하면 안들어 오는게 있을수 있어서 다 써줌 -->
<%@ page import="java.io.*"%>
<%@ page
	import="java.text.*,java.util.*,java.sql.*,javax.servlet.*,javax.sql.*,javax.naming.*"%>
<%@ page import="javax.xml.parsers.*,org.w3c.dom.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교통, 도로공사 정보</title>
<%!// 함수 정의 1) getThreadSafeClient() : 마치 브라우져로 조회하여 세션이 유지되는 효과를 얻음
	// 함수 정의 2) goXML(String getURL) : 해당 유알엘 주소를 입력하여 xml파일을 리턴 받는 함수

	DefaultHttpClient client;//일단 텅빈고객선언

	// 	HttpClient 재사용 관련 서버 통신시 세션을 유지하기 위함...HttpClient 4.5.2->https://hc.apache.org/downloads.cqi 

	public DefaultHttpClient getThreadSafeClient() { //텅빈고객을 쓰레드로 처리하자

		if (client != null) //고객이 있으면
			return client; //그 고객을 내뱉음

		//고객이 없으면
		client = new DefaultHttpClient();
		ClientConnectionManager mgr = client.getConnectionManager();
		HttpParams params = client.getParams();

		client = new DefaultHttpClient(new ThreadSafeClientConnManager(params, mgr.getSchemeRegistry()), params);

		return client;//완전해진 새 고객을 내 뱉음

	}

	public String goXML(String getURL) { //xml파일(웹에 띄우기)

		String Result = null;//xml웹 접근 결과선언

		//세션유지 체크
		HttpClient client = getThreadSafeClient(); //고객정의 함수로 고객을 얻는다
		HttpConnectionParams.setConnectionTimeout(client.getParams(), 1000000);//고객이랑 얼마나 연결되 있을지 옵션설정
		HttpConnectionParams.setSoTimeout(client.getParams(), 1000000);
		HttpPost post = new HttpPost(getURL); //값을 전달하는 방식 정해줌 url얻어서 //역시 옵션 관련됨

		//http값전달 방식을 post로하면 namevaluefair란 리스트를 통해 전달
		List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

		// 		//if false니까 죽은 코드임
		// 		if (false) { //여기가 파라메터 전달하는 곳(로그인을 했을때 여기서 처리를 한다는 것을 보여주는  학습용 소스)
		// 			nameValuePair.add(new BasicNameValuePair("input1", "kopo11"));//지금은 로그인 처리 안하닌까 안쓰임
		// 		}

		try {
			//고객의 요청을 Entity에 담음
			post.setEntity(new UrlEncodedFormEntity(nameValuePair));
			HttpResponse responsePost = null;//http대답선언

			//서버의 응답을 저장(고객의 요청의 결과 )
			responsePost = client.execute(post);
			//http가 서버결과를 얻음
			HttpEntity resEntity = responsePost.getEntity();

			if (resEntity != null) { //서버결과가 있으면 결과를 스트링으로
				Result = EntityUtils.toString(resEntity).trim();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return Result;
	}

	///변수선언///
	//통제할 변수 선언
	String CoordType = ""; //좌표타입 @
	int DataCount = 0; //공사정보 개수 @
	double CoordX = 0; //경도좌표 @ //lng
	double CoordY = 0; //위도좌표 @ //lat

	String type = ""; //도로정보 (its : 국도 / ex : 고속도로 / police : 경찰청) @
	String EventId = ""; //공사 고유 식별번호 @
	//String EventType = ""; //공사정보유형 @ 유용한 정보 아님 0만나옴
	String LanesBlockType = ""; //공사로 인한 차로 차단 방법 @//0: 통제없음, 1: 갓길통제, 2: 차로 부분통제, 3: 전면통제, 4:우회통행. 5:양방향교차통행
	String LanesBlocked = "";//공사로 인해 차단된 차로 수 @
	String EventStartDay = "";//공사 시작일 @
	String EventEndDay = "";//공사 종료일 @
	String EventStartTime = ""; //공사 실제 개시 시간 @
	String EventEndTime = ""; //공사 실제 종료 시간 @
	String EventStatusMsg = ""; //공사 상황정보 메시지 @
	int ExpectedCnt = 0; //우회정보개수 @
	String ExpectedDetourMsg = ""; //우회정보 메시지 @
	String EventDirection = ""; //진행방향 
	
	%>
	
<link href="weather.css" type="text/css" rel="stylesheet"><!-- 테이블 스타일 -->
<style type="text/css">
	html, body {
		height: 100%;
		margin: 0;
		padding: 0;
	}
	#mid_head{
		text-align:center;
	}
	#map {
		margin-left:25%;
		height: 40%;
		width: 50%;	
	}
	#wrapTB{
		height:59%;
		overflow:auto;
	}
	span{
		margin-right:4%;
		margin-left:4%;
	}
</style>
</head>

<body>
	<%
		///파싱준비///
		//rul주소에 공백 있으면 url 신택스에러 뜬다
		String url = "http://openapi.its.go.kr:8082/api/NEventIdentity?key=1498271446332&ReqType=2&MinX=127.100000&MaxX=128.890000&MinY=34.100000&MaxY=39.100000&type=its";
		String ret = goXML(url);//xml파일 결과 받기
		//out.print(ret);

		//파싱준비
		//DocumentBuilderFactory 객체생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder 객체생성
		DocumentBuilder builder = factory.newDocumentBuilder();

		ByteArrayInputStream is = new ByteArrayInputStream(ret.getBytes("utf-8"));//바이트로 읽는 인풋 스트림 이용
		//builder를 이용하여 xml 파싱 -> Document객체 생성
		Document doc = builder.parse(is);

		Element root = doc.getDocumentElement();

	%>
	<h1 align="center">도로 공사 정보</h1>
	<!-- 지도 출력할 위치 -->
	<div id="map" align="center"></div>
	<br>
	<!-- 간단정보 -->
	<div id=mid_head><span>현재 공사 수 : <%=DataCount%>건</span><span><button onclick='initMap()'>전체지도보기</button></span></div>
	<br>
	<!-- 실제 전 정보 -->
	<div id=wrapTB>
	<table id="customers">
		<thead>
			<tr>
				<th>경도</th>
				<th>위도</th>
				<th>도로<br>정보</th>
				<th>공사<br>식별번호</th>
<!-- 				<th>공사 정보유형</th> -->
				<th>공사<br>시작일</th>
				<th>공사<br>종료일</th>
				<th>공사<br>개시시간</th>
				<th>공사<br>종료시간</th>
				<th>공사상황</th>
				<th>차단방법</th>
				<th>차단<br>차로수</th>
				<th>우회<br>정보수</th>
				<th>우회<br>정보</th>
				<th>진행방향</th>
				<th>지도보기</th>
			</tr>
		</thead>
		<tbody>
			<%
				//공사수 갖고 오기(xml문서에서 한개의 정보만 있다.)
				NodeList tag_datacount = doc.getElementsByTagName("datacount");
				DataCount = Integer.parseInt(tag_datacount.item(0).getFirstChild().getNodeValue());

				//각 data태그의 하위태그들을 뽑기위해 일단 data태그를 가져온다
				NodeList tag_001 = doc.getElementsByTagName("data");

				//차단차로수 계산하기위한 변수
				int LanesBlockedCnt = 0; //1000으로 나옴 그냥 간단하게 숫자로만 표현하려 함 그거 계산 위한 변수
				char c = '1';
			
				//맵크러스터에 여러값 던지기 위해 배열 선언
				StringBuilder sb = new StringBuilder(); 
				
				for (int i = 0; i < tag_001.getLength(); i++) {
					
					//각 data태그들 하나의 엘리먼트로 선언해서 하위 태그들 접근
					Element elmt = (Element) tag_001.item(i);

					//경도 위도 정보는 항상 있어어 트라이 캐치 안씀
					CoordX = Double.parseDouble(elmt.getElementsByTagName("coordx").item(0).getFirstChild().getNodeValue()); //xml의 name tag
					CoordY = Double.parseDouble(elmt.getElementsByTagName("coordy").item(0).getFirstChild().getNodeValue()); //xml의 tag_studentid tag

					try { type = elmt.getElementsByTagName("type").item(0).getFirstChild().getNodeValue(); 
					} catch (Exception e) {}
					try { EventId = elmt.getElementsByTagName("eventid").item(0).getFirstChild().getNodeValue(); 
					} catch (Exception e) {}
// 					try { EventType = elmt.getElementsByTagName("eventtype").item(0).getFirstChild().getNodeValue(); 
// 					} catch (Exception e) {}
					try { EventStartDay = elmt.getElementsByTagName("eventstartday").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { EventEndDay = elmt.getElementsByTagName("eventendday").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { EventStartTime = elmt.getElementsByTagName("eventstarttime").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { EventEndTime = elmt.getElementsByTagName("eventendtime").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { EventStatusMsg = elmt.getElementsByTagName("eventstatusmsg").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { LanesBlockType = elmt.getElementsByTagName("lanesblocktype").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { LanesBlocked = elmt.getElementsByTagName("lanesblocked").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { ExpectedCnt = Integer.parseInt(elmt.getElementsByTagName("expectedcnt").item(0).getFirstChild().getNodeValue());
					} catch (Exception e) {}
					try { ExpectedDetourMsg = elmt.getElementsByTagName("expecteddetourmsg").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					try { EventDirection = elmt.getElementsByTagName("eventdirection").item(0).getFirstChild().getNodeValue();
					} catch (Exception e) {}
					
					
					//출력용 데이터 처리
					//도로정보 (its : 국도 / ex : 고속도로 / police : 경찰청) @
					switch(type){  
					case "its" : type = "국도" ; break;
					case "ex" : type = "고속도로"; break;
					case "police" : type = "경찰청";  break;
					}
					//공사로 인한 차로 차단 방법 //( 0 : 통제없음 / 1 : 갓길통제/ 2 : 차로부분통제 / 3 : 전면통제 )
					switch(LanesBlockType){  
					case "0" : LanesBlockType = "통제없음" ; break;
					case "1" : LanesBlockType = "갓길통제"; break;
					case "2" : LanesBlockType = "차로부분통제";  break;
					case "3" : LanesBlockType = "전면통제";  break;
					}
					
					//차단 차선이 100000으로 1차선차단일 경우 1로 나옴 
					//컬럼명과 맞게 차단차선수로만 표시하기
					for(int k=0; k < LanesBlocked.length(); k++ ){
						if(LanesBlocked.charAt(k) == c ){
							LanesBlockedCnt++;
						}
					}
				
					//지도 마커 찍을 배열 만들기(스트링형으로 만들어서 자바스크립[]에 넣어줌)
					sb.append("{lat: "+CoordY+", lng: "+CoordX+"}");
					if( i != tag_001.getLength()-1){
						sb.append(",");
					}
					
						
			%>
			<!-- 실 데이터 출력 -->
			<tr>
				<td><%=Math.round(CoordX*10000000)/10000000.0%></td><!-- 소수점7자리까지만 -->
				<td><%=Math.round(CoordY*10000000)/10000000.0%></td>
				<td><%=type%></td>
				<td><%=EventId%></td>
<%-- 				<td><%=EventType%></td> --%>
				<td><%=EventStartDay%></td>
				<td><%=EventEndDay%></td>
				<td><%=EventStartTime%></td>
				<td><%=EventEndTime%></td>
				<td><%=EventStatusMsg%></td>
				<td><%=LanesBlockType%></td>
<%-- 				<td><%=LanesBlocked%></td> --%>
				<td><%=LanesBlockedCnt%></td>
				<td><%=ExpectedCnt%></td>
				<td><%=ExpectedDetourMsg%></td>
				<td><%=EventDirection%></td>
				<!-- 클릭시 지도가 뜰수 있도록 매개변수로 함수 호출 -->
				<td><button onclick='oneMarkerMap(<%=CoordY%>,<%=CoordX%>)'>지도보기</button></td>
<%-- 				<td><button onclick='initMap2(<%=CoordY%>,<%=CoordX%>)'>지도보기</button></td> --%>

			</tr>
			<%
					LanesBlockedCnt=0;//재사용(계산)을 위한 초기화
				}
			%>
	</table>
	</div>
	
<script>
	var lo = [<%=sb.toString()%>];    
	var zo = 7;                       
	var ce = {lat: 36.5, lng: 127.8}; 
	                                  
	function oneMarkerMap(latt, lngg){
		
		lo = [{lat: latt, lng: lngg}];
		zo = 12;
		ce = {lat: latt, lng: lngg};
		initMap();
		
	}
	

/* 마커하나짜리(공사1개) 구글맵api사용 */
// 	function initMap2(latt,lngg) {
	  
// 	  // The location of Uluru
// 	  var uluru = {lat: latt, lng: lngg};
// 	  // The map, centered at Uluru
// 	  var map = new google.maps.Map(
// 	      document.getElementById('map'), {zoom: 12, center: uluru});
// 	  // The marker, positioned at Uluru
// 	  var marker = new google.maps.Marker({position: uluru, map: map});
// 	}

/* 마커크러스터(공사여러개) */	
     function initMap() {
		var locations  = lo;
    	 //마커의 위치를 배열로 넣는다
       var map = new google.maps.Map(document.getElementById('map'), {
//          zoom: 7,
//          center: {lat: 36.5, lng: 127.8}
         zoom: zo,
         center: ce
       });

       // Create an array of alphabetical characters used to label the markers.
       var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';

       // Add some markers to the map.
       // Note: The code uses the JavaScript Array.prototype.map() method to
       // create an array of markers based on a given "locations" array.
       // The map() method here has nothing to do with the Google Maps API.
       var markers = locations.map(function(location, i) {
         return new google.maps.Marker({
           position: location,
           label: labels[i % labels.length]
         });
       });

       // Add a marker clusterer to manage the markers.
       var markerCluster = new MarkerClusterer(map, markers,
           {imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'});
     }
         
<%--      var locations  = [<%=sb.toString()%>]; //마커의 위치를 배열로 넣는다 --%>
    
</script>
    
<script
	src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js">
</script>
<script async defer
   src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAb73w2PJumWZ-xgrt3QAnXbSMGfumvmiM&callback=initMap">
</script>
    
</body>
</html>