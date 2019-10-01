//1차 만든이유 AccountdaoImpl과 AccountdaoImpl의 중복코리들을 처리하기 위해 더 상위의 클래스를 만들어서
//둘에게 물려줌 상속시킴
//인터페이스는 메소드이름과 변수만 정해줌, 변수등을 선언할 수는 없음
//갑이 을에게 넌 이 이름으로 이것만 만들어하고 정해주는 업무 규약느낌
//인터페이스를 만들고 Impl에게 구현 책임을 넘김으로써 느슨한 연결 가능
//why? 편한게 많다고 한다

package kr.ac.kopo.ctc.kopo11.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public interface GenericDao<T> {
	
	//DB사용
	Connection useDB();
	
	//c
	T create(T t);
	T create_overriding(Statement stmt,T t);
	
	//s
	T selectOne(int id);
	T selectOne_overriding(Statement stmt, int id);
	
	List<T> selectAll();
	List<T> selectAll_overriding(Statement stmt);
	
	List<T> selectAllContainingTitle(String title);
	List<T> selectAllContainingTitle_overriding(Statement stmt, String title);
	
	List<T> selectAllContainingAccount_id(int account_id);
	List<T> selectAllContainingAccount_id_overriding(Statement stmt, int account_id);
	
	//u
	T update(int id, T t);
	T update_overriding(Statement stmt, int id, T t);
	
	T update(String title, T t);
	T update_overriding(Statement stmt, String title, T t);
	
	//d
	T delete(int id);
	T delete_overriding(Statement stmt, int id);
	
	
	T delete_foreign_key(int account_id);
	T delete_foreign_key_overriding(Statement stmt, int account_id);
	
	
}
