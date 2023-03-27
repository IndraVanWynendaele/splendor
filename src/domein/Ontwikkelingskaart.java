package domein;

import util.EdelsteenSoort;

public class Ontwikkelingskaart extends Prestige {
	private final int niveau;
	private EdelsteenSoort bonus;
	

	public Ontwikkelingskaart(int niveau, int prestigePunten, EdelsteenSoort bonus) {
		super(prestigePunten);
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