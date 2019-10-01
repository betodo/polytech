<?xml version="1.0" encoding="UTF-8"?>

<%@ page contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>

<%
	//db연결
	String ip = "jdbc:mysql://192.168.56.102";
	String port = ":3306/";
	String dbname = "song?useSSL=false";
	String dbID = "root";
	String dbPW = "1234";
	
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(ip + port + dbname, dbID, dbPW);
	
	Statement stmt = conn.createStatement();
	
	//데이터 불러옴
	ResultSet rset = stmt.executeQuery("select * from examtable;");
	
	//xml로 출력
	out.print("<datas>");
	while(rset.next()) {	
%>
		<data>
			<name><%=rset.getString(1)%></name>
			<studentid><%=Integer.toString(rset.getInt(2))%></studentid>
			<kor><%=Integer.toString(rset.getInt(3))%></kor>
			<eng><%=Integer.toString(rset.getInt(4))%></eng>
			<mat><%=Integer.toString(rset.getInt(5))%></mat>
		</data>
<%
	}
	out.print("</datas>");
	stmt.close();
	conn.close();
%>