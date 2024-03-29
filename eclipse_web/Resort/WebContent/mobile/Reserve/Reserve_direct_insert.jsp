<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>	
<%@ page import="java.sql.*,useDB.UseDB_Reserve,java.io.*"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%
	//input date 날짜 시작 끝 구하기
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String startDate = sdf.format(cal.getTime());
	cal.add(cal.MONTH, +1);
	cal.add(cal.DATE, -1);
	String endDate = sdf.format(cal.getTime());	
	
%>
<script type="text/javascript">
	//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여
	function submitForm(mode) {
		/* const fm = document.getElementById("fm"); */
		if (mode == 'write') {
			const date = document.getElementById('inputDate');
			const room = document.getElementById('inputRoom');
			
// 			console.log(name, room);

			//값이 널일때 잡음
			if (date.value.trim() == "") {
				alert("날짜를 선택해주세요");
				return;
			} 
			if (room.value.trim() == "") {
				alert("방을 선택해주세요");
				return;
			} 

			fm.action = "?contentPage=Reserve/Reserve_able_decide.jsp";
			//fm.submit();
		} else if (mode == 'cancle') {
			fm.action = "?contentPage=Reserve/Reserve_list.jsp";
			//window.history.go(-1);
		}
			fm.submit();
		
	}
</script>

<div class="container">
	<form method="POST" id=fm>
		<table id="basicTB" width="100%">
			<thead>
				<tr>
					<th colspan=2>예약일, 방선택</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>예약날짜</th>
					<td>
						<input type="date" name="date" id="inputDate" min='<%=startDate %>' max='<%=endDate %>' > 
						오늘부터 한달 후 까지만 예약가능 합니다.
					</td>
				</tr>
				<tr>
					<th>예약방</th>
					<td><select name="room" id="inputRoom">
							<option value="">방선택</option>
							<option value="1">vip룸</option>
							<option value="2">일반룸</option>
							<option value="3">합리룸</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name=startDate value=<%=startDate %>>
		<input type="hidden" name=endDate value=<%=endDate %>>
		<br>
		<div id="divButton" style="width: 100%; text-align: right;">
			<span><input class="btn btn-success" type="button" value=취소
				id=cancle onclick='submitForm("cancle")'></span> <span><input
				class="btn btn-success" type="button" value=선택 id=write
				onclick='submitForm("write")'></span>
		</div>
	</form>
</div>

