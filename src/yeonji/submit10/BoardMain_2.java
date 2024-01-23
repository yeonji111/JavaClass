package yeonji.submit10;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BoardMain_2 {
    public static void main(String[] args) {
        ArrayList<Board> boardList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 글 목록 | 2. 글 쓰기 | 3. 종료");
            System.out.println(">>>>");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                for (int i = 0; i < boardList.size(); i++) {
                    System.out.println(boardList.get(i));
                }
            } else if (command == 2) {
                System.out.println("글 제목 입력: ");
                String title = scan.nextLine();

                System.out.println("글 내용 입력: ");
                String content = scan.nextLine();

                Date today = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                String date = sdf.format(today);

                Board board = new Board(boardList.size()+1,title,date,content);
                boardList.add(board);
            }else {
                break;
            }


        }
    }
}
