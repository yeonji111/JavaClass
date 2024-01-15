package ch09_class.homepage;

import java.util.Scanner;

public class HomepageMain {
    public static void main(String[] args) {
        // 회원가입, 로그인, 회원목록
        // 로그인 후 게시판 진입
        // 글 목록, 글쓰기, 글조회
        // 회원 : 아이디, 비밀번호, 닉네임
        // 게시글 : 글번호, 글제목, 글내용, 작성자(닉네임)

        // 회원가입을 할때마다 새로운 Member 객체를 생성
        // 생성된 Member 객체들을 관리하는 객체가 필요 -> MemberDB
        // MemberDB라는 객체는 딱 하나만 생성해서 쓸 예정
        // = 클래스에 싱글톤(Singleton) 패턴 적용

//        MemberDB db = MemberDB.instance;  -------> 직접적인 접근을 막아야하므로 private 선언 후 오류를 일으킴
//        MemberDB db = MemberDB.getInstance();
//        MemberDB.instance = null; ---------------> memberDB에 직접적인 접근을 허용(private 누락 상태)에는
//                                                  MemberDB의 Instance값 수정이 가능하므로 private선언 후, 접근이 불가능하게 막음

//        new Member("a001", "123a", "호빵맨");
//        new Member("b001", "123b", "세균맨");

        MemberDB memDB = MemberDB.getInstance();
        BoardDB boardDB = BoardDB.getInstance();

        System.out.println(boardDB);    // @404b9385

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("행동을 선택해주세요.");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. 회원목록 | 4. 종료");
            System.out.println(">>>  ");


            int command = Integer.parseInt(scan.nextLine());

            if (command == 1) {
                // todo 회원가입
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.println("비밀번호 입력: ");
                String pw = scan.nextLine();

                System.out.println("닉네임 입력: ");
                String name = scan.nextLine();

                // 사용자가 입력한 값에 대한  Member 객체 생성
                Member mem = new Member(id, pw, name);

                // MemberDB 객체 내 memList에 memd을 넣기
                memDB.signUp(mem);


            } else if (command == 2) {
                // todo 로그인
                System.out.print("아이디 입력: ");
                String id = scan.nextLine();

                System.out.println("비밀번호 입력: ");
                String pw = scan.nextLine();

                // memDB 내 memList에서 사용자가 입력한 id,pw와
                // 둘 다 일치하는 member 객체가 존재한다면 가져오기
                // 존재하지 않는다면 null값이 login에 담김
                Member login = memDB.signIn(id, pw);

                if (login != null) {
                    // 로그인 성공
                    System.out.println("로그인 성공!!");
                    System.out.println(login.getMemName() + "님 환영합니다.");

                    // 게시판 진입
                    while (true) {
                        // todo 게시물 목록 출력
                        BoardDB.showBoardList();
                        System.out.println("행동을 선택해주세요.");
                        System.out.println("1. 글쓰기 | 2. 글 보기 | 3. 로그아웃");
                        System.out.println(">>> ");

                        int select = Integer.parseInt(scan.nextLine());

                        if (select == 1) {
                            // todo 글쓰기
                            System.out.print("글 제목 입력: ");
                            String title = scan.nextLine();

                            System.out.print("글 내용 입력: ");
                            String content = scan.nextLine();


                            Board board = new Board(0, title, content, login.getMemName());
                            BoardDB.wirteBoard(board);


                        } else if (select == 2) {
                            // todo 글 보기
                            System.out.println("글 번호 입력: ");
                            int no = Integer.parseInt(scan.nextLine());

                            boardDB.readBoard(no);

                        } else if (select == 3) {
                            // todo 로그아웃
                            break;
                        }

                    }


                } else {
                    // 로그인 실패
                    System.out.println("존재하지 않는 아이디 이거나 비밀번호가 틀립니다.");

                }

            } else if (command == 3) {
                // todo 회원목록보기 / MemberDB 객체 내 memList 내부 조회
                memDB.showMemList();

            } else if (command == 4) {
                // todo 죵료
                break;
            }


        }


    }
}
