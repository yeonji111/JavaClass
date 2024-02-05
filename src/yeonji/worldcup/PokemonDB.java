package yeonji.worldcup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 리스트에 음식들 담는 싱글톤 클래스, 게임 실행 메소드 작성 */

public class PokemonDB {

    // foodList 에 음식들 담기
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();

    private PokemonDB() {
        pokemonList.add(new Pokemon("피카츄"));
        pokemonList.add(new Pokemon("라이츄"));
        pokemonList.add(new Pokemon("파이리"));
        pokemonList.add(new Pokemon("꼬부기"));
        pokemonList.add(new Pokemon("따라큐"));
        pokemonList.add(new Pokemon("뮤"));
        pokemonList.add(new Pokemon("피죤투"));
        pokemonList.add(new Pokemon("메타몽"));
        pokemonList.add(new Pokemon("잠만보"));
        pokemonList.add(new Pokemon("리자몽"));
        pokemonList.add(new Pokemon("탕구리"));
        pokemonList.add(new Pokemon("토게피"));
        pokemonList.add(new Pokemon("푸린"));
        pokemonList.add(new Pokemon("고라파덕"));
        pokemonList.add(new Pokemon("럭키"));
        pokemonList.add(new Pokemon("블래키"));
    }

    private static PokemonDB intstnace = new PokemonDB();

    public ArrayList<Pokemon> getFoodList() {
        return pokemonList;
    }

    public void setFoodList(ArrayList<Pokemon> foodList) {
        this.pokemonList = pokemonList;
    }

    public static PokemonDB getIntstnace() {
        return intstnace;
    }

    public static void setIntstnace(PokemonDB intstnace) {
        PokemonDB.intstnace = intstnace;
    }


    // 게임 메소드
    public void playGame(int num) {
        //  foodList 에 데이터를 추가해서 16강 이상의 이상형 월드컵으로 사용할때 쓸 수 있는 메소드로 만들기
        //  (많은 데이터가 있으면 파라미터로 입력받는 num강 이상형 월드컵 게임이 될 수 있도록 하기)

        Scanner scan = new Scanner(System.in);
//        boolean isDuple = false; 투두3 때문에 만들어둔 스위치
        ArrayList<Pokemon> gameList = new ArrayList<>();

        //  foodList 에서 랜덤으로 파라미터로 들어온 변수값만큼 뽑기
        Collections.shuffle(pokemonList);
        for (int i = 0; i < num; i++){
            gameList.add(pokemonList.get(i));
        }

        System.out.println("======= 포켓몬 이상형 월드컵 =======");

        while (gameList.size() > 0) {
            if (gameList.size() % 4 == 0) {
                System.out.println(gameList.size() + "강");

            } else if (gameList.size() == 1) {
                // 리스트에 하나 남았을때, 남은 데이터를 출력하고 우승 메세지 띄우기 + 종료하기
                System.out.println("결승");
                System.out.println(gameList.get(0).getPokemonName() + " 우승!!");
                break;
            }

            for (int i = 0; i < gameList.size(); i++) {
                // for문 증감식 i+= 2로 수정하기 -> 선생님 방식은 빈 리스트에 .add라서 내가 한 .remove방식에 적용하면 길이와 인덱스의 범위에 대해 오류를 뱉어냄
                System.out.println("포켓몬을 선택해주세요");
                System.out.println("1. " + gameList.get(i).getPokemonName()
                        + " | " + "2. " + gameList.get(i + 1).getPokemonName());
                System.out.print(">>>  ");

                int select = Integer.parseInt(scan.nextLine());

                // select 에 1이나 2가 아닌 값이 들어온 경우 다시 재출력
                // 해결법을 모르겠어서 그냥 프로그램 강제종료로 마무리 지었는데 좀 더 찾아보고 질문할것
                // ->   틀렸는데도 for문이 계속 진행되어서 문제였기때문에 i--;로 돌아가
                if (select != 1 && select != 2) {
                    System.out.println("다시 선택해주세요.");
                    i--;

                } else if (select == 1) {
                    gameList.remove(gameList.get(i + 1));
                } else if (select == 2) {
                    gameList.remove(gameList.get(i));
                }
            }
        }
    }
}
