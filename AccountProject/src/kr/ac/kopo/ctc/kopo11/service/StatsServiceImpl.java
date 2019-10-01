package kr.ac.kopo.ctc.kopo11.service;

//import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo11.dao.AccountItemDao;
import kr.ac.kopo.ctc.kopo11.dao.AccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo11.domain.AccountItem;
import kr.ac.kopo.ctc.kopo11.dto.StatisticDto;

public class StatsServiceImpl implements StatsService {

	//private DecimalFormat df = new DecimalFormat("###,###,###,###,###");
	private AccountItemDao accountItemDao = new AccountItemDaoImpl();

	@Override
	public StatisticDto AccountItemTitleSum(int month, int year) {
//		int [] ret =new int[3];
		StatisticDto ret = new StatisticDto();
		
		List<AccountItem> list = new ArrayList<AccountItem>();
		list = accountItemDao.selectAll();
	
		int incomeSum = 0;
		int expenseSum = 0;
		
		for (int i = 0; i < list.size(); i++) {
			
			if ((list.get(i).getCreated().getMonth() + 1) == month
					&& list.get(i).getCreated().getYear() + 1900 == year) {

				if (list.get(i).getTitle().equals("수입")) {
					incomeSum = incomeSum + list.get(i).getMoney();
				} else {
					expenseSum = expenseSum + list.get(i).getMoney();
				}

			}
		}

		ret.setMonth(month);
		ret.setIncomeSum(incomeSum);
		ret.setExpenseSum(expenseSum);
		
//		System.out.println("[" + month + "]월"); 서비스단계에서 프린트찍지 말자
//		System.out.printf("수입 합계 : %s원\n", df.format(incomeSum));
//		System.out.printf("지출 합계 : %s원\n", df.format(expenseSum));
//		System.out.printf("잔액 : %s원\n", df.format(incomeSum - expenseSum));
		
		return ret;
	}

	@Override
	public StatisticDto AccountItemOneCategorySum(String category, int month, int year) {
		StatisticDto ret = new StatisticDto();
		
		List<AccountItem> list = new ArrayList<AccountItem>();
		list = accountItemDao.selectAll();

		int categorySum = 0;
		
//		System.out.println("가계부번호  수입/지출    내역    메모            금액    기록일");
//		System.out.println("===================================================================");
		
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).getCreated().getMonth() + 1) == month && list.get(i).getCategory().equals(category)
					&& list.get(i).getCreated().getYear() + 1900 == year) {

				categorySum = categorySum + list.get(i).getMoney();
				
//				System.out.printf("%d \t    %s \t %s \t %s \t %s \t %s \t\n", list.get(i).getAccount().getId(),
//						list.get(i).getTitle(), list.get(i).getCategory(), list.get(i).getMemo(),
//						df.format(list.get(i).getMoney()), list.get(i).getCreated());

			}
		}
		
//		System.out.println("===================================================================");
//		System.out.print("[" + month + "]월");
//		System.out.printf(" %s 합계 : %s원\n", category, df.format(categorySum));
		
		ret.setAccountItem(list);
		ret.setCategorySum(categorySum);
		ret.setMonth(month);
		ret.setCategory(category);
		
		return ret;

	}

	@Override
	public StatisticDto AccountItemAllCategorySum(int month, int year) {
		// TODO Auto-generated method stub
		StatisticDto ret = new StatisticDto();
		
		List<AccountItem> list = new ArrayList<AccountItem>();
		list = accountItemDao.selectAll();
		
		List<CategoryGroup> group = new ArrayList<CategoryGroup>();

		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i).getCreated().getMonth() + 1) == month
					&& list.get(i).getCreated().getYear() + 1900 == year) {
				boolean isContain = false;
				// 검사를 한다.
				for (int j = 0; j < group.size(); j++) {
					if (list.get(i).getCategory().equals(group.get(j).getCategory())) {
						
						// 돈을 추가하자
						int totalMoney = group.get(j).getMoney() + list.get(i).getMoney();
						group.get(j).setMoney(totalMoney);

						isContain = true;
					}
				}
				// 카테고리가 없다?
				// 카테고리 추가
				if (!isContain) {
					CategoryGroup cg = new CategoryGroup();
					cg.setTitle(list.get(i).getTitle());
					cg.setCategory(list.get(i).getCategory());
					cg.setMoney(list.get(i).getMoney());
					group.add(cg);
				}
			}
		}
		ret.setYear(year);
		ret.setMonth(month);
		ret.setCategoryGroup(group);
		return ret; 

//		System.out.println("수입/지출  내역  내역별총금액");
//		System.out.println("================================");
//		for (int i = 0; i < group.size(); i++) {
//			System.out.printf("%s\t   %s\t %s원\n", 
//					group.get(i).getTitle(),
//					group.get(i).getCategory(),
//					df.format(group.get(i).getMoney()));
//
//		}

	}

}
