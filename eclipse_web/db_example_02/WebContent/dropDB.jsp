<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.*,java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="mystyle.css" >
<title>Insert title here</title>
</head>
<body>
	<h3>테이블 삭제.</h3>
	<%
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://34.73.131.137:3306/kopo", "pjw", "1234");
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(
				"drop table examtable;");
		stmt.close();
		conn.close();
	} catch(Exception e) {
        out.println("테이블 드랍 중 에러발생.");
    }
	%>
	
</body>
</html>