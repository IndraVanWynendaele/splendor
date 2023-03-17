package domein;

import java.util.List;

import util.EdelsteenSoort;

public class Edele {
	private int prestigePunten;
	private List<Kost> kosten;

	public Edele(int prestigePunten) {
		this.prestigePunten = prestigePunten;
	}
	
	public void voegKostToe(int aantal, EdelsteenSoort soort) { //mapper en repo gebruikt deze methode
		kosten.add(new Kost(aantal, soort));
	}
}