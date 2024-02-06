package mini_test;

public class Account {
    private int balance = 0;        /* 계좌 잔고 */
    private String accountNum;  /* 계좌 번호 */
    private String userName;    /* 계좌주 */

    public Account() {
    }

    public Account(int balance, String accountNum, String userName) {
        this.balance = balance;
        this.accountNum = accountNum;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", accountNum='" + accountNum + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance >= MIN_BALANCE && balance <= MAX_BALANCE)
            this.balance = balance;
    }

    private static final int MIN_BALANCE = 0; // static final로 변경 불가능한 상수 선언하고 private 으로 외부 접근 제한
    private static final int MAX_BALANCE = 1000000; // static final로 변경 불가능한 상수 선언하고 private 으로 외부 접근 제한


    public static void main(String[] args) {
        Account account = new Account();

        account.setBalance(10000);
        System.out.println("현재 잔고: " + account.getBalance());

        account.setBalance(-100);
        System.out.println("현재 잔고: " + account.getBalance());

        account.setBalance(2000000);
        System.out.println("현재 잔고: " + account.getBalance());

        account.setBalance(300000);
        System.out.println("현재 잔고: " + account.getBalance());
    }

//    public static Account createAccount() {
//
////        return Account;
//    }
}

