<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dbtest</title>
</head>
<body>
<%
    Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			out.println("드라이버 호출 성공<br>");
			//String ip = "192.168.23.96";
 			//String ip = "localhost";
 			
 			String ip = "192.168.56.102";
 			
			String port = ":3306/";
			String dbname = "song?useSSL=false";
			String dbID = "root";
			String dbPW = "1234";

			conn = DriverManager.getConnection("jdbc:mysql://" + ip + port + dbname, dbID, dbPW);
			out.println("커넥션 연결 성공<br>");
			
			Statement stmt = conn.createStatement();

			String QueryTxt;
			QueryTxt = ("select * from testDB;");
            out.print("쿼리 이상없음<br>");
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				out.print(rset.getString(1)+", ");
				out.print(rset.getString(2)+", ");
				out.println(rset.getString(3));

			}
		rset.close();
		stmt.close();
		conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace(); 
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
%>
</body>
</html>