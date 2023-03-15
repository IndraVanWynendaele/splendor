package domein;

import java.time.LocalDate;

public class Speler {

	private Spel s;
	private final String gebruikersnaam;
	private final LocalDate geboortejaar;
	private final LocalDate huidigJaar = LocalDate.parse("2017");

	public String getGebruikersnaam() {
		return this.gebruikersnaam;
	}

	public LocalDate getGeboortejaar() {
		return this.geboortejaar;
	}

	public Speler(String gebruikersnaam, LocalDate geboortejaar) {
		controleerGebruikersnaam(gebruikersnaam);
		controleerGeboortejaar(geboortejaar);
		this.gebruikersnaam = gebruikersnaam;
		this.geboortejaar = geboortejaar;
	}
	
	private void controleerGebruikersnaam(String gebruikersnaam) {
		if(!gebruikersnaam.contains(" ") || !gebruikersnaam.contains("_"))
			throw new IllegalArgumentException("Gebruikersnaam mag enkel spaties en _ bevatten, anders geen speciale tekens!");
		char c = gebruikersnaam.charAt(0);
		if((c <= 'A' && c >= 'Z') || (c <= 'a' || c >= 'z'))
			throw new IllegalArgumentException("Gebruikersnaam moet starten met een letter (klein of groot)!");
	}
	
	private void controleerGeboortejaar(LocalDate geboortejaar) {
		if(geboortejaar.isAfter(huidigJaar)) {
			throw new IllegalArgumentException("Speler moet minimum 6 jaar oud zijn");
		}
	}
}