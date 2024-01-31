package ch14_jdbc_jsp.main;

import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionFactory;
import ch14_jdbc_jsp.service.MemberService;

import java.util.ArrayList;
import java.util.Scanner;

public class JdbcMain {

    public static void main(String[] args) {

        // 회원가입, 로그인, 회원목록
        // 로그인 후 게시판 진입
        // 글 목록, 글쓰기, 글조회
        // 회원 : 아이디, 비밀번호, 닉네임
        // 게시글 : 글번호, 글제목, 글내용, 작성자(닉네임)

        Scanner scan = new Scanner(System.in);
        MemberService memberService = MemberService.getInstance();


        while (true){
            System.out.println("행동을 선택해주세요");
            System.out.println("1. 로그인 | 2. 회원가입 | 3. 회원목록 | 4. 종료 | 5. 회원삭제");
            System.out.println(">>> ");

            int command = Integer.parseInt(scan.nextLine());
            ConnectionFactory.getInstance();

            if (command == 1){
                // 로그인 SELECT
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                MemberDTO member = new MemberDTO(id,pw, null, 0);

                MemberDTO login = memberService.signIn(member);

                if(login != null){
                    // 로그인 성공
                    System.out.println(login.getMemName() + "님 환영합니다.");
                }else{
                    System.out.println("아이디 혹은 비밀번호가 틀렸습니다.");
                }

            }
            if (command == 2){
                // 회원가입 (INSERT)
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                System.out.print("닉네임 입력: ");
                String name = scan.nextLine();

                MemberDTO member = new MemberDTO(id, pw, name, 0);

                int result = memberService.signUp(member);

                if (result == 0){ // INSERT문이 실행되지 않았을 경우 기본값인 0을 리턴하므로
                    System.out.println("회원가입 실패");
                }else{
                    System.out.println("회원가입 성공");
                }


            }
            if (command == 3){
                // 회원목록 (SELECT)
                ArrayList<MemberDTO> memberList = MemberService.getMemberList();

                for(int i = 0; i < memberList.size(); i++){
                    System.out.println(memberList.get(i));
                }
            }
            if (command == 4){
                break; // 종료
            }
            else if (command == 5){
                // 회원삭제 (DELETE)

                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.print("비밀번호 입력: ");
                String pw = scan.nextLine();

                MemberDTO member = new MemberDTO(id,pw, null, 0);

                int result = memberService.deleteMember(member);

                if(result > 0){
                    System.out.println("정상적으로 탈퇴되었습니다.");
                } else {
                    System.out.println("탈퇴 실패 !");
                }

            }






        }





    }
}
