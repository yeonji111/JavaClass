package yeonji.game;

import java.util.ArrayList;

public class PlayerDB {

    private static ArrayList<Player> playerList = new ArrayList<>();


    private PlayerDB() {
        playerList.add(new Player("admin", "admin"));
        playerList.add(new Player("admin2", "admin2"));
    }

    private static PlayerDB instance = new PlayerDB();

    public static PlayerDB getInstance() {
        return instance;
    }

    // 회원가입
    public static void signUp(Player user) {
        boolean isDuple = false;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getId().equals(user.getId())) {
                isDuple = true;
            }
        }
        if (isDuple == false) {
            playerList.add(user);
            System.out.println("회원가입 성공!");
            System.out.println(user.getId() +"님의 가입을 환영합니다 🙌🙌");

            System.out.println();
        } else {
            System.out.println("사용중인 아이디입니다.");
        }
    }


    // 로그인
    public static Player login(String id, String pw) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getId().equals(id) && playerList.get(i).getPw().equals(pw)) {
                return playerList.get(i);
            }
        }
        return null;
    }

    public static Player singIn(String id, String pw) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getId().equals(id) && playerList.get(i).getPw().equals(pw)) {
                return playerList.get(i);
            }
        }
        return null;
    }

    // 기록 조회, 랭킹 조회
}
