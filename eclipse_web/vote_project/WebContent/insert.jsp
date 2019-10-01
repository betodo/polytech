<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보 추가 jsp</title>
<!-- enroll.jsp에서 값을 받아와서 실제로 db에 추가하는 페이지 -->
	<%
		//값 받기
		String idTemp = request.getParameter("toInsertId");
		String nameTemp = request.getParameter("toInsertName");
		
		//받은 값 처리
		int id = Integer.parseInt(idTemp);
		String name = new String(nameTemp.getBytes("8859_1"),"utf-8");
		
		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		
		//db에서 데이터 삭제
		String QueryTxt;
		QueryTxt = String.format("insert into candidate (id, name)"
		+" values (%d,'%s');",id,name);
		stmt.execute(QueryTxt);
	%>

</head>
<body>
<h3 style="margin-left: 2em">후보가 추가 되었습니다.</h3>	
	<br>
	<form method="POST" action="?contentPage=enroll.jsp">
	<input type="submit" value="뒤로">
	</form>
	<%
	    stmt.close();
	    cdb.close();
	%>
</body>
</html>