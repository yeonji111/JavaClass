package yeonji.submit07;

import java.util.ArrayList;
import java.util.Arrays;

public class Submit02 {
    public static void main(String[] args) {

// 리스트 만들고 동시에 담기
        ArrayList<String> yeon = new ArrayList<>(Arrays.asList("냉장고", "로봇청소기", "세탁기", "에어컨"));
        ArrayList<String> ji = new ArrayList<>(Arrays.asList("노트북", "TV", "에어컨", "플레이스테이션", "로봇청소기"));

// 교집합
        ArrayList<String> emp = new ArrayList<>();
        for (int i = 0; i < yeon.size(); i++) {
            yeon.get(i);
            for (int j = 0; j < ji.size(); j++) {
                ji.get(j);

                if (yeon.get(i) == ji.get(j)) {
                    emp.add(yeon.get(i));
                }

            }

        }
        System.out.println(emp);

// 남편,아내 쇼핑목록 합집합

        ArrayList<String>shoArr = new ArrayList<>();
        ArrayList<String>newArr = new ArrayList<>();
        newArr.addAll(yeon);

        for (int i =0; i < ji.size(); i++){
            ji.get(i);
                    for (int j = 0; j < newArr.size(); j++){
                        newArr.get(j);
                    }
            if (ji.get(i) != newArr.get(i)){
                ji.add(shoArr.get(i));
            }
        } System.out.println(ji);
    }
}
