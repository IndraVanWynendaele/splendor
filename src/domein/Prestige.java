package domein;

import java.util.ArrayList;
import java.util.List;

import util.EdelsteenSoort;

public class Prestige {

	private int prestigepunten;
	private List<EdelsteenAantal> kosten;
	
	public List<EdelsteenAantal> getKosten() {
		return kosten;
	}
	
	public Prestige(int prestigepunten) {
		this.prestigepunten=prestigepunten;
		kosten = new ArrayList<>();
	}

	public void voegKostToe(int aantal, EdelsteenSoort soort) {
		kosten.add(new EdelsteenAantal(aantal, soort));
	}
	
	public int getPrestigepunten() {
		return this.prestigepunten;
	}
}