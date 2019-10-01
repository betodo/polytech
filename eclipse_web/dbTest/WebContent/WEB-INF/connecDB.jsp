<meta http-equiv="Content-Type"  content="text/html;charset=utf-8"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.io.*" %>
<%@ page import="dbTest.DBconnect" %>
<%

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
%>
	
	
	