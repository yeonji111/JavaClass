package yeonji.submit03;

public class Submit01 {
    public static void main(String[] args) {
        int num = 10;

        int factorial = 1;
        for (int i = num; i > 0; i--){
            factorial = factorial * i;
        }
        System.out.println(factorial);

        System.out.println("\n=================\n");
        num = 15;

        long factorialTwo = 1l;
        for (int i = num; i > 0; i--){
            factorialTwo = factorialTwo * i;
        }
        System.out.println(factorialTwo);

    }
}

