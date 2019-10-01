package kr.ac.kopo.ctc.kopo11.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.ctc.kopo11.domain.Account;

public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao {

	@Override
	public Account create_overriding(Statement stmt, Account account) {
		// TODO Auto-generated method stub

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String created = transFormat.format(new Date());

		try {
			String QueryTxt;
			QueryTxt = "insert into Account (title, created) "
					+ "values ('" + account.getTitle() + "', '" + created + "');";
			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Account selectOne_overriding(Statement stmt, int id) {
		Account temp = new Account();

		try {
			String QueryTxt;
			QueryTxt = ("select id, title ,created from Account where id =" + id + ";");

			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				temp.setId(rset.getInt(1));
				temp.setTitle(rset.getString(2));
				temp.setCreated(rset.getDate(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public List<Account> selectAll_overriding(Statement stmt) {
		List<Account> ret = new ArrayList<Account>();

		try {
			String QueryTxt;
			QueryTxt = ("select * from Account;");
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				Account temp = new Account();
				temp.setId(rset.getInt(1));
				temp.setTitle(rset.getString(2));
				temp.setCreated(rset.getDate(3));
				ret.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public List<Account> selectAllContainingTitle_overriding(Statement stmt, String title) {
		List<Account> ret = new ArrayList<Account>();

		try {
			String QueryTxt;
			QueryTxt = String.format("select id, title ,created from Account WHERE title = '%s';", title);
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				Account temp = new Account();
				temp.setId(rset.getInt(1));
				temp.setTitle(rset.getString(2));
				temp.setCreated(rset.getDate(3));
				ret.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public Account update_overriding(Statement stmt, int id, Account account) {
		// TODO Auto-generated method stub

		try {
			String QueryTxt;
			QueryTxt = String.format(
					"update Account set title='%s' where id = %d;",account.getTitle(),id);
			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account update_overriding(Statement stmt, String title , Account account) {
		// TODO Auto-generated method stub

		try {
			String QueryTxt;
			QueryTxt = String.format(
					"update Account set title='%s' where title ='%s' ;"
					,account.getTitle(),title);
			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Account delete_overriding(Statement stmt, int id) {
		try {
			String QueryTxt;
			QueryTxt = String.format(
					"delete from Account where id = %d;"
					,id);
			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
//	@Override
//	public Account delete_overriding(Statement stmt) {
//		try {
//			String QueryTxt;
//			QueryTxt = String.format(
//					"delete from Account;");
//			stmt.execute(QueryTxt);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

}
