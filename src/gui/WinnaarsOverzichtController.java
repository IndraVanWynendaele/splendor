package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class WinnaarsOverzichtController extends StackPane{

	private DomeinController dc;
	private StartSpelController preStartSpelScreen;
	
	@FXML
    private Label prestSpeler1;

    @FXML
    private Label prestSpeler2;

    @FXML
    private Label prestSpeler3;

    @FXML
    private Label prestSpeler4;

    @FXML
    private Label speler1;

    @FXML
    private Label speler2;

    @FXML
    private Label speler3;

    @FXML
    private Label speler4;

    public WinnaarsOverzichtController(StartSpelController preStartSpelScreen, DomeinController dc) {
    	this.preStartSpelScreen = preStartSpelScreen;
    	this.dc = dc;
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("WinnaarsOverzicht.fxml"));
    	loader.setRoot(this);
    	loader.setController(this);
    	
    	try {
    		loader.load();
    	}catch (IOException ex) {
    		throw new RuntimeException(ex);
    	}
	}
	
}
