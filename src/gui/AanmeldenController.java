package gui;

import java.io.IOException;

import domein.DomeinController;
import domein.Speler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AanmeldenController extends AnchorPane{

	private DomeinController dc;
	private MenuController preMenuScreen;
	
	@FXML
    private Button btnLogIn;

    @FXML
    private Button btnTerug;

    @FXML
    private Rectangle kader;

    @FXML
    private Label lblGeboortejaar;

    @FXML
    private Label lblGebruikersnaam;

    @FXML
    private TextField txfGeboortjaar;

    @FXML
    private TextField txfGebruikersnaam;

	public AanmeldenController(MenuController preMenuScreen, DomeinController dc) {
		this.preMenuScreen = preMenuScreen;
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Aanmelden.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@FXML
	void btnLogInClicked(ActionEvent event) {
		String gebruikersnaam = txfGebruikersnaam.getText();
		int geboortejaar = Integer.parseInt(txfGeboortjaar.getText());
		
		if(dc.spelerAlAangemeld(new Speler(gebruikersnaam, geboortejaar))) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aanmelden mislukt");
			alert.setContentText(String.format("Speler met naam %s en geboortejaar %d is al aangemeld", gebruikersnaam, geboortejaar));
		}
		else {
			dc.voegToe(new Speler(gebruikersnaam, geboortejaar));
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aanmelden gelukt");
			alert.setContentText(String.format("Speler met naam %s en geboortejaar %d is aangemeld", gebruikersnaam, geboortejaar));
		}
	}
	
	@FXML
    void btnTerugClicked(ActionEvent event) {
		Stage stage = (Stage) (getScene().getWindow());
		stage.setScene(preMenuScreen.getScene());
    }
}