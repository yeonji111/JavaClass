package yeonji.submit06;

/*
한국 배우들의 명단을 배열로 만들어보았습니다.
for문을 이용하여 "이"씨 성을 가진 사람이 몇명인지 출력해주세요.


String[] nameList = {"이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민", "최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬"};

 */

public class Submit01 {
    public static void main(String[] args) {
        String[] nameList = {"이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석", "황정민", "박소담", "이선균", "이성민", "최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬"};
        int count = 0;
        for (int i = 0; i < nameList.length; i++){
         if (( nameList[i].substring(0,1)).equals("이"))
            count += 1;

        }
        System.out.println("이씨 성을 가진 배우가 총 " +count+"명 있습니다.");



    }
}
