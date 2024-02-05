package ch15_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

// 출력 (= 자바 단에서 파일에 데이터 쓰기)
public class FileOutput {
    public static void main(String[] args) {
        // src\\files\\건희\\id.txt 에 내용 추가
        String path = System.getProperty("user.dir");

        File idFile = new File(path + "\\src\\files\\건희\\id.txt");
        // 확장자도 있어야 정상적으로 true 출력
        System.out.println(idFile.exists());

        // 파일 안에 내용을 작성하기 위한 OutputStream 객체 생성
        try(FileOutputStream fos = new FileOutputStream(idFile)) {

            // OutputStream 은 byte 단위로 데이터를 전송하므로
            // 데이터가 byte 단위여야 한다.
            // a001 을 전송하고자 한다면

            // 1. byte 배열을 직접 선언해서 전송하는 방법 (비추)
//            byte[] temp = {'a','0','0','1'};
//            fos.write(temp);

            // 2. String을 만든 후 String을 byte 배열로 변환해서 전송
            String data = "건희";
            byte[] temp = data.getBytes();
            fos.write(temp);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n========================\n");

        // 존재하지 않는 파일을 생성하면서 데이터 넣기
        String attachPath = "C:\\attach";
        String unique = UUID.randomUUID().toString();

        File attachFile = new File(attachPath+"\\" + unique);
        try(FileOutputStream fos = new FileOutputStream(attachFile)){

            String data = "첨부된 파일 데이터";
            fos.write(data.getBytes());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
