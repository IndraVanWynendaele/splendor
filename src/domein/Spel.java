package domein;

import java.util.ArrayList;
import java.util.List;

public class Spel {

	private List<Speler> spelers;
	private Speler startSpeler;
	
	public Spel() {
		spelers= new ArrayList<>();
	}
	
	public Speler getStartSpeler() {
		return startSpeler;
	}
	
	public List<Speler> getSpelers() {
		return spelers;
	}
	
	public void meldAan(Speler sp){
		if(startSpeler==null) {
			startSpeler=sp;
		}
		spelers.add(sp);
	}
}