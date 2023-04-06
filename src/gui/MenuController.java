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
	private StartController preStartScreen;
	
	@FXML
    private ImageView BGImage;

    @FXML
    private Button btnAppStoppen;

    @FXML
    private Button btnOverzichtSpelers;

    @FXML
    private Button btnSpelerAanmelden;

    @FXML
    private Rectangle kader;

    @FXML
    private Label titelSpel;
	
	public MenuController(StartController preStartScreen, DomeinController dc) {
		this.preStartScreen = preStartScreen;
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
		AanmeldenController ac = new AanmeldenController(this, dc);
		Scene scene1 = new Scene(ac);
		Stage stage1 = (Stage) this.getScene().getWindow();
		stage1.setScene(scene1);
		stage1.show();
    }
    
    @FXML
    void btnOverzichtSpelersClicked(ActionEvent event) {
    	OverzichtSpelersController osc = new OverzichtSpelersController(this, dc);
		Scene scene2 = new Scene(osc);
		Stage stage2 = (Stage) this.getScene().getWindow();
		stage2.setScene(scene2);
		stage2.show();
    }
	
    @FXML
    void btnAppStoppenClicked(ActionEvent event) {
    	((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}