package yeonji.submit05;

public class Submit01 {
    public static void main(String[] args) {
    makeTree(5);
    makeTree(7);
}

    public static void makeTree(int n) {
        int floor = n;
        for (int i = 0; i < floor; i++) {
            String blank = "";
            for (int j = 0; j < (floor - i); j++) {
                blank += " ";
            }

            String starTest = "";
            for (int j = 0; j < (i + (i + 1)); j++) {
                starTest += "*";
            }
            System.out.println(blank + starTest);
        }
    }
}
