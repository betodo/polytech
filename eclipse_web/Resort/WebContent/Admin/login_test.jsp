<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page import="javax.sql.*, java.net.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 테스트</title>
<%
	//현재 메인페이지라고 보면됨 여서부터 시작

	//세션을 체크해서 없다면 로그인 창으로 보낸다. 그리고 로그인이 되면 자기자신에게 와야하므로
	//자기자신의 url을 써줘야 한다. login_test.jsp

	String loginOK = null;
	//String jumpURL = "login.jsp?jump=login_test.jsp";
	String jumpURL = "login.jsp?jump=index.jsp";

	//세션의 키인 login_ok로 세션값을 받아옴
	//그게 널이면 로그인창으로 or 그 값이 yes가 아니면 로그인 창으로
	loginOK = (String) session.getAttribute("login_ok");

	if (loginOK == null) {
		response.sendRedirect(jumpURL);
		return;
	}
	if (!loginOK.equals("yes")) {
		response.sendRedirect(jumpURL);
		return;
	}
%>
</head>
<body>
	<h1>로그인 오케이</h1>
	<br>
	<a href="logout.jsp">로그아웃</a>
</body>
</html>