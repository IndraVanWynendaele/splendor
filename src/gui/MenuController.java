package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MenuController extends GridPane{
	
	private DomeinController dc;
	private StartController preScreen;
	
	@FXML
    private ImageView BGImage;

    @FXML
    private Button btnAppStoppen;

    @FXML
    private Button btnSpelStarten;

    @FXML
    private Button btnSpelerAanmelden;

    @FXML
    private Rectangle kader;

    @FXML
    private Label titelSpel;
	
	public MenuController(StartController preScreen, DomeinController dc) {
		this.preScreen = preScreen;
		this.dc = dc;
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@FXML
    void btnSpelerAanmeldenClicked(ActionEvent event) {
		AanmeldenController ns = new AanmeldenController(this, dc);
		Scene scene = new Scene(ns);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
    
    @FXML
    void btnSpelStartenClicked(ActionEvent event) {
    	SpelStartenController ns = new SpelStartenController(this, dc);
		Scene scene = new Scene(ns);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
	
    @FXML
    void btnAppStoppenClicked(WindowEvent event) {
    	btnAppStoppen.setOnAction(e -> Platform.exit());
    }
}