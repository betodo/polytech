/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-07-24 06:39:44 UTC
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
import java.util.Enumeration;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public final class gongji_005fwrite_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.Enumeration");
    _jspx_imports_classes.add("com.oreilly.servlet.multipart.DefaultFileRenamePolicy");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("GongJi.UseDB");
    _jspx_imports_classes.add("com.oreilly.servlet.MultipartRequest");
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
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<!-- 이게 있어야 path 잡기가 가능 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 파일 업로드시 필요한 import --> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>글을 삽입하는 동작페이지</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
	
		//db연결
		UseDB udb = new UseDB();
	
		//넣을 값들(삽입 , 업뎃 공통)
		String title ="";
		String content="";
		
		String uploadPath = request.getRealPath("upload");
		//path 결과 C:\Users\admin\eclipse_web\GongJi_project\WebContent\\upload  
		
		//String viewpath = "upload/";
		
		//동작을 결정할 변수 key
		String key = request.getParameter("key");
		
		if (key.equals("INSERT") ){ //신규글 작성, no 댓글
			
			try {
				
				MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
						request, 
						uploadPath, // 파일을 저장할 디렉토리 지정
						1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
						"utf-8", // 인코딩 방식 지정
						new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
				);
				
				title = multi.getParameter("title");
				content = multi.getParameter("content");
				
				String fileName1 = multi.getFilesystemName("file1"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
				//String orgfileName1 = multi.getOriginalFileName("file1"); // name=file1의 업로드된 원본파일 이름을 구함(중복 처리 전 이름)
				
				String fileName2 = multi.getFilesystemName("file2"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
				//String orgfileName2 = multi.getOriginalFileName("file2");
				
				
				udb.insertGongji(title, content, fileName1, fileName2); //인서트 메서드 실행
				out.print("<h4 align=\"center\">공지 삽입 완료</h4><br>");
			
			}catch(Exception e){
				out.print(e);
			}
		
			
		}else if(key.equals("UPDATE")){ //글 없뎃
			//없뎃할 행을 지정하기 위해 값 받기
			int id =0;
			String idTemp = request.getParameter("id");
			id = Integer.parseInt(idTemp);
			
			//String relevelTemp = request.getParameter("relevel");
			//int relevel = Integer.parseInt(relevelTemp);
			
			String titleTemp = request.getParameter("title");
	 		title =new String(titleTemp.getBytes("8859_1"),"utf-8");
			
	 		String contentTemp = request.getParameter("content");
	 		content =new String(contentTemp.getBytes("8859_1"),"utf-8");
			
			
			udb.updateGongji(id, title, content);
			out.print("<h4 align=\"center\">수정완료</h4><br>");			
		
		}else if(key.equals("INSERT_RE")){ //댓글 작성할때
			
	 		String titleTemp = request.getParameter("title");
	 		title =new String(titleTemp.getBytes("8859_1"),"utf-8");
			
	 		String contentTemp = request.getParameter("content");
	 		content =new String(contentTemp.getBytes("8859_1"),"utf-8");
			
			int rootid = Integer.parseInt(request.getParameter("rootid"));
			int relevel = Integer.parseInt(request.getParameter("relevel"));
			int recnt = Integer.parseInt(request.getParameter("recnt"));


			udb.insertRe(title, content, rootid, relevel, recnt);
			out.print("<h4 align=\"center\">댓글 삽입 완료</h4><br>");
			
			
		}
		
	
      out.write('\r');
      out.write('\n');
      out.write('	');
	
	    udb.close();
	
      out.write("\r\n");
      out.write("\t<!-- 뒤로가기 버튼 -->\r\n");
      out.write("\t<div align=\"center\">\r\n");
      out.write("\t\t<form method=\"post\"><input type=\"submit\" value=뒤로 id=cancle formaction=\"?contentPage=gongji_list.jsp\"></form>\r\n");
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
