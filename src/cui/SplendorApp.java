package cui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import domein.DomeinController;
import domein.Spel;
import domein.Speler;
import persistentie.SpelerMapper;

public class SplendorApp {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	private int keuzeKeuzeMenu;
	private SpelerMapper sm;
	private boolean aantalSpelersInOrde = false;
	private List<Speler> spelers;
	
	public SplendorApp(DomeinController dc) {
		this.dc = dc;
		sm = new SpelerMapper();
	}
	
	public void start() {
		keuzeKeuzeMenu = toonKeuzeMenu();
		while(keuzeKeuzeMenu != 3) {
			switch(keuzeKeuzeMenu) {
				case 1 -> {
					valideerGegevensInput();
					keuzeKeuzeMenu = 0;
				}
				case 2 -> {
					if(controleerAantalSpelers()) {
						dc.startSpel();
						String uitvoer = "";
						for(Speler s: spelers)
							uitvoer += String.format("%s%n", s.getGebruikersnaam());
						System.out.println("\n-- Spel gestart --");
						System.out.printf("Spelers:%n%s%n", uitvoer);
						//System.out.printf("De startspeler is %s%n", dc.startSpeler.getGebruikersnaam());
					}	
				}
				default	-> {
					System.out.println();
					keuzeKeuzeMenu = toonKeuzeMenu();
				}
			}
			if(keuzeKeuzeMenu==2)
				break;			
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
				System.out.println("Keuze moet een nummer zijn!\n");
			}finally {
				input.nextLine();
			}
		}while(keuzeKeuzeMenu < 1 || keuzeKeuzeMenu > 3);
		return keuzeKeuzeMenu;
	}
	
	private void valideerGegevensInput() {
		String gebruikersnaam = "";
		int geboortejaar = 0;
		boolean finished = false;
		
		do {
			
			try {
				System.out.print("Geef je gebruikersnaam in: ");
				gebruikersnaam = input.nextLine();
				
				System.out.print("Geef je geboortejaar in: ");
				geboortejaar = input.nextInt();
				
				if(sm.geefSpeler(gebruikersnaam, geboortejaar) == null) {
					Speler sp = new Speler(gebruikersnaam,geboortejaar);
					sm.voegToe(sp);
					dc.meldAan(sp);
					System.out.printf("Je hebt een nieuwe speler geregistreerd met gebruikersnaam %s geboren in %d%n%n", sp.getGebruikersnaam(), sp.getGeboortejaar());
				}
				else {
					if(!spelerAlAangemeld(gebruikersnaam, geboortejaar)) {
						Speler sp = sm.geefSpeler(gebruikersnaam, geboortejaar);
						dc.meldAan(sp);
						System.out.printf("Je bent aangemeld als %s geboren in %d%n%n", sp.getGebruikersnaam(), sp.getGeboortejaar());	
					}			
					else{
						throw new IllegalArgumentException("Gebruiker is al aangemeld! Kies iemand anders");		
					}
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
	
	private boolean spelerAlAangemeld(String gebruikersnaam, int geboortejaar) {
		spelers = dc.geefSpelers();
	
		for(Speler s : spelers)
			if(s.getGebruikersnaam() == gebruikersnaam)
				if(s.getGeboortejaar() == geboortejaar)
					return true;
		
		return false;
	}

	private boolean controleerAantalSpelers() {
		spelers = dc.geefSpelers();
		
		try{
			if(spelers.size() < 2) {
				throw new IllegalArgumentException("Er moeten minstens 2 spelers aangemeld zijn\n");
			}else if(spelers.size() > 4) {
				spelers.removeAll(spelers);
				throw new IllegalArgumentException("Er mogen maar 4 spelers aangemeld zijn \nDe lijst van spelers is verwijderd, begin helemaal opnieuw! :( \n");
			}
			aantalSpelersInOrde = true;
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		return aantalSpelersInOrde;
	}
}