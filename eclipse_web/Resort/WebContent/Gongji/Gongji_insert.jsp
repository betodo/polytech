<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Gongji,java.io.*"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
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
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar calt = Calendar.getInstance();
%>
<script type="text/javascript">
	//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여
	function submitForm(mode) {
		/* const fm = document.getElementById("fm"); */
		if (mode == 'write') {
			const title = document.getElementById('title');
			const content = document.getElementById('summernote');

			//값이 널일때 잡음
			if (title.value.trim() == "" || content.value.trim() == "") {
				alert("값을 입력해주세요");
				return;
			} else if (content.value.trim().length > 1000) {
				alert("글은 1000자 이내");
				return;
			}
			fm.action = "?contentPage=Gongji/Gongji_write.jsp?key=INSERT";

		} else if (mode == 'cancle') {
			fm.action = "?contentPage=Gongji/Gongji_list.jsp";

		}
		fm.submit();
	}
</script>
<div class="container">
	<form method="POST" id=fm enctype="multipart/form-data">
		<table id="basicTB" width="100%">
			<thead>
			<tr>
				<th colspan=2>새 공지글 작성</th>
			</tr>
		</thead>
			<tr class=tr123>
				<th>번호</th>
				<td>신규(insert), 자동입력</td>
			</tr>
			<tr class=tr123>
				<th>제목</th>
				<td><input type="text" name=title id='title' maxlength="70"></td>
			</tr>
			<tr class=tr123>
				<th>일자</th>
				<td><%=sdf.format(calt.getTime())%></td>
			</tr>
			<tr class=Content>
				<!-- textarea로 긴 문장을 입력받기 -->
				<th>내용</th>
				<td><textarea id="summernote" name="content" wrap="hard"
						maxlength="6000"></textarea></td>
			</tr>
			<tr style="border-bottom: 1px solid; height: 5em;">
				<th>파일 업로드</th>
				<td><input type="file" name=file1 style="margin-bottom: 10px;">
					<input type="file" name=file2></td>
			</tr>
		</table>
		<br>
		<div id="divButton" style="width: 100%; text-align: right;">
			<span><input class="btn btn-success" type="button" value=취소 id=cancle
				onclick='submitForm("cancle")'></span> <span><input class="btn btn-success"
				type="button" value=쓰기 id=write onclick='submitForm("write")'></span>
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


