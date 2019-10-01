<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//관리자 로그인 유무에 따라 출력되는 메뉴가 있다
	String loginOK = null;
	loginOK = (String) session.getAttribute("login_ok");
%>
<!-- 부트스트랩의 네비게이션 바를 활용하여 구현 -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<!-- 로고 이미지를 누르면 인덱스로 감 -->
	<a class="navbar-brand" href="index.jsp"> <img src="img/logo.png"
		width="30" class="d-inline-block align-top" alt=""> POLYRESORT
	</a>
	<!-- 부트스트랩 네비게이션에서 토글러 활용하는 곳 여기선 안쓰인다 -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse" id="navbarSupportedContent">

		<ul class="navbar-nav mr-auto">
			<!-- 네비게이션메뉴1 -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 리조트소개 </a>
				<!-- 네비메뉴1의 하위 메뉴들 -->
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="?contentPage=main.jsp">폴리리조트</a> <a
						class="dropdown-item" href="?contentPage=VipRoom.html">VIP룸</a>
					<!-- 					<div class="dropdown-divider"></div> -->
					<a class="dropdown-item" href="?contentPage=normalRoom.html">일반룸</a>
					<a class="dropdown-item" href="?contentPage=ReasonableRoom.html">합리적인룸</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 찾아오기 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="?contentPage=Direction.html">찾아오는길</a>
					<a class="dropdown-item" href="?contentPage=PublicTransit.html">대중교통이용</a>
					<!-- 					<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a> -->
					<!-- 					<a class="dropdown-item" href="#" aria-disabled="true">자아용이용</a> -->
					<a class="nav-link disabled" href="#" tabindex="-1"
						aria-disabled="true">자가용이용</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 주변여행지 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="?contentPage=Sight1.html">높은 산</a> <a
						class="dropdown-item" href="?contentPage=Sight2.html">시원 해수욕장</a>
					<a class="dropdown-item" href="?contentPage=Sight3.html">따끈 온천</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 예약하기 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item"
						href="?contentPage=Reserve/Reserve_list.jsp">예약상황</a> <a
						class="dropdown-item"
						href="?contentPage=Reserve/Reserve_direct_insert.jsp">예약하기</a>
						<% if( loginOK != null && loginOK.equals("yes") ){ %>
						<a class="dropdown-item" href="?contentPage=Admin/adm_allview.jsp">관리자페이지</a>
						<a class="dropdown-item"
						href="?contentPage=Admin/logout.jsp">관리자로그아웃</a>
						<% }%>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> 리조트소식 </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="?contentPage=Gongji/Gongji_list.jsp">공지사항</a>
					<a class="dropdown-item"
						href="?contentPage=Comment/Comment_list.jsp">이용후기</a>
				</div></li>
			<!-- 			<li class="nav-item"><a class="nav-link" href="Login/login_test.jsp">로그인</a></li> -->


			<!-- 관리자 로그인이 되어서 세션이 기록되면 다음과 같은 네비메뉴를 출력 -->
			<% if( loginOK == null || !loginOK.equals("yes") ){ %>
				<button class="btn btn-outline-success" type="button"
					onclick="location.href='Admin/login_test.jsp'">로그인</button>
					
			<% }else if( loginOK != null && loginOK.equals("yes")){ %> 
				<button class="btn btn-outline-success" type="button"
					onclick="location.href='Admin/logout.jsp'">로그아웃</button>
					
			<% }else{%>
				<button class="btn btn-outline-success" type="button"
					onclick="location.href='Admin/logout.jsp'">로그아웃</button>
			<%} %>
		</ul>
	</div>

</nav>


<!-- </body> -->
<!-- </html> -->