<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%>
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 하나를 입력하는 화면</title>
	<style type="text/css">
		#wrap {
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
		textarea {
			width: 500px; 
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
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calt = Calendar.getInstance();
		//out.print(sdf.format(calt.getTime())); 
	%>
	
	<script type="text/javascript">
		//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여
		function submitForm(mode) {
			/* const fm = document.getElementById("fm"); */
	        if(mode == 'write'){
	        	const title = document.getElementById('title');
		        oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		        const content = document.getElementById('content');
				
		        
		        //값이 널일때 잡음
		        if(title.value.trim() == "" || content.value.trim() == ""){
	                alert("값을 입력해주세요");
	                return;
	            }
		        else if(content.value.trim().length >=500){
		        	alert("글은 500자 까지만");
		        	return;
		        }
	            fm.action = "?contentPage=gongji_write.jsp?key=INSERT";  
	           
	        }else if(mode =='cancle'){
	        	fm.action = "?contentPage=gongji_list.jsp";
	        	
	        }
	        fm.submit();
	    } 
		
        
	</script>
</head>
<body>
	<div id=wrap>
	<form method="POST" id=fm enctype="multipart/form-data">
	<table>
		<tr class=tr123>
			<th>번호</th><td>신규(insert)</td>
		</tr>
		<tr class=tr123>
			<th>제목</th><td><input type="text" name=title id='title' maxlength="70"></td>
		</tr>
		<tr class=tr123>
			<th>일자</th>
			<td>
				<%=sdf.format(calt.getTime()) %>
				<%-- <input type="hidden" value="<%=sdf.format(calt.getTime()) %>"> --%>
			</td>
		</tr>
		<tr class=Content>
		<!-- textarea로 긴 문장을 입력받기 -->
			<th>내용</th>
			<td><textarea id="content" name="content"  wrap="hard" id="content" maxlength="6000"></textarea></td>
		</tr>
		<tr style="border-bottom:1px solid; height: 5em;" >
			<th>파일 업로드</th>
			<td><input type="file" name=file1 style="margin-bottom: 10px;"><input type="file" name=file2></td>
		</tr>
	</table>
	<br>
	<div id="divButton">
		<span><input type="button" value=취소 id=cancle onclick='submitForm("cancle")'></span>
		<span><input type="button" value=쓰기 id=write onclick='submitForm("write")'></span>
	</div>
	</form>
	</div>
	
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