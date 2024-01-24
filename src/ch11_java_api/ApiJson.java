package ch11_java_api;

import ch09_class.school.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class ApiJson {
    public static void main(String[] args) throws ParseException {
        // JSON 객체
        // Javascript Object Notation
        // = 자바스크립트에서의 객체

        // 자바에서의 객체
        // Student -> name, kor. eng, math, avg
        Student hodong = new Student("호동이", 98, 80, 80);
        System.out.println(hodong);

        // JSON 이라면
        // let hodong = { name : "호동이" , kor : 98, eng : 80, math : 80 }

        // 자바 hodong.getName()
        // JSON hodong.name

        // 클라이언트와 서버 간 데이터 통신 시
        // 자바에서 JSON 객체를 사용해야하는 경우가 존재

        // 응답데이터로 JSON String 전달
        // 자바에서 JSON 객체를 생성하고, JSON String으로 변환
        // JSON String -> "{ name : "호동이" , kor : 98, eng : 80, math : 80 }"
        // 요청데이터로 넘어온 JSON String 사용
        // 자바에서 JSON String을 JSON 객체로 변환

        // 단순히 JDK 안에 포함되어있는 라이브러리(클래스 파일들) 로는 불가능
        // 외부 라이브러리를 가지고 와야 사용할 수 있다.

        // 구글에 maven repository 검색 -> 사이트 접속
        // json simple 검색 -> 1.1.1 버전 선택
        // -> Files에서 View All 선택 후 .jar 파일 다운로드

        // 다운로드 받은 .jar 파일을 프로젝트 내부에서 사용할 수 있게하기
        // 프로젝트 내부에 폴더를 하나 생성해서 그 안에 .jar 파일 옮기기

        // Menu - Project Structure - Libraries 에서 해당 파일 추가
        JSONObject jsonObject = new JSONObject();
        System.out.println(jsonObject);

        // JSON 객체는 내부에 Key와 Value 쌍으로 구성된 데이터를 가진다.
        // Key값은 String 타입, Value는 아무 타입 다 가능한 형태
        // 자바의 Map<String, Object>와 유사하다.

        // 데이터 추가
        jsonObject.put("name", "아이유");
        System.out.println(jsonObject);
        jsonObject.put("age", "32");
        System.out.println(jsonObject);

        // 데이터 수정
        jsonObject.put("age", 31);
        System.out.println(jsonObject);

        // Value에 배열(JSONArray) 넣기
        // ArrayList와 사용법이 같음
        JSONArray jsonArray = new JSONArray();
        System.out.println(jsonArray);

        // JSONArray에 값 추가
        jsonArray.add("블루밍");
        jsonArray.add("밤편지");
        jsonArray.add("팔레트");
        jsonArray.add(100); // JSONArray 또한 타입에 자유롭다.
        System.out.println(jsonArray);

        jsonObject.put("songList", jsonArray);

        System.out.println(jsonObject); // Map과 마찬가지로 유의미한 순서가 없다.

        System.out.println(jsonObject.toString()); // JSON String 리턴
        System.out.println(jsonObject.toJSONString()); // JSON String 리턴

        // Value에 JSON 객체 추가
        JSONObject mellomangs = new JSONObject();
        mellomangs.put("name", "멜로망스");
        mellomangs.put("age", 33);

        JSONArray songs = new JSONArray();
        songs.add("선물");
        songs.add("좋은날");

        mellomangs.put("songs", songs);
        System.out.println(mellomangs);

        jsonObject.put("friend", mellomangs);
        System.out.println(jsonObject);

        // Key에 대한 Value 꺼내기
        System.out.println(jsonObject.get("name"));
        // 값을 꺼낼 시, Object 타입으로 리턴됨
        String name = (String) jsonObject.get("name");
//        Object name = jsonObject.get("name");
        System.out.println(name);

        int age = (int) jsonObject.get("age");
        System.out.println(age);

        JSONArray iuSongs = (JSONArray) jsonObject.get("songList");
        System.out.println(iuSongs);

        for (int i = 0; i < iuSongs.size(); i++) {
            System.out.println(iuSongs.get(i));
        }

        System.out.println(jsonObject.get("frie"));

        JSONObject friend = (JSONObject) jsonObject.get("friend");
        System.out.println(friend);

        String mello = (String) friend.get("name");
        System.out.println(mello);

        System.out.println("\n===================================\n");

        // 서버로부터 JSON String을 받은 경우
        String serverData = "{\"name\":\"아이유\",\"friend\":{\"songs\":[\"선물\",\"좋은날\"],\"name\":\"멜로망스\",\"age\":33},\"songList\":[\"블루밍\",\"밤편지\",\"팔레트\",100],\"age\":31}";
        // JSON Parser Online으로 검색하면 가독성 좋게 구분해주는 사이트가 있음

        System.out.println(serverData);

        // JSON String 을 JSON 객체로 변환해야 Key 값을 이용하여
        // Value를 꺼낼 수 있다.
        // JSON String -> JSONObject 변환을 위해 JSONParser 객체 생성
        JSONParser jsonParser = new JSONParser();

        JSONObject jsonData = (JSONObject) jsonParser.parse(serverData);

        System.out.println(jsonData.get("name"));

        System.out.println("\n========JSON 객체 내 선물 꺼내기=======\n");
        System.out.println(jsonData.get("friend"));

        JSONObject friendData = (JSONObject) jsonData.get("friend");

        JSONArray friendArray = (JSONArray) friendData.get("songs");

        System.out.println(friendArray.get(0));


        System.out.println("\n===============================\n");

        // GSON 라이브러리 사용
        // 얘도 maven repository 사이트에서 다운로드

        // GSON 라이브러리의 JSON 객체
        // JSONObject 객체
        JsonObject gsonObject = new JsonObject();
        System.out.println(gsonObject);

        // 값 추가
        gsonObject.addProperty("name", "아이유");
        gsonObject.addProperty("age", 31);
        System.out.println(gsonObject.toString());

        // 1. Gson 객체 생성
        Gson gson = new Gson();

        // 2. GsonBuilder로 Gson 객체 생성
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson2 = gsonBuilder.create(); //  위와 같음 (1번)
        Gson gson3 = gsonBuilder.setPrettyPrinting().create(); // 설정이 추가된 Gson 객체가 생성됨

        // JSON String 얻기
        String gsonString = gsonObject.toString();
        System.out.println(gsonString);

        String gsontString2 = gson.toJson(gsonObject);
        System.out.println(gsontString2);

        String gsonString3 = gson3.toJson(gsonObject);
        System.out.println(gsonString3);

        System.out.println("\n======================\n");

        // 위에 까지는 JSON simple 라이브러리와 별 차이 없다.
        Student hobbang = new Student("호빵맨", 98, 63, 50);

        // let hobbang = { name:"호빵맨", kor:98, eng:63, math:50}
        // { "name":"호빵맨", "kor":98, "eng":63, "math":50 }


        // gson을 이용하여 자바 객체를 JSON String으로 변환 !!
        // = 직렬화 (Serialization)
        String strHobbang = gson.toJson(hobbang);
        System.out.println(strHobbang);

        // 자바의 배열을 Json String으로 변환
        String[] sutArray = {"호빵맨", "찐빵맨", "식빵맨"};
        String strArrray = gson.toJson(sutArray);
        System.out.println(strArrray);

        // 자바의 ArrayList를 Json String으로 변환
        ArrayList<String> stuList = new ArrayList<>();
        stuList.add("호동이");
        stuList.add("호랑이");
        stuList.add("호돌이");
        String strList = gson.toJson(stuList);
        System.out.println(strList);

        // ArrayList 안에 객체가 들어있어도 무리없이 변환 가능 !!
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("호빵이", 80, 90, 40));
        students.add(new Student("식빵이", 63, 83, 93));
        students.add(new Student("밤빵이", 60, 94, 59));
        String strStu = gson.toJson(students);
        System.out.println(strStu);

        // Json String에 대해 Student 객체로 변환 가능 !!
        // = 역직렬화 (Deserialization)
        // 역질렬화를 위해 스프링 프레임워크에서 Gson 라이브러리 및
        // jackson 라이브러리를 이용하는 경우가 많다.

        System.out.println(strHobbang);
        Student hobbangStu = gson.fromJson(strHobbang, Student.class);
        System.out.println(hobbangStu); // String 타입이었던 strHobbang을 Student 객체로 바꾼 후,
        System.out.println(hobbangStu.getName()); // .getName(), .getMath()으로 꺼내기 가능
        System.out.println(hobbangStu.getMath());


        System.out.println("\n============= 연습 문제 ==============\n");

        /* 2020년 8월 2일의 한국 환율(KRW) 값을 꺼내보세요.
         * 1193.46 이 출력되면 됨! */

        String resp = "{\"success\": true, \"timeseries\": true, \"base\": \"USD\", \"start_date\": \"2020-08-01\", \"end_date\": \"2022-08-01\", \"rates\": {\"2020-08-01\": {\"JPY\": 105.65, \"KES\": 107.57, \"KGS\": 76.52, \"KHR\": 4092.64, \"KMF\": 417.5, \"KPW\": 898.38, \"KRW\": 1192.25}, \"2020-08-02\": {\"JPY\": 105.74, \"KES\": 107.69, \"KGS\": 76.62, \"KHR\": 4100, \"KMF\": 418.06, \"KPW\": 899.58, \"KRW\": 1193.46}}}";
        // JSON Parser Online으로 검색하면 가독성 좋게 구분해주는 사이트가 있음
//        System.out.println(resp);

        // JSON String 을 JSON 객체로 변환해야 Key 값을 이용하여
        // Value를 꺼낼 수 있다.
        // JSON String -> JSONObject 변환을 위해 JSONParser 객체 생성
        JSONParser respParser = new JSONParser();
        JSONObject jsonResp = (JSONObject) respParser.parse(resp);

        JSONObject jsonRates = (JSONObject) jsonResp.get("rates");
//        System.out.println(jsonRates);

        JSONObject jsonDate = (JSONObject) jsonRates.get("2020-08-02");
//        System.out.println(jsonDate);
        System.out.println(jsonDate.get("KRW"));

    }
}
