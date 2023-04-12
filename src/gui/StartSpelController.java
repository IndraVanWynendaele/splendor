package gui;

import java.io.IOException;
import java.util.List;

import domein.DomeinController;
import domein.Speler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class StartSpelController extends AnchorPane{

	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	
    @FXML
    public TextField txfSpelerNaam;
    
    @FXML
    private Button btnStart;
    
    @FXML
    private Button btnVolgende;
	
	public StartSpelController(AanmeldenController preAanmeldenScreen, DomeinController dc) {
		this.dc = dc;
		this.preAanmeldenScreen=preAanmeldenScreen;
		txfSpelerNaam = new TextField();
		
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartSpel.fxml"));//SpelStarten
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	@FXML
	void btnVolgendeClicked(ActionEvent event) {
		dc.updateIsAanDeBeurt();
		geefNaamHuidigeSpeler();
	}
	 
	private void geefNaamHuidigeSpeler() {
		List<Speler> spelers = dc.getSpelersInSpel();
		String spelerNaam = "";
		for(Speler s: spelers) {
			if(s.geefIsAanDeBeurt()) {
				spelerNaam = s.getGebruikersnaam();
			}
		}
		txfSpelerNaam.setText(spelerNaam);
	}
	
    @FXML
    void btnStartClicked(ActionEvent event) {
    	txfSpelerNaam.setStyle("-fx-background-color: -fx-control-inner-background");
    	txfSpelerNaam.setText(dc.getStartSpeler().getGebruikersnaam());
    	txfSpelerNaam.deselect();
    	btnStart.setVisible(false);
    }
 }
	 

