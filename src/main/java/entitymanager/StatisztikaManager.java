package entitymanager;

import datastore.DataStore;
import entities.Szereles;
import java.time.LocalDate;
import java.util.Optional;
/**
 * Ez az osztaly statisztikai adatokat szamit ki.
 */

public class StatisztikaManager {
    private static StatisztikaManager instance = new StatisztikaManager();

    /**
     * Singleton osztaly.
     */
    private StatisztikaManager(){}
    public static StatisztikaManager getInstance(){
        return instance;
    }

    /**
     * Az aktualis havi bevetel.
     * @return {@code Optional<Integer>} tipusu objektum.
     */
    public Optional<Integer> eHaviBevetel(){
        return DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()!=null).filter(c->c.getSzerelesBefejezese().getMonth()==LocalDate.now().getMonth()
                                                        &&c.getSzerelesBefejezese().getYear()==LocalDate.now().getYear())
                                                        .map(Szereles::getMunkavegzesKoltsege)
                                                        .reduce((a,b)->a+b);
    }

    /**
     * Az aktualis eves bevetel.
     * @return {@code Optional<Integer>} tipusu objektum.
     */
    public Optional<Integer> ezEviBevetel(){
        return DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()!=null).filter(c->c.getSzerelesBefejezese().getYear()==LocalDate.now().getYear())
                                                    .map(Szereles::getMunkavegzesKoltsege).reduce((a,b)->a+b);
    }

    /**
     * Bevetel egy bizonyos idointervallum kozott.
     * @param Ettol Az intervallum kezdete
     * @param Eddig Az intervallum
     * @return {@code Optional<Integer>} tipusu objektum.
     */

    public Optional<Integer> bevetelEkkor(LocalDate Ettol, LocalDate Eddig){
        return DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()!=null)
            .filter(c->c.getSzerelesBefejezese().isAfter(Ettol)&&c.getSzerelesBefejezese().isBefore(Eddig))
            .map(Szereles::getMunkavegzesKoltsege).reduce((a,b) ->a+b);
    }
}
