package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AanmeldenController extends GridPane{

	private DomeinController dc;
	private MenuController preScreen;
	
	public AanmeldenController(MenuController preScreen, DomeinController dc) {
		this.preScreen = preScreen;
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
}