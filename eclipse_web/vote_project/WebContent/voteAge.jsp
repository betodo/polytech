<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개표결과-성향분석</title>

 	<style>
		div {
			display: inline-block;
		}
	</style>
	
	<%
		int id =0;
		int totalVoter =0;//전체투표자
		//배열의 크기가 10인 이유는 i를 1부터 세면 편하기 때문
		//배열로 각 투표자의 득표율 득표수 저장
		double ageRate[] = new double[10];//각연령대 득표율 //초기화값=0
		int ageCnt[] =new int[10]; //각연령대 투표수
		
		//받아서 출력할 변수(후보이름)
		String name ="";
		
		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		String QueryTxt;
		//값받기
		String idTemp = request.getParameter("toId");
		id= Integer.parseInt(idTemp);
		
		//후보자 한명의 투표자 연령 조회 쿼리
		QueryTxt = "SELECT COUNT(vote_id) FROM ballot WHERE vote_id="+id+";";
		ResultSet rset = stmt.executeQuery(QueryTxt);
		rset.next();
	
		//전체 투표자
		totalVoter=rset.getInt(1);
		
		QueryTxt = "SELECT b.vote_id, b.age, COUNT(b.age),c.name"+ 
				" FROM ballot b JOIN candidate c ON b.vote_id = c.id"+
				" where vote_id="+id+" GROUP BY b.age;";
		
		rset = stmt.executeQuery(QueryTxt);
		

		while(rset.next()){ //투표자 한명의 득표율 구하기
			ageCnt[rset.getInt(2)] = rset.getInt(3);
			name = rset.getString(4);
			ageRate[rset.getInt(2)] = (rset.getInt(3)/(double)totalVoter)*100;
			ageRate[rset.getInt(2)] = Math.round(ageRate[rset.getInt(2)]*100)/100.0;//소수점 둘째 자리끊기
			
		}

	%>

</head>
<body>
<h3 style="margin-left: 2em">개표결과 성향분석</h3>	
<h2>기호 <%=id %>번 , <%=name %> 후보 득표성향 분석</h2>
	<table>
		<% for(int i=1; i<10; i++){ %>		
			<tr>
				<td><%=i %>0대</td>
				<td><div style="width:100vh ;height:1em"><div style="width:<%=ageRate[i]%>vh ;height:1em ;background-color: #ff0000"></div><span><%=ageCnt[i] %>표 (<%=ageRate[i] %>%)</span></div></td>
			</tr>
		<% } %>
	</table>
	<%
		rset.close();
	    stmt.close();
	    cdb.close();
	%>

</body>
</html>