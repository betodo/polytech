<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, java.io.*,java.util.ArrayList"%>

<%
	//모든 접근을 허용
	//클라이언트에서 접속할때 톰캣뿐 아니라 리액트도 가능하도록
	response.setHeader("Access-Control-Allow-Origin","*");	


	Connection conn = null; //얘네 셋을 트라이캐치 밖에선 선언을 안해주면
	Statement stmt = null; //나중에 바디에서 써먹을 수가 없다(전,지역변수 때문에)
	ResultSet rset = null;

	//드라이버
	Class.forName("com.mysql.jdbc.Driver");
	//out.println("드라이버 호출 성공<br>");
	//String ip = "192.168.23.96";
	String ip = "localhost";//서버(우분투)에서 db에 외부로 나갔다 가지 않고 바로 접근 하도록 localhost로 해준다
	String port = ":3306/";
	String dbname = "song?useSSL=false";
	String dbID = "root";
	String dbPW = "1234";

	//커넥션
	conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + dbname, dbID, dbPW);
	//out.println("커넥션 연결 성공<br>");

	//쿼리
	stmt = conn.createStatement();
	rset = stmt.executeQuery(
			"SELECT NAME,studentid,kor,eng,mat,(kor+eng+mat),ROUND(((kor+eng+mat)/3),2) FROM examtable;");
	//sb버퍼로 만들었지만 이걸로 안만들어도 됨
	StringBuilder sb = new StringBuilder();
	
// 	sb.append("{ \"exams\" : [");
	sb.append("[");
	
	while(rset.next()){
		sb.append("{ \"name\" : \""+rset.getString(1)+"\",");
		sb.append(" \"id\" : \""+rset.getInt(2)+"\",");
		sb.append(" \"kor\" : \""+rset.getInt(3)+"\",");
		sb.append(" \"eng\" : \""+rset.getInt(4)+"\",");
		sb.append(" \"mat\" : \""+rset.getInt(5)+"\",");
		sb.append(" \"sum\" : \""+rset.getInt(6)+"\",");
		sb.append(" \"avg\" : \""+rset.getInt(7)+"\"}");
		
		if(rset.next()){
			sb.append(",");
			rset.previous();
		}
	}
	
	sb.append(" ]");
// 	sb.append(" ] }");
	//스트링빌더로 json을 만들어 출력(요청에 응답)
	out.print(sb.toString());
	
	rset.close();
	stmt.close();
	conn.close();
	
%>

<%-- [
	<% 이렇게 만들어도 됨

	  while (rset.next()) {
	%>
	    {"name":"<%=rset.getString(1)%>", "id":<%=rset.getInt(2)%>, "kor":<%=rset.getInt(3)%>, "eng":<%=rset.getInt(4)%>, "math":<%=rset.getInt(5)%>}
	<%
	    if (rset.next()) {
	%>
	      ,
	<%
	      rset.previous();
	    }
	  } // while문 닫음
	%>
	    ]
	<% --%>