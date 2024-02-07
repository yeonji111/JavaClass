package yeonji.quiz;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QuizDB {
    private ArrayList<Quiz> quizList = new ArrayList<>();

    private QuizDB() {
        // 문제들 저장
        quizList.add(new Quiz("ㅇㄹㄷ", "알라딘", 5, "램프"));
        quizList.add(new Quiz("ㄱㅎㅈㅇ", "극한직업", 5, "치킨"));
        quizList.add(new Quiz("ㄱㅅㅊ", "기생충", 5, "짜파구리"));
        quizList.add(new Quiz("ㅇㅋㅌㄷㅁㄱ", "웰컴투동막골", 5, "팝콘"));
        quizList.add(new Quiz("ㄹㅁㅈㄹㅂ", "레미제라블", 5, "장발장"));
        quizList.add(new Quiz("ㅇㅌㅅㅌㄹ", "인터스텔라", 5, "stay"));
        quizList.add(new Quiz("ㅎㄹㅍㅌㅇㅁㅂㅅㅇㄷ", "해리포터와마법사의돌", 5, "윙가르디움레비오사"));
        quizList.add(new Quiz("ㅂㄷㅁㅇㄷㅇㅇㄹ", "바닷마을다이어리", 5, "일본영화"));
        quizList.add(new Quiz("ㅅㅇㅈㅇㄱㅇㅂ", "살인자의기억법", 5, "김영하"));
        quizList.add(new Quiz("ㅅㅈㅁㅇㅁㄷㅅ", "스즈메의문단속", 5, "애니메이션"));
        quizList.add(new Quiz("ㅅㅇㅇㅂ", "서울의봄", 5, "황정민"));
        quizList.add(new Quiz("ㅇㅋ", "웡카", 5, "티모시 샬라메"));
        quizList.add(new Quiz("ㅁㄹ", "명량", 5, "이순신"));
        quizList.add(new Quiz("ㄱㅈㅅㅈ", "국제시장", 5, "부산"));
        quizList.add(new Quiz("ㅂㅌㄹ", "베테랑", 5, "어이가 없네"));
        quizList.add(new Quiz("ㅇㅂㅌ", "아바타", 5, "파란색"));
        quizList.add(new Quiz("ㄱㅇㅇㄱ", "겨울왕국", 5, "자매"));
        quizList.add(new Quiz("ㅇㅂㅈㅅ:ㅇㄷㄱㅇ", "어벤져스: 엔드게임", 5, "건틀릿"));
        quizList.add(new Quiz("ㄷㄷㄷ", "도둑들", 5, "전지현"));
        quizList.add(new Quiz("ㅇㅅ", "암살", 5, "전지현"));


    }


    private static QuizDB intstnace = new QuizDB();

    public static QuizDB getIntstnace() {
        return intstnace;
    }

    public static void setIntstnace(QuizDB intstnace) {
        QuizDB.intstnace = intstnace;
    }

    public ArrayList<Quiz> getQuizList() {
        return quizList;
    }

    public void setQuizList(ArrayList<Quiz> quizList) {
        this.quizList = quizList;
    }

    // 게임 메소드
    public void game(int num) {
        Scanner scan = new Scanner(System.in);
        int score = 0; // 사용자의 점수는 0으로 초기화

//         새로운 리스트를 만들어서 퀴즈 리스트의 값들을 섞어서 저장
        ArrayList<Quiz> gameList = new ArrayList<>();

        Collections.shuffle(quizList);
        for (int i = 0; i < num; i++) {
            gameList.add(quizList.get(i));
        }

        // 게임 코드
        System.out.println("\n===== 영화 이름 맞추기 초성 게임 ======\n");
        System.out.println("👍 총 20개의 문제가 있습니다");
        System.out.println("👍 원하는 문제 갯수를 파라미터에 입력해주세요\n");
        System.out.println("👍 공백없이 정답을 입력해주세요");
        System.out.println("👍 한 문제당 5점입니다!");
        System.out.println("👍 틀리면 한 개의 힌트와 \n\t한 번의 재도전의 기회가 주어집니다.");
        System.out.println("\n=================================\n");

        for (int i = 0; i < gameList.size(); i++) {
            System.out.println("\n문제: " + gameList.get(i).getQuiz());
            System.out.print("정답을 입력해주세요 : ");
            String answer = scan.nextLine();
            num--;


            if (num == 0) {
                System.out.println("\n=========================\n");
                System.out.println("영화 퀴즈가 종료되었습니다.");
                System.out.println("최종 점수 : " + score);
                System.out.println("총 문제 갯수: " + gameList.size());
                System.out.println("맞춘 문제 갯수: " + (score / 5));
                System.out.println("\n=========================\n");
                break;

            } else if (answer.equals(gameList.get(i).getCorrect())) {
                System.out.println("정답입니다. ");
                // 나중에 Quiz 점수 다 다르게 할 수 있으니까 일단은 getScore() 사용함 score+=5 해도 되긴 할듯
                score += gameList.get(i).getScore();
                System.out.println("현재 점수 : " + score);


            } else {
                System.out.println("틀렸습니다.");
                System.out.println("힌트: " + gameList.get(i).getHint());
                if (true) {
                    System.out.println("\n문제: " + gameList.get(i).getQuiz());
                    System.out.print("정답을 입력해주세요 : ");
                    answer = scan.nextLine();

                }


            }


        }
    }
}