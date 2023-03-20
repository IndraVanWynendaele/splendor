package cui;

import java.util.InputMismatchException;
import java.util.Scanner;

import domein.DomeinController;
import domein.Speler;
import persistentie.SpelerMapper;

public class SplendorApp {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	private int keuzeKeuzeMenu;
	private SpelerMapper sm;
	
	public SplendorApp(DomeinController dc) {
		this.dc = dc;
		sm = new SpelerMapper();
	}
	
	public void start() {
		keuzeKeuzeMenu = toonKeuzeMenu();
		while(keuzeKeuzeMenu != 3) {
			switch(keuzeKeuzeMenu) {
			case 1 -> valideerGegevensInput();
			}
			keuzeKeuzeMenu = toonKeuzeMenu();
		}
	}
	
	private int toonKeuzeMenu() {
		do {
			try {
				System.out.println("-- Keuzemenu --");
				System.out.println("1. Een speler aanmelden");
				System.out.println("2. Stoppen met aanmelden en het spel starten");
				System.out.println("3. De applicatie stoppen");
				System.out.print("Maak je keuze (1-3): ");
				keuzeKeuzeMenu = input.nextInt();
			}catch(InputMismatchException exc) {
				System.out.println("Keuze moet een nummer zijn!");
			}finally {
				input.nextLine();
			}
		}while(keuzeKeuzeMenu < 1 || keuzeKeuzeMenu > 3);
		return keuzeKeuzeMenu;
	}
	
	private void valideerGegevensInput() {
		String gebruikersnaam="";
		int geboortejaar=0;
		boolean finished = false;
		
		do {
			
			try {
				System.out.print("Geef je gebruikersnaam in: ");
				gebruikersnaam=input.nextLine();
				
				System.out.print("Geef je geboortejaar in: ");
				geboortejaar=input.nextInt();
				
				if(sm.geefSpeler(gebruikersnaam, geboortejaar)==null) {
					Speler s = new Speler(gebruikersnaam,geboortejaar);
					sm.voegToe(s);
					dc.meldAan(s);
					System.out.printf("Je hebt een nieuwe speler geregistreerd met gebruikersnaam %s geboren in %d%n%n", s.getGebruikersnaam(), s.getGeboortejaar());
				}
				else {
					Speler s= sm.geefSpeler(gebruikersnaam, geboortejaar);
					dc.meldAan(s);
					System.out.printf("Je bent aangemeld als %s geboren in %d%n%n", s.getGebruikersnaam(), s.getGeboortejaar());
				}
				finished = true;
			}catch(InputMismatchException e) {
				System.out.println("Verkeerde invoer, geboortejaar moet een getal zijn");
			}catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}finally {
				input.nextLine();
			} 
		}while(!finished);
	} 
}