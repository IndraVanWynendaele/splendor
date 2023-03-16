package domein;

import domein.EdeleRepository;
public class DomeinController {

	//private List<SpelerDTO> spelers;
	private SpelerRepository sRepo;
	private Spel s;
	private EdeleRepository eRepo;

	public void startSpel() {
		s = new Spel();
	}

	/**
	 * 
	 * @param gebruikersnaam
	 * @param geboortejaar
	 */
	public void meldAan(String gebruikersnaam, int geboortejaar) {
		Speler sp =sRepo.geefSpeler( gebruikersnaam, geboortejaar);
		s.meldAan(sp);		
		
		//Speler s = new Speler(gebruikersnaam,geboortejaar);
		//sRepo.voegToe(s);
		
		//spelers.add(s);
		//Speler startSpeler = new Speler(gebruikersnaam,geboortejaar);
		//List<Speler> spelers= new ArrayList<>();
	}

	public DomeinController() {
		//spelers = new ArrayList<>();
		sRepo = new SpelerRepository();
		
	}
// ik snap niet goed hoe ik de link moet leggen tussen speler en spel en hoe ik dan 
// aanduid welke speler de startspeler is en welke de oovergebleve speles zijn
// ook snap ik niet zo goed of ik de aangemaakte speler moet toevoegen aan de repo 
// of aan het aangemaakte attribut die in deze klasse staat

}