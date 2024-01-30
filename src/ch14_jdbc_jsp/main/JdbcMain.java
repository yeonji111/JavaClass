package ch14_jdbc_jsp.main;

import ch14_jdbc_jsp.jdbc.ConnectionFactory;

import java.util.Scanner;

public class JdbcMain {

    public static void main(String[] args) {

        // 회원가입, 로그인, 회원목록
        // 로그인 후 게시판 진입
        // 글 목록, 글쓰기, 글조회
        // 회원 : 아이디, 비밀번호, 닉네임
        // 게시글 : 글번호, 글제목, 글내용, 작성자(닉네임)

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("행동을 선택해주세요");
            System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원목록 | 4. 종료");
            System.out.println(">>> ");

            int command = Integer.parseInt(scan.nextLine());
            ConnectionFactory.getInstance();

            if (command == 1){
                // 로그인 Select

            }
            if (command == 2){
                // 회원가입 Insert

            }
            if (command == 3){
                // 회원목록 Select while(rs.next)
                for ()

            }
            if (command == 4){
                break; // 종료
            }






        }





    }
}
