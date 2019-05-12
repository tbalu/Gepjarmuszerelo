package entities;

import java.time.LocalDate;

/**
 * Szereleseket modellezo osztaly.
 * A SzerelesElkezdese es SzerelesBefejezese interfeszeket implementalja.
 */


public class Szereles  implements SzerelesElkezdese, SzerelesBefejezese {
    private String Rendszam;
    private LocalDate SzerelesKezdete;
    private LocalDate SzerelesBefejezese;
    private Integer MunkavegzesKoltsege;

    private String Problema;
    //private String Jogositvanyszam;

    public Szereles(){}

    /**
     * Meg nem letezo uj vagy meg be nem fejezett szereles letrehozasa.
     * @param rendszam A gepjarmu rendszama
     * @param szerelesKezdete A szereles kezdete
     */

    public Szereles(String rendszam,LocalDate szerelesKezdete ) {
        SzerelesKezdete = szerelesKezdete;
        Rendszam = rendszam;

    }

    /**
     * Konstruktor a befejezett szerelesek letrehozasahoz.
     * @param rendszam
     * @param szerelesKezdete
     * @param szerelesBefejezese
     * @param munkavegzesKoltsege
     */

    public Szereles(String rendszam, LocalDate szerelesKezdete, LocalDate szerelesBefejezese, Integer munkavegzesKoltsege) {
        Rendszam = rendszam;
        SzerelesKezdete = szerelesKezdete;
        SzerelesBefejezese = szerelesBefejezese;
        MunkavegzesKoltsege = munkavegzesKoltsege;
    }
    @Override
    public void setSzerelesBefejezese(LocalDate BefejezesIdeje) {
        this.SzerelesBefejezese = BefejezesIdeje;
    }

    @Override
    public LocalDate getSzerelesBefejezese() {
        return this.SzerelesBefejezese;
    }

    @Override
    public void setMunkavegzesKoltsege(Integer MunkavegzesKoltsege) {
        this.MunkavegzesKoltsege = MunkavegzesKoltsege;
    }


    @Override
    public Integer getMunkavegzesKoltsege() {
        return this.MunkavegzesKoltsege;
    }

    @Override
    public void setSzerelesKezdete(LocalDate szerelesMegkezdese) {
        this.SzerelesKezdete = szerelesMegkezdese;
    }

    @Override
    public LocalDate getSzerelesKezdete() {
        return this.SzerelesKezdete;
    }

    @Override
    public void setRendszam(String Rendszam) {
        this.Rendszam = Rendszam;
    }

    @Override
    public String getRendszam() {
        return this.Rendszam;
    }



    @Override
    public String toString() {
        return "Szereles{" +
                "SzerelesKezdete=" + SzerelesKezdete +
                ", SzerelesBefejezese=" + SzerelesBefejezese +
                ", MunkavegzesKoltsege=" + MunkavegzesKoltsege +
                ", Rendszam='" + Rendszam + '\'' +
                '}';
    }
}
