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

public final class menu2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

	//관리자 로그인 유무에 따라 출력되는 메뉴가 있다
	String loginOK = null;
	loginOK = (String) session.getAttribute("login_ok");

      out.write("\r\n");
      out.write("<!-- 부트스트랩의 네비게이션 바를 활용하여 구현 -->\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("\t<!-- 로고 이미지를 누르면 인덱스로 감 -->\r\n");
      out.write("\t<a class=\"navbar-brand\" href=\"index.jsp\"> <img src=\"img/logo.png\"\r\n");
      out.write("\t\twidth=\"30\" class=\"d-inline-block align-top\" alt=\"\"> POLYRESORT\r\n");
      out.write("\t</a>\r\n");
      out.write("\t<!-- 부트스트랩 네비게이션에서 토글러 활용하는 곳 여기선 안쓰인다 -->\r\n");
      out.write("\t<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("\t\tdata-target=\"#navbarSupportedContent\"\r\n");
      out.write("\t\taria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n");
      out.write("\t\taria-label=\"Toggle navigation\">\r\n");
      out.write("\t\t<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("\t</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("\r\n");
      out.write("\t\t<ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("\t\t\t<!-- 네비게이션메뉴1 -->\r\n");
      out.write("\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\"> 리조트소개 </a>\r\n");
      out.write("\t\t\t\t<!-- 네비메뉴1의 하위 메뉴들 -->\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=main.jsp\">폴리리조트</a> <a\r\n");
      out.write("\t\t\t\t\t\tclass=\"dropdown-item\" href=\"?contentPage=VipRoom.html\">VIP룸</a>\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t<div class=\"dropdown-divider\"></div> -->\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=normalRoom.html\">일반룸</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=ReasonableRoom.html\">합리적인룸</a>\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\"> 찾아오기 </a>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=Direction.html\">찾아오는길</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=PublicTransit.html\">대중교통이용</a>\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t<a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">Disabled</a> -->\r\n");
      out.write("\t\t\t\t\t<!-- \t\t\t\t\t<a class=\"dropdown-item\" href=\"#\" aria-disabled=\"true\">자아용이용</a> -->\r\n");
      out.write("\t\t\t\t\t<a class=\"nav-link disabled\" href=\"#\" tabindex=\"-1\"\r\n");
      out.write("\t\t\t\t\t\taria-disabled=\"true\">자가용이용</a>\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\"> 주변여행지 </a>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=Sight1.html\">높은 산</a> <a\r\n");
      out.write("\t\t\t\t\t\tclass=\"dropdown-item\" href=\"?contentPage=Sight2.html\">시원 해수욕장</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=Sight3.html\">따끈 온천</a>\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\"> 예약하기 </a>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\thref=\"?contentPage=Reserve/Reserve_list.jsp\">예약상황</a> <a\r\n");
      out.write("\t\t\t\t\t\tclass=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\thref=\"?contentPage=Reserve/Reserve_direct_insert.jsp\">예약하기</a>\r\n");
      out.write("\t\t\t\t\t\t");
 if( loginOK != null && loginOK.equals("yes") ){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=Admin/adm_allview.jsp\">관리자페이지</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\thref=\"?contentPage=Admin/logout.jsp\">관리자로그아웃</a>\r\n");
      out.write("\t\t\t\t\t\t");
 }
      out.write("\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<li class=\"nav-item dropdown\"><a\r\n");
      out.write("\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\taria-expanded=\"false\"> 리조트소식 </a>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"?contentPage=Gongji/Gongji_list.jsp\">공지사항</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\"\r\n");
      out.write("\t\t\t\t\t\thref=\"?contentPage=Comment/Comment_list.jsp\">이용후기</a>\r\n");
      out.write("\t\t\t\t</div></li>\r\n");
      out.write("\t\t\t<!-- \t\t\t<li class=\"nav-item\"><a class=\"nav-link\" href=\"Login/login_test.jsp\">로그인</a></li> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- 관리자 로그인이 되어서 세션이 기록되면 다음과 같은 네비메뉴를 출력 -->\r\n");
      out.write("\t\t\t");
 if( loginOK == null || !loginOK.equals("yes") ){ 
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-outline-success\" type=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location.href='Admin/login_test.jsp'\">로그인</button>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t");
 }else if( loginOK != null && loginOK.equals("yes")){ 
      out.write(" \r\n");
      out.write("\t\t\t\t<button class=\"btn btn-outline-success\" type=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location.href='Admin/logout.jsp'\">로그아웃</button>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t");
 }else{
      out.write("\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-outline-success\" type=\"button\"\r\n");
      out.write("\t\t\t\t\tonclick=\"location.href='Admin/logout.jsp'\">로그아웃</button>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- </body> -->\r\n");
      out.write("<!-- </html> -->");
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
