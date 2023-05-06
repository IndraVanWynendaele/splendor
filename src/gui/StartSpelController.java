package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import domein.DomeinController;
import domein.Edele;
import domein.EdelsteenAantal;
import domein.Ontwikkelingskaart;
import domein.Speler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import util.EdelsteenSoort;

public class StartSpelController extends StackPane {

	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	private List<Speler> tmpSpelerLijst;
	private int aantalKlik = 0;
	private List<Edele> zichtbareEdelen;
	private List<Ontwikkelingskaart> niveau1, niveau2, niveau3, niveau1Zichtbaar, niveau2Zichtbaar, niveau3Zichtbaar;
//	private ResourceBundle rb;
	
    public StartSpelController(AanmeldenController preAanmeldenScreen, DomeinController dc) {
		this.dc = dc;
		this.preAanmeldenScreen=preAanmeldenScreen;
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartSpel.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
			toonStartSpelbord();
//			rb = dc.getRb();
			
			btnFicheKiezen.setText(DomeinController.getText("btnFicheKiezen"));
			btnKaartKopen.setText(DomeinController.getText("btnKaartKopen"));
			btnStartRonde.setText(DomeinController.getText("btnStartRonde"));
			btnVolgende.setText(DomeinController.getText("btnVolgende"));
			
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
			if(dc.getNiveau1().size()==0) {
				if(stapelNiveau1.getImage() == null)
					if(niveau1Buttons.get(i).getGraphic() == null)
						niveau1Buttons.get(i).setGraphic(null);
			}
			else
				niveau1Buttons.get(i).setGraphic(imv);
		}
		
		// niveau 2
		for (int i = 0; i < niveau2Buttons.size(); i++) {
			ImageView imv = new ImageView();
			imv.setImage(niveau2Zichtbaar.get(i).getImage());	
			imv.setFitHeight(160);
			imv.setFitWidth(125);
			if(dc.getNiveau2().size()==0) {
				if(stapelNiveau2.getImage() == null)
					if(niveau2Buttons.get(i).getGraphic() == null)
						niveau2Buttons.get(i).setGraphic(null);
			}
			else
				niveau2Buttons.get(i).setGraphic(imv);
		}
		
