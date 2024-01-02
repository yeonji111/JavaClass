package yeonji.submit05;

public class Submit03 {
    public static void main(String[] args) {
        String myBinaryStr = makeBinary(23);
        System.out.println(myBinaryStr);
    }

    public static String makeBinary(int bin) {
        String myBinaryStr = "";
        int binary = bin;

        while(binary>0) {
            myBinaryStr =  binary%2+myBinaryStr;
            binary /=2;
        }

//        System.out.println(myBinaryStr);
        return myBinaryStr;
    }
}
