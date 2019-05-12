package entities;

/**
 * A gepjarmuveket modellezo osztaly.
 */

public class Gepjarmu {
    private String Marka;
    private String Rendszam;
    private String TulajdonosJogositvanyszam;

    /**
     * Letrehoz egy gepjarmu objektumot.
     * @param marka A gepjarmu markaja
     * @param rendszam A gejarmu rendszama
     * @param tulajdonosJogositvanyszam A gepjarmu tulajdonosanak jogositvanyszama
     */
    public Gepjarmu(String marka, String rendszam, String tulajdonosJogositvanyszam) {
        Marka = marka;
        Rendszam = rendszam;
        TulajdonosJogositvanyszam = tulajdonosJogositvanyszam;
    }

    public String getMarka() {
        return Marka;
    }

    public void setMarka(String marka) {
        Marka = marka;
    }

    public String getRendszam() {
        return Rendszam;
    }

    public void setRendszam(String rendszam) {
        Rendszam = rendszam;
    }

    @Override
    public String toString() {
        return "Gepjarmu{" +
                "Marka='" + Marka + '\'' +
                ", Rendszam='" + Rendszam + '\'' +
                ", TulajdonosJogositvanyszam='" + TulajdonosJogositvanyszam + '\'' +
                '}';
    }
}
