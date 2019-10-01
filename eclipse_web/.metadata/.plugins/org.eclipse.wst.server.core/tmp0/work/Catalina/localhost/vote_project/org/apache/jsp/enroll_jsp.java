/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-07-15 04:31:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import vote_project.connectDB;

public final class enroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

int id = 0; 
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
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("vote_project.connectDB");
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
      out.write("<title>후보등록/삭제</title>\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\ttable {\r\n");
      out.write("\t\t\tborder-collapse: collapse;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttd {\r\n");
      out.write("\t\t\tborder: 1px solid;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tinput {\r\n");
      out.write("\t\t\twidth : 80px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("<!-- 후보등록시 자동입력되는 기호번호 -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
	
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
	
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("        // 입력값 제외 function\r\n");
      out.write("        // 입력값의 문자 종류 판별하는 함수\r\n");
      out.write("        function check_key() { \r\n");
      out.write("            var char_ASCII = event.keyCode;\r\n");
      out.write("            //숫자\r\n");
      out.write("            if (char_ASCII >= 48 && char_ASCII <= 57)\r\n");
      out.write("                return 1;\r\n");
      out.write("            //영어\r\n");
      out.write("            else if ((char_ASCII >= 65 && char_ASCII <= 90) || (char_ASCII >= 97 && char_ASCII <= 122))\r\n");
      out.write("                return 2;\r\n");
      out.write("            //특수기호\r\n");
      out.write("            else if ((char_ASCII >= 33 && char_ASCII <= 47) || (char_ASCII >= 58 && char_ASCII <= 64)\r\n");
      out.write("                || (char_ASCII >= 91 && char_ASCII <= 96) || (char_ASCII >= 123 && char_ASCII <= 126))\r\n");
      out.write("                return 4;\r\n");
      out.write("            //한글\r\n");
      out.write("            else if ((char_ASCII >= 12592) || (char_ASCII <= 12687))\r\n");
      out.write("                return 3;\r\n");
      out.write("            //그 밖에\r\n");
      out.write("            else\r\n");
      out.write("                return 0;\r\n");
      out.write("        }\r\n");
      out.write("        //한글만 입력하도록 하는 함수\r\n");
      out.write("        function onlyHan() {\r\n");
      out.write("            if (check_key() != 3) {\r\n");
      out.write("                event.returnValue = false;\r\n");
      out.write("                alert(\"한글만 입력하세요.\");\r\n");
      out.write("                return;//리턴으로 아무것도 안 뱉으면 함수가 끝난다\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        //널값 제외 함수\r\n");
      out.write("        function limitNull() {\r\n");
      out.write("            const insert = document.getElementById('insert');//form을 받아옴\r\n");
      out.write("            const inputName = document.getElementById('name');//인풋타입텍스트들을 받아옴\r\n");
      out.write("          \r\n");
      out.write("            if(inputName.value ==\"\"){\r\n");
      out.write("                alert(\"입력값이 없는지 확인 해 보세요\");\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            insert.submit(); \r\n");
      out.write("        }\r\n");
      out.write("       \r\n");
      out.write("        </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h3 style=\"margin-left: 2em\">후보등록</h3>\t\r\n");
      out.write("\t<table>\r\n");
      out.write("\t");
 while (rset.next()) { 
      out.write(" <!-- 현재 등록되어 있는 후보들을 보여줌 -->\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<form method=\"POST\" action=\"?contentPage=delete.jsp\">\r\n");
      out.write("\t\t\t\t<td><input type=\"hidden\" value=\"");
      out.print(rset.getInt(1));
      out.write("\" name=\"toDelId\">기호번호 : ");
      out.print(rset.getInt(1));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>후보명 : ");
      out.print(rset.getString(2));
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"submit\" value=\"삭제\" ></td>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t<!-- 후보등록을 추가할때 필요한 입력값 -->\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<form method=\"POST\" action=\"?contentPage=insert.jsp\" id=\"insert\">\r\n");
      out.write("\t\t\t\t<td>기호번호 : <input type=\"text\" value=\"");
      out.print(id );
      out.write("\" readonly=\"readonly\" name=\"toInsertId\" ></td>\r\n");
      out.write("\t\t\t\t<td>후보명 : <input type=\"text\" name=\"toInsertName\" onkeypress='onlyHan()' id=\"name\"></td>\r\n");
      out.write("\t\t\t\t<td><input type=\"button\" value=\"추가\" onclick=\"limitNull()\"></td>\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");

		rset.close();
	    stmt.close();
	    cdb.close();
	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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