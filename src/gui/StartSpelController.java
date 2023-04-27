package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;
import domein.Edele;
import domein.EdelsteenAantal;
import domein.Ontwikkelingskaart;
import domein.Speler;
import dtos.SpelerDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class StartSpelController extends StackPane {

	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	private List<Speler> tmpSpelerLijst;
	private int aantalKlik = 0;
	private List<Edele> zichtbareEdelen;
	private List<Ontwikkelingskaart> niveau1, niveau2, niveau3, niveau1Zichtbaar, niveau2Zichtbaar, niveau3Zichtbaar;
	
    public StartSpelController(AanmeldenController preAanmeldenScreen, DomeinController dc) {
		this.dc = dc;
		this.preAanmeldenScreen=preAanmeldenScreen;
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartSpel.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
			toonStartSpelbord();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	private void toonStartSpelbord() {
		zichtbareEdelen = dc.geefEdelenZichtbaar();
		niveau1Zichtbaar = dc.geefOWK1Zichtbaar();
		niveau2Zichtbaar = dc.geefOWK2Zichtbaar();
		niveau3Zichtbaar = dc.geefOWK3Zichtbaar();
		
		List<Button> niveau1Buttons = new ArrayList<>();
		niveau1Buttons.add(btnN1Owk1);
		niveau1Buttons.add(btnN1Owk2);
		niveau1Buttons.add(btnN1Owk3);
		niveau1Buttons.add(btnN1Owk4);
		
		List<Button> niveau2Buttons = new ArrayList<>();
		niveau2Buttons.add(btnN2Owk1);
		niveau2Buttons.add(btnN2Owk2);
		niveau2Buttons.add(btnN2Owk3);
		niveau2Buttons.add(btnN2Owk4);
		
		List<Button> niveau3Buttons = new ArrayList<>();
		niveau3Buttons.add(btnN3Owk1);
		niveau3Buttons.add(btnN3Owk2);
		niveau3Buttons.add(btnN3Owk3);
		niveau3Buttons.add(btnN3Owk4);
		
		// niveau 1
		for (int i = 0; i < niveau1Buttons.size(); i++) {
			ImageView imv = new ImageView();
			imv.setImage(niveau1Zichtbaar.get(i).getImage());	
			imv.setFitHeight(160);
			imv.setFitWidth(125);
			niveau1Buttons.get(i).setGraphic(imv);
			niveau1Buttons.get(i).setOnAction(this::btnNiveau1Clicked);
		}
		
		// niveau 2
		for (int i = 0; i < niveau2Buttons.size(); i++) {
			ImageView imv = new ImageView();
			imv.setImage(niveau2Zichtbaar.get(i).getImage());	
			imv.setFitHeight(160);
			imv.setFitWidth(125);
			niveau2Buttons.get(i).setGraphic(imv);
			niveau2Buttons.get(i).setOnAction(this::btnNiveau2Clicked);
		}
		
		// niveau 3
		for (int i = 0; i < niveau3Buttons.size(); i++) {
			ImageView imv = new ImageView();
			imv.setImage(niveau3Zichtbaar.get(i).getImage());	
			imv.setFitHeight(160);
			imv.setFitWidth(125);
			niveau3Buttons.get(i).setGraphic(imv);
			niveau3Buttons.get(i).setOnAction(this::btnNiveau3Clicked);
		}
		
		lblDiamantSpelAantal.setText(toString(dc.getDiamantAantal().getAantal()));		
		lblOnyxSpelAantal.setText(toString(dc.getOnyxAantal().getAantal()));
	    lblRobijnSpelAantal.setText(toString(dc.getRobijnAantal().getAantal()));
	    lblSmaragdSpelAantal.setText(toString(dc.getSmaragdAantal().getAantal()));
	    lblSaffierSpelAantal.setText(toString(dc.getSaffierAantal().getAantal()));
	}
	
	
	private String toString(int aantal) {
		return String.format("%d", aantal);
	}
	
	private void geefHuidigeSpeler() {
		List<Speler> spelers = dc.getSpelersInSpel();
//		List<ImageView> edeleBezitImv = new ArrayList<>();
//		edeleBezitImv.add(imgEdeleSpeler1);
//		edeleBezitImv.add(imgEdeleSpeler2);
//		edeleBezitImv.add(imgEdeleSpeler3);
//		edeleBezitImv.add(imgEdeleSpeler4);
//		edeleBezitImv.add(imgEdeleSpeler5);
		List<ImageView> niveauBezitImv = new ArrayList<>();
		//imv in
		
		for(Speler s: spelers) {
			List<Ontwikkelingskaart> ok = s.getOntwikkelingskaartenInBezit();
			List<Edele> e = s.getEdelenInBezit();
			if(s.geefIsAanDeBeurt()) {
				lblSpelerNaam.setText(s.getGebruikersnaam());
				lblPrestigepunten.setText(String.format("Prestigepunten: %s",s.getTotaalAantalPrestigePunten()));
				for(EdelsteenAantal ea : s.getEdelsteenfichesInBezit()) {
					switch(ea.getSoort()) {
					case DIAMANT -> lblDiamantSpelerAantal.setText(toString(ea.getAantal()));
					case ONYX -> lblOnyxSpelerAantal.setText(toString(ea.getAantal()));
					case ROBIJN -> lblRobijnSpelerAantal.setText(toString(ea.getAantal()));
					case SAFFIER -> lblSaffierSpelerAantal.setText(toString(ea.getAantal()));
					case SMARAGD -> lblSmaragdSpelerAantal.setText(toString(ea.getAantal()));
					}				    
				}
				List<ImageView> ontwikkelingsKaartenSpeler = new ArrayList<>();
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler1);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler2);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler3);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler4);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler5);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler6);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler7);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler8);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler9);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler10);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler11);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler12);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler13);
				ontwikkelingsKaartenSpeler.add(imgKaartSpeler14);
				
