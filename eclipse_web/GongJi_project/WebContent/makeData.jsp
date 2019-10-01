<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,GongJi.UseDB,java.io.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디비연결 클래스</title>
</head>
<body>
	<%
		UseDB udb = new UseDB();
		Statement stmt = udb.statementDB();
		
		/* stmt.execute("create table gongji("+ 
				" id int not null primary key auto_increment,"
                + "title varchar (70), "
                + "date date, "
                + "content text)"
                + "DEFAULT CHARSET=utf8;");
		out.print("테이블 생성 완료");
		 */
		 
		stmt.execute("insert into gongji (title, date, content) values ('공지사항1', date(now()), '공지사항 1 내용');");
		stmt.execute("insert into gongji (title, date, content) values ('공지사항2', date(now()), '공지사항 2 내용');");
		stmt.execute("insert into gongji (title, date, content) values ('공지사항3', date(now()), '공지사항 3 내용');");
		stmt.execute("insert into gongji (title, date, content) values ('공지사항4', date(now()), '공지사항 4 내용');");
		stmt.execute("insert into gongji (title, date, content) values ('공지사항5', date(now()), '공지사항 5 내용');");
		out.print("데이터 입력 완료");
		
		stmt.close();
		udb.close();
	%>
</body>
</html>