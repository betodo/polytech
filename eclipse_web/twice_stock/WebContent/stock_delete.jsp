<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,twice_stock_pac.UseDB,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stock_delete.jsp</title>
	<%	
		//db연결
		UseDB udb = new UseDB();
		
		//view.jsp에서 삭제할 데이터의 키값인 id받음
		String idTemp = request.getParameter("id");
		int id = Integer.parseInt(idTemp);
		
		//삭제 메서드 실행
		udb.deleteTw_stock(id);
		
		//삭제할 데이터의 이름도 받아온다 출력을 위해
		String nameTemp = request.getParameter("name");
		String name = new String(nameTemp.getBytes("8859_1"),"utf-8");
	%>
</head>
<body>
	<br>
	<h1>(주) 트와이스 재고 현황-상품삭제</h1>
	<br>
	<br>
	<br>
	<h3>[<%=name %>] 상품이 삭제되었습니다.</h3>
	<br>
	<br>
	<form action="?contentPage=stock_list.jsp">
		<input type="submit" value="목록" id=cancle>
	</form>
	<% udb.close(); %>
</body>
</html>