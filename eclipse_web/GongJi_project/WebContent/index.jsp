<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 넘어오는 값 받아서 div에 배치할 것 지정하기
	String contentPage = request.getParameter("contentPage");
	if (contentPage == null) {
		contentPage = "gongji_list.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최조 진입화면</title>
	<style type="text/css">
		/* 가운데 정렬을 위한 스타일 적용 */
		#wrap {
            height: 100vh;
            display: flex; /* 디스플레이를 플렉스로 준다 */
   			flex-direction: column;
   			align:center;
		}
		#menu{
			text-align: center;
			height: 10vh;
		}
		#main{
			height: 80vh;
		}
	</style>
</head>
<body>
	<!-- 제목과 내용페이지를 2로 나눔 -->
	<div id="wrap">
		<div id="menu"><h1>공지사항</h1></div>
		<div id=main>
			<jsp:include page="<%=contentPage %>"></jsp:include>
		</div>
	</div>
</body>
</html>