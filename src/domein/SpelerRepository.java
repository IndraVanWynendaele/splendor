package domein;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SpelerRepository {

	private List<Speler> spelers;

	public SpelerRepository() {
		spelers = new ArrayList<>();
	}

	public void voegToe(Speler speler) {
		spelers.add(speler);
	}

	public List<Speler> getSpelers() {
		return spelers;
	}
	
	public Speler geefSpeler(String gebruikersnaam, LocalDate Geboortejaar) {
		// link naar de spelermapper
		retrun sp
	}
}