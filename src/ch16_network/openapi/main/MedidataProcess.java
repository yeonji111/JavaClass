package ch16_network.openapi.main;

import ch16_network.openapi.dto.MedidataDTO;
import ch16_network.openapi.service.MedidataService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MedidataProcess {

    public static void main(String[] args) {
        MedidataService mediService = MedidataService.getInstance();

        mediService.getMedidataList();

        ArrayList<MedidataDTO> mediList = mediService.getMedidataList();

        System.out.println(mediList.size());
        System.out.println(mediList.get(23));


        ArrayList<String> efcyList = new ArrayList<>();

        for (int i = 0; i < mediList.size(); i++) {
            String target = mediList.get(i).getEfcyQesitm();

            if (target != null) {
                target = target.replace("이 약은 ", "");
//                target = target.replace("이 약은 ", "");
                target = target.replace("에 사용합니다.", "");
                target = target.replaceAll("\\(.*\\)", "");
                System.out.println(target);

                String[] efcyArray = target.split(", ");

                for (int k = 0; k < efcyArray.length; k++) {
                    efcyList.add(efcyArray[k]);
                    //efcyList.addAll(Arrays.asList(efcyArray)); 와 동일하지만 윗 코드가 눈에 더 익어서 사용하지 않았음

                }

            }

        }

        System.out.println(efcyList.size());

        // 각 증상별로 몇개씩 중복되는지 확인하기
        // 감기 -> 30
        // 두통 -> 52
        // 치통 -> 24

        // HashMap에 각 증상(key) = 0(value) 의 형태로 담기
        // 감기 = 0
        // 두통 = 0
        // 치통 = 0

        HashMap<String, Integer> efcyMap = new HashMap<>();


        // 모든 증상을 담은 efcyList를 for문으로 반복하면서
        // 중복되는 증상 제거 후 Key로 지정하고 값을 0으로 초기화해둠
        for(int i = 0; i < efcyList.size(); i++){
            efcyMap.put(efcyList.get(i), 0);

        }

        // 중복제거하고 난 후의 증상의 총 갯수는 2025
        System.out.println(efcyMap.size());


        // 중복 제거된 증상들에 값으로 efcyList와 efcyMap의 키가 동일할 경우 값을 1씩 증가해주기
        for(int i = 0; i < efcyList.size(); i++){

            int cnt = efcyMap.get(efcyList.get(i));

            efcyMap.put(efcyList.get(i), cnt + 1);

        }
        System.out.println(efcyMap);

        // 상위 증상 10개 뽑기

        // 내 버전)
        // entrySet으로 Map의 내부를 순회하면서 Value의 값에 접근해
        // 빈 배열에 담고
        // 빈 배열에 담긴 Value를 내림차순 정렬해서 10개 출력
        // 10개 출력된 Value와 세트인 Map의 Key를 꺼내서 같이 출력하기


        // 선생님 버전)
        // List로 만들어야겠다.
        // List에 담을 "감기=30" -> 객체로 바라본다.
        // 객체를 클래스로 정의내린다.

        ArrayList<MediCnt> mediCntList = new ArrayList<>();


        // Map 순회
        Set<String> keySet = efcyMap.keySet();
        for ( String key : keySet ){
            mediCntList.add(new MediCnt(key, efcyMap.get(key)));
        }

        System.out.println(mediCntList.size());
        System.out.println(mediCntList.get(10));


        System.out.println("\n=========== 상위 10개 확인 ==============\n");
        Collections.sort(mediCntList, (a, b) -> b.getCnt() - a.getCnt());

        for (int i = 0; i < 10; i++){
            System.out.println(mediCntList.get(i));
        }





    }
}
