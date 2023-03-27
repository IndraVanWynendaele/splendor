package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class SpelStartenController extends GridPane{

	private DomeinController dc;
	private MenuController preMenuScreen;
	
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
}