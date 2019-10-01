//sql문을 실행하는 역할 메소드마다 sql문이 다름
//여기선 crud만 수행
//crud만 수행하는 이유 db와의 기본적 연결
//sql문이 복잡하면 성능은 좋지만 더 지엽적? 특수한? 공통적 그게 안됨
//ex 코드를 사고 파고 할때 

package kr.ac.kopo.ctc.kopo11.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.ctc.kopo11.domain.Account;
import kr.ac.kopo.ctc.kopo11.domain.AccountItem;

public class AccountItemDaoImpl extends GenericDaoImpl<AccountItem> implements AccountItemDao {
//extends 상속받는다는 소리
	@Override
	public AccountItem create_overriding(Statement stmt, AccountItem accountItem) {
		// TODO Auto-generated method stub

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String created = transFormat.format(new Date());

		try {
			String QueryTxt;
			QueryTxt = String.format("insert into AccountItem ("
					+ "account_id, title, category, memo, money, created) "
					+ "values (%d, '%s', '%s', '%s', %d, '%s');"
					, accountItem.getAccount().getId(), accountItem.getTitle(), 
					accountItem.getCategory(), accountItem.getMemo(),
					accountItem.getMoney(),created);

			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public AccountItem selectOne_overriding(Statement stmt, int id) {
		AccountItem temp = new AccountItem();

		try {
			String QueryTxt;
			QueryTxt = ("select * from AccountItem where id =" + id + ";");

			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				AccountDao dao = new AccountDaoImpl();//느슨한 연결로 하는게 좋다고 한다 인터페이스와 구현체 연결가능
				Account account = new Account();
				account = dao.selectOne(rset.getInt(2));
				
				temp.setId(rset.getInt(1));
				temp.setAccount(account);
				temp.setTitle(rset.getString(3));
				temp.setCategory(rset.getString(4));
				temp.setMemo(rset.getString(5));
				temp.setMoney(rset.getInt(6));
				temp.setCreated(rset.getDate(7));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public List<AccountItem> selectAll_overriding(Statement stmt) {
		List<AccountItem> ret = new ArrayList<AccountItem>();

		try {
			String QueryTxt;
			QueryTxt = "select * from AccountItem;";

			ResultSet rset = stmt.executeQuery(QueryTxt);

			
			while (rset.next()) {
				AccountItem temp = new AccountItem();
				AccountDaoImpl dao = new AccountDaoImpl();
				Account account = new Account();
				account = dao.selectOne(rset.getInt(2));
				
				temp.setId(rset.getInt(1));
				temp.setAccount(account);
				temp.setTitle(rset.getString(3));
				temp.setCategory(rset.getString(4));
				temp.setMemo(rset.getString(5));
				temp.setMoney(rset.getInt(6));
				temp.setCreated(rset.getDate(7));
				ret.add(temp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public List<AccountItem> selectAllContainingTitle_overriding(Statement stmt, String title) {
		List<AccountItem> ret = new ArrayList<AccountItem>();

		try {
			String QueryTxt;
			QueryTxt = String.format("select * from AccountItem WHERE title = '%s';"
					, title);
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				AccountItem temp = new AccountItem();
				AccountDaoImpl dao = new AccountDaoImpl();
				Account account = new Account();
				account = dao.selectOne(rset.getInt(2));
				
				temp.setId(rset.getInt(1));
				temp.setAccount(account);
				temp.setTitle(rset.getString(3));
				temp.setCategory(rset.getString(4));
				temp.setMemo(rset.getString(5));
				temp.setMoney(rset.getInt(6));
				temp.setCreated(rset.getDate(7));
				ret.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	@Override
	public List<AccountItem> selectAllContainingAccount_id_overriding(Statement stmt, int account_id) {
		List<AccountItem> ret = new ArrayList<AccountItem>();

		try {
			String QueryTxt;
			QueryTxt = String.format("select * from AccountItem WHERE account_id = %d;"
					, account_id);
			ResultSet rset = stmt.executeQuery(QueryTxt);

			while (rset.next()) {
				AccountItem temp = new AccountItem();
				AccountDaoImpl dao = new AccountDaoImpl();
				Account account = new Account();
				account = dao.selectOne(rset.getInt(2));
				
				temp.setId(rset.getInt(1));
				temp.setAccount(account);
				temp.setTitle(rset.getString(3));
				temp.setCategory(rset.getString(4));
				temp.setMemo(rset.getString(5));
				temp.setMoney(rset.getInt(6));
				temp.setCreated(rset.getDate(7));
				ret.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}
	@Override
	public AccountItem update_overriding(Statement stmt, int id, AccountItem AccountItem) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String QueryTxt;
			QueryTxt = String.format(
					"update AccountItem set title='%s', category='%s', memo='%s', "
					+ "money='%d', created='%s'  where id = %d;",
					AccountItem.getTitle(),AccountItem.getCategory(),AccountItem.getMemo(),
					AccountItem.getMoney(),df.format(AccountItem.getCreated()),id);
			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


	@Override
	public AccountItem delete_overriding(Statement stmt, int id) {
		try {
			String QueryTxt;
			QueryTxt = String.format(
					"delete from AccountItem where id = %d;", id);
			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public AccountItem delete_foreign_key_overriding(Statement stmt, int id) {
		try {
			String QueryTxt;
			QueryTxt = String.format(
					"delete from AccountItem where account_id = %d;", id);
			stmt.execute(QueryTxt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
