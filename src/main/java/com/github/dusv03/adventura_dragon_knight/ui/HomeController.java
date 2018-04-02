package com.github.dusv03.adventura_dragon_knight.ui;

import java.util.Observable;
import java.util.Observer;

import com.github.dusv03.adventura_dragon_knight.logika.IHra;
import com.github.dusv03.adventura_dragon_knight.logika.Prostor;
import com.github.dusv03.adventura_dragon_knight.logika.Vec;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.MenuBar;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou adventury
 * 
 * @author dusv03
 *
 */
public class HomeController extends GridPane implements Observer {
	
	@FXML private TextField textVstup;
	@FXML private TextArea textVypis;
	@FXML private Button odesli;
	@FXML private ListView<Prostor> seznamMistnosti;
	@FXML private ListView<Vec> seznamVeci;
	@FXML private ListView<Vec> seznambatoh;
	@FXML private ImageView panacek;
	@FXML private AnchorPane mapa;
	@FXML private MenuBar menu;
	@FXML private MenuItem newGame;
	@FXML private MenuItem endGame;
	private IHra hra;
	
	/**
	 * Metoda čte příkaz ze vstupního textového pole
	 * a zpracuje ho...
	 */
	public void odesliPrikaz() {
		
		String vypis = hra.zpracujPrikaz(textVstup.getText());
		textVypis.appendText("\n--------\n"+textVstup.getText()+"\n--------\n");
		textVypis.appendText(vypis);
		textVstup.setText("");
		
		if(hra.konecHry()) {
			textVypis.appendText("\n\n Konec hry \n");
			textVstup.setDisable(true);
			odesli.setDisable(true);
		}
		
	}
	
	public void inicializuj(IHra hra) {
		this.hra = hra;
		textVypis.setText(hra.vratUvitani());
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		hra.getHerniPlan().addObserver(this);
		seznamVeci.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getPredmety());
		seznambatoh.getItems().addAll(hra.getBatoh().getVeci());
		hra.getBatoh().addObserver(this);
		hra.getHerniPlan().getAktualniProstor().addObserver(this);
		panacek.setX(hra.getHerniPlan().getAktualniProstor().getX());
		panacek.setY(hra.getHerniPlan().getAktualniProstor().getY());
	}
	
	public void novaHra() {
		seznamMistnosti.getItems().clear();
		seznamVeci.getItems().clear();
		seznambatoh.getItems().clear();
		hra.novaHra();
		this.inicializuj(hra);
		textVstup.setDisable(false);
		odesli.setDisable(false);
	}
	
	public void konecHry() {
		Platform.exit();
	}
	
	public void oHre() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adventura Dragon Knight");
        alert.setHeaderText("Adventura Dragon Knight \nKonzolová adventura s grafickým rozhraním");
        alert.setContentText("Tato adventura vznikla jako semestrální práce na FIS VŠE v Praze"
        		+ "\nv rámci předmětu Softwarové inženýrství(4IT115) v letním semestru 2017/18");
        alert.showAndWait();
	}
	
	public void napoveda() {
		Stage stage = new Stage();
        stage.setTitle("Nápověda k aplikaci");
        WebView webview = new WebView();
        webview.getEngine().load(
                getClass().getResource("./napoveda.html").toExternalForm()
        );
        stage.setScene(new Scene(webview, 500, 500));
        stage.show();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		seznamMistnosti.getItems().clear();
		seznamMistnosti.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVychody());
		seznamVeci.getItems().clear();
		seznamVeci.getItems().addAll(hra.getHerniPlan().getAktualniProstor().getVeci());
		seznambatoh.getItems().clear();
		seznambatoh.getItems().addAll(hra.getBatoh().getVeci());
		hra.getHerniPlan().getAktualniProstor().addObserver(this);
		panacek.setX(hra.getHerniPlan().getAktualniProstor().getX());
		panacek.setY(hra.getHerniPlan().getAktualniProstor().getY());
		
	}

}
