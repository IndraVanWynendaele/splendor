package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {

	private SpelerRepository sRepo;
	private EdeleRepository eRepo;
	private OntwikkelingskaartRepository oRepo;
	private Spel s ;
	public Speler startSpeler;

	public DomeinController() {
		startSpel();
		sRepo = new SpelerRepository();
	}
	
	public void startSpel() {
		s = new Spel();
		bepaalStartSpeler();
	}

	public void meldAan(Speler sp) {
		s.meldAan(sp);		
	}
	
	public List<Speler> geefSpelers(){
		List<Speler> spelerLijst = new ArrayList<>();
		spelerLijst = s.getSpelers();
		return spelerLijst;
	}

	private void bepaalStartSpeler() {
		List<Speler> spelers = geefSpelers();
		int kleinsteGetal = Integer.MAX_VALUE;
		
		for(Speler s : spelers) {
			if(s.getGeboortejaar() < kleinsteGetal) {
				kleinsteGetal = s.getGeboortejaar();
				startSpeler = s;
			}
		}
	}
}