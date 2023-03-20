package domein;

public class Speler {

	private final String gebruikersnaam;
	private final int geboortejaar;
	private final int HUIDIG_JAAR = 2023;
	private final int MINIMUM_JAAR = HUIDIG_JAAR - 6;

	public String getGebruikersnaam() {
		return this.gebruikersnaam;
	}

	public int getGeboortejaar() {
		return this.geboortejaar;
	}

	public Speler(String gebruikersnaam, int geboortejaar) {
		controleerGebruikersnaam(gebruikersnaam);
		controleerGeboortejaar(geboortejaar);
		this.gebruikersnaam = gebruikersnaam;
		this.geboortejaar = geboortejaar;
	}
	
	private void controleerGebruikersnaam(String gebruikersnaam) {
		String specialeKarakters = "!#$%&'()*+,-./:;<=>?@[]^`{|}";
		for(int i = 0; i < specialeKarakters.length(); i++)
			if(gebruikersnaam.contains(Character.toString(specialeKarakters.charAt(i))))
				throw new IllegalArgumentException("gebruikersnaam mag geen speciale tekens buiten spatie en _ bevatten");
		char c = gebruikersnaam.charAt(0);
		if(!((c >= 'A' && c <='Z') || (c >= 'a' && c <='z')))
			throw new IllegalArgumentException("Gebruikersnaam moet starten met een letter (klein of groot)!");		
	}
	
	private void controleerGeboortejaar(int geboortejaar) {
		if(geboortejaar > MINIMUM_JAAR)
			throw new IllegalArgumentException("Gebruiker moet minimum 6 jaar oud zijn");
	}
}