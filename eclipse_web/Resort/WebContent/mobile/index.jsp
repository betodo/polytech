<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
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

<!-- 서버에 캐시를 저장하지 않고 정보필요할때마다 서버에 접속 정보를 가져온다 -->
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" /><!-- 캐시만료일 지정 -->
<meta http-equiv="Pragma" content="no-cache" />

<!-- jsp인클루드로 박는 값들에 부트스트랩 적용 -->
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



<script type="text/javascript">
	//좌우 회전, 화면 크기 변경 대응
	var orientationEvent;
	var uAgent = navigator.userAgent.toLowerCase();
	var mobilePhones = 'android';
	if (uAgent.indexOf(mobilePhones) != -1) {
		orientationEvent = "resize"; //안드로이드는 resize로 들어옴
	} else
		orientationEvent = "orientationchange"; //아이폰은 이렇게 들어옴
		//이벤트(화면돌리는거) 실행되면
	window.addEventListener(orientationEvent, function() {
		//	alert("회전했어요");
		location.href('#');//재부팅해서 다시 넓이같으거 계산해서 출력
	}, false); //false=버블단계 window에 이벤트는 캡쳐단계와 버블단계 둘중 하나에 걸림 교안 3-2강내용

	
	//스크린 나오는 함수
	var prevScreen = 0;
	var sv_prevScreen = 0;
	function prevShow() {
		ScreenShow(prevScreen);
	}

	var muCnt = 5;//서브메뉴
	var scCnt = 14;//화면

	function fncShow(pos) {

		var i = 0;

		//모든 일반 화면 막는다.
		for (i = 0; i < scCnt; i++) {
			var obj = document.getElementById("s" + i);
			obj.style.display = 'none';
		}

		//메뉴선택에 따라 중간메뉴 div는 보여주고, 누른 버튼의 배경을 바꿔준다
		for (i = 0; i < muCnt; i++) {
			var obj = document.getElementById("menu" + i);
			var obj2 = document.getElementById("m" + i);

			if (i == pos) {
				obj.style.display = '';
				obj2.style.background = "#ff0000";
			} else {
				obj.style.display = 'none';
				obj2.style.background = "#FFFF00";
			}
		}
	}

	//총 화면은 14개이고 화면이 선택된 번호에 따라 화면을 보여주는 함수
	var scCnt = 14;
	var ScrObj;
	var timer1;

	function ScrAnimation() {
		var offset = -50;
		if (parseInt(ScrObj.style.left) > 10) {

			ScrObj.style.left = parseInt(ScrObj.style.left) + offset + "px";
			timer1 = setTimeout("ScrAnimation()", 1);

		} else {
			ScrObj.style.left = 5;
			clearTimeout(timer1);
		}
	}
	//화면이 선택된 번호에 따라 화면을 보여주는 함수
	function ScreenShow(pos) {

		var i = 0;
		//모든 메뉴페이지는 막는다
		for (i = 0; i < muCnt; i++) {
			var obj = document.getElementById("menu" + i);
			obj.style.display = 'none';
		}

		//선택된 하면 번호의 화면만 보여준다.
		for (i = 0; i < scCnt; i++) {
			var obj = document.getElementById("s" + i);

			if (i == pos) {

				prevScreen = sv_prevScreen;
				sv_prevScreen = i;
				obj.style.display = '';

				obj.style.position = "relative";
				obj.style.top = 35;
				obj.style.left = screen.width;
				obj.style.height = screen.height - 120;

				ScrObj = obj;
				ScrAnimation();
			} else {
				obj.style.display = 'none';
			}
		}
	}
</script>

<style type="text/css">
li {
	text-align: left;
	vertical-align: middle;
	margin: 2;
	padding: 10;
	height: 20;
	background-color: #aaaa00;
	border: 2px solid red;
	font-size: 16px;
}

ul {
	text-align: left;
	vertical-align: middle;
	margin: 2;
	padding: 10;
	height: 20;
	background-color: #bbaabb;
	border: 2px solid red;
	font-size: 16px;
}

/* 기본 웹페이지를 상단 중단 하단으로 나누고 상하단을 고정 중단은 오버플로우로 스크롤 가능하게한다 */
#container {
	height: 100vh;
	display: flex; /* 디스플레이를 플렉스로 준다 */
	flex-direction: column;
}

