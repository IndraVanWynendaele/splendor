package domein;

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
	}
	
	public int getPrestige() {
		return this.prestigepunten;
	}
	
	public void voegKostToe(int aantal, EdelsteenSoort soort) {
		kosten.add(new EdelsteenAantal(aantal, soort));
	}
}
