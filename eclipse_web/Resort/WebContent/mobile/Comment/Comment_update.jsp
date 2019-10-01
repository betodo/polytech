<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Comment,java.io.*"%>

<%
	//값 받기
	String idTemp = request.getParameter("id");
	int id = Integer.parseInt(idTemp);
	
	String relevelTemp = request.getParameter("relevel");
	int relevel = Integer.parseInt(relevelTemp);

	// db연결
	UseDB_Comment udbC = new UseDB_Comment();
	//select one row메서드
	ResultSet rset = udbC.selectOneComment(id);
	rset.next();
	
	int rootid = rset.getInt(5);
	int recnt = rset.getInt(7);
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

		fm.action = "?contentPage=Comment/Comment_write.jsp?key=UPDATE";
		fm.submit();

	}
</script>
<div class="container">
	<form method="post" id=fm enctype="multipart/form-data">
		<input type="hidden" name="id" value="<%=rset.getInt(1)%>">
		<input type="hidden" name="ogFile1" value=<%=rset.getString(9)%>>
		<input type="hidden" name="ogFile2" value=<%=rset.getString(10)%>>
		<input type="hidden" name="relevel" value =<%=relevel %>>
		<input type="hidden" name="rootid" value =<%=rootid %>>
		<input type="hidden" name="recnt" value =<%=recnt %>>
		<table id="basicTB" width="100%">
			<thead>
			<tr>
				<th colspan=2>후기 글 수정</th>
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
					name="title" id="title" maxlength="100"></td>
			</tr>
			<tr class=tr123>
				<th>일자</th>
				<td><%=rset.getString(3)%></td>
			</tr>
			<tr class=Content>
				<th class=Content>내용</th>
				<td class=Content><textarea height="400px" id="summernote"
						name="content" wrap="hard" maxlength="6000"><%=rset.getString(4)%> </textarea>
				</td>
			</tr>
			<tr style="border-bottom: 1px solid; height: 5em;">
				<th>파일 업로드</th>
				<td><input type="file" name=file1 style="margin-bottom: 10px;">
					<input type="file" name=file2></td>
			</tr>
			</tbody>
		</table>
		<br>
		<!-- 홈, 실제 수정동작, 삭제동작 버튼 -->
		<div id=divButton style="width: 100%; text-align: right;">
			<span><input class="btn btn-success" type="submit" value=취소 id=cancle
				formaction="?contentPage=Comment/Comment_list.jsp"></span>
			<span><input class="btn btn-success" type="button" value=쓰기 onclick='submitForm()'></span>
			<span><input class="btn btn-success" type="submit" value=삭제
				formaction="?contentPage=Comment/Comment_delete.jsp"></span>
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
	udbC.close();
%>
