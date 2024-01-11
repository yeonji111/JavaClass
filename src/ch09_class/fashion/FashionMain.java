package ch09_class.fashion;

public class FashionMain {

    public static void main(String[] args) {
        Fashion haeseong = new Fashion();

        // 일반적인 메소드 사용
        haeseong.setName("해성");
        haeseong.setTopColor("베이지");
        haeseong.setBottomColor("파란색");
        System.out.println(haeseong);

        // 메소드 체이닝
        // 메소드의 리턴값이 객체 자신이라면 메소드를 줄줄이 이어서 사용할 수 있다.
        // 자바에서 자주 보이지는 않는다.
        // 자바스크립트에서 (jQuerry, Vue.js, React.js) 자주 보이는 형태
        haeseong.setName("해성")
                .setCapColor("빨간색")
                .setShoesColor("하얀색");



    }
}
