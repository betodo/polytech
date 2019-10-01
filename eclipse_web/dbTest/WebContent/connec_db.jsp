<meta http-equiv="Content-Type"  content="text/html;charset=utf-8"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.io.*" %>
<%@ page import="dbTest.DBconnect" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbtest</title>
</head>
<body>
<%

	try{
		DBconnect db= new DBconnect();
		Connection conn = db.connDB();
		Statement stmt = conn.createStatement();
		
		String QueryTxt;
		QueryTxt = ("select * from testDB;");
		
		ResultSet rset = stmt.executeQuery(QueryTxt);
		
		while (rset.next()) {
			out.print(rset.getString(1)+", ");
			out.print(rset.getString(2)+", ");
			out.println(rset.getString(3));

		}
		
		stmt.close();
		conn.close();

	} catch (SQLException e1) {
		out.print(e1);
	} catch (Exception e2) {
		out.print(e2);
	}
	
%>
</body></html>