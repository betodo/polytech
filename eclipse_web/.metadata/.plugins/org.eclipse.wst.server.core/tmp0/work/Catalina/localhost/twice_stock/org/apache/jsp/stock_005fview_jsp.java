/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-07-19 04:29:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import twice_stock_pac.UseDB;
import java.io.*;

public final class stock_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("twice_stock_pac.UseDB");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>stock_view</title>\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\ttable {\r\n");
      out.write("\t\t\tborder-collapse: collapse;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttbody>tr {\r\n");
      out.write("\t\t\theight:2em;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttfoot>tr {\r\n");
      out.write("\t\t\theight:20em;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tth {\r\n");
      out.write("\t\t\tborder:1px solid;\r\n");
      out.write("\t\t\twidth:10em;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\ttd {\r\n");
      out.write("\t\t\tpadding-left:1em;\r\n");
      out.write("\t\t\ttext-align:left;\r\n");
      out.write("\t\t\tborder:1px solid;\r\n");
      out.write("\t\t\twidth:30em;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t#divButton {\r\n");
      out.write("    \t\ttext-align: right;\r\n");
      out.write("\t\t} \t\t\r\n");
      out.write("\t\timg { \r\n");
      out.write(" \t\t\tmax-width: 20em;\r\n");
      out.write("    \t\tmax-height: 15em;\r\n");
      out.write("    \t\tpadding-left: 5em;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t} \r\n");
      out.write("\t</style>\r\n");
      out.write("\t");
 
		// stoc_list링크가 주는 값 받기
		String idTemp = request.getParameter("keyId");
		int id = Integer.parseInt(idTemp);
		
		//db연결
		UseDB udb = new UseDB();
		//1 row 조회
		ResultSet rset = udb.selectOneTw_stock(id);
		rset.next();
		
	
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//form 안에 버튼이 2개일때 처리 모드를 변수로 받아 다른 액션을 부여\r\n");
      out.write("\t\tfunction submitForm(mode) {\r\n");
      out.write("\t\t\t/* const fm = document.getElementById(\"fm\"); */\r\n");
      out.write("\t        if(mode == 'update'){\r\n");
      out.write("\t        \tconst stockCnt = document.getElementById('stockCnt');\r\n");
      out.write("\t        \t\r\n");
      out.write("\t        \t//값이 널일때 잡음\r\n");
      out.write("\t\t        if(stockCnt.value.trim() == \"\"){\r\n");
      out.write("\t                alert(\"값을 입력해주세요\");\r\n");
      out.write("\t                return;\r\n");
      out.write("\t            } \r\n");
      out.write("\t            fm.action = \"?contentPage=stock_write.jsp?key=UPDATE\";  \r\n");
      out.write("\t            \r\n");
      out.write("\t        }else if(mode =='del'){\r\n");
      out.write("\t        \tfm.action = \"?contentPage=stock_delete.jsp?key=DELETE\";\r\n");
      out.write("\t        } else{\r\n");
      out.write("\t        \tfm.action = \"?contentPage=stock_list.jsp\"; \r\n");
      out.write("\t        } \r\n");
      out.write("\t        //액션 지정뒤 이동\r\n");
      out.write("\t        fm.submit();\r\n");
      out.write("\t        \r\n");
      out.write("\t    } \r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<h1>(주) 트와이스 재고 현황-상품상세</h1>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<form method=\"POST\" id=fm>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>상품번호</th><td>");
      out.print(rset.getInt(1) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(rset.getInt(1) );
      out.write("\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>상품명</th><td>");
      out.print(rset.getString(2) );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"name\" value=\"");
      out.print(rset.getString(2) );
      out.write("\">\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- 보여주는 화면이지만 바로 재고수정 가능하도록 재고수정을 인풋으로 작성하게함 -->\r\n");
      out.write("\t\t\t\t<th>재고현황</th> ");
      out.write("\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"stockCnt\" id=\"stockCnt\"  maxlength=\"3\" value=\"");
      out.print(rset.getInt(3) );
      out.write("\" onKeyup=\"this.value=this.value.replace(/[^0-9]/g,'');\" ></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>상품 등록일</th><td>");
      out.print(rset.getString(4) );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>재고 등록일</th><td>");
      out.print(rset.getString(5) );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>상품 설명</th><td>");
      out.print(rset.getString(6) );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t<tfoot>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>상품 사진</th><!-- 신규등록시 이미지를 안올렸을때 -->\r\n");
      out.write("\t\t\t\t");
if(rset.getString(7).trim().equals("upload_imgs/null")) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td>이미지가 없습니다.</td>\r\n");
      out.write("\t\t\t\t");
} else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<td><img src=\"");
      out.print(rset.getString(7) );
      out.write("\"></td>\r\n");
      out.write("<!-- \t\t\t\t\t<th>상품 사진</th><td><img src=\"./upload_imgs/bananamilk.jpg\"></td> -->\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tfoot>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<div id=\"divButton\">\r\n");
      out.write("\t\t<span><input type=\"button\" value=\"목록\" id=cancle onclick='submitForm(\"cancle\")'></span>\r\n");
      out.write("\t\t<span><input type=\"button\" value=상품삭제 id=del onclick='submitForm(\"del\")'></span>\r\n");
      out.write("\t\t<span><input type=\"button\" value=재고수정 id=update onclick='submitForm(\"update\")'></span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t");
 rset.close(); udb.close(); 
      out.write("\t\r\n");
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