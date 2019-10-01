<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%>
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>댓글입력화면</title>
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
			width: 450px;
			height: 250px;
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
		
		//원글 번호 받기 = 조회한 글의 id
		String rootidTemp = request.getParameter("rootid");
		int	rootid = Integer.parseInt(rootidTemp);
		
		//댓글 수준 받기 = 조회한 글의 댓글 수준 +1
		String relevelTemp = request.getParameter("relevel");
		int	relevel = Integer.parseInt(relevelTemp)+1;
		
		//댓글 내 순서
		String recntTemp = request.getParameter("recnt");
		int recnt =  Integer.parseInt(recntTemp);	
		
	%>
	<script type="text/javascript">
		//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여
		function submitForm(mode) {
			/* const fm = document.getElementById("fm"); 이거 없어도 fm 사용가능*/
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
		        	alert("댓글은 250자 까지만");
		        	return;
		        }
	            fm.action = "?contentPage=gongji_write.jsp?key=INSERT_RE";  //동작을 결정하는 변수 key값을 insert_re로 보냄
	           
	        }else if(mode =='cancle'){
	        	fm.action = "?contentPage=gongji_list.jsp";
	        	
	        }
	        fm.submit();
	    }
	</script>
</head>
<body>
	<div id=wrap>
	<form method="POST" id=fm>
	<table>
		<tr class=tr123>
			<th>번호</th><td>댓글(insert)</td>
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
			<td><textarea id="content" name="content" wrap="hard" id="content" maxlength="200"></textarea></td>
		</tr>
		<tr class=tr123>
			<th>원글</th><td><%=rootid %></td>
			<input type="hidden" name="rootid" value="<%=rootid %>">
		</tr>
		<tr class=tr123>
			<th>댓글수준</th><td><%=relevel %></td>
			<input type="hidden" name="relevel" value="<%=relevel %>"> 
		</tr>
		<tr class=tr123>
			<th>댓글순서</th>
			<td><%=recnt %></td>
			<input type="hidden" name="recnt" value="<%=recnt %>">
		</tr>
	</table>
	<br>
	<div id="divButton">
		<span><input type="button" value=취소 id=cancle onclick='submitForm("cancle")'></span>
		<span><input type="button" value=쓰기 id=write onclick='submitForm("write")'></span>
	</div>
	</form>
	</div>
	<!-- 네이버 스마트 에디터 사용하기 
	1. 스마트에디터 다운로드 프로젝트 경로내 파일 생성 복사 
	2. 텍스트에어리어 만들고
	3. 아래 js코드 작성-->
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