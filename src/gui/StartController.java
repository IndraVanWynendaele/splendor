package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class StartController extends AnchorPane{
	private DomeinController dc;
	
	public StartController(DomeinController dc) {
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
}