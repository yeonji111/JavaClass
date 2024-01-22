package yeonji.submit10;

import ch09_class.homepage.Board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BoardMain {
    public static void main(String[] args) {

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 글 목록 | 2. 글쓰기 | 3.종료");
            System.out.println(">>>  ");
            Scanner scan = new Scanner(System.in);
            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                BoardDB.showBoardList();
            }
            if (command == 2) {
                System.out.print("글 제목 입력: ");
                String title = scan.nextLine();

                System.out.print("글 내용 입력: ");
                String content = scan.nextLine();

                Date dateToday = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

                String dateTodate = sdf.format(dateToday);
                Board board = new Board();
                BoardDB.wirteBoard(board);

            }
            if (command == 3) {

            }

        }
    }
}
