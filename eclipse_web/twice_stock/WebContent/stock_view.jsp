<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,twice_stock_pac.UseDB,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>stock_view</title>
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
		img { 
 			max-width: 20em;
    		max-height: 15em;
    		padding-left: 5em;
			
		} 
	</style>
	<% 
		// stoc_list링크가 주는 값 받기
		String idTemp = request.getParameter("keyId");
		int id = Integer.parseInt(idTemp);
		
		//db연결
		UseDB udb = new UseDB();
		//1 row 조회
		ResultSet rset = udb.selectOneTw_stock(id);
		rset.next();
		
	%>
	<script type="text/javascript">
		
		//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여
		function submitForm(mode) {
			/* const fm = document.getElementById("fm"); */
	        if(mode == 'update'){
	        	const stockCnt = document.getElementById('stockCnt');
	        	
	        	//값이 널일때 잡음
		        if(stockCnt.value.trim() == ""){
	                alert("값을 입력해주세요");
	                return;
	            } 
	            fm.action = "?contentPage=stock_write.jsp?key=UPDATE";  
	            
	        }else if(mode =='del'){
	        	fm.action = "?contentPage=stock_delete.jsp?key=DELETE";
	        } else{
	        	fm.action = "?contentPage=stock_list.jsp"; 
	        } 
	        //액션 지정뒤 이동
	        fm.submit();
	        
	    } 
	</script>
</head>
<body>
	<br>
	<h1>(주) 트와이스 재고 현황-상품상세</h1>
	<br>
	<form method="POST" id=fm>
	<table>
		<tbody>
			<tr>
				<th>상품번호</th><td><%=rset.getInt(1) %></td>
				<input type="hidden" name="id" value="<%=rset.getInt(1) %>">
			</tr>
			<tr>
				<th>상품명</th><td><%=rset.getString(2) %></td>
				<input type="hidden" name="name" value="<%=rset.getString(2) %>">
			</tr>
			<tr>
				<!-- 보여주는 화면이지만 바로 재고수정 가능하도록 재고수정을 인풋으로 작성하게함 -->
				<th>재고현황</th> <%-- 아스키코드로 숫자함수만 한글 안 먹음 그래서 정규식으로 숫자 잡기 --%>
				<td><input type="text" name="stockCnt" id="stockCnt"  maxlength="3" value="<%=rset.getInt(3) %>" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" ></td>
			</tr>
			<tr>
				<th>상품 등록일</th><td><%=rset.getString(4) %></td>
			</tr>
			<tr>
				<th>재고 등록일</th><td><%=rset.getString(5) %></td>
			</tr>
			<tr>
				<th>상품 설명</th><td><%=rset.getString(6) %></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th>상품 사진</th><!-- 신규등록시 이미지를 안올렸을때 -->
				<%if(rset.getString(7).trim().equals("upload_imgs/null")) { %>
					<td>이미지가 없습니다.</td>
				<%} else { %>
					<td><img src="<%=rset.getString(7) %>"></td>
<!-- 					<th>상품 사진</th><td><img src="./upload_imgs/bananamilk.jpg"></td> -->
				<%} %>
			</tr>
		</tfoot>
	</table>
	<br>
	<div id="divButton">
		<span><input type="button" value="목록" id=cancle onclick='submitForm("cancle")'></span>
		<span><input type="button" value=상품삭제 id=del onclick='submitForm("del")'></span>
		<span><input type="button" value=재고수정 id=update onclick='submitForm("update")'></span>
	</div>
	</form>
	<% rset.close(); udb.close(); %>	
</body>
</html>