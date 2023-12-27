package yeonji.submit03;

public class Submit02 {
    public static void main(String[] args) {
        String findWally = "윌리울리일리울리울리일리월리일리윌리월리울리일리일리월리일리윌리일리윌리일리월리월리윌리울리윌리울리일리울리울리윌리일리";
        int count = 0;
        for (int i = 0; i < findWally.length(); i+= 2){ // 투 스텝씩 밟게 하고 싶은데 .. i++ 이라 하나씩 함
            String Wally = findWally.substring(i,i+2); //  두 글자씩 자르기
            if(Wally.equals("월리")){
                count++;
            }
        }
        System.out.println(count);
    }
}
