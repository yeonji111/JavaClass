package ch09_class.typing;

import ch09_class.common.Constants;

import java.util.ArrayList;

public class Dictionary {
    
    // 타자게임에 필요한 단어 목록을 만들어서 리턴해주는 메소드
    // type = 1 : 한글
    // type = 2 : 영어

    /**
     * type = 1 : 한글
     * type = 2 : 영어
     * @return result
     */
    public static ArrayList<String> makeWordList(int type){
        ArrayList<String> result = new ArrayList<>();


        if(type == Constants.DICTIONARY_TYPE_HANGUL){
            result.add("김태완");
            result.add("이건희");
            result.add("유정현");
            result.add("이용석");
            result.add("안승환");
            result.add("정의철");
            result.add("김미승");
            result.add("강성구");
            result.add("주형구");
            result.add("정회환");
            result.add("박연지");
            result.add("신해성");
            result.add("박유나");
            result.add("이창훈");
        } else if (type == Constants.DICITONARY_TYPE_ENGLISH) {
            result.add("public");
            result.add("private");
            result.add("constructor");
            result.add("forEach");
            result.add("method");
            result.add("Scanner");
            result.add("field");
            result.add("Overloading");

        }


        return result;
    }


    
    
    
    
}
