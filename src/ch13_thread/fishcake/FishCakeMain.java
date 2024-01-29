package ch13_thread.fishcake;

public class FishCakeMain {

    public static void main(String[] args) {
        Chef chef = new Chef();


        Customer yongseok = new Customer(4);
        Customer gunhee = new Customer(5);

        chef.start();
        yongseok.start();
        gunhee.start();



    }
}
