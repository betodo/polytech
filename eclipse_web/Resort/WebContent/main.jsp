<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="javax.sql.*, java.net.*,java.io.*,java.sql.*,java.util.*"%>

<div class="container">
	<!-- 	<div style="height: 5vh"></div> -->
	<!-- 부트스트랩 활용 구현 -->
	<div id="carouselExampleIndicators" class="carousel slide"
		data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0"
				class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/resort.jpg" class="d-block w-100" alt="..."
					style="max-height: 50vh;">
			</div>
			<div class="carousel-item">
				<img src="img/resort2.jpg" class="d-block w-100" alt="..."
					style="max-height: 50vh;">
			</div>
			<div class="carousel-item">
				<img src="img/resort3.jpg" class="d-block w-100" alt="..."
					style="max-height: 50vh;">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators"
			role="button" data-slide="prev"> <span
			class="carousel-control-prev-icon" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
			role="button" data-slide="next"> <span
			class="carousel-control-next-icon" aria-hidden="true"></span> <span
			class="sr-only">Next</span>
		</a>
	</div>
	<br>
	<blockquote class="blockquote text-center" style="font-size: x-large;">
		<p class="mb-0">폴리 리조트에 오신걸 환영합니다.</p>
		<footer class="blockquote-footer">
			참 <cite title="Source Title">잘 왔어요</cite>
		</footer>
	</blockquote>
	<div class="card-deck" >
		<div class="card" >
			<img src="img/diningroom.jpg" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">멋진 식당</h5>
				<p class="card-text">맛있고 멋지고 5성에다가 6시 내고향에도 나오고 스타쉐프도 있고 연예인도
					많이오는 그런 식당</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card" >
			<img src="img/food.jpg" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">최고급 요리</h5>
				<p class="card-text">집나간 며느리도 돌아온다는 그런 음식, 잃어버린 미각을 찾아줄 그런 음식,
					한번 맛보면 잊지 못하는 그런 음식</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
		<div class="card" >
			<img src="img/show.jpg" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">고퀄 공연</h5>
				<p class="card-text">매주 수요일 토요일 열리는 공연, 국내외 내노라하는 스타군단이 공연,
					투숙객이면 무료, 놓치면 아깝</p>
				<p class="card-text">
					<small class="text-muted">Last updated 3 mins ago</small>
				</p>
			</div>
		</div>
	</div>
</div>