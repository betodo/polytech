<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Gongji,java.io.*"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<!-- 이게 있어야 path 잡기가 가능 -->
<%@page import="java.util.Enumeration"%>
<!-- 파일 업로드시 필요한 import -->
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- </head> -->
<!-- <body> -->
<!-- </body> -->
<!-- </html> -->
<%
	request.setCharacterEncoding("UTF-8");//한글 깨짐 방지
	
	//db연결
	UseDB_Gongji udbG = new UseDB_Gongji();

	//넣을 값들(삽입 , 업뎃 공통)
	String title = "";
	String content = "";
	String fileName1 ="";
	String fileName2 ="";
	
	//업뎃에서만 받을 애들
	int id = 0;
	String ogFileName1 ="";
	String ogFileName2 ="";

	//파일 저장 경로
	String uploadPath = request.getRealPath("mobile/Gongji/upload");
	

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
			
			udbG.insertGongji(title, content, fileName1, fileName2); //인서트 메서드 실행
%>
			<script>
				alert("작성 되었습니다.");
				window.location="?contentPage=Gongji/Gongji_list.jsp";
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

	} else if (key.equals("UPDATE")) { //글 없뎃
		//out.print(key);
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
			
			int s = udbG.updateGongji(id, title, content, fileName1, fileName2);
			
%>
			<script>
				alert("수정 되었습니다.");
				window.location="?contentPage=Gongji/Gongji_list.jsp";
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

	}
	udbG.close();
%>








