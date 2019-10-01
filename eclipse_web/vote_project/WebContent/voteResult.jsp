<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표결과</title>
	<%
		int voteId =0; // 입력하는 값1
		int age =0; //입력하는 값2
		
		//값 받기
		String voteIdTemp = request.getParameter("toVote");
		voteId = Integer.parseInt(voteIdTemp);
		
		//받은 값 처리
		String ageTemp = request.getParameter("toAge");
		age = Integer.parseInt(ageTemp);
	
		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		
		//db에 데이터 입력
		String QueryTxt;
		QueryTxt = String.format("insert into ballot (vote_id, age)"
		+" values (%d,%d);",voteId, age);
		stmt.execute(QueryTxt);
	%>

</head>
<body>
투표결과 : 투표하였습니다.
	<br>
	<form method="POST" action="?contentPage=vote.jsp">
	<input type="submit" value="뒤로">
	</form>
	<%
	    stmt.close();
	    cdb.close();
	%>
</body>
</html>