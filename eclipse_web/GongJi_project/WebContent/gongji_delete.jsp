<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제 동작 페이지</title>
</head>
<body>
	<%	
		//db연결
		UseDB udb = new UseDB();
		
		//삭제할 데이터의 키값인 id받음
		String idTemp = request.getParameter("id");
		int id = Integer.parseInt(idTemp);
		
		//삭제 메서드 실행
		udb.deleteGongji(id);
	%>
	<h4 align="center">삭제완료</h4><br>
	<div align="center">
		<form method="post"><input type="submit" value=뒤로 id=cancle formaction="?contentPage=gongji_list.jsp"></form>
	</div>
</body>
</html>