<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,twice_stock_pac.UseDB,java.io.*"%>
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stock_insert(input) </title>
	<style type="text/css">
		table {
			border-collapse: collapse;
		}
		tbody>tr {
			height:2em;
		}
		tfoot>tr {
			height:20em;
		}
		th {
			border:1px solid;
			width:10em;
		}
		td {
			padding-left:1em;
			text-align:left;
			border:1px solid;
			width:30em;
		}
		#divButton {
    		text-align: right;
		}
	</style>
	<%
		//날짜 출력 처리
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calt = Calendar.getInstance();
	
		//id값 자동 입력이지만 출력 위해 id 구함
		int id =0;
		UseDB udb = new UseDB();
		Statement stmt = udb.statementDB();
		String sql = "SELECT max(id) FROM tw_stock;";
		ResultSet rset = stmt.executeQuery(sql);
		rset.next();
		id = rset.getInt(1)+1;
	%>
	<script type="text/javascript">
		//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여
		function submitForm(mode) {
			/* const fm = document.getElementById("fm"); */
	        if(mode == 'insert'){
	        	const name = document.getElementById('name');
		        const stockCnt = document.getElementById('stockCnt');
		        const description = document.getElementById('description');
				
		        //값이 널일때 잡음
		        if(name.value.trim() == "" || stockCnt.value.trim() == ""
		        		|| description.value.trim() == ""){
	                alert("값을 입력해주세요");
	                return;
	            } 
	            fm.action = "?contentPage=stock_write.jsp?key=INSERT";  
	            
	        }else if(mode =='cancle'){
	        	fm.action = "?contentPage=stock_list.jsp";
	        }
// 	        else{
// 	        	fm.action = "?contentPage=stock_write.jsp?key=UPLOAD";
// 	        }
	        
	        fm.submit();
	        
	    }
	</script>
</head>
<body>
	<br>
	<h1>(주) 트와이스 재고 현황-상품등록</h1>
	<br>
	<!-- 파일 업로드시 메소드는 post enctype은 multipart/form-data로 해준다 -->
	<form method="POST" id=fm enctype="multipart/form-data">
	<table>
		<tbody>
			<tr>
				<th>상품번호</th>
				<td> <!-- 상품번호는 자동 입력이기 때문에 리드온리 -->
					<input type="text" value="<%=id %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="name" id="name" placeholder="20자 이내 입력" maxlength="20">
				</td>
			</tr>
			<tr>
				<th>재고현황</th>
				<td><!-- onkeyup을 사용할 경우 키보드를 눌렀다 땟을때가 액션이됨 -->
					<input type="text" name="stockCnt" id="stockCnt" placeholder="재고는 999개를 넘을수 없습니다." maxlength="3" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');">
				</td>
			</tr>
			<tr>
				<th>상품 등록일</th><td><%=sdf.format(calt.getTime()) %></td>
			</tr>
			<tr>
				<th>재고 등록일</th><td><%=sdf.format(calt.getTime()) %></td>
			</tr>
			<tr>
				<th>상품 설명</th>
				<td>
					<input type="text" name="description" id="description" placeholder="50자 이내 입력" maxlength="50">
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th>상품 사진</th>
				<td> <!-- 인풋 타입을 file로 하면 파일 찾기 단추가 생기고 업로드할 파일 선택 가능 -->
					<input type="file" name="file1">
				</td>
			</tr>
		</tfoot>
	</table>
	<br>
	<div id="divButton">
		<span><input type="button" value="취소" id=cancle onclick='submitForm("cancle")'></span>
		<span><input type="button" value="완료" id=insert onclick='submitForm("insert")'></span>
	</div>
	</form>
	<% rset.close(); stmt.close(); udb.close(); %>
</body>
</html>