package ch15_stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GameLog {

    public static void main(String[] args) {
        // 강화 게임
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        System.out.print("아이디 입력: ");
        String id = scan.nextLine();

        int grade = 1;

        while(true){
            System.out.println("현재 강화: " + grade);
            System.out.println("강화 확률 50%");
            System.out.println("1. 강화");
            System.out.println("2. 종료");
            System.out.println(">>> ");

            int command = Integer.parseInt(scan.nextLine());

            if (command == 1){
                // 강화
                int ran = (int)(Math.random() * 2);
                if (ran == 0){
                    // 성공
                    grade++;
                    saveLog(id+"님이 "
                            + (grade-1)
                            +"->"+grade+"강화에 성공하였습니다."
                            +sdf.format(new Date()));
                    // ~~ 님이 1->2 강화에 성공하였습니다.

                } else {
                    // 실패
                    saveLog(id+"님이 "
                            + grade
                            +"->"+(grade+1)+"강화에 실패하였습니다."
                            +sdf.format(new Date()));
                    // ~~ 님이 1->2 강화에 성공하였습니다.

                }


            } else if (command == 2) {
                break;
            }


        }


    }
    // 게임 로그 저장 메소드
    static void saveLog(String data){
        File logFile = new File("C:\\attach\\gameLog.txt");

        data += "\n";
        // fos 로 기존 텍스트에 추가로 텍스트를 입력하고자 한다면
        // 파라미터에 true 를 추가해준다.

        try(FileOutputStream fos = new FileOutputStream(logFile,true)){
            fos.write(data.getBytes()); // 파일은 byte로 작성할 수 있으므로 .getByte() 필수

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
