package ch09_class.school;

import ch09_class.common.MyUtil;

// 학생은 이름, 국어, 영어, 수학, 평균을 가진다.
// lombok 라이브러리
//@Constructor
//@Setter
//@Getter
//@toString
public class Student {
    // 필드변수 선언
    // 필드변수를 싹다 private 으로 두고
    // 각 필드변수에 대해 Getter,Setter를 만드는 방식
    // 캡슐화 (Encapsulation) -> 국룰
    private String name ;   /* 학생 이름 */
    private int kor;        /* 국어 점수 */
    private int eng;        /* 영어 점수 */
    private int math;       /* 수학 점수 */
    private double avg;     /* 점수 평균 */



    // 접근제어자
    // 클래스 내 필드변수, 메소드, 생성자를 다른 패키지(폴더)에서
    // 접근 가능한 여부를 제어함
    // public : 모든 패키지에서 사용 가능
    // private : 현재 클래스 내에서만 사용 가능
    //          (같은 패키지에 있는 다른 클래스에서도 사용 불가)
    // protected : 같은 패키지(폴더) 내에서만 사용 가능
    //          ( 같은 패키지에 있는 다른 클래스에서는 사용 가능,
    //          ( 다른 패키지에 있는 클래스에서는 사용 불가능)
    // (default) : 접근제어자를 기입하지 않은 상태, protected와 같음
    public Student(){}

    // 평균을 따로 입력받지 않아도, 되는 생성자
    public Student(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.avg = (kor + eng + math)/3.0;
        calAvg();
    }

    // 평균을 계산해서 반올림까지 적용하는 메소드
    // 오로지 Student 클래스 내에서만 사용하는 메소드
    // 다른 곳에서 사용하지도 않기 때문에, 접근 못하게 private 적용
    private void calAvg(){
        avg = (kor + eng + math) / 3.0;
       avg = MyUtil.myRound(avg,2);
    }



    // 풀생성자를 만들면 파라미터를 무조건 넣어야하므로
    // 파라미터를 입력하지 않아도 되는 기본 생성자 생성
    // public Student() {}

    // 풀(full)생성자 만들기
    public Student(String name, int kor, int eng, int math, double avg) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        this.avg = avg;
        calAvg();
    }

    // toString() 생성 단축키 : [Alt + Insert]
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", avg=" + avg +
                '}';
    }

    // Getter 라고 부름
    // name 에 저장된 값을 보여주는 메소드
    public String getName(){
        return name;
    }

    // [Alt - Insert] - Getter를 사용해서 자동완성가능
    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public double getAvg() {
        return avg;
    }

    // 다른 클래스에서 이름을 바꾸게 허용하는 메소드
    // [Alt - Insert] - Setter
    public void setName(String name){
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
//        this.avg = (this.kor + this.eng + this.math) / 3.0;
//        this.avg = MyUtil.myRound(this.avg,2);
        calAvg();
    }

    public void setEng(int eng) {
        this.eng = eng;
//        this.avg = MyUtil.myRound(this.avg,2);
        calAvg();
    }

    public void setMath(int math) {
        this.math = math;
//        this.avg = (this.kor + this.eng + this.math) / 3.0;
//        this.avg = MyUtil.myRound(this.avg,2);
        calAvg();
    }



}
