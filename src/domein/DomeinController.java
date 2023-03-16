package domein;

import domein.EdeleRepository;
public class DomeinController {

	private SpelerRepository sRepo;
	private Spel s;
	private EdeleRepository eRepo;

	public void startSpel() {
		s = new Spel();
	}

	public void meldAan(String gebruikersnaam, int geboortejaar) {
		Speler sp =sRepo.geefSpeler( gebruikersnaam, geboortejaar);
		s.meldAan(sp);		
	}

	public DomeinController() {
		//spelers = new ArrayList<>();
		sRepo = new SpelerRepository();
	}
}