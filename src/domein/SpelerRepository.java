package domein;

import java.util.ArrayList;
import java.util.List;

import persistentie.SpelerMapper;

public class SpelerRepository {

	private final SpelerMapper sm;

	public SpelerRepository() {
		sm= new SpelerMapper();
	}
	
	public Speler geefSpeler(String gebruikersnaam, int geboortejaar) {
		Speler s=sm.geefSpeler(gebruikersnaam,geboortejaar );
		return s;
	}
}