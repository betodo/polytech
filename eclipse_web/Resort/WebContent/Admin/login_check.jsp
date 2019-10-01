<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.sql.*, java.net.*,java.io.*,java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");

		String jump = request.getParameter("jump");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		//out.print(pwd+"<br>");

		//여기서 엉뚱한 값을 체크해야 하는데 생략함

		//

		//세션뿐 아니라 관리자 db에서도 로그인 체크
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/song?useSSL=false", "root", "1234");
		String sql = "SELECT * FROM adminfo;";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rset =  pstmt.executeQuery();
		
		rset.next();
		
		boolean bPassChk = false;

		//아이디, 패스워드 체크
		if (id.replaceAll(" ", "").equals("admin") && pwd.replaceAll(" ", "").equals("1234")) {
			bPassChk = true;
			//out.print("ddd");
 		}
		else if(rset.getString(1).equals(id.replaceAll(" ", "")) && rset.getString(2).equals(pwd.replaceAll(" ", ""))){
			bPassChk = true;
			//out.print("zzz");
		}else {
			bPassChk = false;
		}
		

		rset.close();
		pstmt.close();
		conn.close();
		//out.print(bPassChk);
		//패스워드 체크가 끝나면, 세션을 기록하고 점프한다
		if (bPassChk) {
			session.setAttribute("login_ok", "yes");
			session.setAttribute("login_id", id);
			//response.sendRedirect(jump); //로그인 체크후 돌아갈 곳
			//response.sendRedirect("../"+jump); //로그인 체크후 돌아갈 곳
			
			out.print("<script>alert(\"로그인되었습니다.\");"
						+"window.location.href='../index.jsp'</script>");
		} else {
	%>
	<!-- 		<h2>아이디 또는 패스워드 오류</h2> -->
	<%-- 		<input type="button" value="로그인" onclick="location.href='login.jsp?jump=<%=jump %>'"> --%>
			<script>
 				alert("아이디 또는 패스워드 오류");
				window.location.href = "login.jsp?jump=<%=jump %>";
			</script>

	<%
		
		}
	%>
</body>
</html>