/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-07-25 02:06:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import GongJi.UseDB;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class gongji_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("GongJi.UseDB");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>공지 글 하나 select 화면</title>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t#wrap { \r\n");
      out.write("\t\t\tdisplay: flex;\r\n");
      out.write("\t\t\t/* justify-content: center; */\r\n");
      out.write("\t\t\talign-items: center;  \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttable{\r\n");
      out.write("\t\t\tborder-collapse: collapse;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttr {\r\n");
      out.write("\t\t\theight:3em;\r\n");
      out.write("\t\t\tborder-bottom:1px solid;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tth {\r\n");
      out.write("\t\t\twidth:80px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.td {\r\n");
      out.write("\t\t\tpadding-left:2em;\r\n");
      out.write("\t\t\twidth:500px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.tdfile {\r\n");
      out.write("\t\t\tdisplay:flex;\r\n");
      out.write("\t\t\talign-items: center;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#divButton{\r\n");
      out.write("\t\t    width: 450px;\r\n");
      out.write("    \t\ttext-align: right;\r\n");
      out.write("\t\t}\r\n");
      out.write("/* \t\ttextarea {width: 450px;height: 200px;} */\r\n");
      out.write("\t\t#divContent {\r\n");
      out.write("\t\t\tmargin-left:2em;\r\n");
      out.write("\t\t\twidth: 500px;\r\n");
      out.write("\t\t\theight: 170px;\r\n");
      out.write("\t\t\toverflow: auto;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\timg { \r\n");
      out.write(" \t\t\tmax-width: auto;\r\n");
      out.write("    \t\tmax-height: 7em;\r\n");
      out.write("    \t\tpadding-left: 5em;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.divFile {\r\n");
      out.write("\t\t\tline-height:45px;\r\n");
      out.write("\t\t\tmargin-left:2em;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t");

		//날짜 출력 처리
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calt = Calendar.getInstance();
		
		// 값 받기
		String idTemp = request.getParameter("keyId");
		int id = Integer.parseInt(idTemp);
		
		//
		UseDB udb = new UseDB();
		Statement stmt = udb.statementDB();
		
		String sql2 = "select viewcnt from gongji where id="+id+";";
		ResultSet rset2 = stmt.executeQuery(sql2);
		rset2.next();
		int viewcnt = rset2.getInt(1)+1;
		
		String sql3 = "update gongji set viewcnt="+viewcnt+" where id="+id+";";
		stmt.execute(sql3);
		
		String sql = "SELECT * FROM gongji where id="+id+";";
		ResultSet rset = stmt.executeQuery(sql);
		rset.next();
		
	
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=wrap>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>번호</th>\r\n");
      out.write("\t\t\t<td class=\"td\">");
      out.print(rset.getInt(1) );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t<td class=\"td\">");
      out.print(rset.getString(2) );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>일자</th>\r\n");
      out.write("\t\t\t<td class=\"td\">");
      out.print(rset.getString(3) );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>조회수</th>\r\n");
      out.write("\t\t\t<td class=\"td\">");
      out.print(rset.getString(8) );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>내용</th>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<td><div id=divContent>");
      out.print(rset.getString(4) );
      out.write("</div></td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>원글</th>\r\n");
      out.write("\t\t\t<td class=\"td\">");
      out.print(rset.getString(5) );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>댓글수준</th>\r\n");
      out.write("\t\t\t<td class=\"td\">");
      out.print(rset.getString(6) );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>댓글순서</th>\r\n");
      out.write("\t\t\t<td class=\"td\">");
      out.print(rset.getString(7) );
      out.write("</td></tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>파일1</th><!-- 신규등록시 이미지를 안올렸을때 -->\r\n");
      out.write("\t\t\t<td class=tdfile>\r\n");
      out.write("\t\t\t");

				String file1 ="";
				String file1Type ="";
				
				if(rset.getString(9)==null){
					file1="파일 없음";
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=divFile>");
      out.print(file1 );
      out.write("</div>\r\n");
      out.write("\t\t\t");
		
				}else{
					file1 = rset.getString(9).trim();
					file1Type = file1.substring(file1.length()-3, file1.length());
					
					if(file1Type.equals("jpg") || file1Type.equals("png")) {
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=divFile><a href=\"upload/");
      out.print(file1 );
      out.write("\" download>");
      out.print(file1 );
      out.write("</a></div>\t\r\n");
      out.write("\t\t\t\t\t\t<img src=\"upload/");
      out.print(file1 );
      out.write("\">\r\n");
      out.write("\t\t\t");
		}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=divFile><a href=\"upload/");
      out.print(file1 );
      out.write("\" download>");
      out.print(file1 );
      out.write("</a></div>\r\n");
      out.write("\t\t\t");
 			
					}
				}
			
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>파일2</th>\r\n");
      out.write("\t\t\t<td class=tdfile>\r\n");
      out.write("\t\t\t");

				String file2 ="";
				String file2Type ="";
				
				if(rset.getString(10)==null){
					file2="파일 없음";
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=divFile>");
      out.print(file2 );
      out.write("</div>\r\n");
      out.write("\t\t\t");
		
				}else{
					file2 = rset.getString(10).trim();
					file2Type = file2.substring(file2.length()-3, file2.length());
					
					if(file2Type.equals("jpg") || file2Type.equals("png")) {
			
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=divFile><a href=\"upload/");
      out.print(file2 );
      out.write("\" download>");
      out.print(file2 );
      out.write("</a></div>\t\r\n");
      out.write("\t\t\t\t\t\t<img src=\"upload/");
      out.print(file2 );
      out.write("\">\r\n");
      out.write("\t\t\t");
		}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=divFile><a href=\"upload/");
      out.print(file2 );
      out.write("\" download>");
      out.print(file2 );
      out.write("</a></div>\r\n");
      out.write("\t\t\t");
 			
					}
				}
			
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<form method=\"POST\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"keyId\" value =");
      out.print(id );
      out.write(">\r\n");
      out.write("\t<input type=\"hidden\" name=\"rootid\" value =");
      out.print(rset.getString(5) );
      out.write(">\r\n");
      out.write("\t<input type=\"hidden\" name=\"relevel\" value =");
      out.print(rset.getString(6) );
      out.write(">\r\n");
      out.write("\t<input type=\"hidden\" name=\"recnt\" value =");
      out.print(rset.getString(7) );
      out.write(">\r\n");
      out.write("\t<!-- 뒤로가기 버튼과 수정 버튼 -->\r\n");
      out.write("\t<div id=divButton>\r\n");
      out.write("\t\t<span><input type=\"submit\" value=목록 formaction=\"?contentPage=gongji_list.jsp\"></span>\r\n");
      out.write("\t\t<span><input type=\"submit\" value=수정 formaction=\"?contentPage=gongji_update.jsp\"></span>\r\n");
      out.write("\t\t<span><input type=\"submit\" value=댓글 formaction=\"?contentPage=gongji_reinsert.jsp\"></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");
	
		rset.close();
		rset2.close();
	    stmt.close();
	    udb.close();
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}