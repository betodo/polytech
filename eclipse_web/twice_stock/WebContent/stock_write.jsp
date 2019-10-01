<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,twice_stock_pac.UseDB,java.io.*"%>
<!-- 이게 있어야 path 잡기가 가능 -->
<%@page import="java.util.Enumeration"%>
<!-- 파일 업로드시 필요한 import --> 
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stock_write(실제 db동작)</title>
</head>
	<%	
		//db연결
		UseDB udb = new UseDB();
		
		//삭제 할 건지 insert할건지 동작을 결정할 변수 key
		String key = request.getParameter("key");
		//out.print(key);
	%>
<body>
	<%
		//stock_view.jsp에서 재고 변경으로 넘어올때
		if (key.equals("UPDATE")){ 
			//key가 업뎃이면 변경할 데이터의 키값인 id받음
			String idTemp = request.getParameter("id");
			int id = Integer.parseInt(idTemp);
			//out.print(id);
			
			//변경할 데이터 받음
			String stockCntTemp = request.getParameter("stockCnt");
			int stockCnt = Integer.parseInt(stockCntTemp);
			//out.print(stockCnt);
			//변경 메서드 실행
			udb.updateTw_stock(stockCnt, id);
	%>		<!-- 결과 출력 -->
			<br><h1>(주) 트와이스 재고 현황-재고수정</h1><br><br>
			<br>
			<h3>상품번호 [<%=id %>]의 재고가 수정되었습니다.</h3><br>
			<br>
	<!-- key가 인서트면 할 동작들 -->
	<!-- stock_insert에서 넘어올때 -->
	<% } else if(key.equals("INSERT")) { 
			
			//받아와서 디비에 인서트할 변수들
			String name = "";
			int stockCnt = 0;
			String description = "";
			
			String img = "upload_imgs/"; //현재 경로에 디렉토리 만들어 줬기 때문에 잡아줌
			//String img = "";
			
			String fileName1 = "";
			String orgfileName1 = "";
			
			//파일 업로드에 필요한 경로
			//서버옵션에서 퍼블리싱 기능 해제 햇기 때문에 톰캣 경로로 안감
			//현재 만들어놓은 upload_imgs로 경로가 잡힌다.
			String uploadPath = request.getRealPath("upload_imgs"); // upload_imgs는 폴더명
			//String uploadPath = "C:\\Users\\admin\\eclipse_web\\twice_stock\\WebContent\\upload_imgs";
			//out.print(uploadPath);
			
			try {
				MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
						request, 
						uploadPath, // 파일을 저장할 디렉토리 지정
						1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
						"utf-8", // 인코딩 방식 지정
						new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
				);
				
				//insert.jsp에서 보낸 값 받기
				//멀티는 한글 처리 안해도 되었다.
				name = multi.getParameter("name");
				String stockCntTemp = multi.getParameter("stockCnt");
				stockCnt = Integer.parseInt(stockCntTemp);
				
				description = multi.getParameter("description");
				
				fileName1 = multi.getFilesystemName("file1"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
				orgfileName1 = multi.getOriginalFileName("file1"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
				
// 				img = uploadPath +"/" + fileName1;
				//디렉토리 경로에 파일네임을 붙이면 view에서 이미지src상대경로가 완성됨
				img = img + fileName1;
				
			} catch (Exception e) {
				e.getStackTrace();
			} // 업로드 종료
				
			//삽입 메서드 실행
			udb.insertTw_stock(name, stockCnt, description, img);
	%>
			<br><h1>(주) 트와이스 재고 현황-상품등록</h1><br><br>
			<br>
			<h3>[<%=name %>] 상품이 등록 되었습니다.</h3><br>
			<br>
			
	<% } %>
	<form action="?contentPage=stock_list.jsp">
		<input type="submit" value="목록" id=cancle>
	</form>
	<% udb.close(); %>
</body>
</html>