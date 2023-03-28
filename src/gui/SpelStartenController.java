package gui;

import java.io.IOException;
import java.util.List;

import domein.DomeinController;
import dtos.SpelerDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class SpelStartenController extends AnchorPane{

	private DomeinController dc;
	private MenuController preMenuScreen;
	
	@FXML
    private TextArea txaSpelers;
	
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