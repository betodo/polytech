<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.sql.*, java.net.*,java.io.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
#wrap {
	height: 100vh;
	display: flex; /* 디스플레이를 플렉스로 준다 */
	flex-direction: column; /* 위아래로 나뉘도록 */
	/* 	align:center; */
	justify-content: center; /*두개다 있으면 한가운데 정렬 */
	align-items: center;
}
</style>
</head>
<body>
	<%
		String jump = request.getParameter("jump");
	%>
	<div id=wrap>
		<form action="login_check.jsp" method="post">
<!-- 			<table> -->
<!-- 				<thead> -->
<!-- 					<tr> -->
<!-- 						<th colspan=2>관리자 로그인</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tr> -->
<!-- 					<td>아이디</td> -->
<!-- 					<td><input type="text" name="id"></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td>비밀번호</td> -->
<!-- 					<td><input type="password" name="pwd"></td> -->
<!-- 				</tr> -->
<!-- 				<tr> -->
<!-- 					<td colspan=2 align="center"><input type="submit" value="전송"></td> -->
<!-- 				</tr> -->
<!-- 			</table> -->
<%-- 			<input type="hidden" name="jump" value="<%=jump%>"> --%>
			<table class="table" style="border:1px solid;">
				<thead class="thead-dark">
					<tr>
						<th scope="col" colspan=2>관리자 로그인</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">아이디</th>
						<td><input type="text" name="id"></td>
						
					</tr>
					<tr>
						<th scope="row">비밀번호</th>
						<td><input type="password" name="pwd"></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="jump" value="<%=jump%>">

			<div style="text-align:right">
				<input type="button" class="btn btn-outline-secondary" value="로그인 취소" onclick="location.href='../index.jsp'">
				<input type="submit" class="btn btn-outline-secondary" value="전송">
			</div>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>