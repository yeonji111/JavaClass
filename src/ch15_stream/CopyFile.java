package ch15_stream;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");


        // files 폴더에 ch15_stream 폴더 안에 있는 FileBasic 복사본 만들기
        // 읽어올 대상 파일
//        File fileBasic = new File("C:\\Users\\user\\Desktop\\tangerines.jpg"); // 귤 사진 붙여넣기
        File fileBasic = new File(path + "\\src\\cg15_stream\\FileBasic.java"); // .java 확장자 붙여야함
        System.out.println(fileBasic.exists());

        // 쓸 대상 파일
//        File copyFileBasic = new File(path + "\\src\\files\\tangerines.jpg"); // 귤 사진 붙여넣기
        File copyFileBasic = new File(path + "\\src\\files\\FileBasic.java"); // 현재 존재하지 않는 파일 생성

        try(FileInputStream fis = new FileInputStream(fileBasic); // 복사할 대상(fileBasic)
            FileOutputStream fos = new FileOutputStream(copyFileBasic)){ // 복사한 걸 저장할 대상 (copyFileBasic)

            byte[] bowl = new byte[fis.available()];

            fis.read(bowl);
            fos.write(bowl);

            fos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
