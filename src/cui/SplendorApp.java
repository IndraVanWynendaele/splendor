package cui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import domein.DomeinController;
import domein.Speler;
import dtos.SpelerDTO;

public class SplendorApp {
	private DomeinController dc;
	private Scanner input = new Scanner(System.in);
	private int keuzeKeuzeMenu;
	private List<SpelerDTO> spelersDTO;
	
	public SplendorApp(DomeinController dc) {
		this.dc = dc;
		spelersDTO = new ArrayList<>();
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
					if(dc.controleerAantalSpelers()) {
						dc.startSpel();
						String uitvoer = "";
						spelersDTO = dc.geefSpelerDTOs();
						for(SpelerDTO sDTO: spelersDTO)
							uitvoer += String.format("%s%n", sDTO.gebruikersnaam());
						System.out.println("\n-- Spel gestart --");
						System.out.printf("Spelers:%n%s%n", uitvoer);
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
				
				Speler sp = new Speler(gebruikersnaam, geboortejaar);
				if(dc.spelerAlAangemeld(sp)) {
					if(dc.meldAan(sp)) {
						System.out.printf("Je bent aangemeld als %s geboren in %d%n%n", sp.getGebruikersnaam(), sp.getGeboortejaar());
					}
					else{
						String antwoord;
						do {
						System.out.print("De speler is nog niet geregistreerd, wil je dit doen?");
						antwoord = input.nextLine().toLowerCase();
						}while(!(antwoord.equals("ja")||antwoord.equals("nee"))); // testen of dit werkt
						if(antwoord.equals("ja")) {
							dc.voegToe(sp);
							dc.meldAan(sp);
							System.out.printf("Je hebt een nieuwe speler geregistreerd met gebruikersnaam %s geboren in %d%n%n", sp.getGebruikersnaam(), sp.getGeboortejaar());	
						}else {
							valideerGegevensInput();
						}
					}
				}else {
					throw new IllegalArgumentException("Deze speler is al aangemeld!\n");
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