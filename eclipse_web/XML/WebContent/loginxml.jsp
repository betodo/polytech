<?xml version="1.0" encoding="UTF-8"?>

<%@ page contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*,java.net.*"%>

<%
	//로그인 체크
	String thisPage = "loginxml.jsp";
	String login_url = "login.jsp?rtn_url=" + thisPage;

	String loginVal = (String) session.getAttribute("loginOK");
	if (loginVal == null || !loginVal.equals("YES"))
		response.sendRedirect(login_url); //로그인 필요하면 로그인 페이지로 보냄
%>

<%
	//로그인 통과되면 xml파일 만든다
	String ip = "jdbc:mysql://192.168.56.102";
	String port = ":3306/";
	String dbname = "song?useSSL=false";
	String dbID = "root";
	String dbPW = "1234";

	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection(ip + port + dbname, dbID, dbPW);
	Statement stmt = conn.createStatement();
	
	ResultSet rset = stmt.executeQuery("select * from examtable;");
	
	out.print("<datas>");
	while(rset.next()) {	
		out.print("<data>");
		out.print("<name>"+rset.getString(1)+"</name>");
		out.print("<studentid>"+Integer.toString(rset.getInt(2))+"</studentid>");
		out.print("<kor>"+Integer.toString(rset.getInt(3))+"</kor>");
		out.print("<eng>"+Integer.toString(rset.getInt(4))+"</eng>");
		out.print("<mat>"+Integer.toString(rset.getInt(5))+"</mat>");
		out.print("</data>");
		
	}
	out.print("</datas>");
	stmt.close();
	conn.close();
	
%>

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->

<!-- </body> -->
<!-- </html> -->