package main;

import controllers.TulajdonosEsAutoAdataiController;
import datastore.DataStore;
import entities.Tulajdonos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.net.URL;
import java.nio.file.Paths;

/**
 * Main osztaly a program belepesi pontja.
 */
public class Main extends Application {
    /**
     * Elinditja a programot. Betolti a kezdo {@link Scene}-t ami a tulajdonosok felvetele.
     * @param primaryStage
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception{
        //URL url = Paths.get("target/classes/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        //Parent root = FXMLLoader.load(url);
        Parent root =  FXMLLoader.load(FXMLLoader.getDefaultClassLoader().getResource("TulajdonosEsAutoAdatai.fxml"));
        primaryStage.setTitle("Gépjarműszervíz");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    /**
     * Betolti az osszes adatot.
     */
    public static void loadMindent(){
        DataStore.loadTulajdonosok();
        DataStore.loadSzerelesek();
        DataStore.loadGepjarmuvek();

    }
    public static void main(String[] args){


        Tulajdonos t = new Tulajdonos("Balu","12341","Debrecen");
        System.out.println(t.toString());
        loadMindent();
        launch(args);
        Logger.info(DataStore.getSzerelesek());
        Logger.info(DataStore.getTulajdonosok());
        Logger.info(DataStore.getGepjarmuvek());
        DataStore.saveMindent("target/classes/tulajdonosok.json"
                ,"target/classes/gepjarmuvek.json"
                ,"target/classes/szerelesek.json");
    }
}
