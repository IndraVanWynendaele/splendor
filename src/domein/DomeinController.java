package domein;

import java.util.ArrayList;
import java.util.List;

import dtos.EdeleDTO;
import dtos.OntwikkelingskaartDTO;
import dtos.SpelerDTO;

public class DomeinController {

	private SpelerRepository sRepo;
	private EdeleRepository eRepo;
	private OntwikkelingskaartRepository oRepo;
	private Spel s ;
	public Speler startSpeler;
	public Speler huidigeSpeler;
	public List<Speler> spelersInSpel;
	
	public DomeinController() {
		s = new Spel();
		startSpel();
		sRepo = new SpelerRepository();
	}
	
	public List<Speler> getSpelersInSpel() {
		return spelersInSpel;
	}
	
	public Speler getStartSpeler() {
		return startSpeler;
	}
	
	public void startSpel() {
		s.shuffleOntwikkelingsKaarten();
		s.shuffleEdelen();
		s.geefKaartenAantalSpelers();
		s.maakZichtbareOntwikkelingskaarten();
	}

	public boolean meldAan(Speler sp) {
		if(sRepo.geefSpeler(sp.getGebruikersnaam(), sp.getGeboortejaar())!= null) {
			s.meldAan(sp);
			return true;
		}
		return false;	
	}
	
	public void voegToe(Speler sp) {
		sRepo.voegToe(sp);
	}
	
	public boolean spelerAlAangemeld(Speler sp) {
		spelersInSpel= s.getSpelers();
		for(Speler speler : spelersInSpel)
			if(speler.getGebruikersnaam().equals(sp.getGebruikersnaam()))
				if(speler.getGeboortejaar() == sp.getGeboortejaar())
					return false;
		return true;
	}
	
	public boolean controleerAantalSpelers() {
		boolean aantalSpelersInOrde = false;
		spelersInSpel= s.getSpelers();

			if(spelersInSpel.size() < 2) {
				throw new IllegalArgumentException("Er moeten minstens 2 spelers aangemeld zijn\n");
				// else if weg doen
			}else if(spelersInSpel.size() > 4) {
				spelersInSpel.removeAll(spelersInSpel);
				throw new IllegalArgumentException("Er mogen maar 4 spelers aangemeld zijn \nDe lijst van spelers is verwijderd, begin helemaal opnieuw! :( \n");
			}
			aantalSpelersInOrde = true;

		return aantalSpelersInOrde;
	}
	
