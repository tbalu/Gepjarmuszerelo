package controllers;

import entities.Szereles;
import entitymanager.StatisztikaManager;
import entitymanager.SzerelesManager;
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

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Ez az osztaly iranyitja a befejezett szereleseket megjelenito {@code Scene}-t.
 */
public class BefejezettSzerelesekController implements Initializable {
    @FXML private TableView<Szereles> BefejezettSzerelesekTablaNezet;
    @FXML private TableColumn<Szereles,String> RendszamOszlop;
    @FXML private TableColumn<Szereles, LocalDate> SzerelesKezdeteOszlop;
    @FXML private TableColumn<Szereles, LocalDate> SzerelesVegeOszlop;
    @FXML private TableColumn<Szereles, Integer> ArOszlop;
    @FXML private Label EzEviBevetel;
    @FXML private Label EHaviBevetel;
    @FXML private Label MaiBevetel;

    /**
     * Ha megnyomjuk a Vissza az uj szerelesek felvetelehez gombot akkor vissza jutunk az uj szerelesek felvetelehez.
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
     * Inicializalja a tablazatot alkoto valtozokat, amik az osztaly tagvaltozoi.
     * Kiszamolja az ezevi, ehavi, mai bevetelt.
     * @param url url
     * @param resourceBundle resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RendszamOszlop.setCellValueFactory(new PropertyValueFactory<>("Rendszam"));
        SzerelesKezdeteOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,LocalDate>("SzerelesKezdete"));
        SzerelesVegeOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,LocalDate>("SzerelesBefejezese"));
        ArOszlop.setCellValueFactory(new PropertyValueFactory<Szereles,Integer>("MunkavegzesKoltsege"));

        BefejezettSzerelesekTablaNezet.setItems(SzerelesManager.getInstance().getBefejezettSzerelesek());

        BefejezettSzerelesekTablaNezet.setEditable(true);
        RendszamOszlop.setCellFactory(TextFieldTableCell.forTableColumn());



        LocalDate most = LocalDate.now();
        Optional<Integer> ehavibevetel = StatisztikaManager.getInstance()
                .bevetelEkkor(LocalDate.of(most.getYear(),most.getMonth(),1).minusDays(1),
                        LocalDate.of(most.getYear(),most.getMonth().getValue(),most.lengthOfMonth()));
        Optional<Integer> ezevibevetel = StatisztikaManager.getInstance()
                .bevetelEkkor(LocalDate.of(most.getYear()-1,12,31)
                        ,LocalDate.of(most.getYear()+1, 1,1));
        Optional<Integer> maibevetel = StatisztikaManager.getInstance()
                .bevetelEkkor(LocalDate.now().minusDays(1),LocalDate.now().plusDays(1));
        ehavibevetel.ifPresent(c->EHaviBevetel.setText(c.toString()));
        ezevibevetel.ifPresent(c->EzEviBevetel.setText(c.toString()));
        maibevetel.ifPresent(c->MaiBevetel.setText(c.toString()));




    }
}
