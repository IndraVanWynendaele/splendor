package gui;

import java.io.IOException;
import java.util.Optional;

import domein.DomeinController;
import domein.Speler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
		try {
			String gebruikersnaam = txfGebruikersnaam.getText();
			int geboortejaar = Integer.parseInt(txfGeboortjaar.getText());
			
			Speler sp = new Speler(gebruikersnaam, geboortejaar);
			if(dc.spelerAlAangemeld(sp)) {
				if(dc.meldAan(sp)) {
					update(gebruikersnaam, geboortejaar);
				}
				else{
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Nieuwe speler aanmaken?");
					alert.setContentText("Wil je een nieuwe speler aanmaken?");
					Optional<ButtonType> result = alert.showAndWait();
					if(result.get() == ButtonType.OK) {
						dc.voegToe(sp);
						dc.meldAan(sp);
						update(gebruikersnaam, geboortejaar);
					}
				}
			}else {
				throw new IllegalArgumentException("Deze speler is al aangemeld!\n");
			}
		}catch(NumberFormatException ex) {
			txfGeboortjaar.setText("");
			txfGeboortjaar.setPromptText("Moet een positief getal zijn");
			txfGeboortjaar.setStyle("-fx-text-box-border: red");
		}catch(IllegalArgumentException ex) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Aanmelden mislukt");
			alert.setContentText(ex.getMessage());
			alert.show();
		}
	}
	
	private void update(String gebruikersnaam, int geboortejaar) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Aanmelden gelukt");
		alert.setContentText(String.format("Speler met naam %s en geboortejaar %d is aangemeld", gebruikersnaam, geboortejaar));
		alert.show();
		
		txfGeboortjaar.clear();
		txfGebruikersnaam.clear();
	}
	
	@FXML
    void btnTerugClicked(ActionEvent event) {
		Stage stage = (Stage) (getScene().getWindow());
		stage.setScene(preMenuScreen.getScene());
    }
	
	@FXML
	void btnStartSpelClicked(ActionEvent event) {
		
		try {
			if(dc.controleerAantalSpelers()) {
				dc.startSpel();
				dc.isStartSpeler();
				dc.isAanDeBeurt();
				
				StartSpelController ssc = new StartSpelController(this, dc);
				Scene scene1 = new Scene(ssc);
				Stage stage1 = (Stage) this.getScene().getWindow();
				stage1.setScene(scene1);
				stage1.show();
				
			}
		}catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Aantal spelers incorrect");
			alert.setContentText(e.getMessage());
			alert.show();
			
			//Stage stage = (Stage) (getScene().getWindow());
			//stage.setScene(this.getScene());
		}
	
	}
}