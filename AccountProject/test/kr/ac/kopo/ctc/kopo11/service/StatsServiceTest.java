package kr.ac.kopo.ctc.kopo11.service;

import java.text.DecimalFormat;
import java.util.List;

import org.junit.Test;

import kr.ac.kopo.ctc.kopo11.domain.AccountItem;
import kr.ac.kopo.ctc.kopo11.dto.StatisticDto;

public class StatsServiceTest {
	
	private DecimalFormat df = new DecimalFormat("###,###,###,###,###");
	private StatsService statsService = new StatsServiceImpl();
	
//	@Test
//	public void AccountItemTitleSumTest() {
//	
//		StatisticDto statisticDto =  statsService.AccountItemTitleSum(6, 2019);
//		
//		System.out.println("[" + statisticDto.getMonth() + "]월");
//		System.out.printf("수입 합계 : %s원\n", df.format(statisticDto.getIncomeSum()));
//		System.out.printf("지출 합계 : %s원\n", df.format(statisticDto.getExpenseSum()));
//		System.out.printf("당월 잔액 : %s원\n", 
//				df.format(statisticDto.getIncomeSum() - statisticDto.getExpenseSum()));
//	}	
	
//		for (int item: a) {
//			
//		}
	
	
//	@Test
//	public void AccountItemOneCategorySumTest() {
//		
//		StatisticDto statisticDto = new StatisticDto();
//		statisticDto = statsService.AccountItemOneCategorySum("식비", 6, 2019);
//		
//		System.out.println("가계부번호  수입/지출    내역    메모            금액    기록일");
//		System.out.println("===================================================================");
//		
//		for( int i=0; i < statisticDto.getAccountItem().size(); i++ ) {
//			
//			System.out.printf("%d \t    %s \t %s \t %s \t %s \t %s \t\n", 
//					statisticDto.getAccountItem().get(i).getAccount().getId(),
//					statisticDto.getAccountItem().get(i).getTitle(), 
//					statisticDto.getAccountItem().get(i).getCategory(), 
//					statisticDto.getAccountItem().get(i).getMemo(),
//					df.format(statisticDto.getAccountItem().get(i).getMoney()), 
//					statisticDto.getAccountItem().get(i).getCreated());
//			
//		}
//		
//		System.out.println("===================================================================");
//		System.out.print("[" + statisticDto.getMonth() + "]월");
//		System.out.printf(" %s 합계 : %s원\n", statisticDto.getCategory(), df.format(statisticDto.getCategorySum()));
//		
//		
//	}

//	@Test
//	public void AccountItemAllCategorySumTest() {
//	
//		StatisticDto statisticDto =  statsService.AccountItemAllCategorySum(6, 2019);
//		
//		System.out.println("수입/지출  내역  내역별총금액");
//		System.out.println("================================");
//		
//		for (int i = 0; i < statisticDto.getCategoryGroup().size(); i++) {
//			System.out.printf("%s\t   %s\t %s원\n", 
//					statisticDto.getCategoryGroup().get(i).getTitle(),
//					statisticDto.getCategoryGroup().get(i).getCategory(),
//					df.format(statisticDto.getCategoryGroup().get(i).getMoney()));
//
//		}
//		
//	}
//
//	
}
