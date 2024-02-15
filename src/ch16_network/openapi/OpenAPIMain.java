package ch16_network.openapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class OpenAPIMain {

    public static void main(String[] args) throws IOException, ParseException {
        // 요청 URL 생성
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("WOX88LV9CJfxoI/Q6nDfxyNOTVxAyhC3xfcuWdBbKkzKkbPrriTVsfPSJDyI5pCaXEY/pT+RCCgY2jW99Pm1ww==")); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/

        // 위에서 만든 URL 주소(문자열)에 해당하는 URL 객체 생성
        URL url = new URL(urlBuilder.toString());

        // URL 주소에 대한 연결
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 연결 요청 방식 (GET,POST)
        conn.setRequestMethod("GET");
        // 연결 요청 시 데이터 타입 (json 으로 설정)
        conn.setRequestProperty("Content-type", "application/json");

        // URL 에 대한 OpenAPI 서버의 응답
        System.out.println("Response code: " + conn.getResponseCode());


        // 데이터 읽어올 객체 생성
        BufferedReader rd;
        // 응답코드가 200~300 사이면 정상적으로 응답이 온 경우
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
           // Reader에 응답 데이터 담음
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        // rd.readLine()이 실행될때마다
        // rd 에 기록된 데이터에서 한줄씩 (\n기준)
        // line에 담긴다.(더이상 담을게 없다면 null값 담김)
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // JSON String을 JSON 객체로 파싱
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(sb.toString());

        System.out.println(json);

        JSONObject body = (JSONObject) json.get("body");

        System.out.println(body);

        JSONArray items = (JSONArray) body.get("items");
        System.out.println(items.size());

        // 로컬에 저장하기
        String path = System.getProperty("user.dir");
        try(FileWriter writer = new FileWriter(path + "\\src\\files\\mediData.txt")){

            writer.write(items.toString());

        }



        // efcyQesitm = 증상들이 쓰여있음
        // 100개의 약들에 대해 증상들을 수집
        // 위산과다, 속쓰림, 위부불쾌감, 위부팽만감, 체함, 구역,
        // 위산과다, 속쓰림, 위부불쾌감, 위통, 신트림

        // 여러 증상들의 배열 얻기
        // [위산과다, 속쓰림, 위부불쾌감, 위부팽만감, 위통, 체함, 구역, 신트림]


        // depositMethodQesitm(보관방법), useMethodQesitm(사용방법) , itemName(약품명), entpNamem(회사명), efcyQesitm(증상), itemSeq(기본키)
    }

    // 페이지에 대한 약품 목록을 가져오는 메소드
    public static JSONArray getMediList(int page) throws Exception {

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("WOX88LV9CJfxoI/Q6nDfxyNOTVxAyhC3xfcuWdBbKkzKkbPrriTVsfPSJDyI5pCaXEY/pT+RCCgY2jW99Pm1ww==")); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(page + "", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/

        // 위에서 만든 URL 주소(문자열)에 해당하는 URL 객체 생성
        URL url = new URL(urlBuilder.toString());

        // URL 주소에 대한 연결
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        // 연결 요청 방식 (GET,POST)
        conn.setRequestMethod("GET");
        // 연결 요청 시 데이터 타입 (json 으로 설정)
        conn.setRequestProperty("Content-type", "application/json");

        // URL 에 대한 OpenAPI 서버의 응답
        System.out.println("Response code: " + conn.getResponseCode());


        // 데이터 읽어올 객체 생성
        BufferedReader rd;
        // 응답코드가 200~300 사이면 정상적으로 응답이 온 경우
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            // Reader에 응답 데이터 담음
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        StringBuilder sb = new StringBuilder();
        String line;
        // rd.readLine()이 실행될때마다
        // rd 에 기록된 데이터에서 한줄씩 (\n기준)
        // line에 담긴다.(더이상 담을게 없다면 null값 담김)
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        // JSON String을 JSON 객체로 파싱
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(sb.toString());

        System.out.println(json);

        JSONObject body = (JSONObject) json.get("body");

        System.out.println(body);

        JSONArray items = (JSONArray) body.get("items");

        return items;
    }
}
