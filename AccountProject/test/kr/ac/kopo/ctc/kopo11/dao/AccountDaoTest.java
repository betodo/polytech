package kr.ac.kopo.ctc.kopo11.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import kr.ac.kopo.ctc.kopo11.domain.Account;
import kr.ac.kopo.ctc.kopo11.domain.AccountItem;

public class AccountDaoTest {

//	@Test
//	public void insertTest() {
//		AccountDao dao = new AccountDaoImpl();
//		Account a = new Account();
//		a.setTitle("비상용");
//		dao.create(a);
//		
//		assertEquals(a.getTitle(), "비상용");
//	}

//	@Test
//	public void testSeclectOne() {
//		
//		AccountDaoImpl dao = new AccountDaoImpl();
//		Account a = new Account();
//		a = dao.selectOne(1);
//		assertEquals(a.getTitle(),"개인");
//	}

//	@Test
//	public void testSeclectAll() {
//		
//		AccountDao dao = new AccountDaoImpl();
//		List<Account> list = dao.selectAll();
//		assertEquals(list.size(),2);
//	}

//	@Test
//	public void testSeclectAllContainingTitle() {
//		
//		AccountDaoImpl dao = new AccountDaoImpl();
//		List<Account> list = dao.selectAllContainingTitle("개인");
//		assertEquals(list.size(),1);
//	}
//	

//	@Test
//	public void testUpdate() {
//		
//		AccountDaoImpl dao = new AccountDaoImpl();
//		Account a = new Account();
//		a.setTitle("동아리");
//		dao.update(5, a);
//	
//		Account b = dao.selectOne(2);
//		
//		assertEquals(a.getTitle(), b.getTitle());
//	}

//	@Test
//	public void testUpdate2() {
//		
//		AccountDaoImpl dao = new AccountDaoImpl();
//		Account a = new Account();
//		a.setTitle("동아리");
//		dao.update("회사", a);
//	
//		Account b = dao.selectOne(2);
//		
//		assertEquals(a.getTitle(), b.getTitle());
//	}

//	@Test
//	public void testDelete() {
//		
//		AccountDaoImpl dao = new AccountDaoImpl();
//		dao.delete(2);
//		
//		List<Account> listA = new ArrayList<Account>();
//		listA = dao.selectAll();
//		
//		assertEquals(1, listA.size());
//	}
//	
//	@Test
//	public void testDelete() {
//		
//		AccountDaoImpl dao = new AccountDaoImpl();
//		Account a = new Account();
//		a = dao.delete();
//		
//		List<Account> listA = new ArrayList<Account>();
//		listA = dao.selectAll();
//		
//		assertEquals(0, listA.size());
//	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		//insertTest();
//		
////		selectOneTest();
//		
//		
//		
//		System.out.print("테스트중");
//	}

}
