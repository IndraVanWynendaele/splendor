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
	
	private List<Edele> beschikbareEdelen;
	private List<EdelsteenAantal> edelsteenFicheVoorraad;
	private List<Ontwikkelingskaart> beschikbareOntwikkelingskaarten;
	
	public Spel() {
		okr= new OntwikkelingskaartRepository();
		er= new EdeleRepository();
		spelers= new ArrayList<>();
		shuffleOntwikkelingsKaarten();
		shuffleEdelen();
		geefKaartenAantalSpelers();
	}
	
	public List<Speler> getSpelers() {
		return spelers;
	}
	
	public List<Edele> getBeschikbareEdelen() {
		return beschikbareEdelen;
	}
	
	public List<EdelsteenAantal> getEdelsteenFicheVoorraad() {
		return edelsteenFicheVoorraad;
	}
	
	public List<Ontwikkelingskaart> getBeschikbareOntwikkelingskaarten() {
		return beschikbareOntwikkelingskaarten;
	}
	
	public void setBeschikbareEdelen(List<Edele> beschikbareEdelen) {
		//TODO
		this.beschikbareEdelen = beschikbareEdelen;
	}
	
	public void setEdelsteenFicheVoorraad(List<EdelsteenAantal> edelsteenFicheVoorraad) {
		//TODO
		this.edelsteenFicheVoorraad = edelsteenFicheVoorraad;
	}
	
	public void setBeschikbareOntwikkelingskaarten(List<Ontwikkelingskaart> beschikbareOntwikkelingskaarten) {
		//TODO
		this.beschikbareOntwikkelingskaarten = beschikbareOntwikkelingskaarten;
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
	
	
	
	/*public void isStartspeler() {
		int jongsteGeboorte=Integer.MAX_VALUE;
		startSpeler=spelers.get(0);
		
		for(Speler speler:spelers) {
			if(speler.getGeboortejaar()>jongsteGeboorte) {
				jongsteGeboorte=speler.getGeboortejaar();
				startSpeler=speler;
			}
		}
		startSpeler.isStartspeler(true);
	}
	*/
	/*private void bepaalStartSpeler() {
		int kleinsteGetal = Integer.MAX_VALUE;
		startSpeler=spelersInSpel.get(0);
		spelersInSpel= s.getSpelers();
		for(Speler speler : spelersInSpel) {
			if(speler.getGeboortejaar() < kleinsteGetal) {
				kleinsteGetal = speler.getGeboortejaar();
				startSpeler = speler;
			}
		}
		startSpeler.isStartspeler(true);
	}*/
}
	
