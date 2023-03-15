package domein;


import java.time.LocalDate;
import java.util.*;

public class DomeinController {

	private List<Speler> spelers;
	private SpelerRepository sRepo;
	private Spel s;

	public void startSpel() {
		spelers=sRepo.getSpelers();
	}

	/**
	 * 
	 * @param gebruikersnaam
	 * @param geboortejaar
	 */
	public void meldAan(String gebruikersnaam, LocalDate geboortejaar) {
		s = new Spel();
		Speler s = new Speler(gebruikersnaam,geboortejaar);
		sRepo.voegToe(s);
		
		//Speler startSpeler = new Speler(gebruikersnaam,geboortejaar);
		//List<Speler> spelers= new ArrayList<>();
	}

	public DomeinController() {
		spelers = new ArrayList<>();
		sRepo = new SpelerRepository();
		
	}


}