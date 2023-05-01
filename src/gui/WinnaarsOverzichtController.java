package gui;

import domein.DomeinController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class WinnaarsOverzichtController extends StackPane{

	private DomeinController dc;
	
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

    public WinnaarsOverzichtController(DomeinController dc) {
		
	}
	
}
