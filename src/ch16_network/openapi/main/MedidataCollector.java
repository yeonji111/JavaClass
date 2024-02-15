package ch16_network.openapi.main;

import ch16_network.openapi.dto.MedidataDTO;
import ch16_network.openapi.service.MedidataService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class MedidataCollector {

    public static void main(String[] args) {

     MedidataService mediService = MedidataService.getInstance();

        try {
            ArrayList<MedidataDTO> mediList = new ArrayList<>();
            for(int p = 1; p <= 47; p++){
                mediList.addAll(getMediList(p));
            }

            // 4690개 확보
            System.out.println(mediList.size());

            for(int i = 0; i < mediList.size(); i++){
                mediService.inputMedidata(mediList.get(i));
            }

            System.out.println("데이터 스틸 끝");



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }





    // 약품 꺼내오는 메소드
    static ArrayList<MedidataDTO> getMediList(int pageNo) throws IOException, ParseException {
        // 요청 url 생성
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("WOX88LV9CJfxoI/Q6nDfxyNOTVxAyhC3xfcuWdBbKkzKkbPrriTVsfPSJDyI5pCaXEY/pT+RCCgY2jW99Pm1ww==")); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode(pageNo + "", "UTF-8")); /*페이지번호*/
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


        ArrayList<MedidataDTO> result = new ArrayList<>();

        for(int i = 0; i < items.size(); i++){
            JSONObject medi = (JSONObject) items.get(i);

            String strItemSeq = (String)medi.get("itemSeq");
            int itemSeq = Integer.parseInt(strItemSeq);

            String itemName = (String)medi.get("itemName");
            String entpName = (String)medi.get("entpName");
            String efcyQesitm = (String)medi.get("efcyQesitm");
            String useMethodQesitm = (String)medi.get("useMethodQesitm");

            MedidataDTO medidata = new MedidataDTO(itemSeq, itemName, entpName, efcyQesitm, useMethodQesitm);

            result.add(medidata);

        }


        return result;
    }


}
