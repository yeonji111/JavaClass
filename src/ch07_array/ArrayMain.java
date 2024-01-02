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
        seoyugi[0] = "삼장";
        // seoyugi = ["삼장", null, null, null]
        seoyugi[1] = "오공";
//        seoyugi = ["삼장","오공", null, null]
        seoyugi[2] = "사오정";
        seoyugi[3] = "저팔계";

        // 한번에 배열 내 요소들을 확인하기
        // for문을 이용한 배열 순회
        for (int i = 0; i < seoyugi.length; i++) {
            // i 는 0,1,2,3 -> 인덱스로 사용 가능
            System.out.println(seoyugi[i]);
        }

        System.out.println("\n==========================\n");
        // 배열 내 요소를 한번에 볼 수 있는 함수 만들기
        printArray(seoyugi); // [삼장, 오공, 사오정, 저팔계]

        // 자바에서의 배열(Array)은 직접 만들어서 사용하는 경우가 드물다.
        // 배열의 크기가 고정되어있는게 너무 불편함
        // (다른 언어는 대부분 배열의 크기가 유동적임)
        // (자바에서는 컬렉션을 주로 사용)


        System.out.println("\n==========================\n");
        // 배열의 장점
        // for문을 이용하여 배열의 담긴 모든 요소들을 한번에 처리할 수 있다.
        // 모든 요소들 앞에 "서유기" 를 붙여주고자 한다면

        for (int i = 0; i < seoyugi.length; i++) {
            seoyugi[i] = "서유기 " + seoyugi[i];
        }
        printArray(seoyugi);

        // 배열 내 특정 요소에 접근하여 처리할 수 있다.
        // 서유기 오공 -> 드래곤볼 오공
        for (int i = 0; i < seoyugi.length; i++) {
            if (seoyugi[i].equals("서유기 오공")) {

            }

            if (seoyugi[i].contains("오공")) {

            }

            //"서유기 삼장", "서유기 오공", "서유기 사오정"
            if (seoyugi[i].indexOf("오공") != -1) {
                seoyugi[i] = seoyugi[i].replace("서유기", "드래곤볼");
            }
        }
        printArray(seoyugi);

        System.out.println("\n==========================\n");

        int[] intArray = new int[6];

        intArray[0] = 1;
        intArray[1] = 2; // 1,2,0,0,0,0

        System.out.println(intArray); // [I@682a0b20


        // 메소드 오버로딩
        printArray(intArray); // 파라미터로 int 타입이 올 수 있도록 printArray 메소드 오버로딩함.

        // 숫자 배열 안에 로또 번호 넣기
        // Math.random() : 0~1 사이의 소수 리턴(1은 안나옴)
        System.out.println(Math.random());
        // Math.random * 10 : 0~10 사이의 소수 리턴(10은 안나옴)
        System.out.println(Math.random() * 10);
        //(int) (Math.random() * 10)
        System.out.println((int) Math.random() * 10); // int 강제 형변환이 Math.radom()에 적용돼서 무조건 0이 출력되어버림
        System.out.println((int) (Math.random() * 10));
        // 로또 번호는 1~45 사이의 랜덤 정수
        // (int)(Math.random() * 45) : 0부터 44 사이의 정수
        // (int)(Math.random() * 46) : 0부터 46 사이의 정수
        System.out.println((int) (Math.random() * 45) + 1);


        //intArray에 로또번호 6자리 담기 [for문 이용]
        intArray[0] = (int) (Math.random() * 45) + 1;
        intArray[1] = (int) (Math.random() * 45) + 1;
        intArray[2] = (int) (Math.random() * 45) + 1;
        intArray[3] = (int) (Math.random() * 45) + 1;
        intArray[4] = (int) (Math.random() * 45) + 1;
        intArray[5] = (int) (Math.random() * 45) + 1;

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 45) + 1;
            printArray(intArray);
        }

        System.out.println("\n===========================\n");

        // 값을 넣으면서 배열을 선언
        String[] students = {"건희", "태완", "정현"};

        // 위 한줄이 아래의 4줄과 같다.
        String[] stu = new String[3];
        stu[0] = "건희";
        stu[1] = "태완";
        stu[2] = "정현";


        printArray(students);
        printArray(stu);

        System.out.println("\n===========================\n");

        // 배열을 사용할 수 밖에 없게끔
        // 특정 메소드에서 배열을 리턴하거나, 파라미터로 배열을 요구하는 경우가 있음.

        // 문자열 나누기
        String company = "카카오, 네이버, 배민, 요기요";

        // .split(문자열)
        // 괄호 안 문자열을 기준으로 해당 문자열을 나누어서
        // 문자열 배열로 리턴
        String[] comArray = company.split(",");
        System.out.println(comArray.length);
        System.out.println(comArray[1]);

        // 각각의 요소에 좌우 공백 제거 .trim
        for (int i = 0; i < comArray.length; i++) {
            comArray[i] = comArray[i].trim();
        }

        System.out.println(comArray[1]);


        String language = "자바+자바스크립트+파이썬";
//        String[] lanArray = language.split("+");
        String[] lanArray = language.split("\\+");
        // regex는 정규표현식(Regular Expression)의 약자
        // *, ?, + 의 경우 정규표현식에서 특정 기능을 가지는 특수문자이므로
        // "" ,'', \\ 와 같이 앞에 \\ 를 붙여주어야 일반 문자로 동작

        printArray(lanArray);

        // 정규표현식 사용 예시
        // 이름에 한글, 영어로만 기입했는지 체크
        // PIN번호에 숫자만 기입했는지 체크
        // 비밀번호에 알파벳 소/대문자, 숫자, 특수문자 각 한 개 이상 들어갔는지 체크




    }

    // printArray 메소드 만들기
    public static void printArray(String[] name) {
        System.out.print("[");
        for (int i = 0; i < name.length; i++) {
            if (i == name.length - 1) {
                System.out.print(name[i]);
            } else {
                System.out.print(name[i] + ", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }

    public static void printArray(int[] name) {
        System.out.print("[");
        for (int i = 0; i < name.length; i++) {
            if (i == name.length - 1) {
                System.out.print(name[i]);
            } else {
                System.out.print(name[i] + ", ");
            }
        }
        System.out.print("]");
        System.out.println("");
    }


}
