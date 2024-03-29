/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-08 08:36:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import useDB.UseDB_Reserve;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public final class adm_005fupdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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

//로직
// 1. 예약일과 방을 수정했는가?
// 	1-1 수정  
// 		기존의 예약과 겹치는가?
// 			겹침 : 예약불가 뒤로가
// 			안겹침 : 기존꺼 지우고 수정한 값으로 새로 인서트
// 	1-2 수정 안함 -> 바로 예약일 방 빼고 없뎃

	request.setCharacterEncoding("UTF-8"); //한글 안먹음 왜?
	String change = request.getParameter("change"); // 예약일과 방을 변경 했는지 change가 true면 예약일 방 변경
	//out.print(change);
	
	//변경할 애들 값받기
	String nameTemp = request.getParameter("name");
	String name = new String(nameTemp.getBytes("8859_1"), "utf-8");

	String addrTemp = request.getParameter("addr");
	String addr = new String(addrTemp.getBytes("8859_1"), "utf-8");

	String phone_num = request.getParameter("phone_num");

	String deposit_nameTemp = request.getParameter("deposit");
	String deposit = new String(deposit_nameTemp.getBytes("8859_1"), "utf-8");

	String rsv_commentTemp = request.getParameter("rsv_comment");
	String comment = new String(rsv_commentTemp.getBytes("8859_1"), "utf-8");
	
	String write_dateTemp = request.getParameter("write_date");
	String write_date = new String(write_dateTemp.getBytes("8859_1"), "utf-8");
	
	int processing = Integer.parseInt(request.getParameter("processing"));
		
	//변경한 애들 중 이미 예약된 방과 일자는 변경안됨
	String rsv_date = "";//값 받을 변수 초기화
	int room = 0;
	boolean rsv_able = true; //변경가능 여부 변수
	UseDB_Reserve udbR = new UseDB_Reserve();//예약가능 여부 확인 위한 디비비교 준비

	//받은 값과 db를 비교하여 예야가능여부 판별
	//if(request.getParameter("date") != null && request.getParameter("room") != null){
	rsv_date = request.getParameter("date");
	room = Integer.parseInt(request.getParameter("room"));

	// 방번호에 따른 이름
	String roomName = "";
	switch (room) {
	case 1:
		roomName = "vip룸";
		break;
	case 2:
		roomName = "합리룸";
		break;
	case 3:
		roomName = "일반룸";
		break;
	}
	
	ResultSet rset = null;
	
	//날짜와 방 예약을 바꿨으면
	if(change.equals("true")){
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		//디비에서 선택된 날짜비교
		rset = udbR.selectOneYearReserve(startDate, endDate);
		
		//디비에 바꾼 날짜와 방이 있는지 판단
		if (rset.next()) {
			rset.beforeFirst();
			while (rset.next()) {
			
				if (rsv_date.equals(rset.getString(1)) && room == rset.getInt(2)) {
					rsv_able = false; //있으면 예약불가
					break;
				}
			}
		}
	
		if (rsv_able == false) { //예약불가면 아래와 같은 내용 나옴

      out.write("\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<table id=\"basicTB\" width=\"100%\">\r\n");
      out.write("\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<th colspan=2>예약 가능 여부</th>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t<tbody>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>죄송합니다. ");
      out.print(rsv_date);
      out.write(' ');
      out.write(',');
      out.write(' ');
      out.print(roomName);
      out.write("은 이미 예약 되었습니다. 다른 일자 또는\r\n");
      out.write("\t\t\t\t\t\t\t방을 선택해 주세요\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<form method='post'\r\n");
      out.write("\t\t\t\taction=\"?contentPage=Admin/adm_allview.jsp\">\r\n");
      out.write("\t\t\t\t<div id=\"divButton\" style=\"width: 100%; text-align: right;\">\r\n");
      out.write("\t\t\t\t\t<span><input class=\"btn btn-success\" type=\"submit\" value=뒤로></span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");

		}else{ //디비에서 뒤졌는데 예약가능하면
			
			//변경시 기존의 날짜 방 에약은 삭제해야
			String OGrsv_date = request.getParameter("OGrsv_date");
			int OGroom = Integer.parseInt(request.getParameter("OGroom"));
			udbR.deleteRsv(OGrsv_date, OGroom);
			
			//삭제하고 새로 인서트함
			udbR.insertRsvForAdmin(name, rsv_date, room, addr, phone_num, deposit, comment, write_date, processing);
			out.print("<script>alert(\"수정되었습니다.(기존delete,새로insert)\");"
					+"window.location.href='?contentPage=Admin/adm_allview.jsp'</script>");
		}
	}else{//예약일과 방을 안바꿨으면 바로 업뎃
		
		udbR.updateRsv(name, rsv_date, room, addr, phone_num, deposit, comment, write_date, processing);
		out.print("<script>alert(\"수정되었습니다.(바로수정)\");"
				+"window.location.href='?contentPage=Admin/adm_allview.jsp'</script>");
	}

	
	if(rset!=null) rset.close();
	udbR.close();

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
