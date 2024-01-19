package ch10_extends_interface.simple;

public class Parent {
    private String name;
    private int age;

    public Parent() {

    }

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void hello(){
        System.out.println("안녕하세요. 어른입니다.");
    }

    public void work(){
        System.out.println("힘들게 일하는중..");
    }




//    @Override
//    public String toString() {
//        return "Parent{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
