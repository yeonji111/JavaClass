package yeonji.submit08;

import java.util.HashMap;
import java.util.Scanner;

public class Submit02 {
    public static void main(String[] args) {
        HashMap<String,String> infoMap = new HashMap<>();

        infoMap.put("a001", "1234a");
        infoMap.put("b001", "1234b");
        infoMap.put("c001", "1234c");
        infoMap.put("d001", "1234d");
        infoMap.put("e001", "1234e");

        Scanner scan = new Scanner(System.in);

        System.out.println("아이디를 입력해주세요");
        System.out.print(">>>>>>>");
        String id = scan.nextLine();

        if (infoMap.containsKey(id) == true) {
            System.out.println("비밀번호를 입력해주세요");
            String pw = scan.nextLine();
            if (infoMap.containsValue(pw) == true){
                System.out.println("로그인 성공");  // key랑 value값이 맞아야 정상적인 로그인 성공인데..?
            } else if (infoMap.containsValue(pw) != true) {
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }

        if (infoMap.containsKey(id) != true) {
            System.out.println("비밀번호를 입력해주세요");
            System.out.print(">>>>>>>");
            String pw = scan.nextLine();
            System.out.println("존재하지 않는 아이디입니다.");
        }


    }
}
