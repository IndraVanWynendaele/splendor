package domein;

import java.util.ArrayList;
import java.util.List;

public class Speler {
	private final String gebruikersnaam;
	private final int geboortejaar;
	private static final int HUIDIG_JAAR = 2023;
	private static final int MINIMUM_JAAR = HUIDIG_JAAR - 6;

	private int totaalAantalPrestigepunten;
	private boolean isAanDeBeurt;
	private boolean isStartspeler;
	private boolean isWinnaar;
	private List<Ontwikkelingskaart> ontwikkelingskaartenInBezit;
	private List<EdelsteenAantal> edelsteenfichesInBezit = new ArrayList<>();
	private List<Edele> edelenInBezit ;
	
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
	
	public void voegEdeleToe(Edele edele) {
		edelenInBezit.add(edele);
	}
	
	public void isStartspeler(boolean i) {
		isStartspeler = i;
	}
	
	public void isAanDeBeurt(boolean i) {
		isAanDeBeurt = i;
	}
	
	public boolean geefIsAanDeBeurt() {
		return isAanDeBeurt;
	}
	
	public boolean geefisStartSpeler() {
		return isStartspeler;
	}
	
	public List<Edele> getEdelenInBezit() {
		return edelenInBezit;
	}
	
	public List<EdelsteenAantal> getEdelsteenfichesInBezit() {
		return edelsteenfichesInBezit;
	}
	
	public List<Ontwikkelingskaart> getOntwikkelingskaartenInBezit() {
		return ontwikkelingskaartenInBezit;
	}
	
	public int getTotaalAantalPrestigePunten() {
		return totaalAantalPrestigepunten;
	}
	
	public String getGebruikersnaam() {
		return this.gebruikersnaam;
	}

	public int getGeboortejaar() {
		return this.geboortejaar;
	}
}