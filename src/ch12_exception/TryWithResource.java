package ch12_exception;

import java.text.ParseException;
import java.util.Scanner;

public class TryWithResource {

    public static void main(String[] args) {
        // 일반적으로 데이터가 오고가는 통로(스트림, Stream)가 연결
        // 되고, 사용하는 객체에 대해서, 사용이 끝난 후 close()를
        // 해주는 것이 권장됨
//        Scanner scan = new Scanner(System.in);
//        scan.nextLine();
//        scan.close();

        // try~with~resource 구문
        // 자원정리 .close() 가 권장되는 객체를
        // try() 소괄호 안에 선언 후
        // try(){} 중괄호 안에서 사용하면 끝
        // 이후 별도로 .close() 코드를 작성하지 않아도 알아서 닫아준다.
        // 일반적인 try~catch 구문과 달리 catch 부분이 없어도 된다.
        try(Scanner scan = new Scanner(System.in)){
            int command = Integer.parseInt(scan.nextLine());
        } catch (Exception e){
            System.out.println("숫자가 아닌 걸 입력함");
        }

        // 14번째 줄 코드에서 scan.close()로 닫았기때문에 실행이 되지 않음
        // try~with~resource 구문도 자체적으로 Scanner 객체의 입력을 닫기때문에
        // 실행되지 않고 오류를 뱉어낸다.
        Scanner copy = new Scanner(System.in);
        copy.nextLine();




    }
}
