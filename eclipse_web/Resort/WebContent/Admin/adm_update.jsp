<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,useDB.UseDB_Reserve,java.io.*"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%
//로직
// 1. 예약일과 방을 수정했는가?
// 	1-1 수정  
// 		기존의 예약과 겹치는가?
// 			겹침 : 예약불가 뒤로가
// 			안겹침 : 기존꺼 지우고 수정한 값으로 새로 인서트
// 	1-2 수정 안함 -> 바로 예약일 방 빼고 없뎃

	request.setCharacterEncoding("UTF-8"); //한글 안먹음 왜?
	String change = request.getParameter("change"); // 예약일과 방을 변경 했는지 change가 true면 예약일 방 변경
	//out.print(change);
	
	//변경할 애들 값받기
	String nameTemp = request.getParameter("name");
	String name = new String(nameTemp.getBytes("8859_1"), "utf-8");

	String addrTemp = request.getParameter("addr");
	String addr = new String(addrTemp.getBytes("8859_1"), "utf-8");

	String phone_num = request.getParameter("phone_num");

	String deposit_nameTemp = request.getParameter("deposit");
	String deposit = new String(deposit_nameTemp.getBytes("8859_1"), "utf-8");

	String rsv_commentTemp = request.getParameter("rsv_comment");
	String comment = new String(rsv_commentTemp.getBytes("8859_1"), "utf-8");
	
	String write_dateTemp = request.getParameter("write_date");
	String write_date = new String(write_dateTemp.getBytes("8859_1"), "utf-8");
	
	int processing = Integer.parseInt(request.getParameter("processing"));
		
	//변경한 애들 중 이미 예약된 방과 일자는 변경안됨
	String rsv_date = "";//값 받을 변수 초기화
	int room = 0;
	boolean rsv_able = true; //변경가능 여부 변수
	UseDB_Reserve udbR = new UseDB_Reserve();//예약가능 여부 확인 위한 디비비교 준비

	//받은 값과 db를 비교하여 예야가능여부 판별
	//if(request.getParameter("date") != null && request.getParameter("room") != null){
	rsv_date = request.getParameter("date");
	room = Integer.parseInt(request.getParameter("room"));

	// 방번호에 따른 이름
	String roomName = "";
	switch (room) {
	case 1:
		roomName = "vip룸";
		break;
	case 2:
		roomName = "합리룸";
		break;
	case 3:
		roomName = "일반룸";
		break;
	}
	
	ResultSet rset = null;
	
	//날짜와 방 예약을 바꿨으면
	if(change.equals("true")){
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		//디비에서 선택된 날짜비교
		rset = udbR.selectOneYearReserve(startDate, endDate);
		
		//디비에 바꾼 날짜와 방이 있는지 판단
		if (rset.next()) {
			rset.beforeFirst();
			while (rset.next()) {
			
				if (rsv_date.equals(rset.getString(1)) && room == rset.getInt(2)) {
					rsv_able = false; //있으면 예약불가
					break;
				}
			}
		}
	
		if (rsv_able == false) { //예약불가면 아래와 같은 내용 나옴
%>
			<div class="container">
			<table id="basicTB" width="100%">
				<thead>
					<tr>
						<th colspan=2>예약 가능 여부</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>죄송합니다. <%=rsv_date%> , <%=roomName%>은 이미 예약 되었습니다. 다른 일자 또는
							방을 선택해 주세요
						</td>
					</tr>
				</tbody>
			</table>
			<form method='post'
				action="?contentPage=Admin/adm_allview.jsp">
				<div id="divButton" style="width: 100%; text-align: right;">
					<span><input class="btn btn-success" type="submit" value=뒤로></span>
				</div>
			</form>
			</div>
<%
		}else{ //디비에서 뒤졌는데 예약가능하면
			
			//변경시 기존의 날짜 방 에약은 삭제해야
			String OGrsv_date = request.getParameter("OGrsv_date");
			int OGroom = Integer.parseInt(request.getParameter("OGroom"));
			udbR.deleteRsv(OGrsv_date, OGroom);
			
			//삭제하고 새로 인서트함
			udbR.insertRsvForAdmin(name, rsv_date, room, addr, phone_num, deposit, comment, write_date, processing);
			out.print("<script>alert(\"수정되었습니다.(기존delete,새로insert)\");"
					+"window.location.href='?contentPage=Admin/adm_allview.jsp'</script>");
		}
	}else{//예약일과 방을 안바꿨으면 바로 업뎃
		
		udbR.updateRsv(name, rsv_date, room, addr, phone_num, deposit, comment, write_date, processing);
		out.print("<script>alert(\"수정되었습니다.(바로수정)\");"
				+"window.location.href='?contentPage=Admin/adm_allview.jsp'</script>");
	}

	
	if(rset!=null) rset.close();
	udbR.close();
%>