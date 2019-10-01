<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%>
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 글 하나 select 화면</title>
	<style type="text/css">
		#wrap { 
			display: flex;
			/* justify-content: center; */
			align-items: center;  
		}
		table{
			border-collapse: collapse;
		}
		tr {
			height:3em;
			border-bottom:1px solid;
		}
		th {
			width:80px;
		}
		.td {
			padding-left:2em;
			width:500px;
		}
		.tdfile {
			display:flex;
			align-items: center;
		}
		#divButton{
		    width: 450px;
    		text-align: right;
		}
/* 		textarea {width: 450px;height: 200px;} */
		#divContent {
			margin-left:2em;
			width: 500px;
			height: 170px;
			overflow: auto;
		}
		img { 
 			max-width: auto;
    		max-height: 7em;
    		padding-left: 5em;
		}
		.divFile {
			line-height:45px;
			margin-left:2em;
		}
	</style>
	<%
		//날짜 출력 처리
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calt = Calendar.getInstance();
		
		// 값 받기
		String idTemp = request.getParameter("keyId");
		int id = Integer.parseInt(idTemp);
		
		//목록화면에서 한글보기로(여기)들어오면 조회수를 늘려준다
		UseDB udb = new UseDB();
		Statement stmt = udb.statementDB();
		
		String sql2 = "select viewcnt from gongji where id="+id+";";//이글의 조회수 가져오고
		ResultSet rset2 = stmt.executeQuery(sql2);
		rset2.next();
		int viewcnt = rset2.getInt(1)+1;//조회수늘려주고
		
		String sql3 = "update gongji set viewcnt="+viewcnt+" where id="+id+";";//db에 입력
		stmt.execute(sql3);
		
		String sql = "SELECT * FROM gongji where id="+id+";";//출력준비
		ResultSet rset = stmt.executeQuery(sql);
		rset.next();
		
	%>
</head>
<body>
	<div id=wrap>
	<table>
		<tr>
			<th>번호</th>
			<td class="td"><%=rset.getInt(1) %></td></tr>
		<tr>
			<th>제목</th>
			<td class="td"><%=rset.getString(2) %></td></tr>
		<tr>
			<th>일자</th>
			<td class="td"><%=rset.getString(3) %></td></tr>
		<tr>
			<th>조회수</th>
			<td class="td"><%=rset.getString(8) %></td></tr>
		<tr>
			<th>내용</th>
<%-- 			<td><textarea readonly="readonly"><%=rset.getString(4) %></textarea></td></tr> --%>
			<td><div id=divContent><%=rset.getString(4) %></div></td></tr>
		<tr>
			<th>원글</th>
			<td class="td"><%=rset.getString(5) %></td></tr>
		<tr>
			<th>댓글수준</th>
			<td class="td"><%=rset.getString(6) %></td></tr>
		<tr>
			<th>댓글순서</th>
			<td class="td"><%=rset.getString(7) %></td></tr>
		<tr>
			<th>파일1</th><!-- 신규등록시 이미지를 안올렸을때 -->
			<td class=tdfile>
			<%
				//파일이름에 따라 출력다르게하기
				String file1 ="";
				String file1Type ="";
				
				if(rset.getString(9)==null){//파일이 없으면 파일 없음
					file1="파일 없음";
			%>
				<div class=divFile><%=file1 %></div>
			<%		
				}else{
					file1 = rset.getString(9).trim();
					file1Type = file1.substring(file1.length()-3, file1.length());//확장자가 png나 jpg면 이미지보기로 출력
					
					if(file1Type.equals("jpg") || file1Type.equals("png")) {
			%>
						<div class=divFile><a href="upload/<%=file1 %>" download><%=file1 %></a></div>	
						<img src="upload/<%=file1 %>">
					<!-- 파일이 이미지 파일이 아니면 이름을 걍 출력 -->	
			<%		}else{ %>
						<div class=divFile><a href="upload/<%=file1 %>" download><%=file1 %></a></div>
			<% 			//a태그 옵션 download = 클릭시 파일 다운로드가 된다
					}
				}
			%>
			</td>
		</tr>
		<tr>
			<th>파일2</th>
			<td class=tdfile>
			<%
				String file2 ="";
				String file2Type ="";
				
				if(rset.getString(10)==null){
					file2="파일 없음";
			%>
				<div class=divFile><%=file2 %></div>
			<%		
				}else{
					file2 = rset.getString(10).trim();
					file2Type = file2.substring(file2.length()-3, file2.length());
					
					if(file2Type.equals("jpg") || file2Type.equals("png")) {
			%>
						<div class=divFile><a href="upload/<%=file2 %>" download><%=file2 %></a></div>	
						<img src="upload/<%=file2 %>">
			<%		}else{ %>
						<div class=divFile><a href="upload/<%=file2 %>" download><%=file2 %></a></div>
			<% 			
					}
				}
			%>
			</td>
		</tr>
	</table>
	<br>
	<!-- 댓글 구현을 위해 id와 원글번호 댓글수준 댓글순서를 결정할 변수를 보냄-->
	<form method="POST">
	<input type="hidden" name="keyId" value =<%=id %>>
	<input type="hidden" name="rootid" value =<%=rset.getString(5) %>>
	<input type="hidden" name="relevel" value =<%=rset.getString(6) %>>
	<input type="hidden" name="recnt" value =<%=rset.getString(7) %>>
	<!-- 뒤로가기 버튼과 수정 버튼 -->
	<div id=divButton>
		<span><input type="submit" value=목록 formaction="?contentPage=gongji_list.jsp"></span>
		<span><input type="submit" value=수정 formaction="?contentPage=gongji_update.jsp"></span>
		<span><input type="submit" value=댓글 formaction="?contentPage=gongji_reinsert.jsp"></span>
	</div>
	</form>
	</div>
	<%	
		rset.close();
		rset2.close();
	    stmt.close();
	    udb.close();
	%>
</body>
</html>