	public void isStartSpeler() {
		int jongsteJaar=Integer.MIN_VALUE;
		spelersInSpel = s.getSpelers();
		startSpeler=spelersInSpel.get(0);
		for(Speler speler:spelersInSpel) {
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
				if(tmpSpelerLijst.size()==1) {
					huidigeSpeler.isAanDeBeurt(false);
					tmpSpelerLijst.remove(huidigeSpeler);
					if(klaar)break;
				}else {
				for(int i = 0; i < spelersInSpel.size(); i++) {
					String naam = spelersInSpel.get(i).getGebruikersnaam();
						if(huidigeSpeler.getGebruikersnaam().equals(naam)) {
							huidigeSpeler.isAanDeBeurt(false);
							tmpSpelerLijst.remove(huidigeSpeler);
							huidigeSpeler = tmpSpelerLijst.get(0);
							huidigeSpeler.isAanDeBeurt(true);
							
							klaar = true;
						}
					if(klaar)break;
					}
				}
			}
		}
		return tmpSpelerLijst;
		
	}
	
	public boolean isEindeSpel() {
		spelersInSpel=s.getSpelers();
		for(Speler speler: spelersInSpel) {
			if(speler.getTotaalAantalPrestigePunten()>=15) {
				return true;
			}
		}
		return false;	
	}
	
	public void bepaalWinnaar() {
		int maxPrestigepunten=Integer.MIN_VALUE;
		spelersInSpel = s.getSpelers();
		List<Speler> winnaar = new ArrayList<>();
		winnaar.add(spelersInSpel.get(0));
				
		for(Speler speler:spelersInSpel) {
			if(speler.getTotaalAantalPrestigePunten() == maxPrestigepunten) {
				if(speler.getOntwikkelingskaartenInBezit().size() < startSpeler.getOntwikkelingskaartenInBezit().size()) {
					maxPrestigepunten=speler.getTotaalAantalPrestigePunten();
					winnaar.remove(0);
					winnaar.add(speler);
				}
				else if(speler.getOntwikkelingskaartenInBezit().size() == startSpeler.getOntwikkelingskaartenInBezit().size()) {
					maxPrestigepunten=speler.getTotaalAantalPrestigePunten();
					winnaar.add(speler);
				}
			}
			else if(speler.getTotaalAantalPrestigePunten()> maxPrestigepunten) {
				maxPrestigepunten=speler.getTotaalAantalPrestigePunten();
				winnaar.remove(0);
				winnaar.add(speler);
			}
		}
	}
	
	public int controleerMogelijkheidTotEdelen() {
		if(s.controleerMogelijkheidTotEdelen(huidigeSpeler)) {
			List<Edele> beschikbareEdelen = s.edelenTeKoop(huidigeSpeler);
			if(beschikbareEdelen.size() == 1)
				huidigeSpeler.voegEdeleToe(beschikbareEdelen.get(0));
			return beschikbareEdelen.size();
		}
		return 0;
	}
	
	public List<SpelerDTO> geefSpelerDTO(){
		spelersInSpel = s.getSpelers();
		List<SpelerDTO> spelerDTOs = new ArrayList<>();
		for(Speler speler : spelersInSpel) {
			spelerDTOs.add(new SpelerDTO(speler.getGebruikersnaam(),speler.getGeboortejaar(), speler.getTotaalAantalPrestigePunten(), speler.geefIsAanDeBeurt(), speler.geefisStartSpeler(), speler.getOntwikkelingskaartenInBezit(), speler.getEdelsteenfichesInBezit(), speler.getEdelenInBezit()));
		}
		return spelerDTOs;
	}
	
	public List<EdeleDTO> geefEdeleDTO(){
		Edele[] edeleInSpel = s.getEdeleSpelers();
		List<EdeleDTO> edeleDTO = new ArrayList<>();
		for(Edele edele:edeleInSpel) {
			edeleDTO.add(new EdeleDTO(edele.getPrestigepunten(),edele.getKosten()));
		}
		return edeleDTO;
	}
	
	public List<OntwikkelingskaartDTO> geefOntwikkelingskaartDTO1(){
		List<Ontwikkelingskaart> ontwikkelingskaart1 =s.getNiveau1();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO1 = new ArrayList<>();
		for(Ontwikkelingskaart o1:ontwikkelingskaart1) {
			ontwikkelingskaartDTO1.add(new OntwikkelingskaartDTO(o1.getPrestigepunten(),o1.getKosten(),o1.getNiveau(),o1.getBonus()));
		}
		return ontwikkelingskaartDTO1;
	}

	public List<OntwikkelingskaartDTO> geefOntwikkelingskaartDTO2(){
		List<Ontwikkelingskaart> ontwikkelingskaart2 =s.getNiveau2();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO2 = new ArrayList<>();
		for(Ontwikkelingskaart o2:ontwikkelingskaart2) {
			ontwikkelingskaartDTO2.add(new OntwikkelingskaartDTO(o2.getPrestigepunten(),o2.getKosten(),o2.getNiveau(),o2.getBonus()));
		}
		return ontwikkelingskaartDTO2;
	}
	
	public List<OntwikkelingskaartDTO> geefOntwikkelingskaartDTO3(){
		List<Ontwikkelingskaart> ontwikkelingskaart3 =s.getNiveau1();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO3 = new ArrayList<>();
		for(Ontwikkelingskaart o3:ontwikkelingskaart3) {
			ontwikkelingskaartDTO3.add(new OntwikkelingskaartDTO(o3.getPrestigepunten(),o3.getKosten(),o3.getNiveau(),o3.getBonus()));
		}
		return ontwikkelingskaartDTO3;
	}
	
	public List<OntwikkelingskaartDTO> getNiveau1Zichtbaar() {
		List<Ontwikkelingskaart> ontwikkelingskaart1 = s.getNiveau1Zichtbaar();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO1 = new ArrayList<>();
		for(Ontwikkelingskaart o1:ontwikkelingskaart1) {
			ontwikkelingskaartDTO1.add(new OntwikkelingskaartDTO(o1.getPrestigepunten(),o1.getKosten(),o1.getNiveau(),o1.getBonus()));
		}
		return ontwikkelingskaartDTO1; 
	}
	
	public List<OntwikkelingskaartDTO> getNiveau2Zichtbaar() {
		List<Ontwikkelingskaart> ontwikkelingskaart2 =s.getNiveau2Zichtbaar();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO2 = new ArrayList<>();
		for(Ontwikkelingskaart o2:ontwikkelingskaart2) {
			ontwikkelingskaartDTO2.add(new OntwikkelingskaartDTO(o2.getPrestigepunten(),o2.getKosten(),o2.getNiveau(),o2.getBonus()));
		}
		return ontwikkelingskaartDTO2; 
	}
	
	public List<OntwikkelingskaartDTO> getNiveau3Zichtbaar() {
		List<Ontwikkelingskaart> ontwikkelingskaart3 =s.getNiveau3Zichtbaar();
		List<OntwikkelingskaartDTO> ontwikkelingskaartDTO3 = new ArrayList<>();
		for(Ontwikkelingskaart o3:ontwikkelingskaart3) {
			ontwikkelingskaartDTO3.add(new OntwikkelingskaartDTO(o3.getPrestigepunten(),o3.getKosten(),o3.getNiveau(),o3.getBonus()));
		}
		return ontwikkelingskaartDTO3; 
	}
	
	public List<Ontwikkelingskaart> getNiveau1() {
		return s.getNiveau1();
	}
	
	public List<Ontwikkelingskaart> getNiveau2() {
		return s.getNiveau2();
	}
	
	public List<Ontwikkelingskaart> getNiveau3() {
		return s.getNiveau3();
	}
	
	public Edele[] getEdeleSpelers() {
		return s.getEdeleSpelers();
	}
	
	public EdelsteenAantal getDiamantAantal() {
		return s.getDiamantAantal();
	}
	
	public EdelsteenAantal getOnyxAantal() {
		return s.getOnyxAantal();
	}
	
	public EdelsteenAantal getRobijnAantal() {
		return s.getRobijnAantal();
	}
	
	public EdelsteenAantal getSaffierAantal() {
		return s.getSaffierAantal();
	}
	
	public EdelsteenAantal getSmaragdAantal() {
		return s.getSmaragdAantal();
	}
}