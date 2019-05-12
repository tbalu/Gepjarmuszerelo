package datastore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Gepjarmu;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Ezt az osztalyt hasznalom a <code>Gepjarmu</code> tipusu objektumok betoltesere.
 * A <code>gepjarmuvek</code> listajaba olvassa be a {@link JSONOlvasoIro#gepjarmuveketBeolvas(String)}
 * fuggveny.
 */
public class Gepjarmuvek {
    private List<Gepjarmu> gepjarmuvek;

    /**
     * Ez a konstruktor letrehozza az obektumot .
     * @param gepjarmuvek Egy {@code List} interfeszt implementalo
     *      {@code Gepjarmu}veket tartalmazo lista.
     */
    public Gepjarmuvek(List gepjarmuvek){
        this.gepjarmuvek=gepjarmuvek;
    }


    public List<Gepjarmu> getGepjarmuvek() {
        return gepjarmuvek;
    }

    public void setGepjarmuvek(List<Gepjarmu> gepjarmuvek) {
        this.gepjarmuvek = gepjarmuvek;
    }
}
