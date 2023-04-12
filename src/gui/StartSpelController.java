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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class StartSpelController extends AnchorPane{

	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	private List<Speler> tmpSpelerLijst;
	private int aantalKlik = 0;
	
    @FXML
    private Label lblSpelerNaam;
    
    @FXML
    private Button btnStartRonde;
    
    @FXML
    private Button btnVolgende;
    
    @FXML
    private Label lblRondeNr;
	
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
	
	@FXML
	void btnVolgendeClicked(ActionEvent event) {
		geefNaamHuidigeSpeler();
		if(tmpSpelerLijst.size()==1) {
			btnVolgende.setDisable(true);
	    	btnStartRonde.setDisable(false);
		}
		tmpSpelerLijst= dc.updateIsAanDeBeurt(tmpSpelerLijst);
		
	}
	 
	private void geefNaamHuidigeSpeler() {
		List<Speler> spelers = dc.getSpelersInSpel();
		String spelerNaam = "";
		for(Speler s: spelers) {
			if(s.geefIsAanDeBeurt()) {
				spelerNaam = s.getGebruikersnaam();
			}
		}
		lblSpelerNaam.setText(spelerNaam);
	}
	
    @FXML
    void btnStartRondeClicked(ActionEvent event) {
    	aantalKlik++;
        lblRondeNr.setText(String.format("Ronde: %d", aantalKlik));
    	
    	lblSpelerNaam.setStyle("-fx-background-color: -fx-control-inner-background; -fx-text-fill: #8e0000");
    	lblSpelerNaam.setText(dc.getStartSpeler().getGebruikersnaam());
    	tmpSpelerLijst = new ArrayList<>();
    	for(int i = 0; i < dc.getSpelersInSpel().size();i++) {
    		tmpSpelerLijst.add(dc.getSpelersInSpel().get(i));
    	}
    	dc.isStartSpeler();
    	tmpSpelerLijst = dc.updateIsAanDeBeurt(tmpSpelerLijst);
    	
    	btnVolgende.setDisable(false);
    	btnStartRonde.setDisable(true);
    }
 }
	 

