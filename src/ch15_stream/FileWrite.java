package ch15_stream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        try (FileWriter writer = new FileWriter(path + "\\src\\files\\temp.txt",true)){
            // 존재하지 않는 temp.txt 파일을 생성함과 동시에 파일안에 내용 작성

            String message = "건희짱🙌";
            writer.write(message);

            // FileOutputStream과 FileWriter와 같이
            // 데이터를 전송하는 부분에서 스트림에 잔여 데이터가 남지 않고
            // 전부 보내지도록 하기 위해 flush() 사용
            // (= 데이터를 버퍼에 남기지 않음)
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
