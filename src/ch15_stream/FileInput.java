package ch15_stream;

import java.io.*;

public class FileInput {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        // 읽어오고자 하는 File
        File context = new File(path + "\\src\\config\\context-db.properties");

        System.out.println(context.exists());
        StringBuffer sb = new StringBuffer();

        // 해당 File 읽어오기 , FileInputStream
        try (FileInputStream fis = new FileInputStream(context)) {

            // 데이터를 가져올 그릇(byte[]) 생성
            byte[] bowl = new byte[3]; // [1]이면 그릇의 크기가 1이라는 뜻


            while (true) {
                // 해당 파일을 읽어서 bowl에 담음
                // cnt에는 bowl에 담긴 데이터의 개수가 저장됨
                int cnt = fis.read(bowl);

                // 데이터를 전부 읽어오면 bowl 에는 데이터가 담기지 않고
                // cnt 에는 -1이 담기게 된다. -> while문 종료시키기
                if (cnt == -1) {
                    break;
                }

                // bowl(byte[])을 String으로 변환
                String text = new String(bowl); // 새로운 문자열 객체에 읽어온걸 담는 버전
                sb.append(text); // 새로운 StringBuffer 객체에 읽어온 걸 하나씩 추가해서 담는 버전
//                System.out.println(text); // 주석처리한 것까지 읽어온다.
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);


        System.out.println("\n=================================\n");
        // ch15_stream \\ GameLog 클래스의 데이터 읽어오기

        File gameLog = new File(path + "\\src\\ch15_stream\\GameLog.java");

        System.out.println(gameLog.exists());

        sb = new StringBuffer();

        try (FileInputStream fis = new FileInputStream(gameLog)) {

            // 한글은 inputStream 등으로 (byte 단위)
            // 읽어오면 깨질 수 있다.

            // bowl의 크기를 해당 파일의 크기만큼 늘려버리면 안깨진다.
            System.out.println(gameLog.length()); // 2564
            System.out.println(fis.available()); // 2564
//            byte[] bowl = new byte[2564];
            // 그릇의 크기가 작으면 한번에 사용되는 메모리 용량은 작지만 오래 걸리고,
            // 그릇의 크기가 크면 한번에 사용되는 메모리 용량이 크지만 금방 끝난다.
            byte[] bowl = new byte[fis.available()];

            while (true) {
                int cnt = fis.read(bowl);

                if (cnt == -1) {
                    break;
                }
                String text = new String(bowl);
                sb.append(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
    }
}
