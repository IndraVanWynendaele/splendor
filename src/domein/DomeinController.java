package domein;

import java.util.ArrayList;
import java.util.List;

public class DomeinController {

	private SpelerRepository sRepo;
	private EdeleRepository eRepo;
	private OntwikkelingskaartRepository oRepo;
	private Spel s ;

	public DomeinController() {
		startSpel();
		sRepo = new SpelerRepository();
	}
	
	public void startSpel() {
		s = new Spel();
	}

	public void meldAan(Speler sp) {
		s.meldAan(sp);		
	}
	
	public List<Speler> geefSpelers(){
		List<Speler> spelerLijst = new ArrayList<>();
		// elke apparte speler aan een lijst toevoegen
		spelerLijst = s.getSpelers();
		return spelerLijst;
	}

}