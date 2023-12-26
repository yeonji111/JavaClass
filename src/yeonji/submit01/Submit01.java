package yeonji.submit01;

public class Submit01 {
    public static void main(String[] args) {
        //Q.01

        String name = "홍길동";
        int age = 26;
        double height = 177.9;
//        long phone = 01073987332L;
        String phone = "01073987332";
        // 전화번호, 차량 번호, 주민등록번호, 우편번호, ...
        // 수치나 수량이 아닌 숫자들의 경우는 문자열로 다룬다.
        // 숫자끼리 연산할 일이 딱히 없는 숫자는 문자열로 다룬다.


        String email = "akow283@gmail.com";


        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height);
        System.out.println("연락처: " + phone);
        System.out.println("이메일: " + email);
    }
}
