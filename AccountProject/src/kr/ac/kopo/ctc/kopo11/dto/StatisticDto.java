//서비스의 결과들을 넣고 빼는 용도의 클래스
//서비스는 로직만 관심있음
//서비스의 결과들은 db와 연결되면 안됨

package kr.ac.kopo.ctc.kopo11.dto;

import java.util.List;

import kr.ac.kopo.ctc.kopo11.domain.AccountItem;
import kr.ac.kopo.ctc.kopo11.service.CategoryGroup;

public class StatisticDto {//=자바빈 ui에 데이터 보내줌

	private int year;
	private int month;
	
	private int incomeSum;
	private int expenseSum;
	
	private String category;
	private int categorySum;
	
	private List<AccountItem> accountItem;
	private List<CategoryGroup> categoryGroup;
	
	public List<CategoryGroup> getCategoryGroup() {
		return categoryGroup;
	}

	public void setCategoryGroup(List<CategoryGroup> categoryGroup) {
		this.categoryGroup = categoryGroup;
	}

	public List<AccountItem> getAccountItem() {
		return accountItem;
	}

	public void setAccountItem(List<AccountItem> accountItem) {
		this.accountItem = accountItem;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getIncomeSum() {
		return incomeSum;
	}

	public void setIncomeSum(int incomeSum) {
		this.incomeSum = incomeSum;
	}

	public int getExpenseSum() {
		return expenseSum;
	}

	public void setExpenseSum(int expenseSum) {
		this.expenseSum = expenseSum;
	}

	public int getCategorySum() {
		return categorySum;
	}

	public void setCategorySum(int categorySum) {
		this.categorySum = categorySum;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	

	
}
