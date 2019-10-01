//콘솔에 출력 담당 클라스
//서비스와 crud를 담당

package kr.ac.kopo.ctc.kopo11.ui;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.ctc.kopo11.dao.AccountDao;
import kr.ac.kopo.ctc.kopo11.dao.AccountDaoImpl;
import kr.ac.kopo.ctc.kopo11.dao.AccountItemDao;
import kr.ac.kopo.ctc.kopo11.dao.AccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo11.domain.Account;
import kr.ac.kopo.ctc.kopo11.domain.AccountItem;
import kr.ac.kopo.ctc.kopo11.dto.StatisticDto;
import kr.ac.kopo.ctc.kopo11.service.StatsService;
import kr.ac.kopo.ctc.kopo11.service.StatsServiceImpl;

public class AccountUi {
	
	private Scanner in = new Scanner(System.in);
	private DecimalFormat df = new DecimalFormat("###,###,###,###,###");
	private StatsService statsService = new StatsServiceImpl();
	private AccountDao accountDao = new AccountDaoImpl();
	private AccountItemDao accountItemDao = new AccountItemDaoImpl();
	private CommonPrint commonPrint = new CommonPrint();
	private StatisticDto statisticDto = new StatisticDto();
	private Account account = new Account();
	private AccountItem accountItem = new AccountItem();
	
	public void menu() {
		
		System.out.println("************************************************");
		System.out.println("입력 후 아무것도 안나오면 엔터한 번 더 치세요");
		System.out.println("뒤로에서-1을 입력하면 언제라도 프로그램 종료가능");
		System.out.println("************************************************\n");
		
		while(true) {
			try {
				int inputMenu;
				
				System.out.println("메뉴를 선택하세요");
				System.out.print("1. 조회\n2. 통계\n3. 입력/수정/삭제\n4. 종료\n=");
				inputMenu = in.nextInt();
				in.nextLine();
				if(inputMenu == 1) select(); 
				else if(inputMenu == 2) stats(); 
				else if(inputMenu == 3) insert_update_delete();
				else if(inputMenu == 4) System.exit(0);
				else if (inputMenu == -1) System.exit(0);
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}//in.nextLine();
		}
		
	}

	public void select() {
		int inputSelect = 0;
		do { 
			try {
				inputSelect =0;
				System.out.println("[1] 조회");
				System.out.print("1. 가계부 조회\n2. 현재 사용중인 내역 조회\n99. 뒤로\n=");
				inputSelect = in.nextInt();
				in.nextLine();
				if(inputSelect ==1) select1_1();
				else if(inputSelect ==2) select2();
				else if (inputSelect ==99) menu();
				else if (inputSelect == -1) System.exit(0);
			}catch (Exception e) {
				System.out.println("잘못입력하셨습니다.");
			}
			in.nextLine();
		}while(inputSelect !=1 && inputSelect !=2 && inputSelect !=99);

	}
		
	public void select1_1() {
		int back =0;
		do {
			try {
				//일단 가계뷰 종류 다 보여줌(selectAll Account)
				List<Account> accountList = accountDao.selectAll();
				commonPrint.accountPrint(accountList);
				
				System.out.println("1-1) 보고싶은 가계부 번호 또는 0(=모든 가게뷰)을 입력하세요");
				System.out.print("1-2) -2를 입력하시면 수입/지출 별 조회 가능합니다.\n=");
				
				int inputAccountID = in.nextInt();
				in.nextLine();
				//select all AccountItem
				if(inputAccountID==0) { 
					List<AccountItem> AccountItemList = accountItemDao.selectAll();
					commonPrint.accountItemPrint(AccountItemList);
				}
				//selectAllContainingAccount_id
				else if(inputAccountID==-2) {
					
				}
				else { 
					List<AccountItem> accountItemList = accountItemDao.selectAllContainingAccount_id(inputAccountID);
					commonPrint.accountItemPrint(accountItemList);		
				}
				back =commonPrint.backPrint();
				if (back == 99) select();
				else if (back == -1) System.exit(0);
			}catch (Exception e) {
				System.out.println("잘못입력하셨습니다.");
			}in.nextLine();
		}while(back !=99);
		
	}
	
