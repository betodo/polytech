<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.net.URLDecoder"%>
<%
	/* String loginOK = null;
	String jumpURL = "login.jsp?jump=index.jsp";
	loginOK = (String) session.getAttribute("login_ok"); */
	
	
	///////////////////////////////////////////////////////////

	// 넘어오는 값 받아서 div에 배치할 것 지정하기
	String contentPage = request.getParameter("contentPage");

	//마지막 방문일 인덱스에서만 출력하도록 boolean 변수
	boolean lastDatePrint = false; // fasle면 출력 안함
	if (contentPage == null) {
		//최초접속 위해
		contentPage = "main.jsp";
		lastDatePrint = true; //최초 인덱스 접속 시에만 마지막 방문시각 출력
	}

	//최근 방문시간 기록(쿠키저장처리)

	// 마지막 방문일을 저장하고 있는 쿠키를 저장할 객체
	Cookie lastDate = null;

	// 화면에 출력할 메시지를 저장할 문자열 변수
	String msg = "";

	// 마지막 방문일을 저장하고 있는 쿠키가 존재하는지를 판별할 변수
	boolean bln_cookie = false;

	//현재시간을 저장
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	//out.print(sdf.format(cal.getTime()));

	String curTime = URLEncoder.encode(sdf.format(cal.getTime()), "UTF-8");

	// 쿠키를 얻는다.
	Cookie[] cookies = request.getCookies();

	// 마지막 방문 일을 정하고 있는 쿠키를 검색
	if (cookies != null) {

		for (int i = 0; i < cookies.length; i++) {

			lastDate = cookies[i];

			// 			out.print("울랄라");
			// 			out.print(lastDate.getName() + "<br>");
			// 			out.print(lastDate.getValue() + "<br>");

			if (lastDate.getName().equals("lastdateCookie")) {

				bln_cookie = true;
				break;
			}
		}
	}

	// 처음 방문일 경우 새 쿠키 생성
	if (!bln_cookie) { // if (bln_cookie = false)

		msg = "처음 방문 입니다.";

		// 쿠키 객체를 생성
		lastDate = new Cookie("lastdateCookie", curTime);

		// 쿠키 속성값을 설정
		lastDate.setMaxAge(365 * 24 * 60 * 60); // 365일
		lastDate.setPath("/");

		// 쿠키를 추가
		response.addCookie(lastDate);

		// 		out.print("야호");
		// 		out.print(lastDate.getName() + "<br>");
		// 		out.print(lastDate.getValue() + "<br>");

	}

	else { // 이미 방문한 적이 있는 클라이언트라면

		msg = "최근 방문일은 " + URLDecoder.decode(lastDate.getValue(), "UTF-8") + "입니다.";

		// 쿠키에 새 값을 추가
		lastDate.setValue(curTime);
		lastDate.setMaxAge(365 * 24 * 60 * 60);
		// 쿠키를 추가
		response.addCookie(lastDate);

	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>

<!-- 부트 스트랩 사용 링크(헤드에 있어야함) -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<!-- include libraries(jQuery, bootstrap) -->
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

<!-- include summernote css/js  섬머노트 사용 링크-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
<style>
/* 여러 페이지에서 사용되는 스타일들 동시 적용 하려고 css파일 임포트 */
@import url(CSS/Basic_table.css);

@import url(CSS/Pagination.css);
/* @import url(‘mystyle.css’); 로 해도 됨 */
/* @import “mystyle.css”;로 해도 됨 */
</style>



<!-- 프레임을 나누는 역할 -->
<style type="text/css">
/* 가운데 정렬을 위한 스타일 적용 */
#wrapp {
	height: 100vh;
	display: flex; /* 디스플레이를 플렉스로 준다 */
	flex-direction: column; /* 위아래로 나뉘도록 */
	/* align:center; */
	/* justify-content: center; 두개다 있으면 한가운데 정렬 */
	/* align-items: center; */
}
#menuu {
	/*   			line-height:10vh; */
	/* 			vertical-align: center; */
	/* 			justify-content: center; */
	/*   			height: 10vh;   */
}
#mainn {
	/* 	display: flex; */
	/*  			justify-content: center;  */
	/*  			align-items: center;  */
	/*    			height: 100vh;      */
	/*  			overflow: auto;   */
	
}

#title {
	width: 100%;
}

#tdContent {
	width: 90%;
	height: 35vh;
}

.rsv_input {
	width: 100%;
}

.rsv_td {
	width: 20%;
}
address{
	font-style: italic;
	padding-left: 2em;
    color: ghostwhite;
    background-color: black;
}
</style>
</head>
<body>
	<div id="wrapp">
		<header id="menuu">
			<jsp:include page="menu2.jsp"></jsp:include> <!-- 상단 메뉴바 -->
		</header>
		<br> <br> 
		<div id="mainn">
			<jsp:include page="<%=contentPage%>"></jsp:include> <!-- 화면전환 -->
		</div>
		<br> <br>
		<footer>
			<!--마지막 방문일 표시 일단 display none으로 해주고 js함수로 조건에 맞게 표시  -->
			<h3 id="lastDateCookie" align=center style='display: none;'><%=msg%></h3>
			<!-- 모든 페이지에 적용되는 하단 주소정보 -->
			<address>경기도 성남시 분당구 황새울로329번길 5 (서현동, 한국폴리텍대학 융합기술교육원)<br>
			5, Hwangsaeul-ro 329beon-gil, Bundang-gu, Seongnam-si, Gyeonggi-do, Republic of Korea<br>
			P: (123) 456-7890
			</address>
		</footer>
	</div>
<script type="text/javascript">
	//최근 방문일표시가 true면 display none을 지워서 표시해줌
	var lastDatePrint = <%=lastDatePrint%>
	var obj = document.getElementById("lastDateCookie")
	if (lastDatePrint) {
		obj.style.display = '';
	}
</script>

	<!-- 부트스트랩 사용에 필요한 코드 바디 마지막에 필요 -->
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