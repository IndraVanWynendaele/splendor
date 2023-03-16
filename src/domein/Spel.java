package domein;

import java.time.LocalDate;
import java.util.List;

public class Spel {

	private List<Speler> spelers;
	private Speler startSpeler;
	
	public Spel() {
		
	}
	
	public void meldAan(String gebruikersnaam, int geboortejaar){
		Speler s = new Speler(gebruikersnaam,geboortejaar);
		spelers.add(s);
	}
	

	public Spel() {
		// TODO Auto-generated constructor stub
	}

}