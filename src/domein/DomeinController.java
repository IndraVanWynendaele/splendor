package domein;

import java.util.ArrayList;
import java.util.List;

import dtos.SpelerDTO;

public class DomeinController {

	private SpelerRepository sRepo;
	//private EdeleRepository eRepo;
	//private OntwikkelingskaartRepository oRepo;
	private Spel s ;
	public Speler startSpeler;
	private List<Speler> spelersInSpel;
	
	public Edele[] getEdeleSpelers() {
		return s.getEdeleSpelers();
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
	
	public DomeinController() {
		s = new Spel();
		startSpel();
		sRepo = new SpelerRepository();
		
		// spelersInSpel = new ArrayList<>();
	}
	
	public void startSpel() {
		s.shuffleOntwikkelingsKaarten();
		s.shuffleEdelen();
		s.geefKaartenAantalSpelers();
	}

	public boolean meldAan(Speler sp) {
		if(sRepo.geefSpeler(sp.getGebruikersnaam(), sp.getGeboortejaar())!= null) {
			s.meldAan(sp);
			return true;
		}
			return false;	
	}
	
	public List<SpelerDTO> geefSpelerDTOs(){
		spelersInSpel = s.getSpelers();
		List<SpelerDTO> spelerDTOs = new ArrayList<>();
		for(Speler speler : spelersInSpel) {
			spelerDTOs.add(new SpelerDTO(speler.getGebruikersnaam(),speler.getGeboortejaar(), speler.getTotaalAantalPrestigePunten(), speler.geefIsAanDeBeurt(), speler.geefisStartSpeler(), speler.getOntwikkelingskaartenInBezit(), speler.getEdelsteenfichesInBezit(), speler.getEdelenInBezit()));
		}
		return spelerDTOs;
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
		try{
			if(spelersInSpel.size() < 2) {
				throw new IllegalArgumentException("Er moeten minstens 2 spelers aangemeld zijn\n");
			}else if(spelersInSpel.size() > 4) {
				spelersInSpel.removeAll(spelersInSpel);
				throw new IllegalArgumentException("Er mogen maar 4 spelers aangemeld zijn \nDe lijst van spelers is verwijderd, begin helemaal opnieuw! :( \n");
			}
			aantalSpelersInOrde = true;
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
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
	}
}