#head {
	height: 7vh;
}

#contents {
	height: 81vh;
	overflow: auto;
}

#foot {
	height: 11vh;
}
</style>


<title>m.Resort</title>
</head>
<body onload='ScreenShow(0);'>
	<center>
		<div id="container"
			style="width: device-width; height: device-height;">

			<!-- 헤더  고정된다 -->
			<div id="head">
				<div id="header1"
					style="background-color: #00FFFF; height: 35px; width: 15%; float: left;"
					onclick="prevShow();">
					<center>
						<img src="img/back_btn.png" width="40px" height="32px">
					</center>
				</div>
				<div id="header2"
					style="background-color: #00FFFF; height: 35px; width: 70%; float: left;">
					<center style="margin: 10px">
						<B>폴리 리조트</B>
					</center>
				</div>
				<div id="header3"
					style="background-color: #00FFFF; height: 35px; width: 15%; float: left;"
					onclick="ScreenShow(0);">
					<center>
						<img src="img/home_btn.png" width="30px" height="32px">
					</center>
				</div>
			</div>

			<!-- 메뉴화면 기본적으로 display가 none인 상태-->
			<div id="menu0"
				style="background-color: #EEEEEE; display: none; width: device-width;">
				리조트 소개
				<li onclick='ScreenShow(0);'>폴리리조트</li>
				<li onclick='ScreenShow(1);'>vip룸</li>
				<li onclick='ScreenShow(2);'>일반룸</li>
				<li onclick='ScreenShow(3);'>합리룸</li> <br>
			</div>
			<div id="menu1"
				style="background-color: #EEEEEE; display: none; width: device-width;">
				찾아오기
				<li onclick='ScreenShow(4);'>찾아오는길</li>
				<li onclick='ScreenShow(5);'>대중교통이용</li>
				<li onclick='ScreenShow(6);'>자가용이용</li> <br>
			</div>
			<div id="menu2"
				style="background-color: #EEEEEE; display: none; width: device-width;">
				주변명소
				<li onclick='ScreenShow(7);'>높아산</li>
				<li onclick='ScreenShow(8);'>시원해수용작</li>
				<li onclick='ScreenShow(9);'>따근온천</li> <br>
			</div>
			<div id="menu3"
				style="background-color: #EEEEEE; display: none; width: device-width;">
				예약하기
				<li onclick='ScreenShow(10);'>예약상황</li>
				<li onclick='ScreenShow(11);'>예약하기</li> <br>
			</div>
			<div id="menu4"
				style="background-color: #EEEEEE; display: none; width: device-width;">
				리조트소식
				<li onclick='ScreenShow(12);'>공지사항</li>
				<li onclick='ScreenShow(13);'>이용후기</li> <br>
			</div>

			<!-- 화면 부 메뉴클릭시 뜬다 -->
			<div id="contents">
				<div id="s0" style="display: none; width: device-width;overflow: overlay;">
				
					<!-- 정적 페이지는 jsp인클루드로 불러옴 부트스트랩으로 이미 반응형 크기이다. -->
					<jsp:include page="../main.jsp"></jsp:include>
				</div>
				<div id="s1" style="display: none; width: device-width;">
					<jsp:include page="../VipRoom.html"></jsp:include>
				</div>
				<div id="s2" style="display: none; width: device-width;">
					<jsp:include page="../normalRoom.html"></jsp:include>
				</div>
				<div id="s3" style="display: none; width: device-width;">
					<jsp:include page="../ReasonableRoom.html"></jsp:include>
				</div>
				<div id="s4" style="display: none; width: device-width;">
					<jsp:include page="mDirection.html"></jsp:include>
				</div>
				<div id="s5" style="display: none; width: device-width;">
					<jsp:include page="mPublicTransit.html"></jsp:include>
				</div>
				<div id="s6" style="display: none; width: device-width;">
					<br>
					<h1>현재 주차장 바닥 공사로 가급적 대중교통을 이용해 주시기 바랍니다</h1>
					<br> <br>
					<h2>죄송합니다. 빠른 시일내로 정상화 하겠습니다.</h2>
				</div>
				<div id="s7" style="display: none; width: device-width;">
					<jsp:include page="../Sight1.html"></jsp:include>
				</div>
				<div id="s8" style="display: none; width: device-width;">
					<jsp:include page="../Sight2.html"></jsp:include>
				</div>
				<div id="s9" style="display: none; width: device-width;">
					<jsp:include page="../Sight3.html"></jsp:include>
				</div>
				<div id="s10" style="display: none; width: device-width;">
					<!-- 					<iframe src="mReserve.jsp" frameborder="0" border="0" -->
					<!-- 						bordercolor="white" width="320px" height="420px" margin-width="0" -->
					<!-- 						margin-height="0" scroling="yes">예약상황</iframe> -->
					
					<!-- 예약 공지 이용후기는 iframe을 활용하여 한다. -->
					<iframe src="mReserve.jsp" frameborder="0" border="0"
						bordercolor="white" margin-width="0"
						style="width: -webkit-fill-available; height: -webkit-fill-available;"
						margin-height="0" scroling="yes">예약상황</iframe>

				</div>
				<div id="s11" style="display: none; width: device-width;">
					<iframe src="mReserve.jsp?contentPage=Reserve/Reserve_direct_insert.jsp" frameborder="0" border="0" bordercolor="white"
						margin-width="0" margin-height="0"
						style="width: -webkit-fill-available; height: -webkit-fill-available;"
						scroling="yes">예약하기</iframe>
				</div>
				<div id="s12" style="display: none; width: device-width;">
					<iframe src="mNotification.jsp" frameborder="0" border="0" bordercolor="white"
						margin-width="0" margin-height="0"
						style="width: -webkit-fill-available; height: -webkit-fill-available;"
						scroling="yes">공지사항</iframe>
				</div>
				<div id="s13" style="display: none; width: device-width;">
					<iframe src="mComment.jsp" frameborder="0" border="0" bordercolor="white"
						margin-width="0" margin-height="0"
						style="width: -webkit-fill-available; height: -webkit-fill-available;"
						scroling="yes">이용후기</iframe>
				</div>
			</div>

			<!-- footer 하단의 메뉴 고정 클릭시마다 fncshow함수가 실행된다.-->
			<!-- 포지션을 absolute로 주었기 때문에 하단에 고정되고 left를 %주어 넓이는 반응형으로 함 -->
			<div id="foot">
				<div id="m0" onclick='fncShow(0);'
					style="position: absolute; bottom: 3px; position: absolute; left: 1%; background-color: #FF0000; height: 60px; width: 18%; float: left;">
					<center>
						<img src="img/m1_btn.png" width="40px" height="40px"><br>
						<font size=1.5>리조트소개</font>
					</center>
				</div>
				<div id="m1" onclick='fncShow(1);'
					style="position: absolute; bottom: 3px; position: absolute; left: 21%; background-color: #FF0000; height: 60px; width: 18%; float: left;">
					<center>
						<img src="img/m2_btn.png" width="40px" height="40px"><br>
						<font size=1.5>찾아오기</font>
					</center>
				</div>
				<div id="m2" onclick='fncShow(2);'
					style="position: absolute; bottom: 3px; position: absolute; left: 41%; background-color: #FF0000; height: 60px; width: 18%; float: left;">
					<center>
						<img src="img/m3_btn.png" width="40px" height="40px"><br>
						<font size=1.5>주변명소</font>
					</center>
				</div>
				<div id="m3" onclick='fncShow(3);'
					style="position: absolute; bottom: 3px; position: absolute; left: 61%; background-color: #FF0000; height: 60px; width: 18%; float: left;">
					<center>
						<img src="img/m4_btn.png" width="40px" height="40px"><br>
						<font size=1.5>예약하기</font>
					</center>
				</div>
				<div id="m4" onclick='fncShow(4);'
					style="position: absolute; bottom: 3px; position: absolute; left: 81%; background-color: #FF0000; height: 60px; width: 18%; float: left;">
					<center>
						<img src="img/m5_btn.png" width="40px" height="40px"><br>
						<font size=1.5>리조트소식</font>
					</center>
				</div>
			</div>
		</div>
	</center>


	<!-- jsp인클루드로 박는 값들에 부트스트랩 적용 -->
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