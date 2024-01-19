package ch10_extends_interface.mysort;

public interface MyComparator<T> {

    // MyComparator를 생성할 때, MyComparator<T>의
    // T 안에 입력된 객체의 타입이 메소드의 파라미터 T에 적용된다.
    boolean myCompare(T left, T right);


}
