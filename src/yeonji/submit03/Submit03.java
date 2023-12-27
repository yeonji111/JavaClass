package yeonji.submit03;

public class Submit03 {
    public static void main(String[] args) {

        // 출력 결과
        // ***** 별 5, 공백 0  // substring(0,4)  다 별 // .substring
        // **** 별 4, 공백 1 // .substring(0,3) 별 // .substring(4,4) 공백
        // *** 별 3, 공백 2 // .substring(0,2) 별 // .substring(3,4) 공백
        // ** 별 2, 공백 3 // .substring(0,1) 별 // .substring(2,4) 공백
        // * 별 1, 공백 4 // .substring(0,0) 별   //.substring(1,4) 공백

//        for (int i = 0; i < 5; i++){ // 일단 5번 반복할거니까.
//            String blank = " ";
//            stars=blank.replace('*');
//
//            stars.substring(4-i,4);;
//        }
        for (int i = 5; i > 0; i--){
            String stars ="";
            for (int j = 5; j > 0; j--){
                stars+= "*";

                String blank = "";
                for(int k = 0; k < (5-j) ; k++){
                    blank += " ";
                }
                System.out.println(stars + blank); // 미친 트리 5개?
            }



        }


//
//        for (int i = 0; i < 5 ; i++){
//            // stars안에 담겨있는 내용 * 의 substring(4,4-i)를 "(공백)" 으로 바꾸고 싶음.
//            String stars = "*****";
//            String blank = " ";
//            stars.substring(4,4-i)
        }

    }

