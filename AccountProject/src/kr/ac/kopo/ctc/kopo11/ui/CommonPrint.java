package kr.ac.kopo.ctc.kopo11.ui;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

//import kr.ac.kopo.ctc.kopo11.dao.AccountDao;
//import kr.ac.kopo.ctc.kopo11.dao.AccountDaoImpl;
import kr.ac.kopo.ctc.kopo11.domain.Account;
import kr.ac.kopo.ctc.kopo11.domain.AccountItem;
import kr.ac.kopo.ctc.kopo11.dto.StatisticDto;
import kr.ac.kopo.ctc.kopo11.service.CategoryGroup;

public class CommonPrint {
	private Scanner in = new Scanner(System.in);
	private DecimalFormat df = new DecimalFormat("###,###,###,###,###");
	//private AccountDao accountDao = new AccountDaoImpl();

	private int year = 0;
	private int month = 0;

	public int getYear() {
		return year;
	}

//	public void setYear(int year) {
//		this.year = year;
//	}
	public int getMonth() {
		return month;
	}
//	public void setMonth(int month) {
//		this.month = month;
//	}

	public void statsInput() {
		in = new Scanner(System.in);
		System.out.print("연도(네자리)를 입력하세요\n=");
		year = in.nextInt(); // 연도
		in.nextLine();
		System.out.print("월을 입력하세요\n=");
		month = in.nextInt(); // 월
		in.nextLine();

	}

	// utf-8은 한글 3바이트 영어 1바이트
	// (바이트 수 - 길이) / 2 = 한글 갯수
	public void koreanPrintUtil(String contents, int allLength) {

		int koreanCount = (contents.getBytes().length - contents.length()) / 2;

		for (int blank = 0; blank < allLength - contents.getBytes().length + koreanCount; blank++) {
			System.out.printf("%s", " ");
		}
	}

	public void accountItemPrint(List<AccountItem> accountItemList) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		System.out.println("일련번호 가계부번호 수입/지출  내역       메모               금액        기록일");
		System.out.println("=======================================================================================");
		for (int i = 0; i < accountItemList.size(); i++) {
			System.out.printf("%5d%9d%10s     %s", accountItemList.get(i).getId(),
					accountItemList.get(i).getAccount().getId(), accountItemList.get(i).getTitle(),
					accountItemList.get(i).getCategory());
			koreanPrintUtil(accountItemList.get(i).getCategory(), 11);

			System.out.print(accountItemList.get(i).getMemo());
			koreanPrintUtil(accountItemList.get(i).getMemo(), 12);

			System.out.printf("%12s%21s\n", df.format(accountItemList.get(i).getMoney()),
					sdf.format(accountItemList.get(i).getCreated()));
		}
		System.out.println("=======================================================================================");
	}

	public int backPrint() {
		in = new Scanner(System.in);
		int back = 0;
		System.out.println("====================================");
		System.out.print("99를 입력하시면 뒤로 갈 수 있습니다.\n=");
		back = in.nextInt();
		in.nextLine();
		return back;
	}

	public void CategoryGroupPrint() {
		StatisticDto statisticDto = new StatisticDto();
		CategoryGroup categoryGroup = new CategoryGroup();
		statisticDto = categoryGroup.AccountItemCategoryAll();

		System.out.println("현재 사용 중인 내역");
		System.out.println("================");
		System.out.println("번호 타입 내역");
		System.out.println("================");
		for (int i = 0; i < statisticDto.getCategoryGroup().size(); i++) {
			System.out.printf("%d.   %s %s\n", i + 1, statisticDto.getCategoryGroup().get(i).getTitle(),
					statisticDto.getCategoryGroup().get(i).getCategory());
		}
		System.out.println("================");

	}

	public void accountPrint(List<Account> accountList) {
		System.out.println("가계부 종류 목록\n");

		System.out.println("가계부번호 종류    만든날짜");
		System.out.println("=============================");
		for (int i = 0; i < accountList.size(); i++) {
			System.out.printf("%3d %9s %12s\n", accountList.get(i).getId(), accountList.get(i).getTitle(),
					accountList.get(i).getCreated());
		}
		System.out.println("=============================");
	}
}
