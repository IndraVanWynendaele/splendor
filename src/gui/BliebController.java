package gui;

import domein.DomeinController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class BliebController extends Pane{
	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	
	@FXML
    private Button button;

    @FXML
    private ImageView view;
    
	public BliebController(AanmeldenController preAanmeldenScreen, DomeinController dc) {
		this.dc = dc;
		this.preAanmeldenScreen=preAanmeldenScreen;
		
		button = new Button();
		view = new ImageView();
		
		view.setImage(new Image(getClass().getResourceAsStream("/images/Edelekaart2.png")));
		button.setGraphic(view);
		
		this.getChildren().addAll(view);
	}
}
