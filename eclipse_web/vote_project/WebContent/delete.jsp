<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보삭제 jsp</title>
<!-- enroll.jsp에서 값을 받아와서 실제로 db에서 삭제하는 페이지 -->
	<%
		//값 받기
		String idTemp = request.getParameter("toDelId");
		int id = Integer.parseInt(idTemp);
		
		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		Statement stmt2 = cdb.useDB();
		//삭제
		String QueryTxt;
		//포린키 때문에 두개 삭제
		QueryTxt = String.format("delete from ballot WHERE vote_id=%d;",id);
		stmt2.execute(QueryTxt);
		QueryTxt = String.format("delete from candidate WHERE id=%d;",id);
		stmt.execute(QueryTxt);
	%>

</head>
<body>
<h3 style="margin-left: 2em">후보가 삭제 되었습니다.</h3>	
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