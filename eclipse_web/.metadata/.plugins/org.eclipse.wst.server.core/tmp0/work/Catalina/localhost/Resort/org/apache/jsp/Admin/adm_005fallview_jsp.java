/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-06 00:26:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import useDB.UseDB_Reserve;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public final class adm_005fallview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("useDB.UseDB_Reserve");
    _jspx_imports_classes.add("java.util.ArrayList");
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

	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	//db연결 예약목록과 실제 db저장된 예약내용을 비교하기
	UseDB_Reserve udbR = new UseDB_Reserve();
	ResultSet rset = udbR.selectRsv();
	

      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t//jquery 문서 돔이 준비가 되면 함수를 호출\r\n");
      out.write("\t$( document ).ready(function() {\r\n");
      out.write("\t\trsv_color();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t//예약불가에 색깔 입히기\r\n");
      out.write("\tfunction rsv_color(){\r\n");
      out.write("\r\n");
      out.write("\t\t//클래스 reservation-by-day를 가져와서 그 자식들(e 만큼 for each를  돌림\r\n");
      out.write("\t\t//.each(function)은 문법\r\n");
      out.write("\t\t//i는 인덱스 item은 그 자식들\r\n");
      out.write("// \t\t$('.reservation_by_day').each(function (i, item) {\r\n");
      out.write("// \t\t\t//console.log(i, item);\r\n");
      out.write("\t\t\t\r\n");
      out.write("// // \t\t\tvar e0 = item.children[0]; //날짜 td\r\n");
      out.write("// // \t\t\tvar e1 = item.children[1].childNodes[0];//td의 a 태그\r\n");
      out.write("// // \t\t\tvar e2 = item.children[2].childNodes[0];\r\n");
      out.write("// // \t\t\tvar e3 = item.children[3].childNodes[0];\r\n");
      out.write("\t\t\t\r\n");
      out.write("// // \t\t\tif (e1.text != '예약가능') {\r\n");
      out.write("// // \t\t\t\te1.classList.add(\"booked\"); //클래스를 붙여줌\r\n");
      out.write("\t\t\t\r\n");
      out.write("// // // \t\t\t\te1.setAttribute('href', '?contentPage=Admin/adm_oneview.jsp?day='+e0+'&room=1');\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("// // // \t\t\t\tdocument.getElementById('id_value').setAttribute('title', 'It is kkamikoon Title');\r\n");
      out.write("\r\n");
      out.write("// // \t\t\t}\r\n");
      out.write("// // \t\t\tif(e2.text !== '예약가능') {\r\n");
      out.write("// // \t\t\t\te2.classList.add(\"booked\");\r\n");
      out.write("// // // \t\t\t\te2.setAttribute('href', '?contentPage=Admin/adm_oneview.jsp?day='+e0+'&room=2');\r\n");
      out.write("// // \t\t\t}\r\n");
      out.write("// // \t\t\tif(e3.text !== '예약가능') {\r\n");
      out.write("// // \t\t\t\te3.classList.add(\"booked\");\r\n");
      out.write("// // // \t\t\t\te3.setAttribute('href', '?contentPage=Admin/adm_oneview.jsp?day='+e0+'&room=3');\r\n");
      out.write("// // \t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("// \t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write(".booked {\r\n");
      out.write("   \tcolor: red;  \r\n");
      out.write("/*  \tpointer-events:none; */\r\n");
      out.write("/*  \tcursor:default; */\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<table id=\"basicTB\" width=\"100%\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th class=\"collum1\">날짜</th>\r\n");
      out.write("\t\t\t\t<th class=\"collum2\">vip룸</th>\r\n");
      out.write("\t\t\t\t<th class=\"collun3\">일반룸</th>\r\n");
      out.write("\t\t\t\t<th class=\"collum4\">합리룸</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead> \r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t");

				rset.beforeFirst();
				String korDay = "";
				while(rset.next()) {
					
					switch (rset.getInt(2)) {
						case 1: korDay = "(일)"; break;
						case 2: korDay = "(월)"; break;
						case 3: korDay = "(화)"; break;
						case 4: korDay = "(수)"; break;
						case 5: korDay = "(목)"; break;
						case 6: korDay = "(금)"; break;
						case 7: korDay = "(토)"; break;
						
					}
			
      out.write("\r\n");
      out.write("\t\t\t<tr class=\"reservation_by_day\">\r\n");
      out.write("\t\t\t\t<td class=\"rsv_td\">");
      out.print(rset.getString(1) );
      out.print(korDay);
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
 if(rset.getString(3).equals("예약가능")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a class=\"room1\"\r\n");
      out.write("\t\t\t\t\thref=\"?contentPage=Reserve/Reserve_insert.jsp?day=");
      out.print(rset.getString(1));
      out.write("&room=1&key=adm\">");
      out.print(rset.getString(3) );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a class=\"room1\" style=\"color:red;\"\r\n");
      out.write("\t\t\t\t\thref=\"?contentPage=Admin/adm_oneview.jsp?day=");
      out.print(rset.getString(1));
      out.write("&room=1\">");
      out.print(rset.getString(3) );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write(" \t\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
 if(rset.getString(4).equals("예약가능")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a class=\"room2\"\r\n");
      out.write("\t\t\t\t\thref=\"?contentPage=Reserve/Reserve_insert.jsp?day=");
      out.print(rset.getString(1));
      out.write("&room=2&key=adm\">");
      out.print(rset.getString(4) );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a class=\"room2\" style=\"color:red;\"\r\n");
      out.write("\t\t\t\t\thref=\"?contentPage=Admin/adm_oneview.jsp?day=");
      out.print(rset.getString(1));
      out.write("&room=2&\">");
      out.print(rset.getString(4) );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
 if(rset.getString(5).equals("예약가능")){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a class=\"room3\"\r\n");
      out.write("\t\t\t\t\thref=\"?contentPage=Reserve/Reserve_insert.jsp?day=");
      out.print(rset.getString(1));
      out.write("&room=3&key=adm\">");
      out.print(rset.getString(5) );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a class=\"room3\" style=\"color:red;\"\r\n");
      out.write("\t\t\t\t\thref=\"?contentPage=Admin/adm_oneview.jsp?day=");
      out.print(rset.getString(1));
      out.write("&room=3\">");
      out.print(rset.getString(5) );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				}
				rset.close();
				udbR.close();
			
      out.write("\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
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
