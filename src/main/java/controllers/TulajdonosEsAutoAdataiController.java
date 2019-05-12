package controllers;

import entitymanager.GepjarmuManager;
import entitymanager.SzerelesManager;
import entitymanager.TulajdonosManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Ez az osztaly iranyitja azt a {@code Scene}-t amelyben felvesszuk a szereleseket.
 */
public class TulajdonosEsAutoAdataiController {
    @FXML private TextField Nev;
    @FXML private TextField Lakcim;
    @FXML private TextField Jogositvanyszam;
    @FXML private TextField Automarka;
    @FXML private TextField Rendszam;

    /**
     * Szereles felvetele gomb iranyitasa.
     * Ha megnyomjuk letrejon egy uj {@code Tulajdonos}, {@code Gepjarmu}, {@code Szereles} objektum
     * a {@code TextField}-keben levo informaciok segitsegevel, ha eddig meg ilyen nem letezett.
     */
    public void szerelesFelvetelePushed(){

        if(Jogositvanyszam.getText()!=null
            && Nev.getText() != null
            && Rendszam.getText() != null
            && Automarka.getText() !=null){

        String jogositvanyszamText = Jogositvanyszam.getText();
        TulajdonosManager.getInstance().addTulajdonosokhoz(Nev.getText(),Lakcim.getText(),jogositvanyszamText);
        Logger.info(jogositvanyszamText);
        SzerelesManager.getInstance().addSzerelesekhez(Rendszam.getText(),jogositvanyszamText);
        GepjarmuManager.getInstance().addGepjarmuvekhez(Automarka.getText(),Rendszam.getText(),jogositvanyszamText);
        Nev.clear();
        Jogositvanyszam.clear();
        Lakcim.clear();
        Rendszam.clear();
        Automarka.clear();
        }
        else return;

    }

    /**
     * A folyamatban levo szerelesek {@code Scene}-hez iranyitja a felhasznalot.
     * @param event esemeny
     * @throws IOException Ha nem letezik a fajl amit be akar olvasni.
     */
    public void folyamatbanLevoSzerelesekPushed(ActionEvent event) throws IOException {
        //URL url = Paths.get("target/classes/FolyamatbanLevoSzerelesek.fxml").toUri().toURL();
        URL url = FXMLLoader.getDefaultClassLoader().getResource("FolyamatbanLevoSzerelesek.fxml");
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * A Befejezett szerelesek {@code Scene}-hez iranyitja a felhasznalot.
     * @param event esemeny
     * @throws IOException Ha nem letezik a fajl amit be akar olvasni.
     */
    public void statisztikaPushed(ActionEvent event) throws IOException {
        //URL url = Paths.get("target/classes/BefejezettSzerelesek.fxml").toUri().toURL();
        URL url = FXMLLoader.getDefaultClassLoader().getResource("BefejezettSzerelesek.fxml");
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
}
