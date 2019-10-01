/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-07-15 05:09:58 UTC
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

public final class voteRate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 int totalVoter =0; //득표율을 구하기 위한 총 투표자수
		double voteRate =0; //득표율
		int voteCnt =0; //득표수
	
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
      out.write("<title>개표결과</title>\r\n");
      out.write("\t<style>\r\n");
      out.write("\t\tdiv {\r\n");
      out.write("\t\t\tdisplay: inline-block;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');
      out.write('	');

		//db연결
		connectDB cdb = new connectDB();
		Statement stmt = cdb.useDB();
		String QueryTxt;
		
		//총 투표자수 구하기
		QueryTxt = "select num from ballot;";
		ResultSet rset = stmt.executeQuery(QueryTxt);
		rset.last();
		totalVoter=rset.getRow();
		
		//득표수구하기(쿼리문으로 사용)
		QueryTxt =("SELECT c.id, c.name, b.vote_id, COUNT(*)"
				 +" FROM candidate c left join ballot b" 
				 +" on c.id = b.vote_id GROUP BY c.id;");
		
		rset = stmt.executeQuery(QueryTxt);
	
      out.write('\r');
      out.write('\n');
      out.write('	');
 
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h3 style=\"margin-left: 2em\">후보별 득표율</h3>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t");
 while(rset.next()) {
			if(rset.getInt(3) !=0) voteCnt = rset.getInt(4); 
			voteRate = Math.round(((voteCnt/(double)totalVoter)*100)*100)/100.0; //후보자 한명의 득표율 계산
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<a href=\"?contentPage=voteAge.jsp?toId=");
      out.print(rset.getInt(3));
      out.write("\">기호 ");
      out.print(rset.getInt(1) );
      out.write('번');
      out.write(' ');
      out.print(rset.getString(2) );
      out.write("</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<!-- 디브 100안에 디브를 득표율 만큼 빨간색으로 그려서 그래프 그림 -->\r\n");
      out.write("\t\t\t\t<div style=\"width:100vh ;height:1em\"><div style=\"width:");
      out.print(voteRate );
      out.write("vh ;height:1em ;background-color: #ff0000\"></div><span>");
      out.print(voteCnt );
      out.write('표');
      out.write(' ');
      out.write('(');
      out.print(voteRate );
      out.write("%)</span></div>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");
 
		voteCnt = 0;
		}
		
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t");

		rset.close();
	    stmt.close();
	    cdb.close();
	
      out.write("\r\n");
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
