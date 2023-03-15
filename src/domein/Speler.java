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

	public Speler(String gebruikersnaam, LocalDate geboortejaar) {
		controleerGebruikersnaam(gebruikersnaam);
		controleerGeboortejaar(geboortejaar);
		this.gebruikersnaam = gebruikersnaam;
		this.geboortejaar = geboortejaar;
	}
	
	private void controleerGebruikersnaam(String gebruikersnaam) {
		String specialeKarakters = "!#$%&'()*+,-./:;<=>?@[]^`{|}";
		boolean goed;
		for(int i = 0; i < specialeKarakters.length(); i++)
			if(gebruikersnaam.contains(Character.toString(specialeKarakters.charAt(i))))
				throw new IllegalArgumentException("gebruikersnaam mag geen speicale tekens buiten spatie en _ bevatten");
		char c = gebruikersnaam.charAt(0);
		/*if((c < 'A' && c > 'Z') || (c < 'a' && c > 'z'))
			throw new IllegalArgumentException("Gebruikersnaam moet starten met een letter (klein of groot)!");*/
		if(!((c >= 'A' && c <='Z') || (c >= 'a' && c <='z')))
			throw new IllegalArgumentException("Gebruikersnaam moet starten met een letter (klein of groot)!");

		
	}
	
	private void controleerGeboortejaar(LocalDate geboortejaar) {
		LocalDate minimumJaar = LocalDate.now().minusYears(6);
		if(geboortejaar.isAfter(minimumJaar))
			throw new IllegalArgumentException("Gebruiker moet minimum 6 jaar oud zijn");
	}
}