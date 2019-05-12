package entitymanager;

import datastore.DataStore;
import entities.Gepjarmu;
import entities.Tulajdonos;
import org.pmw.tinylog.Logger;

import java.util.ListIterator;
/**
 * Ez az osztaly kezeli a {@link Gepjarmu} objektumokat.
 * */
public class GepjarmuManager {
    private static GepjarmuManager instance = new GepjarmuManager();
    /**
     * Singleton osztaly.
     * */
    private GepjarmuManager(){}
    public static GepjarmuManager getInstance(){
        return instance;
    }

    /**
     * Uj gepjarmuvet ad hozza a {@link DataStore} megfelelo listajahoz.
     * */
    public void addGepjarmuvekhez(String Marka,String Rendszam,String TulajdonosJogositvanyszama){
        ListIterator<Gepjarmu> listIterator = DataStore.Gepjarmuvek.listIterator();
        while (listIterator.hasNext()){
            if(listIterator.next().getRendszam().equals(Rendszam)){
                Logger.info("Már van ilyen rendszamu kocsi");
               return;
            }
        }
        Gepjarmu gepjarmu = new Gepjarmu(Marka,Rendszam, TulajdonosJogositvanyszama);

        DataStore.getGepjarmuvek().add(gepjarmu);
        Logger.info(DataStore.getGepjarmuvek().toString());

    }
}
