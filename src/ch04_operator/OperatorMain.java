package ch04_operator;

public class OperatorMain {
    public static void main(String[] args) {

        // 산술 연산자
        int numberA = 10;
        int numberB = 3;
        System.out.println(numberA);
        System.out.println(numberA+1);

        //numberA에 1을 더하기
        numberA = numberA+1;
        System.out.println(numberA); // 11

        numberA = numberA+20;
        System.out.println(numberA); // 31

        numberA = numberA-21; // 31-21 = 10
        System.out.println(numberA);

        // 곱하기 numberA * numberB
        System.out.println(numberA*numberB); //10*3 = 30

        // 나누기 numberA / numberB
        System.out.println(numberA/numberB); // 10 나누기 3 = 3.3333 인데 소숫점 자리 사라지고 3만 출력
        System.out.println(numberB/numberA); // 3 나누기 10 = 0.3333 인데 소숫점 다 날리고 0만 남음
        // 나머지 numberA % numberB
        System.out.println(numberA % numberB); // 10을 3으로 나눈 나머지
        System.out.println(numberB % numberA); // 3을 10으로 나눈 나머지

        System.out.println("\n=========================\n");


        // 증감 연산자(1씩 증가 혹은 감소)
        numberA++; // 10에서 1 증가
        System.out.println(numberA);

        numberA--;
        System.out.println(numberA); // 11에서 1 감소

        ++numberA; // 10에서 1 증가
        System.out.println(numberA);


        // 증감연산자의 ++,--의 위치에 따라 실행 순서가 달라진다.

        // println 실행 당시에 numberA값 출력-> 이후 numberA에 1 증가
        System.out.println(numberA++); // 11 !!!!!!!!!!!!!!!
        System.out.println(numberA); // 12 !!!!!!!!!!!!!!!!!

        // println 실행 전에 numberA 1 증가 후 numberA 값 출력
        System.out.println(++numberA); // 13 !!!!!!!!!!!!!!!!

        System.out.println("\n========================\n");

        // 대입 연산자
        numberA = 10;

        numberA = numberA + 1;
        numberA++;

        numberA += 1; // numberA에 1 증가
        System.out.println(numberA);

        numberA -= 3; // numberA에 3 감소
        System.out.println(numberA);

        numberA *= 3; // numberA에 3 곱한값
        System.out.println(numberA);

        numberA /= 7; // numberA에 7로 나눈 값, 30/7 = 4 (나머지는 출력X)
        System.out.println(numberA);

        numberA %= 3; // numberA를 3으로 나눈 후 나머지 4/3 = 1
        System.out.println(numberA);

        // 문자열 이어붙이기에도 대입연산자 적용 가능
        String subway = "오룡역";
        subway = subway + " 서대전네거리";
        System.out.println(subway);

        // 문자열 뒤에만 이어붙일 수 있음
        subway += " 중구청";
        System.out.println(subway);

        // 변수 앞에 문자열을 붙이고 싶을때, 대입연산자보다 산술연산자 사용이 편함
        subway = "용문역 " + subway;
        System.out.println(subway);

        System.out.println("\n ========== 형변환 =========== \n");

        // 형변환 (Casting)
        // 형변환이 가능한 경우에 대해 형변환을 통해
        // 상황에 맞게 적절히 사용할 수 있다.

        int intNum = 15;
        double doubNum = 1.23;

//        -> 정수(int) 곱하기, 나누기 소수는 소수타입이 된다.
                System.out.println(intNum * doubNum); // 18.45

//        int temp = intNum * doubNum;    결과가 소수이므로 정수타입인 int로 담을 수 없어 오류를 발생시킴
        double temp = intNum * doubNum;

        float flo = intNum * 1.23f; // int  곱하기 float 은 float 타입
        double doub = intNum *1.23f; // float 타입을 double 타입으로 담음

        long longNum = 3465; // int 타입을 long 타입으로 담음

        // float -> double
        // int -> long 으로 담을 때에는 자동 형변환이 되어 담긴다.

        // long -> int 으로 형변환하기 (= 강제 형변환)
        int intNo = (int) 3465L; // long 타입 3465를 int 타입으로 변환 후 변수에 담음
        System.out.println(intNo);

//        int intMax = 3000000000L;
        int intMax = (int) 3000000000L;
        System.out.println(intMax); // MAX인 21억보다 초과한만큼 - 되어 출력, -12억

        // 소수타입 -> 정수타입 강제형변환
//        int intCast = 3.69;
        int intCast = (int)3.69;
        System.out.println(intCast); // int로 강제 형변환해서 소숫점을 제외한 정수에 해당하는 '3'만 출력된다.

//        int intMul = 10 * 3.33;
        int intMul = (int) (10 * 3.33);
        System.out.println(intMul); // 33


        // 10 / 3 = 3.3333
        // int / int = int 타입이 유지되는 성질
        System.out.println(10/3);

        double result = (double) 10 / 3;
        // 10을 double 타입으로 강제 형변환하여 10.0 / 3 = 3.33333333
        // double result = 10 / (double)3;
        // double result = 10 / 3.0;
        System.out.println(result); // 3.333333

        // 프로그래밍 언어에서 소수 연산의 정확도는 떨어진다.
        // 대부분 소수 둘째, 셋째자리로 반올림하여 쓰기 때문에 신경 쓸 일은 없다.



        // 숫자형 문자열 -> 정수로 형변환 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String strNum = "235";
        System.out.println(strNum + 2); // 2352

        int num = Integer.parseInt(strNum); // "235" -> 235
        System.out.println(num + 2);



        // 정수를 문자열로 형변환 타입 변수 = Integer.toString(정수) !!!!!!!!!!!!!!!

//        String comeback = num
//                String comeback = Integer.toString(num);
                String comeback = num + ""; // 정수를 문자열로 간단히 형변환 하는 방법 !!!!!!!!!!!!!!!!!!!


        // 소수형 문자열 -> 소수로 형변환 !!!!!!!!!!!!!!!! 타입 변수 = Double.parseDouble(소수형문자열)
        strNum = "23.45";
        double dnum = Double.parseDouble(strNum);

        System.out.println("\n============================\n");

        // 나머지 연산자(%) 사용 예시
        // 홀수, 짝수 판별
        int seven = 88;

        // seven 2로 나눈 나머지가 0이면 짝수, 1이면 홀수
        System.out.println(seven % 2);

        // 게시판 페이징 구현 !!!!!!!!!!!!!!!!!!!!!!!!!!
        int totalCountBoard = 33; // 게시글이 총 33개 있다.
        int showCountPage = 10; // 한 페이지에 보여줄 글의 수가 10개다.

        // 총 페이지의 수? -> 4페이지 !!!!!!!!!!!!!!!!!!
        // 33/10 = 3.3 -> 올림처리 = 4
        // Math.ceil(3.3) -> 4.0
        // totalCountBoard / showCountpage 먼저 계산해서 double 로 출력 -> 출력한 값 정수값으로 형변환 -> totalPage에 출력된 정수값 담기
        int totalPage = (int)Math.ceil((double)totalCountBoard / showCountPage);
        System.out.println(totalPage);


        // 마지막 페이지에 대한 글의 개수
        // 총 33개, 한페이지당 10개
        // 33 % 10 = 3
        int countLastPage = totalCountBoard % showCountPage;
        System.out.println(countLastPage);

        System.out.println("/n=======================/n");

        // 비교 연산자
        int numFive = 5;
        double pi = 3.14;
        int numOne = 1;

        //numFive 가 numOne 보다 작습니까?
        System.out.println(numFive < numOne); // 아니면 false 출력
        //numFive 가 numOne 보다 큽니까?
        System.out.println(numFive > numOne); // 맞다면 true출력

        // 비교 연산자의 결과는 true/false라서 boolean 타입 변수에 담을 수 있다.
        boolean boolRst = numFive > numOne;

        // 타입이 다른 숫자도 서로 비교 가능하다.
        System.out.println(numFive > pi);


        // 작거나 같냐 <=
        // 크거나 같냐 >=

        // == 는 왼쪽과 오른쪽이 같은지 비교
        // 같다면 true, 다르면 false 리턴
        System.out.println(numFive == numOne);
        System.out.println(numFive == 5);

        // != 는 왼쪽과 오른쪽이 다른지 비교 !!!!!!!!!!!!!! (조건문에서 사용)
        // 달라야 true, 같으면 false 리턴
        System.out.println(numFive != numOne);


        // 문자열이 같은지 비교
        String ship = "배";
        String pear = "배";
        String stomach = new String("배");
        System.out.println(ship);
        System.out.println(pear);
        System.out.println(stomach);

        System.out.println(ship == pear);
        System.out.println(ship == stomach);
        System.out.println(pear == stomach);


        // 문자열 값이 같은지 비교
        // .equals(문자열) !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // 해당 문자열이 괄호 안 문자열과 같다면 true, 다르다면 false 리턴
        System.out.println(ship.equals(stomach));

        // 빈 문자열(empty) 체크
        String inputData = "";
        System.out.println(inputData.equals("")); // .equals() 메소드를 사용한 첫번째 방법
        System.out.println(inputData.isEmpty()); // .isEmpty() 메소드를 사용한 두번째 방법, 빈 문자열이면 true
        System.out.println(inputData.length() == 0); // inputData의 길이가 0 이면 빈 문자열이므로 true

        // 문자(char) 는 비교연산자를 통해 비교 가능 (유니코드내에 넘버링이 되어있기때문에)
        // (= 이름순 정렬 같은 데에 사용 가능)
        System.out.println('가' > '나'); // '가'가 '나'보다 유니코드내 넘버가 작으므로 fasle

        String cat = "고양이";
        String dog = "강아지";
        System.out.println(cat.charAt(0) > dog.charAt(0)); // 순번이 0번째인 '고', '강'을 서로 비교함, '고'보다 '강'이 유니코드 내에 앞 순번이므로 true


        System.out.println("/n=======================/n");

        // 삼항 연산자  () ? () : ()      ---------- '?' ':' 있으면 삼항 영산자
        String inputId = "pyj103701";

        // inputId의 글자수가 7글자 이상이면 통과, 7글자 미만이면 불통
        // 첫번째 항에는 조건이 들어간다. (true/false)
        // 두번째 항에는 조건이 true일때 리턴되는 값을 작성한다.
        // 세번째 항에는 조건이 false일때 리턴되는 값을 작성한다.

        String check = (inputId.length() >= 7) ? ("통과") : ("불통"); // 결국 리턴되는 값이 문자열 "통과" or "불통" 이므로 String 타입으로 지정
        System.out.println(check);


        // inputId의 글자수가 7글자 이상이면 1, 미만이면 0  --------- 괄호 없애도 됨
        int check2 = inputId.length() >= 7 ? 1 : 0;
        System.out.println(check2);

        int score = 75;
        // score 가 90점 이상이면 "A", 90점 미만이면 "B"를 grade 에 담기
        String grade = (score >= 90) ? "A" : "B";
        System.out.println(grade);
        
        // score가 90점 이상이면 "A", 80점 이상이면 "B", 그 외 "C"!!!!!!!!!!!!!!!!!!! 삼항 연산자 안에 삼한 연산자를 넣는 것도 가능
//        grade = () ? () : () ;

        grade = (score >= 90) ? ("A") : ((score >= 80) ? ("B") : ("C"));
        System.out.println(grade);

        System.out.println("\n=============================\n");

        // 논리연산자
        // 조건체크를 여러번 하지 않고 한번에 끝낼 수 있도록 도와줌

        // 회원가입시
        // 이름은 한글자 이상
        // 나이는 14세 이상
        // 휴대폰번호는 10자리 '또는' 11자리 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String inputName = "박연지";
        int inputAge = 30;
        String inputPhone = "01047959465";

        System.out.println(inputName.length() >= 1);
        System.out.println(inputAge > 14);

        // 논리연산자 AND(&&)  !!!!!!!!!!!!!!!!
        // &&
        // && 의 왼쪽 조건과 오른쪽 조건이 모두 true일때만 true 리턴
        // 둘 중 하나라도 false면 false 리턴
        System.out.println(inputName.length() >= 1 && inputAge > 14);

        // 휴대폰 번호가 10자리 또는 11자리 => 휴대폰 번호가 10자리 이상 11자리 이하 !!!!!!!!!!!!!!!!!!!!!!!
//        inputPhone.length() >= 10 && inputPhone.length() <= 11;
        System.out.println(inputPhone.length() >= 10 && inputPhone.length() <= 11);


        // 논리연산자 OR
        // || (shift + 역슬래시)
        // || 의 왼쪽 조건과 오른쪽 조건 중 하나라도 true 이면 true 리턴
        // 둘 다 false 일때만 false 리턴
//        inputPhone.length() == 10 || inputPhone.length() == 11 --------- 휴대폰 길이가 10자리 이상 '또는(||)' 11자리 이상이면 true
        System.out.println(inputPhone.length() == 10 || inputPhone.length() == 11);

        // 5 < x < 20 를 자바에서 구현
        // 5 < x && x < 20
        System.out.println(5 < inputAge && inputAge < 20);

        // !
        // !를 boolean 타입 앞에 붙여주면 (true/fasle) 값을 뒤집는다.
        // 이름은 1글자 이상 = 이름은 empty가 아니어야 한다.
//        inputName.isEmpty() 는 inputName이 empty일때 true 리턴
//        inputName이 empty가 아닐때 true를 얻고자 한다면
//        !inputName.isEmpty()

        boolean checkName = !inputName.isEmpty();
        boolean checkAge = inputAge >= 14;
        boolean checkPhone = inputPhone.length() == 10 || inputPhone.length() == 11;
        System.out.println(checkName && checkAge && checkPhone);


        // 조건을 여러개 넣을 경우 () 처리 잘하기, 컴퓨터는 순서대로 처리하기 때문에 논리연산자 OR로 인해 잘못된 결과를 리턴할 수 도 있음

         System.out.println(!inputName.isEmpty()
                && inputAge >= 14
                && (inputPhone.length() == 10 || inputPhone.length() == 11));


        System.out.println("\n==========================\n");

        // 비트 연산자
        // 2진수
        int bitTen = 10; // 1010
        int bitNine = 9; // 1001
                         // 1000 (10과 9의 2진수를 AND 연산자로 나타낸 결과 - 8)




        // 비트연산자 AND
        // &
        // 2진수의 각 자리를 비교해서 같은자리의 숫자가 둘 다 1이면
        // 그 자리에 1이 남고, 둘 중 하나라도 1이 아니면 그 자리에 0이 남음
        System.out.println(bitTen & bitNine);

        // 비트연산자 OR
        // |
        // 각 자리수를 비교해서 둘 중 하나라도 1이면 그 자리에 1이 남음
        // bitTen 과 bitNine 비트연산자 OR 로 나타낸 2진수 1011 = 1+2+8 == 11
        System.out.println(bitTen | bitNine);

        // 비트연산 XOR
        // ^
        // 각 자리수를 비교해서 서로 다른 경우에만 그 자리에 1이 남음.
        //10(1010) 과 9(1001)을 비트연산 XOR로 나타내면 0011
        System.out.println(bitTen ^ bitNine);


        // 2진수 예시
        // 4가지 취미를 나타내기 위해 숫자로 저장
        // 0001 : 축구를 좋아함
        // 0010 : 야구를 좋아함
        // 0100 : 농구를 좋아함
        // 1000 : 배구를 좋아함
        // 동혁 : 0001
        int dhLike = 1;
        // 승환: 1010
        int shLike = 10;

        // 리눅스에서 파일, 폴더의 권한을 설정하는 명령어
        // chmod
        //

}
}