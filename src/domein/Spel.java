package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Spel {
	private List<Speler> spelers;
	private Speler startSpeler;
	private OntwikkelingskaartRepository okr;
	private EdeleRepository er;
	private EdelsteenficheRepository efr;
	
	private List<Ontwikkelingskaart> niveau1, niveau2, niveau3;
	private List<Edele> edelen;
	private Edele[] edeleSpelers;
	private List<Edelsteenfiche> edelsteenficheDiamant, edelsteenficheSmaragd, edelsteenficheSaffier, edelsteenficheOnyx, edelsteenficheRobijn;
	private Edelsteenfiche[] edelsteenficheDiamantSpelers, edelsteenficheSmaragdenSpelers, edelsteenficheSaffierenSpelers, edelsteenficheOnyxenSpelers, edelsteenficheRobijnSpelers;

	
	public Spel() {
		okr= new OntwikkelingskaartRepository();
		er= new EdeleRepository();
		efr= new EdelsteenficheRepository();
		spelers= new ArrayList<>();
		shuffleOntwikkelingsKaarten();
		shuffleEdelen();
		geefKaartenAantalSpelers();
	}
	
	public List<Speler> getSpelers() {
		return spelers;
	}
	
	public void meldAan(Speler sp){
		spelers.add(sp);
	}
	
	private void shuffleOntwikkelingsKaarten() {
		niveau1 = okr.geefKaartenNiveau1();
		Collections.shuffle(niveau1);
		
		niveau2 = okr.geefKaartenNiveau2();
		Collections.shuffle(niveau2);
		
		niveau3 = okr.geefKaartenNiveau3();
		Collections.shuffle(niveau3);
	}
	
	private void shuffleEdelen() {
		edelen= er.geefEdelen();
		Collections.shuffle(edelen);
	}
	
	private void geefKaartenAantalSpelers() {
		edelsteenficheDiamant = efr.geefFichesDiamant();
		edelsteenficheRobijn=efr.geefFichesRobijn();
		edelsteenficheOnyx= efr.geefFichesOnyx();
		edelsteenficheSaffier=efr.geefFichesSaffier();
		edelsteenficheSmaragd=efr.geefFichesSmaragd();
			
		if(spelers.size() == 2) {
			edeleSpelers=new Edele[3];
			edelsteenficheDiamantSpelers= new Edelsteenfiche[4];
			edelsteenficheOnyxenSpelers= new Edelsteenfiche[4];
			edelsteenficheRobijnSpelers=new Edelsteenfiche[4];
			edelsteenficheSaffierenSpelers=new Edelsteenfiche[4];
			edelsteenficheSmaragdenSpelers=new Edelsteenfiche[4];
			
			for(int i =0;i<edeleSpelers.length;i++) {
				edeleSpelers[i]=edelen.get(i);
			}
			for(int i=0;i<4;i++) {
				edelsteenficheDiamantSpelers[i]= edelsteenficheDiamant.get(i);
				edelsteenficheOnyxenSpelers[i]= edelsteenficheOnyx.get(i);
				edelsteenficheRobijnSpelers[i]=edelsteenficheRobijn.get(i);
				edelsteenficheSaffierenSpelers[i]=edelsteenficheSaffier.get(i);
				edelsteenficheSmaragdenSpelers[i]=edelsteenficheSmaragd.get(i);
			}
			if(spelers.size() == 3) {
				edeleSpelers=new Edele[4];
				edelsteenficheDiamantSpelers= new Edelsteenfiche[5];
				edelsteenficheOnyxenSpelers= new Edelsteenfiche[5];
				edelsteenficheRobijnSpelers=new Edelsteenfiche[5];
				edelsteenficheSaffierenSpelers=new Edelsteenfiche[5];
				edelsteenficheSmaragdenSpelers=new Edelsteenfiche[5];
				
				for(int i =0;i<edeleSpelers.length;i++) {
					edeleSpelers[i]=edelen.get(i);
				}
				for(int i=0;i<5;i++) {
					edelsteenficheDiamantSpelers[i]= edelsteenficheDiamant.get(i);
					edelsteenficheOnyxenSpelers[i]= edelsteenficheOnyx.get(i);
					edelsteenficheRobijnSpelers[i]=edelsteenficheRobijn.get(i);
					edelsteenficheSaffierenSpelers[i]=edelsteenficheSaffier.get(i);
					edelsteenficheSmaragdenSpelers[i]=edelsteenficheSmaragd.get(i);
				}
			}
			if(spelers.size() == 4) {
				edeleSpelers=new Edele[5];
				edelsteenficheDiamantSpelers= new Edelsteenfiche[7];
				edelsteenficheOnyxenSpelers= new Edelsteenfiche[7];
				edelsteenficheRobijnSpelers=new Edelsteenfiche[7];
				edelsteenficheSaffierenSpelers=new Edelsteenfiche[7];
				edelsteenficheSmaragdenSpelers=new Edelsteenfiche[7];
				
				for(int i =0;i<edeleSpelers.length;i++) {
					edeleSpelers[i]=edelen.get(i);
				}
				for(int i=0;i<7;i++) {
					edelsteenficheDiamantSpelers[i]= edelsteenficheDiamant.get(i);
					edelsteenficheOnyxenSpelers[i]= edelsteenficheOnyx.get(i);
					edelsteenficheRobijnSpelers[i]=edelsteenficheRobijn.get(i);
					edelsteenficheSaffierenSpelers[i]=edelsteenficheSaffier.get(i);
					edelsteenficheSmaragdenSpelers[i]=edelsteenficheSmaragd.get(i);
				}
			}
		}
	}
	
}