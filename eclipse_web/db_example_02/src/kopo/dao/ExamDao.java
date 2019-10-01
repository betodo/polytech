package kopo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kopo.domain.Exam;

public class ExamDao {
	
	public static Connection getConnection(){  
	    Connection con=null;  
	    try{  
	        Class.forName("com.mysql.cj.jdbc.Driver");  
	        con=DriverManager.getConnection("jdbc:mysql://34.73.131.137:3306/kopo", "pjw", "1234");  
	    }catch(Exception e){System.out.println(e);}  
	    return con;  
	}
	
	public static int save(Exam u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	        		"insert into examtable(name,studentid,kor,eng,mat) values(?,?,?,?,?)");  
	        ps.setString(1,u.getName());  
	        ps.setInt(2,u.getStudentid());  
	        ps.setInt(3,u.getKor());  
	        ps.setInt(4,u.getEng());  
	        ps.setInt(5,u.getMat());  
	        status=ps.executeUpdate();
	        ps.close();
	        con.close();
	    }catch(Exception e){System.out.println(e);}  
	    return status;
	}  
	
	public static int update(Exam u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement(  
	        		"update examtable set name=?,studentid=?,kor=?,eng=?,math=? where studentid=?");  
	        ps.setString(1,u.getName());  
	        ps.setInt(2,u.getStudentid());  
	        ps.setInt(3,u.getKor());  
	        ps.setInt(4,u.getEng());  
	        ps.setInt(5,u.getMat());
	        ps.setInt(6,u.getStudentid());
	        status=ps.executeUpdate();
	        ps.close();
	        con.close();
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}
	
	public static int delete(Exam u){  
	    int status=0;  
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("delete from examtable where studentid=?");  
	        ps.setInt(1,u.getStudentid());  
	        status=ps.executeUpdate();
	        ps.close();
	        con.close();
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}
	
	public static List<Exam> getAllRecords(){  
	    List<Exam> list=new ArrayList<Exam>();  
	      
	    try{  
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from examtable");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Exam u= new Exam();  
	            u.setName(rs.getString("name"));  
	            u.setStudentid(rs.getInt("studentid"));  
	            u.setKor(rs.getInt("kor"));  
	            u.setEng(rs.getInt("eng"));  
	            u.setMat(rs.getInt("mat"));    
	            list.add(u);  
	        }  
	        rs.close();
	        ps.close();
	        con.close();
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	public static Exam getRecordById(int id){  
		Exam u= new Exam();  
	    try{
	        Connection con=getConnection();  
	        PreparedStatement ps=con.prepareStatement("select * from examtable where studentid=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){
	        	u.setName(rs.getString("name"));  
	            u.setStudentid(rs.getInt("studentid"));  
	            u.setKor(rs.getInt("kor"));  
	            u.setEng(rs.getInt("eng"));  
	            u.setMat(rs.getInt("mat"));  
	        }
	        rs.close();
	        ps.close();
	        con.close();
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}  
}
