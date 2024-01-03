package ch07_array;

import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
import java.util.Collections;

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

        System.out.println("\n===========================\n");

        printArray(seoyugi);

        // 배열의 복사
        String[] sinSeoyugi = seoyugi;

        printArray(sinSeoyugi);

        sinSeoyugi[0] = "강호동";
        sinSeoyugi[1] = "이수근";
        printArray(sinSeoyugi);

        printArray(seoyugi);

        // @ 앞은 참조 타입 객체의 타입,
        // @ 뒤는 메모리 주소의 해쉬코드를 16진수로 나타낸 것

        System.out.println(seoyugi);    // [Ljava.lang.String;@776ec8df [String 타입 배열, 메모리 주소]
        System.out.println(sinSeoyugi); // [Ljava.lang.String;@776ec8df [String 타입 배열, 메모리 주소]
        System.out.println(intArray);   // [I@682a0b20 [Int 타입 배열, 메모리 주소]

        // 해쉬코드(hashcode)
        // 객체의 메모리 주소값에 해쉬를 적용한 코드
        // 실제 메모리 주소 202호 -> 해쉬함수를 적용 -> 해쉬코드값
        System.out.println(seoyugi.hashCode());    // 2003749087
        System.out.println(sinSeoyugi.hashCode()); // 2003749087
        // 10진수 16진수로 변환
        System.out.println(Integer.toHexString(2003749087));

        // 해쉬(Hash)
        // 해쉬함수(암호화 알고리즘)를 이용해서
        // 데이터를 암호화하는 기법

        // Base64로 문자열 인코딩 (암호화 아님)
        Encoder base64Encoder = Base64.getEncoder();
        String password = "1q2w3e4";

        // .getBytes()
        // 해당 문자열을 byte 배열로 변환
        byte[] byteArray = password.getBytes();

        // byte 배열에 대해 인코딩
        byte[] encodeArray = base64Encoder.encode(byteArray);

        // byte 배열을 문자열로 변환
        String encodeString = new String(encodeArray);
        System.out.println(encodeString); // MXEydzNlNA==

        // 인코딩된 문자열 디코딩
        Decoder base64Decoder = Base64.getDecoder();
        // 디코딩된 byte 배열 리턴
        byte[] decodeArray = base64Decoder.decode(encodeString);
        String decodeString = new String(decodeArray);
        System.out.println(decodeString);


        System.out.println("\n============================\n");

        // 올바른 배열 복사
        printArray(seoyugi);

        String[] newSeoyugi = seoyugi.clone();
        printArray(newSeoyugi);

        newSeoyugi[2] = "은지원";
        printArray(newSeoyugi);
        printArray(seoyugi);

        System.out.println(newSeoyugi); // @4f3f5b24 [메모리 주소]
        System.out.println(seoyugi);    // @776ec8df [메모리 주소]

        // clone 없이 배열 복사 (for문 사용)
        // 1. seoyugi 와 같은 크기를 갖는 배열 만들기
        String[] synSeoyugi = new String[seoyugi.length];

        // 2. seoyugi의 각 인덱스 값을 synSeoyugi에 넣기
        for (int i = 0; i < seoyugi.length; i++){
            synSeoyugi[i] = seoyugi[i];
        }
        printArray(seoyugi);
        printArray(synSeoyugi); // 똑같은 배열 복사한 결과 [강호동, 이수근, 서유기 사오정, 서유기 저팔계]

        synSeoyugi[2] = "안재현";

        printArray(seoyugi);
        printArray(synSeoyugi); // 똑같은 배열을 복사해서 인덱스 2를 수정하니 [강호동, 이수근, 안재현, 서유기 저팔계] 리턴

        // 숫자 배열
        int[] numberArray ={11,2,56,65,89,21};

        System.out.println(numberArray[0]); // 11
        System.out.println(numberArray[1]); // 2

        // 인덱스 0번과 인덱스 1번 값의 위치를 바꿔보기
//        (내가 한 버전)
//        int[] testArray = numberArray.clone();
//
//        testArray[0] = numberArray[1];
//        testArray[1] = numberArray[0];
//
//        printArray(testArray);

//        (선생님 버전)
        int temp = numberArray[1]; // temp = 2
        numberArray[1] = numberArray[0]; // numberArray[0] = 11, numberArray[1] = 11
        numberArray[0] = temp;  // numberarray[0] = temp = 2 .... [2,11,56,65,89,21] 출력

        // 자리 바꾸기 메소드화
        printArray(numberArray);
        swap(numberArray[2], numberArray[3]);
        printArray(numberArray);

        // 가끔 면접에서 묻는 문제
        // Call by value와 Call by Reference 구분
        // 기본타입 변수에 대해서는 Call by Value로 동작
        // 참조타입 변수에 대해서는 Call by Reference로 동작
        int a = 10;
        int b = a;

        a = 20;
        System.out.println(b);



        swap(a,b); // a: 20, b:10

        System.out.println(a);
        System.out.println(b);

        printArray(numberArray); // [2, 11, 56, 65, 89, 21]
        swap(numberArray, 2, 3); // 인덱스 2,3의 자리를 바꾸는 메소드 사용
        printArray(numberArray); // [2, 11, 65, 56, 89, 21]


        System.out.println("\n============= 정렬 ===============\n");

        // 정렬(sort)
        // 오름차순 정렬
        // Arrays.sort(배열명)

        Arrays.sort(numberArray);
        printArray(numberArray);

        // 내림차순 정렬
        // 이 방법은 참조타입 객체를 담는 배열에 대해서만 가능한 방법
        // numberArray는 int타입을 담고 있으므로 불가능

      //  Arrays.sort(numberArray, Collections.reverseOrder());



        // 오름차순을 이용한 내림차순 정렬
        // 1. numberArray의 모든 요소에 -1을 곱함           {2,5,8} ->  -> {-2,-5,-8}
        // 2. numberArray에 Arrays.sort 적용 (음수 활용)   {-2,-5,-8} -> {-8,-5,-2}
        // 3. numberArray의 모든 요소에 -1을 곱함 (숫자를 원상복구) {-8,-5,-2} -> {8,5,2}

        for (int i = 0; i < numberArray.length; i++){
            numberArray[i] *= -1;
        }  // 모든 요소에 *(-1)

        Arrays.sort(numberArray); // 오름차순 정렬

        for (int i = 0; i < numberArray.length; i++){
            numberArray[i] *= -1;
        } // 모든 요소에 *(-1)

        printArray(numberArray);

        System.out.println("\n==========================\n");

        // 알고리즘을 이용한 정렬







    }

    // 배열 내 요소의 자리를 바꾸는 메소드
    public static void swap(int[] array, int idxA, int idxB){
        int temp = array[idxA];
        array[idxA] = array[idxB];
        array[idxB] = temp;

    }





    // 자리 바꾸기 메소드 만들기
    public static void swap(int left, int right){
        int temp = right;
        right = left;
        left = temp;

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
