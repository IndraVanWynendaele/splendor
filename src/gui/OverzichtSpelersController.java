package gui;

import java.io.IOException;
import java.util.List;

import domein.DomeinController;
import dtos.SpelerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class OverzichtSpelersController extends StackPane{

	private DomeinController dc;
	private MenuController preMenuScreen;
	
	@FXML
    private TextArea txaSpelers;
	
	@FXML
    private Button btnTerug;
	
	public OverzichtSpelersController(MenuController preMenuScreen, DomeinController dc) {
		this.preMenuScreen = preMenuScreen;
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("OverzichtSpelers.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		try {
			geefSpelersWeer();
			if(dc.controleerAantalSpelers()) {
				dc.startSpel();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Spel gestart");
				alert.setContentText("Aantal spelers correct & spel is aangemaakt!");
				alert.show();
			}
		}catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Aantal spelers incorrect");
			alert.setContentText(e.getMessage());
			alert.show();
		}
	}
	
	@FXML
    void btnTerugClicked(ActionEvent event) {
		Stage stage = (Stage) (getScene().getWindow());
		stage.setScene(preMenuScreen.getScene());
    }
	
	private void geefSpelersWeer() {
		List<SpelerDTO> spelers = dc.geefSpelerDTO();
		String uitvoerGeg = "";
		for(SpelerDTO speler: spelers) {
			uitvoerGeg += String.format("%s%n", speler.gebruikersnaam());
		}
		txaSpelers.setText(uitvoerGeg);
	}
}