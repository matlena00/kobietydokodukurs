package pl.kobietydokodu.koty;

import java.util.ArrayList;
import java.util.List;

public class KotDAO {

    private List<Kot> koty = new ArrayList<Kot>();

    public List<Kot> getKoty() {
        return koty;
    }

    public void setKoty(List<Kot> koty) {
        this.koty = koty;
    }

    public void dodajKota(Kot kot) {
        koty.add(kot);
        System.out.println("Poprawnie dodano kota do listy :)");
    }

}
