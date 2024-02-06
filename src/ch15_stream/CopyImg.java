package ch15_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyImg {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        // 텍스트(문자열) 특화 Reader와 Writer로 이미지, 음악 파일을
        // 처리하는데 어려움이 있다.
        try(FileReader reader = new FileReader(path + "\\src\\files\\tangerines.jpg");
            FileWriter writer = new FileWriter(path + "\\src\\files\\건희\\tangerines2.jpg")){

            char[] word = new char[1];

            while(true){
                int cnt = reader.read(word);

                if (cnt == -1){
                    break;
                }

                // char[] -> String 변환
              writer.write(word);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
