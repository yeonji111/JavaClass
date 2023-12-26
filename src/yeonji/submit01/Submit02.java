package yeonji.submit01;

public class Submit02 {

    public static void main(String[] args) {

        String enigma = "너오구늘리뭐너먹구지리";

        enigma = enigma.replace("너","");
        enigma = enigma.replace("구", "");
        enigma = enigma.replace("리","");

        System.out.println(enigma);


    }
}
