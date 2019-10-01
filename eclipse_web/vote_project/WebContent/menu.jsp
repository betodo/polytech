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
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	/* 메뉴바를 테이블을 이용해 스타일 설정 */
		div {
			padding-left:10px;
			padding-top:10px;
		}
		
		th {
			width: 8em;
			height: 3em;
            border: 1px solid;
            margin-right: 3em;
            border-color: blue;
            font-weight: bold;
        }
        .menu {
        	font-size: 1.6em;
        	color: black;
        	text-decoration: none;
        }
	</style>
	
</head>
<body>
	<div>
	<table>
	<!-- a링크 주소로 ?컨텐트 페이지를 지정하면 된다 -->
		<tr>
        <th id=enroll><a href="?contentPage=enroll.jsp" class=menu>후보등록</a></th>
        <th id=vote><a href="?contentPage=vote.jsp" class=menu>투표</a></th>
        <th id=analysis><a href="?contentPage=voteRate.jsp" class=menu>개표결과</a></th>
        </tr>
    </table>
    </div>
    <!-- 주소를 건너뛸 때 마다 배경색 노랑으로 채우기 id enroll인식위해 밑에다 -->
    <script type="text/javascript">
			//각 페이지가 보내는 컨텐트 페이지를 채온다
			var x = '<%=contentPage%>'; 
			const th1 = document.getElementById('enroll'); //각 th를 받아온다
			const th2 = document.getElementById('vote');
			const th3 = document.getElementById('analysis');
			
			const page_name = x.split('?')[0]; // 같이 넘기는 값이 있으면 나눠줌
			
			//현재 페이지가 저럴때마다 색깔 지정
			if (page_name === 'enroll.jsp') {
				th1.style.background = 'yellow';
			} else if (page_name === 'vote.jsp'){
				th2.style.background = 'yellow';
			} else if (page_name === 'voteRate.jsp'){
				th3.style.background = 'yellow';
			} else if (page_name === 'voteAge.jsp'){
				th3.style.background = 'yellow';
			} 
// 		}
		
	</script>
    
</body>
</html>