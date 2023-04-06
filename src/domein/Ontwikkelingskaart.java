package domein;

import util.EdelsteenSoort;

public class Ontwikkelingskaart extends Prestige {
	private final int niveau;
	private EdelsteenSoort bonus;

	public Ontwikkelingskaart(int niveau, int prestigepunten, EdelsteenSoort bonus) {
		super(prestigepunten);
		this.niveau = niveau;
		this.bonus = bonus;
	}
	
	public int getNiveau() {
		return niveau;
	}
	
	public EdelsteenSoort getBonus() {
		return bonus;
	}
}