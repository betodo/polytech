<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Reserve,java.io.*"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%
	request.setCharacterEncoding("UTF-8"); //한글 안먹음 왜?

	String rsv_date = "";//값 받을 변수 초기화
	int room = 0;
	boolean rsv_able = true; //예약가능 여부 변수
	UseDB_Reserve udbR = new UseDB_Reserve();//예약가능 여부 확인 위한 디비비교 준비

	//받은 값과 db를 비교하여 예야가능여부 판별
	//if(request.getParameter("date") != null && request.getParameter("room") != null){
	rsv_date = request.getParameter("date");
	room = Integer.parseInt(request.getParameter("room"));
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	//디비에서 선택된 날짜비교
	ResultSet rset = udbR.selectOneYearReserve(startDate, endDate);

	if (rset.next()) {
		rset.beforeFirst();
		while (rset.next()) {

			if (rsv_date.equals(rset.getString(1)) && room == rset.getInt(2)) {
				rsv_able = false;
 				break;			
			}
		}
	}
	rset.close();
	udbR.close();

%>

<script type="text/javascript">
function submitForm(mode) {
	
	/* const fm = document.getElementById("fm"); */
	if (mode == 'write') {
		fmm.action = "?contentPage=Reserve/Reserve_insert.jsp";

	} else if (mode == 'cancle') {
		fmm.action = "?contentPage=Reserve/Reserve_direct_insert.jsp";
		
	}
	fmm.submit();
}
</script>


<div class="container">
<%
	if (rsv_able == false) {
		// 방번호에 따른 이름
		String roomName ="";
		switch(room){  
			case 1: roomName = "vip룸"; break;
			case 2: roomName = "vip룸"; break;
			case 3: roomName = "vip룸"; break;
		}
		
%>
			<table id="basicTB" width="100%">
				<thead>
					<tr>
						<th colspan=2>예약 가능 여부</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							죄송합니다. <%=rsv_date %> , <%=roomName %>은 이미 예약 되었습니다. 다른 일자 또는 방을 선택해 주세요
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			
			<form method='post' action ="?contentPage=Reserve/Reserve_direct_insert.jsp">
				<div id="divButton" style="width: 100%; text-align: right;">
				<span><input class="btn btn-success" type="submit" value=뒤로
				></span> 
				</div>
			</form>
<%
	} else if(rsv_able == true){
%>
		<table id="basicTB" width="100%">
				<thead>
					<tr>
						<th colspan=2>예약 가능 여부</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							예약 가능합니다. 예약자 정보를 입력해 주세요
						</td>
					</tr>
				</tbody>
			</table>
			<br>
			<form id=fmm name='fmm' method='post'>
				<input type="hidden" name=day value="<%=rsv_date %>">
				<input type="hidden" name=room value="<%=room %>">
				<div id="divButton" style="width: 100%; text-align: right;">
					<span><input class="btn btn-success" type="button" value=취소 
					id=cancle onclick='submitForm("cancle")'></span> 
					<span><input class="btn btn-success" type="button" value="예약자 정보 입력"  
					id=write onclick='submitForm("write")'></span>
				</div>
			</form>


<%			
	}
%>
</div>





























