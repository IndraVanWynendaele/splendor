package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.EdelsteenSoort;

public class Spel {
	private List<Speler> spelers;
	private Speler startSpeler;
	private OntwikkelingskaartRepository okr;
	private EdeleRepository er;
	private EdelsteenAantal diamantAantal, smaragdAantal, saffierAantal, onyxAantal, robijnAantal;
	
	private List<Ontwikkelingskaart> niveau1, niveau2, niveau3;
	private List<Edele> edelen;
	private Edele[] edeleSpelers;
	/*
	private List<Edele> beschikbareEdelen;
	private List<EdelsteenAantal> edelsteenFicheVoorraad;
	private List<Ontwikkelingskaart> beschikbareOntwikkelingskaarten;
	*/
	public Spel() {
		okr= new OntwikkelingskaartRepository();
		er= new EdeleRepository();
		spelers= new ArrayList<>();
		
	}
	
	public List<Speler> getSpelers() {
		return spelers;
	}
	
	public Edele[] getEdeleSpelers() {
		return edeleSpelers;
	}
	
	public List<Ontwikkelingskaart> getNiveau1() {
		return niveau1;
	}
	
	public List<Ontwikkelingskaart> getNiveau2() {
		return niveau2;
	}
	
	public List<Ontwikkelingskaart> getNiveau3() {
		return niveau3;
	}
	
	public EdelsteenAantal getDiamantAantal() {
		return diamantAantal;
	}
	
	public EdelsteenAantal getOnyxAantal() {
		return onyxAantal;
	}
	
	public EdelsteenAantal getRobijnAantal() {
		return robijnAantal;
	}
	
	public EdelsteenAantal getSaffierAantal() {
		return saffierAantal;
	}
	
	public EdelsteenAantal getSmaragdAantal() {
		return smaragdAantal;
	}
	
	public void meldAan(Speler sp){
		spelers.add(sp);
	}
	
	public void shuffleOntwikkelingsKaarten() {
		niveau1 = okr.geefKaartenNiveau1();
		Collections.shuffle(niveau1);
		
		niveau2 = okr.geefKaartenNiveau2();
		Collections.shuffle(niveau2);
		
		niveau3 = okr.geefKaartenNiveau3();
		Collections.shuffle(niveau3);
	}
	
	public void shuffleEdelen() {
		edelen= er.geefEdelen();
		Collections.shuffle(edelen);
	}
	
	public void geefKaartenAantalSpelers() {	
		if(spelers.size() == 2) {
			edeleSpelers=new Edele[3];
			diamantAantal = new EdelsteenAantal(4,EdelsteenSoort.DIAMANT);
			smaragdAantal = new EdelsteenAantal(4,EdelsteenSoort.SMARAGD);
			robijnAantal = new EdelsteenAantal(4,EdelsteenSoort.ROBIJN);
			saffierAantal = new EdelsteenAantal(4,EdelsteenSoort.SAFFIER);
			onyxAantal = new EdelsteenAantal(4,EdelsteenSoort.ONYX);
			for(int i =0;i<edeleSpelers.length;i++) {
				edeleSpelers[i]=edelen.get(i);
			}
		}
			
		if(spelers.size() == 3) {
			edeleSpelers=new Edele[4];
			diamantAantal = new EdelsteenAantal(5,EdelsteenSoort.DIAMANT);
			smaragdAantal = new EdelsteenAantal(5,EdelsteenSoort.SMARAGD);
			robijnAantal = new EdelsteenAantal(5,EdelsteenSoort.ROBIJN);
			saffierAantal = new EdelsteenAantal(5,EdelsteenSoort.SAFFIER);
			onyxAantal = new EdelsteenAantal(5,EdelsteenSoort.ONYX);
			for(int i =0;i<edeleSpelers.length;i++) {
				edeleSpelers[i]=edelen.get(i);
			}
		}
		
		if(spelers.size() == 4) {
			edeleSpelers=new Edele[5];
			diamantAantal = new EdelsteenAantal(7,EdelsteenSoort.DIAMANT);
			smaragdAantal = new EdelsteenAantal(7,EdelsteenSoort.SMARAGD);
			robijnAantal = new EdelsteenAantal(7,EdelsteenSoort.ROBIJN);
			saffierAantal = new EdelsteenAantal(7,EdelsteenSoort.SAFFIER);
			onyxAantal = new EdelsteenAantal(7,EdelsteenSoort.ONYX);
			for(int i =0;i<edeleSpelers.length;i++) {
				edeleSpelers[i]=edelen.get(i);
			}
		}
	}
}
	
