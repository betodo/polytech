package kr.ac.kopo.ctc.kopo11.dao;

import org.junit.Test;
import kr.ac.kopo.ctc.kopo11.domain.AccountItem;
//import org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class AccountItemDaoTest {

	// ///////////////////////////////////////////AccountItem 부분////////////////////////////////////////

//	@Test
//	public void insertTest() {
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		AccountItem a = new AccountItem();
//		AccountDaoImpl dao1 = new AccountDaoImpl();
//		
//		Account b = new Account();
//		b=dao1.selectOne(4);
//		
//		a.setAccount(b);
//		a.setTitle("지출");
//		a.setCategory("라라");
//		a.setMemo("라라");
//		a.setMoney(50000);
//		dao.create(a);
//		
//		assertEquals(a.getTitle(),"지출");
//}

//	@Test
//	public void testSeclectOne() {
//
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		AccountItem a = new AccountItem();
//		a = dao.selectOne(8);
//		
//		System.out.println(a.getId());
//		System.out.println(a.getAccount().getId());
//		System.out.println(a.getTitle());
//		System.out.println(a.getCategory());
//		System.out.println(a.getMemo());
//		System.out.println(a.getMoney());
//		System.out.println(a.getCreated());
//		
//		assertEquals(a.getTitle(), "지출");
//		
//	}

//	@Test
//	public void testSeclectAll() {
//
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		List<AccountItem> list = dao.selectAll();
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getId());
//			System.out.println(list.get(i).getAccount().getId());
//			System.out.println(list.get(i).getTitle());
//			System.out.println(list.get(i).getCategory());
//			System.out.println(list.get(i).getMemo());
//			System.out.println(list.get(i).getMoney());
//			System.out.println(list.get(i).getCreated());
//		}
//
//		assertEquals(list.size(), 1);
//	}
	
	
//	@Test
//	public void testSeclectAllContainingTitle() {
//		
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		List<AccountItem> list = dao.selectAllContainingTitle("수입");
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getId());
//			System.out.println(list.get(i).getAccount().getId());
//			System.out.println(list.get(i).getTitle());
//			System.out.println(list.get(i).getCategory());
//			System.out.println(list.get(i).getMemo());
//			System.out.println(list.get(i).getMoney());
//			System.out.println(list.get(i).getCreated());
//		}
//		assertEquals(list.size(),1);
//	}

//	@Test
//	public void testSeclectAllContainingAccount_id() {
//		
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		List<AccountItem> list = dao.selectAllContainingAccount_id(4);
//		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getId());
//			System.out.println(list.get(i).getAccount().getId());
//			System.out.println(list.get(i).getTitle());
//			System.out.println(list.get(i).getCategory());
//			System.out.println(list.get(i).getMemo());
//			System.out.println(list.get(i).getMoney());
//			System.out.println(list.get(i).getCreated());
//		}
//		assertEquals(list.size(),1);
//	}
	
//	@Test
//	public void testUpdate() {
//		
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		AccountItem a = new AccountItem();
//		a.setTitle("지출");
//		dao.update(7, a);
//	
//		AccountItem b = dao.selectOne(7);
//		
//		assertEquals(a.getTitle(), b.getTitle());
//	}	
	
//	@Test
//	public void testDelete() {
//		
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		dao.delete(7);
//		
//		List<AccountItem> listA = new ArrayList<AccountItem>();
//		listA = dao.selectAll();
//		
//		assertEquals(0, listA.size());
//	}
	
//	@Test
//	public void testDelete_FK() {
//		
//		AccountItemDaoImpl dao = new AccountItemDaoImpl();
//		dao.delete_foreign_key(8);
//		
//		List<AccountItem> listA = new ArrayList<AccountItem>();
//		listA = dao.selectAllContainingAccount_id(8);
//		
//		assertEquals(0, 0);
//	}
//	
//	@Test 
//	public void test() {
//		//AccountDao dao = new AccountDaoImpl();
//		AccountDao dao = new AccountDaoImpleMock();
//		// -> impleMock : 간단한 테스트를 위해 만듬
//		// -> 실제 DB에 접근하는것이아니라 간단하게 객체를 만들어서 테스트를함
//		// 느슨한 연결(위임 - 인터페이스 사용)을 하는 이유
//		// 서비스를 할때는 mock을 만들어보자 
//		// test쪽에다가 만들기
//		Account account = dao.selectOne(3);
//	}
//	
//	
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
