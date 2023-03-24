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
		startSpel();
		sRepo = new SpelerRepository();
		spelersInSpel = new ArrayList<>();
	}
	
	public void startSpel() {
		s = new Spel();
		bepaalStartSpeler();
	}

	public boolean meldAan(Speler sp) {
		if(sRepo.geefSpeler(sp.getGebruikersnaam(), sp.getGeboortejaar())!= null) {
			s.meldAan(sp);
			return true;
		}
			return false;	
	}
	
	public List<SpelerDTO> geefSpelers(){
		List<SpelerDTO> spelerLijstDTO = new ArrayList<>();
		spelersInSpel= s.getSpelers();
		for(Speler sp : spelersInSpel) {
			spelerLijstDTO.add(new SpelerDTO(sp.getGebruikersnaam(),sp.getGeboortejaar()));
		}
		return spelerLijstDTO;
	}

	private void bepaalStartSpeler() {
		int kleinsteGetal = Integer.MAX_VALUE;
		spelersInSpel= s.getSpelers();
		for(Speler s : spelersInSpel) {
			if(s.getGeboortejaar() < kleinsteGetal) {
				kleinsteGetal = s.getGeboortejaar();
				startSpeler = s;
			}
		}
	}
	public void voegToe(Speler sp) {
		sRepo.voegToe(sp);
	}
	
	public boolean spelerAlAangemeld(Speler sp) {
		spelersInSpel= s.getSpelers();
		for(Speler s : spelersInSpel)
			if(s.getGebruikersnaam().equals(sp.getGebruikersnaam()))
				if(s.getGeboortejaar() == sp.getGeboortejaar())
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

	
}