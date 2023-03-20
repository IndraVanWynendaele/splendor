package domein;

import persistentie.SpelerMapper;

public class SpelerRepository {

	private final SpelerMapper sm;

	public SpelerRepository() {
		sm= new SpelerMapper();
	}
	
	public Speler geefSpeler(String gn,int gj) {
		Speler sp = sm.geefSpeler(gn, gj);
		return sp;
	}
}