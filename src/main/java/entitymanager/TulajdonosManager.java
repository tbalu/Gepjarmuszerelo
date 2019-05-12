package entitymanager;
import datastore.DataStore;
import entities.Tulajdonos;
import org.pmw.tinylog.Logger;

import java.util.ListIterator;

/**
 * A {@link Tulajdonos}okat kezelo osztaly.
 */
public class TulajdonosManager {
    private static TulajdonosManager instance = new TulajdonosManager();

    /**
     * Singleton osztaly.
     */
    private TulajdonosManager(){}
    public static TulajdonosManager getInstance(){
        return instance;
    }

    /**
     * Uj tulajdonost ad hozza a {@link DataStore} oszataly megfelelo listajahoz.
     * @param nev A tulajdonos neve
     * @param lakcim A tulajdonos lakcime
     * @param jogositvanyszam A tulajdonos jogositvanyszama
     */
    public void addTulajdonosokhoz(String nev,  String lakcim,String jogositvanyszam){

        ListIterator<Tulajdonos> listIterator = DataStore.getTulajdonosok().listIterator();
        while(listIterator.hasNext()){


            if(listIterator.next().getJogositvanyszam().equals(jogositvanyszam)){

                Logger.info("Már van " + jogositvanyszam+ " számú tulajdonos");
                return;
            }
        }
        DataStore.Tulajdonosok.add(new Tulajdonos(nev,lakcim,jogositvanyszam));
        Logger.info(DataStore.getTulajdonosok().toString());
    }
}
