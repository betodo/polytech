/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-12 06:33:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mobile.Comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import useDB.UseDB_Comment;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Comment_005freinsert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("useDB.UseDB_Comment");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
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

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	Calendar calt = Calendar.getInstance();
	//out.print(sdf.format(calt.getTime())); 

	//원글 번호 받기 = 조회한 글의 id
	String rootidTemp = request.getParameter("rootid");
	int rootid = Integer.parseInt(rootidTemp);

	//댓글 수준 받기 = 조회한 글의 댓글 수준 +1
	String relevelTemp = request.getParameter("relevel");
	int relevel = Integer.parseInt(relevelTemp) + 1;

	//댓글 내 순서
	String recntTemp = request.getParameter("recnt");
	int recnt = Integer.parseInt(recntTemp);
	

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여\r\n");
      out.write("\tfunction submitForm(mode) {\r\n");
      out.write("\t\t/* const fm = document.getElementById(\"fm\"); */\r\n");
      out.write("\t\tif (mode == 'write') {\r\n");
      out.write("\t\t\tconst title = document.getElementById('title');\r\n");
      out.write("\t\t\tconst content = document.getElementById('summernote');\r\n");
      out.write("\r\n");
      out.write("\t\t\t//값이 널일때 잡음\r\n");
      out.write("\t\t\tif (title.value.trim() == \"\" || content.value.trim() == \"\") {\r\n");
      out.write("\t\t\t\talert(\"값을 입력해주세요\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t} else if (content.value.trim().length > 500) {\r\n");
      out.write("\t\t\t\talert(\"글은 500자 이내\");\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfm.action = \"?contentPage=Comment/Comment_write.jsp?key=INSERT_RE\";\r\n");
      out.write("\r\n");
      out.write("\t\t} else if (mode == 'cancle') {\r\n");
      out.write("\t\t\tfm.action = \"?contentPage=Comment/Comment_list.jsp\";\r\n");
      out.write("\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfm.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<form method=\"POST\" id=fm enctype=\"multipart/form-data\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"rootid\" value=\"");
      out.print(rootid );
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"relevel\" value=\"");
      out.print(relevel );
      out.write("\"> \r\n");
      out.write("\t<input type=\"hidden\" name=\"recnt\" value=\"");
      out.print(recnt );
      out.write("\">\r\n");
      out.write("\t\t<table id=\"basicTB\" width=\"100%\">\r\n");
      out.write("\t\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th colspan=2>후기 댓글 작성</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t\t<tr class=tr123>\r\n");
      out.write("\t\t\t\t<th>번호</th>\r\n");
      out.write("\t\t\t\t<td>자동입력</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr class=tr123>\r\n");
      out.write("\t\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=title id='title' maxlength=\"70\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr class=tr123>\r\n");
      out.write("\t\t\t\t<th>일자</th>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(sdf.format(calt.getTime()));
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr class=Content>\r\n");
      out.write("\t\t\t\t<!-- textarea로 긴 문장을 입력받기 -->\r\n");
      out.write("\t\t\t\t<th>내용</th>\r\n");
      out.write("\t\t\t\t<td><textarea id=\"summernote\" name=\"content\" wrap=\"hard\"\r\n");
      out.write("\t\t\t\t\t\tmaxlength=\"6000\"></textarea></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr style=\"border-bottom: 1px solid; height: 5em;\">\r\n");
      out.write("\t\t\t\t<th>파일 업로드</th>\r\n");
      out.write("\t\t\t\t<td><input type=\"file\" name=file1 style=\"margin-bottom: 10px;\">\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" name=file2></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<div id=\"divButton\" style=\"text-align:right;\">\r\n");
      out.write("\t\t\t<span><input class=\"btn btn-success\" type=\"button\" value=취소 id=cancle\r\n");
      out.write("\t\t\t\tonclick='submitForm(\"cancle\")'></span> \r\n");
      out.write("\t\t\t<span><input class=\"btn btn-success\"\r\n");
      out.write("\t\t\t\ttype=\"button\" value=쓰기 id=write onclick='submitForm(\"write\")'></span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$('#summernote')\r\n");
      out.write("\t\t\t.summernote(\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t//placeholder: 'Hello bootstrap 4',\r\n");
      out.write("\t\t\t\t\t\ttabsize : 2,\r\n");
      out.write("\t\t\t\t\t\theight : 100,\r\n");
      out.write("\t\t\t\t\t\ttoolbar : [\r\n");
      out.write("\t\t\t\t\t\t\t\t// [groupName, [list of button]]\r\n");
      out.write("\t\t\t\t\t\t\t\t[\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t'style',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t[ 'bold', 'italic', 'underline',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'clear' ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\t[\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t'font',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t[ 'strikethrough', 'superscript',\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t'subscript' ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\t[ 'fontsize', [ 'fontsize' ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\t[ 'color', [ 'color' ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\t[ 'para', [ 'ul', 'ol', 'paragraph' ] ],\r\n");
      out.write("\t\t\t\t\t\t\t\t[ 'height', [ 'height' ] ] ]\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