	public void select1_2() {
		int back =0;
		do {
			try {
				System.out.print("1-2-1) 수입조회는 수입, 지출조회는 지출을 입력하세요.\n=");
				String inputT = in.next();
				in.nextLine();
				
				//selectAllContainingTitle
				if(inputT.equals("수입") || inputT.equals("지출")) {
					List<AccountItem> accountItemList = accountItemDao.selectAllContainingTitle(inputT);
					commonPrint.accountItemPrint(accountItemList);
				}
				back =commonPrint.backPrint();
				if (back == 99) select();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
	}
	
	public void select2() {
		int back =0;
		do {
			try {
				//현재 사용중인 내역을 보여줌
				commonPrint.CategoryGroupPrint();
				System.out.println("입력/수정/삭제 메뉴에서 입력,수정,삭제 가능합니다.");
				System.out.println("==================================================");
				back =commonPrint.backPrint();
				if (back == 99) select();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
	}
	
	public void stats() {
		int inputNo =0;
		do {
			try {
				System.out.println("[2] 통계(월기준)");
				System.out.println("1. 수입 /지출 별 합계 & 당월 잔액");
				System.out.println("2. 특정 내역 합계");
				System.out.println("3. 내역 별 합계");
				System.out.println("99. 뒤로");
				System.out.print("번호를 입력하세요\n=");
				inputNo = in.nextInt();
				in.nextLine();
				if(inputNo ==1) stats1();
				else if(inputNo ==2) stats2();
				else if(inputNo ==3) stats3();
				else if(inputNo ==99) menu();
				else if (inputNo == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(inputNo !=1 && inputNo !=2 && inputNo !=3 && inputNo !=99);
		

	}
	
	public void stats1() {
		int back =0;
		do {
			try {
				System.out.println("2-1) 수입 /지출 별 합계 & 당월 잔액");
				
				commonPrint.statsInput();
	
				StatisticDto statisticDto =  
						statsService.AccountItemTitleSum(commonPrint.getMonth(), commonPrint.getYear());
				
				System.out.println("=======================");
				System.out.println("[" + statisticDto.getMonth() + "]월");
				System.out.printf("수입 합계 : %s원\n", df.format(statisticDto.getIncomeSum()));
				System.out.printf("지출 합계 : %s원\n", df.format(statisticDto.getExpenseSum()));
				System.out.printf("당월 잔액 : %s원\n", 
						df.format(statisticDto.getIncomeSum() - statisticDto.getExpenseSum()));
				System.out.println("=======================");
				
				back =commonPrint.backPrint();
				if (back == 99) stats();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
	}
	
	public void stats2() {
		int back =0;
		do {
			try {
				//AccountItemCategoryOneSum
				System.out.println("2-2) 특정 내역 합계");
				commonPrint.statsInput();
				System.out.println("보고싶은 내역을 (한글로) 입력하세요");
				System.out.println("");
				commonPrint.CategoryGroupPrint();
				System.out.print("=");
				String category = in.next();
				in.nextLine();
			
				statisticDto = 
						statsService.AccountItemOneCategorySum( category, 
								commonPrint.getMonth(), 
								commonPrint.getYear());
				
				System.out.print("[" + statisticDto.getMonth() + "]월");
				System.out.printf(" %s 합계 : %s원\n", statisticDto.getCategory(), df.format(statisticDto.getCategorySum()));
				System.out.println("===========================");
				
				back =commonPrint.backPrint();
				if (back == 99) stats();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
	}
	
	public void stats3() {
		int back =0;
		do {
			try {
				System.out.println("2-3) 내역 별 합계");
				//AccountItemCategorySum_all
				commonPrint.statsInput();
				
				statisticDto = 
						statsService.AccountItemAllCategorySum( 
								commonPrint.getMonth(), 
								commonPrint.getYear());
				
				System.out.printf("[%d년 %d월]\n",statisticDto.getYear(),statisticDto.getMonth());
				System.out.println("수입/지출  내역    내역별총금액");
				System.out.println("================================");
				
				for (int i = 0; i < statisticDto.getCategoryGroup().size(); i++) {
					System.out.printf("%s\t   %s", 
							statisticDto.getCategoryGroup().get(i).getTitle(),
							statisticDto.getCategoryGroup().get(i).getCategory());
					
					commonPrint.koreanPrintUtil(statisticDto.getCategoryGroup().get(i).getCategory(),8);
					
					System.out.printf("%10s원\n",df.format(statisticDto.getCategoryGroup().get(i).getMoney()));
				}
				System.out.println("================================");
				
				back =commonPrint.backPrint();
				if (back == 99) stats();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
	}
	
	public void insert_update_delete() {
		int inputNo =0;
		do {
			try {
				System.out.println("[3] 입력/수정/삭제");
				System.out.println("1. 가계부 종류 이름 새로 입력");
				System.out.println("2. 가계부 데이터 입력");
				System.out.println("3. 가계부 종류 이름 수정");
				System.out.println("4. 가계부 데이터 수정");
				System.out.println("5. 가계부 종류 삭제");
				System.out.println("6. 가계부 데이터 삭제");
				System.out.println("99. 뒤로");
				
				System.out.print("번호를 입력하세요\n=");
				inputNo = in.nextInt();
				in.nextLine();
				
				if(inputNo ==1) insertAccount() ;
				else if(inputNo ==2) insertAccountItem();
				else if(inputNo ==3) updateAccount();
				else if(inputNo ==4) updateAccountItem();
				else if(inputNo ==5) deleteAccount();
				else if(inputNo ==6) deleteAccountItem();
				else if(inputNo ==99) menu() ;
				else if (inputNo == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(inputNo !=1 && inputNo !=2 && inputNo !=3 && inputNo !=4
				&& inputNo !=5 && inputNo !=6 && inputNo !=99);
	}
	
	public void insertAccount() {
		int back =0;
		do {
			try {
				//일단 가계뷰 종류 다 보여줌(selectAll Account)
				List<Account> accountList = accountDao.selectAll();
				commonPrint.accountPrint(accountList);
				
				System.out.print("3-1) 새로운 가계부 종류 이름을 새로 입력하세요.\n=");
				String newAccount = in.next();
				
				account.setTitle(newAccount);
				accountDao.create(account);
				
				System.out.println(newAccount+" : 입력완료");
				back =commonPrint.backPrint();
				if (back == 99) insert_update_delete();	
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);

	}
	
	public void insertAccountItem() {
		int back =0;
		System.out.println("<글자 입력이 깨질 수 있으니 커서 위치를 '=' 옆에 정확히 갖다놓고 입력하세요>");
		System.out.println("****************************************************************************");
		do {
			try {
				System.out.println("3-2) 가계부 데이터 입력");
				
				//일단 가계뷰 종류 다 보여줌(selectAll Account)//가게부 번호 입력하도록
				List<Account> accountList = accountDao.selectAll();
				commonPrint.accountPrint(accountList);
				
				System.out.print("입력할 가계부 종류의 번호를 선택하세요.\n=");
				int inputID = in.nextInt();
				
				System.out.print("수입 또는 지출을 입력하세요.\n=");
				String inputTitle = in.next();
				in.nextLine();
				
				System.out.print("(참고)");
				commonPrint.CategoryGroupPrint();
				System.out.print("내역을 입력하세요\n=");
				String inputCategory = in.next();
				in.nextLine();
				
				System.out.print("메모를 입력하세요\n=");
				String inputMemo = in.next();
				in.nextLine();
				
				System.out.print("금액을 입력하세요\n=");
				int inputMoney = in.nextInt();
				
				account = accountDao.selectOne(inputID);
			
				accountItem.setAccount(account);
				accountItem.setTitle(inputTitle);
				accountItem.setCategory(inputCategory);
				accountItem.setMemo(inputMemo);
				accountItem.setMoney(inputMoney);
				accountItemDao.create(accountItem);
				
				System.out.println(inputID+", "
							+inputTitle+", "+inputCategory+", "+inputMemo+", "
							+ ""+inputMoney+ ": 입력완료");
				
				back =commonPrint.backPrint();
				if (back == 99) insert_update_delete();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
		
	}
	
	public void updateAccount() {
		int back =0;
		do {
			try {
				System.out.println("3-3) 가계부 종류 이름 수정");
				
				//일단 가계뷰 종류 다 보여줌(selectAll Account)
				List<Account> accountList = accountDao.selectAll();
				commonPrint.accountPrint(accountList);
				
				System.out.print("변경할 가계부 번호를 입력하세요\n=");
				int inputID = in.nextInt();
				in.nextLine();
				System.out.print("새로운 가계부 종류 이름을 입력하세요\n=");
				String inputTitle = in.next();
				in.nextLine();
				
				account.setTitle(inputTitle);
				accountDao.update(inputID, account);
				
				System.out.println(inputID+"번 가계부 이름이 "+inputTitle+"(으)로 변경완료");
				back =commonPrint.backPrint();
				if (back == 99) insert_update_delete();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
	}
	
	public void updateAccountItem() {
		int back =0;
		do {
			try {
				//일단 가계뷰 종류 다 보여줌(selectAll Account)
				List<Account> accountList = accountDao.selectAll();
				commonPrint.accountPrint(accountList);
				System.out.println("");
				System.out.print("변경할 가계부 번호 먼저 선택하세요\n=");
				int inputAccountID = in.nextInt();
				in.nextLine();
				
				
				List<AccountItem> accountItemList = accountItemDao.selectAllContainingAccount_id(inputAccountID);
				commonPrint.accountItemPrint(accountItemList);		
				System.out.println("");
				
				System.out.print("변경할 데이터의 일련변호를 선택하세요\n=");
				int inputID = in.nextInt();
				in.nextLine();
				
				System.out.println("<글자 입력이 깨질 수 있으니 커서 위치를 '=' 옆에 정확히 갖다놓고 입력하세요>\n");
				System.out.println("변경 내용을 입력하세요");
				System.out.println("변경할 내용이 아니면 그대로 입력하시면 됩니다");
				
				System.out.print("수입/지출\n=");
				String inputTitle = in.next();
				in.nextLine();
				System.out.print("내역\n=");
				String inputCategory = in.next();
				in.nextLine();
				System.out.print("메모\n=");
				String inputMemo = in.next();
				in.nextLine();
				System.out.print("금액\n=");
				int inputMoney = in.nextInt();
				in.nextLine();
				System.out.print("기록일(yyyy-mm-dd형식으로 입력하세요)\n=");
				String inputCreated_str = in.next();
				in.nextLine();
				
				accountItem.setTitle(inputTitle);
				accountItem.setCategory(inputCategory);
				accountItem.setMemo(inputMemo);
				accountItem.setMoney(inputMoney);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date inputCrated_date;
				try {
					inputCrated_date = sdf.parse(inputCreated_str);
					accountItem.setCreated(inputCrated_date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				accountItemDao.update(inputID, accountItem);
				System.out.println("");
				System.out.println(inputAccountID+"번 가계부 일련번호 "+inputID+"번 데이터 변경완료");
				back =commonPrint.backPrint();
				if (back == 99) insert_update_delete();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
		
	}
	
	public void deleteAccount() {
	int back =0;
		do {
			try {
				System.out.println("3-5)가계부 종류 삭제");
				//일단 가계뷰 종류 다 보여줌(selectAll Account)
				List<Account> accountList = accountDao.selectAll();
				commonPrint.accountPrint(accountList);
				System.out.println("");
				
				System.out.print("삭제할 가계부 종류의 번호를 입력하세요\n=");
				int inputAccountID = in.nextInt();
				in.nextLine();
				
				accountItemDao.delete_foreign_key(inputAccountID);
				accountDao.delete(inputAccountID);
				System.out.println(inputAccountID+"번 가계부 삭제완료");
				back =commonPrint.backPrint();
				if (back == 99) insert_update_delete();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
			
	}
	
	public void deleteAccountItem() {
		int back =0;
		do {
			try {
				//일단 가게뷰 다 보여줌
				List<AccountItem> AccountItemList = accountItemDao.selectAll();
				commonPrint.accountItemPrint(AccountItemList);
				
				System.out.print("삭제할 데이터의 일련번호를 입력하세요\n=");
				int inputID = in.nextInt();
				in.nextLine();
				
				accountItemDao.delete(inputID);
				System.out.println("일련번호 "+inputID+"번 데이터 삭제완료");
				back =commonPrint.backPrint();
				if (back == 99) insert_update_delete();
				else if (back == -1) System.exit(0);
			}catch(Exception e) {
				System.out.println("잘못 입력하셨습니다.");
			}in.nextLine();
		}while(back != 99);
	}
}
