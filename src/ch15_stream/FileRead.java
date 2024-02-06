package ch15_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        // FileReader는 굳이 File 객체를 생성하지 않아도 된다.
        try(FileReader reader = new FileReader(path + "\\src\\ch15_stream\\CopyFile.java")) {

            // 데이터를 옮길 그릇 생성, char 타입 (=>byte타입과 달리 문자가 깨지지 않음)
            char[] word = new char[1];

            while(true){
                int cnt = reader.read(word);

                if (cnt == -1){
                    break;
                }

                // char[] -> String 변환
                String text = new String(word);
                System.out.println(text);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
