package ch16_network.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        // ServerSocket 에 소켓 연결 요청

        // (IP주소, 포트번호)
        // 선생님 IP 주소에 접근
        try {
            Socket clientSocket = new Socket("192.168.0.147", 9001);

            System.out.println("서버와 연결 성공!");
            System.out.println(clientSocket.getRemoteSocketAddress());

            SendThread send = new SendThread(clientSocket);
            send.start();

            ReceiveThread receive = new ReceiveThread(clientSocket);
            receive.start();



        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}