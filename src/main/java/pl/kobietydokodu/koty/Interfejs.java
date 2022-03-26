package pl.kobietydokodu.koty;

import java.util.Scanner;

public class Interfejs {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Kot kot = new Kot();

        String imieKota;
        String opiekun;

        System.out.println("Podaj imie kota: ");
        kot.setImie(getUserInput());

        System.out.println("Podaj imie opiekuna: ");
        kot.setImieOpiekuna(getUserInput());

        System.out.println("Pomyślnie dodano dane ;)");

    }

    public static String getUserInput() {
        return sc.nextLine();
    }
}
