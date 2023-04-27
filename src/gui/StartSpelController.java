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
import util.EdelsteenSoort;

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
		
		List<ImageView> edeleImv = new ArrayList<>();
		edeleImv.add(imvEdele1);
		edeleImv.add(imvEdele2);
		edeleImv.add(imvEdele3);
		edeleImv.add(imvEdele4);
		edeleImv.add(imvEdele5);
		
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
		
		// edele
		for (int i = 0; i < zichtbareEdelen.size(); i++) {
            edeleImv.get(i).setImage(zichtbareEdelen.get(i).getImage());
        }
		
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
		updateAantalFichesSpel();
	}
	
	private void updateAantalFichesSpel() {
		lblDiamantSpelAantal.setText(toString(dc.getDiamantAantal().getAantal()));		
		lblOnyxSpelAantal.setText(toString(dc.getOnyxAantal().getAantal()));
	    lblRobijnSpelAantal.setText(toString(dc.getRobijnAantal().getAantal()));
	    lblSmaragdSpelAantal.setText(toString(dc.getSmaragdAantal().getAantal()));
	    lblSaffierSpelAantal.setText(toString(dc.getSaffierAantal().getAantal()));
	}
	
	private void updateAantalFichesSpeler() {//dit werkt well!!
		List<Speler> spelers = dc.getSpelersInSpel();
		for(Speler s: spelers) {
			if(s.geefIsAanDeBeurt()) {
				for(EdelsteenAantal ea : s.getEdelsteenfichesInBezit()) {
					switch(ea.getSoort()) {
					case DIAMANT -> lblDiamantSpelerAantal.setText(toString(ea.getAantal()));
					case ONYX -> lblOnyxSpelerAantal.setText(toString(ea.getAantal()));
					case ROBIJN -> lblRobijnSpelerAantal.setText(toString(ea.getAantal()));
					case SAFFIER -> lblSaffierSpelerAantal.setText(toString(ea.getAantal()));
					case SMARAGD -> lblSmaragdSpelerAantal.setText(toString(ea.getAantal()));
					}				    
				}
			}
		}
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
			
//			// hier kaarten en edelen tonen
//			 for(int i = 0; i < e.size(); i++) {
//				edeleBezitImv.get(i).setImage(e.get(i).getImage());	
//				edeleBezitImv.get(i).setFitHeight(150);
//				edeleBezitImv.get(i).setFitWidth(150);
//			}
//		
//			for(int i = 0; i < ok.size(); i++) {
//				ontwikkelingsKaartenSpeler.get(i).setImage(ok.get(i).getImage());	
//				ontwikkelingsKaartenSpeler.get(i).setFitHeight(160);
//				ontwikkelingsKaartenSpeler.get(i).setFitWidth(125);
//			}
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
	
	private void knoppenDisable() {
		btnDiamantSpel.setDisable(true);	
    	btnOnyxSpel.setDisable(true);   	
    	btnRobijnSpel.setDisable(true);    	
    	btnSaffierSpel.setDisable(true);
    	btnSmaragdSpel.setDisable(true);
	}

	@FXML
	void btnVolgendeClicked(ActionEvent event) {
		geefHuidigeSpeler();
		if(tmpSpelerLijst.size()==1) {
			btnVolgende.setDisable(true);
	    	btnStartRonde.setDisable(false);
		}
		
		tmpSpelerLijst= dc.updateIsAanDeBeurt(tmpSpelerLijst);
		btnFicheKiezen.setDisable(false);
	
		knoppenDisable();
		updateAantalFichesSpeler();// dit staat op de juiste plek AFBLIJVEN
	}
	
    @FXML
    void btnStartRondeClicked(ActionEvent event) {
    	geefHuidigeSpeler();
    	aantalKlik++;
        lblRondeNr.setText(String.format("Ronde: %d", aantalKlik));
    	lblSpelerNaam.setText(dc.getStartSpeler().getGebruikersnaam());
    	tmpSpelerLijst = new ArrayList<>();
    	for(int i = 0; i < dc.getSpelersInSpel().size();i++) {
//    		/**/if(dc.getSpelersInSpel().get(i).getGebruikersnaam()==dc.getStartSpeler().getGebruikersnaam())break;
    		tmpSpelerLijst.add(dc.getSpelersInSpel().get(i));
    		// Het probleem is dat we hier (lijn 247) al runnen waardoor dat Indra uit de lijst is
    		// (dat is goed) maar waardoor Anke al achter de schermen de huidigspeler is
    		// met andere woorden, we moeten dus heel dit ding opnieuw maken
    		
    		// indra --> ziet anke haar spelerbord (je voegd fiches toe als het op indra staat)
    		// anke --> ziet youna haar spelerbord (je voegd fiches toe als het op anke staat)
    		// youna --> ziet lara haar spelerbord (je voegd fiches toe als het op youna staat)
    		// en lara --> ziet haar eige spelerbord (je voegd fiches toe als het op lara staat)
    		
    		// indra heeft geen speelerbord
    	}
    	dc.isStartSpeler();
    	tmpSpelerLijst = dc.updateIsAanDeBeurt(tmpSpelerLijst);
    	
    	btnFicheKiezen.setDisable(false);
    	if(aantalKlik > 1) {
    		btnKaartKopen.setDisable(false);
    		
    	}
    	
    	btnVolgende.setDisable(false);
    	btnStartRonde.setDisable(true);
    	knoppenDisable();
    	updateAantalFichesSpeler();
    }
    
    @FXML
    void btnFicheKiezenClicked(ActionEvent event) {   	
    	btnDiamantSpel.setDisable(false);
    	btnDiamantSpel.setOnAction(this::btnFicheClicked);
    	
    	btnOnyxSpel.setDisable(false);
    	btnOnyxSpel.setOnAction(this::btnFicheClicked);
    	
    	btnRobijnSpel.setDisable(false);
    	btnRobijnSpel.setOnAction(this::btnFicheClicked);;
    	
    	btnSaffierSpel.setDisable(false);
    	btnSaffierSpel.setOnAction(this::btnFicheClicked);
    	
    	btnSmaragdSpel.setDisable(false);
    	btnSmaragdSpel.setOnAction(this::btnFicheClicked);
    }
    
    void btnFicheClicked(ActionEvent event) {
    	int kolom;
    	Button b = (Button) event.getSource();
    	
    	if(GridPane.getColumnIndex(b) == null)
    		kolom = 0;
    	else
    		kolom = GridPane.getColumnIndex(b);
    	
    	switch(kolom) {
    	case 0 ->{
    		dc.neemEdelsteenaantal(new EdelsteenAantal(1, EdelsteenSoort.SMARAGD));
    		dc.getSmaragdAantal().setAantal(dc.getSmaragdAantal().getAantal() - 1);
    	}
    	case 1 -> {
    		dc.neemEdelsteenaantal(new EdelsteenAantal(1, EdelsteenSoort.ONYX));
    		dc.getOnyxAantal().setAantal(dc.getOnyxAantal().getAantal() - 1);
    	}
    	case 2 -> {
    		dc.neemEdelsteenaantal(new EdelsteenAantal(1, EdelsteenSoort.DIAMANT));
    		dc.getDiamantAantal().setAantal(dc.getDiamantAantal().getAantal() - 1);
    	}
    	case 3 -> {
    		dc.neemEdelsteenaantal(new EdelsteenAantal(1, EdelsteenSoort.SAFFIER));
    		dc.getSaffierAantal().setAantal(dc.getSaffierAantal().getAantal() - 1);
    	}
    	case 4 -> {
    		dc.neemEdelsteenaantal(new EdelsteenAantal(1, EdelsteenSoort.ROBIJN));
    		dc.getRobijnAantal().setAantal(dc.getRobijnAantal().getAantal() - 1);
    	}
    	}
    	updateAantalFichesSpel();
    	updateAantalFichesSpeler();
    }

    @FXML
    void btnKaartKopenClicked(ActionEvent event) {

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
    private Button btnDiamantSpel;

    @FXML
    private Button btnFicheKiezen;

    @FXML
    private Button btnKaartKopen;

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
    private Button btnOnyxSpel;

    @FXML
    private Button btnRobijnSpel;

    @FXML
    private Button btnSaffierSpel;

    @FXML
    private Button btnSmaragdSpel;

    @FXML
    private Button btnStartRonde;

    @FXML
    private Button btnVolgende;

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
    private ImageView imvEdele1;

    @FXML
    private ImageView imvEdele2;

    @FXML
    private ImageView imvEdele3;

    @FXML
    private ImageView imvEdele4;

    @FXML
    private ImageView imvEdele5;

    @FXML
    private Label lblDiamantSpelAantal;

    @FXML
    private Label lblDiamantSpelerAantal;

    @FXML
    private Label lblOnyxSpelAantal;

    @FXML
    private Label lblOnyxSpelerAantal;

    @FXML
    private Label lblPrestigepunten;

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
    private ImageView stapelNiveau1;

    @FXML
    private ImageView stapelNiveau2;

    @FXML
    private ImageView stapelNiveau3;

 
    
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
