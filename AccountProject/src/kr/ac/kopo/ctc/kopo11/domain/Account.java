//도메인의 역할 db의 엔터티와 1:1로 대응, 
//엔터티들의 각 칼럼값들을 자바에서 처리하기 위해 만듬(get,set)
package kr.ac.kopo.ctc.kopo11.domain;

import java.util.Date;

public class Account {
	private int id;
	private String title;
	private Date created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
