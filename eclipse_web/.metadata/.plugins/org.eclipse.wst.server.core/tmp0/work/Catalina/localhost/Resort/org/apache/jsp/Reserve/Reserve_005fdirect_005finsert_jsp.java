/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-12 00:07:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Reserve;

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

public final class Reserve_005fdirect_005finsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");

	//이페이지에서는 예약일과 방만 먼저 입력 받아 예약가능여부 판단 페이지에 값을 넘겨준다	


	//input date 날짜 시작 끝 구하기 =인풋 타입 date의 min 옵션과 max옵션
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String startDate = sdf.format(cal.getTime());
	cal.add(cal.MONTH, +1);
	cal.add(cal.DATE, -1);//내 쿼리가 31일이거나 30일 일 수 있다 그래서 -1해줌
	String endDate = sdf.format(cal.getTime());	
	

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여\r\n");
      out.write("\tfunction submitForm(mode) {\r\n");
      out.write("\t\t/* const fm = document.getElementById(\"fm\"); */\r\n");
      out.write("\t\tif (mode == 'write') {\r\n");
      out.write("\t\t\tconst date = document.getElementById('inputDate');\r\n");
      out.write("\t\t\tconst room = document.getElementById('inputRoom');\r\n");
      out.write("\t\t\t\r\n");
      out.write("// \t\t\tconsole.log(name, room);\r\n");
      out.write("\r\n");
      out.write("\t\t\t//값이 널일때 잡음\r\n");
      out.write("\t\t\tif (date.value.trim() == \"\") {\r\n");
      out.write("\t\t\t\talert(\"날짜를 선택해주세요\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\t\t\tif (room.value.trim() == \"\") {\r\n");
      out.write("\t\t\t\talert(\"방을 선택해주세요\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\r\n");
      out.write("\t\t\tfm.action = \"?contentPage=Reserve/Reserve_able_decide.jsp\";\r\n");
      out.write("\t\t\t//fm.submit();\r\n");
      out.write("\t\t} else if (mode == 'cancle') {\r\n");
      out.write("\t\t\tfm.action = \"?contentPage=Reserve/Reserve_list.jsp\";\r\n");
      out.write("\t\t\t//window.history.go(-1);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\tfm.submit();\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<form method=\"POST\" id=fm>\r\n");
      out.write("\t\t<table id=\"basicTB\" width=\"100%\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th colspan=2>예약일, 방선택</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</thead>\r\n");
      out.write("\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>예약날짜</th>\r\n");
      out.write("\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t<!-- 인풋타입이 date면 입력란이 날짜로 나옴 민맥스옵션은 날짜의 활성화를 함 -->\r\n");
      out.write("\t\t\t\t\t\t<input type=\"date\" name=\"date\" id=\"inputDate\" min='");
      out.print(startDate );
      out.write("' max='");
      out.print(endDate );
      out.write("' > \r\n");
      out.write("\t\t\t\t\t\t오늘부터 한달 후 까지만 예약가능 합니다.\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th>예약방</th>\r\n");
      out.write("\t\t\t\t\t<!-- 셀렉트 태그를 사용하면 드롭방식형식의 input이 가능 -->\r\n");
      out.write("\t\t\t\t\t<td><select name=\"room\" id=\"inputRoom\">\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"\">방선택</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"1\">vip룸</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"2\">일반룸</option>\r\n");
      out.write("\t\t\t\t\t\t\t<option value=\"3\">합리룸</option>\r\n");
      out.write("\t\t\t\t\t</select></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</tbody>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<!-- 디비를 뒤지기 위해 필요한 변수를 보낸다 -->\r\n");
      out.write("\t\t<input type=\"hidden\" name=startDate value=");
      out.print(startDate );
      out.write(">\r\n");
      out.write("\t\t<input type=\"hidden\" name=endDate value=");
      out.print(endDate );
      out.write(">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div id=\"divButton\" style=\"width: 100%; text-align: right;\">\r\n");
      out.write("\t\t\t<span><input class=\"btn btn-success\" type=\"button\" value=취소\r\n");
      out.write("\t\t\t\tid=cancle onclick='submitForm(\"cancle\")'></span> <span><input\r\n");
      out.write("\t\t\t\tclass=\"btn btn-success\" type=\"button\" value=선택 id=write\r\n");
      out.write("\t\t\t\tonclick='submitForm(\"write\")'></span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
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