package home;

public class Array {
    public static void main(String[] args) {

        String[] nameList = {"이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민", "최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬"};

        int cnt = 0;
        for (int i = 0; i < nameList.length; i++) {
            if (nameList[i].substring(0, 1).equals("이")) {
                cnt++;
            }
        }
        System.out.println("이씨 성을 가진 배우가 총 " + cnt + "명 있습니다.");


        System.out.println("\n====================\n");
        int[] intArr = {23, 456, 213, 32, 464, 1, 2, 4};
        int max = 0;

        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] >= max) {
                max = intArr[i];

            }
        }
        System.out.println("최댓값: " + max);
        for(int i = 0; i < intArr.length; i++){
            if(intArr[i] <= max){
                max = intArr[i];
            }
        }
        System.out.println("최솟값: " + max);


        System.out.println("\n====================\n");
        int[] myLotto = makeLotto(6);
        for(int i = 0; i < myLotto.length; i++){
            System.out.print(myLotto[i] + " ");
        }





    } public static int[] makeLotto(int n){

        int[] lottoNum = new int [6];
        for(int i = 0; i < 6; i++){
            int ran = (int) ((Math.random() * 45) + 1);
            lottoNum[i] = ran;

            for(int j = 0; j < i; j++){
                if(lottoNum[j] == ran){
                    i--;
                }
            }

        }

        return lottoNum;
    }
}
