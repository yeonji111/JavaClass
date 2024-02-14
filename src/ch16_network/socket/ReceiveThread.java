package ch16_network.socket;


// 연결된 소켓 객체의 inputStream으로부터
// flush로 전달받은 데이터를 읽어다 콘솔창에 출력해주는 클래스

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {

    private Socket soc;

    public ReceiveThread(Socket soc) {
        this.soc = soc;
    }

    @Override
    public void run() {
        // 소켓의 InputStream 가져오기

        try {
            BufferedReader reader
                    = new BufferedReader( new InputStreamReader(soc.getInputStream()) );

            while (true){
                // InputStream 안에 있는 내용 읽기
                String msg = reader.readLine();

                // 넘어온 메시지 출력
                System.out.println(msg);


                if (msg.equals("상대방이 나갔습니다.")){
                    break;
                }


            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally { // 사용한 소켓 종료 (자원정리)
            try { soc.close();} catch (IOException e) {  }
        }


    }
}
