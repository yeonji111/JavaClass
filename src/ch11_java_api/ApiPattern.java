package ch11_java_api;

import java.util.regex.Pattern;

public class ApiPattern {

    public static void main(String[] args) {
        // 정규표현식 (Regular Expression) * 해당 내용 파일찾기 = [Ctrl + Shift + F]
        // 특정 규칙을 가진 문자열의 집합을 표현하기 위해 쓰는 표현식

        // 숫자만 존재하는지 검증 (유효성 검사, Validation)
        String example = "143a243";
        // ^ : 문자열의 시작, $ : 문자열의 끝
        // [] : 하나의 문자
        // + : 한 개 이상
        // * : 0 개 이상
        String regex = "^[0-9]+$";

        // 검사 결과에 대한 true/false 리턴
        boolean result = Pattern.matches(regex, example);
        System.out.println(example +"의 검증 " + regex + " 결과: " + result);


        // boolean 타입에 담지 않고 바로 검증해서 결과값 출력하기.
        // String 메소드에 Pattern.matches()가 들어있음
        System.out.println(example.matches(regex));

        // 알파벳만 존재하는지 검증
        example = "Park Yeonji";
        regex = "^[a-z|A-Z| ]+$";
//        regex = "^[a-zA-Z ]+$"; --> [ | ] 은 생략 가능
//        regex = "^[a-zA-Z\\s ]+$"; --> 세개의 regex는 모두 같은 기준을 가지고 있다. [\\s 는 띄어쓰기 문자를 의미]
        result = example.matches(regex);
        System.out.println(example +"의 검증 " + regex + " 결과: " + result);



        // 한글만 존재하는지 검증
        example = "박ㅇㅕㄴㅈㅣ";
        regex = "^[가-힣|ㄱ-ㅎ|ㅏ-ㅣ]+$"; // --> 자음과 모음을 합친 한글을 기준으로 유효성 검사하는 기준
        result = example.matches(regex);
        System.out.println(example +"의 검증 " + regex + " 결과: " + result);


        // 아이디 패턴
        // 영어와 숫자로 구성
        // 아이디는 7글자 이상, 12글자 이하여야 한다.
        example = "pyj103701";
        regex = "^[a-z|A-Z|0-9|]{7}$";      // 7글자만 허용
        regex = "^[a-z|A-Z|0-9|]{7,}$";     // 7글자 이상만 허용(100글자도 괜찮음)
        regex = "^[a-z|A-Z|0-9|]{0,12}$";   // 12글자 이하
        regex = "^[a-z|A-Z|0-9|]{7,12}$";   // 7-12 글자
        regex = "^[\\w]{7,12}$";   //       \\w : 한 개의 알파벳 또는 한 개의 숫자와 동익
        result = example.matches(regex);
        System.out.println(example +"의 검증 " + regex + " 결과: " + result);

        // 비밀번호 패턴
        // 영어와 숫자 + 특수문자
        example = "1q2w3e4";
        regex = "^[\\w|!@#$%^&*()_+|]+$";    // 특수문자가 없어도 통과 됨
        result = example.matches(regex);
        System.out.println(example +"의 검증 " + regex + " 결과: " + result);

        // 영어 소문자, 대문자, 숫자, 특수문자 각 각 1개 이상
        // 8~16글자 사이의 비밀번호 패턴
        example = "Duswl701!";
        // .은 아무 문자를 의미
        // 조건이 여러개일 경우 (조건1)(조건2)(조건3)
        regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*(])[\\w!@#$%^&*(]{8,16}$";
        result = example.matches(regex);
        System.out.println(example +"의 검증 " + regex + " 결과: " + result);

        // 이메일 형식 체크
        example = "pyj10370160@gmail.com";
        regex = "^[\\w]+[@][a-z]+[.][a-z]+$";
        result = example.matches(regex);

        System.out.println(example +"의 검증 " + regex + " 결과: " + result);

        // PIN 비밀번호 설정시
        // 동일한 숫자가 연달아 3개 이상 있으면 금지 (단순 비밀번호 금지)
        example = "111224";
        regex = "^.*([0-9])\\1\\1.*$";  // .* 0개 이상의 문자가 앞에 있고 반복하면서 [0-9]\\1\\1 이 반복하면서 검증함
        result = example.matches(regex); // \\1\\1은 N(i),N(i)이라고 생각하는게 편할듯

        System.out.println(example +"의 검증 " + regex + " 결과: " + result);

    }
}
