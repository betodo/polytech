<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="vote_project.connectDB" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보등록/삭제</title>
	<style>
		table {
			border-collapse: collapse;
		}
		td {
			border: 1px solid;
		}
		input {
			width : 80px;
		}
	</style>
<%!int id = 0; %><!-- 후보등록시 자동입력되는 기호번호 -->
<%-- <%!int del_index = 1; %> --%>
	<%	
		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		
		//추가등록시 자동 기호번호 부여
		String QueryTxt;
		QueryTxt = "select * from candidate where id=1;"; //기호번호 시작번호 1을 넣어준다
		ResultSet rset = stmt.executeQuery(QueryTxt);
		
		if(rset.next()){
            rset = stmt.executeQuery("select min(id+1) from candidate"
					+" where (id+1) not in (select id from candidate);"); 
            // 전체테이블에서 없는 기호번호에 더하기 1한 기호번호중 최소 기호번호 조회 그걸 id로 할당
            rset.next();
            id = rset.getInt(1);
        }else{
            id = 1;//기호번호 시작값이 없는 경우는 기호번호시작값 그대로 너준다
        }
		
		//현재 등록되어 있는 후보들 조회할 준비
		rset = stmt.executeQuery("select * from candidate"); 
	%>
	<script>
        // 입력값 제외 function
        // 입력값의 문자 종류 판별하는 함수
        function check_key() { 
            var char_ASCII = event.keyCode;
            //숫자
            if (char_ASCII >= 48 && char_ASCII <= 57)
                return 1;
            //영어
            else if ((char_ASCII >= 65 && char_ASCII <= 90) || (char_ASCII >= 97 && char_ASCII <= 122))
                return 2;
            //특수기호
            else if ((char_ASCII >= 33 && char_ASCII <= 47) || (char_ASCII >= 58 && char_ASCII <= 64)
                || (char_ASCII >= 91 && char_ASCII <= 96) || (char_ASCII >= 123 && char_ASCII <= 126))
                return 4;
            //한글
            else if ((char_ASCII >= 12592) || (char_ASCII <= 12687))
                return 3;
            //그 밖에
            else
                return 0;
        }
        //한글만 입력하도록 하는 함수
        function onlyHan() {
            if (check_key() != 3) {
                event.returnValue = false;
                alert("한글만 입력하세요.");
                return;//리턴으로 아무것도 안 뱉으면 함수가 끝난다
            }
        }
        
        //널값 제외 함수
        function limitNull() {
            const insert = document.getElementById('insert');//form을 받아옴
            const inputName = document.getElementById('name');//인풋타입텍스트들을 받아옴
          
            if(inputName.value ==""){
                alert("입력값이 없는지 확인 해 보세요");
                return;
            }

            insert.submit(); 
        }
       
        </script>
</head>
<body>
<h3 style="margin-left: 2em">후보등록</h3>	
	<table>
	<% while (rset.next()) { %> <!-- 현재 등록되어 있는 후보들을 보여줌 -->
		<tr>
			<form method="POST" action="?contentPage=delete.jsp">
				<td><input type="hidden" value="<%=rset.getInt(1)%>" name="toDelId">기호번호 : <%=rset.getInt(1)%></td>
				<td>후보명 : <%=rset.getString(2)%></td>
				<td><input type="submit" value="삭제" ></td>
			</form>
		</tr>
	<% } %>
	<!-- 후보등록을 추가할때 필요한 입력값 -->
		<tr>
			<form method="POST" action="?contentPage=insert.jsp" id="insert">
				<td>기호번호 : <input type="text" value="<%=id %>" readonly="readonly" name="toInsertId" ></td>
				<td>후보명 : <input type="text" name="toInsertName" onkeypress='onlyHan()' id="name"></td>
				<td><input type="button" value="추가" onclick="limitNull()"></td>						
			</form>
		</tr>
	</table>
	<%
		rset.close();
	    stmt.close();
	    cdb.close();
	%>
</body>
</html>
