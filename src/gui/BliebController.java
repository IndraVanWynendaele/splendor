package gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domein.DomeinController;
import domein.Edele;
import domein.Speler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class BliebController extends AnchorPane{
	private DomeinController dc;
	private AanmeldenController preAanmeldenScreen;
	private List<Speler> tmpSpelerLijst;
	private int aantalKlik = 0;
	
	@FXML
    private Label RondeWeergave;

    @FXML
    private Button button;

    @FXML
    private ImageView edeleTest;

    @FXML
    private Label spelerNaamWeergave;
    
    @FXML
    private ImageView achtergrondAfbeelding;
    
	public BliebController(AanmeldenController preAanmeldenScreen, DomeinController dc) {
		this.dc = dc;
		this.preAanmeldenScreen=preAanmeldenScreen;
			 
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Blieb.fxml"));
		loader.setRoot(this);
		loader.setController(this);
		
		try {
			loader.load();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		spelbord();
	}
	
	private void spelbord() {
		List<Edele> zichtbareEdelen = new ArrayList<>();
		zichtbareEdelen = dc.geefEdelenZichtbaar();
		List<ImageView> imageViewEdele = new ArrayList<>();
		List<Button> edeleButtons = new ArrayList<>(); 
		
		edeleTest.setImage(new Image(getClass().getResourceAsStream("/images/Edelekaart2.png")));
		edeleTest.setFitHeight(150);
		edeleTest.setFitWidth(150);
		button.setGraphic(edeleTest);
		
		for(int i = 0; i < zichtbareEdelen.size(); i++) {
			
		}
		
//		// for-loop om voor zichtbareEdelen bijhorende kaart in een lijst te zetten (imageViewEdele)
//		for(int i=0; i<zichtbareEdelen.size(); i++) {
//			Image img = zichtbareEdelen.get(i).getImage();
//			imageViewEdele.get(i).setImage(img);
//		}
//		
//		// voor elk element uit imageViewEdele de graphic zetten op bijhorende button via String.format
//		for(int i=0; i<imageViewEdele.size(); i++) {
//			ImageView imageview = imageViewEdele.get(i);
//			edeleButtons.get(i).setGraphic(imageview);
//		}
	}
}
