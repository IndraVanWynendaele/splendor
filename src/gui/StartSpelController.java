package gui;

import java.io.IOException;
import java.util.ArrayList;
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
	private List<Speler> tmpSpelerLijst;
	
    @FXML
    public TextField txfSpelerNaam;
    
    @FXML
    private Button btnStartRonde;
    
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
		geefNaamHuidigeSpeler();
		dc.updateIsAanDeBeurt(tmpSpelerLijst);
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
    void btnStartRondeClicked(ActionEvent event) {
    	txfSpelerNaam.setStyle("-fx-background-color: -fx-control-inner-background");
    	txfSpelerNaam.setText(dc.getStartSpeler().getGebruikersnaam());
    	tmpSpelerLijst = new ArrayList<>();
    	for(int i = 0; i < dc.getSpelersInSpel().size();i++) {
    		tmpSpelerLijst.add(dc.getSpelersInSpel().get(i));
    	}
    	tmpSpelerLijst = dc.updateIsAanDeBeurt(tmpSpelerLijst);
    	
    }
 }
	 

