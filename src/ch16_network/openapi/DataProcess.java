package ch16_network.openapi;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 로컬에 저장한 데이터 실행하는 클래스 */
public class DataProcess {
        public static void main(String[] args) throws ParseException {
                String path = System.getProperty("user.dir");

                StringBuilder sb = new StringBuilder();

            try(FileReader reader = new FileReader(path + "\\src\\files\\mediData.txt")){
                char[] word = new char[1];

                while (true){
                    int cnt = reader.read(word);

                    if (cnt == -1){
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
            JSONArray items = (JSONArray)parser.parse(sb.toString());

            System.out.println(items.size());
            System.out.println(items.get(3));


            // items 로
            // efcyQesitm = 증상들이 쓰여있음
            // 100개의 약들에 대해 증상들을 수집
            // 위산과다, 속쓰림, 위부불쾌감, 위부팽만감, 체함, 구역,
            // 위산과다, 속쓰림, 위부불쾌감, 위통, 신트림

            // 여러 증상들의 배열 얻기
            // [위산과다, 속쓰림, 위부불쾌감, 위부팽만감, 위통, 체함, 구역, 신트림]


        }
}
