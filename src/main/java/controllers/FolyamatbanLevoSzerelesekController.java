package controllers;

import datastore.DataStore;
import entities.Szereles;
import entitymanager.SzerelesManager;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import org.pmw.tinylog.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * Ez az osztaly iranyitja a folyamatban levo szereleseket megjelenito {@code Scene}-t.
 */
public class FolyamatbanLevoSzerelesekController implements Initializable {
    @FXML private TableView<Szereles> FolyamatbanLevoSzerelesekTablaNezet;
    @FXML private TableColumn<Szereles,String> AutoMarkajaOszlop;
    @FXML private TableColumn<Szereles,String> RendszamOszlop;
    @FXML private TableColumn<Szereles, LocalDate> MunkavegzesKezdeteOszlop;

    @FXML private TextField MunkavegzesKoltsege;

    /**
     * Inicializalja a tablazat megjelenitesehez szugseges tagvaltozokat.
     * @param url url
     * @param resourceBundle resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //AutoMarkajaOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("AutoMarkaja"));
        RendszamOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,String>("Rendszam"));
        MunkavegzesKezdeteOszlop.setCellValueFactory(new PropertyValueFactory<Szereles, LocalDate>("SzerelesKezdete"));

        FolyamatbanLevoSzerelesekTablaNezet.setItems(DataStore.getBefejezetlenSzerelesek());

        FolyamatbanLevoSzerelesekTablaNezet.setEditable(true);
        RendszamOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
        //lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //MunkavegzesKezdeteOszlop.setCellFactory(TextFieldTableCell.forTableColumn());
        FolyamatbanLevoSzerelesekTablaNezet.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /**
     * Ha megnyomjuk a vissza az uj szerelesek felvetelehez gombot akkor visszalep az uj szerlesekhez.
     * @param event esemeny
     * @throws IOException Ha nem letezik a fajl amit be akar olvasni.
     */
    public void visszaazUjSzerelesekFelvetelehezPushed(ActionEvent event) throws IOException {
        //URL url = Paths.get("target/classes/TulajdonosEsAutoAdatai.fxml").toUri().toURL();
        URL url = FXMLLoader.getDefaultClassLoader().getResource("TulajdonosEsAutoAdatai.fxml");
        Parent tableViewParent = FXMLLoader.load(url);
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * Egy szerelest fejezhetunk be vele.
     * Ha megnyomjuk a gombot akkor az eppen a tablazatban kijelolt {@code Szereles} objektumot
     * ertekul adja a {@code SzerelesManager} {@code szerelesBefejezese} fuggvenynek.
     */
    public void szerelesVegePushed(){
        //SzerelesManager.getInstance().szerelesBefejezese()
        ObservableList<Szereles>  FolyamatbanLevoSzerelesek;
        Szereles KivalasztottSor;
        FolyamatbanLevoSzerelesek = FolyamatbanLevoSzerelesekTablaNezet.getItems();

        KivalasztottSor = FolyamatbanLevoSzerelesekTablaNezet.getSelectionModel().getSelectedItem();
        Logger.info(KivalasztottSor);

        if(KivalasztottSor!=null)
        SzerelesManager.getInstance().szerelesBefejezese(KivalasztottSor,Integer.valueOf(MunkavegzesKoltsege.getText()));

        FolyamatbanLevoSzerelesek.remove(KivalasztottSor);
        Logger.info(DataStore.getSzerelesek());
    }
}
