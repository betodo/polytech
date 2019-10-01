<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 넘어오는 값 받아서 div에 배치할 것 지정하기
	String contentPage = request.getParameter("contentPage");
	if (contentPage == null) {
		//최초접속 위해
		contentPage = "stock_list.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>최초접속 index</title>
<!-- 프레임을 나누는 역할 -->
	<style type="text/css">
		/* 가운데 정렬을 위한 스타일 적용 */
		#wrap {
            height: 100vh;
            display: flex; /* 디스플레이를 플렉스로 준다 */
   			flex-direction: column; /* 위아래로 나뉘도록 */
   			/* align:center; */
   			/* justify-content: center; 두개다 있으면 한가운데 정렬 */
            align-items: center;
		}

		#main{
			height: 80vh;
			text-align: center; /* 안의 내용물들이 중앙절렬 되도록 */
		}
	</style>

</head>
<body>
	<div id="wrap">
		<div id=main>
			<jsp:include page="<%=contentPage %>"></jsp:include>
		</div>
</body>
</html>