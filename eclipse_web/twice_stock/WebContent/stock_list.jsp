<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,twice_stock_pac.UseDB,java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고리스트</title>
	<style type="text/css">
		table {
			border-collapse: collapse;
		}
		th {
			background: cyan;
			border:1px solid;
			height:2em;
		}
		.dataTable {
			border:1px solid;
			height:1.5em;
		}
		/* 각열의 넓이 지정 */
		.col1 {
			width:70px;
		}
		.col2 {
			width:300px;
		}
		.col3 {
			width:110px;
		}
		.col4 {
			width:110px;
		}
		a {
	        text-decoration: none;
	        margin-left: 0.3em;
	        margin-right: 0.3em;
		}
		a:hover {
            text-decoration: underline;
            color: red;
        }
        div {
        	text-align: right;
    		margin-top: 10px;
        }
	</style>
	<%
		//db연결, 
		UseDB udb = new UseDB();
		ResultSet rset = udb.selectAllTw_stock();
	%>
	<%-- 페이징 처리하는 jsp --%>
    <%
	  //선언
	    //테이블 라인 조회 변수
	    int LineCnt = 0; //행 번호
	    int fromNum =0; //몇번부터
	    int toCnt = 20; //몇개를
	    String fromTemp;//던지는 값을 일시적으로 받을 변수
	
	    //페이징 처리 변수
	    final int firstPage_firstLinkNum=1; //제일 첫p의 첫 링크 번호
	    int firstLinkNum = 1;//각 p의 첫 링크 번호
	    int totalLineCnt = 0;//데이터의 전체 라인 수(마지막 P 구현에 필요)
	    int previousPage_firstLinkNum = 0;//이전 p 갈 때 필요 변수
	    int nextPage_firstLinkNum = 0;//다음 p 갈 때 필요 변수
	    int lastPage_firstLinkNum = 0;//막p 첫 링크 번호
	
	    //값 받기
	    fromTemp =request.getParameter("from"); 
	
	    //최초 받은 값이 없고 있고 처리
	    if(fromTemp == null) {
	        fromNum =1; //제일 처음
	    }else { 
	        fromNum = Integer.parseInt(fromTemp);
	
	    }
	
	    //데이터 전체라인 구하기
	    rset.last();
	    totalLineCnt=rset.getRow();
	    rset.beforeFirst();
	
	    //하이퍼링크가 던지는 값(각 페이지의 첫번째 링크 숫자) 받기
	    String getFirstLink = request.getParameter("sendFirstLink");
	    if (getFirstLink != null){
	        firstLinkNum = Integer.parseInt(getFirstLink);
	    }
	    
	    //마지막p 첫 링크 번호 구하기 (총라인 몇개 산정하고 식을 도출해내는 식으로 구함)
	    if (totalLineCnt % 200 !=0){
	    	lastPage_firstLinkNum = ((int)(totalLineCnt/200) *10)+1;
	    }
	    else{ //나누어 떨어졌을때 페이지의 첫 링크
	    	lastPage_firstLinkNum = ((int)(totalLineCnt/200) *10)-9;
	    }
	    
// 	    lastPage_firstLinkNum = ((int)(totalLineCnt/200) *10)+1;   
// 	    if (totalLineCnt == 200) lastPage_firstLinkNum = 1;
	
	    //이전페이지 갈 때 구현
	    previousPage_firstLinkNum = firstLinkNum-10;
	  	//이전 페이지가 음수 찍히지 않도록
	    if( previousPage_firstLinkNum <= 0 ) previousPage_firstLinkNum =1; 
	
	    //다음페이지 갈 때 구현
	    nextPage_firstLinkNum = firstLinkNum+10;
	  	//다음페이지가 무수히 나오지 않도록
	  	if(nextPage_firstLinkNum >= lastPage_firstLinkNum +10){
            nextPage_firstLinkNum = lastPage_firstLinkNum; 
        }
    %>
</head>
<body>
	<br>
	<h1>(주) 트와이스 재고 현황-전체현황</h1>
	<br>
	<table>
		<thead>
			<th class = "col1">상품번호</th><th class = "col2">상품명</th><th class = "col3">현재 재고수</th>
			<th class = "col4">재고 파악일</th><th class = "col4">상품 등록일</th>
		</thead>
		<tbody>
			<% 
				while(rset.next()){ 
					LineCnt++;
                    if(LineCnt < fromNum) {continue;} 
                    //continue continue를 만나게 되면 다음을 수행 안하고 다음 반복문으로 뛴다
                    if(LineCnt >= fromNum+toCnt) {break;}
			%>
				<tr>
					<td class="dataTable">
						<a href="?contentPage=stock_view.jsp?keyId=<%=rset.getInt(1)%>"><%=rset.getInt(1) %></a>
					</td>	
					<td class="dataTable"><%=rset.getString(2) %></td>
					<td class="dataTable"><%=rset.getInt(3) %></td>
					<td class="dataTable"><%=rset.getString(5) %></td>
					<td class="dataTable"><%=rset.getString(4) %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
	<br>

	<!-- 페이징 출력 -->

    <table id="linkTable" align="center">
        <tr id="Ptr">
	       <%-- 제일 처음 페이지가는 링크 --%>
	       <td>
	           <a href="?contentPage=stock_list.jsp?sendFirstLink=<%=firstPage_firstLinkNum%>">&lt&lt</a>
	       </td>
	       <%-- 이전 페이지 가는 링크 --%>
	       <td>
	           <a href="?contentPage=stock_list.jsp?sendFirstLink=<%=previousPage_firstLinkNum%>&from=<%=previousPage_firstLinkNum*20-19%>">&lt</a>
	       </td>
     
            <%-- 한 페이지 안의 10개의 링크 만들기 --%>
            <%
                for(int i=firstLinkNum; i<firstLinkNum+10 ; i++) {
                    if ( (i*20-19) > totalLineCnt) break; //데이터가 없는 링크가 만들어 지지 않도록
                    out.print("<td>");    
                    //링크의 번호에 따라 조회할 데이터의 번호가 바뀜 & 바뀐 번호를 던져줌
                    out.print("<a href=?contentPage=stock_list.jsp?sendFirstLink="+firstLinkNum+"&from="+(i*20-19)+">"+i+"p</a>");   
                    out.print("</td>");                    
                }
            %>
            
            <%-- 다음페이지 넘어가기 링크 --%>
            <td>
                <a href="?contentPage=stock_list.jsp?sendFirstLink=<%=nextPage_firstLinkNum%>&from=<%=nextPage_firstLinkNum*20-19%>">&gt</a>
            </td>
            <%-- 마지막 페이지 가는 링크 --%>
            <td>
                <a href="?contentPage=stock_list.jsp?sendFirstLink=<%=lastPage_firstLinkNum%>&from=<%=lastPage_firstLinkNum*20-19%>">&gt&gt</a>
            </td>
        </tr>
    </table>
    <div>
    	<form action="?contentPage=stock_insert.jsp" method="POST">
					<input type="submit" value="신규등록">
		</form>
    </div>
	<% rset.close(); udb.close(); %>
</body>
</html>