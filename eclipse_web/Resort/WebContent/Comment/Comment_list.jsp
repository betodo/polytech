<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.text.SimpleDateFormat, java.util.Calendar" %>
<%@ page import="java.sql.*,useDB.UseDB_Comment,java.io.*"%>

 <title>후기리스트</title> 
 
 <%
	//날짜 출력 처리, 포맷부터 선언
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar calt = Calendar.getInstance();
	
	//db에서 전체 조회
	UseDB_Comment udbC = new UseDB_Comment();
	ResultSet rset = null;
	rset = udbC.selectAllComment();
 
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
    int stopLink = 10;//링크 몇개까지
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
  	
 %>
 <div class="container">
 <table id="basicTB" width="100%">
	<thead>
		<tr><th class="collum1">번호</th><th class="collum2">제목</th>
		<th class="collun3">파일</th>
		<th class="collum4">조회수</th><th class="collum5">등록일</th></tr>	
	</thead>
	<tbody>
		<% 
			String title ="";
			while(rset.next()){ 
				LineCnt++;
                if(LineCnt < fromNum) {continue;} 
                //continue continue를 만나게 되면 다음을 수행 안하고 다음 반복문으로 뛴다
                if(LineCnt >= fromNum+toCnt) {break;}
			
				if(sdf.format(calt.getTime()).equals(rset.getString(3))) {
					title = rset.getString(2)+"[new]";
				}else {
					title = rset.getString(2);
				}
				
				//댓글에 re 붙이히
// 				if(rset.getInt(6) != 0){ //원글이 아니면
// 					//StringBuffer sb = new StringBuffer();
// 					//StringBuilder sb = new StringBuilder();
// 					StringBuilder sb = new StringBuilder();
// 					for(int i=0; i < rset.getInt(6); i++) {
// 						sb.append("-");
// 					}
// 					sb.append(">");
					
// 				}
			
		%>
			<tr>
			<!-- 댓글이면 글번호대신 댓글이란 텍스트를 출력 -->
			<%if(rset.getInt(6)==0){ %>
				<td class="collum1"><%=rset.getInt(1) %></td>	
			<%}else{ %>
				<td class="collum1">댓글</td>
			<%} %>
				<td class="collum2">
					<a href="?contentPage=Comment/Comment_view.jsp?keyId=<%=rset.getInt(1)%>">
					
					<%
					if(rset.getInt(6) != 0){ //원글이 아니라 댓글이면
						StringBuilder sb = new StringBuilder();
						//댓글 수준만큼 공백을 채운다
						for(int i=0; i < rset.getInt(6); i++) {
							sb.append("&nbsp;&nbsp;&nbsp;");
							//out.print("&nbsp;&nbsp;&nbsp;");
						}
						//sb.append("->");
						out.print(sb.toString());
					%>
						<!-- 공백을 채운뒤 댓글을 표시하는 이미지 출력 -->
						<img alt="" src="img/re.png" style="width: 1.3em;">
						[re]&nbsp;<%=title %></a>
						
					<%}else{ %>
						<!-- 댓글이 아니면 걍 -->
						<%=title %></a>
						
					<%} %>
					
				</td>
				<!-- 파일 유무에 따라 파일 아이콘 출력 -->
				<td class="collum3" style="width: 15vh;">
				<%if(rset.getString(9)!=null) {%>	
					파일1 : <img alt="" src="img/file.png"><br>
				<%}else{ %>
					파일1 : 없음<br>
				<%} %>
				<%if(rset.getString(10)!=null) {%>	
					파일2 : <img alt="" src="img/file.png">
				<%}else{ %>
					파일2 : 없음
				<%} %>
				</td>
				<td class="collum4"><%=rset.getString(8) %></td>
				<td class="collum5"><%=rset.getString(3) %></td>
			</tr>
		<% } %>
	</tbody>
</table>
<br>
 <!-- 페이징 출력 -->
<div align="center">
	<ul id ="pagination">
    <%-- 제일 처음 페이지가는 링크 --%>
		<li>
        <a href="?contentPage=Comment/Comment_list.jsp?sendFirstLink=<%=firstPage_firstLinkNum%>">&lt&lt</a>
		</li>
    <%-- 이전 페이지 가는 링크 --%>
		<li>
        <a href="?contentPage=Comment/Comment_list.jsp?sendFirstLink=<%=previousPage_firstLinkNum%>&from=<%=previousPage_firstLinkNum*toCnt-(toCnt-1)%>">&lt</a>
		</li>
        <%-- 한 페이지 안의 10개의 링크 만들기 --%>
        <%
            for(int i=firstLinkNum; i<firstLinkNum+stopLink ; i++) {
                if ( (i*toCnt-(toCnt-1)) > totalLineCnt) break; //데이터가 없는 링크가 만들어 지지 않도록
                out.print("<td>");    
                //링크의 번호에 따라 조회할 데이터의 번호가 바뀜 & 바뀐 번호를 던져줌
                out.print("<li><a href=?contentPage=Comment/Comment_list.jsp?sendFirstLink="+firstLinkNum+"&from="+(i*toCnt-(toCnt-1))+">"+i+"</a>");   
                out.print("</li>");                    
            }
        %>
        <%-- 다음페이지 넘어가기 링크 --%>
         <li>
         <a href="?contentPage=Comment/Comment_list.jsp?sendFirstLink=<%=nextPage_firstLinkNum%>&from=<%=nextPage_firstLinkNum*toCnt-(toCnt-1)%>">&gt</a>
      	</li>
        <%-- 마지막 페이지 가는 링크 --%>
          <li>
          <a href="?contentPage=Comment/Comment_list.jsp?sendFirstLink=<%=lastPage_firstLinkNum%>&from=<%=finishLink*toCnt-(toCnt-1)%>">&gt&gt</a>
        </li>
    
	</ul>
</div>
<br>
 <form action="?contentPage=Comment/Comment_insert.jsp" method="POST" style="width: 90%;
    text-align: right;">
	<input type="submit" value="신규" class="btn btn-success">
</form>
 </div>
 <%	
	rset.close();
	udbC.close();
%>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 