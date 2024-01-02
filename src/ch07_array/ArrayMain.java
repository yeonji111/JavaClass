package ch07_array;

public class ArrayMain {
    public static void main(String[] args) {
        String samjang = "삼장";
        String woogoong = "오공";
        String saojeong = "사오정";
        String palgye = "저팔계";

        // 배열 선언
        // 문자열(String)을 담을 수 있는 배열
        // 오른쪽 대괄호[] 안에 있는 숫자는 첨자라고 부르며,
        // 해당 배열이 담을 수 있는 값의 개수를 의미한다. (= 배열의 크기)
        String[] seoyugi = new String[4];

        // .length
        // 배열의 크기 리턴
        System.out.println(palgye.length()); // 문자열의 길이
        System.out.println(seoyugi.length); // length에 소괄호 없음 = 배열의 크기 리턴

        // 배연 안에 담겨있는 값 하나하나를 요소(element)라고 표현
        // 배열 내 요소를 확인하려면 인덱스 사용 (= 인덱싱)
        System.out.println(seoyugi); // [Ljava.lang.String;@776ec8df
        System.out.println(seoyugi[0]); // 배열 내 인덱스 0번째 요소 확인

        // 크기만 선언되고 값을 별도로 부여하지 않은 배열 내에는
        // 해당 타입의 기본값(default)이 들어있다.
        // 숫자타입: 0
        // boolean: false
        // 참조타입: null

        int[] numbers = new int[5];
        System.out.println(numbers[1]); // 0, 0, 0, 0, 0

        boolean[] bools = new boolean[3];
        // 인덱스 -1 이나 3과 같이 배열에 존재하지 않는 인덱스를 넣으면 에러 발생
        System.out.println(bools[2]); // false, false, false

        System.out.println("\n==========================\n");


        // 배열에 값 넣기
        // seoyugi = [null, null, null, null]
        seoyugi[0] ="삼장";
        // seoyugi = ["삼장", null, null, null]
        seoyugi[1] ="오공";
//        seoyugi = ["삼장","오공", null, null]
        seoyugi[2] ="사오정";
        seoyugi[3] ="저팔계";

        // 한번에 배열 내 요소들을 확인하기
        // for문을 이용한 배열 순회
        for (int i = 0; i < seoyugi.length; i++){
            // i 는 0,1,2,3 -> 인덱스로 사용 가능
            System.out.println(seoyugi[i]);
        }

        System.out.println("\n==========================\n");
        // 배열 내 요소를 한번에 볼 수 있는 함수 만들기
        printArray(seoyugi); // [삼장, 오공, 사오정, 저팔계]


    }

    // printArray 메소드 만들기
    public static void printArray(String[] name){
        for(int i = 0; i < name.length; i++){
            System.out.print(name[i] + ", ");
        }

    }


}
