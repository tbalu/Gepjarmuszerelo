package datastore;

import entities.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.commons.lang3.ObjectUtils;
import org.pmw.tinylog.Logger;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *A program altal hasznalt adatokat tartolja {@code ObservableList}-ekben.
 */
public class DataStore {

        public static ObservableList<Tulajdonos> Tulajdonosok = FXCollections.observableArrayList();
        public static ObservableList<Gepjarmu> Gepjarmuvek = FXCollections.observableArrayList();
        public static ObservableList<Szereles> Szerelesek = FXCollections.observableArrayList();


    /**
     * Betolti a {@code Tulajdonos} objektumokat a {@link JSONOlvasoIro#tulajdonosokBeolvas(String)} fuggveny segitsegevel.
     */
    public static void loadTulajdonosok(){
            /* TODO */
            //Tulajdonosok.add(new Tulajdonos("Tóth Balázs","Debrecen, Nagycsere tanya HRSZ.:02147/5","123"));
        try{
        Tulajdonosok.addAll(JSONOlvasoIro.tulajdonosokBeolvas("tulajdonosok.json"));}
        catch (NullPointerException n){
            Logger.info("Nincs elem a tulajdonos.json fajlban.");
        }
        Logger.info(Tulajdonosok.toString());
        }

    /**
     * Betolti a {@code Gepjarmuvek} objektumokat a {@link JSONOlvasoIro#gepjarmuveketBeolvas(String)} fuggveny segitsegevel.
     */
    public static void loadGepjarmuvek(){
        /* TODO */
        try {
            Gepjarmuvek.addAll(JSONOlvasoIro.gepjarmuveketBeolvas("gepjarmuvek.json"));

            Logger.info(Gepjarmuvek.toString());
        }catch (NullPointerException n){
            Logger.info("Nincs elem a gepjarmuvek.json fajlban");
        }
        }

    /**
     * Betolti a {@code Szereles} objektumokat a {@link JSONOlvasoIro#szereleseketBeolvas(String)} fuggveny segitsegevel.
     */
    public static void loadSzerelesek() {

        try {


            Szerelesek.addAll(JSONOlvasoIro.szereleseketBeolvas("szerelesek.json"));

            Logger.info(Szerelesek.toString());
        }catch (NullPointerException n){
            Logger.info("Nincs elem a szerelesek.json fajlban");
        }
    }


    /**
     * Elmenti a {@code Tulajdonos}, {@code Gepjarmu}, {@code Szereles} tipusu objektumokat.
     * @param tul A tulajdonosokat tartalmazo json fajl neve.
     * @param gps A gepjarmuveket tartalamzo json fajl neve.
     * @param szer A szereloket tartalmazo json fajl neve.
     */
        public static void saveMindent(String tul, String gps, String szer){
            JSONOlvasoIro.gepjarmuveketMent(getGepjarmuvek(),gps);
            JSONOlvasoIro.szereleseketMent(getSzerelesek(),szer);
            JSONOlvasoIro.tulajdonosokatMent(getTulajdonosok(),tul);
        }


    public static List<Tulajdonos> getTulajdonosok() {
        return Tulajdonosok;
    }

    public static List<Gepjarmu> getGepjarmuvek() {
        return Gepjarmuvek;
    }

    public static List<Szereles> getSzerelesek() {
        return Szerelesek;
    }

    /**
     * Kiszuri a befejezettlen szereleseket.
     * @return {@code ObservableList} tipusu objetumot terit vissza.
     */
    public static ObservableList<Szereles> getBefejezetlenSzerelesek(){
            return FXCollections.observableArrayList(DataStore.getSzerelesek().stream().filter(c->c.getSzerelesBefejezese()==null)
                    .collect(Collectors.toList()));
    }


}