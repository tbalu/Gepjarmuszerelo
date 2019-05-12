package entitymanager;

import datastore.DataStore;
import entities.Szereles;
import entities.SzerelesBefejezese;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.pmw.tinylog.Logger;
import java.time.LocalDate;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * A Szerekeseket kezelo osztaly.
 */

public class SzerelesManager {
    private static SzerelesManager instance = new SzerelesManager();

    /**
     * Singleton osztaly.
     */
    private SzerelesManager(){}
    public static SzerelesManager getInstance(){
        return instance;
    }

    /**
     * Uj szerelest ad hozza a DataStore megfelelo listajahoz.
     * @param Rendszam  Auto rendszama.
     * @param Jogositvanyszam Tulajdonos jogositvanyszama.
     */

    public void addSzerelesekhez(String Rendszam,String Jogositvanyszam){
        ListIterator<Szereles> listIterator = DataStore.getSzerelesek().listIterator();
        while(listIterator.hasNext()){
            Szereles szereles = listIterator.next();
            if(szereles.getRendszam().equals(Rendszam)&&szereles.getSzerelesKezdete().equals(LocalDate.now())){
                Logger.info("Már van ilyen szerelesunk");
                return;
            }
        }
        DataStore.getSzerelesek().add(this.createSzereles(Rendszam));
        Logger.info(DataStore.getSzerelesek().toString());
    }

    /**
     * Uj szereles letrehozasa.
     * @param Rendszam Gepjarmu rendszama.
     * @return
     */
    public Szereles createSzereles(String Rendszam){
        Szereles szereles = new Szereles();
        szereles.setRendszam(Rendszam);
        szereles.setSzerelesKezdete(LocalDate.now());

        Logger.info(szereles.toString());
        return szereles;
    }

    /**
     * Szereles befejezeset valositja meg. A {@link SzerelesBefejezese} objektum
     * Beallitja az objektum {@code MunkavegzesKoltsege}-t es a {@code SzerelesBefejezese}
     * tagvaltozoit.
     * @param szereles Megkezdett szereles
     * @param MunkavegzesKoltsege A munkavegzes koltsege
     * @return
     */
    public Szereles szerelesBefejezese(SzerelesBefejezese szereles, Integer MunkavegzesKoltsege) {
        int index = DataStore.getSzerelesek().indexOf(szereles);
        szereles.setSzerelesBefejezese(LocalDate.now());
        szereles.setMunkavegzesKoltsege(MunkavegzesKoltsege);
        DataStore.getSzerelesek().set(index, (Szereles) szereles);
        return (Szereles) szereles;
    }

    /**
     * Kivalogatja azokat a szereleseket amelyeknek a {@link Szereles#getSzerelesBefejezese()}
     * {@code null} erteku, tehat meg nem fejeztek be.
     * @return
     */
    public ObservableList<Szereles> getBefejezettSzerelesek(){
        return FXCollections.observableArrayList(DataStore.Szerelesek.stream()
                                .filter(c->c.getSzerelesBefejezese()!=null).collect(Collectors.toList()));
    }
}
