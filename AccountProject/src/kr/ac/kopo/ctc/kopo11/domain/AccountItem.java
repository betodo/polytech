//도메인의 역할 db의 엔터티와 1:1로 대응, 
//엔터티들의 각 칼럼값들을 자바에서 처리하기 위해 만듬(get,set)
package kr.ac.kopo.ctc.kopo11.domain;

import java.util.Date;

public class AccountItem {
	

	private int id;
	private Account account;
	private String title;
	private String	category;
	private String	memo;	
	private int money;
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	

}
