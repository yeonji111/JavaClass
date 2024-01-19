package ch10_extends_interface.simple;

// Child는 Parent를 상속받는 클래스
// 클래스 이름 옆에 extends Parent 을 붙여준다.
public class Child extends Parent{

    private String school;

    public Child() {
    }


    public Child(String name, int age,String school) {
        // super는 부모 객체를 의미
        // super()는 부모의 생성자
        super(name, age); // 부모의 생성자를 앞에
        this.school = school; // 자식 생성자는 뒤에
    }


    // Parent에서 만든 hello 메소드를 오버라이딩하기
    // 메소드명 입력 후 자동완성 이용

    @Override
    public void hello() {
        System.out.println("안녕하세요. 어린이입니다.");
    }



    // Override는 부모가 가진 메소드를 자식 클래스에서 재정의(수정)
    // 하는 것을 의미한다.
    // 모든 클래스는 보이지는 않지만 기본적으로 Object 클래스를
    // 상속받고 있다.
    // toString 메소드는 Object 클래스에 정의되어 있는 메소드




    @Override
    public String toString() {
        // super를 이용하여 부모 객체의 필드변수에 접근
        return "Child{name=" + super.getName()
                + ",age =" + super.getAge()
                + ", school=" + this.school + "}";
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
