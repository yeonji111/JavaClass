package yeonji.submit05;

public class Submit02 {
    public static void main(String[] args) {

        String example = "로꾸꺼 로꾸꺼";
        String result = reverseStr(example);
        System.out.println(result);

    }

    public static String reverseStr(String example){
        String reverse = "";
        for(int i = example.length(); i > 0; i--){

            reverse += example.substring(i-1,i);

        }
//        System.out.println(reverse);
        return reverse;
    }


}
