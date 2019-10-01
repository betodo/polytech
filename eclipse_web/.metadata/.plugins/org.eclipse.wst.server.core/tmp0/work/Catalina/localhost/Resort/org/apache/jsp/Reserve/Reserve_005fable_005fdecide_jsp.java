/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-12 00:22:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Reserve;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import useDB.UseDB_Reserve;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public final class Reserve_005fable_005fdecide_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	request.setCharacterEncoding("UTF-8"); //한글 안먹음 왜?

	String rsv_date = "";//값 받을 변수 초기화
	int room = 0;
	boolean rsv_able = true; //예약가능 여부 변수
	

	//받은 값과 db를 비교하여 예야가능여부 판별
	//if(request.getParameter("date") != null && request.getParameter("room") != null){
	
	//값받기
	rsv_date = request.getParameter("date");
	room = Integer.parseInt(request.getParameter("room"));
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	
	//디비에서 선택된 날짜비교
	UseDB_Reserve udbR = new UseDB_Reserve();//예약가능 여부 확인 위한 디비비교 준비
	ResultSet rset = udbR.selectOneYearReserve(startDate, endDate);//한달간격의 예약테이블 조회

	if (rset.next()) {//조회한 값이 있으면 비교
		rset.beforeFirst();//rset 한번 사용했으니까 다시 처음으로
		
		while (rset.next()) {
			
			//받은값(예약일,방)과 조회한 값이 같으면 예약불가
			if (rsv_date.equals(rset.getString(1)) && room == rset.getInt(2)) {
				rsv_able = false;
 				break;			
			}
		}
	}
	rset.close();
	udbR.close();


      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("//버튼 동작 함수\r\n");
      out.write("function submitForm(mode) {\r\n");
      out.write("\t\r\n");
      out.write("\t/* const fm = document.getElementById(\"fm\"); */\r\n");
      out.write("\tif (mode == 'write') {\r\n");
      out.write("\t\tfmm.action = \"?contentPage=Reserve/Reserve_insert.jsp\";\r\n");
      out.write("\r\n");
      out.write("\t} else if (mode == 'cancle') {\r\n");
      out.write("\t\tfmm.action = \"?contentPage=Reserve/Reserve_direct_insert.jsp\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfmm.submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");

	//예약불가일때
	if (rsv_able == false) {
		// 방번호에 따른 이름
		String roomName ="";
		switch(room){  
			case 1: roomName = "vip룸"; break;
			case 2: roomName = "일반룸"; break;
			case 3: roomName = "합리룸"; break;
		}
		

      out.write("\r\n");
      out.write("\t\t\t<table id=\"basicTB\" width=\"100%\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=2>예약 가능 여부</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t죄송합니다. ");
      out.print(rsv_date );
      out.write(' ');
      out.write(',');
      out.write(' ');
      out.print(roomName );
      out.write("은 이미 예약 되었습니다. 다른 일자 또는 방을 선택해 주세요\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form method='post' action =\"?contentPage=Reserve/Reserve_direct_insert.jsp\">\r\n");
      out.write("\t\t\t\t<div id=\"divButton\" style=\"width: 100%; text-align: right;\">\r\n");
      out.write("\t\t\t\t<span><input class=\"btn btn-success\" type=\"submit\" value=뒤로\r\n");
      out.write("\t\t\t\t></span> \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");

	//예약가능일때
	} else if(rsv_able == true){

      out.write("\r\n");
      out.write("\t\t<table id=\"basicTB\" width=\"100%\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=2>예약 가능 여부</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t예약 가능합니다. 예약자 정보를 입력해 주세요\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<form id=fmm name='fmm' method='post'>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=day value=\"");
      out.print(rsv_date );
      out.write("\"><!-- 선택한 예약일 -->\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=room value=\"");
      out.print(room );
      out.write("\"><!-- 선택학 방을 넘기자 -->\r\n");
      out.write("\t\t\t\t<div id=\"divButton\" style=\"width: 100%; text-align: right;\">\r\n");
      out.write("\t\t\t\t\t<span><input class=\"btn btn-success\" type=\"button\" value=취소 \r\n");
      out.write("\t\t\t\t\tid=cancle onclick='submitForm(\"cancle\")'></span> \r\n");
      out.write("\t\t\t\t\t<span><input class=\"btn btn-success\" type=\"button\" value=\"예약자 정보 입력\"  \r\n");
      out.write("\t\t\t\t\tid=write onclick='submitForm(\"write\")'></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
			
	}

      out.write("\r\n");
      out.write("</div>\r\n");
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
