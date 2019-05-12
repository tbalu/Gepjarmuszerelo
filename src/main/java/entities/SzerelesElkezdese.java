package entities;

import java.time.LocalDate;

/**
 * Szereles elkezdeset modellezo interfesz.
 */
public interface SzerelesElkezdese {
    void setSzerelesKezdete(LocalDate szerelesMegkezdese);
    LocalDate getSzerelesKezdete();
    void setRendszam(String gepjarmuRendszama);
    String getRendszam();

}
