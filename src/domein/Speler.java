package domein;

import java.util.ArrayList;
import java.util.List;

import util.EdelsteenSoort;

public class Speler {
	private final String gebruikersnaam;
	private final int geboortejaar;
	private static final int HUIDIG_JAAR = 2023;
	private static final int MINIMUM_JAAR = HUIDIG_JAAR - 6;
	private static final int MAXIMUM_JAAR = HUIDIG_JAAR - 99;

	private int totaalAantalPrestigepunten;
	private boolean isAanDeBeurt;
	private boolean isStartspeler;
	private boolean isWinnaar;
	private List<Ontwikkelingskaart> ontwikkelingskaartenInBezit= new ArrayList<>();
	private List<EdelsteenAantal> edelsteenfichesInBezit = new ArrayList<>();
	private List<Edele> edelenInBezit = new ArrayList<>();
	
	public Speler(String gebruikersnaam, int geboortejaar) {
		controleerGebruikersnaam(gebruikersnaam);
		controleerGeboortejaar(geboortejaar);
		ficheBegin();
		this.gebruikersnaam = gebruikersnaam;
		this.geboortejaar = geboortejaar;
	}
	
	private void ficheBegin() {
		edelsteenfichesInBezit.add(new EdelsteenAantal(0,EdelsteenSoort.DIAMANT));
		edelsteenfichesInBezit.add(new EdelsteenAantal(0,EdelsteenSoort.ONYX));
		edelsteenfichesInBezit.add(new EdelsteenAantal(0,EdelsteenSoort.ROBIJN));
		edelsteenfichesInBezit.add(new EdelsteenAantal(0,EdelsteenSoort.SAFFIER));
		edelsteenfichesInBezit.add(new EdelsteenAantal(0,EdelsteenSoort.SMARAGD));
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
		if(geboortejaar < 0)
			throw new IllegalArgumentException("Vul positief getal in");
		if(geboortejaar > MINIMUM_JAAR || geboortejaar < MAXIMUM_JAAR)
			throw new IllegalArgumentException("Gebruiker moet minimum 6 en maximum 99 jaar oud zijn");
	}
	
	public void voegEdeleToe(Edele edele) {
		edelenInBezit.add(edele);
		totaalAantalPrestigepunten += edele.getPrestigepunten();
	}
	
	public void voegEdelsteenficheToe(EdelsteenAantal fiche) {
		for(int i = 0; i < edelsteenfichesInBezit.size(); i++) {
			EdelsteenAantal huidige = edelsteenfichesInBezit.get(i);
			if(huidige.getSoort() == fiche.getSoort()) {
				huidige.setAantal(huidige.getAantal() + fiche.getAantal());
			}
		}
	}
	
	public void voegOntwikkelingskaartToe(Ontwikkelingskaart kaart) {
		ontwikkelingskaartenInBezit.add(kaart);
		totaalAantalPrestigepunten += kaart.getPrestigepunten();
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