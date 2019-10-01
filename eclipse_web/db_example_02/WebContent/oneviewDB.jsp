<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kopo.service.ExamService,kopo.service.ExamServiceImpl,kopo.dto.ExamScore" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="mystyle.css" >
</head>
<body>
	<h3>조회</h3>
	<hr>
	<%
		int studentid = Integer.parseInt(request.getParameter("studentid"));
		ExamService examService = new ExamServiceImpl(); 
		ExamScore exam= examService.selectOne(studentid);
	%>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">이름</th>
				<th scope="col">학번</th>
				<th scope="col">국어</th>
				<th scope="col">영어</th>
				<th scope="col">수학</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><%=exam.getName()%></td>
				<td><%=exam.getStudentid()%></td>
				<td><%=exam.getKor()%></td>
				<td><%=exam.getEng()%></td>
				<td><%=exam.getMat()%></td>
			</tr>
		</tbody>
	</table>
	
</body>
</html>