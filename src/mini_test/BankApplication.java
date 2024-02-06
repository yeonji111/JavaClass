package mini_test;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Account> accountList = new ArrayList<>();

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

                int balance = Integer.parseInt(scan.nextLine());

                accountList.add(new Account(balance, accountNum, userName));


                System.out.println("결과: 계좌가 생성되었습니다.");

                continue;

            } else if (select == 2) {
                // 계좌목록
                System.out.println("--------");
                System.out.println("계좌목록");
                System.out.println("--------");

                for (int i = 0; i < accountList.size(); i++) {
                    System.out.println(accountList.get(i).getAccountNum()
                            + accountList.get(i).getUserName()
                            + accountList.get(i).getBalance());
                }


            } else if (select == 3) {
                // 예금
                // 계좌번호와 예금액을 입력받고 잔고 += 예금하고자 하는 금액하기
                // 조건 ) 계좌번호가 null값이 아니라면
                // , 리스트에 존재하는 계좌번호가 맞다면
                int inMoney = Integer.parseInt(scan.nextLine());



            } else if (select == 4) {
                // 출금
                // 계좌번호와 예금액을 입력받고 잔고 -= 예금하고자 하는 금액하기
                // 조건 ) 계좌번호가 null값이 아니라면
                // , 리스트에 존재하는 계좌번호가 맞다면
                int withdraw = Integer.parseInt(scan.nextLine()); // 인출하고자 하는 금액


            } else if (select == 5) {
                // 종료
                break;

            }
        }
    }
}
