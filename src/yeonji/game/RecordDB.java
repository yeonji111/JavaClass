package yeonji.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RecordDB {
    private HashMap<Object, Object> recordMap;
    // record 저장 메소드
    HashMap<Object, Object> rankMap = new HashMap<Object, Object>(recordMap);


    // record 내림차순 배열 메소드
    Set<Map.Entry<Object, Object>> entrySet = recordMap.entrySet();

for(
    Map.Entry<Object, Object> entry :entrySet)

    {
        System.out.println(entry.getValue());
    }


    // 배열한걸 바탕으로 랭킹 세우기 메소드

}
