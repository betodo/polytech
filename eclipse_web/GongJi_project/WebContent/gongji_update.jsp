<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%> 
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정 화면</title>
	<style type="text/css">
		#wrap { /* 가운데 정렬 */
			display: flex;
			/* justify-content: center; */
			align-items: center;  
		}
		table{
			border-collapse: collapse;
		}
		.tr123 {
			height:3em;
			border-bottom:1px solid;
		}
		th {
			width:50px;
		}
		td {
			padding-left:2em;
			width:500px;
		}
		#divButton {
		    width: 550px;
    		text-align: right;
		}
		#title {
			width: 400px;	
		}
		textarea { /* 마미막행에서 내용칸 크기 지정 */
			width: 450px;
			height: 350px;
		}
		.Content  {
			height: 400px;
			border-bottom:1px solid;
		}
		form {
			height:100%;
		}
	</style>
	<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>
	<%
		//날짜 출력 준비
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calt = Calendar.getInstance();
		
		// 값 받기
		String idTemp = request.getParameter("keyId");
		int id = Integer.parseInt(idTemp);
		
		String relevelTemp = request.getParameter("relevel");
		int relevel = Integer.parseInt(relevelTemp);
		
		// db연결
		UseDB udb = new UseDB();
		//select one row메서드
		ResultSet rset = udb.selectOneGongji(id);
		rset.next();
		
		String realTitle = rset.getString(2);
	%>
	<script type="text/javascript">
	
		function submitForm() {
			const title = document.getElementById('title');
	        oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	        const content = document.getElementById('content');
	        //document.getElementById("ir1").value
	        //값이 널일때 잡음
	        if(title.value.trim() == "" || content.value.trim() == ""){
                alert("값을 입력해주세요");
                return;
            }
	        else if(content.value.trim().length >=500){
	        	alert("댓글은 250자 까지만");
	        	return;
	        }
	        fm.action = "?contentPage=gongji_write.jsp?key=UPDATE";  
	        fm.submit();
	        
	    } 
		
	</script>
</head>
<body>
	<div id=wrap>
	<form method="post" id=fm>
	<input type="hidden" name="relevel" value =<%=relevel %>>
	<table>
		<tr class=tr123>
			<th>번호</th>
			<td><input type=text value=<%=rset.getInt(1) %> readonly=readonly name="id"></td>
		</tr>
		<tr class=tr123>
			<th>제목</th>
			<td><input type=text value="<%=realTitle %>" name="title" id="title" maxlength="100"></td>
		</tr>
		<tr class=tr123>
			<th>일자</th><td><%=sdf.format(calt.getTime()) %></td>
		</tr>
		<tr class=Content>
			<th class=Content>내용</th>
			<td class=Content>
				<textarea height="400px" id="content" name="content"  wrap="hard" maxlength="6000"><%=rset.getString(4) %></textarea>
			</td>
		</tr>
	</table>
	<br>
	<!-- 홈, 실제 수정동작, 삭제동작 버튼 -->
	<div id=divButton>
		<span><input type="submit" value=취소 id=cancle formaction="?contentPage=gongji_list.jsp"></span>
<!-- 		<span><input type="submit" value=쓰기 formaction="?contentPage=gongji_write.jsp?key=UPDATE" ></span> -->
		<span><input type="button" value=쓰기 onclick='submitForm()'></span>
		<span><input type="submit" value=삭제 formaction="?contentPage=gongji_delete.jsp"></span>
	</div>
	</form>
	</div>
	<% rset.close(); udb.close(); %>
	
	<script type="text/javascript">

		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			 oAppRef: oEditors,
			 elPlaceHolder: "content",
			 sSkinURI: "se2/SmartEditor2Skin.html",
			 fCreator: "createSEditor2"
		});
	
	</script>
</body>
</html>