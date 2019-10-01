//accountdaoimpl accountItemdatimpl의 공통을 뽑아냄
//여기선 db와의 연결을 책임짐
//오버라이딩은 어카운트애들이 가져감

package kr.ac.kopo.ctc.kopo11.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {
	//형태를 클래스로 고정함<T> //implements 인터페이스 받은거 표시

	@Override
	public Connection useDB() {
		Connection conn = null;
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String ip ="192.168.56.102";
		String port =":3306/";
		String ubuntuID="kopo11?useSSL=false";
		String dbID="root";
		String dbPW="1234";
		
		conn = DriverManager.getConnection("jdbc:mysql://"+ip+port+ubuntuID, dbID, dbPW);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	@Override
	public T create(T t) {
		// TODO Auto-generated method stub

		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement();
			
			
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopo11", "root", "1234");
//			Statement stmt = conn.createStatement(); 

			T ret =create_overriding(stmt, t);
			
//			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			String created = transFormat.format(new Date());
//			stmt.execute(
//			"insert into Account (title, created) values ('" + account.getTitle() + "', '" + created + "');");
			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public T create_overriding(Statement stmt, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T selectOne(int id) {
		// TODO Auto-generated method stub
		T rset =null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.56.102:3306/kopo11?useSSL=false", "root", "1234");
//			Statement stmt = conn.createStatement(); 
			
			Connection conn = useDB();
			Statement stmt = conn.createStatement();
			
			rset = selectOne_overriding(stmt, id);
			
			stmt.close();
			conn.close();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rset;
	}

	@Override
	public T selectOne_overriding(Statement stmt, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectAll() {
		List<T> rset = null;
		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement();

			rset = selectAll_overriding(stmt);
			
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rset;
	}
	
	@Override
	public List<T> selectAll_overriding(Statement stmt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectAllContainingTitle(String title) {
		List<T> rset =null;
		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement(); 

			rset = selectAllContainingTitle_overriding(stmt, title);
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rset;
	}

	@Override
	public List<T> selectAllContainingTitle_overriding(Statement stmt, String title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<T> selectAllContainingAccount_id(int account_id) {
		List<T> rset =null;
		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement(); 

			rset = selectAllContainingAccount_id_overriding(stmt, account_id);
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rset;
	}

	@Override
	public List<T> selectAllContainingAccount_id_overriding(Statement stmt, int account_id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T update(int id, T t) {
		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement(); 

			T ret =update_overriding(stmt, id, t);
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public T update_overriding(Statement stmt, int id, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T update(String title, T t) {
		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement();

			T ret =update_overriding(stmt, title, t);
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public T update_overriding(Statement stmt, String title, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete(int id) {
		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement();

			T ret =delete_overriding(stmt, id);
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public T delete_overriding(Statement stmt, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T delete_foreign_key(int account_id) {
		try {
			Connection conn = useDB();
			Statement stmt = conn.createStatement();

			T ret =delete_foreign_key_overriding(stmt, account_id);
			
			stmt.close();
			conn.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public T delete_foreign_key_overriding(Statement stmt, int account_id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}

	













