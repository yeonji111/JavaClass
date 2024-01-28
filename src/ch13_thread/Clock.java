package ch13_thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Clock {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("a hh:mm:ss");

        Thread clock = new Thread(() -> {
            while (true){
                System.out.println(sdf.format(new Date()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        clock.start();

        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println(">>>  ");
            String input = scan.nextLine();
            if (input.equals("q")){
                break;
            }
            System.out.println(input);
        }


    }

}
