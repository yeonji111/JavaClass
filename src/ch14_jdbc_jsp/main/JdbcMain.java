package ch14_jdbc_jsp.main;

import ch12_exception.BizException;
import ch14_jdbc_jsp.dto.BoardDTO;
import ch14_jdbc_jsp.dto.MemberDTO;
import ch14_jdbc_jsp.jdbc.ConnectionFactory;
import ch14_jdbc_jsp.service.BoardService;
import ch14_jdbc_jsp.service.MemberService;

import java.util.ArrayList;
import java.util.List;
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
        BoardService boardService = BoardService.getInstance();


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

                    while(true){
                        // 게시글 목록 출력
                        List<BoardDTO> boardList = boardService.getBoardList();
                        for (BoardDTO bo : boardList){
                            System.out.println("[ " + bo.getBoNo()
                                    + " | " + bo.getBoTitle()
                                    + " | " + bo.getMemName()
                                    + " | " + bo.getBoDate()
                                    + " | " + bo.getViewCount() + " ]");

                        }


                        System.out.println("행동을 선택해주세요.");
                        System.out.println("1. 글쓰기 | 2. 글보기 | 3. 로그아웃 | 4. 글 삭제");
                        System.out.print(">>>> ");

                        int select = Integer.parseInt(scan.nextLine());

                        if (select == 1){
                            // 글쓰기
                            System.out.print("글 제목 입력 : ");
                            String title = scan.nextLine();

                            System.out.print("글 내용 입력 : ");
                            String content = scan.nextLine();

                            BoardDTO board = new BoardDTO();
                            board.setBoTitle(title);
                            board.setBoContent(content);
                            board.setMemId(login.getMemId());

                            int result = boardService.writeBoard(board);

                            if (result > 0) {
                                System.out.println("글 등록 완료");
                            } else {
                                System.out.println("글 등록 실패 !");
                            }




                        } if (select == 2){
                            // 글보기
                            // 자바 단에서 클릭은 안되니까 글번호 입력받는 방식으로
                            System.out.println("글 번호 입력 : ");
                            int no = Integer.parseInt(scan.nextLine());

                            BoardDTO bo = boardService.readBoard(no);

                            if (bo != null){
                                // DB에 존재하는 게시글을 선택한 것이므로
                                // 해당 게시글의 조회수 +1 시킨다.
                                boardService.upViewCount(no);

                                System.out.println("=========================");
                                System.out.println("제목: " + bo.getBoTitle());
                                System.out.println("작성자: " +bo.getMemName());
                                System.out.println("작성일: " +bo.getBoDate());
                                System.out.println("-------------------------");
                                System.out.println(bo.getBoContent());
                                System.out.println("=========================");
                            } else {
                                System.out.println("요청하신 페이지를 찾을 수 없습니다.");
                            }



                        } else if(select == 3){
                            // 로그아웃
                            System.out.println("로그아웃 되었습니다.");
                            break;


                        } else if(select == 4){
                            // todo 글 삭제
                            // mem_boards 테이블에 delete Y/N 컬럼 추가
                            // 삭제여부 delete_YN 값이 "Y"(삭제 O) / "N"(삭제 X)
                            System.out.println("글 번호 입력 : ");
                            int no = Integer.parseInt(scan.nextLine());

                            // 해당 게시글의 작성자(mem_id)가
                            // 현재 로그인한 사람의 아이디(mem_id)와 일치해야
                            // 삭제가 되도록 하기

                            BoardDTO board = boardService.readBoard(no);

                            if(board != null){

                                if(login.getMemId().equals(board.getMemId())){

                                    try {
                                        boardService.deleteBoard(no);
                                    } catch (BizException e) {
                                        System.out.println("에러페이지: 글 삭제 안됨");
                                    }
                                }else {
                                    System.out.println("해당 글을 삭제할 수 없습니다.");
                                }

                            }


                        }




                    }





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