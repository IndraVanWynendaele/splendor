package domein;

import java.util.List;

import persistentie.SpelerMapper;

public class SpelerRepository {

	private final SpelerMapper sm;
	private final List<Speler> spelers;

	public SpelerRepository() {
		sm= new SpelerMapper();
		spelers = sm.geefSpelers();
	}
	
	public List<Speler> geefSpelers() {
		return spelers;
	}
}