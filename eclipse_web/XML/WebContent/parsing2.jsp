<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
<title>Insert title here</title>
<%!// 함수 정의 1) getThreadSafeClient() : 마치 브라우져로 조회하여 세션이 유지되는 효과를 얻음
	// 함수 정의 2) goXML(String getURL) : 해당 유알엘 주소를 입력하여 xml파일을 리턴 받는 함수

	DefaultHttpClient client;//일단 텅빈고객선언

	// 	HttpClient 재사용 관련 서버 통신시 세션을 유지하기 위함...HttpClient 4.5.2->https://hc.apache.org/downloads.cqi 

	public DefaultHttpClient getThreadSafeClient() { //텅빈고객을 쓰레드로 처리하자

		if (client != null) //고객이 있으면
			return client; //그 고객을 내뱉음

		//고객이 없으면
		client = new DefaultHttpClient(); //고객은 새로운 고객이고
		ClientConnectionManager mgr = client.getConnectionManager();//클라이언트 커넥션 메니저를 통해 새 고객과 커낵션을 맺는다
		HttpParams params = client.getParams(); //params는 고객의 요청을 받는 일을 하는 애 고객은 파람스를 얻으므로써 서버에 요청을 할 수 있다
		//이제 새로운 고객은 TheadSafeConnManager를 통해rparams와 커넥션을 가진 완전한 고객이 됨
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

		//if false니까 죽은 코드임
		if (false) { //여기가 파라메터 전달하는 곳(로그인을 했을때 여기서 처리를 한다는 것을 보여주는  학습용 소스)
			nameValuePair.add(new BasicNameValuePair("input1", "kopo11"));//지금은 로그인 처리 안하닌까 안쓰임
		}

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
	
	
%>
</head>

<body>
	<h1>성적 조회</h1>
	<%
	
	///파싱///
	String ret = goXML("http://192.168.23.96:8090/XML/xmlmake.jsp");//xml파일 결과 받기
	out.print(ret);	

	//파일 대신 xml호출로 처리
	
	try{
		
		//DocumentBuilderFactory 객체생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder 객체생성
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		ByteArrayInputStream is = new ByteArrayInputStream(ret.getBytes("utf-8"));//바이트로 읽는 인풋 스트림 이용
		//builder를 이용하여 xml 파싱 -> Document객체 생성
		Document doc = builder.parse(is);
		
		//생성된 document에서 삭 요소들을 접근하여 데이터를 저장함
		Element root  = doc.getDocumentElement(); //root태그를 가져오기도 하지난 이소스에서는 쓰이는 곳 없음
	
		NodeList tag_name = doc.getElementsByTagName("name"); //xml의 name tag
		NodeList tag_studentid = doc.getElementsByTagName("studentid"); //xml의 tag_studentid tag
		NodeList tag_kor = doc.getElementsByTagName("kor"); //xml의 name tag
		NodeList tag_eng = doc.getElementsByTagName("eng"); //xml의 name tag
		NodeList tag_mat = doc.getElementsByTagName("mat"); //xml의 name tag
		
		out.print("<table cellespacing=1 width=500 border=1>");
		out.print("<tr>");
		out.print("<td width=100>이름</td>");
		out.print("<td width=100>학번</td>");
		out.print("<td width=100>국어</td>");
		out.print("<td width=100>영어</td>");
		out.print("<td width=100>수학</td>");
		out.print("</tr>");
		
		for(int i=0; i<tag_name.getLength(); i++){
			out.print("<tr>");
			//아래와 같은 형식으로 불러온다
			out.print("<td width=100>"+tag_name.item(i).getFirstChild().getNodeValue()+"</td>");
			out.print("<td width=100>"+tag_studentid.item(i).getFirstChild().getNodeValue()+"</td>");
			out.print("<td width=100>"+tag_kor.item(i).getFirstChild().getNodeValue()+"</td>");
			out.print("<td width=100>"+tag_eng.item(i).getFirstChild().getNodeValue()+"</td>");
			out.print("<td width=100>"+tag_mat.item(i).getFirstChild().getNodeValue()+"</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
%>

</body>
</html>


















