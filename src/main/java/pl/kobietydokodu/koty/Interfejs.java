package pl.kobietydokodu.koty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interfejs {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Kot kot = new Kot();
        KotDAO kotDAO = new KotDAO();

        String imieKota;
        String opiekun;

        System.out.println("Podaj imie kota: ");
        kot.setImie(getUserInput());

        System.out.println("Podaj imie opiekuna: ");
        kot.setImieOpiekuna(getUserInput());

        Pattern wzorzecDaty = Pattern.compile("[0-9]{4}.[0-1]?[0-9].[0-3]?[0-9]");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String dataUrodzeniaWczytana;

        do {
            System.out.print("Podaj datę urodzenia kota w formacie RRRR.MM.DD: ");
            dataUrodzeniaWczytana = getUserInput();
            if (wzorzecDaty.matcher(dataUrodzeniaWczytana).matches()) {
                try {
                    kot.setData(sdf.parse(dataUrodzeniaWczytana));
                } catch (ParseException pe) {
                    System.out.println("Coś jest nie tak z datą! Przykładowa data: 2014.01.05");
                }
            }
        } while (kot.getData()==null);

        Pattern wzorzecWagi = Pattern.compile("[0-9]+(\\.[0-9]+)?");
        String wagaWczytana;

        do {
            System.out.print("Podaj wagę kota: ");
            wagaWczytana = getUserInput();

            if (wzorzecWagi.matcher(wagaWczytana).matches()) {
                kot.setWaga(Float.valueOf(wagaWczytana));
            }
        } while (kot.getWaga() == null);

        kotDAO.dodajKota(kot);

    }

    public static String getUserInput() {
        return sc.nextLine();
    }
}
