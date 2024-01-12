package ch09_class.homepage;

import java.util.ArrayList;

// Member 객체들을 관리하는 객체
public class MemberDB {

    private ArrayList<Member> memList = new ArrayList<>();

    // 싱글톤 패턴 적용
    // 프로젝터 내에서 이 객체를 딱 하나만 생성해서 쓸 때 사용
    // 1. 기본 생성자의 접근제어자를 private으로 막는다.
    private MemberDB() {
        // memList에 Member 객체 두개 기본적으로 넣기 (로그인 확인하기 위함)
        memList.add(new Member("admin", "admin", "관리자"));
        memList.add(new Member("a001", "a123", "박연지"));
    }

    // 2. 필드에 MemberDB 자기 자신을 객체(Instance)로 소환한다.
    // 2-1. static을 붙여야 다른 곳에서 MemberDB 객체 생성없이
    //      Instance에 접근 가능
    // 2-2. 다른 곳에서 .instance와 같이 직접 접근하지 못하도록 private 설정
    private static MemberDB instance = new MemberDB();

    // 3. instance에 대한 Getter 만들어주기
    public static MemberDB getInstance() {
        return instance;
    }

    // 회원가입 메소드
    public void signUp(Member mem) {
        // 파라미터로 들어온 Member 객체의 아이디가
        // memList 내부에 존재하는 Member의 아이디와 중복되는지 체크
        // 중복되면 회원가입 불가, 중복되지 않아야만 add가 실행되게끔

        // memList를 for문을 돌려서 memList.get(i)의 아이디가
        // 파라미터로 들어온 mem의 아이디와 같은게 있는지 체크
        // for문이 종료된 이후에 중복된 것이 존재했다면 회원가입 X
        // for문이 종료된 이후에 중복된 것이 있었다면 회원가입 성공
        boolean isDuple = false;
        for (int i = 0; i < memList.size(); i++) {
            if (memList.get(i).getMemId().equals(mem.getMemId())) {
                isDuple = true;
            }
        }
        if (isDuple == false) {  //             if (!isDuple) {         과 같음
            memList.add(mem);
            System.out.println("회원가입 성공!!");
        } else {
            System.out.println("사용중인 아이디입니다.");
        }

    }

    // 회원목록 조회 메소드(memList 내부 조회)
    public void showMemList() {
        for (int i = 0; i < memList.size(); i++) {
            System.out.println(memList.get(i));
        }
    }

    // 로그인 메소드
    public Member signIn(String id, String pw) {
        for (int i = 0; i < memList.size(); i++) {
            if (memList.get(i).getMemId().equals(id)
                    && memList.get(i).getMemPw().equals(pw)) {
                return memList.get(i);
            }

        }
        // 로그인 실패시, 리턴할 Member가 없기에 null값 리턴
        return null;
    }

}
