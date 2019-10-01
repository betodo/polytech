<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page import="java.sql.*,useDB.UseDB_Reserve,java.io.*"%>
<%@ page import="java.util.List, java.util.ArrayList"%>

<%
	//값받기(목록에서 클릭 했을 때 받아온 값)
	String rsv_date = request.getParameter("day");
	int room = Integer.parseInt(request.getParameter("room"));
	
	//수정에서 예약일과 방을 바꿀 경우 원래 값
	String OGrsv_date = request.getParameter("day");
	int OGroom = Integer.parseInt(request.getParameter("room"));
	
	boolean is_change_date_room = false; //날짜와 방을 바꿨는지 알기위한 변수 false면 날짜 방을 안 바꿨음

	//db연결 예약목록과 실제 db저장된 예약내용을 비교하기
	UseDB_Reserve udbR = new UseDB_Reserve();
	ResultSet rset = udbR.selectOneRsv(rsv_date, room);

	// 방번호에 따른 이름
	String roomName = "";
	switch (room) {
		case 1 :
			roomName = "vip룸";
			break;
		case 2 :
			roomName = "합리룸";
			break;
		case 3 :
			roomName = "일반룸";
			break;
	}

	rset.next();
	String name = rset.getString(1);
	String addr = rset.getString(4);
	String phone_num = rset.getString(5);
	String deposit_name = rset.getString(6);
	String comment = rset.getString(7);
	String write_date = rset.getString(8);
	int processing = rset.getInt(9);

	// 처리상태번호에 따른 이름
	String processingName = "";
	switch (processing) {
		case 1 :
			processingName = "예약완료";
			break;
		case 2 :
			processingName = "입금완료";
			break;
		case 3 :
			processingName = "환불요청";
			break;
	}

	//input date 날짜 시작 끝 구하기
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String startDate = sdf.format(cal.getTime());
	cal.add(cal.MONTH, +1);
	String endDate = sdf.format(cal.getTime());
%>
<script type="text/javascript">
	function submitForm(mode) {
		if (mode == 'update') {//변경버튼 눌렀을때
			const name = document.getElementById('name');
			const rsvDate = document.getElementById('inputDate');
			const room = document.getElementById('inputRoom');
			const processing = document.getElementById('inputProcessing');
			
			//최소 필요한 값이 널일때 잡음
			if (name.value.trim() == "" || rsvDate.value.trim() == "" 
					|| room.value.trim() == "" || processing.value.trim() == "") {
				alert("값을 입력해주세요");
				return;
			} 
			
			//기존의 예약일과 방을 바꿨을때를 알기위해
			if(rsvDate.value.trim()=='<%=rsv_date%>' && room.value.trim()==<%=room%>){
				fm.action = "?contentPage=Admin/adm_update.jsp?change=false";
			}else {
				fm.action = "?contentPage=Admin/adm_update.jsp?change=true";
				
			}
			
		} else if (mode == 'cancle') { //취소버튼 눌렀을때
			fm.action = "?contentPage=Admin/adm_allview.jsp";

		} else if (mode == 'delete') { //삭제버튼 눌렀을때
			const rsvDate = document.getElementById('inputDate');
			const room = document.getElementById('inputRoom');
			
			
			if (rsvDate.value.trim() == "" || room.value.trim() == "" ) {
				alert("값을 입력해주세요");
				return;
			}
		
			//입력한 값과 기존의 클릭해서 받아온 값 비교
			if(rsvDate.value.trim()!='<%=rsv_date%>' || room.value.trim()!=<%=room%>){
		
				alert("예약을 삭제할꺼면 예약일과 방을 바꾸지마세요");
				return;
			}
			
			fm.action = "?contentPage=Admin/adm_delete.jsp";
		}
		fm.submit();
	}
</script>
<div class="container">
	<form method="POST" id=fm>
		<input type="hidden" name=OGrsv_date value=<%=OGrsv_date %>>
		<input type="hidden" name=OGroom value=<%=OGroom %>>
		<table id="basicTB" width="100%">
			<thead>
				<tr>
					<th colspan=2>예약 조회</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>이름</th>
					<td><input class="rsv_input" type="text" name="name" id='name'
						value="<%=name%>" maxlength="20"></td>
				</tr>
				<tr>
					<th>예약일자</th>
					<td><input type="date" name="date" id="inputDate" 
					value="<%=rsv_date%>" min='<%=startDate %>' max='<%=endDate %>' > 
						오늘부터 한달 후 까지만 변경가능 합니다.</td>
				</tr>
				<tr>
					<th>예약방</th>
					<td><select name="room" id="inputRoom">
							<option value="<%=room%>"><%=roomName %></option>
							<option value="1">vip룸</option>
							<option value="2">일반룸</option>
							<option value="3">합리룸</option>
					</select></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input class="rsv_input" type="text" name="addr" id='addr'
						value="<%=addr%>" maxlength="100"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input class="rsv_input" type="text" name="phone_num" value="<%=phone_num%>"
						id='phone_num' maxlength="12" onKeyup="this.value=this.value.replace(/[^0-9]/g,'');"></td>
				</tr>
				<tr>
					<th>입금자</th>
					<td><input class="rsv_input" type="text" name="deposit"
						value="<%=deposit_name%>" id='deposit' maxlength="20"></td>
				</tr>
				<tr>
					<th>전하실 말</th>
					<td><textarea id="rsv_comment" name="rsv_comment" wrap="hard"
							value="<%=comment%>"  maxlength="200" style="width: 100%;"></textarea></td>
				</tr>
				<tr>
					<th>예약 작성일</th>
					<td><input class="rsv_input" type="date" name="write_date"
						value="<%=write_date%>" id='deposit'></td>
				</tr>
				<tr>
					<th>예약 상황</th>
					<td><select name="processing" id="inputProcessing">
							<option value="<%=processing%>"><%=processingName %></option>
							<option value="1">예약완료</option>
							<option value="2">입금완료</option>
							<option value="3">환불요청</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name=startDate value=<%=startDate %>>
		<input type="hidden" name=endDate value=<%=endDate %>>
		<br>
		<div id="divButton" style="width: 100%; text-align: right;">
			<span><input class="btn btn-success" type="button" value=취소
				id=cancle onclick='submitForm("cancle")'></span>
			<span><input
				class="btn btn-success" type="button" value=변경 id=write
				onclick='submitForm("update")'></span> 
			<span><input
				class="btn btn-success" type="button" value=삭제 id=write
				onclick='submitForm("delete")'></span>
		</div>
	</form>
</div>
<%
	rset.close();
	udbR.close();
%>