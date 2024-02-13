package ch16_network.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 연결된 소켓 객체의 Stream 중에 OutputStream에다
// 텍스트를 작성하여 보내주는 클래스
public class SendThread extends Thread{

    private Socket soc;

    public SendThread(Socket soc){
        this.soc = soc;

    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);

        // todo 연결된 소켓 객체의 OutputStream 가져오기
        // 단순 연결은 soc.getOutputStream() 하면 되지만 데이터가 왔다갔다 해야하므로 PrintWriter 객체로 만들어주기
        try {
            PrintWriter writer = new PrintWriter(soc.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){

            String input = scan.nextLine();

            // todo 데이터 전송




        }

    }
}
