package yeonji.submit03;

public class Submit03 {
    public static void main(String[] args) {
        //궁리 1
//        String stars = "*****";
//
//        for(int i = 0; i < 5; i++){ // 다섯번 반복
//            for(int j = i; j > 0; j--){ // 공백 " " i가 반복하는만큼 넣을거임
//                System.out.print(" "); // 공백 지정
//            }
//            System.out.println(stars.substring(stars.length()-i,stars.length()));
        }
//       //  궁리 2
//        for (int i = 5; i > 0; i--) {
//            String stars = "";
//            for (int j = 5; j > 0; j--) {
//                stars += "*";
//
//                String blank = "";
//                for (int k = 0; k < (5 - j); k++) {
//                    blank += " ";
//                }
//                System.out.println(stars + blank); // 미친 트리 5개?

//        // 궁리 3
        String stars = "*****";

        for (int i = 0; i < stars.length(); i++){
            for (int j = i; j > 0; j--){ // 1. i = j = 0 인 경우
                System.out.print(" ");
                System.out.println(stars.substring(stars.length(),(stars.length()-i)));
            }


        }
    }
}