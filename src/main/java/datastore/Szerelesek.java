package datastore;

import entities.Szereles;

import java.util.List;

/**
 * Ezt az osztalyt hasznalom a {@link Szereles} tipusu objektumok betoltesere.
 * A szerelesek listajaba olvassa be a {@link JSONOlvasoIro#szereleseketBeolvas(String)} (String)}
 * fuggveny.
 */
public class Szerelesek {
    private List<Szereles> szerelesek;
    /**
     * Ez a konstruktor letrehozza az obektumot .
     * @param szerelesek Egy {@code List} interfeszt implementalo
     *      {@link Szereles}veket tartalmazo lista.
     */
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
