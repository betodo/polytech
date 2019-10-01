<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Gongji,java.io.*, java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<bodY>
	<%
		//다른 브라우저로 실행하면 다른 세션 브라우저 마다 다른 세션값 가짐	
		//브라우저내 다른 탭은 같은 값 서버에 값이 있기 때문
		
		
		//세션 생성
		//session.setAttribute("session_id", "park");
		
		//세션 가져오기
		String id = "";
		id = (String)session.getAttribute("session_id");
		
		out.print(id);
		
		//세션 지우기
// 		session.invalidate();
// 		out.print("세션 지우기 완료");


		//세션 옵션 설정하기
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd [hh:mm:ss]");
		long createTime = (long)session.getCreationTime(); //세션 생성시간
		long lastTime = (long)session.getLastAccessedTime(); //마지막 처리 시간
		

	%>

세션 생성 시간 == <%=sdf.format(new Date(createTime)) %> <br>
세션 마지막 처리시간 시간 == <%=sdf.format(new Date(lastTime)) %> <br>
세션 유지 시간 == <%=(int)session.getMaxInactiveInterval() %> <br>
세션 유지 시간 변경 == <% session.setMaxInactiveInterval(1800); %> <br>
세션 값 표시 ==<%=(String)session.getAttribute("session_id") %> <br>
세션 ID == <%=session.getId() %> <br>
세션 유지 시간 == <%=(int)session.getMaxInactiveInterval() %> <br>

</bodY>
</html>