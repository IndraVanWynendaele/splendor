package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StartSpelController extends BorderPane{

	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	
	 @FXML
	 private ImageView BGImage;
	
	 public StartSpelController(AanmeldenController preAanmeldenScreen, DomeinController dc) {
		 this.dc = dc;
		 this.preAanmeldenScreen=preAanmeldenScreen;
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StartSpel.fxml"));//SpelStarten
			loader.setRoot(this);
			loader.setController(this);
			
			try {
				loader.load();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
	 }
 }
	 

