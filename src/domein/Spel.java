package domein;

import java.util.ArrayList;
import java.util.List;

public class Spel {
	private List<Speler> spelers;
	private Speler startSpeler;
	
	public Spel() {
		spelers= new ArrayList<>();
	}
	
	public List<Speler> getSpelers() {
		return spelers;
	}
	
	public void meldAan(Speler sp){
		spelers.add(sp);
	}
}