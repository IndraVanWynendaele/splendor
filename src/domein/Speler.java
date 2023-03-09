package domein;

import java.time.LocalDate;

public class Speler {

	private Spel s;
	private final String gebruikersnaam;
	private final LocalDate geboortejaar;

	public String getGebruikersnaam() {
		return this.gebruikersnaam;
	}

	public LocalDate getGeboortejaar() {
		return this.geboortejaar;
	}

	/**
	 * 
	 * @param gebruikersnaam
	 * @param geboortejaar
	 */
	public Speler(String gebruikersnaam, LocalDate geboortejaar) {
		// TODO - implement Speler.Speler
		throw new UnsupportedOperationException();
	}

}