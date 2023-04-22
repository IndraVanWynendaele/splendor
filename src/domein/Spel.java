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
	
	private List<Ontwikkelingskaart> niveau1, niveau2, niveau3, niveau1Zichtbaar, niveau2Zichtbaar, niveau3Zichtbaar;
	private List<Edele> edelen;
	private Edele[] edeleInSpel;
	
	public Spel() {
		okr= new OntwikkelingskaartRepository();
		er= new EdeleRepository();
		spelers= new ArrayList<>();
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
		niveau1=okr.geefKaartenNiveau1();
		niveau2=okr.geefKaartenNiveau2();
		niveau3=okr.geefKaartenNiveau3();
		
		if(spelers.size() == 2) {
			edeleInSpel=new Edele[3];
			diamantAantal = new EdelsteenAantal(4,EdelsteenSoort.DIAMANT);
			smaragdAantal = new EdelsteenAantal(4,EdelsteenSoort.SMARAGD);
			robijnAantal = new EdelsteenAantal(4,EdelsteenSoort.ROBIJN);
			saffierAantal = new EdelsteenAantal(4,EdelsteenSoort.SAFFIER);
			onyxAantal = new EdelsteenAantal(4,EdelsteenSoort.ONYX);
			for(int i =0;i<edeleInSpel.length;i++) {
				edeleInSpel[i]=edelen.get(i);
			}
		}
			
		if(spelers.size() == 3) {
			edeleInSpel=new Edele[4];
			diamantAantal = new EdelsteenAantal(5,EdelsteenSoort.DIAMANT);
			smaragdAantal = new EdelsteenAantal(5,EdelsteenSoort.SMARAGD);
			robijnAantal = new EdelsteenAantal(5,EdelsteenSoort.ROBIJN);
			saffierAantal = new EdelsteenAantal(5,EdelsteenSoort.SAFFIER);
			onyxAantal = new EdelsteenAantal(5,EdelsteenSoort.ONYX);
			for(int i =0;i<edeleInSpel.length;i++) {
				edeleInSpel[i]=edelen.get(i);
			}
		}
		
		if(spelers.size() == 4) {
			edeleInSpel=new Edele[5];
			diamantAantal = new EdelsteenAantal(7,EdelsteenSoort.DIAMANT);
			smaragdAantal = new EdelsteenAantal(7,EdelsteenSoort.SMARAGD);
			robijnAantal = new EdelsteenAantal(7,EdelsteenSoort.ROBIJN);
			saffierAantal = new EdelsteenAantal(7,EdelsteenSoort.SAFFIER);
			onyxAantal = new EdelsteenAantal(7,EdelsteenSoort.ONYX);
			for(int i =0;i<edeleInSpel.length;i++) {
				edeleInSpel[i]=edelen.get(i);
			}
		}
	}
	
	public void maakZichtbareOntwikkelingskaarten() {
		niveau1Zichtbaar = new ArrayList<>();
		niveau2Zichtbaar = new ArrayList<>();
		niveau3Zichtbaar = new ArrayList<>();
		
		for(int i =0;i<4;i++) {
			niveau1Zichtbaar.add(niveau1.remove(0));
			niveau2Zichtbaar.add(niveau2.remove(0));
			niveau3Zichtbaar.add(niveau3.remove(0));
		}
	}
	
	public boolean controleerMogelijkheidTotEdelen(Speler huidigeSpeler) {
		// lijst aanmaken met edelsteen aantal van huidigeSpeler zijn huidige voorraad ontwikkelingskaarten
		List<Edele> beschikbareEdelen = edelenTeKoop(huidigeSpeler);
				
		if(beschikbareEdelen.size() > 0)
			return true;
		return false;
	}
	
	public List<Edele> edelenTeKoop(Speler huidigeSpeler){
		List<Ontwikkelingskaart> aantalHuidigeOntwikkelingskaarten = huidigeSpeler.getOntwikkelingskaartenInBezit();
		List<Edele> beschikbareEdelen = new ArrayList<>();
		
		for(Edele ed : edeleInSpel)
			for(Ontwikkelingskaart otw : aantalHuidigeOntwikkelingskaarten)
				if(ed.getKosten().equals(otw.getKosten()))
					beschikbareEdelen.add(ed);
		
		return beschikbareEdelen;
	}
	
	public List<Ontwikkelingskaart> getNiveau1Zichtbaar() {
		return niveau1Zichtbaar;
	}
	
	public List<Ontwikkelingskaart> getNiveau2Zichtbaar() {
		return niveau2Zichtbaar;
	}
	
	public List<Ontwikkelingskaart> getNiveau3Zichtbaar() {
		return niveau3Zichtbaar;
	}
	
	public List<Speler> getSpelers() {
		return spelers;
	}
	
	public Edele[] getEdeleSpelers() {
		return edeleInSpel;
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
	
	
	
}