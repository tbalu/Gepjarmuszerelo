package datastore;

import entities.Tulajdonos;

import java.util.List;

public class Tulajdonosok {
    private List<Tulajdonos> tulajdonosok;

    public Tulajdonosok(List<Tulajdonos> tulajdonosok) {
        this.tulajdonosok = tulajdonosok;
    }

    public List<Tulajdonos> getTulajdonosok() {
        return tulajdonosok;
    }

    public void setTulajdonosok(List<Tulajdonos> tulajdonosok) {
        this.tulajdonosok = tulajdonosok;
    }
}
