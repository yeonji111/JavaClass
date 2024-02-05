package mini_test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Account account = new Account();
        ArrayList<Object> accountList = new ArrayList<>();

        while (true) {
            System.out.println("---------------------------------------------------");
            System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
            System.out.println("---------------------------------------------------");
            System.out.print("선택>>");

            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                // 계좌생성
                System.out.println("--------");
                System.out.println("계좌생성");
                System.out.println("--------");

                System.out.print("계좌번호: ");
                String accountNum = scan.nextLine();
                System.out.print("계좌주: ");
                String userName = scan.nextLine();
                System.out.print("초기입금액: ");
                String balance = scan.nextLine();

                accountList.add(account.setBalance(Integer.parseInt(balance))
                        , account.setAccountNum(accountNum)
                        , account.setUserName(userName));

                account.setBalance(Integer.parseInt(balance));
                account.setAccountNum(accountNum);
                account.setUserName(userName);


                System.out.println("결과: 계좌가 생성되었습니다.");

                continue;

            } else if (select == 2) {
                // 계좌목록
                System.out.println("--------");
                System.out.println("계좌목록");
                System.out.println("--------");

                for ()
                System.out.println(account.getAccountNum() + account.getUserName() + account.getBalance());


            } else if (select == 3) {
                // 예금

            } else if (select == 4) {
                // 출금

            } else if (select == 5) {
                // 종료
                break;

            }
        }
    }
}