//				// hier kaarten en edelen tonen
//				 for(int i = 0; i < e.size(); i++) {
//					edeleBezitImv.get(i).setImage(e.get(i).getImage());	
//					edeleBezitImv.get(i).setFitHeight(150);
//					edeleBezitImv.get(i).setFitWidth(150);
//				}
				
//				for(int i = 0; i < ok.size(); i++) {
//					ontwikkelingsKaartenSpeler.get(i).setImage(ok.get(i).getImage());	
//					ontwikkelingsKaartenSpeler.get(i).setFitHeight(160);
//					ontwikkelingsKaartenSpeler.get(i).setFitWidth(125);
//				}
			}
		}
	}
	
	private void updateAantalKaarten() {
		if(niveau1.isEmpty())
			stapelNiveau1.setOpacity(0.50);
		if(niveau2.isEmpty())
			stapelNiveau2.setOpacity(0.50);
		if(niveau3.isEmpty())
			stapelNiveau3.setOpacity(0.50);
	}

	@FXML
	void btnVolgendeClicked(ActionEvent event) {
		geefHuidigeSpeler();
		if(tmpSpelerLijst.size()==1) {
			btnVolgende.setDisable(true);
	    	btnStartRonde.setDisable(false);
		}
		tmpSpelerLijst= dc.updateIsAanDeBeurt(tmpSpelerLijst);
	}
	
    @FXML
    void btnStartRondeClicked(ActionEvent event) {
    	geefHuidigeSpeler();
    	aantalKlik++;
        lblRondeNr.setText(String.format("Ronde: %d", aantalKlik));
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
    
    void btnNiveau1Clicked(ActionEvent event) {
    	Button b = (Button) event.getSource();
    	dc.koopKaartNiveau1(GridPane.getColumnIndex(b)-1);
    	toonStartSpelbord();
    	if(dc.getNiveau1().size()==0) {
    		stapelNiveau1.setImage(null);
    	}
    }
    
    void btnNiveau2Clicked(ActionEvent event) {
    	Button b = (Button) event.getSource();
    	dc.koopKaartNiveau2(GridPane.getColumnIndex(b)-1);
    	toonStartSpelbord();
    	if(dc.getNiveau2().size()==0) {
    		stapelNiveau2.setImage(null);
    	}
    }
    
    void btnNiveau3Clicked(ActionEvent event) {
    	Button b = (Button) event.getSource();
    	dc.koopKaartNiveau3(GridPane.getColumnIndex(b)-1);
    	toonStartSpelbord();
    	if(dc.getNiveau3().size()==0) {
    		stapelNiveau3.setImage(null);
    	}
    }
    
    @FXML
    void btnFicheKiezenClicked(ActionEvent event) {

    }

    @FXML
    void btnKaartKopenClicked(ActionEvent event) {

    }
    @FXML
    private ImageView imgKaartSpeler1;

    @FXML
    private ImageView imgKaartSpeler10;

    @FXML
    private ImageView imgKaartSpeler11;

    @FXML
    private ImageView imgKaartSpeler12;

    @FXML
    private ImageView imgKaartSpeler13;

    @FXML
    private ImageView imgKaartSpeler14;

    @FXML
    private ImageView imgKaartSpeler2;

    @FXML
    private ImageView imgKaartSpeler3;

    @FXML
    private ImageView imgKaartSpeler4;

    @FXML
    private ImageView imgKaartSpeler5;

    @FXML
    private ImageView imgKaartSpeler6;

    @FXML
    private ImageView imgKaartSpeler7;

    @FXML
    private ImageView imgKaartSpeler8;

    @FXML
    private ImageView imgKaartSpeler9;
    
    @FXML
    private Button btnDiamantSpel;

    @FXML
    private Button btnDiamantSpeler;

    @FXML
    private Button btnOnyxSpel;

    @FXML
    private Button btnOnyxSpeler;

    @FXML
    private Button btnRobijnSpel;

    @FXML
    private Button btnRobijnSpeler;

    @FXML
    private Button btnSaffierSpel;

    @FXML
    private Button btnSaffierSpeler;

    @FXML
    private Button btnSmaragdSpel;

    @FXML
    private Button btnSmaragdSpeler;

    
    @FXML
    private Button btnStartRonde;

    @FXML
    private Button btnVolgende;

    @FXML
    private Label lblDiamantSpelAantal;

    @FXML
    private Label lblDiamantSpelerAantal;

    @FXML
    private Label lblOnyxSpelAantal;

    @FXML
    private Label lblOnyxSpelerAantal;

    @FXML
    private Label lblRobijnSpelAantal;

    @FXML
    private Label lblRobijnSpelerAantal;

    @FXML
    private Label lblRondeNr;

    @FXML
    private Label lblSaffierSpelAantal;

    @FXML
    private Label lblSaffierSpelerAantal;

    @FXML
    private Label lblSmaragdSpelAantal;

    @FXML
    private Label lblSmaragdSpelerAantal;

    @FXML
    private Label lblSpelerNaam;

    @FXML
    private SplitPane splitPane2;
    
    @FXML
    private Button btnEdele1;

    @FXML
    private Button btnEdele2;

    @FXML
    private Button btnEdele3;

    @FXML
    private Button btnEdele4;

    @FXML
    private Button btnEdele5;

    @FXML
    private Button btnN1Owk1;

    @FXML
    private Button btnN1Owk2;

    @FXML
    private Button btnN1Owk3;

    @FXML
    private Button btnN1Owk4;

    @FXML
    private Button btnN2Owk1;

    @FXML
    private Button btnN2Owk2;

    @FXML
    private Button btnN2Owk3;

    @FXML
    private Button btnN2Owk4;

    @FXML
    private Button btnN3Owk1;

    @FXML
    private Button btnN3Owk2;

    @FXML
    private Button btnN3Owk3;

    @FXML
    private Button btnN3Owk4;
    
    @FXML
    private ImageView stapelNiveau1;

    @FXML
    private ImageView stapelNiveau2;

    @FXML
    private ImageView stapelNiveau3;
    
    @FXML
    private Label lblPrestigepunten;
    
    @FXML
    private ImageView imgEdeleSpeler1;

    @FXML
    private ImageView imgEdeleSpeler2;

    @FXML
    private ImageView imgEdeleSpeler3;

    @FXML
    private ImageView imgEdeleSpeler4;

    @FXML
    private ImageView imgEdeleSpeler5;
    
    @FXML
    private Button btnFicheKiezen;

    @FXML
    private Button btnKaartKopen;

 
    
    @FXML
    void btnDiamantSpelClicked(ActionEvent event) {

    }

    @FXML
    void btnEdele1Clicked(ActionEvent event) {

    }

    @FXML
    void btnEdele2Clicked(ActionEvent event) {

    }

    @FXML
    void btnEdele3Clicked(ActionEvent event) {

    }

    @FXML
    void btnEdele4Clicked(ActionEvent event) {

    }

    @FXML
    void btnEdele5Clicked(ActionEvent event) {

    }

    @FXML
    void btnN1Owk1Clicked(ActionEvent event) {

    }

    @FXML
    void btnN1Owk2Clicked(ActionEvent event) {

    }

    @FXML
    void btnN1Owk3Clicked(ActionEvent event) {

    }

    @FXML
    void btnN1Owk4Clicked(ActionEvent event) {

    }

    @FXML
    void btnN2Owk1Clicked(ActionEvent event) {

    }

    @FXML
    void btnN2Owk2Clicked(ActionEvent event) {

    }

    @FXML
    void btnN2Owk3Clicked(ActionEvent event) {

    }

    @FXML
    void btnN2Owk4Clicked(ActionEvent event) {

    }

    @FXML
    void btnN3Owk1Clicked(ActionEvent event) {

    }

    @FXML
    void btnN3Owk2Clicked(ActionEvent event) {

    }

    @FXML
    void btnN3Owk3Clicked(ActionEvent event) {

    }

    @FXML
    void btnN3Owk4Clicked(ActionEvent event) {

    }

    @FXML
    void btnOnyxSpelClicked(ActionEvent event) {

    }

    @FXML
    void btnRobijnSpelClicked(ActionEvent event) {

    }

    @FXML
    void btnSaffierSpelClicked(ActionEvent event) {

    }

    @FXML
    void btnSmaragdSpelClicked(ActionEvent event) {

    }
}
