package datastore;


import entities.Tulajdonos;

import java.util.List;

/**
 * Ezt az osztalyt hasznalom a {@link Tulajdonos} tipusu objektumok betoltesere.
 * A tulajdonosok listajaba olvassa be a {@link JSONOlvasoIro#tulajdonosokBeolvas(String)} )}
 * fuggveny.
 */

public class Tulajdonosok {
    private List<Tulajdonos> tulajdonosok;

    /**
     * Ez a konstruktor letrehozza az obektumot .
     * @param tulajdonosok Egy {@code List} interfeszt implementalo
     *      {@code Gepjarmu}veket tartalmazo lista.
     */

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
