package domein;

import java.util.ArrayList;
import java.util.List;

import domein.EdeleRepository;
public class DomeinController {

	private SpelerRepository sRepo;
	private Spel s;
	private EdeleRepository eRepo;

	public void startSpel() {
		s = new Spel();
	}

	public void meldAan(String gebruikersnaam, int geboortejaar) {
		Speler sp =sRepo.geefSpeler(gebruikersnaam, geboortejaar);
		s.meldAan(sp);		
		/*List<Speler> spelers = new ArrayList<>();
		spelers = sRepo.geefSpelers();
		for(Speler sp:spelers) {
			s.meldAan(sp);
		}*/
	}
	
	public List<Speler> geefSpelers(){
		List<Speler> spelerLijst = new ArrayList<>();
		// elke apparte speler aan een lijst toevoegen
		return spelerLijst;
	}

	public DomeinController() {
		//spelers = new ArrayList<>();
		sRepo = new SpelerRepository();
	}
}