/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2019-08-12 05:57:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Gongji;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import useDB.UseDB_Gongji;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

public final class Gongji_005fwrite_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("useDB.UseDB_Gongji");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 이게 있어야 파업로드위한 path 잡기가 가능 -->\r\n");
      out.write("\r\n");
      out.write("<!-- 파일 업로드시 필요한 import -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");//한글 깨짐 방지
	
	//db연결
	UseDB_Gongji udbG = new UseDB_Gongji();

	//넣을 값들(삽입 , 업뎃 공통)
	String title = "";
	String content = "";
	String fileName1 ="";
	String fileName2 ="";
	
	//업뎃에서만 받을 애들(파일수정시)
	int id = 0;
	String ogFileName1 ="";
	String ogFileName2 ="";

	//파일 저장 경로
	String uploadPath = request.getRealPath("Gongji/upload");
	

	//동작을 결정할 변수 key
	String key = request.getParameter("key");
	
	if (key.equals("INSERT")) { //신규글 작성
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, uploadPath, // 파일을 저장할 디렉토리 지정
					1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);

			//cos.jar를 활용하여 파일을 받기위해 form태그의 타입을 enctype="multipart/form-data"로 할 경우
			//request가 아니라 mult로 받는다 이때 한글잘된다.
			title = multi.getParameter("title");
			content = multi.getParameter("content");
			fileName1 = multi.getFilesystemName("file1"); 
			fileName2 = multi.getFilesystemName("file2");
			
			udbG.insertGongji(title, content, fileName1, fileName2); //인서트 메서드 실행

      out.write("\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\talert(\"작성 되었습니다.\");\r\n");
      out.write("\t\t\t\twindow.location=\"?contentPage=Gongji/Gongji_list.jsp\";\r\n");
      out.write("\t\t\t</script>\r\n");
				
		}catch(Exception e){
			out.print(e);

      out.write("\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\talert(\"작성 실패\");\r\n");
      out.write("\t\t\t\twindow.history.go(-1);\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t\r\n");
		
		}

	} else if (key.equals("UPDATE")) { //글 없뎃
		//out.print(key);
		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, uploadPath, // 파일을 저장할 디렉토리 지정
					1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);
			//업뎃할 애들 값 받기
			String idTemp = multi.getParameter("id");
			id = Integer.parseInt(idTemp);

			title = multi.getParameter("title");
			content = multi.getParameter("content");
			
			//파일 수정시 처리 위해
			//원래 파일 값 받고 원래 파일이 없었으면 널찍어줌
			ogFileName1 = multi.getParameter("ogFile1");
			if(ogFileName1.equals("null")) ogFileName1 =null;
			ogFileName2 = multi.getParameter("ogFile2");
			if(ogFileName2.equals("null")) ogFileName2 =null;
			
			//업데이트에서 작성한 파일 이름
			fileName1 = multi.getFilesystemName("file1"); 
			fileName2 = multi.getFilesystemName("file2");
			
			//새로운 파일로 수정시 기존 파일 지우기
			if(fileName1 == null) {//파일 수정 안했으면
				fileName1 = ogFileName1;//수정파일=원래파일
				
			}else{//파일수정 했으면 파일 삭제
				 File f1 = new File(uploadPath+"/"+ogFileName1);
			     if(f1.exists()) f1.delete();
			}
			
			//새로운 파일로 수정시 기존 파일 지우기
			if(fileName2 == null) {
				fileName2 = ogFileName2;
			}else{
				File f2 = new File(uploadPath+"/"+ogFileName2);
			    if(f2.exists()) f2.delete();
			}
			
			//수정 db처리
			int s = udbG.updateGongji(id, title, content, fileName1, fileName2);
			

      out.write("\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\talert(\"수정 되었습니다.\");\r\n");
      out.write("\t\t\t\twindow.location=\"?contentPage=Gongji/Gongji_list.jsp\";\r\n");
      out.write("\t\t\t</script> \r\n");

		} catch (Exception e) {
			out.print(e);

      out.write("\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\t\talert(\"수정 실패\");\r\n");
      out.write("\t\t\t\twindow.history.go(-1);\r\n");
      out.write("\t\t\t</script> \r\n");

		}

	}
	udbG.close();

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
