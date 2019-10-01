<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Reserve,java.io.*"%>

<%
		UseDB_Reserve udbR = new UseDB_Reserve();
	try{
	
		String rsv_date = request.getParameter("date");
		int room = Integer.parseInt(request.getParameter("room"));
		
		udbR.deleteRsv(rsv_date, room);
		
		out.print("<script>alert(\"삭제되었습니다.\");"
				+"window.location.href='?contentPage=Admin/adm_allview.jsp'</script>");
	}catch(Exception e){
		out.print(e);
		out.print("<script>alert(\"삭제실패\");"
				+"window.location.href='?contentPage=Admin/adm_allview.jsp'</script>");
	}
	udbR.close();
%>
























