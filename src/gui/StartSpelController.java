package gui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;
import domein.Edele;
import domein.Speler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Path;

public class StartSpelController extends AnchorPane {

	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	private List<Speler> tmpSpelerLijst;
	private int aantalKlik = 0;
	

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
    private Label lblOnyxSpelerAantal1;

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
    private ImageView imvEdele1;

    @FXML
    private ImageView imvEdele2;

    @FXML
    private ImageView imvEdele3;

    @FXML
    private ImageView imvEdele4;   
    
    @FXML
    private ImageView imvEdele5;
    

	public StartSpelController(AanmeldenController preAanmeldenScreen, DomeinController dc) {
		this.dc = dc;
		this.preAanmeldenScreen=preAanmeldenScreen;
			
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartSpel.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		toonStartSpelbord();
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	private void toonStartSpelbord() {
		
		List<Edele> zichtbareEdelen = new ArrayList<>();
		zichtbareEdelen = dc.geefEdelenZichtbaar();
		List<ImageView> imageViewEdele = new ArrayList<>();
		List<Button> edeleButtons = new ArrayList<>();
		
		btnEdele1 = new Button();
		btnEdele2 = new Button();
		btnEdele3 = new Button();
		btnEdele4 = new Button();
		btnEdele5 = new Button();
		
		edeleButtons.add(btnEdele1);
		edeleButtons.add(btnEdele2);
		edeleButtons.add(btnEdele3);
		edeleButtons.add(btnEdele4);
		edeleButtons.add(btnEdele5);
		
		imvEdele1 = new ImageView();
		imvEdele2 = new ImageView();
		imvEdele3 = new ImageView();
		imvEdele4 = new ImageView();
		imvEdele5 = new ImageView();
		
		imageViewEdele.add(imvEdele1);
		imageViewEdele.add(imvEdele2);
		imageViewEdele.add(imvEdele3);
		imageViewEdele.add(imvEdele4);
		imageViewEdele.add(imvEdele5);
		
		
		
		imvEdele1.setImage(new Image(getClass().getResourceAsStream("/images/Edelekaart2.png")));		
		btnEdele1.setGraphic(imvEdele1);
		
//		// for-loop om voor zichtbareEdelen bijhorende kaart in een lijst te zetten (imageViewEdele)
//		for(int i=0; i<zichtbareEdelen.size(); i++) {
//			Image img = zichtbareEdelen.get(i).getImage();
//			imageViewEdele.get(i).setImage(img);
//		}
//		// voor elk element uit imageViewEdele de graphic zetten op bijhorende button via String.format
//		for(int i=0; i<imageViewEdele.size(); i++) {
//			ImageView imageview = imageViewEdele.get(i);
//			edeleButtons.get(i).setGraphic(imageview);
//		}		
		
		//this.getChildren().addAll(imvEdele1, imvEdele2,imvEdele3,imvEdele4,imvEdele5,btnEdele1,btnEdele2,btnEdele3,btnEdele4,btnEdele5);
//		for(int i=0; i<zichtbareEdelen.size(); i++) {
//			imageViewEdele.get(i).setImage();
//			
//		}
		// btnEdele1.setGraphic(imvEdele1);
		 this.getChildren().addAll(imvEdele1, btnEdele1);
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
	void btnVolgendeClicked(ActionEvent event) {
		geefNaamHuidigeSpeler();
		if(tmpSpelerLijst.size()==1) {
			btnVolgende.setDisable(true);
	    	btnStartRonde.setDisable(false);
		}
		// geeft indexoutofboundsexception
		tmpSpelerLijst= dc.updateIsAanDeBeurt(tmpSpelerLijst);
		
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
    

    @FXML
    void btnDiamantSpelClicked(ActionEvent event) {

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

    
 }
	 