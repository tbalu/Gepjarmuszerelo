package entitymanager;

import datastore.DataStore;
import entities.Szereles;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StatisztikaManagerTest {

    Szereles sz1 = new Szereles("ABC", LocalDate.of(2016,4,10),
            LocalDate.of(2016,4,12),23);
    Szereles sz2 = new Szereles("ABC", LocalDate.of(2017,4,10),
            LocalDate.of(2017,4,12),23);
    Szereles sz4 = new Szereles("ABC", LocalDate.of(2019,4,10),
            LocalDate.of(2019,4,12),23);
    Szereles sz5 = new Szereles("ABC", LocalDate.of(2019,2,1),
            LocalDate.of(2019,2,2),2);
    Szereles sz6 = new Szereles("ABC", LocalDate.of(2019,5,1),
            LocalDate.of(2019,2,2),2);
    Szereles sz7 = new Szereles("ABC", LocalDate.of(2019,2,1),
            LocalDate.of(2019,2,2),2);
    Szereles sz8 = new Szereles("ABC", LocalDate.of(2019,2,1),
            LocalDate.of(2019,2,2),2);
    Szereles sz9 = new Szereles("ABC", LocalDate.of(2019,5,1),
            LocalDate.of(2019,5,2),2);
    Szereles sz10 = new Szereles("ABC", LocalDate.of(2019,5,2),
            LocalDate.of(2019,5,5),2);
    Szereles sz3 = new Szereles("ABC", LocalDate.of(2019,8,4),
            LocalDate.of(2016,8,12),23);
    List<Szereles> szerelesek = new ArrayList<>();

    void datastoretInicializal(){
        szerelesek.add(sz1);
        szerelesek.add(sz2);
        szerelesek.add(sz3);
        szerelesek.add(sz4);
        szerelesek.add(sz5);
        szerelesek.add(sz6);
        szerelesek.add(sz7);
        szerelesek.add(sz8);
        szerelesek.add(sz9);
        szerelesek.add(sz10);
    }


    @Test
    void eHaviBevetel() {

        datastoretInicializal();
        DataStore.getSzerelesek().clear();
        DataStore.getSzerelesek().addAll(szerelesek);
        StatisztikaManager.getInstance().ezEviBevetel();
        Optional<Integer> o = Optional.ofNullable(4);
        assertEquals(o,StatisztikaManager.getInstance().eHaviBevetel(),"Sikertelen");
    }

    @Test
    void ezEviBevetel() {
        datastoretInicializal();
        DataStore.getSzerelesek().clear();
        DataStore.getSzerelesek().addAll(szerelesek);
        StatisztikaManager.getInstance().ezEviBevetel();
        Optional<Integer> o = Optional.ofNullable(35);
        assertEquals(o,StatisztikaManager.getInstance().ezEviBevetel(),"Sikertelen");
    }

    @Test
    void bevetelEkkor(){
        datastoretInicializal();
        DataStore.getSzerelesek().clear();
        DataStore.getSzerelesek().addAll(szerelesek);
        StatisztikaManager.getInstance().ezEviBevetel();
        Optional<Integer> o = Optional.ofNullable(27);
        assertEquals(o,StatisztikaManager.getInstance()
                .bevetelEkkor(LocalDate.of(2019,4,1)
                ,LocalDate.of(2019,5,20)),"Sikertelen");
    }
}