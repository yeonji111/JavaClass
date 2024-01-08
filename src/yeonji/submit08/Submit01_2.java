package yeonji.submit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
Submit01은 메인안에서 굴러가게 만든거고
Submit01_2는 메인안에 있던 코드를 사용해서
ArrayList를 리턴하는 makeLotto 메소드를 만들었음

 */

public class Submit01_2 {
    public static void main(String[] args) {
        ArrayList<Integer> myLotto = makeLotto(6);
        System.out.println(myLotto);
    }

    public static ArrayList<Integer> makeLotto(int n) {


        HashSet<Integer> makeLotto = new HashSet<>();

        while (makeLotto.size() < n) {
            makeLotto.add((int) (Math.random() * 45) + 1);

        }
        System.out.println(makeLotto);


        ArrayList<Integer> lotto = new ArrayList<>();
        lotto.addAll(makeLotto);

        Collections.sort(lotto);
        System.out.println(lotto);


        return lotto;
    }



}
