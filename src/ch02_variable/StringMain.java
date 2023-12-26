package ch02_variable;

public class StringMain {

    public static void main(String[] args) {
        // 문자열(String)
        // 자바에서는 문자열을 처리하기 위한 String 클래스가 존재한다.
        // 클래스이므로 참조타입에 해당
        // 문자열을 처리할 수 있는 다양한 메소드들이 존재한다.
        // 문자열은 쌍따옴표("") 안에 있는 문자들이다.
        // char 타입의 '가'는 String 타입의 "가"와 서로 타입이 다르다.
        String fruits = "Apple, Banana, Cherry";
        System.out.println(fruits);


        System.out.println("\n============== 변수, 문자열 메소드(.charAt .subsring .replace .trim ===========\n");

        // .length() 문자열의 길이를 리턴해주는 메소드 !!!!!!!!!!!!!!!!!!!!!
        System.out.println(fruits.length());
        System.out.println("Apple, Banana, Cherry".length());



        // .charAt(인덱스)
        // 인덱스는 배열에서 각 요소별 순번에 해당한다.
        // 인덱스는 0부터 시작한다.
        // 해당 인덱스의 문자를 리턴(char타입으로) 해준다.

        System.out.println(fruits.charAt(3));
        char alpha = fruits.charAt(3);
        System.out.println(alpha);



        // .substring(시작 인덱스, 끝 인덱스)
        // 해당 문자열을 시작 인덱스에서 끝 인덱스의 전까지 자른 값을 리턴(String 타입으로)한다.


        System.out.println(fruits.substring(7,13)); // banana만 출력하고 싶어서 시작 인덱스 7, 끝 인덱스 전인 13 입력


        String strAlpha = fruits.substring(3,4); // l만 출력하고 싶어서 시작 인덱스 3, 끝 인덱스 전인 4 입력
        System.out.println(strAlpha);

        System.out.println( fruits.substring(3)); // 시작 인덱스만 넣으면 시작부터 끝까지 리턴

        // substring을 사용하더라도 해당 문자열이 직접적으로 변하지 않는다. (= 해당 문자열을 자른 모습을 리턴시킴)
        System.out.println(fruits);

        // 유효하지 않은 인덱스 번호 입력시 에러가 발생한다.
        // 코드를 실행하기도 전에 빨간줄이 그어지는 에러는 '컴파일 에러'
        // 코드 실행 중에 발생하는 에러는 '런타임 에러' 라고 부른다.

//        System.out.println(fruits.charAt(51)); // Sting index out of range 라고 에러가 뜸
//        System.out.println(fruits.substring(13,44)); // begin 13, end 44, length 21라고 에러가 뜸


//        .replace(바뀔 문자열, 바꾸고 싶은 문자열)
//        해당 문자열에서 특정 문자열을 바꾸고 싶은 문자열로 교체한 값을 리턴한다.
        System.out.println(fruits.replace("Cherry", "Coconut"));

        // 리턴값을 원본에 적용하기
        fruits = fruits.replace("Cherry", "Coconut");
        System.out.println(fruits); // fruits의 변수값이 Cherry 에서 Coconut으로 대체되었으므로 Coconut으로 출력된다.


        // .trim()
        // 해당 문자열의 양 끝에 존재하는 모든 공백 문자를 제거해준다.

        String example = "      Hello, World  !!    ";

        // .replace 를 이용하여 문자열 내 공백 제거
        example.replace(" ", ""); // 문자열 내의 "   " 공백을 "" 없앤다는 의미
        System.out.println(example.replace(" ", ""));

        // 양 옆 공백만 지우고 싶어서 .trim 을 이용한 케이스
        System.out.println(example.trim()); // Hello, World 사이의 공백은 살리고, 양 끝쪽의 공백만 지우는 메소드


        // .toUpperCase()
        // .toLowerCase()
        // 해당 문자열에 존재하는 알파벳들을 전부 대문자로, 소문자로 바꿔주는 메소드

        System.out.println(fruits.toUpperCase()); // 모두 대문자로 출력
        System.out.println(fruits.toLowerCase()); // 모두 소문자로 출력


        System.out.println("\n========== .indexOf(문자열) ============\n");

        // !!!!!!!!! .indexOf(문자열)
        // 해당 문자열에서 괄호 안에 있는 문자열의 인덱스 리턴
        // 인덱스의 순번을 일일이 세지 않고 메소드를 통해 알 수 있음

        System.out.println(fruits.indexOf("Banana")); // 얘도 대소문자를 구분함, 괄호 안 문자열이 존재 하지 않으면 -1 을 출력함

        System.out.println(fruits.indexOf("orange")); // fruits 에는 orange 값이 없으므로 -1 을 출력

        System.out.println(fruits);
        System.out.println(fruits.indexOf("a")); // 대소문자를 구별하며, 가장 앞에 있는 문자의 인덱스만 리턴

        // .contains(문자열)  해당 문자열 내부에 괄호안 문자열이 존재하면 true, 없으면 false 를 리턴

        System.out.println(fruits.contains("orange")); // 없으므로 false 를 출력

        // .concat(문자열)   해당 문자열 뒤에 괄호 안 문자열을 이어붙인 결과를 리턴

        System.out.println(fruits.concat(", Durian"));

        // 문자열 이어붙이기는 + 기호로도 구현이 가능해서 잘 사용하지 않음

        System.out.println(10 + 5);
        System.out.println(fruits + ", Durian");


        // + 기호를 쓰면 앞에다가도 문자열을 붙일 수 있음
        System.out.println("과일목록: " + fruits);

        fruits = "과일목록: " + fruits + ", Durian";  // 변수값 변경
        System.out.println(fruits);

        System.out.println("\n==========================\n");

        // ""를 empty 혹은 빈 문자열이라고 부른다.
        String empty = "";
        System.out.println(empty); // 아무것도 출력되지 않음
        System.out.println(empty.length()); // "" 의 길이는 0이므로 0 출력

        String temp = null;
        System.out.println(temp); // temp 는 null 값을 담고 있으므로 null 을 출력
        System.out.println(temp.length()); // null 이라서 길이 파악을 못함

        // 참조타입의 경우 null 값을 가질 수 있다.
        // 기본타입의 경우 null 값을 가질 수 없다.

//        int nullnum = null 은 불가하다


        // 참조타입 변수에 대해 객체(instance) 라고 부른다.


    }
}
