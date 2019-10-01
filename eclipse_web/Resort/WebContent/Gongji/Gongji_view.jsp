<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page import="java.sql.*,useDB.UseDB_Gongji,java.io.*"%>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> -->
<title>Insert title here</title>
<!-- </head><body></body></html> -->

<%
	//글 수정 관리자만 가능 관리자 세션값 필요
	String loginOK = null;
	loginOK = (String) session.getAttribute("login_ok");	


	//날짜 출력 처리, 포맷부터 선언
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar calt = Calendar.getInstance();

	// 값 받기(db에서 해당 글 찾아서 내용 띄우기 위해)
	String idTemp = request.getParameter("keyId");
	int id = Integer.parseInt(idTemp);

	//디비tkdyd
	UseDB_Gongji udbG = new UseDB_Gongji();

	//조회수 하나 올려줌(이 페이지 진입시)
	udbG.addViewcnt(udbG.selectOneGongji(id), id);

	//출력준비
	ResultSet rset = udbG.selectOneGongji(id);
	rset.next();
%>
<div class="container">
	<table id="basicTB" width="100%">
		<thead>
			<tr>
				<th colspan=2>공지사항</th>
			</tr>
		</thead>
		<tbody>
		<tr>
			<th>번호</th>
			<td class="td"><%=rset.getInt(1)%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="td"><%=rset.getString(2)%></td>
		</tr>
		<tr>
			<th>일자</th>
			<td class="td"><%=rset.getString(3)%></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td class="td"><%=rset.getString(7)%></td>
		</tr>
		<tr>
			<th>내용</th>
			<%-- <td><textarea readonly="readonly"><%=rset.getString(4) %></textarea></td></tr> --%>
			<td id=tdContent><div><%=rset.getString(4)%></div></td>
		</tr>
		<tr>
			<th>파일1</th>
			<!-- 신규등록시 이미지를 안올렸을때 -->
			<td class=tdfile>
				<%
					String file1 = "";//파일1출력용 변수
					String file1Type = "";//파일이 이미지인지 판단하기 위한 변수

					if (rset.getString(5)==null) {//아예 파일 없으면
						file1 = "파일 없음";
				%>
				<div class=divFile><%=file1%></div> <%
 	} else {
 		file1 = rset.getString(5).trim();//파일 있으면 이름 받고
 		file1Type = file1.substring(file1.length() - 3, file1.length());//확장자 추출

 		if (file1Type.equals("jpg") || file1Type.equals("png")) {//확장자가 jpg나 png면 파일이름과 이미지 출력
 %>
				<div class=divFile style="display:inline">
					<!-- a링크의 download옵션으로 다운로드 가능하게함+파일이름 출력 -->
					<a href="Gongji/upload/<%=file1%>" download><%=file1%><img alt="" src="img/save.png"></a>
				</div><img src="Gongji/upload/<%=file1%>" class="img-fluid" alt="Responsive image" style="max-width:20%"> 
 <%
 	} else { //확장자가 jpg나 png가 아니면 그냥 파일이름만 출력
 %>
				<div class=divFile>
					<a href="Gongji/upload/<%=file1%>" download><%=file1%><img alt="" src="img/save.png"></a>
				</div> <%
 	}
 	}
 %>
			</td>
		</tr>
		<tr>
			<th>파일2</th>
			<td class=tdfile>
				<%
					String file2 = "";
					String file2Type = "";

					if (rset.getString(6) == null) {
						file2 = "파일 없음";
				%>
				<div class=divFile><%=file2%></div> <%
 	} else {
 		file2 = rset.getString(6).trim();
 		file2Type = file2.substring(file2.length() - 3, file2.length());

 		if (file2Type.equals("jpg") || file2Type.equals("png")) {
 %>
				<div class=divFile style="display:inline">
					<a href="Gongji/upload/<%=file2%>" download><%=file2%><img alt="" src="img/save.png"></a>
				</div> <img src="Gongji/upload/<%=file2%>" style="max-width:20%"> <%
 		} else {
 %>
				<div class=divFile>
					<a href="Gongji/upload/<%=file2%>" download><%=file2%><img alt="" src="img/save.png"></a>
				</div> <%
 		}
 	}
 %>
			</td>
		</tr>
		</tbody>
	</table>
	<br>
	<form method="POST" style="width: 100%; text-align: right;">
		<!-- 수정시 무슨 글을 수정할지 알려면 글번호 넘겨줘야한다 -->
		<input type="hidden" name="id" value=<%=id%>>
<%-- 		<input type="hidden" name="file1" value=<%=rset.getString(5)%>> --%>
		<!-- 뒤로가기 버튼과 수정 버튼 -->
		<div id=divButton>
			<span><input class="btn btn-success" type="submit" value=목록
				formaction="?contentPage=Gongji/Gongji_list.jsp"></span>
<% if( loginOK != null && loginOK.equals("yes") ){ %>
			<span><input class="btn btn-success" type="submit" value=수정
				formaction="?contentPage=Gongji/Gongji_update.jsp"></span>
<% }%>
		</div>
	</form>
</div>
<%
	rset.close();
	udbG.close();
%>

