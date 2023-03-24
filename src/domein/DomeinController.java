package domein;

import java.util.ArrayList;
import java.util.List;

import dtos.SpelerDTO;

public class DomeinController {

	private SpelerRepository sRepo;
	private EdeleRepository eRepo;
	private OntwikkelingskaartRepository oRepo;
	private Spel s ;
	public Speler startSpeler;
	private List<Speler> spelersInSpel;
	

	public DomeinController() {
		s = new Spel();
		startSpel();
		sRepo = new SpelerRepository();
		
		// spelersInSpel = new ArrayList<>();
	}
	
	public void startSpel() {
		bepaalStartSpeler();
	}

	public boolean meldAan(Speler sp) {
		if(sRepo.geefSpeler(sp.getGebruikersnaam(), sp.getGeboortejaar())!= null) {
			s.meldAan(sp);
			return true;
		}
			return false;	
	}
	
	public List<SpelerDTO> geefSpelerDTOs(){
		spelersInSpel = s.getSpelers();//probleem
		List<SpelerDTO> spelerDTOs = new ArrayList<>();
		for(Speler speler : spelersInSpel) {
			spelerDTOs.add(new SpelerDTO(speler.getGebruikersnaam(),speler.getGeboortejaar(), speler.getTotaalAantalPrestigePunten(), speler.geefIsAanDeBeurt(), speler.geefisStartSpeler(), speler.getOntwikkelingskaartenInBezit(), speler.getEdelsteenfichesInBezit(), speler.getEdelenInBezit()));
		}
		return spelerDTOs;
	}

	private void bepaalStartSpeler() {
		int kleinsteGetal = Integer.MAX_VALUE;
		spelersInSpel= s.getSpelers();
		for(Speler speler : spelersInSpel) {
			if(speler.getGeboortejaar() < kleinsteGetal) {
				kleinsteGetal = speler.getGeboortejaar();
				startSpeler = speler;
			}
		}
	}
	public void voegToe(Speler sp) {
		sRepo.voegToe(sp);
	}
	
	public boolean spelerAlAangemeld(Speler sp) {
		spelersInSpel= s.getSpelers();//klopt
		for(Speler speler : spelersInSpel)
			if(speler.getGebruikersnaam().equals(sp.getGebruikersnaam()))
				if(speler.getGeboortejaar() == sp.getGeboortejaar())
					return false;
		return true;
	}
	
	public boolean controleerAantalSpelers() {
		boolean aantalSpelersInOrde = false;
		spelersInSpel= s.getSpelers();//klopt
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

	
}