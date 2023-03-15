package domein;


import java.time.LocalDate;
import java.util.*;

import javafx.scene.control.Spinner;

public class DomeinController {

	private List<Speler> spelers;
	private SpelerRepository sRepo;
	private Spel s;
	
	private Scanner input = new Scanner(System.in);
	private boolean gebruikerGedaan;

	public void startSpel() {
		String naam;
		String stringJaar;
		LocalDate jaar;
		
		System.out.print("Geef de gebruikersnaam: ");
		naam= input.nextLine();
		System.out.print("Geef je geboortjejaar (formaat: jjjj-mm-dd): ");
		stringJaar=input.nextLine();
		
		jaar = LocalDate.parse(stringJaar);
		
		meldAan(naam,jaar);
		
		spelers=sRepo.getSpelers();
		//Speler startSpeler=spelers.get(0);
		//spelers.remove(0);
		
		int i=1;
		do {
			i++;
			System.out.printf("Geef de gebruikersnaam van speler %d: ",i+1);
			naam= input.nextLine();
			System.out.printf("Geef je geboortjejaar van speler %d (formaat: jjjj-mm-dd): ",i+1);
			stringJaar=input.nextLine();
			
			jaar = LocalDate.parse(stringJaar);
				
			meldAan(naam,jaar);
				
			System.out.printf("Wil je nog een %d de speler toevoegen? (1=ja, 2=nee)");
			int keuze = input.nextInt();
			switch(keuze) {
			case 1 -> gebruikerGedaan=false;
			case 2 -> gebruikerGedaan=true;
			default -> throw new IllegalArgumentException("Je moet 1 of 2 ingeven");
			}
			if (i==4) {
				 gebruikerGedaan=true;
			}
		}while(!gebruikerGedaan);
		
	}

	/**
	 * 
	 * @param gebruikersnaam
	 * @param geboortejaar
	 */
	public void meldAan(String gebruikersnaam, LocalDate geboortejaar) {
		s = new Spel();
		Speler s = new Speler(gebruikersnaam,geboortejaar);
		sRepo.voegToe(s);
		//spelers.add(s);
		
		//Speler startSpeler = new Speler(gebruikersnaam,geboortejaar);
		//List<Speler> spelers= new ArrayList<>();
	}

	public DomeinController() {
		spelers = new ArrayList<>();
		sRepo = new SpelerRepository();
		
	}
// ik snap niet goed hoe ik de link moet leggen tussen speler en spel en hoe ik dan 
// aanduid welke speler de startspeler is en welke de oovergebleve speles zijn
// ook snap ik niet zo goed of ik de aangemaakte speler moet toevoegen aan de repo 
// of aan het aangemaakte attribut die in deze klasse staat

}