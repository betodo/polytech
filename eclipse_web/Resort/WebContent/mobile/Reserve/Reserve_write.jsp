<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Reserve,java.io.*"%>

<%
	UseDB_Reserve udbR = new UseDB_Reserve();
	try {
		//값받기
		request.setCharacterEncoding("UTF-8"); //한글 안먹음 왜?
		
		String key = request.getParameter("key");
				
		String nameTemp = request.getParameter("name");
		String name = new String(nameTemp.getBytes("8859_1"), "utf-8");

		String rsv_date = request.getParameter("rsv_date");
		int room = Integer.parseInt(request.getParameter("room"));

		String addrTemp = request.getParameter("addr");
		String addr = new String(addrTemp.getBytes("8859_1"), "utf-8");

		String phone_num = request.getParameter("phone_num");

		String deposit_nameTemp = request.getParameter("deposit");
		String deposit_name = new String(deposit_nameTemp.getBytes("8859_1"), "utf-8");

		String rsv_commentTemp = request.getParameter("rsv_comment");
		String rsv_comment = new String(rsv_commentTemp.getBytes("8859_1"), "utf-8");

		//out.print(rsv_comment);
		//String write_date ="";//예약한 날짜 db시스템상 현재
		int processing = 1;

		//db에 작성
		udbR.insertReserve(name, rsv_date, room, addr, phone_num, deposit_name, rsv_comment, processing);
		//out.print("성공");
		if(key.equals("adm")){
			out.print("<script>alert(\"예약되었습니다.\");"
					+"window.location ='?contentPage=Admin/adm_allview.jsp'</script>");
		}else{
			out.print("<script>alert(\"예약되었습니다.\");"
					+"window.location ='?contentPage=Reserve/Reserve_list.jsp'</script>");
		}
			
	} catch (Exception e) {
		out.print(e);
%>
<script>
	alert("작성 실패");
	window.history.go(-1);
</script>
<%
	udbR.close();
	}
%>
























