package datastore;

import entities.Szereles;

import java.util.List;

public class Szerelesek {
    private List<Szereles> szerelesek;

    public Szerelesek(List<Szereles> szerelesek) {
        this.szerelesek = szerelesek;
    }

    public List<Szereles> getSzerelesek() {
        return szerelesek;
    }

    public void setSzerelesek(List<Szereles> szerelesek) {
        this.szerelesek = szerelesek;
    }
}
