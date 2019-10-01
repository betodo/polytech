<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kopo.service.ExamService,kopo.service.ExamServiceImpl,kopo.dto.ExamScore" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 Insert</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="mystyle.css" >
</head>
<body>
	<h3>데이터 Insert</h3>
	<hr>
	<%
		ExamService examService = new ExamServiceImpl();
		examService.create(new ExamScore("나연",209901,91,100,95));
		examService.create(new ExamScore("정연",209902,92,100,95));
		examService.create(new ExamScore("모모",209903,93,100,95));
		examService.create(new ExamScore("사나",209904,94,100,95));
		examService.create(new ExamScore("지효",209905,80,100,95));
		examService.create(new ExamScore("미나",209906,96,100,95));
		examService.create(new ExamScore("다현",209907,97,100,95));
		examService.create(new ExamScore("채영",209908,98,100,95));
		examService.create(new ExamScore("쯔위",209909,99,100,95));
	%>
	
</body>
</html>