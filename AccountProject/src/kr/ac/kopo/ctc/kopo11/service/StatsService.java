package kr.ac.kopo.ctc.kopo11.service;

import kr.ac.kopo.ctc.kopo11.dto.StatisticDto;

public interface StatsService {
	
	//수입 지출 합계
	StatisticDto AccountItemTitleSum(int month, int year);
	
	//내역 한개의 합계 금액
	StatisticDto AccountItemOneCategorySum(String category, int month, int year);
	
	//내역 별 합계의 금액(자바로 그룹바이 구현)
	StatisticDto AccountItemAllCategorySum(int month, int year);
	
	
}
