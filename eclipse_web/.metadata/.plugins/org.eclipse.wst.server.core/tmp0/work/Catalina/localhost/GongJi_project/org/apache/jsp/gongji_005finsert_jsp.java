/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-07-24 06:03:33 UTC
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

public final class gongji_005finsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>공지사항 하나를 입력하는 화면</title>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t#wrap {\r\n");
      out.write("\t\t\tdisplay: flex;\r\n");
      out.write("\t\t\t/* justify-content: center; */\r\n");
      out.write("\t\t\talign-items: center;  \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttable{\r\n");
      out.write("\t\t\tborder-collapse: collapse;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.tr123 {\r\n");
      out.write("\t\t\theight:3em;\r\n");
      out.write("\t\t\tborder-bottom:1px solid;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tth {\r\n");
      out.write("\t\t\twidth:50px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttd {\r\n");
      out.write("\t\t\tpadding-left:2em;\r\n");
      out.write("\t\t\twidth:500px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#divButton {\r\n");
      out.write("\t\t    width: 550px;\r\n");
      out.write("    \t\ttext-align: right;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#title {\r\n");
      out.write("\t\t\twidth: 400px;\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttextarea {\r\n");
      out.write("\t\t\twidth: 500px; \r\n");
      out.write("\t\t\theight: 350px; \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.Content  {\r\n");
      out.write("\t\t\theight: 400px; \r\n");
      out.write("\t\t\tborder-bottom:1px solid; \r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tform {\r\n");
      out.write("\t\t\theight:100%;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"se2/js/service/HuskyEZCreator.js\" charset=\"utf-8\"></script>\r\n");
      out.write("\t");

		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar calt = Calendar.getInstance();
		//out.print(sdf.format(calt.getTime())); 
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여\r\n");
      out.write("\t\tfunction submitForm(mode) {\r\n");
      out.write("\t\t\t/* const fm = document.getElementById(\"fm\"); */\r\n");
      out.write("\t        if(mode == 'write'){\r\n");
      out.write("\t        \tconst title = document.getElementById('title');\r\n");
      out.write("\t\t        oEditors.getById[\"content\"].exec(\"UPDATE_CONTENTS_FIELD\", []);\r\n");
      out.write("\t\t        const content = document.getElementById('content');\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t        \r\n");
      out.write("\t\t        //값이 널일때 잡음\r\n");
      out.write("\t\t        if(title.value.trim() == \"\" || content.value.trim() == \"\"){\r\n");
      out.write("\t                alert(\"값을 입력해주세요\");\r\n");
      out.write("\t                return;\r\n");
      out.write("\t            }\r\n");
      out.write("\t\t        else if(content.value.trim().length >=500){\r\n");
      out.write("\t\t        \talert(\"글은 500자 까지만\");\r\n");
      out.write("\t\t        \treturn;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t            fm.action = \"?contentPage=gongji_write.jsp?key=INSERT\";  \r\n");
      out.write("\t           \r\n");
      out.write("\t        }else if(mode =='cancle'){\r\n");
      out.write("\t        \tfm.action = \"?contentPage=gongji_list.jsp\";\r\n");
      out.write("\t        \t\r\n");
      out.write("\t        }\r\n");
      out.write("\t        fm.submit();\r\n");
      out.write("\t    } \r\n");
      out.write("\t\t\r\n");
      out.write("        \r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=wrap>\r\n");
      out.write("\t<form method=\"POST\" id=fm enctype=\"multipart/form-data\">\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr class=tr123>\r\n");
      out.write("\t\t\t<th>번호</th><td>신규(insert)</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=tr123>\r\n");
      out.write("\t\t\t<th>제목</th><td><input type=\"text\" name=title id='title' maxlength=\"70\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=tr123>\r\n");
      out.write("\t\t\t<th>일자</th>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t");
      out.print(sdf.format(calt.getTime()) );
      out.write("\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=Content>\r\n");
      out.write("\t\t<!-- textarea로 긴 문장을 입력받기 -->\r\n");
      out.write("\t\t\t<th>내용</th>\r\n");
      out.write("\t\t\t<td><textarea id=\"content\" name=\"content\"  wrap=\"hard\" id=\"content\" maxlength=\"6000\"></textarea></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr style=\"border-bottom:1px solid; height: 5em;\" >\r\n");
      out.write("\t\t\t<th>파일 업로드</th>\r\n");
      out.write("\t\t\t<td><input type=\"file\" name=file1 style=\"margin-bottom: 10px;\"><input type=\"file\" name=file2></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div id=\"divButton\">\r\n");
      out.write("\t\t<span><input type=\"button\" value=취소 id=cancle onclick='submitForm(\"cancle\")'></span>\r\n");
      out.write("\t\t<span><input type=\"button\" value=쓰기 id=write onclick='submitForm(\"write\")'></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar oEditors = [];\r\n");
      out.write("\tnhn.husky.EZCreator.createInIFrame({\r\n");
      out.write("\t oAppRef: oEditors,\r\n");
      out.write("\t elPlaceHolder: \"content\",\r\n");
      out.write("\t sSkinURI: \"se2/SmartEditor2Skin.html\",\r\n");
      out.write("\t fCreator: \"createSEditor2\"\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
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
