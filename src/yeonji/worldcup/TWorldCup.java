package yeonji.worldcup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TWorldCup {
    public static void main(String[] args) {
        ArrayList<String> menuList = new ArrayList<>();

        menuList.add("짜장면");
        menuList.add("짬뽕");
        menuList.add("볶음밥");
        menuList.add("김치찌개");
        menuList.add("제육볶음");
        menuList.add("돈까스");
        menuList.add("카레");
        menuList.add("규동");
        menuList.add("순대국밥");
        menuList.add("고등어구이");
        menuList.add("햄버거");
        menuList.add("육개장");
        menuList.add("백반");
        menuList.add("두부두루치기");
        menuList.add("칼국수");
        menuList.add("꼬마김밥");

        // menuList 섞기
        Collections.shuffle(menuList);

        playWorldCup(menuList);
    }

    static void playWorldCup(ArrayList<String> menuList) {

        Scanner scan = new Scanner(System.in);
        ArrayList<String> selectList = new ArrayList<>();

        if (menuList.size() == 2){
            System.out.println("결승");
        } else {
        System.out.println(menuList.size() + "강");
        }
        for (int i = 0; i < menuList.size(); i += 2) {
            System.out.println("1. " + menuList.get(i));
            System.out.println("2. " + menuList.get(i + 1));
            System.out.println(">>>> ");

            int select = Integer.parseInt(scan.nextLine());

            if (select == 1) {
                selectList.add(menuList.get(i));
            } else if (select == 2) {
                selectList.add(menuList.get(i + 1));
            }
        }

        menuList.clear();
        menuList.addAll(selectList);
        selectList.clear();

        // 재귀함수
        if (menuList.size() == 1){
            System.out.println(menuList.get(0) + " 우승!!!");
        } else {
            playWorldCup(menuList);
        }


    }
}

