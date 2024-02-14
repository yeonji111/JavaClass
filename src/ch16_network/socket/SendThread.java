package ch16_network.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 연결된 소켓 객체의 Stream 중에 OutputStream에다
// 텍스트를 작성하여 보내주는 클래스
public class SendThread extends Thread {

    private Socket soc;

    public SendThread(Socket soc) {
        this.soc = soc;

    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);

        System.out.println("닉네임 입력: ");
        String name = scan.nextLine();

        // 연결된 소켓 객체의 OutputStream 가져오기
        // 단순 연결은 soc.getOutputStream() 하면 되지만 데이터가 왔다갔다 해야하므로 PrintWriter 객체로 만들어주기
        try {
            PrintWriter writer = new PrintWriter(soc.getOutputStream());

            while (true) {
                System.out.println(">>>  ");
                String input = scan.nextLine();

                if (input.equals("나가기")){
                    writer.println("상대방이 나갔습니다.");
                    writer.flush();
                    break;
                }
                // 데이터 전송
                // outputStream에 입력한 문구 작성
                writer.println(name +": " + input);
                // 데이터 전송
                writer.flush();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally { // 사용한 소켓 종료 (자원정리)
            try { soc.close();} catch (IOException e) {  }
        }


    }
}
