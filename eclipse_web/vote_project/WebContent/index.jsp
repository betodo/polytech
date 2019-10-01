<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 넘어오는 값 받아서 div에 배치할 것 지정하기
	String contentPage = request.getParameter("contentPage");
	if (contentPage == null) {
		contentPage = "intro.jsp";
	}
%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<style>
		/* 전체를 감싸기 위해 컨테이너 사용 */
		#container{
            height: 100vh;
            display: flex;
   			flex-direction: column;
		}
		#menu{
			height:10vh;
		}
		#main{
			height: 80vh;
		}
	</style>
<head>
<title>처음 시작(레이아웃 나누는 index.jsp)</title>
</head>
<body>
	<div id="container">
		<div id="menu">
			<!-- jsp:include사용 지정한 페이지가 박힌다. -->
			<jsp:include page="menu.jsp"></jsp:include>
		</div>
		<div id=main>
			<jsp:include page="<%=contentPage %>"></jsp:include>
		</div>
	</div>
</body>
</html>