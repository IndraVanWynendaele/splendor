package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Speler;

class SpelerTest {

	private LocalDate geldigGeboortejaar = LocalDate.now().minusYears(8);
	private LocalDate netOngeldigGeboortejaar = LocalDate.now().minusYears(5);
	private LocalDate ongeldigGeboortejaar = LocalDate.now().minusYears(2);
	
	@ParameterizedTest
	@ValueSource(strings = {"Aenof", "Afu12", "a12 fBfz", "fe_12 AB"})
	void maakSpeler_gegevensGeldig_MaaktSpeler(String gebruikersnaam) {
		Speler s = new Speler(gebruikersnaam, geldigGeboortejaar);
		assertEquals(gebruikersnaam, s.getGebruikersnaam());
		assertEquals(geldigGeboortejaar, s.getGeboortejaar());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1fzbhi", "_fzbfe", " fzfuob", "fbz*fjz", "fzoeb.fz fu"}) 
	void maakSpeler_gebruikersnaamOngeldig_WerptException(String gebruikersnaam) {
		assertThrows(IllegalArgumentException.class, () -> new Speler(gebruikersnaam, geldigGeboortejaar));
	}
	
	@Test
	void maakSpeler_geboorteJaarOngeldig_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> new Speler("Afbzo_12", netOngeldigGeboortejaar));
		assertThrows(IllegalArgumentException.class, () -> new Speler("Afbzo_12", ongeldigGeboortejaar));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"1fzbhi", "_fzbfe", " fzfuob", "fbz*fjz", "fzoeb.fz fu"})
	void maakSpeler_gegevensOngeldig_WerptException(String gebruikersnaam) {
		assertThrows(IllegalArgumentException.class, () -> new Speler(gebruikersnaam, ongeldigGeboortejaar));
	}
}
