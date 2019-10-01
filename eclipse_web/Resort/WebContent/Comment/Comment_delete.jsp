<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Comment,java.io.*"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%
	String filePath = request.getRealPath("Comment/upload/");
	MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
			request, filePath, // 파일을 저장할 디렉토리 지정
			1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
			"utf-8", // 인코딩 방식 지정
			new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
	);

	String idTemp = multi.getParameter("id");
	int id = Integer.parseInt(idTemp);

	int rootid = Integer.parseInt(multi.getParameter("rootid"));
	int relevel = Integer.parseInt(multi.getParameter("relevel"));
	int recnt = Integer.parseInt(multi.getParameter("recnt"));
	
	
	String ogFile1 = multi.getParameter("ogFile1");
	String ogFile2 = multi.getParameter("ogFile2");
	
	//지우기 시작
	try {
		//db에서 삭제
		UseDB_Comment udbC = new UseDB_Comment();
		udbC.deleteComment2(rootid, relevel, recnt);
		//udbC.deleteComment(id);
		udbC.close();
		
		/*************** 서버에서 파일 삭제 *****************/
		if (ogFile1 != null) {
			//out.print(ogFile1);
			File f1 = new File(filePath + ogFile1);
			f1.delete();
		}
		if (ogFile2 != null) {
			File f2 = new File(filePath + ogFile2);
			f2.delete();
		}
%>
<script>alert("삭제되었습니다.");</script>

<%
	} catch (Exception e) {
%>

<script>alert("삭제실패 \n에러 : <%=e%>");
</script>

<%
	}
%>
<Script>
	window.location = "?contentPage=Comment/Comment_list.jsp";
</Script>
