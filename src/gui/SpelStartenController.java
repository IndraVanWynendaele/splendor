package gui;

import java.io.IOException;
import java.util.List;

import domein.DomeinController;
import dtos.SpelerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SpelStartenController extends AnchorPane{

	private DomeinController dc;
	private MenuController preMenuScreen;
	
	@FXML
    private TextArea txaSpelers;
	
	@FXML
    private Button btnTerug;
	
	public SpelStartenController(MenuController preMenuScreen, DomeinController dc) {
		this.preMenuScreen = preMenuScreen;
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("SpelStarten.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		
		try {
			dc.controleerAantalSpelers();
		}catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Aantal spelers incorrect");
			alert.setContentText(e.getMessage());
			alert.show();
			
			
		}
		
		geefSpelersWeer();
		dc.startSpel();
	}
	
	@FXML
    void btnTerugClicked(ActionEvent event) {
		Stage stage = (Stage) (getScene().getWindow());
		stage.setScene(preMenuScreen.getScene());
    }
	
	private void geefSpelersWeer() {
		List<SpelerDTO> spelers = dc.geefSpelerDTOs();
		String uitvoerGeg = "";
		for(SpelerDTO speler: spelers) {
			uitvoerGeg += String.format("%s%n", speler.gebruikersnaam());
		}
		txaSpelers.setText(uitvoerGeg);
	}
}