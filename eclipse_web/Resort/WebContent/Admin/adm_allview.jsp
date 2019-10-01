<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Calendar"%>
<%@ page import="java.sql.*,useDB.UseDB_Reserve,java.io.*"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	//db연결 예약목록과 실제 db저장된 예약내용을 비교하기
	UseDB_Reserve udbR = new UseDB_Reserve();
	ResultSet rset = udbR.selectRsv();
	
%>
<script>
	//jquery 문서 돔이 준비가 되면 함수를 호출
	$( document ).ready(function() {
		rsv_color();
	});
	
	//예약불가에 색깔 입히기
	function rsv_color(){

		//클래스 reservation-by-day를 가져와서 그 자식들(e 만큼 for each를  돌림
		//.each(function)은 문법
		//i는 인덱스 item은 그 자식들
// 		$('.reservation_by_day').each(function (i, item) {
// 			//console.log(i, item);
			
// // 			var e0 = item.children[0]; //날짜 td
// // 			var e1 = item.children[1].childNodes[0];//td의 a 태그
// // 			var e2 = item.children[2].childNodes[0];
// // 			var e3 = item.children[3].childNodes[0];
			
// // 			if (e1.text != '예약가능') {
// // 				e1.classList.add("booked"); //클래스를 붙여줌
			
// // // 				e1.setAttribute('href', '?contentPage=Admin/adm_oneview.jsp?day='+e0+'&room=1');
				
// // // 				document.getElementById('id_value').setAttribute('title', 'It is kkamikoon Title');

// // 			}
// // 			if(e2.text !== '예약가능') {
// // 				e2.classList.add("booked");
// // // 				e2.setAttribute('href', '?contentPage=Admin/adm_oneview.jsp?day='+e0+'&room=2');
// // 			}
// // 			if(e3.text !== '예약가능') {
// // 				e3.classList.add("booked");
// // // 				e3.setAttribute('href', '?contentPage=Admin/adm_oneview.jsp?day='+e0+'&room=3');
// // 			}
			
// 		});
		
	}
</script>
<style>
.booked {
   	color: red;  
/*  	pointer-events:none; */
/*  	cursor:default; */
}

</style>
<div class="container">
	<table id="basicTB" width="100%">
		<thead>
			<tr>
				<th class="collum1">날짜</th>
				<th class="collum2">vip룸</th>
				<th class="collun3">일반룸</th>
				<th class="collum4">합리룸</th>
			</tr>
		</thead> 
		<tbody>
			<%
				rset.beforeFirst();
				String korDay = "";
				while(rset.next()) {
					
					switch (rset.getInt(2)) {
						case 1: korDay = "(일)"; break;
						case 2: korDay = "(월)"; break;
						case 3: korDay = "(화)"; break;
						case 4: korDay = "(수)"; break;
						case 5: korDay = "(목)"; break;
						case 6: korDay = "(금)"; break;
						case 7: korDay = "(토)"; break;
						
					}
			%>
			<tr class="reservation_by_day">
				<td class="rsv_td"><%=rset.getString(1) %><%=korDay%></td>
				<td>
				<% if(rset.getString(3).equals("예약가능")){ %>
					<a class="room1"
					href="?contentPage=Reserve/Reserve_insert.jsp?day=<%=rset.getString(1)%>&room=1&key=adm"><%=rset.getString(3) %></a>
				<% }else{ %>
					<a class="room1" style="color:red;"
					href="?contentPage=Admin/adm_oneview.jsp?day=<%=rset.getString(1)%>&room=1"><%=rset.getString(3) %></a>
				<% } %>
				</td>
 				<td>
				<% if(rset.getString(4).equals("예약가능")){ %>
					<a class="room2"
					href="?contentPage=Reserve/Reserve_insert.jsp?day=<%=rset.getString(1)%>&room=2&key=adm"><%=rset.getString(4) %></a>
				<% }else{ %>
					<a class="room2" style="color:red;"
					href="?contentPage=Admin/adm_oneview.jsp?day=<%=rset.getString(1)%>&room=2&"><%=rset.getString(4) %></a>
				<% } %>
				</td>
				<td>
				<% if(rset.getString(5).equals("예약가능")){ %>
					<a class="room3"
					href="?contentPage=Reserve/Reserve_insert.jsp?day=<%=rset.getString(1)%>&room=3&key=adm"><%=rset.getString(5) %></a>
				<% }else{ %>
					<a class="room3" style="color:red;"
					href="?contentPage=Admin/adm_oneview.jsp?day=<%=rset.getString(1)%>&room=3"><%=rset.getString(5) %></a>
				<% } %>
				</td>
			</tr>
			<%
				}
				rset.close();
				udbR.close();
			%>
		</tbody>
	</table>
</div>
