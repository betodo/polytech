/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-08 13:43:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mobile;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class mReserve_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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

	//넘어오는 값 받아서 div에 배치할 것 지정하기
	String contentPage = request.getParameter("contentPage");

	if (contentPage == null) {
		//최초접속 위해
		contentPage = "Reserve/Reserve_list.jsp";

	}

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<!-- 페이지 크기 제어 사파리용 -->\r\n");
      out.write("<meta name=\"viewport\" content=\"user-scable= no, width=device-width\" />\r\n");
      out.write("<!-- Safari UI(URL Bar, Button Bar) 없애기 및 변경하기 -->\r\n");
      out.write("<meta name=”apple-mobile-web-app-capable” content=”yes” />\r\n");
      out.write("<meta name=”apple-mobile-web-app-status-bar-style” content=”black” />\r\n");
      out.write("<meta http-equiv=\"Cache-Control\" content=\"no-cache\" />\r\n");
      out.write("<meta http-equiv=\"Expires\" content=\"0\" />\r\n");
      out.write("<meta http-equiv=\"Pragma\" content=\"no-chache\" />\r\n");
      out.write("<title>모바일 예약</title>\r\n");
      out.write("<!-- 부트스트랩 사용 -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- include libraries(jQuery, bootstrap) -->\r\n");
      out.write("<!-- 부트스트랩 제대로 돌아가려면 이거 필요 min 말고-->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- include summernote css/js -->\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("@import url(CSS/Basic_table.css);\r\n");
      out.write("\r\n");
      out.write("@import url(CSS/Pagination.css);\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, contentPage, out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
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
