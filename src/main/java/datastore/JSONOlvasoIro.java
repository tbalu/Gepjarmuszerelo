package datastore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import entities.Gepjarmu;
import entities.Szereles;
import entities.Tulajdonos;
import org.pmw.tinylog.Logger;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Ennek az osztalynak a fuggvenyi olvassak be es mentik el a programban hasznalt
 * objektumokat.
 */
public class JSONOlvasoIro {
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Beolvassa a szereleseket a json fajlbol.
     * @param FajlNev {@code String} tipusu , a fajl elereset hatarozza meg.
     * @return {@code Szereles}eket tartalmazo {@code List}
     */
    public static List<Szereles> szereleseketBeolvas(String FajlNev){

        try {

            Szerelesek szerelesek = gson.fromJson(new FileReader(ClassLoader.getSystemResource(FajlNev).getFile()), Szerelesek.class);
            return szerelesek.getSzerelesek();
        }catch (FileNotFoundException f){
            return null;
        }

    }
    /**
     * Beolvassa a gepjarmuveket a json fajlbol.
     * @param FajlNev {@code String} tipusu , a fajl elereset hatarozza meg.
     * @return {@code Gepjarmu}eket tartalmazo {@code List}
     */
    public static List<Gepjarmu> gepjarmuveketBeolvas(String FajlNev){

        try {
            Gepjarmuvek gepjarmuvek = gson.fromJson(new FileReader(ClassLoader.getSystemResource(FajlNev).getFile()), Gepjarmuvek.class);
            return gepjarmuvek.getGepjarmuvek();
        }catch (FileNotFoundException f){
            return null;
        }

    }
    /**
     * Beolvassa a tulajdonosokat a json fajlbol.
     * @param FajlNev {@code String} tipusu , a fajl elereset hatarozza meg.
     * @return {@code Tulajdonos}eket tartalmazo {@code List}
     */

    public static List<Tulajdonos> tulajdonosokBeolvas(String FajlNev){

        try {
            Logger.info(ClassLoader.getSystemResource(FajlNev).getPath());
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Tulajdonosok tulajdonosok = gson.fromJson(new FileReader(classLoader.getSystemResource(FajlNev).getFile()), Tulajdonosok.class);
            return tulajdonosok.getTulajdonosok();
        }catch (FileNotFoundException f){
            return null;
        }

    }

  /*  public static List<Tulajdonos> tulajdonosokBeolvas(String fileName){
        String destination = "";
        try {
            Path workingDirectory = FileSystems.getDefault().getPath("").toAbsolutePath();
            destination = workingDirectory.toString() + File.separator + "data" + File.separator;
            Logger.info("Working directory: {}", workingDirectory);
        } catch (Exception e) {
            Logger.error(e.toString());
        }
        try {
            File directory = new File(destination);
            if (directory.mkdir()) {
                Logger.info("Directory {} created", destination);
            }

            destination = destination + fileName;
            InputStream source = getClass().getResourceAsStream("/" + fileName);
            Path dest = Paths.get(destination);
            if (Files.notExists(dest)) {
                Files.copy(source, Paths.get(destination));
                Logger.info("File table.json copied from jar to {}", destination);
            } else {
                Logger.info("{} was already existed", destination);
            }
        } catch (Exception e) {
            Logger.error(e.toString());
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        }

    }
*/

    /**
     * Elmenti a szereleseket egy json fajlba.
     * @param szerelesek {@code Szereles}eket tartalmazo lista.
     * @param FajlNev A fajl elerese.
     */

    public static void szereleseketMent(List<Szereles> szerelesek,String FajlNev){
        Szerelesek szerelesek1 = new Szerelesek(szerelesek);
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            FileWriter writer2 = new FileWriter(classLoader.getSystemResource(FajlNev).getFile());
            gson.toJson(szerelesek1, writer2);
            writer2.close();
        }catch (FileNotFoundException f){
            f.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Elmenti a tulajdonosokat egy json fajlba.
     * @param tulajdonosok {@code Tulajdonos}okat tartalmazo lista.
     * @param FajlNev A fajl elerese.
     */
    public static void tulajdonosokatMent(List<Tulajdonos> tulajdonosok,String FajlNev){
        Tulajdonosok tulajdonosok1 = new Tulajdonosok(tulajdonosok);
        try {
            Logger.info(ClassLoader.getSystemResource(FajlNev).getPath());
            FileWriter writer2 = new FileWriter(ClassLoader.getSystemResource(FajlNev).getFile());
            gson.toJson(tulajdonosok1, writer2);
            writer2.close();
        }catch (FileNotFoundException f){

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * Elmenti a gepjarmuveket egy json fajlba.
     * @param gpk {@code Gepjarmu}veket tartalmazo lista.
     * @param FajlNev A fajl elerese.
     */
    public static void gepjarmuveketMent(List<Gepjarmu> gpk,String FajlNev){
        Gepjarmuvek gepjarmuvek = new Gepjarmuvek(gpk);
        try {
            FileWriter writer2 = new FileWriter(ClassLoader.getSystemResource(FajlNev).getFile());
            gson.toJson(gepjarmuvek, writer2);
            writer2.close();
        }catch (FileNotFoundException f){

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
