/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-11 09:17:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.sql.*;
import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.net");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.sql");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<!-- \t<div style=\"height: 5vh\"></div> -->\r\n");
      out.write("\t<!-- 부트스트랩 활용 구현 -->\r\n");
      out.write("\t<div id=\"carouselExampleIndicators\" class=\"carousel slide\"\r\n");
      out.write("\t\tdata-ride=\"carousel\">\r\n");
      out.write("\t\t<ol class=\"carousel-indicators\">\r\n");
      out.write("\t\t\t<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"0\"\r\n");
      out.write("\t\t\t\tclass=\"active\"></li>\r\n");
      out.write("\t\t\t<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"1\"></li>\r\n");
      out.write("\t\t\t<li data-target=\"#carouselExampleIndicators\" data-slide-to=\"2\"></li>\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t\t<div class=\"carousel-inner\">\r\n");
      out.write("\t\t\t<div class=\"carousel-item active\">\r\n");
      out.write("\t\t\t\t<img src=\"img/resort.jpg\" class=\"d-block w-100\" alt=\"...\"\r\n");
      out.write("\t\t\t\t\tstyle=\"max-height: 50vh;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"carousel-item\">\r\n");
      out.write("\t\t\t\t<img src=\"img/resort2.jpg\" class=\"d-block w-100\" alt=\"...\"\r\n");
      out.write("\t\t\t\t\tstyle=\"max-height: 50vh;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"carousel-item\">\r\n");
      out.write("\t\t\t\t<img src=\"img/resort3.jpg\" class=\"d-block w-100\" alt=\"...\"\r\n");
      out.write("\t\t\t\t\tstyle=\"max-height: 50vh;\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<a class=\"carousel-control-prev\" href=\"#carouselExampleIndicators\"\r\n");
      out.write("\t\t\trole=\"button\" data-slide=\"prev\"> <span\r\n");
      out.write("\t\t\tclass=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span> <span\r\n");
      out.write("\t\t\tclass=\"sr-only\">Previous</span>\r\n");
      out.write("\t\t</a> <a class=\"carousel-control-next\" href=\"#carouselExampleIndicators\"\r\n");
      out.write("\t\t\trole=\"button\" data-slide=\"next\"> <span\r\n");
      out.write("\t\t\tclass=\"carousel-control-next-icon\" aria-hidden=\"true\"></span> <span\r\n");
      out.write("\t\t\tclass=\"sr-only\">Next</span>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<br>\r\n");
      out.write("\t<blockquote class=\"blockquote text-center\" style=\"font-size: x-large;\">\r\n");
      out.write("\t\t<p class=\"mb-0\">폴리 리조트에 오신걸 환영합니다.</p>\r\n");
      out.write("\t\t<footer class=\"blockquote-footer\">\r\n");
      out.write("\t\t\t참 <cite title=\"Source Title\">잘 왔어요</cite>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t</blockquote>\r\n");
      out.write("\t<div class=\"card-deck\" >\r\n");
      out.write("\t\t<div class=\"card\" >\r\n");
      out.write("\t\t\t<img src=\"img/diningroom.jpg\" class=\"card-img-top\" alt=\"...\">\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\">멋진 식당</h5>\r\n");
      out.write("\t\t\t\t<p class=\"card-text\">맛있고 멋지고 5성에다가 6시 내고향에도 나오고 스타쉐프도 있고 연예인도\r\n");
      out.write("\t\t\t\t\t많이오는 그런 식당</p>\r\n");
      out.write("\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t<small class=\"text-muted\">Last updated 3 mins ago</small>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card\" >\r\n");
      out.write("\t\t\t<img src=\"img/food.jpg\" class=\"card-img-top\" alt=\"...\">\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\">최고급 요리</h5>\r\n");
      out.write("\t\t\t\t<p class=\"card-text\">집나간 며느리도 돌아온다는 그런 음식, 잃어버린 미각을 찾아줄 그런 음식,\r\n");
      out.write("\t\t\t\t\t한번 맛보면 잊지 못하는 그런 음식</p>\r\n");
      out.write("\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t<small class=\"text-muted\">Last updated 3 mins ago</small>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"card\" >\r\n");
      out.write("\t\t\t<img src=\"img/show.jpg\" class=\"card-img-top\" alt=\"...\">\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("\t\t\t\t<h5 class=\"card-title\">고퀄 공연</h5>\r\n");
      out.write("\t\t\t\t<p class=\"card-text\">매주 수요일 토요일 열리는 공연, 국내외 내노라하는 스타군단이 공연,\r\n");
      out.write("\t\t\t\t\t투숙객이면 무료, 놓치면 아깝</p>\r\n");
      out.write("\t\t\t\t<p class=\"card-text\">\r\n");
      out.write("\t\t\t\t\t<small class=\"text-muted\">Last updated 3 mins ago</small>\r\n");
      out.write("\t\t\t\t</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>");
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
