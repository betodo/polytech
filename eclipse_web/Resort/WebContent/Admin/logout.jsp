<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.sql.*, java.net.*,java.io.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		session.invalidate();
	%>
	<!-- 	<h2>로그아웃 되었습니다.</h2> -->
	<!-- 	<!-- 로그아웃후 일반적으로는 홈으로 간다.(여기서는 login_test.jsp) -->
	
	<!-- 	<input type="button" value="메인페이지" onclick="location.href='login_test.jsp'"> -->

	<script>
		alert("로그아웃 되었습니다.");
		window.location.href="http://localhost:8090/Resort/index.jsp?contentPage=main.jsp";
		
	</script>
<!-- out.print("<script>window.location.href='../index.jsp?bln_login=1'</script>"); -->
</body>
</html>

<!-- 전체 흐름
1. 로긴테스트로 최초 접속(보통 메인 페이지)
세션 ok값을 받아야 하는데 처음엔 없으니까 로그인 페이지로 뜀
2.로그인으로 와서 아이디와 비밀번호를 입력
입력한 아디와 비번을 로그인체크로 보냄
3. 로그인체크에서 받은 비번과 아이디를 판별하여 boolean 로그인ok값을 판별
체크가 끝나면 세션을 기록하고 점프함 어디로? 메인페이지인 로긴테스트로
4. 로긴테스트는 이제 세션값이 있기 때문에 로그인 페이지로 뛰지 않고 로그인 오케이를 띄어줌-->