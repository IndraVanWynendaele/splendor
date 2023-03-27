package domein;

import util.EdelsteenSoort;

public class EdelsteenAantal {
	private int aantal;
	private EdelsteenSoort soort;
	
	public EdelsteenAantal(int aantal, EdelsteenSoort soort) {
		this.aantal = aantal;
		this.soort = soort;
	}
	
	public int getAantal() {
		return aantal;
	}
	
	public EdelsteenSoort getSoort() {
		return soort;
	}
}