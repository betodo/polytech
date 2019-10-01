<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%>
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 글 목록을 보여주는 화면</title>
	<style type="text/css">
		/* 가운데 정렬과 테이블 꾸미기 위한 스타일 지정 */
		#wrap {
			display: flex;
			/* justify-content: center; */
			align-items: center;  
		}
		table{
			border-collapse: collapse;
		}
		tr {
			height:3em;
			border-bottom:1px solid;
		}
		.collum1  {
			width:50px;
			text-align:center;
		}
		.collum4  {
			width:70px;
			text-align:center;
		}
		.collum2 {
			text-align:left;
			padding-left:2em;
			width:600px;
		}
		.collum2 {
			width:350px;
		}
		#divButton{
		    width: 550px;
    		text-align: right;
		}
		a {
			text-decoration: none;
		}
		a:hover {
			text-decoration: underline;
            background: lightgray;
		}
	</style>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calt = Calendar.getInstance();
		
		String title ="";
		
// 		디비를 연결하고 쿼리를 날릴 클래스를 하나 파서 메서드를 만듬
		UseDB udb = new UseDB();
		Statement stmt =null;
		ResultSet rset =null;
		// 첫화면은 클래스에 쿼리날리는 메서드를 만들지 않고 여기서 직접했다
		String sql="";
		//try{
			stmt = udb.statementDB();
			sql = "select id, title, date, recnt, viewcnt, relevel from gongji order by rootid desc, recnt asc;";
			rset = stmt.executeQuery(sql);
			
			//페이징 처리
			//선언
		    //테이블 라인 조회 변수
		    int LineCnt = 0; //행 번호
		    int fromNum =0; //몇번부터
		    int toCnt = 10; //몇개를
		    String fromTemp;//던지는 값을 일시적으로 받을 변수
		
		    //페이징 처리 변수
		    final int firstPage_firstLinkNum=1; //제일 첫p의 첫 링크 번호
		    int firstLinkNum = 1;//각 p의 첫 링크 번호
		    int stopLink = 3;
		    int totalLineCnt = 0;//데이터의 전체 라인 수(마지막 P 구현에 필요)
		    int previousPage_firstLinkNum = 0;//이전 p 갈 때 필요 변수
		    int nextPage_firstLinkNum = 0;//다음 p 갈 때 필요 변수
		    int lastPage_firstLinkNum = 0;//막p 첫 링크 번호
		    int finishLink = 0; //최종 마지막 링크
		
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
		    if (totalLineCnt % (stopLink*toCnt) !=0){
		    	lastPage_firstLinkNum = ((int)(totalLineCnt/(stopLink*toCnt)) *stopLink)+1;
		    }
		    else{ //나누어 떨어졌을때 페이지의 첫 링크
		    	lastPage_firstLinkNum = ((int)(totalLineCnt/(stopLink*toCnt)) *stopLink)-4;
		    }
		    
		    //최종 마지막 링크 번호 구하기
		    if(totalLineCnt % toCnt ==0) finishLink = totalLineCnt/toCnt;
		    else finishLink = totalLineCnt/toCnt + 1;
		    
//	 	    lastPage_firstLinkNum = ((int)(totalLineCnt/200) *10)+1;   
//	 	    if (totalLineCnt == 200) lastPage_firstLinkNum = 1;
		
		    //이전페이지 갈 때 구현
		    previousPage_firstLinkNum = firstLinkNum-stopLink;
		  	//이전 페이지가 음수 찍히지 않도록
		    if( previousPage_firstLinkNum <= 0 ) previousPage_firstLinkNum =1; 
		
		    //다음페이지 갈 때 구현
		    nextPage_firstLinkNum = firstLinkNum+stopLink;
		  	//다음페이지가 무수히 나오지 않도록
		  	if(nextPage_firstLinkNum >= lastPage_firstLinkNum +stopLink){
	            nextPage_firstLinkNum = lastPage_firstLinkNum; 
	        }
			
		//}catch (Exception e){ 
	%>
<!-- 			<script >window.location="/Gongji_project";</script> 메서드를 폼으로 잡으면 이 처리 없어도 됨 -->
			
<%-- 	<% } %> --%>


</head>
<body>
	<div id=wrap>
	<br>
	<table>
		<thead>
			<tr><th class="collum1">번호</th><th class="collum2">제목</th>
			<th class="collum4">조회수</th><th class="collum3">등록일</th></tr>	
		</thead>
		<tbody>
			<% while(rset.next()){ 
					LineCnt++;
	                if(LineCnt < fromNum) {continue;} 
	                //continue continue를 만나게 되면 다음을 수행 안하고 다음 반복문으로 뛴다
	                if(LineCnt >= fromNum+toCnt) {break;}
				
					if(sdf.format(calt.getTime()).equals(rset.getString(3))) {
						title = rset.getString(2)+"[new]";
					}else {
						title = rset.getString(2);
					}
					
					if(rset.getInt(6) != 0){
						//StringBuffer sb = new StringBuffer();
						StringBuilder sb = new StringBuilder();
						
						for(int i=0; i < rset.getInt(6); i++) {
							sb.append("-");
						}
						
						title = sb.toString()+">[re]"+title;
					}
				
				
			%>
				<tr>
					<td class="collum1"><%=rset.getInt(1) %></td>	
					<td class="collum2">
						<a href="?contentPage=gongji_view.jsp?keyId=<%=rset.getInt(1)%>"><%=title %></a>
					</td>
					<td class="collum4"><%=rset.getString(5) %></td>
					<td class="collum3"><%=rset.getString(3) %></td>
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
	           <a href="?contentPage=gongji_list.jsp?sendFirstLink=<%=firstPage_firstLinkNum%>">&lt&lt</a>
	       </td>
	       <%-- 이전 페이지 가는 링크 --%>
	       <td>
	           <a href="?contentPage=gongji_list.jsp?sendFirstLink=<%=previousPage_firstLinkNum%>&from=<%=previousPage_firstLinkNum*toCnt-(toCnt-1)%>">&lt</a>
	       </td>
     
            <%-- 한 페이지 안의 10개의 링크 만들기 --%>
            <%
                for(int i=firstLinkNum; i<firstLinkNum+stopLink ; i++) {
                    if ( (i*toCnt-(toCnt-1)) > totalLineCnt) break; //데이터가 없는 링크가 만들어 지지 않도록
                    out.print("<td>");    
                    //링크의 번호에 따라 조회할 데이터의 번호가 바뀜 & 바뀐 번호를 던져줌
                    out.print("<a href=?contentPage=gongji_list.jsp?sendFirstLink="+firstLinkNum+"&from="+(i*toCnt-(toCnt-1))+">"+i+"p</a>");   
                    out.print("</td>");                    
                }
            %>
            
            <%-- 다음페이지 넘어가기 링크 --%>
            <td>
                <a href="?contentPage=gongji_list.jsp?sendFirstLink=<%=nextPage_firstLinkNum%>&from=<%=nextPage_firstLinkNum*toCnt-(toCnt-1)%>">&gt</a>
            </td>
            <%-- 마지막 페이지 가는 링크 --%>
            <td>
                <a href="?contentPage=gongji_list.jsp?sendFirstLink=<%=lastPage_firstLinkNum%>&from=<%=finishLink*toCnt-(toCnt-1)%>">&gt&gt</a>
            </td>
        </tr>
    </table>
	<br>
	<div id=divButton>	
		<form action="?contentPage=gongji_insert.jsp" method="POST">
					<input type="submit" value="신규">
		</form>
	</div>
	</div>
	<%	
		rset.close();
	    stmt.close();
	    udb.close();
	%>
</body>
</html>