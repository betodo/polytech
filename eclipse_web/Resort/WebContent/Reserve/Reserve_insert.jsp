<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//관리자페이지에서 접근했을때 값 받기
	String key = null;
	if (key == null) key = request.getParameter("key");
	else key = "";
	
	//out.print(key);
	
	//예약상황표에서 가능 예약일과 방 클릭시 값 받기
	request.setCharacterEncoding("UTF-8");
	String day = request.getParameter("day");
	String roomTemp = request.getParameter("room");
	int room = Integer.parseInt(roomTemp);
	
	// 방번호에 따른 이름
	String roomName ="";
	switch(room){  
		case 1: roomName = "vip룸"; break;
		case 2: roomName = "합리룸"; break;
		case 3: roomName = "일반룸"; break;
	}
	
%>
<script type="text/javascript">
	//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여
	function submitForm(mode) {
		/* const fm = document.getElementById("fm"); */
		//예약버튼 클릭시
		if (mode == 'write') {
			const name = document.getElementById('name');
			const phone_num = document.getElementById('phone_num');
			
// 			console.log(name, room);

			//값이 널일때 잡음
			if (name.value.trim() == "") {
				alert("이름을 입력해주세요");
				return;
			} 
// 			if(phone_num.value.lenth>12){
// 				alert("번호는 11자리 이내로")
// 				return;
// 			}
// 			else if (content.value.trim().length > 500) {
// 				alert("글은 500자 이내");
// 				return;
// 			}
			//action을 지정해준다 key는 관리자 권한으로 들어올때 필요한 변수
			fm.action = "?contentPage=Reserve/Reserve_write.jsp?key=<%=key %>";

		//취소 버튼 클릭시 역시 관리자 권한으로 들어왔을때 구분을 위해 key존재
		} else if (mode == 'cancle') {
			
			if(<%=key%>=='adm'){
				fm.action = "?contentPage=Admin/adm_allview.jsp";
			}else{
				fm.action = "?contentPage=Reserve/Reserve_list.jsp";
			}
			//window.history.go(-1); 
		} 
			fm.submit();
	}
</script>
<div class="container">
	<!-- 여기서 입력받는 모든 값을 넘겨줘서 db쿼리에 사용 -->
	<form method="POST" id=fm>
		<input type="hidden" name=rsv_date value="<%=day %>"><!-- 예약일 -->
		<table id="basicTB" width="100%">
			<thead>
				<tr>
					<th colspan=2>예약글 작성</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>이름</th><!-- 예약자 -->
					<td><input class="rsv_input" type="text" name="name" id='name'
						maxlength="20"></td>
				</tr>
				<tr>
					<th>예약일자</th>
					<td><%=day%></td>
				</tr>
				<tr>
					<th>예약방</th>
					<td><%=roomName %>
					<input type="hidden" name=room value="<%=room %>">
					<!-- <select name="room" id="room">
							<option value="">방선택</option>
							<option value="1">vip룸</option>
							<option value="2">일반룸</option>
							<option value="3">합리룸</option>
					</select> -->
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input class="rsv_input" type="text" name="addr" id='addr'
						maxlength="100"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input class="rsv_input" type="text" name="phone_num"
						id='phone_num' maxlength="12" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></td>
				</tr>
				<tr>
					<th>입금자</th>
					<td><input class="rsv_input" type="text" name="deposit"
						id='deposit' maxlength="20"></td>
				</tr>
				<tr>
					<th>전하실 말</th>
					<td><textarea id="rsv_comment" name="rsv_comment" wrap="hard"
							maxlength="200" style="width: 100%;"></textarea></td>
				</tr>
			</tbody>
		</table>
		<br>
		<div id="divButton" style="width: 100%; text-align: right;">
			<span><input class="btn btn-success" type="button" value=취소
				id=cancle onclick='submitForm("cancle")'></span> <span><input
				class="btn btn-success" type="button" value=예약 id=write
				onclick='submitForm("write")'></span>
		</div>
	</form>
</div>