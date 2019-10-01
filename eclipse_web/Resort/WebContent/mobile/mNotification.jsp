<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//넘어오는 값 받아서 div에 배치할 것 지정하기
	String contentPage = request.getParameter("contentPage");

	if (contentPage == null) {
		//최초접속 위해
		contentPage = "Gongji/Gongji_list.jsp";

	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- 페이지 크기 제어 사파리용 -->
<meta name="viewport" content="user-scable= no, width=device-width" />
<!-- Safari UI(URL Bar, Button Bar) 없애기 및 변경하기 -->
<meta name=”apple-mobile-web-app-capable” content=”yes” />
<meta name=”apple-mobile-web-app-status-bar-style” content=”black” />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-chache" />

<title>모바일 공지</title>

<!-- 부트스트랩 사용 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- include libraries(jQuery, bootstrap) -->
<!-- 부트스트랩 제대로 돌아가려면 이거 필요 min 말고-->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js -->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<style>
@import url(CSS/Basic_table.css);

@import url(CSS/mPagination.css);
</style>
</head>

<body>
	<div>
		<jsp:include page="<%=contentPage%>"></jsp:include>
	</div>
</body>
</html>