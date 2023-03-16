package testen;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Spel;
import domein.Speler;
import domein.SpelerRepository;

class SpelTest {
	
	private int geboortejaar;
	private SpelerRepository sr;
	private Speler s1, s2, s3, s4, s5;
	
	@BeforeEach
	void setUp1() {
		Speler s1 = new Speler("naam", geboortejaar);
		Speler speler2 = new Speler("naam", geboortejaar);
		Speler speler3 = new Speler("naam", geboortejaar);
		Speler speler4 = new Speler("naam", geboortejaar);
		Speler speler5 = new Speler("naam", geboortejaar);
		
		sr = new SpelerRepository();
		ArrayList<Speler> spelers= new ArrayList<>();
	}
		
	@Test
	void maakSpel_aantalSpelersTeKlein_werptException() {
		
		sr.voegToe(s1);
		
		assertThrows(IllegalArgumentException.class, () -> new Spel());
	}
	
	@Test
	void maakSpel_aantalSpelersTeGroot_werptException() {
		List spelers = new ArrayList();
		sr.voegToe(s1);
		sr.voegToe(s2);
		sr.voegToe(s3);
		sr.voegToe(s4);
		sr.voegToe(s5);		
		
		assertThrows(IllegalArgumentException.class, () -> new Spel());
	}
	
	@Test
	void maakSpel_aantalSpelersCorrect_maaktSpel() {
		List spelers = new ArrayList();
		sr.voegToe(s1);
		sr.voegToe(s2);
		sr.voegToe(s3);
		
		assertEquals(3, spelers.size());
	}
	
}
