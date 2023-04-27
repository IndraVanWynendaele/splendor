package domein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.EdelsteenSoort;

public class Spel {
	private List<Speler> spelers,tmpSpelerLijst;
	private Speler startSpeler;
	private OntwikkelingskaartRepository okr;
	private EdeleRepository er;
	private EdelsteenAantal diamantAantal, smaragdAantal, saffierAantal, onyxAantal, robijnAantal;
	public Speler huidigeSpeler;
	private List<Ontwikkelingskaart> niveau1, niveau2, niveau3, niveau1Zichtbaar, niveau2Zichtbaar, niveau3Zichtbaar;
	private List<Edele> edelen, beschikbareEdelenSpeler;
	private Edele[] edeleInSpel;
	private List<Speler> winnaars;
	
	public Speler getHuidigeSpeler() {
		return huidigeSpeler;
	}
	
	public Speler getStartSpeler() {
		return startSpeler;
	}
	
	public List<Speler> getWinnaars() {
		return winnaars;
	}
	
	public List<Edele> getBeschikbareEdelenSpeler() {
		return beschikbareEdelenSpeler;
	}
	
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
		beschikbareEdelenSpeler = new ArrayList<>();
		
		for(Edele ed : edeleInSpel)
			for(Ontwikkelingskaart otw : aantalHuidigeOntwikkelingskaarten)
				if(otw.getKosten().containsAll(ed.getKosten()))
					// ed.getKosten().equals(otw.getKosten()
					beschikbareEdelenSpeler.add(ed);
		
		return beschikbareEdelenSpeler;
	}
	
	public void koopKaartNiveau1(int index) {
		// krijgt index binnen van kaartnummer
		// index kaart uit lijst zichtbare kaarten halen
		// deze kaart in huidigeSpeler.ontwikkelingskaartenInBezit
		if(niveau1.size()!=0) {
			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau1Zichtbaar.remove(index));
			niveau1Zichtbaar.add(index,niveau1.remove(0));
		}//else {
//			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau1Zichtbaar.remove(index));
//		} --> werkt niet
	}
	
	public void koopKaartNiveau2(int index) {
		if(niveau2.size()!=0) {
			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau2Zichtbaar.remove(index));
			niveau2Zichtbaar.add(index,niveau2.remove(0));
		}//else {
//			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau2Zichtbaar.remove(index));
//		} --> werkt niet
	}

	public void koopKaartNiveau3(int index) {
		if(niveau3.size()!=0) {
			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau3Zichtbaar.remove(index));
			niveau3Zichtbaar.add(index,niveau3.remove(0));
		}//else {
//			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau3Zichtbaar.remove(index));
//		} --> werkt niet
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
	
	
//	public void speelRonde() {
//		for(Speler sp : spelers) {
//			sp.speelBeurt();
//			tmpSpelerLijst=updateIsAanDeBeurt(tmpSpelerLijst);
//		}
//		isEindeSpel();
//	}

	private void koopOntwikkelingskaart(int rij, int kolom) {
		Ontwikkelingskaart o ;
		switch(rij) {
		case 1 ->{ 
			o=niveau1Zichtbaar.get(kolom-1);
			controleerOntwikkelingskaartKopen(o);
			}
		case 2 ->{ o=niveau2Zichtbaar.remove(kolom-1);}
		case 3 ->{ o=niveau3Zichtbaar.remove(kolom-1);}
		}
		
	}

	private boolean controleerOntwikkelingskaartKopen(Ontwikkelingskaart o) {
//		TODO huidigeSpeler
		return false;
	}
	
	private void kiesEdelsteenfiches(int kolom) {
		List<EdelsteenAantal> edelsteenfichesInBezit=huidigeSpeler.getEdelsteenfichesInBezit();
		switch(kolom) {
		case 1 -> {
			edelsteenfichesInBezit.get(kolom);
			smaragdAantal.setAantal(smaragdAantal.getAantal()-1);
		}
//		case 2 ->null;
//		case 3 ->null;
//		case 4 ->null;
//		case 5 ->null;
		}
	}

	public boolean isEindeSpel() {
		for(Speler speler: spelers) {
			if(speler.getTotaalAantalPrestigePunten()>=15) {
				bepaalWinnaar();
				return true;
			}
		}
		return false;	
	}
	
	private void bepaalWinnaar() {
		int maxPrestigepunten=Integer.MIN_VALUE;
		winnaars = new ArrayList<>();
		winnaars.add(spelers.get(0));
				
		for(Speler speler:spelers) {
			if(speler.getTotaalAantalPrestigePunten() == maxPrestigepunten) {
				if(speler.getOntwikkelingskaartenInBezit().size() < startSpeler.getOntwikkelingskaartenInBezit().size()) {
					maxPrestigepunten=speler.getTotaalAantalPrestigePunten();
					winnaars.remove(0);
					winnaars.add(speler);
				}
				else if(speler.getOntwikkelingskaartenInBezit().size() == startSpeler.getOntwikkelingskaartenInBezit().size()) {
					maxPrestigepunten=speler.getTotaalAantalPrestigePunten();
					winnaars.add(speler);
				}
			}
			else if(speler.getTotaalAantalPrestigePunten()> maxPrestigepunten) {
				maxPrestigepunten=speler.getTotaalAantalPrestigePunten();
				winnaars.remove(0);
				winnaars.add(speler);
			}
		}
	}
	
	public void isStartSpeler() {
		int jongsteJaar=Integer.MIN_VALUE;
		startSpeler=spelers.get(0);
		for(Speler speler:spelers) {
			if(speler.getGeboortejaar() == jongsteJaar) {
				if(speler.getGebruikersnaam().length() > startSpeler.getGebruikersnaam().length()) {
					jongsteJaar=speler.getGeboortejaar();
					startSpeler=speler;
				}
				else if(speler.getGebruikersnaam().length() == startSpeler.getGebruikersnaam().length()) {
					String str1 = speler.getGebruikersnaam();
					String str2 = startSpeler.getGebruikersnaam();
					int result;
					do {
						result = str1.compareTo(str2);
						if(result > 0) // 1
							startSpeler = speler;
					}while(result <= 0);			        
				}
			}
			else if(speler.getGeboortejaar()>jongsteJaar) {
					jongsteJaar=speler.getGeboortejaar();
					startSpeler=speler;
			}
		}
		startSpeler.isStartspeler(true);
		startSpeler.isAanDeBeurt(true);
		huidigeSpeler = startSpeler;
		
	}
	
	public List<Speler> updateIsAanDeBeurt(List<Speler> tmpSpelerLijst) {
		if(tmpSpelerLijst.size()!=0) {
			boolean klaar = false;
			while(!klaar) {
				if(tmpSpelerLijst.size()!=1) {
					for(int i = 0; i < spelers.size(); i++) {
						String naam = spelers.get(i).getGebruikersnaam();
							if(huidigeSpeler.getGebruikersnaam().equals(naam)) {
								huidigeSpeler.isAanDeBeurt(false);
								tmpSpelerLijst.remove(huidigeSpeler);
								huidigeSpeler = tmpSpelerLijst.get(0);
								huidigeSpeler.isAanDeBeurt(true);
								klaar = true;
							}
						if(klaar)break;
					}
				}else {
					huidigeSpeler.isAanDeBeurt(false);
					tmpSpelerLijst.remove(huidigeSpeler);
					klaar = true;
				}
			}
		}
		return tmpSpelerLijst;
	}
	
}