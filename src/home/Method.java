package home;

public class Method {
    public static void main(String[] args) {
        makeTree(5);

        System.out.println("\n=========================\n");

        makeTree(7);

        System.out.println("\n=========================\n");

        String example = "로꾸꺼 로꾸꺼";
        String result = reverseStr(example);
        System.out.println(result);

        System.out.println("\n=========================\n");

        String myBinaryStr = makeBinary(23);
        System.out.println(myBinaryStr);

    }

    public static void makeTree(int n) {
        // i가 0일때 별 1, 공백 4 -- 별 2*i +1 // 공백 4-i
        // i가 1일때 별 3, 공백 3
        // i가 2일때 별 5, 공백 2
        // i가 3일때 별 7, 공백 1
        // i가 4일때 별 9, 공백 0
        String tree = "";
        for(int i = 0; i < n; i++){
            String emp = "";
            String star = "";
            for(int j = 0; j < 4-i; j++){
                emp += " ";
            } for(int k = 0; k < 2*i+1; k++){
                star += "*";
            }
            System.out.println(emp+star);
        }
    }

    public static String reverseStr(String example){
        String result = "";
        for(int i = example.length()-1; i >= 0; i--){
            result += example.charAt(i);
        }
        return result;
    }


    public static String makeBinary(int n){
        String result = "";

        // 이진수 계산 방법
        while (n != 1) {
            result += n % 2;
            n /= 2;
        }
        result += "1";

        String fin = "";
        for(int i = result.length()-1; i >= 0; i--){
            fin += result.charAt(i);
        }
        return fin;


    }

}


