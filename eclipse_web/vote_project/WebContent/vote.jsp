<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표</title>
	<%
		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		
		//select box출력 준비
		String QueryTxt;
		QueryTxt = "select * from candidate;";
		ResultSet rset = stmt.executeQuery(QueryTxt);
	%>
	<script type="text/javascript">
		//널값 제외 함수
	    function limitNull() {
	        const insert = document.getElementById('insert');//form을 받아옴
	        const inputName = document.getElementById('name');//인풋타입텍스트들을 받아옴
	        const inputAge = document.getElementById('age');//인풋타입텍스트들을 받아옴
	      
	        if(inputName.value =="" || inputAge.value==""){
	            alert("입력값이 없는지 확인 해 보세요");
	            return;
	        }
	
	        insert.submit(); 
	    }
	</script>
</head>
<body>
<h3 style="margin-left: 2em">투표</h3>	
	<table>
		<tr>
			<form method="post" action="?contentPage=voteResult.jsp" id="insert">
				<td>
					<!-- 폼에 셀렉트 태그를 씌어서 셀렉트 박스를 만든다. -->
					<select name =toVote id=name>
						<option value="">후보자 선택</option>
						<% while(rset.next()){ %>
							<option value="<%=rset.getInt(1) %>"><%=rset.getInt(1) %>번 : <%=rset.getString(2) %></option>
						<% } %>
					</select>
				</td>
				<td>
					<select name="toAge" id=age>
						<option value="">투표자 연령 선택</option>
						<option value="1">10대</option>
						<option value="2">20대</option>
						<option value="3">30대</option>
						<option value="4">40대</option>
						<option value="5">50대</option>
						<option value="6">60대</option>
						<option value="7">70대</option>
						<option value="8">80대</option>
						<option value="9">90대</option>
					</select>
				</td>
				<!-- 버튼에 클릭이벤트리스너를 만들어서 값보내기 -->
				<td><input type="button" value="투표하기" onclick="limitNull()"></td>
			</form>			 
		</tr>
	</table>
	<%
		rset.close();
	    stmt.close();
	    cdb.close();
	%>
</body>
</html>