package yeonji.submit14;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Collections;


public class Json {
    public static void main(String[] args) throws ParseException {

        String response = "{ \"city\" : [\"서울\", \"광주\", \"대구\", \"대전\", \"부산\", \"울산\", \"인천\"], \"fields\": [{\"id\": \"자장면\"},{\"id\": \"냉면\"}, {\"id\": \"김밥\"}, {\"id\": \"칼국수\"}], \"records\": [{\"시도명\": \"서울\", \"자장면\": 7069, \"냉면\": 11308, \"김밥\": 3215, \"칼국수\": 8962}, {\"시도명\": \"광주\", \"자장면\": 6800, \"냉면\": 9400, \"김밥\": 3160, \"칼국수\": 8400}, {\"시도명\": \"대구\", \"자장면\": 6250, \"냉면\": 10417, \"김밥\": 2750, \"칼국수\": 6750}, { \"시도명\": \"대전\", \"자장면\": 6700, \"냉면\": 10400, \"김밥\": 3000, \"칼국수\": 7800}, {\"시도명\": \"부산\", \"자장면\": 6143, \"냉면\": 10857, \"김밥\": 2786, \"칼국수\": 6986}, { \"시도명\": \"울산\", \"자장면\": 6500, \"냉면\": 9900, \"김밥\": 3300, \"칼국수\": 8400}, {\"시도명\": \"인천\", \"자장면\": 6500, \"냉면\": 10667, \"김밥\": 3050, \"칼국수\": 8000}]}";

        // 1. 7개 도시 중 가장 냉면 값이 저렴한 도시와 그 가격을 찾아 출력


        JSONParser json = new JSONParser();

        // String 타입인 response를 JSONObject 덩어리로 포장하기
        JSONObject item = (JSONObject) json.parse(response);

        // JSONObject인 item에서 배열형태인 "records"를 JSONArray 타입으로 꺼내기
        JSONArray records = (JSONArray)item.get("records");


        System.out.println(records);
        System.out.println(records.size());

        int min = 100000;


        for (int i = 0; i < records.size(); i++) {
            JSONObject record = (JSONObject) records.get(i);
            System.out.println(record);

            // key 가 "냉면" 인 value 값을 꺼내려하는데 , 해당 값이 int가 아닌 long타입임 (에러메세지를 보고 알 수 있음)
            // 따라서 long 타입인 냉면의 value를 int 타입으로 강제 형변환하여 꺼냄
            int price = ((Long) record.get("냉면")).intValue();
            System.out.println(price);


            // for문이 돌면서 더 싼 가격이 min 에 덮어쓰기 되므로 최종적으로 남는 min 은 최저가임
            if(min > price){
                min = price;
            }
        }

        System.out.println(min);

        for(int i = 0; i < records.size(); i++){
            JSONObject record = (JSONObject)records.get(i);

            int price = ((Long) record.get("냉면")).intValue();

            // 최저가로 뽑은 가격과 동일한 가격값을 가진 도시명 뽑기
            if(price == min){
                String city = (String) record.get("시도명");

                System.out.println(city + ": " + price);
            }
        }


        System.out.println("\n===========================\n");

        // 자장면 평균 가격
        int total = 0;

        for (int i = 0; i < records.size(); i++){
            JSONObject record = (JSONObject)records.get(i);

            int price = ((Long) record.get("자장면")).intValue();
            total += price;
        }
            int avg = total / records.size();
            System.out.println("자장면 평균 가격: " + avg);
    }


}


// 2. 7개 도시의 자장면 평균 가격을 계산







