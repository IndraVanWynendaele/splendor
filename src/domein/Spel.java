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
	private Speler huidigeSpeler;
	private List<Ontwikkelingskaart> niveau1, niveau2, niveau3, niveau1Zichtbaar, niveau2Zichtbaar, niveau3Zichtbaar;
	private List<Edele> edelen, beschikbareEdelenSpeler = new ArrayList<>();
	private Edele[] edeleInSpel;
	private List<Speler> winnaars;
	private static final int prestigePunten = 50; // OPGEPAST AANGEPAST
	
	
	public Spel() {
		okr = new OntwikkelingskaartRepository();
		er = new EdeleRepository();
		spelers = new ArrayList<>();
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
	
//	public boolean controleerMogelijkheidTotEdelen(Speler huidigeSpeler) {
//		// lijst aanmaken met edelsteen aantal van huidigeSpeler zijn huidige voorraad ontwikkelingskaarten
//		List<Edele> beschikbareEdelen = edelenOpBezoek(huidigeSpeler);		
//		if(beschikbareEdelen.size() > 0)
//			return true;
//		return false;
//	}	
//	
//	public List<Edele> edelenOpBezoek(Speler huidigeSpeler){
//		List<Ontwikkelingskaart> aantalHuidigeOntwikkelingskaarten = huidigeSpeler.getOntwikkelingskaartenInBezit();
//		beschikbareEdelenSpeler = new ArrayList<>();
//		
//		for(Edele ed : edeleInSpel)
//			for(Ontwikkelingskaart otw : aantalHuidigeOntwikkelingskaarten)
//				if(otw.getKosten().containsAll(ed.getKosten()))
//					// ed.getKosten().equals(otw.getKosten()
//					beschikbareEdelenSpeler.add(ed);
//		
//		return beschikbareEdelenSpeler;
//	}
	
	public boolean controleerMogelijkheidTotEdelen() {
		int aantalSoortenEdelstenen = -1;
		int aantalGoed = 0;
		for(int i = 0; i < edeleInSpel.length; i++) {
		aantalSoortenEdelstenen = edeleInSpel[i].getKosten().size();
		for(EdelsteenAantal kost : edeleInSpel[i].getKosten())
			for(EdelsteenAantal bonus : huidigeSpeler.getBonussen())
				if(kost.getSoort().equals(bonus.getSoort()))
					if(kost.getAantal() <= bonus.getAantal())
						aantalGoed++;
			if(aantalGoed == aantalSoortenEdelstenen) {
				huidigeSpeler.voegEdeleToe(edeleInSpel[i]); // voor 1 edele
				// verwijderEdeleSpel(edeleInSpel[i]);
				return true;
			}
		}
		
		return false;
	}
	
//	private void verwijderEdeleSpel(Edele edele) {
//		List<Edele> edeleInSpelLijst = new ArrayList<>();
//		for(Edele ed : edeleInSpel) {
//			if(!ed.equals(edele))
//				edeleInSpelLijst.add(ed);
//		}
//		
//		edeleInSpel = edeleInSpelLijst.toArray();
//	}
	
	public void koopKaartNiveau1(int index) {
		// krijgt index binnen van kaartnummer
		// index kaart uit lijst zichtbare kaarten halen
		// deze kaart in huidigeSpeler.ontwikkelingskaartenInBezit
		if(kanKaartGekochtWorden(niveau1Zichtbaar.get(index))) {
			if(niveau1.size()!=0) {
				// fiches uit bezit speler halen
				for(EdelsteenAantal kost : niveau1Zichtbaar.get(index).getKosten()) {
					huidigeSpeler.verwijderEdelsteenfiches(kost.getSoort(), kost.getAantal());
					fichesTerugSpel(kost);
				}
				huidigeSpeler.voegOntwikkelingskaartToe(niveau1Zichtbaar.remove(index));
				niveau1Zichtbaar.add(index,niveau1.remove(0));				
			}
		}
//		else {
//			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau1Zichtbaar.remove(index));
//		} --> werkt niet
	}
	
	public void koopKaartNiveau2(int index) {
		if(kanKaartGekochtWorden(niveau2Zichtbaar.get(index))) {
			if(niveau2.size()!=0) {
				for(EdelsteenAantal kost : niveau2Zichtbaar.get(index).getKosten()) {
					huidigeSpeler.verwijderEdelsteenfiches(kost.getSoort(), kost.getAantal());
					fichesTerugSpel(kost);
				}
				huidigeSpeler.voegOntwikkelingskaartToe(niveau2Zichtbaar.remove(index));
				niveau2Zichtbaar.add(index,niveau2.remove(0));
			}
		}
		//else {
//			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau2Zichtbaar.remove(index));
//		} --> werkt niet
	}

	public void koopKaartNiveau3(int index) {
		if(kanKaartGekochtWorden(niveau3Zichtbaar.get(index))) {
			if(niveau3.size()!=0) {
				for(EdelsteenAantal kost : niveau3Zichtbaar.get(index).getKosten()) {
					huidigeSpeler.verwijderEdelsteenfiches(kost.getSoort(), kost.getAantal());
					fichesTerugSpel(kost);
				}
				huidigeSpeler.voegOntwikkelingskaartToe(niveau3Zichtbaar.remove(index));
				niveau3Zichtbaar.add(index,niveau3.remove(0));
			}
		}
		//else {
//			huidigeSpeler.getOntwikkelingskaartenInBezit().add(niveau3Zichtbaar.remove(index));
//		} --> werkt niet
	}
	
	private void fichesTerugSpel(EdelsteenAantal fiche) {
		switch(fiche.getSoort()) {
		case DIAMANT ->	diamantAantal.setAantal(diamantAantal.getAantal() + fiche.getAantal());
		case ONYX -> onyxAantal.setAantal(onyxAantal.getAantal() + fiche.getAantal());
		case ROBIJN -> robijnAantal.setAantal(robijnAantal.getAantal() + fiche.getAantal());
		case SAFFIER -> saffierAantal.setAantal(saffierAantal.getAantal() + fiche.getAantal());
		case SMARAGD -> smaragdAantal.setAantal(smaragdAantal.getAantal() + fiche.getAantal());
		}
	}
	
	private void fichesUitSpel(EdelsteenAantal fiche) {
		switch(fiche.getSoort()) {
		case DIAMANT ->	diamantAantal.setAantal(diamantAantal.getAantal() - fiche.getAantal());
		case ONYX -> onyxAantal.setAantal(onyxAantal.getAantal() - fiche.getAantal());
		case ROBIJN -> robijnAantal.setAantal(robijnAantal.getAantal() - fiche.getAantal());
		case SAFFIER -> saffierAantal.setAantal(saffierAantal.getAantal() - fiche.getAantal());
		case SMARAGD -> smaragdAantal.setAantal(smaragdAantal.getAantal() - fiche.getAantal());
		}
	}
	
	private boolean kanKaartGekochtWorden(Ontwikkelingskaart k) {
		int aantalSoortenEdelstenen = k.getKosten().size();
		int aantalGoed = 0;
		for(EdelsteenAantal kost : k.getKosten())
			for(EdelsteenAantal inBezit : huidigeSpeler.getEdelsteenfichesInBezit())
				if(kost.getSoort().equals(inBezit.getSoort()))
					if(kost.getAantal() <= inBezit.getAantal())
						aantalGoed++;
		if(aantalGoed == aantalSoortenEdelstenen)
			return true;
		throw new IllegalArgumentException("Deze kaart kan niet gekocht worden, je hebt niet genoeg edelsteenfiches!");
	}
	
	public void neemEdelsteenAantal(EdelsteenAantal fiche) {
		switch(fiche.getSoort()) {
		case DIAMANT ->	controleerAantal(diamantAantal.getAantal(), fiche.getSoort());
		case ONYX -> controleerAantal(onyxAantal.getAantal(), fiche.getSoort());
		case ROBIJN -> controleerAantal(robijnAantal.getAantal(), fiche.getSoort());
		case SAFFIER -> controleerAantal(saffierAantal.getAantal(), fiche.getSoort());
		case SMARAGD -> controleerAantal(smaragdAantal.getAantal(), fiche.getSoort());
		}
		huidigeSpeler.voegEdelsteenficheToe(fiche);
	}
	
	public void voegTmpLijstFichesToeAanPermLijst() {
		List<EdelsteenAantal> lijst = huidigeSpeler.getTmpFicheLijst();
		for(int i = 0; i < lijst.size(); i++) {
			fichesUitSpel(lijst.get(i));
		}
		huidigeSpeler.voegTmpLijstFichesToeAanPermLijst();	
	}
	
	private void controleerAantal(int aantal, EdelsteenSoort soort) {
		if(aantal == 0)
			throw new IllegalArgumentException(String.format("Er zijn geen fiches meer van het soort %s", soort.name().toLowerCase()));
	}
	
	public boolean controleerHoeveelheidFichesNemen(EdelsteenAantal fiche) {
		List<EdelsteenAantal> tmpLijst = huidigeSpeler.getTmpFicheLijst();
		if(tmpLijst.size() == 3)
			return false; 
		else {
			for(int i = 0; i < tmpLijst.size(); i++) {
				EdelsteenAantal spelerFiche = tmpLijst.get(i);
				if(spelerFiche.getSoort().equals(fiche.getSoort())) {
					if(spelerFiche.getAantal() == 2)
						throw new IllegalArgumentException("Je hebt al 2 fiches van dezelfde soort!");
					if(aantalInSpel(fiche.getSoort()) < 4)
						throw new IllegalArgumentException("Voor 2 dezelfde fiches moeten er min 4 fiches op de stapel liggen");
					else if(tmpLijst.size() == 2)
						throw new IllegalArgumentException("Je moet 3 verschillende fiches nemen!");
					huidigeSpeler.voegTmpFicheToe(fiche);
					return true;					
				}
				huidigeSpeler.voegTmpFicheToe(fiche);
				return true;
			}
		}
		huidigeSpeler.voegTmpFicheToe(fiche);
		return true;
	}
	
	private int aantalInSpel(EdelsteenSoort soort) {
		return switch(soort) {
		case DIAMANT ->	diamantAantal.getAantal();
		case ONYX -> onyxAantal.getAantal();
		case ROBIJN -> robijnAantal.getAantal();
		case SAFFIER -> saffierAantal.getAantal();
		case SMARAGD -> smaragdAantal.getAantal();
		};
	}
	
	public boolean controleerAlTweeGelijkeFichesGekozen() {
		List<EdelsteenAantal> tmpLijst = huidigeSpeler.getTmpFicheLijst();
		if(tmpLijst.get(0).getSoort().equals(tmpLijst.get(1).getSoort())) {
			return true;
		}
		return false;
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
	
	public List<EdelsteenAantal> getTmpLijstSpeler() {
		return huidigeSpeler.getTmpFicheLijst();
	}
	
	
//	public void speelRonde() {
//		for(Speler sp : spelers) {
//			sp.speelBeurt();
//			tmpSpelerLijst=updateIsAanDeBeurt(tmpSpelerLijst);
//		}
//		isEindeSpel();
//	}
//
//	private void koopOntwikkelingskaart(int rij, int kolom) {
//		Ontwikkelingskaart o ;
//		switch(rij) {
//		case 1 ->{ 
//			o=niveau1Zichtbaar.get(kolom-1);
//			controleerOntwikkelingskaartKopen(o);
//			}
//		case 2 ->{ o=niveau2Zichtbaar.remove(kolom-1);}
//		case 3 ->{ o=niveau3Zichtbaar.remove(kolom-1);}
//		}
//		
//	}
//
//	private boolean controleerOntwikkelingskaartKopen(Ontwikkelingskaart o) {
////		TODO huidigeSpeler
//		return false;
//	}
//	
//	private void controleerKeuzeEdelsteenfiches(int kolom) {
//		List<EdelsteenAantal> edelsteenfichesInBezit=huidigeSpeler.getEdelsteenfichesInBezit();
//		switch(kolom) {
//			case 1 -> {
//			edelsteenfichesInBezit.get(kolom);
//			smaragdAantal.setAantal(smaragdAantal.getAantal()-1);
//			}
//		}
//		
//	}

	public boolean isEindeSpel() {
		for(Speler speler: spelers) {
			if(speler.getTotaalAantalPrestigePunten() >= prestigePunten) {
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
		if(tmpSpelerLijst.contains(startSpeler)) {
			tmpSpelerLijst.remove(huidigeSpeler);
			return tmpSpelerLijst;
		}
			boolean klaar = false;
			while(!klaar) {
				if(tmpSpelerLijst.size()!=1) {
					
					for(int i = 0; i < spelers.size(); i++) {
						String naam = spelers.get(i).getGebruikersnaam();
							if(tmpSpelerLijst.get(0).getGebruikersnaam().equals(naam)) {
								huidigeSpeler.isAanDeBeurt(false);
								tmpSpelerLijst.remove(huidigeSpeler);
								huidigeSpeler = tmpSpelerLijst.get(0);
								huidigeSpeler.isAanDeBeurt(true);
								klaar = true;
							}
						if(klaar)break;
					}
				}
				else if(tmpSpelerLijst.size() == 1) {
					huidigeSpeler.isAanDeBeurt(false);
					tmpSpelerLijst.remove(huidigeSpeler);
					huidigeSpeler = tmpSpelerLijst.get(0);
					huidigeSpeler.isAanDeBeurt(true);
					klaar = true;
				}
			}
		return tmpSpelerLijst;
	}

	public void resetSpelers() {
		isStartSpeler();
		for(Speler s : spelers) {
			if(!s.geefisStartSpeler()) {
				s.isAanDeBeurt(false);
			}
		}
	}
	
}