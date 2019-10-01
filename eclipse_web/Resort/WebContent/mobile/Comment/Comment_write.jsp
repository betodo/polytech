<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Comment,java.io.*"%>   
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<!-- 이게 있어야 path 잡기가 가능 -->
<%@page import="java.util.Enumeration"%>
<!-- 파일 업로드시 필요한 import -->
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%
	//db연결
	UseDB_Comment udbC = new UseDB_Comment();

	//넣을 값들(후기 작성)
	String title = ""; //신규 수정 공통
	String content = ""; //신규 수정 공통
	String fileName1 ="";//신규 수정 공통
	String fileName2 ="";//신규 수정 공통
	int rootid = 0;
	int relevel = 0;
	int recnt = 0;
	
	//수정 에서만 받을 애들
	int id = 0;
	String ogFileName1 ="";
	String ogFileName2 ="";
	
	//파일 저장 경로
	String uploadPath = request.getRealPath("mobile/Comment/upload");
	
	//동작을 결정할 변수 key
	String key = request.getParameter("key");
	
	if (key.equals("INSERT")) { //신규글 작성
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, uploadPath, // 파일을 저장할 디렉토리 지정
					1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);

			title = multi.getParameter("title");
			content = multi.getParameter("content");
			fileName1 = multi.getFilesystemName("file1"); 
			fileName2 = multi.getFilesystemName("file2");
			
			udbC.insertComment(title, content, fileName1, fileName2);
%>
			<script>
				alert("후기가 작성 되었습니다.");
				window.location="?contentPage=Comment/Comment_list.jsp";
			</script>
	<%
		}catch(Exception e){
			out.print(e);
	%>	
			<script>
				alert("작성 실패");
				window.history.go(-1);
			</script>	
	<%
		}
	
	}else if(key.equals("UPDATE")){ //후기 수정	
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, uploadPath, // 파일을 저장할 디렉토리 지정
					1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);
			//업뎃할 애들 값 받기
			String idTemp = multi.getParameter("id");
			id = Integer.parseInt(idTemp);

			title = multi.getParameter("title");
			content = multi.getParameter("content");
			
			ogFileName1 = multi.getParameter("ogFile1");
			if(ogFileName1.equals("null")) ogFileName1 =null;
			ogFileName2 = multi.getParameter("ogFile2");
			if(ogFileName2.equals("null")) ogFileName2 =null;
			
			fileName1 = multi.getFilesystemName("file1"); 
			fileName2 = multi.getFilesystemName("file2");
	
			//새로운 파일로 수정시 기존 파일 지우기
			if(fileName1 == null) {
				fileName1 = ogFileName1;
			}else{
				 File f1 = new File(uploadPath+"/"+ogFileName1);
			     if(f1.exists()) f1.delete();
			}
			
			//새로운 파일로 수정시 기존 파일 지우기
			if(fileName2 == null) {
				fileName2 = ogFileName2;
			}else{
				File f2 = new File(uploadPath+"/"+ogFileName2);
			    if(f2.exists()) f2.delete();
			}
			
			udbC.updateComment(id, title, content, fileName1, fileName2);
	%>
			<script>
				alert("수정 되었습니다.");
				window.location="?contentPage=Comment/Comment_list.jsp";
			</script> 
	<%
		} catch (Exception e) {
			out.print(e);
	%>
			<script>
				alert("수정 실패");
				window.history.go(-1);
			</script> 
	<%
		}	
	}else if(key.equals("INSERT_RE")){ //댓글 작성할때
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, uploadPath, // 파일을 저장할 디렉토리 지정
					1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);
			
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			
			fileName1 = multi.getFilesystemName("file1"); 
			fileName2 = multi.getFilesystemName("file2");
			
			rootid = Integer.parseInt(multi.getParameter("rootid"));
			relevel = Integer.parseInt(multi.getParameter("relevel"));
			recnt = Integer.parseInt(multi.getParameter("recnt"));
			
			udbC.insertRe(title, content, rootid, relevel, recnt, fileName1, fileName2);
			
	%>
			<script>
				alert("댓글 작성 되었습니다.");
				window.location="?contentPage=Comment/Comment_list.jsp";
			</script> 
	<%
		} catch (Exception e) {
			out.print(e);
	%>
			<script>
				alert("댓글 작성 실패 실패");
				window.history.go(-1);
			</script> 
	
	<%
		}

	}
	udbC.close();
%>
	
	
	
	
	
