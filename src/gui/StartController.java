package gui;

import java.io.IOException;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartController extends AnchorPane{
	private DomeinController dc;	

    @FXML
    private ImageView BGImage;

    @FXML
    private Button btnSpelen;

    @FXML
    private Rectangle kader;

    @FXML
    private Text titelSpel;
	
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
	/*
	public void initialize() {
		BGImage = new ImageView(new Image(getClass().getResourceAsStream("/images/splendor.jpg")));
	}*/
	
	@FXML
    void btnSpelenClicked(ActionEvent event) {
		MenuController ns = new MenuController(this, dc);
		Scene scene = new Scene(ns);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
}