		// niveau 3
		for (int i = 0; i < niveau3Buttons.size(); i++) {
			ImageView imv = new ImageView();
			imv.setImage(niveau3Zichtbaar.get(i).getImage());	
			imv.setFitHeight(160);
			imv.setFitWidth(125);
			if(dc.getNiveau3().size()==0) {
				if(stapelNiveau3.getImage() == null)
					if(niveau3Buttons.get(i).getGraphic() == null)
						niveau3Buttons.get(i).setGraphic(null);
			}
			else
				niveau3Buttons.get(i).setGraphic(imv);
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
	
	private void updateAantalFichesSpeler() {
		List<Speler> spelers = dc.getSpelersInSpel();
		for(Speler s: spelers) {
			if(s.geefIsAanDeBeurt()) {
				lblPrestigepunten.setText(String.format("%s: %s", DomeinController.getText("lblPrestigepunten"), s.getTotaalAantalPrestigePunten()));
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
	
	private void updateSpelerOntwikkelingskaarten() {
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
		
		List<Speler> spelers = dc.getSpelersInSpel();
		for(Speler s: spelers) {
			if(s.geefIsAanDeBeurt()) {
				lblPrestigepunten.setText(String.format("%s: %s", DomeinController.getText("lblPrestigepunten"), s.getTotaalAantalPrestigePunten()));
				List<Ontwikkelingskaart> ok = s.getOntwikkelingskaartenInBezit();
				for(int i= 0; i < ontwikkelingsKaartenSpeler.size(); i++) {
					ontwikkelingsKaartenSpeler.get(i).setImage(null);
				}
				
				for(int i = 0; i < ok.size(); i++) {
					ontwikkelingsKaartenSpeler.get(i).setImage(ok.get(i).getImage());	
					ontwikkelingsKaartenSpeler.get(i).setFitHeight(160);
					ontwikkelingsKaartenSpeler.get(i).setFitWidth(125);
				}
			}
		}
	}
	
	private void updateEdele() {
		
		List<ImageView> edeleBezitImv = new ArrayList<>();
		edeleBezitImv.add(imgEdeleSpeler1);
		edeleBezitImv.add(imgEdeleSpeler2);
		edeleBezitImv.add(imgEdeleSpeler3);
		edeleBezitImv.add(imgEdeleSpeler4);
		edeleBezitImv.add(imgEdeleSpeler5);
		 
		 List<Speler> spelers = dc.getSpelersInSpel();
			for(Speler s: spelers) {
				if(s.geefIsAanDeBeurt()) {
					List<Edele> e = s.getEdelenInBezit();
					for(int i = 0; i < e.size(); i++) {
						edeleBezitImv.get(i).setImage(e.get(i).getImage());	
						edeleBezitImv.get(i).setFitHeight(150);
						edeleBezitImv.get(i).setFitWidth(150);
					}
					
				}
				
			}
		// for lijst edelen in bezit
		// for lijst zichbare edelen
		// if bonus edelen spel == bonus edelen speler
		// remove image edele spel ??
	}
		
	private String toString(int aantal) {
		return String.format("%d", aantal);
	}
	
	private void geefHuidigeSpeler() {
		List<Speler> spelers = dc.getSpelersInSpel();
		
		List<ImageView> edeleBezitImv = new ArrayList<>();
		edeleBezitImv.add(imgEdeleSpeler1);
		edeleBezitImv.add(imgEdeleSpeler2);
		edeleBezitImv.add(imgEdeleSpeler3);
		edeleBezitImv.add(imgEdeleSpeler4);
		edeleBezitImv.add(imgEdeleSpeler5);
		
		List<ImageView> niveauBezitImv = new ArrayList<>();
		niveauBezitImv.add(imgKaartSpeler1);
		niveauBezitImv.add(imgKaartSpeler2);
		niveauBezitImv.add(imgKaartSpeler3);
		niveauBezitImv.add(imgKaartSpeler4);
		niveauBezitImv.add(imgKaartSpeler5);
		niveauBezitImv.add(imgKaartSpeler6);
		niveauBezitImv.add(imgKaartSpeler7);
		niveauBezitImv.add(imgKaartSpeler8);
		niveauBezitImv.add(imgKaartSpeler9);
		niveauBezitImv.add(imgKaartSpeler10);
		niveauBezitImv.add(imgKaartSpeler11);
		niveauBezitImv.add(imgKaartSpeler12);
		niveauBezitImv.add(imgKaartSpeler13);
		niveauBezitImv.add(imgKaartSpeler14);
		
		for(Speler s: spelers) {
			List<Ontwikkelingskaart> ok = s.getOntwikkelingskaartenInBezit();
			List<Edele> e = s.getEdelenInBezit();
			if(s.geefIsAanDeBeurt()) {
				lblSpelerNaam.setText(s.getGebruikersnaam());
				lblPrestigepunten.setText(String.format("%s: %s", DomeinController.getText("lblPrestigepunten"), s.getTotaalAantalPrestigePunten()));
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
			
			// hier kaarten en edelen tonen
			for(int i = 0; i < edeleBezitImv.size(); i ++) {
				edeleBezitImv.get(i).setImage(null);
			}
			for(int i = 0; i < e.size(); i++) {
				edeleBezitImv.get(i).setImage(e.get(i).getImage());	
				edeleBezitImv.get(i).setFitHeight(150);
				edeleBezitImv.get(i).setFitWidth(150);
			}
			 
			if(ok.size()!=0)
                for(int i = 0; i < ok.size(); i++) {
                    ontwikkelingsKaartenSpeler.get(i).setImage(ok.get(i).getImage());
                    ontwikkelingsKaartenSpeler.get(i).setFitHeight(160);
                    ontwikkelingsKaartenSpeler.get(i).setFitWidth(125);
            } 
		}
	}
		
	private void knoppenDisable() {
		//edelsteenfiches
		btnDiamantSpel.setDisable(true);	
    	btnOnyxSpel.setDisable(true);   	
    	btnRobijnSpel.setDisable(true);    	
    	btnSaffierSpel.setDisable(true);
    	btnSmaragdSpel.setDisable(true);
    	
    	//ontwikkelingskaarten
    	btnN1Owk1.setDisable(true);
        btnN1Owk2.setDisable(true);
        btnN1Owk3.setDisable(true);
        btnN1Owk4.setDisable(true);
        btnN2Owk1.setDisable(true);
        btnN2Owk2.setDisable(true);
        btnN2Owk3.setDisable(true);
        btnN2Owk4.setDisable(true);
        btnN3Owk1.setDisable(true);
        btnN3Owk2.setDisable(true);
        btnN3Owk3.setDisable(true);
        btnN3Owk4.setDisable(true);
	}

	@FXML
	void btnVolgendeClicked(ActionEvent event) {
		tmpSpelerLijst = dc.updateIsAanDeBeurt(tmpSpelerLijst);
		geefHuidigeSpeler();
//		if(tmpSpelerLijst.size()==1) {
//			btnVolgende.setDisable(true);
//	    	btnStartRonde.setDisable(false);
//	    	if(dc.isEindeSpel()) {
//	    		WinnaarsOverzichtController woc = new WinnaarsOverzichtController(this, dc);
//	    		Scene scene1 = new Scene(woc);
//	    		Stage stage1 = (Stage) this.getScene().getWindow();
//	    		stage1.setScene(scene1);
//	    		stage1.setMinHeight(600);
//	    		stage1.setMinWidth(600);
//	    		stage1.setMaxHeight(600);
//	    		stage1.setMaxWidth(600);
//	    		stage1.show();
//	    	}
//		}
		btnFicheKiezen.setDisable(false);
		if(aantalKlik > 1)
    		btnKaartKopen.setDisable(false);
			
		knoppenDisable();
		updateAantalFichesSpeler();
		updateSpelerOntwikkelingskaarten();// dit staat op de juiste plek AFBLIJVEN
		if(tmpSpelerLijst.size()==1) {
			btnVolgende.setDisable(true);
	    	btnStartRonde.setDisable(false);
		}
		
	}
	
    @FXML
    void btnStartRondeClicked(ActionEvent event) {
    	aantalKlik++; 
		lblRondeNr.setText(String.format("%s: %d",DomeinController.getText("lblRondeNr"), aantalKlik));
    	lblSpelerNaam.setText(dc.getStartSpeler().getGebruikersnaam());
    	tmpSpelerLijst = new ArrayList<>();
    	for(int i = 0; i < dc.getSpelersInSpel().size();i++) {
    		tmpSpelerLijst.add(dc.getSpelersInSpel().get(i));
    	}
    	dc.resetSpelers();
    	tmpSpelerLijst = dc.updateIsAanDeBeurt(tmpSpelerLijst);
    	
    	btnFicheKiezen.setDisable(false);
    	if(aantalKlik > 1)
    		btnKaartKopen.setDisable(false);

    	if(dc.isEindeSpel()) {
    		WinnaarsOverzichtController woc = new WinnaarsOverzichtController(this, dc);
    		Scene scene1 = new Scene(woc);
    		Stage stage1 = (Stage) this.getScene().getWindow();
    		stage1.setScene(scene1);
    		stage1.setMinHeight(600);
    		stage1.setMinWidth(600);
    		stage1.setMaxHeight(600);
    		stage1.setMaxWidth(600);
    		stage1.show();
    	}
    	
    	geefHuidigeSpeler();
    	btnVolgende.setDisable(false);
    	btnStartRonde.setDisable(true);
    	knoppenDisable();
    	updateAantalFichesSpeler();
    }
    
    @FXML
    void btnFicheKiezenClicked(ActionEvent event) {
    	btnKaartKopen.setDisable(true);
    	
    	btnDiamantSpel.setDisable(false);
    	btnDiamantSpel.setOnAction(this::btnFicheClicked);    	
    	btnOnyxSpel.setDisable(false);
    	btnOnyxSpel.setOnAction(this::btnFicheClicked);    	
    	btnRobijnSpel.setDisable(false);
    	btnRobijnSpel.setOnAction(this::btnFicheClicked);    	
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
    	EdelsteenSoort soort = switch(kolom) {
    	case 0 -> EdelsteenSoort.SMARAGD;
    	case 1 -> EdelsteenSoort.ONYX;
    	case 2 -> EdelsteenSoort.DIAMANT;
    	case 3 -> EdelsteenSoort.SAFFIER;
    	case 4 -> EdelsteenSoort.ROBIJN;
		default -> throw new IllegalArgumentException(DomeinController.getText("btnFicheClicked1") + kolom);
    	};

    	List<EdelsteenAantal> tmpLijstSpeler = dc.getTmpLijstSpeler();
 
    	try {
    		
    		 if(!dc.controleerHoeveelheidFichesNemen(new EdelsteenAantal(1, soort))) {
	    		knoppenDisable();
	    		dc.voegTmpLijstFichesToeAanPermLijst();
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setTitle(DomeinController.getText("controleerAlDrieFichesGekozen1"));
	    		alert.setContentText(DomeinController.getText("controleerAlDrieFichesGekozen2"));
	    		alert.show();
	    	}
	    	else {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setTitle(DomeinController.getText("btnFicheClicked2"));	
	    		alert.setContentText(String.format(DomeinController.getText("btnFicheClicked3"), soort.toString().toLowerCase()));
	    		alert.showAndWait();
	    	}
	    	
	    	// vergeet niet size == 2 moet nog gedaan w
	    	
    	}catch(IllegalArgumentException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(DomeinController.getText("btnFicheClicked4"));
			alert.setContentText(e.getMessage());
			alert.show();
    	}
    	controleerAlDrieFichesGekozen();
    	if(tmpLijstSpeler.size() == 2) {
    		controleerAlTweeGelijkeFichesGekozen();
    	}
    	updateAantalFichesSpel();
    	updateAantalFichesSpeler();
    	
    }
    
    private void controleerAlDrieFichesGekozen() {
    	List<EdelsteenAantal> tmpLijstSpeler = dc.getTmpLijstSpeler();
    	if(tmpLijstSpeler.size() == 3) {
			knoppenDisable();
    		dc.voegTmpLijstFichesToeAanPermLijst();
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle(DomeinController.getText("controleerAlDrieFichesGekozen1"));
    		alert.setContentText(DomeinController.getText("controleerAlDrieFichesGekozen2"));
    		alert.show();
    		btnFicheKiezen.setDisable(true);
		}
    }
    
    private void controleerAlTweeGelijkeFichesGekozen() {
    	if(dc.controleerAlTweeGelijkeFichesGekozen()) {
    		knoppenDisable();
    		dc.voegTmpLijstFichesToeAanPermLijst();
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle(DomeinController.getText("controleerAlDrieFichesGekozen1"));
    		alert.setContentText(DomeinController.getText("controleerAlDrieFichesGekozen2"));
    		alert.show();
    		btnFicheKiezen.setDisable(true);
    	}
    }
    

    @FXML
    void btnKaartKopenClicked(ActionEvent event) {
    	btnFicheKiezen.setDisable(true);
    	
    	btnN1Owk1.setDisable(false);
    	btnN1Owk1.setOnAction(this::btnNiveau1Clicked);
        btnN1Owk2.setDisable(false);
        btnN1Owk2.setOnAction(this::btnNiveau1Clicked);
        btnN1Owk3.setDisable(false);
        btnN1Owk3.setOnAction(this::btnNiveau1Clicked);
        btnN1Owk4.setDisable(false);
        btnN1Owk4.setOnAction(this::btnNiveau1Clicked);
        
        btnN2Owk1.setDisable(false);
        btnN2Owk1.setOnAction(this::btnNiveau2Clicked);
        btnN2Owk2.setDisable(false);
        btnN2Owk2.setOnAction(this::btnNiveau2Clicked);
        btnN2Owk3.setDisable(false);
        btnN2Owk3.setOnAction(this::btnNiveau2Clicked);
        btnN2Owk4.setDisable(false);
        btnN2Owk4.setOnAction(this::btnNiveau2Clicked);
        
        btnN3Owk1.setDisable(false);
        btnN3Owk1.setOnAction(this::btnNiveau3Clicked);
        btnN3Owk2.setDisable(false);
        btnN3Owk2.setOnAction(this::btnNiveau3Clicked);
        btnN3Owk3.setDisable(false);
        btnN3Owk3.setOnAction(this::btnNiveau3Clicked);
        btnN3Owk4.setDisable(false);
        btnN3Owk4.setOnAction(this::btnNiveau3Clicked);
    }
    
    void btnNiveau1Clicked(ActionEvent event) {
    	Button b = (Button) event.getSource();
    	try {
    		dc.koopKaartNiveau1(GridPane.getColumnIndex(b)-1);
        	toonStartSpelbord();
        	updateAantalFichesSpeler();
        	updateSpelerOntwikkelingskaarten();
        	if(dc.getNiveau1().size()==0) {
        		if(stapelNiveau1.getImage() == null)
        			b.setGraphic(null);
        		stapelNiveau1.setImage(null);
        	}
        	if(dc.controleerMogelijkheidTotEdelen()) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle(DomeinController.getText("btnNiveauClicked1"));
        		alert.show();
        		updateEdele();
        	}
//        	else if(dc.controleerMogelijkheidTotEdelen() > 1) {
//        		Popup popup = new Popup();
//        		for(Edele edele : dc.geefBeschikbareEdelen()) {
//        			ImageView imv = new ImageView();
//        			imv.setImage(edele.getImage());
//        			popup.getContent().addAll(imv);
//        		}
//        	}
    	}catch(IllegalArgumentException e) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(DomeinController.getText("btnNiveauClicked2"));
			alert.setContentText(e.getMessage());
			alert.show();
    	}
    }

	void btnNiveau2Clicked(ActionEvent event) {
    	Button b = (Button) event.getSource();
    	try {
    		dc.koopKaartNiveau2(GridPane.getColumnIndex(b)-1);
        	toonStartSpelbord();
        	updateAantalFichesSpeler();
        	updateSpelerOntwikkelingskaarten();
        	if(dc.getNiveau2().size()==0) {
        		if(stapelNiveau2.getImage() == null)
        			b.setGraphic(null);
        		stapelNiveau2.setImage(null);
        	}
        	if(dc.controleerMogelijkheidTotEdelen()) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle(DomeinController.getText("btnNiveauClicked1"));
        		alert.show();
        		updateEdele();
        	}
    	}catch(IllegalArgumentException e) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(DomeinController.getText("btnNiveauClicked2"));
			alert.setContentText(e.getMessage());
			alert.show();
    	}
    }
    
    void btnNiveau3Clicked(ActionEvent event) {
    	Button b = (Button) event.getSource();
    	try {
    		dc.koopKaartNiveau3(GridPane.getColumnIndex(b)-1);
        	toonStartSpelbord();
        	updateAantalFichesSpeler();
        	updateSpelerOntwikkelingskaarten();
        	if(dc.getNiveau3().size()==0) {
        		if(stapelNiveau3.getImage() == null)
        			b.setGraphic(null);
        		stapelNiveau3.setImage(null);
        	}
        	if(dc.controleerMogelijkheidTotEdelen()) {
        		Alert alert = new Alert(AlertType.INFORMATION);
        		alert.setTitle(DomeinController.getText("btnNiveauClicked1"));
        		alert.show();
        		updateEdele();
        	}
    	}catch(IllegalArgumentException e) {
    		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle(DomeinController.getText("btnNiveauClicked2"));
			alert.setContentText(e.getMessage());
			alert.show();
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
}
