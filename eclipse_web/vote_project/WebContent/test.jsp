<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	test
	
	<%
	connectDB cdb = new connectDB();
	Statement stmt = cdb.useDB();
	
	String QueryTxt;
	QueryTxt = "select * from candidate;";
	
	ResultSet rset = stmt.executeQuery(QueryTxt);
	
	while (rset.next()) {
		out.print(rset.getString(1)+", ");
		out.print(rset.getString(2)+", ");
		//out.println(rset.getString(3));

	}
	
	 rset.close();
     stmt.close();
     cdb.close();

	%>
	
</body>
</html>