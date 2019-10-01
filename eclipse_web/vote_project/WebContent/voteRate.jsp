<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개표결과</title>
	<style>
		div {
			display: inline-block;
		}
	</style>
	<%! int totalVoter =0; //득표율을 구하기 위한 총 투표자수
		double voteRate =0; //득표율
		int voteCnt =0; //득표수
	%>
	<%
		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		String QueryTxt;
		
		//총 투표자수 구하기
		QueryTxt = "select num from ballot;";
		ResultSet rset = stmt.executeQuery(QueryTxt);
		rset.last();
		totalVoter=rset.getRow();
		
		//득표수구하기(쿼리문으로 사용)
		QueryTxt =("SELECT c.id, c.name, b.vote_id, COUNT(*)"
				 +" FROM candidate c left join ballot b" 
				 +" on c.id = b.vote_id GROUP BY c.id;");
		
		rset = stmt.executeQuery(QueryTxt);
	%>
	<% %>
</head>
<body>
<h3 style="margin-left: 2em">후보별 득표율</h3>
	<table>
		<% while(rset.next()) {
			if(rset.getInt(3) !=0) voteCnt = rset.getInt(4); 
			voteRate = Math.round(((voteCnt/(double)totalVoter)*100)*100)/100.0; //후보자 한명의 득표율 계산
		%>
		<tr>
			<td>
				<a href="?contentPage=voteAge.jsp?toId=<%=rset.getInt(3)%>">기호 <%=rset.getInt(1) %>번 <%=rset.getString(2) %></a>
			</td>
			<td>
				<!-- 디브 100안에 디브를 득표율 만큼 빨간색으로 그려서 그래프 그림 -->
				<div style="width:100vh ;height:1em"><div style="width:<%=voteRate %>vh ;height:1em ;background-color: #ff0000"></div><span><%=voteCnt %>표 (<%=voteRate %>%)</span></div>
			</td>
		</tr>
		<% 
		voteCnt = 0;
		}
		%>
	</table>
	<%
		rset.close();
	    stmt.close();
	    cdb.close();
	%>
</body>
</html>