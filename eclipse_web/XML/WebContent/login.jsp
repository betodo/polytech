<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.*,java.io.*,java.util.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<%
	//loginxml로 최초접속 로그인세션이 없으면 일로 옴
	//여기서 로그인 하고 세션만들고 넘어가서 xml파일 띄움
	
	//loginxml에서 값 받기 + 이 페이지에서 값받기
	String userName = request.getParameter("userName"); 
	String userPwd = request.getParameter("userPwd");
	String rtn_url = request.getParameter("rtn_url"); // 로그인 처리하고 다시 돌아갈때
	String loginCnt = request.getParameter("loginCnt");
	
	if(loginCnt == null) loginCnt = "0"; //처음 부분이니 선언과 비슷
	if(userName == null) userName = "";
	if(userPwd == null) userPwd = "";
	if(rtn_url == null) rtn_url = "";
	
	//로그인 되면
	if(userName.equals("kopo11") && userPwd.equals("1234")){ //login OK
		session.setAttribute("loginOK","YES");//세션기록
		response.sendRedirect(rtn_url); //다시 돌아감
	
	//횟수만 다시 늘려주고 다시 이 페이지 띄운다
	}else { //login Err
		loginCnt = Integer.toString(Integer.parseInt(loginCnt)+1);
	}
	
%>
</head>
<body>

	<form method="post" action="login.jsp">
	이름 : <input type="text" name="userName"><br>
	비밀번호 : <input type="text" name="userPwd"><br>
	<input type="hidden" name="loginCnt" value="<%=loginCnt %>"> 
	<input type="hidden" name="rtn_url" value="<%=rtn_url %>">
	<input type="submit" value="전송">
	</form>
	로그인 시도 횟수 : <%=loginCnt %><br>
	rtn_url : <%=rtn_url %>
</body>
</html>