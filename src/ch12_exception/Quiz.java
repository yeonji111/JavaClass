package ch12_exception;

public class Quiz {
    /* try~catc~finally 의 실행 순서를 맞춰보는 문제 */

    public static void main(String[] args) {
        try {
            qMethod(-1);
            System.out.println("B");
        } catch (Exception e) {
            System.out.println("C");
        }finally {
            System.out.println("D");
        }
        System.out.println("E");
    }

   public static void qMethod(int no) throws Exception {
        if(no < 0){
            throw new Exception();
        }
        System.out.println("A"); // Exception으로 던진 후 println은 실행되지 않음!
    }
}
