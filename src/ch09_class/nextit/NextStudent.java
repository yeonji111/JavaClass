package ch09_class.nextit;

// 학생 객체들을 정의내리는 클래스
// 이름, 레벨, 경험치
public class NextStudent {
    // 필드변수(= 객체의 속성, 상태)
    String name;        /* 학생의 이름 */
    int level;          /* 학생의 레벨 */
    int exp;            /* 학생의 경험치 */


    // 기본 생성자
    // 클래스 내에 생성자를 별도로 만들지 않으면
    // 기본 생성자는 보이지 않더라도 존재한다.
    public NextStudent(){}


    // 파라미터를 입력받는 생성자 만들기
    // 생성자를 별도로 만들어 주었기 때문에,
    // 보이지 않지만 존재했던 기본 생성자가 사라짐
    public NextStudent(String name, int level, int exp) {
        // this는 현재 객체를 의미
        // 현재 객체의 필드변수에 생성자의 파라미터로 들어온 값 부여
        this.name = name;
        this.level = level;
        this.exp = exp;
    }

    // toString() 만들기
    // 단축키 [Alt + Insert] - toString() 클릭
    @Override
    public String toString() {

        return "이름: " + name +
                ", 레벨: " + level +
                ", 경험치: " + exp;
    }

    // 하루가 지남.. 에 대한 메소드 만들기
    public void afterOneDay() {
        // NextStudent 객체들은 afterOneDay가 실행되면
        // 경험치가 30 오르고, 이때 경험치가 100 이상이 되면 레벨업을 한다.
        exp += (int) (Math.random() * 31) + 10;

        if (exp >= 100) {
            level++;
            exp %= 100;
            System.out.println(name + " 레벨업!!" + (level - 1) + " -> " + level);
        }

        System.out.println(name + "의 경험치: " + exp);
    }


}
