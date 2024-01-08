package yeonji.submit08;

import java.util.*;

/*

Collection _List,Map,Set

 */
public class SubmitSsam {

    public static void main(String[] args) {
        ArrayList<Integer> myLotto = makeLotto();
        System.out.println(myLotto);


        System.out.println("\n===================== 2번 ====================\n");

        HashMap<String, String> infoMap = new HashMap<>();

        infoMap.put("a001", "1234a");
        infoMap.put("b001", "1234b");
        infoMap.put("c001", "1234c");
        infoMap.put("d001", "1234d");
        infoMap.put("e001", "1234e");

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("아이디를 입력해주세요");
            System.out.println(">>>>>>");
            String id = scan.nextLine();

            System.out.println("비밀번호를 입력해주세요.");
            System.out.println(">>>>>>");
            String pw = scan.nextLine();

            // 로그인 성공
            if(infoMap.get(id) != null){
                // infoMap 내에 사용자가 입력한 아이디가 Key값으로 존재
                if(infoMap.get(id).equals(pw)){ // 에러날 일 없음
                    System.out.println("로그인 성공");
                    break;
                }else {
                    System.out.println("비밀번호가 틀립니다.");
                }

            } else {
                System.out.println("존재하지 않는 아이디 입니다.");
            }



        }


    }

    public static ArrayList<Integer> makeLotto() {
        HashSet<Integer> tempSet = new HashSet<>();

        while (tempSet.size() < 6) {
            int rand = (int) (Math.random() * 45) + 1;
            tempSet.add(rand);
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(tempSet);

        Collections.sort(result);

        return result;
    }

}


