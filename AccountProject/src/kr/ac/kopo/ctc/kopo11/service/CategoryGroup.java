package kr.ac.kopo.ctc.kopo11.service;

import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo11.dao.AccountItemDao;
import kr.ac.kopo.ctc.kopo11.dao.AccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo11.domain.AccountItem;
import kr.ac.kopo.ctc.kopo11.dto.StatisticDto;

public class CategoryGroup {

	private String title;
	private String category;
	private int money;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public  StatisticDto AccountItemCategoryAll() {
		// TODO Auto-generated method stub
		StatisticDto ret = new StatisticDto();
		AccountItemDao accountItemDao = new AccountItemDaoImpl();
		List<AccountItem> list = new ArrayList<AccountItem>();
		
		list = accountItemDao.selectAll();
		
		List<CategoryGroup> group = new ArrayList<CategoryGroup>();

		for (int i = 0; i < list.size(); i++) {
			
				boolean isContain = false;
				// 검사를 한다.
				for (int j = 0; j < group.size(); j++) {
					if (list.get(i).getCategory().equals(group.get(j).getCategory())) {
						isContain = true;
					}
				}
				// 카테고리가 없다?
				// 카테고리 추가
				if (!isContain) {
					CategoryGroup cg = new CategoryGroup();
					cg.setTitle(list.get(i).getTitle());
					cg.setCategory(list.get(i).getCategory());
					group.add(cg);
				}
			}
		
		ret.setCategoryGroup(group);
		return ret; 
	}
}
