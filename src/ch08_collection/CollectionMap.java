package ch08_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {

    public static void main(String[] args) {
        // Map -> HaspMap의 선언
        // Map은 데이터를 각각 Key와 Value의 한쌍으로 저장
        HashMap<String, String> stuMap = new HashMap<String, String>();
        HashMap<String, String> stuMap2 = new HashMap<>();

        // 다형성 이용
        // 어지간한 경우에 Key값의 타입은 String이다.
        Map<String, Integer> coinMap = new HashMap<>();

        // 값 추가
        // .put(Key,Value)
        stuMap.put("첫째", "성구");
        stuMap.put("둘째", "미승");
        stuMap.put("셋째", "의철");

        System.out.println(stuMap);

        // 중복된 키값을 허용하지 않는다.
        stuMap.put("첫째", "연지");
        System.out.println(stuMap); // 기존 키값의 데이터를 덮어씀

        coinMap.put("비트코인", 58000000);
        coinMap.put("도지코인", 102);
        System.out.println(coinMap);


        System.out.println("\n=======================\n");

        // Key값을 이용하여 Value값 꺼내기
        // .get(key 값)
        System.out.println(stuMap.get("둘째"));
        // 존재하지 않는 key값을 입력하면 null값 리턴
        System.out.println(stuMap.get("없는키값")); // null값을 출력

        System.out.println(coinMap.get("비트코인"));

        // .size()
        System.out.println(stuMap.size());
        System.out.println(coinMap.size());

        // .containsKey(값)
        // 괄호 안 값과 같은 Key값이 존재하면 true, 없으면 false 리턴
        System.out.println(stuMap.containsKey("둘째"));
        System.out.println(stuMap.containsKey("넷째"));
        // 위와 같음
        System.out.println(stuMap.get("둘째") != null);
        System.out.println(stuMap.get("넷째") != null);

        // .containsValue(값)
        // 괄호 안 값과 같은 Value값이 존재하면 true, 없으면 false
        System.out.println(stuMap.containsValue("미승"));

        // .remove(key값)
        // 해당 key값을 가지는 내부 요소를 삭제
        stuMap.remove("셋째");
        System.out.println(stuMap);

        System.out.println("\n=========== Map 순회 ==============\n");

        // Map 순회
        // 1. KeySet 이용
        // .keySet()
        // map 내부 요소들의 key값들만 Set에 담은 것
        Set<String> keySet = stuMap.keySet();
        System.out.println(keySet);

        for (String key : keySet){
            System.out.println(key); // 첫째, 둘째,... (키값 리턴)
            System.out.println(stuMap.get(key)); // 연지, 미승, ...(Value값 리턴)
        }

        // 2. EntrySet 이용
        Set<Entry<String,String>> entrySet = stuMap.entrySet();

        for (  Entry<String,String> entry : entrySet ){
            System.out.println(entry); // key값 = value값 출력
            System.out.println(entry.getKey()); // key값만 출력
            System.out.println(entry.getValue()); // value값만 출력F
        }








    }
}
