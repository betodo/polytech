<%@ page errorPage="error.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.*,java.util.ArrayList" %>

 
    <%
        //String title = "실습 데이터 입력 ok";
        //try{
        //
        //}catch(Exception e){
        //    
        //}
        Connection conn = null; //얘네 셋을 트라이캐치 밖에선 선언을 안해주면
        Statement stmt =null; //나중에 바디에서 써먹을 수가 없다(전,지역변수 때문에)
        ResultSet rset = null;
        
            //드라이버
            Class.forName("com.mysql.jdbc.Driver");
            //out.println("드라이버 호출 성공<br>");
            //String ip = "192.168.23.96";
            String ip = "localhost";//서버(우분투)에서 db에 외부로 나갔다 가지 않고 바로 접근 하도록 localhost로 해준다
            String port = ":3306/";
            String dbname = "song";
            //String dbname = "song?useSSL=false";
            String dbID = "root";
            String dbPW = "1234";

            //커넥션
            conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + dbname, dbID, dbPW);
            //out.println("커넥션 연결 성공<br>");

            //쿼리
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT NAME,studentid,kor,eng,mat,(kor+eng+mat),ROUND(((kor+eng+mat)/3),2) FROM examtable;");

        
		
    %>
<%-- 페이징 처리 구현 jsp문 --%>
    <%
    //선언
        //테이블 라인 조회 변수
        int LineCnt = 0; //행 번호
        int fromNum =0; //몇번부터
        int toCnt = 10; //몇개를
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
        lastPage_firstLinkNum = ((int)(totalLineCnt/100) *10)+1;   
        if (totalLineCnt == 100) lastPage_firstLinkNum = 1;

         //이전페이지 갈 때 구현
        previousPage_firstLinkNum = firstLinkNum-10;

        //다음페이지 갈 때 구현
        nextPage_firstLinkNum = firstLinkNum+10;
        
    %>
<%-- 총점,평균,등수 부여 jsp문 --%>
    <%
        //총점,평균은 쿼리로 처리 
        //총점을 비교하여 등수부여를 위해 총점을 어레이 리스트에 저장
        ArrayList<Integer> total = new ArrayList<>(); //비교할 총점
        ArrayList<Integer> rank = new ArrayList<>(); //부여할 등수
        int rank_index =0; //부여한 등수를 출력할때 필요한 등수arrayList의 인덱스

        rank_index = fromNum-1;//페이징 처리때문에 계산 
        
        //등수부여를 위해 총점 배열에 값 저장
        while(rset.next()){
            total.add(rset.getInt(6));
            rank.add(1);
        }

        //총점을 비교하여 등수 부여, 저장
        for(int i=0; i < rank.size(); i++){
            rank.set(i,1);
            for(int j =0; j < total.size(); j++){
                if(total.get(i) < total.get(j)){
                    rank.set(i, rank.get(i)+1);
                }
            }
        }

        rset.beforeFirst();//최종출력을 위해 rset을 돌려놈
    %>
</head>
<body>
<%-- 최종출력(+페이징, 총점,평균,등수) --%>
    <%-- 데이터 출력 --%>
    <h1>조회</h1>
    <table id="dataTable">
        <thead>
            <tr>
                <th>이름</th><th>학번</th>
                <th>국어</th><th>영여</th><th>수학</th>
                <th>합계</th><th>평균</th><th>등수</th>
            </tr>
        </thead>
        <tbody>
    <%
        while(rset.next()) {
            LineCnt++;
            if(LineCnt < fromNum) {continue;} 
            if(LineCnt >= (fromNum+toCnt) ) {break;}
    %>  
            <tr>
                <td class="dataTableTD"><a href="oneviewDB.jsp?sended_studentID=<%=rset.getInt(2)%>&sended_studentName=<%=rset.getString(1)%>"><%=rset.getString(1)%></a></td>
                <td class="dataTableTD"><%=rset.getInt(2)%></td>
                <td class="dataTableTD"><%=rset.getInt(3)%></td>
                <td class="dataTableTD"><%=rset.getInt(4)%></td>
                <td class="dataTableTD"><%=rset.getInt(5)%></td>
                <td class="dataTableTD"><%=rset.getInt(6)%></td>
                <td class="dataTableTD"><%=rset.getDouble(7)%></td>
                <td class="dataTableTD"><%=rank.get(rank_index)%></td>
            </tr>
    <%    
            rank_index++;//인덱스를 페이지 링크 누를때 던져서 변화 시켜야함
        }
    %>

        </tbody>
    </table>
    <!-- 페이징 출력 -->
    <table id="linkTable" align="center">
        <tr id="Ptr">
            <%
            if(firstLinkNum !=1){ //첫 페이지에선 이전페이지 가는 링크 안나오도록
            %>
                <%-- 제일 처음 페이지가는 링크 --%>
                <td>
                    <a href="AllviewDB.jsp?sendFirstLink=<%=firstPage_firstLinkNum%>">&lt&lt</a>
                </td>
                <%-- 이전 페이지 가는 링크 --%>
                <td>
                    <a href="AllviewDB.jsp?sendFirstLink=<%=previousPage_firstLinkNum%>&from=<%=previousPage_firstLinkNum*10-9%>&cnt=10">&lt</a>
                </td>
            <%    
            }
            %>
            <%-- 한 페이지 안의 10개의 링크 만들기 --%>
            <% 
                for(int i=firstLinkNum; i<firstLinkNum+10 ; i++) {
                    if ( (i*10-9) > totalLineCnt) break; //데이터가 없는 링크가 만들어 지지 않도록
                    out.print("<td>");    
                    //링크의 번호에 따라 조회할 데이터의 번호가 바뀜 & 바뀐 번호를 던져줌
                    out.print("<a href=AllviewDB.jsp?sendFirstLink="+firstLinkNum+"&from="+(i*10-9)+">"+i+"p</a>");   
                    out.print("</td>");                    
                }
            %>
            <%
            if( (firstLinkNum+9)*10 < totalLineCnt ){ //마지막페이지에서 다음페이지 가는 링크 안나오도록
            %>
                <%-- 다음페이지 넘어가기 링크 --%>
                <td>
                    <a href="AllviewDB.jsp?sendFirstLink=<%=nextPage_firstLinkNum%>&from=<%=nextPage_firstLinkNum*10-9%>">&gt</a>
                </td>
                <%-- 마지막 페이지 가는 링크 --%>
                <td>
                    <a href="AllviewDB.jsp?sendFirstLink=<%=lastPage_firstLinkNum%>&from=<%=lastPage_firstLinkNum*10-9%>">&gt&gt</a>
                </td>
            <%    
            }
            %>
        </tr>
    </table>
    <%
        //rset2.close();//데이터 안잡아 먹도록 쓰고나면 닫자
        //stmt2.close();
        rset.close();//데이터 안잡아 먹도록 쓰고나면 닫자
        stmt.close();
        conn.close(); 
    %>
</body>
</html>