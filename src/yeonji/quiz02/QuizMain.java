package yeonji.quiz02;



/** 선생님 버전 영화 맞추기 게임
    영화이름, 명대사, 출연배우, 초성    */
import java.util.ArrayList;
import java.util.Scanner;

public class QuizMain {

    public static void main(String[] args) {
        ArrayList<Quiz> quizList = new ArrayList<>();

        quizList.add(new Quiz("신세계", "거 죽기 딱 좋은 날씨네", "황정민,이정재,박성웅", "ㅅㅅㄱ"));
        quizList.add(new Quiz("범죄도시", "니 내 누군지 아니", "마동석, 진선규", "ㅂㅈㄷㅅ"));
        quizList.add(new Quiz("아이언맨", "I am ironman", "로버트 다우니 주니어", "ㅇㅇㅇㅁ"));
        quizList.add(new Quiz("어벤져스", "어벤져스 어셈블", "로다주, 크리스 에반스", "ㅇㅂㅈㅅ"));
        quizList.add(new Quiz("곡성", "아쿠마다!", "황정민,곽도원", "ㄱㅅ"));

        Scanner scan = new Scanner(System.in);

        int score = 0;

        for (int i = 0; i < quizList.size(); i++) {
            // 명대사 보여줌
            System.out.println(quizList.get(i).getTalk());
            System.out.println(">>> ");

            // 정답 입력 받음
            String answer = scan.nextLine();

            // 정답 체크
            if (quizList.get(i).getName().equals(answer)) {
                score += 3;
                System.out.println("정답입니다. +3점");
                continue;
            }
            // 첫번째 힌트 (배우 이름)
            System.out.println(quizList.get(i).getActor());
            System.out.println(">>> ");

            answer = scan.nextLine();

            if (quizList.get(i).getName().equals(answer)) {
                score += 2;
                System.out.println("정답입니다. +2점");
                continue;
            }
            // 두번째 힌트 (초성)
            System.out.println(quizList.get(i).getWord());
            System.out.println(">>> ");
            answer = scan.nextLine();

            if (quizList.get(i).getName().equals(answer)) {
                score += 1;
                System.out.println("정답입니다. +2점");
                continue;
            } else {
                System.out.println(" 틀렸습니다. 다음 문제로 넘어갑니다.\n 정답: " + quizList.get(i).getName());
            }

        }
        System.out.println("총 점수: " + score);
    }
}

