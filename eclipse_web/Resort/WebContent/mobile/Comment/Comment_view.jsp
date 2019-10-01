<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Comment,java.io.*"%>

<%
	String loginOK = null;
	loginOK = (String) session.getAttribute("login_ok");

	//값 받기
	String idTemp = request.getParameter("keyId");
	int id = Integer.parseInt(idTemp);

	//디비tkdyd
	UseDB_Comment udbC = new UseDB_Comment();

	//조회수 하나 올려줌(이 페이지 진입시)
	udbC.addViewcnt(udbC.selectOneComment(id), id);

	//출력준비
	ResultSet rset = udbC.selectOneComment(id);
	rset.next();
%>
<div class="container">
	<table id="basicTB" width="100%">
		<thead>
			<tr>
				<th colspan=2>후기</th>
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
				<td class="td"><%=rset.getString(8)%></td>
			</tr>
			<tr>
				<th>내용</th>
				<%-- <td><textarea readonly="readonly"><%=rset.getString(4) %></textarea></td></tr> --%>
				<td id=tdContent><div ><%=rset.getString(4)%></div></td>
			</tr>
			<tr>
				<th>파일1</th>
				<!-- 신규등록시 이미지를 안올렸을때 -->
				<td class=tdfile>
					<%
						String file1 = "";
						String file1Type = "";

						if (rset.getString(9) == null) {
							file1 = "파일 없음";
					%>
					<div class=divFile><%=file1%></div> 
 <%
 	} else {
 		file1 = rset.getString(9).trim();
 		file1Type = file1.substring(file1.length() - 3, file1.length());
 		
 		if (file1Type.equals("jpg") || file1Type.equals("png")) {
 			//System.out.print("확인");
 %>
					<div class=divFile style="display:inline">
						<a href="Comment/upload/<%=file1%>" download><%=file1%><img alt="" src="img/save.png"></a>
					</div> <img src="Comment/upload/<%=file1%>" class="img-fluid" alt="Responsive image" style="max-width:20%">
 <%
 		} else { 
 %>
					<div class=divFile>
						<a href="Comment/upload/<%=file1%>" download><%=file1%><img alt="" src="img/save.png"></a>
					</div> 
 <%
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

						if (rset.getString(10) == null) {
							file2 = "파일 없음";
					%>
					<div class=divFile><%=file2%></div>
 <%
 	} else {
 		file2 = rset.getString(10).trim();
 		file2Type = file2.substring(file2.length() - 3, file2.length());

 		if (file2Type.equals("jpg") || file2Type.equals("png")) {
 			
 %>
					<div class=divFile style="display:inline">
						<a href="Comment/upload/<%=file2%>" download><%=file2%><img alt="" src="img/save.png"></a>
					</div> <img src="Comment/upload/<%=file2%>" style="max-width:20%">
 <%
 		} else { 
 %>
					<div class=divFile>
						<a href="Comment/upload/<%=file2%>" download><%=file2%><img alt="" src="img/save.png"></a>
					</div> 
 <%
 		}
 	}
 %>
				</td>
			</tr>
		</tbody>
	</table>
	<br>
	<form method="POST" style="width: 100%; text-align: right;">
		<input type="hidden" name="id" value=<%=id%>>
		<input type="hidden" name="rootid" value =<%=rset.getString(5) %>>
		<input type="hidden" name="relevel" value =<%=rset.getString(6) %>>
		<input type="hidden" name="recnt" value =<%=rset.getString(7) %>>
		<!-- 뒤로가기 버튼과 수정 버튼 -->
		<div id=divButton>
			<span><input class="btn btn-success" type="submit" value=목록
				formaction="?contentPage=Comment/Comment_list.jsp"></span>
			<% if( loginOK != null && loginOK.equals("yes") ){ %>	 
			<span><input class="btn btn-success" type="submit" value=수정
				formaction="?contentPage=Comment/Comment_update.jsp"></span>
			<span><input class="btn btn-success" type="submit" value=댓글 
				formaction="?contentPage=Comment/Comment_reinsert.jsp"></span>
			<% }%>	
		</div>
	</form>
</div>
<%
	rset.close();
	udbC.close();
%>