package gui;

import java.io.File;
import java.io.IOException;

import domein.DomeinController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StartController extends StackPane{
	private DomeinController dc;
	public static MediaPlayer mp;
	
	@FXML
    private ImageView BGImage;

    @FXML
    private Button btnPlay;

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
		
//		String sound = "src/sounds/achtergrondmuziekje.mp3";
//    	Media mediaSound = new Media(new File(sound).toURI().toString());
//    	mp = new MediaPlayer(mediaSound);
//    	mp.play();
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@FXML
    void btnSpelenClicked(ActionEvent event) {
		MenuController mc = new MenuController(this, dc);
		Scene scene = new Scene(mc);
		Stage stage = (Stage) this.getScene().getWindow();
		stage.setScene(scene);
		stage.setMinWidth(600);
	    stage.setMinHeight(586);
		stage.show();
    }
	
	@FXML
    void btnPlayClicked(ActionEvent event) {
		dc.setWordtVertaald(true);
		btnSpelenClicked(event);
    }
}