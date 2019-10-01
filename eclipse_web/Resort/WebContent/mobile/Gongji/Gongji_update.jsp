<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page import="java.sql.*,useDB.UseDB_Gongji,java.io.*"%>
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta charset="UTF-8"> -->
<!-- <title>공지 수정 업데이트</title> -->

<%
	//날짜 출력 준비
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar calt = Calendar.getInstance();

	// 값 받기
	String idTemp = request.getParameter("id");
	int id = Integer.parseInt(idTemp);

	
	// db연결
	UseDB_Gongji udbG = new UseDB_Gongji();
	//select one row메서드
	ResultSet rset = udbG.selectOneGongji(id);
	rset.next();

	//String realTitle = rset.getString(2);
%>
<script type="text/javascript">
	function submitForm() {
		const title = document.getElementById('title');
		//oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		const content = document.getElementById('summernote');
		//document.getElementById("ir1").value
		//값이 널일때 잡음
		if (title.value.trim() == "" || content.value.trim() == "") {
			alert("값을 입력해주세요");
			return;
		} else if (content.value.trim().length > 1000) {
			alert("글은 1000자 이내");
			return;
		}

		fm.action = "?contentPage=Gongji/Gongji_write.jsp?key=UPDATE";
		fm.submit();

	}
</script>
<div class="container">
	<form method="post" id=fm enctype="multipart/form-data">
		<input type="hidden" name="id" value="<%=rset.getInt(1)%>"> <input
			type="hidden" name="ogFile1" value=<%=rset.getString(5)%>> <input
			type="hidden" name="ogFile2" value=<%=rset.getString(6)%>>
		<table id="basicTB" width="100%">
			<thead>
			<tr>
				<th colspan=2>공지 글 수정</th>
			</tr>
			</thead>
			<tbody>
			<tr class=tr123>
				<th>번호</th>
				<td><%=rset.getInt(1)%></td>
			</tr>
			<tr class=tr123>
				<th>제목</th>
				<td><input type=text value="<%=rset.getString(2)%>"
					name="title" id="title" maxlength="70"></td>
			</tr>
			<tr class=tr123>
				<th>일자</th>
				<td><%=rset.getString(3)%></td>
			</tr>
			<tr class=Content>
				<th class=Content>내용</th>
				<td class=Content><textarea height="400px" id="summernote"
						name="content" wrap="hard" maxlength="2000"><%=rset.getString(4)%></textarea>
				</td>
			</tr>
			<tr style="border-bottom: 1px solid; height: 5em; width: 15em;">
				<th>파일 변경<br>(기존파일<br>삭제주의)</th>
				<td><input type="file" name=file1 style="margin-bottom: 10px;">
					<input type="file" name=file2></td>
			</tr>
			</tbody>
		</table>
		<br>
		<!-- 홈, 실제 수정동작, 삭제동작 버튼 -->
		<div id=divButton style="width: 100%; text-align: right;">
			<span><input class="btn btn-success" type="submit" value=취소 id=cancle
				formaction="?contentPage=Gongji/Gongji_list.jsp"></span>
			<!-- <span><input type="submit" value=쓰기 formaction="?contentPage=gongji_write.jsp?key=UPDATE" ></span> -->
			<span><input class="btn btn-success" type="button" value=쓰기 onclick='submitForm()'></span>
			<span><input class="btn btn-success" type="submit" value=삭제
				formaction="?contentPage=Gongji/Gongji_delete.jsp"></span>
		</div>
	</form>
</div>

<script type="text/javascript">
	$('#summernote')
			.summernote(
					{
						//placeholder: 'Hello bootstrap 4',
						tabsize : 2,
						height : 100,
						toolbar : [
								// [groupName, [list of button]]
								[
										'style',
										[ 'bold', 'italic', 'underline',
												'clear' ] ],
								[
										'font',
										[ 'strikethrough', 'superscript',
												'subscript' ] ],
								[ 'fontsize', [ 'fontsize' ] ],
								[ 'color', [ 'color' ] ],
								[ 'para', [ 'ul', 'ol', 'paragraph' ] ],
								[ 'height', [ 'height' ] ] ]
					});
</script>
<%
	rset.close();
	udbG.close();
%>

