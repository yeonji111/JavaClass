package home;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*

    1. 7개 도시 중 가장 냉면 값이 저렴한 도시와 그 가격을 찾아 출력하기
    2. 7개 도시의 자장면 평균 가격을 계산하여 출력하기

* */
public class OpenApi {
    public static void main(String[] args) throws ParseException {

        String response = "{ \"city\" : [\"서울\", \"광주\", \"대구\", \"대전\", \"부산\", \"울산\", \"인천\"], \"fields\": [{\"id\": \"자장면\"},{\"id\": \"냉면\"}, {\"id\": \"김밥\"}, {\"id\": \"칼국수\"}], \"records\": [{\"시도명\": \"서울\", \"자장면\": 7069, \"냉면\": 11308, \"김밥\": 3215, \"칼국수\": 8962}, {\"시도명\": \"광주\", \"자장면\": 6800, \"냉면\": 9400, \"김밥\": 3160, \"칼국수\": 8400}, {\"시도명\": \"대구\", \"자장면\": 6250, \"냉면\": 10417, \"김밥\": 2750, \"칼국수\": 6750}, { \"시도명\": \"대전\", \"자장면\": 6700, \"냉면\": 10400, \"김밥\": 3000, \"칼국수\": 7800}, {\"시도명\": \"부산\", \"자장면\": 6143, \"냉면\": 10857, \"김밥\": 2786, \"칼국수\": 6986}, { \"시도명\": \"울산\", \"자장면\": 6500, \"냉면\": 9900, \"김밥\": 3300, \"칼국수\": 8400}, {\"시도명\": \"인천\", \"자장면\": 6500, \"냉면\": 10667, \"김밥\": 3050, \"칼국수\": 8000}]}";


        // 문자열 -> Json으로 파싱하기
        JSONParser parser = new JSONParser();
        parser.parse(response);
        JSONObject obj = (JSONObject)parser.parse(response);
        System.out.println(obj);

        // 파싱한 단순 json 덩어리를 json array로 예쁘게 담기
        JSONArray array = (JSONArray) obj.get("records");
        System.out.println(array);

        // 최소값을 높게 주고, 빈 문자열 도시를 만들어둔다.
        int min = 100000;
        String city = "";

        // 반복문을 통해 jsonArray를 모두 순회하면서
       for (int i = 0; i < array.size(); i++){

           // array의 각 인덱스에 접근한다.
           JSONObject record = (JSONObject) array.get(i);
           System.out.println(record);

           // 각 인덱스의 "냉면"값에 접근하고
           int price = ((Long) record.get("냉면")).intValue();

           // 일부러 높게 설정해둔 min보다 냉면의 값이 적은 경우 덮어쓰기를 사용한다
           // 버블정렬과 비슷한 원리
           // 해당 가격에 덮어쓰기할때, 빈 문자열로 선언해둔 도시명도 시도명이 덮어쓰기한다.
           if(price < min){
               min = price;
               city = record.get("시도명").toString();
           }

       }
        System.out.println("냉면의 최종 가격: " + min +"\n 냉면이 제일 저렴한 도시: " + city);




       int total = 0;
       int avg = 0;

       for (int i = 0; i < array.size(); i++){
           JSONObject record = (JSONObject) array.get(i);
           System.out.println(record);
           // 자장면 꺼내서 해당 value값인 가격을 모두 더한다.
           total += ((Long)record.get("자장면")).intValue();
       }
        // 자장면의 값을 모두 더한 것을 array.size만큼 나누고 해당 값을 avg에 덮어쓴다.
        avg = total/ array.size();

        System.out.println(array.size()+"개 도시 자장면 평균 가격: " + avg + "원");

    }
}
