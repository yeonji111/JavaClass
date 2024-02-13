package ch16_network.openapi;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/* 로컬에 저장한 데이터 실행하는 클래스 */
public class DataProcess {
    public static void main(String[] args) throws ParseException {
        String path = System.getProperty("user.dir");

        StringBuilder sb = new StringBuilder();

        try (FileReader reader = new FileReader(path + "\\src\\files\\mediData.txt")) {
            char[] word = new char[1];

            while (true) {
                int cnt = reader.read(word);

                if (cnt == -1) {
                    break;
                }

                String text = new String(word);
                sb.append(text);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sb);

        JSONParser parser = new JSONParser();
        JSONArray items = (JSONArray) parser.parse(sb.toString());

        System.out.println(items.size());
        System.out.println(items.get(3));


        System.out.println("\n================================\n");

        // items 로
        // efcyQesitm = 증상들이 쓰여있음
        // 100개의 약들에 대해 증상들을 수집
        // 위산과다, 속쓰림, 위부불쾌감, 위부팽만감, 체함, 구역,
        // 위산과다, 속쓰림, 위부불쾌감, 위통, 신트림

        // 여러 증상들의 배열 얻기
        // [위산과다, 속쓰림, 위부불쾌감, 위부팽만감, 위통, 체함, 구역, 신트림]

        // 증상들을 중복되지 않게 담기
        HashSet<String> efcySet = new HashSet<>();

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i) + "\n");
            JSONObject temp = (JSONObject) items.get(i);
            String efcy = (String) temp.get("efcyQesitm"); // 키 값에 있어서 대소문자 구분을 함
            System.out.println(efcy);

            if (efcy != null) {
                efcy = efcy.replace("이 약은 ", "");
                efcy = efcy.replace("에 사용합니다.", "");
                efcy = efcy.replace("\n", "");

                System.out.println(efcy);

                String[] efcyArray = efcy.split(", ");
                System.out.println(efcyArray[0]);

                for (int j = 0; j < efcyArray.length; j++) {
                    efcySet.add(efcyArray[j]);
                }
            }
        }
        ArrayList<String> efcyList = new ArrayList<>();
        efcyList.addAll(efcySet);

        for (int i = 0; i < efcyList.size(); i++) {
            System.out.println(efcyList.get(i));
        }

        System.out.println("\n===================================\n");
        // 인후통에 사용하는 약품 목록 보여주기
        for (int i = 0; i < items.size(); i++) {
            JSONObject item = (JSONObject) items.get(i);
            String efcy = (String) item.get("efcyQesitm");

            if (efcy != null && efcy.contains("감기")) {
                String itemName = (String) item.get("itemName");
                String entpName = (String) item.get("entpName");
                System.out.println(itemName);
                System.out.println(entpName);

            }


        }

    }
}
