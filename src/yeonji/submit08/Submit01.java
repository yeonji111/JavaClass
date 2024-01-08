package yeonji.submit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Submit01 {
    public static void main(String[] args) {

        HashSet<Integer> makeLotto = new HashSet<>();

        while (makeLotto.size() < 6) {
            makeLotto.add((int) (Math.random() * 45) + 1);

        }
        System.out.println(makeLotto);


        ArrayList<Integer> lotto = new ArrayList<>();
        lotto.addAll(makeLotto);

        Collections.sort(lotto);
        System.out.println(lotto);

    }



}


