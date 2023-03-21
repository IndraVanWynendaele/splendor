package domein;

import java.util.List;

import util.EdelsteenSoort;

public class Ontwikkelingskaart {
	private final int niveau;
	private int prestigePunten;
	private EdelsteenSoort bonus;
	private List<Kost> kosten;

	public Ontwikkelingskaart(int niveau, int prestigePunten, EdelsteenSoort bonus) {
		this.niveau = niveau;
		this.prestigePunten = prestigePunten;
		this.bonus = bonus;
	}
	
	public void voegKostToe(int aantal, EdelsteenSoort soort) {
		kosten.add(new Kost(aantal, soort));
	}
	
	
}