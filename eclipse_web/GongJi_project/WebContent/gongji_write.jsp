<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%>    
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>
<!-- 이게 있어야 path 잡기가 가능 -->
<%@page import="java.util.Enumeration"%>
<!-- 파일 업로드시 필요한 import --> 
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글을 삽입하는 동작페이지</title>
</head>
<body>
	<%	
		//db연결
		UseDB udb = new UseDB();
	
		//넣을 값들(삽입 , 업뎃 공통)
		String title ="";
		String content="";
		
		String uploadPath = request.getRealPath("upload");
		//path 결과 C:\Users\admin\eclipse_web\GongJi_project\WebContent\\upload  
		
		//String viewpath = "upload/";
		
		//동작을 결정할 변수 key
		String key = request.getParameter("key");
		
		if (key.equals("INSERT") ){ //신규글 작성, no 댓글
			
			try {
				
				MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
						request, 
						uploadPath, // 파일을 저장할 디렉토리 지정
						1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
						"utf-8", // 인코딩 방식 지정
						new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
				);
				
				title = multi.getParameter("title");
				content = multi.getParameter("content");
				
				String fileName1 = multi.getFilesystemName("file1"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
				//String orgfileName1 = multi.getOriginalFileName("file1"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
				
				String fileName2 = multi.getFilesystemName("file2"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
				//String orgfileName2 = multi.getOriginalFileName("file2");
				
				
				udb.insertGongji(title, content, fileName1, fileName2); //인서트 메서드 실행
				out.print("<h4 align=\"center\">공지 삽입 완료</h4><br>");
			
			}catch(Exception e){
				out.print(e);
			}
		
			
		}else if(key.equals("UPDATE")){ //글 없뎃
			//없뎃할 행을 지정하기 위해 값 받기
			int id =0;
			String idTemp = request.getParameter("id");
			id = Integer.parseInt(idTemp);
			
			//String relevelTemp = request.getParameter("relevel");
			//int relevel = Integer.parseInt(relevelTemp);
			
			//업뎃(수정)시 제목과 글내용만 수정 가능
			String titleTemp = request.getParameter("title");
	 		title =new String(titleTemp.getBytes("8859_1"),"utf-8");
			
	 		String contentTemp = request.getParameter("content");
	 		content =new String(contentTemp.getBytes("8859_1"),"utf-8");
			
			
			udb.updateGongji(id, title, content);
			out.print("<h4 align=\"center\">수정완료</h4><br>");			
		
		}else if(key.equals("INSERT_RE")){ //댓글 작성할때
			
	 		String titleTemp = request.getParameter("title");
	 		title =new String(titleTemp.getBytes("8859_1"),"utf-8");
			
	 		String contentTemp = request.getParameter("content");
	 		content =new String(contentTemp.getBytes("8859_1"),"utf-8");
			
	 		//댓글 작성시 필요한 변수들
			int rootid = Integer.parseInt(request.getParameter("rootid"));
			int relevel = Integer.parseInt(request.getParameter("relevel"));
			int recnt = Integer.parseInt(request.getParameter("recnt"));


			udb.insertRe(title, content, rootid, relevel, recnt);
			out.print("<h4 align=\"center\">댓글 삽입 완료</h4><br>");
			
			
		}
		
	%>
	<%	
	    udb.close();
	%>
	<!-- 뒤로가기 버튼 -->
	<div align="center">
		<form method="post"><input type="submit" value=뒤로 id=cancle formaction="?contentPage=gongji_list.jsp"></form>
	</div>
</body>
</html>