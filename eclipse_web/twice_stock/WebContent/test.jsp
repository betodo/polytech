<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,twice_stock_pac.UseDB,java.io.*"%>   
<%@page import="java.util.Enumeration"%>
<%@page import="javax.servlet.ServletContext" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="javax.servlet.ServletContext"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//1과 2는 같은 경로 현재 서버옵션에서 퍼블리싱 기능 해제 햇기 때문에 톰캣 경로로 안감
	String uploadPath1 = request.getRealPath("upload_imgs"); 
	String uploadPath2 = application.getRealPath("upload_imgs");
	String uploadPath3 = application.getRealPath("/");
	String uploadPath4 = request.getRealPath("/"); // upload_imgs는 폴더명
	String uploadPath5 = application.getContextPath(); // upload_imgs는 폴더명
	
	//String uploadPath = "C:\\Users\\admin\\eclipse_web\\twice_stock\\WebContent\\upload_imgs";
	out.print(uploadPath1);
	out.print("<br>");
	out.print(uploadPath2);
	out.print("<br>");
	out.print(uploadPath3);
	out.print("<br>");
	out.print(uploadPath4);
	out.print("<br>");
	out.print(uploadPath5);
	
	UseDB udb = new UseDB();
	
	ResultSet rset = udb.selectOneTw_stock(1);
	
%>
</body>
</html>